package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create ExtentReports and attach the HTML reporter
            extent = new ExtentReports();
            htmlReporter = new ExtentSparkReporter("src/main/java/reports/extentreports/ExtentReport.html");
            htmlReporter.config().setReportName("Test Report");
            htmlReporter.config().setDocumentTitle("Extent Report");
            htmlReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
