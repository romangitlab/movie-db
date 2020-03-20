package mobile.lib.ui.mobile_web.pages.login;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPage extends MainPage {

    protected static String
            LOGIN_INPUT = "id:username",
            PASSWORD_INPUT = "id:password",
            SUBMIT_BUTTON = "css:input[value='Login']";

    public AuthorizationPage(RemoteWebDriver driver) {
        super(driver);
        driver.get(baseUrl + "login");
        driver.get(baseUrl + "login");
    }

    public void login() {
        waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find path to 'login' element", 5);
        waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find path to 'password' element", 5);
    }
}
