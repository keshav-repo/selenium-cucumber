package com.automation.pages;

import com.automation.common.DriverUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyntraHome extends PageBase{
    private WebDriver driver;
    private Logger log = LogManager.getLogger(MyntraHome.class);

    @FindBy(how = How.XPATH, using = "//input[@class='desktop-searchBar']")
    private WebElement searchInputElement;

    public MyntraHome(WebDriver driver) {
        super(driver);
        this.driver = DriverUtility.driver;
    }

    public void navigate(){
        try{
            driver.get("https://www.myntra.com/");
            System.out.println("successfully navigated to page");
            log.info("successfully navigated to page");
        }catch (Exception e){
            log.info("error while navigating: {}", e.getMessage());
        }
    }

    public void enterSearcText(String searchQuery){
        this.searchInputElement.sendKeys(searchQuery);
        try{
            Thread.sleep(1000*3);
        }catch (Exception e){

        }
        this.searchInputElement.sendKeys(Keys.ENTER);
    }
}
