package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginRegisterPage extends BasePage{


    public LoginRegisterPage(WebDriver nav) {
        super(nav);
        //TODO Auto-generated constructor stub
    }

    public LoginFormPage clickLoginAndRegister(){
        nav.findElement(By.linkText("Login or register")).click();

        return new LoginFormPage(nav);
    }

}
