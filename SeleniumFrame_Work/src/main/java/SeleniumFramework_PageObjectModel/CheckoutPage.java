package SeleniumFramework_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFramework_AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	@FindBy(css= "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath= "(//button[contains(@class ,'ta-item')])[2]")
	WebElement Selectcountry;
	
	@FindBy(css= ".btnn.action__submit.ng-star-inserted")
	WebElement Submit;
	
	By results = By.cssSelector(".ta-results");


public void selectCountry(String countryname)
{
	 Actions a = new Actions(driver);
	  
	  a.sendKeys(country,countryname).build().perform();
	  
	  waitForElementAppear(results);
	  Selectcountry.click();
	  
}
public ConfirmationPage submitorder()

{
	Submit.click();
	return new ConfirmationPage(driver);
}

}