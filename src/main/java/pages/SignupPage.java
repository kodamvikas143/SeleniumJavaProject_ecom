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

public class SignupPage {
	

	By signupLink = By.xpath("//a[contains(text(),'Sign up')]");
	By inputUserName = By.id("sign-username");
	By inputPassword = By.id("sign-password");
	By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");
			
	WebDriver driver;
	WebDriverWait wait;
	
	public SignupPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 5);
		 driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	public void signupAccount(String input_email, String input_password) { //pass a parameter so we don't hardcode values in the object class.
		driver.findElement(signupLink).click();
		driver.findElement(inputUserName).sendKeys(input_email);
		driver.findElement(inputPassword).sendKeys(input_password);
		driver.findElement(signUpButton).click();
	
		
		
		
	}
}