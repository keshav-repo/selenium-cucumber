package com.automation.configuration.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
    private static Logger log = LogManager.getLogger(ChromeBrowser.class);

    public static WebDriver getChromeDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/usr/bin/chromium");
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            return new ChromeDriver(options);
        } catch (Exception e) {
            log.error("error initiating chrome browser", e);
            throw new RuntimeException(e);
        }
    }
}
