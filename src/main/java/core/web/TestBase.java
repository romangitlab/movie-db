package core.web;

import core.Logging;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase extends Logging {

    WebManager manager = new WebManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeTest(alwaysRun = true)
    public void baseTest() {
        manager.init();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        manager.stop();
    }
}