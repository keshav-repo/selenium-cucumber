package com.automation.configuration.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FirefoxBrowser {
    private static Logger log = LogManager.getLogger(FirefoxBrowser.class);

    public static WebDriver getDriver() {
        try{
            String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
            String headlessEnv = System.getenv("HEADLESS");
            boolean useHeadless = "true".equalsIgnoreCase(headlessEnv) || (remoteUrl != null && !remoteUrl.isEmpty());

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage", "--width=1920", "--height=1080");
            if (useHeadless){
                // add headless flag for Firefox
                options.addArguments("-headless");
            }

            if (remoteUrl != null && !remoteUrl.isEmpty()){
                log.info("Using remote WebDriver at {}", remoteUrl);
                return new RemoteWebDriver(new URL(remoteUrl), options);
            }

            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver driver =  new FirefoxDriver(options);
            driver.manage().window().maximize();
            return driver;
        }catch (Exception e){
            log.error("error initiating firefox browser", e);
            throw new RuntimeException(e);
        }
    }
}
