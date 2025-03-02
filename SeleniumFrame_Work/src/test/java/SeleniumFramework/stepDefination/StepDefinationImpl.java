package SeleniumFramework.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import SeleniumFramework_PageObjectModel.CartPage;
import SeleniumFramework_PageObjectModel.CheckoutPage;
import SeleniumFramework_PageObjectModel.ConfirmationPage;
import SeleniumFramework_PageObjectModel.LoginPage;
import SeleniumFramework_PageObjectModel.ProductCatalogue;
import SeleniumFramework_test.testcomponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest {
	
public LoginPage landingpage;	
public LoginPage login;
public ProductCatalogue productcatalogue;
public ConfirmationPage confirmationpage;
@Given("landed to the ECom Page")
public void landed_to_the_ECom_Page() throws IOException
{
	login =launchApplication();
}

@Given ("^login to the ECom page by using username(.+) and password (.+)$")
public void login_to_the_e_com_page_by_using_username_and_password(String username, String password)
{
	 productcatalogue= login.loginApplication(username,password);
}

@When ("^Checkout the productname(.+) to the Cart$")
public void checkout_the_product_to_the_cart(String productname)
{
	List<WebElement> products = productcatalogue.productlist();
	productcatalogue.addproducttocart(productname);	
}

@When ("^checkout (.+) and submit the order$")
public void checkout_and_submit_the_order(String productname)
{
	CartPage cartpage= productcatalogue.gotoCartPage();
	Boolean match = cartpage.VerifyProductDisplay(productname);
	Assert.assertTrue(match);
	CheckoutPage checkoutpage =cartpage.checkout();
	checkoutpage.selectCountry("India");
	 confirmationpage = checkoutpage. submitorder();
	
}

@Then ("Verify the {string} message is displayed on confirmationpage")
public void confirmationpage_msg(String string)
{
	String ConMSG = confirmationpage.getconfirmationmsg();
	  
	 AssertJUnit.assertTrue(ConMSG.equalsIgnoreCase(string));
	 driver.close();
}
		

}
