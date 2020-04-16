package com.ha.qa.web.uiframework.events;

import com.ha.qa.web.uiframework.common.DriverFactory;
import com.ha.qa.web.uiframework.configurations.Configs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UIActions {

    private static final Logger logger = LogManager.getLogger(UIActions.class);
    private static final long FLUENT_TIME_OUT_DURATION = Long.parseLong(Configs.OR.getProperty("FluentWaitInSeconds"));
    private static final long POLLING_SLEEP_DURATION = Long.parseLong(Configs.OR.getProperty("SleepTimeBetweenPollingInMillis"));

    private static WebDriver driver = DriverFactory.getDriver();
    private static Actions actions = new Actions(driver);

    public static void navigateTo(String url)throws UIAException {
        try{
            driver.get(url);
            onSuccess("Navigate to url: \""+url+"\"",false);
        }
        catch(Exception e) {
            //onFailure("Failed to open: "+url,true,e);
        }

    }

    public static void click(WebElement element, String elementName, long extraWaitInSeconds, int nOfPgDwns4Err)throws UIAException{
        try {
            WebDriverWait wait = new WebDriverWait(driver
                    , FLUENT_TIME_OUT_DURATION+extraWaitInSeconds, POLLING_SLEEP_DURATION);
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            el.click();
            onSuccess("Click on : "+elementName,false);
        }
        catch(TimeoutException te){
            for (int i=0; i<nOfPgDwns4Err;i++){
                actions.sendKeys(Keys.PAGE_DOWN);
                actions.perform();
            }
            onFailure("Element: "+elementName+" could not be found for peforming the click action",true,te);
        }
        catch(Exception e){
            actions.moveToElement(element);
            actions.perform();
            //onFailure("Failed to click on "+elementName,true,e);
        }
    }

    public static void sendKeys(WebElement element, String input,boolean tab,String elementName, long extraWaitInSeconds, int nOfPgDwns4Err) throws UIAException{
        try{
            WebDriverWait wait = new WebDriverWait(driver, FLUENT_TIME_OUT_DURATION+extraWaitInSeconds
            ,POLLING_SLEEP_DURATION);
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            el.sendKeys(input);
            if (tab) {
                Thread.sleep(1000);
                el.sendKeys(Keys.TAB);
            }
            onSuccess("Enter  \""+input+"\" as "+elementName,false);
        }
        catch(TimeoutException te){
            for (int i=0; i<nOfPgDwns4Err;i++){
                actions.sendKeys(Keys.PAGE_DOWN);
                actions.perform();
            }
            //onFailure("Element: "+elementName+" could not be found for keying in the value",true,te);
        }
        catch (Exception e) {
            actions.moveToElement(element);
            actions.perform();
           // onFailure("Failed to key in value for "+ elementName,true,e);
        }

    }


    private static void onSuccess(String message, boolean captureScreen){
        logger.info(message);

    }

    private static void onFailure(String message, boolean captureScreen, Exception e) throws UIAException{
        logger.error(message + "- More Details: "+ e.getMessage()+ " - StackTrace: " +e.getStackTrace());
        throw new UIAException(message);// +" \n More Details: "+e.getMessage());
    }

}
