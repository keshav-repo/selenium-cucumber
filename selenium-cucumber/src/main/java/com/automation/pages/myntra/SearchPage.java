package com.automation.pages.myntra;

import com.automation.common.DriverUtility;
import com.automation.pages.PageBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Iterator;
import java.util.Set;

public class SearchPage extends PageBase {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(MyntraHome.class);

    @FindBy(how = How.XPATH, using = "(//li[@class='product-base'])[1]")
    private WebElement firstSearchProduct;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = DriverUtility.driver;
    }

    public void clickFirstProduct(){
        firstSearchProduct.click();

        Set<String> hanles =  this.driver.getWindowHandles();

        Iterator<String> windowsIterator = hanles.iterator();
        String parentWindow = windowsIterator.next();
        String productWindow = windowsIterator.next();

        this.driver.switchTo().window(productWindow);

        try{
            Thread.sleep(1000*3);
        }catch (Exception e){

        }
        this.driver.close();
        //this.driver.quit();

    }

}
