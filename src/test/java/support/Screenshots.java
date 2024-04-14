package support;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
    public static void takeSS (WebDriver nav, String file){
        File screenshot = ((TakesScreenshot)nav).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(file));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Issue copying file to the folder" + e.getMessage());
        }
    }
}
