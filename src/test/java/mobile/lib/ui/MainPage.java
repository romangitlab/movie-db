package mobile.lib.ui;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import mobile.lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class MainPage {

    protected final static String baseUrl = getApiProperties().getProperty("baseUrl");
    protected final static String login = getApiProperties().getProperty("username");
    protected final static String password = getApiProperties().getProperty("password");

    private static Properties properties;
    protected RemoteWebDriver driver;

    public MainPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public static Properties getApiProperties(){

        if (properties == null) {
            properties = new Properties();

            try {
                properties.load(new FileInputStream("src/test/resources/settings.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementPresent(String locator, String error_message) {
        return waitForElementPresent(locator, error_message, 5);
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);

        if(Platform.getInstance().isAndroid()) {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        } else {
            element.sendKeys(Keys.ENTER);
        }

        return element;
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void scrollWebPageTo(WebElement element)
    {
        if (Platform.getInstance().isMW()) {
            String location = element.getLocation().toString();
            JavascriptExecutor JSExecutor = driver;
            JSExecutor.executeScript("window.scrollBy" + location + "");
        } else {
            System.out.println("Method scrollWebPageTo do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get typ of locator. Locator: " + locator_with_type);
        }
    }
}
