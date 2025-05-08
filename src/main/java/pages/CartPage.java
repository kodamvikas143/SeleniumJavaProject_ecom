package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	By phoneCategory = By.xpath("//a[contains(text(),'Phones')]");
	By laptopsCategory = By.xpath("//a[contains(text(),'Laptops')]");
	By nokiaPhone = By.xpath("//a[contains(text(),'Nokia lumia 1520')]");
	By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
	By cartLink = By.xpath("//a[contains(text(),'Cart')]");
	By productName = By.xpath("(//tbody/tr/td)[2]");
	By productPrice = By.xpath("(//tbody/tr/td)[3]");
	By deleteButton = By.xpath("(//tbody/tr/td)[4]");
	By placeOrderButton =By.xpath("//button[contains(text(),'Place Order')]");
	By name = By.id("name");
	By country = By.id("country");
	By city = By.id("city");
	By card = By.id("card");
	By month = By.id("month");
	By year = By.id("year");
	By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
	By purchaseSucessMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 5);
		 driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	public void addToCart() { //pass a parameter so we don't hardcode values in the object class.

		driver.findElement(phoneCategory).click();
		driver.findElement(nokiaPhone).click();
		
		driver.findElement(addToCartButton).click();
		
	}
	
	public void placeOrder(String in_name, String in_country,String in_city,String in_card,String in_month,String in_year) {
		driver.findElement(cartLink).click();
		driver.findElement(productName).isDisplayed();
		driver.findElement(productPrice).isDisplayed();
		driver.findElement(placeOrderButton).click();
		driver.findElement(name).sendKeys(in_name);
		driver.findElement(country).sendKeys(in_country);
		driver.findElement(city).sendKeys(in_city);
		driver.findElement(card).sendKeys(in_card);
		driver.findElement(month).sendKeys(in_month);
		driver.findElement(year).sendKeys(in_year);
		driver.findElement(purchaseButton).click();
		driver.findElement(purchaseSucessMessage).isDisplayed();
		
		
	}
	
	public void deleteItem() throws InterruptedException {
		driver.findElement(cartLink).click();
		driver.findElement(productName).isDisplayed();
		driver.findElement(productPrice).isDisplayed();
		driver.findElement(deleteButton).click();
	}
//	
//	
//	public boolean verifyNewPage() {
//
//		return driver.findElement(nameOfUser).getText().contains("Welcome test_vikas@gmail.com");
//	}
//	public void errorContainerDisplayed() {
//		 Alert error = driver.switchTo().alert();
//		 System.out.println(error.getText());
//		 error.accept();
//		 driver.findElement(closeIcon).click();
//	}
//	

}
