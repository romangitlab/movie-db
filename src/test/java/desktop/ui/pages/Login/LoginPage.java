package desktop.ui.pages.Login;

import desktop.ui.base.HelperBase;
import org.openqa.selenium.By;

public class LoginPage extends HelperBase {

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
        click(By.cssSelector("input[value='Login']"));
    }
}
