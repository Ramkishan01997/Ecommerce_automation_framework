package extentreport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import testCases.BaseTest;

public class ExtentTest extends BaseTest implements ITestListener {
	com.aventstack.extentreports.ExtentTest test;
	ExtentReports extent = ExtentReporter.getReporterObject();

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSucess(ITestResult result) {
		test.log(Status.PASS, "Test case Passed");
	}

	public void onTestFailure(ITestResult result) {
		
//		test.log(Status.FAIL, "Test case Failed");
		test.fail(result.getThrowable());
		
		try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		String filePath=null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case Skipped");
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
