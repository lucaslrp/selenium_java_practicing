package support;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdrive.chrome.driver", "C:\\Users\\Drivers-automation\\chromedriver.exe");
        WebDriver nav = new ChromeDriver();
        nav.manage().window().maximize();
        nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        nav.get("https://automationteststore.com/");

        return nav;
    }
}

// Classe abriga um conjunto de métodos relacionados à aplicação web, onde cria uma instancia Chrome, ele tem coisas relacionadas ao chrome nesse caso e navega para determinada pág.

// Poderia também ter quebrado, ou seja, ter um só pra criar um chorme, outro só pra definir as opções relacionadas ao tempo de sessão, por exemplo, outro pra navegar, 
//mas como nesse caso td acontece junto, é bom estarem juntas.
