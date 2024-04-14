package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterLoginPage extends BasePage {
    
    public AfterLoginPage(WebDriver nav) {
        super(nav);
        //TODO Auto-generated constructor stub
    }

    public String confirmLogin(){

        return nav.findElement(By.xpath("//div[@class='menu_text' and contains(text(), 'Welcome back')]")).getText();
        //String confirmLoginMessage = confirmLogin.getText();
        
        //return confirmLoginMessage.getText();
        //assertTrue(confirmLoginMessage.contains("Welcome back"));

        
    }

}
