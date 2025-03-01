package Prajna.SeleniumFramework_test;


import io.github.bonigarcia.wdm.WebDriverManager;

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

import SeleniumFramework_PageObjectModel.LoginPage;

public class CommonClass {

	public static void main(String[] args) {
		
		String productName ="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LoginPage login = new LoginPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("prajna@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Lipa@0811");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		 WebElement product1= products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 
		 product1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		 
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
		 
		 List <WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		 Boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
		 
		 Assert.assertTrue(match);
		  driver.findElement(By.cssSelector(".totalRow button")).click();
		  
		  Actions a = new Actions(driver);
		  
		  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		  
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		  
		  driver.findElement(By.xpath("(//button[contains(@class ,'ta-item')])[2]")).click();
		  
		  driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		  
		  String ConMSG = driver.findElement(By.cssSelector(".hero-primary")).getText();
		  
		  Assert.assertTrue(ConMSG.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		  
		  driver.close();
		  
		  
		  
		  
		  
		 
		 
		 
		 
		 
		 
		
		
		

	}

}
