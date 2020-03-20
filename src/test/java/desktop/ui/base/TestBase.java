package desktop.ui.base;

import desktop.ui.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {

    ApplicationManager manager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeTest(alwaysRun = true)
    public void baseTest() {
        manager.init();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        manager.stop();
    }
}