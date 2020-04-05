package core.application;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Platform {

    private static Platform instance;
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";


    private Platform() {}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        if (this.isAndroid()) {
            URL URL = new URL(APPIUM_URL);
            return new AndroidDriver(URL, this.getAnroidDesiredCapabilities());
        } else if (this.isIOS()) {
            URL URL = new URL(APPIUM_URL);
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("No driver selected: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    private boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");

        return capabilities;
    }

    private DesiredCapabilities getAnroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("deviceName","Galaxy Nexus API 24");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("automationName","UiAutomator1");
        capabilities.setCapability("appPackage","com.csovan.themoviedb");
        capabilities.setCapability("appActivity","com.csovan.themoviedb.ui.activity.SplashActivity");
        capabilities.setCapability("noReset","false");
        //capabilities.setCapability("app","/Users/vitalijkotov/JavaAppiumMaven/apks/org.wikipedia.apk");
        return capabilities;
    }
}
