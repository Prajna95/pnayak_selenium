package Prajna.SeleniumFramework_test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class CommonCls_Selenium_ench extends BaseTest  {

	
	private static final String HashMap  = null;

	//String productName ="ADIDAS ORIGINAL";
	
@Test(dataProvider="getData", groups= {"purches"})

	public void EcomPage(java.util.HashMap<String,String>Input) throws IOException
	{
		
		
		ProductCatalogue productcatalogue=login.loginApplication(Input.get("email"), Input.get("password"));
		
		
		List<WebElement> products = productcatalogue.productlist();
		productcatalogue.addproducttocart(Input.get("product"));	
		
		CartPage cartpage= productcatalogue.gotoCartPage();
		
		

		Boolean match = cartpage.VerifyProductDisplay(Input.get("product"));
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
	String productName = null;
	Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
}








//one way 
//@DataProvider
//public Object[][] getData()
//{
	//return new Object [] [] {{"prajna@gmail.com","Lipa@0811","productName"},{"prajna11@gmail.com","Lipa@08111","productName1"}};
//}
//2nd way by using hashmap

@DataProvider
public Object[][] getData() throws IOException{
	
	//HashMap<String,String> map = new HashMap<String,String>();
	//map.put("email", "prajna@gmail.com");
	//map.put("password", "Lipa@0811");
	//map.put("product", "ADIDAS ORIGINAL");
	
	//HashMap<String,String> map1 = new HashMap<String,String>();
	//map1.put("email", "prajna@gmail1.com");
	//map1.put("password", "Lipa@08111");
	//map1.put("product", "ADIDAS ORIGINA11L");
	
	List <HashMap<String ,String>> data = getjsonDatatoMap
			("System.getProperty(\"user.dir\") +\"//src//test//java//SeleniumFramework//data/purchaseOrder.json\"),StandardCharsets.UTF_8");
			
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
	
}

}
