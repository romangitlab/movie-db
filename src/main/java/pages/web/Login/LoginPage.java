package pages.web.Login;

import helpers.WebHelper;
import org.openqa.selenium.By;

public class LoginPage extends WebHelper {

    public LoginPage(){
        openLoginPage();
    }

    public String username = properties.getProperty("username");
    public String password = properties.getProperty("password");

    public LoginPage openLoginPage(){
        webDriver.get(getProductWebAddress() + "login");
        webDriver.get(getProductWebAddress() + "login");

        return this;
    }

    public void login(){
        type(By.id("username"), username);
        type(By.id("password"), password);
        clickAtElement(By.cssSelector("input[value='Login']"));
    }
}
