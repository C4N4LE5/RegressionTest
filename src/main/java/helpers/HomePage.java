package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import helpers.ExcelUtils;
import helpers.InitUtil;
import helpers.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends PageObject {

    WebDriverWait wait = new WebDriverWait(driver, 180);
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter = null;
    private String screenshotFolder;
    private String outputFolder;
    private String fileName;
    private String reportName;


    @FindBy(how = How.CSS, using = "#capability\\2e name")
    private WebElement divContainer;

    public HomePage(WebDriver driver, String screenshotFolder) throws Exception {
        super(driver);
        this.screenshotFolder = screenshotFolder;
        htmlReporter = new InitUtil().init(outputFolder + fileName, reportName);
        extent = new InitUtil().extend(htmlReporter, true);
    }

    public void homePageMap() throws Exception {
        //Name on test report
        ExtentTest test = extent.createTest(ExcelUtils.getCellData(12, 0));
        TakeScreenshots screenshot = new TakeScreenshots(driver,screenshotFolder);
        try {
            wait.until(ExpectedConditions.visibilityOf(divContainer));
            screenshot.capturescreenshot(driver, "homePage");
            test.log(Status.PASS, "Home Page is Displayed Ok", MediaEntityBuilder.createScreenCaptureFromPath(
                    screenshotFolder + "homePage.png").build());
        } catch (Exception e) {
            e.printStackTrace();
            screenshot.capturescreenshot(driver, "homePageFail");
            test.log(Status.FAIL, "Home Page is Displayed Fail", MediaEntityBuilder.createScreenCaptureFromPath(
                    screenshotFolder + "homePageFail.png").build());
        }
        /*
        test.assignAuthor("Rick");
        test.assignCategory("Companion Automated Tests");
        */
        extent.flush();
    }

}