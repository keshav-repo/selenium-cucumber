package com.automation.configuration.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeBrowser {
    private static Logger log = LogManager.getLogger(ChromeBrowser.class);

    public static WebDriver getChromeDriver() {
        try {
            String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
            String headlessEnv = System.getenv("HEADLESS");
            boolean useHeadless = "true".equalsIgnoreCase(headlessEnv) || (remoteUrl != null && !remoteUrl.isEmpty());

            ChromeOptions co = new ChromeOptions();
            // Common options for CI
            co.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
            if (useHeadless) {
                // Use new headless mode when available
                co.addArguments("--headless=new");
            }

            if (remoteUrl != null && !remoteUrl.isEmpty()) {
                log.info("Using remote WebDriver at {}", remoteUrl);
                return new RemoteWebDriver(new URL(remoteUrl), co);
            } else {
                // Use WebDriverManager to download correct chromedriver for the environment
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(co);
            }
        } catch (Exception e) {
            log.error("error initiating chrome browser", e);
            throw new RuntimeException(e);
        }
    }
}
