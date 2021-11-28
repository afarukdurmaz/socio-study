package util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePageUtil<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);


    public BasePageUtil(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Find an element
     * @param by target element locator
     */
    public WebElement findElementBy(By by) {
        try {
            Thread.sleep(3000);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception ex) {
            logger.error("Element is not found! Exception: " + ex);
            Assert.assertTrue(false, "Element is not found!");
            return null;
        }
    }
    /**
     * Find List of element
     * @param by target element locator
     */
    public List<WebElement> findElementsBy(By by) {
        try {
            Thread.sleep(3000);
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (Exception ex) {
            logger.error("Element is not found! Exception: " + ex);
            Assert.assertTrue(false, "Element is not found!");
            return null;
        }
    }
    /**
     * Wait Until Dissappear an element
     * @param by target element locator
     */
    public void waitUntilDisappearElement(By by) {
        try {
            wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(by)));
        } catch (Exception ex) {
            logger.info("Waiting element not found.");
        }
    }

    /**
     * Clicks element
     * @param by target element locator
     */
    public void clickElement(By by) {
        findElementBy(by).click();
    }

    /**
     * SendKeys to element
     * @param by target element locator
     * @param text given text
     */
    public void sendKeys(By by, String text) {
        findElementBy(by).sendKeys(text);
    }

    /**
     * Move Mouse to element
     * @param by target element locator
     */
    public void moveMouse(By by) {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(by);
        actions.moveToElement(menuOption).perform();
    }

}
