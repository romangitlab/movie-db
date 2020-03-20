package desktop.ui.base;

import desktop.ui.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class HelperBase {

    protected Properties properties = ApplicationManager.getProperties();
    protected WebDriver webDriver = ApplicationManager.getActualWebDriver();

    public String getProductWebAddress(){
        return properties.getProperty("baseUrl");
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    protected void click(By locator) {
        webDriver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = webDriver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                webDriver.findElement(locator).clear();
                webDriver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void type(By locator, String text, Keys key) {
        click(locator);
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
}
