package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePageUtil;

public abstract class BasePage<T> extends BasePageUtil<T> {
    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By LOGIN_BUTTON = By.xpath("//a[@href='login']");
    private final By WALL_PAGE_BUTTON = By.xpath("(//div[@data-testid='listItem'])[4]");
    private final By WEB_APP_BUTTON = By.linkText("Web App");
    private final By EDIT_EVENT_BUTTON = By.xpath("//*[contains(text(),'Edit')]");


    public LoginPage callLoginPage() {
        clickElement(LOGIN_BUTTON);
        return new LoginPage(driver, wait);
    }

    public WallPage callWallPage() {
        clickElement(WALL_PAGE_BUTTON);
        return new WallPage(driver, wait);
    }

    public WebAppPage callWebAppPage() {
        clickElement(WEB_APP_BUTTON);
        return new WebAppPage(driver, wait);
    }

    public EditEventPage callEditEventPage() {
        clickElement(EDIT_EVENT_BUTTON);
        return new EditEventPage(driver, wait);
    }

}
