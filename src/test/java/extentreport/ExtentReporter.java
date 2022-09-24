package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getReporterObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Function Test");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Ramkishan ");
		extent.setSystemInfo("browser", "chrome");
		return extent;
	}

}
