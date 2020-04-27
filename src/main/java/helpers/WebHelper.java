package helpers;

import core.web.WebManager;
import org.openqa.selenium.*;

import java.util.Properties;

public class WebHelper {

    protected Properties properties = WebManager.getProperties();
    protected WebDriver webDriver = WebManager.getActualWebDriver();

    public String getProductWebAddress(){
        return properties.getProperty("baseUrl");
    }

    protected void clickAtElement(By locator) {
        webDriver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        clickAtElement(locator);
        if (text != null) {
            String existingText = webDriver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                webDriver.findElement(locator).clear();
                webDriver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void type(By locator, String text, Keys key) {
        clickAtElement(locator);
        if (text != null) {
            String existingText = webDriver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                webDriver.findElement(locator).clear();
                webDriver.findElement(locator).sendKeys(text);
                webDriver.findElement(locator).sendKeys(key);
            }
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            webDriver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void scrollWebPageTo(WebElement element) {

            String location = element.getLocation().toString();
            JavascriptExecutor JSExecutor = (JavascriptExecutor)webDriver;
            JSExecutor.executeScript("window.scrollBy" + location + "");
    }
}
