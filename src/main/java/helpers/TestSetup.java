package helpers;

import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSetup {

    protected WebDriver driver;

    @BeforeTest
    public void SetUp() throws Exception {
        driver = new DriverFactory().create();
    }


    @AfterTest
    public void TearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
