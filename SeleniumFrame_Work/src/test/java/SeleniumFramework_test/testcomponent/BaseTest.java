package SeleniumFramework_test.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFramework_PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
public WebDriver driver;	
public LoginPage login;
	public WebDriver initializationwebDriver() throws IOException 
	{
		
		
		
	//properties cls
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//SeleniumFramework_resources//GlobalData.properties");
		prop.load(fs);
		String browsername = System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");
		
	 //browsername = prop.getProperty("browser");
	
	if(browsername.contains("chrome"))
	{
		
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browsername.contains("headless"))
		{
			option.addArguments("headless");
		}
		
	
	 driver = new ChromeDriver(option);
	 driver.manage().window().setSize(new Dimension(1440,900)); //full screen display
	
	}
	
	//else if (browsername.equalsIgnoreCase("safari"))
	{
		//System.setProperty("WebDriver.Safari.Driver", "safari.exe");
		//WebDriver driver = new SafariDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;

}


		public  List<HashMap<String,String>> getjsonDatatoMap(String filePath) throws IOException
		{
			
			//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath));
		
		//covert string to hashmap :jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
			return data;
				
				
		
		}
		
		public String getScreenshot(String testcase) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//TestSuites//" +testcase+  ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//Reports//" +testcase+  ".png";

		}


		
@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException
	{
		driver= initializationwebDriver();
		login = new LoginPage(driver);
		login.url();
		return login;
		
	}
@AfterMethod(alwaysRun=true)

	public void CloseApp()
	{
	
	driver.close();
}
	
	
}

