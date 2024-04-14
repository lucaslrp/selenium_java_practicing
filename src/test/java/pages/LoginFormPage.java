package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{
    
    public LoginFormPage(WebDriver nav) {
        super(nav);
        //TODO Auto-generated constructor stub
    }

    //Método Estrutural
    public LoginFormPage typeLoginName(String loginName){
        nav.findElement(By.id("loginFrm")).findElement(By.name("loginname")).sendKeys(loginName);

        return this;
    }

    public LoginFormPage typePassword(String password){
        nav.findElement(By.id("loginFrm")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public AfterLoginPage clickLoginBtn(){
        nav.findElement(By.id("loginFrm")).findElement(By.xpath("//button[@title='Login']")).click();

        return new AfterLoginPage(nav);
    }

    //Método Funcional
    public AfterLoginPage loginAction(String loginName, String password){

        nav.findElement(By.id("loginFrm")).findElement(By.name("loginname")).sendKeys(loginName);
        nav.findElement(By.id("loginFrm")).findElement(By.name("password")).sendKeys(password);
        nav.findElement(By.id("loginFrm")).findElement(By.xpath("//button[@title='Login']")).click();

        return new AfterLoginPage(nav);
    }

    //Método Funcional com Estrutural
    /*public AfterLoginPage loginAction(String loginName, String password){

        typeLoginName(loginName);
        typePassword(password);
        clickLoginBtn();

        return new AfterLoginPage(nav);
    }*/
}
