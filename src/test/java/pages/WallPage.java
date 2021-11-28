package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePageUtil;

import java.util.ArrayList;


public class WallPage extends BasePage<WallPage> {

    public WallPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);

    public final String imagePath = System.getProperty("user.dir") + "/images.png";

    private final By WHAT_IS_ON_YOUR_MIND_BUTTON = By.xpath("//button[@data-testid='new-post-send']");
    private final By WHAT_IS_ON_YOUR_MIND_INPUT_TEXT = By
            .xpath("//textarea[@placeholder='What’s on your mind, Test?']");
    private final By UPLOAD_IMAGE_BUTTON = By.xpath("//div[@data-testid = 'upload_image']");
    private final By UPLOAD_IMAGE_INPUT = By.xpath("//input[@id='fsp-fileUpload']");
    private final By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    private final By UPLOAD_BUTTON = By.xpath("//*[@title='Upload']");
    private final By FORM = By.xpath("//div[@class='fsp-modal']");
    private final By SEND_BUTTON = By.xpath("(//*[contains(text(),'Send')])[2]");


    public WallPage clickWhatIsOnYourMind() {
        clickElement(WHAT_IS_ON_YOUR_MIND_BUTTON);
        return this;
    }

    public String writeRandomTextToInput() {
        String text = RandomStringUtils.randomAlphabetic(10);
        sendKeys(WHAT_IS_ON_YOUR_MIND_INPUT_TEXT, text);
        return text;
    }

    public WallPage uploadImage() {
        clickElement(UPLOAD_IMAGE_BUTTON);
        logger.info("path = " + imagePath);
        driver.findElement(UPLOAD_IMAGE_INPUT).sendKeys(imagePath);
        clickElement(SAVE_BUTTON);
        clickElement(UPLOAD_BUTTON);
        logger.info("Upload completed.");
        waitUntilDisappearElement(FORM);
        clickElement(SEND_BUTTON);
        logger.info("Successfully sent.");
        return this;
    }

    public MainPage closeCurrentWindow() {
        try {
            Thread.sleep(4000);
            ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(windows.get(0));
        } catch (Exception ex) {
            logger.info("Window Changes failed! Exception: " + ex);
        }
        return new MainPage(driver, wait);
    }
}
