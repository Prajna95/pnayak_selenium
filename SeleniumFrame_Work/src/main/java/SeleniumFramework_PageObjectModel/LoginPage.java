package SeleniumFramework_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework_AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	
	//local cls 
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	
	//1st way //WebElement userEmailid = driver.findElement(By.id("userEmail"));
	
	//2nd way // //PageFactory
	@FindBy(id="userEmail")  // FindBy annotation by Using initElemnts method construing the driver arg that we send in method , //pagefactory we can't apply in webelement.finfelement
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id ="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Errormsg;
	
			
			
	
	
	public ProductCatalogue loginApplication(String Email, String Password)
	
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		login.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	
	
	public void url()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg()
	{
		waitForWEbElementAppear(Errormsg);
		return Errormsg.getText();
	}
	
	

}
