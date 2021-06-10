package core.web;

import core.Logging;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase extends Logging {

    WebManager manager = new WebManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUp(Method method) {
        manager.init();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        manager.stop();
    }
}