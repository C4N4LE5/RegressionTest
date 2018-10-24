package helpers;

import helpers.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeHelper {


    private static final String HOME_PAGE_EXIST = "Google";
    private WebDriver driver;
    private HomePage home = null;
    private boolean FolderCreate;
    private boolean ScreenshotFolder;
    public String screenshotFolder;

    public HomeHelper(WebDriver driver,
                      String screenshotFolder) throws Exception {
        this.driver = driver;
        this.screenshotFolder = screenshotFolder;
        FolderCreate = new InitUtil().CreateFolder(ExcelUtils.getCellData(2, 0));
        ScreenshotFolder = new InitUtil().CreateSceenshotFolder(ExcelUtils.getCellData(4, 0));
        Thread.sleep(5000);
        home = new HomePage(driver,screenshotFolder);
    }

    public void checkHomePageExists() throws Exception {
        if (WindowHelper.windowExits(driver, HOME_PAGE_EXIST)) {
            System.out.println("Home Page Exist");
            home.homePageMap();
        } else {
            System.out.println("Home Page Not Exist");
        }

    }
}

