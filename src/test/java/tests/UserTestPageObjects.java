package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pages.LoginRegisterPage;
import support.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfoUsersPageObjects.csv")

public class UserTestPageObjects {
    private WebDriver nav;

    @Before
    public void setUp(){
        nav = Web.createChrome();
    }

    @Test
    public void testLogin(){

        //Método Estrutural
        /*new LoginRegisterPage(nav)
            .clickLoginAndRegister()
            .typeLoginName("testtester")
            .typePassword("testtester12345")
            .clickLoginBtn();*/

        //Método Funcional
        String confirmLoginMessage = new LoginRegisterPage(nav)
            .clickLoginAndRegister()
            .loginAction("testtester", "testtester12345")
            .confirmLogin();

        assertTrue(confirmLoginMessage.contains("Welcome back"));

    }

    @After
    public void tearDown(){
        nav.quit();
    }
}
