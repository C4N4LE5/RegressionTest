package PageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import helpers.ExcelUtils;
import helpers.HomePage;
import helpers.InitUtil;
import helpers.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

public class GooglePageObject extends HomePage {

    WebDriverWait wait = new WebDriverWait(driver, 20);
    private static ExtentReports extent;
    private ExtentHtmlReporter htmlReporter = null;
    private Properties properties;
    private String screenshotFolder;

    @FindBy(how = How.CSS, using = "#lst-ib")
    WebElement search;

    public GooglePageObject(WebDriver driver, String screenshotFolder) throws Exception {
        super(driver,screenshotFolder);
        htmlReporter = new InitUtil().init(
                ExcelUtils.getCellData(2, 0) +
                        ExcelUtils.getCellData(8, 0),
                ExcelUtils.getCellData(10, 0)
        );
        extent = new InitUtil().extend(htmlReporter, true);
        this.screenshotFolder = ExcelUtils.getCellData(6, 0);
    }


    public void googleTest() throws Exception {
        ExtentTest test = extent.createTest(ExcelUtils.getCellData(8, 1));
        TakeScreenshots screenshots = new TakeScreenshots(driver,screenshotFolder);
        try {
            wait.until(ExpectedConditions.visibilityOf(search));
            screenshots.capturescreenshot(driver, "test");
            assert search.isEnabled();
            search.sendKeys("TEST");
            test.log(Status.INFO, "Searching word TEST", MediaEntityBuilder.createScreenCaptureFromPath(screenshotFolder+"test.png").build());
        }catch (Exception e){
            e.printStackTrace();
            screenshots.capturescreenshot(driver, "test failure");
            test.log(Status.FAIL, "Something went wrong while searching word test", MediaEntityBuilder.createScreenCaptureFromPath(screenshotFolder+"test failure.png").build());
        }
        extent.flush();

    }

}
