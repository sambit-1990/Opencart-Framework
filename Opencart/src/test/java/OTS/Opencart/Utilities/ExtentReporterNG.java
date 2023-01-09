package OTS.Opencart.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports getReporter() {
		String path = System.getProperty("user.dir") + "//Test-Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result-Opencart");
		reporter.config().setReportName("Automation Test report - Opencart");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");

		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester's name ", "Sambit Bhattacharyya");
		report.setSystemInfo("Operating System", "Windows11");
		report.setSystemInfo("Sprint Name", "Iteration1");
		return report;
		

	}
}
