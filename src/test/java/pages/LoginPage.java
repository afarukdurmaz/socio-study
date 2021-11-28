package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePageUtil;

public class LoginPage extends BasePage<LoginPage> {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);


    private final By MAIL_INPUT = By.id("email");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private final By MAIL_INPUT_ALTERNATE = By.id("email");
    private final By CONTINUE_BUTTON = By.id("continue-button");
    private final By PASSWORD_INPUT_ALTERNATE = By.id("password-input");
    private final By LOGIN_BUTTON_ALTERNATE = By.id("login-button");

    public MainPage login(String mail, String pass) {
        sendKeys(MAIL_INPUT, mail);
        sendKeys(PASSWORD_INPUT, pass);
        clickElement(LOGIN_BUTTON);
        logger.info("Login successful.");
        return new MainPage(driver, wait);
    }

    public MainPage loginAlternate(String mail, String pass) {
        sendKeys(MAIL_INPUT_ALTERNATE, mail);
        clickElement(CONTINUE_BUTTON);
        sendKeys(PASSWORD_INPUT_ALTERNATE, pass);
        clickElement(LOGIN_BUTTON_ALTERNATE);
        logger.info("Login successful.");
        return new MainPage(driver,wait);
    }
}
