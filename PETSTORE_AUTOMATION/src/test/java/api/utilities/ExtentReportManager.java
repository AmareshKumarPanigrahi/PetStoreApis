package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;

	
	public void onStart(ITestContext context) {
     String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());//time stamp
     repName="Test-Report-"+timeStamp+".html";
     
     sparkReporter=new ExtentSparkReporter(".\\Reports\\"+repName);//specify location of the report
     sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");//title of report
     sparkReporter.config().setReportName("Pet Stores Users Api");//name of the Report
     sparkReporter.config().setTheme(Theme.STANDARD);
     
     extent=new ExtentReports();
     extent.attachReporter(sparkReporter);
     extent.setSystemInfo("Application","Petstores Users Api");
     extent.setSystemInfo("OperatingSystem",System.getProperty("os.name"));
     extent.setSystemInfo("UserName", System.getProperty("user.name"));
     extent.setSystemInfo("Environment", "QA");
     extent.setSystemInfo("User", "Amaresh");
     
     
     
     
     
	}
	

	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}

	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
        test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
        
        
		
	}


	public void onFinish(ITestContext context) {
	
		extent.flush();
	}
	
	
	

	

}
