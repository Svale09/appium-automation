package TestUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReporter(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("/Users/ivansvalina/IdeaProjects/ZavrsniRad/Reports");
        reporter.config().setReportName("Test Report");
        reporter.config().setDocumentTitle("Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ivan Svalina");

        return extent;
    }
}
