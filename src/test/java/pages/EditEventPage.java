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

public class EditEventPage extends BasePage<EditEventPage> {

    public EditEventPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final Logger logger = LogManager.getLogger(BasePageUtil.class);


    private final By WALL_BUTTON = By.id("Wall");
    private final By EDIT_WALL_BUTTON = By.xpath("//button[@data-testid='buttonEditFeature']");


    public EditEventPage openEditWall() {
        moveMouse(WALL_BUTTON);
        //clickElement(WALL_BUTTON);
        clickElement(EDIT_WALL_BUTTON);
        logger.info("Edit Wall Opened.");
        return this;
    }

    public EditEventPage validatePostIsListed(String postName) {
        List<WebElement> posts = findElementsBy(By.xpath("//*[contains(@class,'post-caption')]/span"));
        boolean validate = false;
        for (WebElement element : posts) {
            if(element.getText().equals(postName)) {
                validate = true;
                logger.info(postName + " has found.");
                break;
            }
        }
        Assert.assertTrue(validate, postName + " not found!");
        return this;
    }
}
