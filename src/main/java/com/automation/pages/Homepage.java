package com.automation.pages;

import com.automation.common.DriverUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class Homepage extends PageBase{
    private WebDriver driver;
    private static Logger log = LogManager.getLogger(Homepage.class);

    @FindBy(how= How.XPATH,using="//img[@alt='Electronics']")
    private WebElement electronics;

    @FindBy(how = How.XPATH, using = "//span[@role='button']")
    private WebElement closePopUpBtn;

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement searchInputTxt;

    @FindBy(how = How.XPATH, using = "//div[@data-id!='' and @data-id]")
    private List<WebElement> searchItems;

    public Homepage(WebDriver driver) {
        super(DriverUtility.driver);
        this.driver = DriverUtility.driver;
    }
    public void navigate(){
        try{
            driver.get("https://www.flipkart.com/");
            log.info("successfully navigated to page");
        }catch (Exception e){
            log.info("error while navigating: {}", e.getMessage());
        }
    }
    public void closePopup(){
        this.closePopUpBtn.click();
    }
    public void clickSearchBtn(){
        searchInputTxt.click();
    }
    public void searchItem(String query){
        // send query that needs to be search
       searchInputTxt.sendKeys(query);
       // enter to take to search page
       searchInputTxt.sendKeys(Keys.ENTER);
    }

    public int itemCount(){
        return searchItems.size();
    }
}
