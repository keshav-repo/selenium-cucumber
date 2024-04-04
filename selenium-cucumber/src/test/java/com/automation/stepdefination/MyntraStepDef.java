package com.automation.stepdefination;

import com.automation.common.DriverUtility;
import com.automation.pages.myntra.MyntraHome;
import com.automation.pages.myntra.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MyntraStepDef {
    private MyntraHome myntraHome;
    private SearchPage searchPage;
    public MyntraStepDef(){
        WebDriver driver = DriverUtility.driver;
        myntraHome = new MyntraHome(driver);
        searchPage = new SearchPage(driver);
    }
    @Given("I am at the myntra home page")
    public void navigateToHomePage(){
        myntraHome.navigate();
    }

    @When("I entered {string} in search text field")
    public void iEnteredText(String string) {
        myntraHome.enterSearcText(string);
    }

    @Then("Clicked to first search product")
    public void clickFirstProduct(){
        searchPage.clickFirstProduct();
    }
}
