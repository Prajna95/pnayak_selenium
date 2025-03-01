package SeleniumFramework_test.testcomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFramework_resources.extentReportsNG;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentReports extn = extentReportsNG.getextentobject();
	ExtentTest test;
	ThreadLocal extntest = new ThreadLocal();
	
	
	public  void onTestStart(ITestResult result)
	{
	    test = extn.createTest(result.getMethod().getMethodName());
	    extntest.set(test); //unique thread safe id (errorvalidation)--> test
	 }


	  public  void onTestSuccess(ITestResult result) {
		  ((ExtentTest) extntest.get()).log(Status.PASS, "test passed");
	    
	  }

	 
	  public  void onTestFailure(ITestResult result) {
		  test.log(Status.FAIL, "test failed");
		  ((ExtentTest) extntest.get()).fail(result.getThrowable());
		  
		  try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		 String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		((ExtentTest) extntest.get()).addScreenCaptureFromPath(filepath, result.getMethod().getMethodName() );
	   
	  }

	 
	  public  void onTestSkipped(ITestResult result) {
	    
	  }

	  
	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }

	  
	  public  void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public  void onStart(ITestContext context) {
	   
	  }

	 
	  public  void onFinish(ITestContext context) {
	    extn.flush();
	  }

}
