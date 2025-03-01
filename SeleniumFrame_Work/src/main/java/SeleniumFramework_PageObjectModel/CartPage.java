package SeleniumFramework_PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework_AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	
	//local cls 
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	
	//1st way //WebElement userEmailid = driver.findElement(By.id("userEmail"));
	
	@FindBy(css =".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css =".totalRow button")
	WebElement checkOut;
	
	public Boolean VerifyProductDisplay(String ProductName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public CheckoutPage checkout()
	{
		checkOut.click();
		 return new CheckoutPage(driver);
	}
	
	
	

}
