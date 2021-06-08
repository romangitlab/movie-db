package core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebManager {

    public static Boolean isMob;
    private String browser;
    private static WebDriver wd;
    private static Properties properties;
    ChromeOptions options;

    public WebManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() {
        try {
            properties.load(new FileInputStream("src/main/resources/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isMW()) {
            wd = new ChromeDriver(this.getMWChromeOptions());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en");
            options.addArguments("--headless");
            wd = new ChromeDriver(options);
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        } else {
            wd = new FirefoxDriver();
        }

        if(!isMW()){
            wd.manage().window().maximize();
        }

        wd.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    private static String getPlatform() {
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();

        return context.getCurrentXmlTest().getParameter("platform");
    }

    public static final boolean isMW() {
        if (isMob == null) {
            try {
                isMob = getPlatform().equals("mobile");
            } catch (Exception e) {
                return false;
            }
        }

        return isMob;
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

    private ChromeOptions getMWChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=360,640");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        return chromeOptions;
    }
}
