package desktop.ui.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private String browser;
    private static WebDriver wd;
    private static Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() {
        try {
            properties.load(new FileInputStream("src/test/resources/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        } else {
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    public void stop() {
        wd.quit();
    }

    public static WebDriver getActualWebDriver(){
       return wd;
    }

    public static Properties getProperties(){
        return properties;
    }

}
