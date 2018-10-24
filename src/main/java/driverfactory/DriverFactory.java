package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {

    public static WebDriver create()  {


        String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Mac")) {
            String pathToChromeDriver = "/Users/kxng739/Box Sync/ScriptsPJP/companionwebautomation/companionAutomation/src/main/java/driverfactory/chromedriver";
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            return new ChromeDriver();
        } else if (operatingSystem.contains("Windows")) {
            String pathToChromeDriver = System.getProperty("user.dir") + "/src/main/java/driverfactory/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            return new ChromeDriver();
        } else {
            throw new NullPointerException();
        }


    }

}
