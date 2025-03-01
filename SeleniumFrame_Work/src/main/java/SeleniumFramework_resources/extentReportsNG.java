package SeleniumFramework_resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportsNG {
	
	
	
	
public static ExtentReports getextentobject()
	
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);  
		reporter.config().setReportName("Web automation result sheet");
		reporter.config().setDocumentTitle("test Result");
		
		ExtentReports extn = new ExtentReports();
		extn.attachReporter(reporter);
		extn.setSystemInfo("Tester", "Prajna");
		return extn;
		
		
	}	

}
