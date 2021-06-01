package pages.web.Login;

import helpers.WebHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends WebHelper {
    Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public String username = properties.getProperty("username");
    public String password = properties.getProperty("password");

    public LoginPage(){
        openLoginPage();
    }

    public LoginPage openLoginPage(){
        logger.info("Run: openLoginPage()");

        webDriver.get(getProductWebAddress() + "login");
        webDriver.get(getProductWebAddress() + "login");

        return this;
    }

    public void login(){
        logger.info("Run: login()");

        type(By.id("username"), username);
        type(By.id("password"), password);
        clickAtElement(By.id("login_button"));
    }
}
