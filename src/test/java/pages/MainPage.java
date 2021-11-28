package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.BasePageUtil;

import java.util.List;

public class MainPage extends BasePage<MainPage> {
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);


    private final By DASBOARD_MAIN_TEXT = By.xpath("//h3[@data-testid='titleDashead']");
    private final By EVENT_APP_BUTTON = By.id("event-app-nav");
    private final By MY_EVENTS_BUTTON = By.xpath("//a[@title='My Events']");
    private final By EVENTS_LIST = By.xpath("//div[@data-testid='colEvent']//h3");


    public MainPage validateMyEventsPageOpen() {
        try {
            String dasheadText = findElementBy(DASBOARD_MAIN_TEXT).getText();
            if (dasheadText.equals("My Events")) {
                logger.info("My Events Page has already opened.");
            } else {
                clickElement(EVENT_APP_BUTTON);
                clickElement(MY_EVENTS_BUTTON);
                logger.info("My Events Page opened.");
            }
        } catch (Exception ex) {
            Assert.assertTrue(false, "'My Events' page didn't open!");
        }
        return this;
    }

    public MainPage chooseEvent(String eventName) {
        try {
            List<WebElement> eventList = findElementsBy(EVENTS_LIST);
            boolean found = false;
            for (WebElement el :
                    eventList) {
                if (el.getText().equals(eventName)) {
                    el.click();
                    found = true;
                    logger.info(eventName + " is found.");
                    break;
                }
            }
            Assert.assertTrue(found, eventName + " not found!");
        } catch (Exception ex) {
            Assert.assertTrue(false, eventName + " not found!");
        }
        return this;
    }

}
