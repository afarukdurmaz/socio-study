package test;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.WallPage;
import util.BrowserStackTestNGTest;
import util.Configuration;
import util.LocalSetUp;

public class SocioStudyCase extends BrowserStackTestNGTest {

    public static final String EVENT_NAME = "Test Automation Assessment Event";
    Configuration configuration = new Configuration();

    @Test
    public void studyCase() {
        String postName = new MainPage(driver, wait).callLoginPage()
                .login(configuration.getSocioMail(), configuration.getSocioPass())
                .validateMyEventsPageOpen()
                .chooseEvent(EVENT_NAME)
                .callWebAppPage()
                .validateEnableWebApp()
                .copyShareableLinkAndOpenNewWindow()
                .loginAlternate(configuration.getSocioMail(), configuration.getSocioPass())
                .callWallPage()
                .clickWhatIsOnYourMind()
                .writeRandomTextToInput();

        new WallPage(driver, wait).uploadImage()
                .closeCurrentWindow()
                .callEditEventPage()
                .openEditWall()
                .validatePostIsListed(postName);
    }
}
