package helpers;

import helpers.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by krdm291 on 30/01/2017.
 */
public class TakeScreenshots extends HomePage {


    public TakeScreenshots(WebDriver driver, String screenshotfolder) throws Exception {
        super(driver, screenshotfolder);
    }


    public void capturescreenshot(WebDriver driver, String screenshotname) throws Exception {
        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(src, new File(ExcelUtils.getCellData(4, 0) + screenshotname + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
