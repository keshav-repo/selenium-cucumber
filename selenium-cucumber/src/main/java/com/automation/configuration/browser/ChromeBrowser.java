package com.automation.configuration.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
	private static Logger log = LogManager.getLogger(ChromeBrowser.class);

	public static WebDriver getChromeDriver() {
		try {
			ChromeOptions co = new ChromeOptions();
			co.setBinary("src/main/resources/driver/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
			return new ChromeDriver(co);
		}catch (Exception e){
			log.error("error initiating chrome browser");
			throw new RuntimeException(e);
		}
	}
}
