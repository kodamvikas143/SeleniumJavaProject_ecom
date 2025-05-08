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

public class ContactPage {
	

	By contactLink = By.xpath("//a[contains(text(),'Contact')]");
	By email = By.id("recipient-email");
	By recipientName = By.id("recipient-name");
	By message = By.xpath("//label[contains(text(),'Message')]/following-sibling::textarea");
	By sendMessage = By.xpath("//button[contains(text(),'Send message')]");
			
			
	WebDriver driver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 5);
		 driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	public void contactFuction(String recipant_email, String recipant_name, String messageText) { //pass a parameter so we don't hardcode values in the object class.
		driver.findElement(contactLink).click();
		driver.findElement(email).sendKeys(recipant_email);
		driver.findElement(recipientName).sendKeys(recipant_name);
		driver.findElement(message).sendKeys(messageText);
		driver.findElement(sendMessage).click();
		Alert sucess = driver.switchTo().alert();
		 System.out.println(sucess.getText());
		 sucess.accept();
		
		
		
	}
}