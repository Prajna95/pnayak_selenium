package SeleniumFramework_PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework_AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	
	//local cls 
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css =".mb-3")
	List<WebElement> products;
	
	@FindBy(css =".ng-animating")
	WebElement spinner;
	
	
	By product=  By.cssSelector(".mb-3");
	By addtocart= By.cssSelector(".card-body button:last-of-type");
	By toastmsg =By.cssSelector("#toast-container");
	
	
	
	public  List<WebElement> productlist()
	{
		waitForElementAppear(product);
		return products;
		
	}
	
    public WebElement getproductByName(String productName)
    {
    	 WebElement prod= productlist().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	 return prod;
    	 
    }
    public void addproducttocart(String productName) 
    {
    	
    	WebElement prod = getproductByName( productName);
    	prod.findElement(addtocart).click();
    	waitForElementAppear(toastmsg);
    	//waitForElementDisappear(spinner);
    	
    	
    }
    
    
}
