package helpers;

import org.openqa.selenium.WebDriver;

/**
 * Created by kcwl112 on 17/05/2017.
 */
public class WindowHelper {

    private WindowHelper() {

    }

    public static boolean windowExits(WebDriver driver, String windowTitle) throws InterruptedException {

        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }

        if (windowTitle == null || windowTitle.trim().length() < 0) {
            throw new IllegalArgumentException("windowTitle doesn't exits");
        }

        Thread.sleep(3000);
        boolean flag = false;
        String currentWindowTitle = driver.getTitle();
        System.out.println("// This is your current title: " + currentWindowTitle);

        if (currentWindowTitle == null || currentWindowTitle.trim().length() < 1) {
            return false;
        }

        if (currentWindowTitle.equalsIgnoreCase(windowTitle)) {
            flag = true;
        }

        return flag;

    }
}
