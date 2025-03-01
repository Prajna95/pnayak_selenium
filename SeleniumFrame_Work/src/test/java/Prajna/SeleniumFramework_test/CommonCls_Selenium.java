package Prajna.SeleniumFramework_test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramework_PageObjectModel.CartPage;
import SeleniumFramework_PageObjectModel.CheckoutPage;
import SeleniumFramework_PageObjectModel.ConfirmationPage;
import SeleniumFramework_PageObjectModel.LoginPage;
import SeleniumFramework_PageObjectModel.OrderPage;
import SeleniumFramework_PageObjectModel.ProductCatalogue;
import SeleniumFramework_test.testcomponent.BaseTest;

public class CommonCls_Selenium extends BaseTest  {

	
	String productName ="ADIDAS ORIGINAL";
	
@Test

	public void EcomPage() throws IOException
	{
		
		
		ProductCatalogue productcatalogue=login.loginApplication("prajna@gmail.com", "Lipa@0811");
		
		
		List<WebElement> products = productcatalogue.productlist();
		productcatalogue.addproducttocart(productName);	
		
		CartPage cartpage= productcatalogue.gotoCartPage();
		
		

		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage =cartpage.checkout();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationpage = checkoutpage. submitorder();
		
		 String ConMSG = confirmationpage.getconfirmationmsg();
		  
		  AssertJUnit.assertTrue(ConMSG.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 	
		

	}

@Test(dependsOnMethods="EcomPage")
public void OrderHistoryPage()
{
	ProductCatalogue productcatalogue=login.loginApplication("prajna@gmail.com", "Lipa@0811");
	OrderPage orderpage =productcatalogue.gotoOrderPage();
	Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
}
}
