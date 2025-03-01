package SeleniumFramework_AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework_PageObjectModel.CartPage;
import SeleniumFramework_PageObjectModel.OrderPage;

public class AbstractComponent {

WebDriver driver;

public AbstractComponent(WebDriver driver) {
	this.driver=driver;
	PageFactory .initElements(driver, this);
		
	
	}
@FindBy(css ="[routerLink*='cart']")
WebElement cartHeader;

@FindBy(css ="[routerLink*='myorders']")
WebElement orderheader;

public void waitForElementAppear(By FindBy)
{



	WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));


}

public void waitForWEbElementAppear(WebElement FindBy)
{



	WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElements(FindBy));


}

public void waitForElementDisappear(WebElement spin) throws InterruptedException
{
	Thread.sleep(2000);
	//WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(2));
	//wait.until(ExpectedConditions.invisibilityOf((spin)));
}



public CartPage gotoCartPage() {
	
	cartHeader.click();
	CartPage cartpage = new CartPage(driver);
	return cartpage;
	
	
}

public OrderPage gotoOrderPage() {
	
	orderheader.click();
	OrderPage orderpage = new OrderPage(driver);
	return orderpage;
	
	
}

}