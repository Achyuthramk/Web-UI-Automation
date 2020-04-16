package com.qa.web.uiframework.common;

import com.qa.web.uiframework.configurations.Configs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            if(Configs.OR.getProperty("BrowserName").equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver",Configs.OR.getProperty("ChromeDriver"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("start-fullscreen");
                driver = new ChromeDriver(chromeOptions);
                logger.info("ChromeDriver initiated.");
            }
            else{
                driver = new FirefoxDriver();
                logger.info("FirefoxDriver initiated");
            }
            driver.manage().timeouts().implicitlyWait(Long.parseLong(Configs.OR.getProperty("ImplcitWaitInSeconds"))
                    , TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(Long.parseLong(Configs.OR.getProperty("PageLoadTimeOutInSeconds"))
                    , TimeUnit.SECONDS);
            return driver;
        }
        else{
            return driver;
        }
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
            logger.info("WebDriver Quit Completed.");
        }
    }

}
