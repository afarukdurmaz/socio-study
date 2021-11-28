package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.BasePageUtil;

public class WebAppPage extends BasePage<WebAppPage> {
    public WebAppPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);


    private final By WEB_APP_SETTINGS_BUTTONS = By.xpath("//div[@class='bootstrap-switch-container']/..");
    private final By ENABLE_WEB_APP_BUTTONS = By.xpath("//span[@class='bootstrap-switch-label']");
    private final By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    private final By URL = By.xpath("//input[@class='form-control']");

    public WebAppPage validateEnableWebApp() {
        try {
            String webAppStatus =
                    findElementsBy(WEB_APP_SETTINGS_BUTTONS).get(0)
                            .getAttribute("class");
            if (!webAppStatus.contains("bootstrap-switch-on")) {
                findElementsBy(ENABLE_WEB_APP_BUTTONS).get(0).click();
                clickElement(SAVE_BUTTON);
                logger.info("Clicked Web App Enable button");
            } else {
                logger.info("Web app already enable.");
            }
        } catch (Exception ex) {
            Assert.assertTrue(false, "Enable Web App has failed!");
        }
        return this;
    }

    public LoginPage copyShareableLinkAndOpenNewWindow() {
        String copiedUrl = findElementBy(URL).getAttribute("value");
        WebDriver newDriver = driver.switchTo().newWindow(WindowType.WINDOW);
        newDriver.get(copiedUrl);
        newDriver.manage().window().maximize();
        return new LoginPage(driver, wait);
    }

}
