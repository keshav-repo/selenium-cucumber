package com.automation.pages.myntra;

import com.automation.common.DriverUtility;
import com.automation.pages.PageBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Product extends PageBase {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(MyntraHome.class);

    public Product(WebDriver driver) {
        super(driver);
        this.driver = DriverUtility.driver;
    }



}
