package Prajna.SeleniumFramework_test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramework_PageObjectModel.CartPage;
import SeleniumFramework_PageObjectModel.LoginPage;
import SeleniumFramework_PageObjectModel.ProductCatalogue;
import SeleniumFramework_test.testcomponent.BaseTest;
import SeleniumFramework_test.testcomponent.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest  {

@Test(groups= {"errorhandleing"}, retryAnalyzer=Retry.class)

	public void EcomPageErrorValidation() throws IOException
	{
		
		
		
		ProductCatalogue productcatalogue=login.loginApplication("prajna@gmail.com", "Lipa@08");
		AssertJUnit.assertEquals("Incorrect email or password@", login.getErrorMsg());
	
	}

@Test
public void productPageErrorValidation()
{
	ProductCatalogue productcatalogue=login.loginApplication("prajna@gmail.com", "Lipa@0811");
	List<WebElement> products = productcatalogue.productlist();
	String productName = "ADIDAS ORIGINAL";
	productcatalogue.addproducttocart(productName);	
	CartPage cartpage= productcatalogue.gotoCartPage();
	Boolean match = cartpage.VerifyProductDisplay("ADIDAS ORIGINAL1");
	Assert.assertFalse(match);
}

}
