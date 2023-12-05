package com.automation.configuration.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class FirefoxBrowser {
    private static Logger log = LogManager.getLogger(FirefoxBrowser.class);

    public static WebDriver getDriver() {
        try{
            System.setProperty("webdriver.gecko.driver","src/main/resources/driver/geckodriver");
            return new FirefoxDriver();
        }catch (Exception e){
            log.error("error initiating firefox browser");
            throw new RuntimeException(e);
        }
    }
}
