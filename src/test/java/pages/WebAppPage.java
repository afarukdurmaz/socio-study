package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAppPage extends BasePage<WebAppPage> {
    public WebAppPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

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
                System.out.println("tiklandi.");
            } else {
                System.out.println("Web app Enable is true.");
            }
        } catch (Exception ex) {

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
