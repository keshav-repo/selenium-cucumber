package com.automation.stepdefination;

import com.automation.common.DriverUtility;
import com.automation.pages.MyntraHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class MyntraStepDef {
    private MyntraHome myntraHome;
    public MyntraStepDef(){
        myntraHome = new MyntraHome(DriverUtility.driver);
    }
    @Given("I am at the myntra home page")
    public void navigateToHomePage(){
        myntraHome.navigate();
    }

    @When("I entered {string} in search text field")
    public void iEnteredText(String string) {

        myntraHome.enterSearcText(string);
    }

    // Lehenga Choli

}
