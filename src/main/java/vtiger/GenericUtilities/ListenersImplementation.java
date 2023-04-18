package vtiger.GenericUtilities;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/***
 * 
 * @author Sushma Akki
 * This Method is for ITestListener implementation
 */
public class ListenersImplementation implements ITestListener
{
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	ExtentReports  report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Test Script Started");
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+"Test Script Execution Started");
	}

	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---PASS---");
		String screenShotName = methodName+"-"+new JavaUtility().systemDateInFormat();
		try {
			String path = wUtil.takeScreenShotS(BaseClass.screenShot_Driver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--- FAIL ---");
		test.log(Status.INFO, result.getThrowable());
		String screenShotName = methodName+"-"+new JavaUtility().systemDateInFormat();
		try {
			String path = wUtil.takeScreenShotS(BaseClass.screenShot_Driver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"----SKIPPED-----");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
	}

	public void onStart(ITestContext context) 
	{
		
		System.out.println("executionstarted");
		
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(".\\ExtentReportig\\report-"+jUtil.systemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("Vtiger Execution report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setReportName("Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-Name", "Sushma");
		
		
	}

	public void onFinish(ITestContext context) 
	{
		//we are generating extent reports and giving the reportname as report-systemdate.html
		
		System.out.println("execution completed");
		
		report.flush();//this is to generate the Extent Report
	}
	
}
