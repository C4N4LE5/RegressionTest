package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

/**
 * Created by kcwl112 on 23/03/2017.
 */
public class InitUtil {

    public boolean CreateFolder(String reportPath) {
        boolean success;
        success = (new File(reportPath).mkdir());
        if (success) {
            System.out.print("Report Folder Created Ok");
        }
        return success;
    }

    public boolean CreateSceenshotFolder(String screenshotPath) {
        boolean screenshot;
        screenshot = (new File(screenshotPath)).mkdir();
        if (screenshot) {
            System.out.print("// Screenshot Folder Created Ok");
        }
        return screenshot;
    }


    public ExtentHtmlReporter init(String filePath, String ReportName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setDocumentTitle("Companion Automation Report");
        htmlReporter.config().setReportName(ReportName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.setAppendExisting(true);
        return htmlReporter;
    }


    public ExtentReports extend(ExtentHtmlReporter extentHtmlReporter, boolean isManualConfig) {
        ExtentReports extent;
        extent = new ExtentReports();
        extent.attachReporter(extentHtmlReporter);
        extent.setReportUsesManualConfiguration(isManualConfig);
        return extent;
    }


}
