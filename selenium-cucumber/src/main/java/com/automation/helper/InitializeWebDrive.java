package com.automation.helper;

import com.automation.common.DriverUtility;
import com.automation.configuration.browser.BrowserType;
import com.automation.configuration.browser.ChromeBrowser;
import com.automation.configuration.browser.FirefoxBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static com.automation.configuration.browser.BrowserType.Chrome;
import static com.automation.configuration.browser.BrowserType.Firefox;

public class InitializeWebDrive {
    private static Logger log = LogManager.getLogger(InitializeWebDrive.class);

    public void setUpDriver(BrowserType browserType) {
        log.info("browser type {}", browserType);
        if(!Objects.isNull(DriverUtility.driver))
            return;
        switch (browserType) {
            case Chrome:
                DriverUtility.driver = ChromeBrowser.getChromeDriver();
                break;
            case Firefox:
                DriverUtility.driver = FirefoxBrowser.getDriver();
                break;
            default:
                DriverUtility.driver = ChromeBrowser.getChromeDriver();
        }
    }

    @Before(order=1, value = "@chrome")
    public void beforeChrome() throws Exception {
        setUpDriver(Chrome);
        log.info(Chrome);
    }
    @After(order=1, value = "@chrome")
    public void afterChrome() throws Exception{
        log.info("tear down called");
        tearDownDriver();
    }

    @Before(order=2, value = "@firefox")
    public void beforeFirefox() throws Exception {
        setUpDriver(Firefox);
        log.info(Chrome);
    }
    @After(order=2, value = "@firefox")
    public void afterFirefox(Scenario scenario) throws Exception{
        log.info("tear down called");
        log.info("{} scenario status is : {}", scenario.getName(), scenario.getStatus());
        tearDownDriver();
    }

    public void tearDownDriver() throws Exception {
        try {
            if (DriverUtility.driver != null) {
                // giving some sleep before shutting the browser
                try{
                    Thread.sleep(3000);
                }catch (Exception e){

                }
                DriverUtility.driver.quit();
            }
        } catch (Exception e) {
            log.error("error tear down browser");
            throw e;
        }
    }
}
