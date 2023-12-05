package com.automation.helper;

import com.automation.common.DriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitializeWebDrive {
    public void setUpDriver() {
        try {
            ChromeOptions co = new ChromeOptions();
            co.setBinary("src/main/resources/driver/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
            DriverUtility.driver =  new ChromeDriver(co);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Before()
    public void before() throws Exception {
        setUpDriver();
    }

    @After
    public void after() throws Exception{
        tearDownDriver();
    }

    public void tearDownDriver() throws Exception {
        try {
            if (DriverUtility.driver != null) {
                DriverUtility.driver.quit();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
