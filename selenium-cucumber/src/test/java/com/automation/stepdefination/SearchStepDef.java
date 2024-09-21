package com.automation.stepdefination;

import com.automation.common.DriverUtility;
import com.automation.pages.flipkart.Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SearchStepDef {
    private Homepage homepage;
    private Logger log = LogManager.getLogger(SearchStepDef.class);

    public SearchStepDef() {
        homepage = new Homepage(DriverUtility.driver);
    }

    @Given("I am at the home page")
    public void i_am_at_the_home_page() throws Exception{
        homepage.navigate();
        try{
            homepage.closePopup();
        }catch (Exception e) {
            log.warn("pop up not coming or not closing");
        }
    }

    @When("I click on the {string} search filter")
    public void i_click_on_the_search_filter(String string) {
        homepage.clickSearchBtn();
    }

    @Then("I should be at the {string} search page with {string} items")
    public void i_should_be_at_the_search_page_with(String query, String searchItemCount) {
        homepage.searchItem(query);
        int expectedItemCount = Integer.parseInt(searchItemCount);
        int actualItemCount =  homepage.itemCount();
        log.info("actualItemCount is "+actualItemCount);
        Assert.assertEquals(actualItemCount,expectedItemCount);
    }

    @Then("The title should be {string} search page")
    public void the_title_should_be_search_page(String expectedTitle) {
        String actualTitle = homepage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
