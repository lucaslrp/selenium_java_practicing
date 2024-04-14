package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import support.Generator;
import support.Screenshots;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserTest.csv")

public class UserTest {
    private WebDriver nav;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        
        System.setProperty("webdrive.chrome.driver", "C:\\Users\\Drivers-automation\\chromedriver.exe");
        nav = new ChromeDriver();
        nav.manage().window().maximize();
        nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        nav.get("https://automationteststore.com/");
    }

    @Test
    public void testCreateAccount() {
        //@Param(name="firstname")String firstName,@Param(name="lastName")String lastName, @Param(name="email")String email, @Param(name="address")String address, @Param(name="city")String city, @Param(name="countryValue")String countryValue, @Param(name="stateValue")String stateValue, @Param(name="postCode")String postCode, @Param(name="loginName")String loginName, @Param(name="password")String password
        // click in Login
        // nav.findElement(By.linkText("Login or register")).click();
        WebElement loginAndRegister = nav.findElement(By.linkText("Login or register"));
        loginAndRegister.click();

        nav.findElement(By.xpath("//button[@title='Continue']")).click();

        WebElement accountForm = nav.findElement(By.id("AccountFrm"));
        accountForm.findElement(By.id("AccountFrm_firstname")).sendKeys("test5");
        accountForm.findElement(By.id("AccountFrm_lastname")).sendKeys("tester5");
        accountForm.findElement(By.id("AccountFrm_email")).sendKeys("testtester5@test5.com");
        accountForm.findElement(By.id("AccountFrm_address_1")).sendKeys("address test 5");
        accountForm.findElement(By.id("AccountFrm_city")).sendKeys("City test 5");
        WebElement country = nav.findElement(By.id("AccountFrm_country_id"));
        new Select(country).selectByValue("30");
        WebElement regionState = nav.findElement(By.id("AccountFrm_zone_id"));
        new Select(regionState).selectByValue("464");
        accountForm.findElement(By.id("AccountFrm_postcode")).sendKeys("12345");
        accountForm.findElement(By.id("AccountFrm_loginname")).sendKeys("testtester5");
        accountForm.findElement(By.id("AccountFrm_password")).sendKeys("testtester12345");
        accountForm.findElement(By.id("AccountFrm_confirm")).sendKeys("testtester12345");
        WebElement radioNo = nav.findElement(By.id("AccountFrm_newsletter0"));
        radioNo.click();
        accountForm.findElement(By.id("AccountFrm_agree")).click();

        nav.findElement(By.xpath("//*[@id='AccountFrm']/div[5]/div/div/button")).click();

        String scrennshotFileName = "C:\\Users\\lucas\\OneDrive\\Documents\\Pratica Selenium+Java\\selenium_java_practicing\\Screenshots" + Generator.dateTimeforFile() + test.getMethodName() + ".png";
        Screenshots.takeSS(nav, scrennshotFileName);

        WebElement confirmAccountCreation = nav
                .findElement(By.xpath("//div[@class='menu_text' and contains(text(), 'Welcome back')]"));
        String confirmLoginMessage = confirmAccountCreation.getText();
        assertTrue(confirmLoginMessage.contains("test5"));

    }

    @Test
    public void testLogin() {

        // click in Login
        // nav.findElement(By.linkText("Login or register")).click();
        WebElement loginAndRegister = nav.findElement(By.linkText("Login or register"));
        loginAndRegister.click();

        // write login and password in Login Form
        WebElement loginForm = nav.findElement(By.id("loginFrm"));

        loginForm.findElement(By.name("loginname")).sendKeys("testtester");
        loginForm.findElement(By.name("password")).sendKeys("testtester12345");

        // click login in Login Form
        loginForm.findElement(By.xpath("//button[@title='Login']")).click();

        // validation
        //// div[@class='menu_text' and contains(text(), 'Welcome back')]
        WebElement confirmLogin = nav
                .findElement(By.xpath("//div[@class='menu_text' and contains(text(), 'Welcome back')]"));
        String confirmLoginMessage = confirmLogin.getText();
        assertTrue(confirmLoginMessage.contains("Welcome back"));

    }

    @After
    public void tearDown() {
        nav.quit();
    }
}
