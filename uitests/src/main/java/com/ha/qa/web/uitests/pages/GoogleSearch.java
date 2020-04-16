package com.ha.qa.web.uitests.pages;

import com.ha.qa.web.uiframework.common.DriverFactory;
import com.ha.qa.web.uiframework.configurations.Configs;
import com.ha.qa.web.uiframework.data.DataValues;
import com.ha.qa.web.uiframework.events.UIAException;
import com.ha.qa.web.uiframework.events.UIActions;
import com.ha.qa.web.uitests.common.ControlLocators;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {

    WebDriver driver;

    @FindBy(xpath= ControlLocators.SEARCH_FIELD)
    WebElement inputKey;

    public GoogleSearch(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

//    public void enterSearchKey() throws Exception{
//        UIActions.sendKeys(inputKey, DataValues.SEARCH_KEY, false, "Enter search Key", 0,0);
//    }

    @Before
    public void setUp() throws Exception{
        UIActions.navigateTo(Configs.OR.getProperty("URL"));
    }

    @Given("^homepage is displayed$")
        public void homepageIsDisplayed() throws Exception{
            System.out.println("Home page is displayed");
        }

        @When("^Search with the key word$")
        public void searchWithTheKeyWord() throws UIAException {
            UIActions.sendKeys(inputKey, DataValues.SEARCH_KEY, false, "Enter search Key", 0,0);
        }

        @Then("^Search suggestion are displayed$")
        public void searchSuggestionAreDisplayed() {
            System.out.println("Search Suggestions are displayed");
        }

        @After
        public void cleanUp(){
            DriverFactory.quitDriver();
        }
}
