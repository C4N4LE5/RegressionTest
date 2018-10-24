package googleTest;

import PageObject.GooglePageObject;
import helpers.ExcelUtils;
import helpers.HomeHelper;
import helpers.TestSetup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import shared.ExcelProperties;
import testdata.Constant;

import java.util.HashMap;

public class GoogleTest extends TestSetup {

    private String screenshotFolder;

    @BeforeTest
    public void homePageVisibility() throws Exception {
        /* Load the Excel and the Sheet Name */
        ExcelUtils.setExcelFile(
                Constant.Path_TestData + Constant.File_TestData,
                "Google");
        /* Get the URL and open it */
        System.out.println(ExcelUtils.getCellData(2, 1));
        driver.get(ExcelUtils.getCellData(2, 1));
        /* Get the Data for the Report creation from Excel Sheet */
        HashMap<String, String> googlePage = new ExcelProperties().getGoogleData();
        /* Create an Instance of HomeHelper class to validate if the Home Page is fully loaded. */
        HomeHelper homeHelper = new HomeHelper(driver,screenshotFolder);
        homeHelper.checkHomePageExists();
    }

    @Test(priority = 1)
    public void createNewAccountPlan() throws Exception {
        Thread.sleep(5000);
        GooglePageObject object = new GooglePageObject(driver,screenshotFolder);
        object.googleTest();

    }
}
