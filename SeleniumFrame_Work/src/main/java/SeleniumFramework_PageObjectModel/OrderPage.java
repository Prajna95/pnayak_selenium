package SeleniumFramework_PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework_AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	
	//local cls 
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	
	//1st way //WebElement userEmailid = driver.findElement(By.id("userEmail"));
	
	@FindBy(css ="tr td:nth-child(3)")
	private List<WebElement> Productnames;
	
	@FindBy(css =".totalRow button")
	WebElement checkOut;
	
	public Boolean VerifyOrderDisplay(String ProductName)
	{
		Boolean match = Productnames.stream().anyMatch(productname-> productname.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public CheckoutPage checkout()
	{
		checkOut.click();
		 return new CheckoutPage(driver);
	}
	
	
	

}
