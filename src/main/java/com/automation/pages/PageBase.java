package com.automation.pages;

import com.google.common.base.Function;
import io.cucumber.core.logging.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

public abstract class PageBase {
    private static Logger log = LogManager.getLogger(PageBase.class);
    private WebDriver driver;

    public PageBase(WebDriver driver) {
        if(driver == null)
            throw new IllegalArgumentException("Driver object is null");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver = driver;
    }

    private By getFindByAnno(FindBy anno){
        log.info(  anno );
        switch (anno.how()) {
            case CLASS_NAME:
                return new By.ByClassName(anno.using());
            case CSS:
                return new By.ByCssSelector(anno.using());
            case ID:
                return new By.ById(anno.using());
            case LINK_TEXT:
                return new By.ByLinkText(anno.using());
            case NAME:
                return new By.ByName(anno.using());
            case PARTIAL_LINK_TEXT:
                return new By.ByPartialLinkText(anno.using());
            case XPATH:
                return new By.ByXPath(anno.using());
            default :
                throw new IllegalArgumentException("Locator not Found : " + anno.how() + " : " + anno.using());
        }
    }

    protected By getElemetLocator(Object obj,String element) throws SecurityException,NoSuchFieldException {
        Class childClass = obj.getClass();
        By locator = null;
        try {
            locator = getFindByAnno(childClass.
                    getDeclaredField(element).
                    getAnnotation(FindBy.class));
        } catch (SecurityException | NoSuchFieldException e) {
            log.equals(e);
            throw e;
        }
        log.debug(locator);
        return locator;
    }

    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotInteractableException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.until(elementLocated(element));
    }

    private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                 log.debug("Waiting for Element : " + element);
                return element.isDisplayed();
            }
        };
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
}
