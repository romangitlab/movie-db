package mobile.lib;

import junit.framework.TestCase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTest extends TestCase {

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
    }

    @Override
    protected void tearDown() throws Exception {
        //driver.quit();
        super.tearDown();
    }
}
