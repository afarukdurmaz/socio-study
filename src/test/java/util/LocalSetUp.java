package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class LocalSetUp {

    protected WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl = "https://staging.platform.socio.events";


    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(baseUrl);

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
