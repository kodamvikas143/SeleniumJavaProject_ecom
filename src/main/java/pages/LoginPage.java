package pages;

import java.util.Set;

import javax.xml.datatype.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	By signUpLink = By.id("signin2");
	By inputUserName = By.id("sign-username");
	By inputPassword = By.id("sign-password");
	By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");
	By loginLink = By.id("login2");
	By usernameField = By.id("loginusername");
	By passwordField = By.id("loginpassword");
	By loginButton = By.xpath("//button[contains(text(),'Log in')]");
	By nameOfUser = By.id("nameofuser");
	By closeIcon = By.xpath("(//button[@type='button']/span[contains(text(),'×')])[3]");
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 5);
	}
	
	public void typeUsername(String username) { //pass a parameter so we don't hardcode values in the object class.

		driver.findElement(loginLink).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
		element.clear();
		element.sendKeys(username);
	
	}
	
	public void typePassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSignIn() throws InterruptedException {
		driver.findElement(loginButton).click();
		Thread.sleep(3000);
	}
	
	
	public boolean verifyNewPage() {

		return driver.findElement(nameOfUser).getText().contains("Welcome test_vikas@gmail.com");
	}
	public void errorContainerDisplayed() {
		 Alert error = driver.switchTo().alert();
		 System.out.println(error.getText());
		 error.accept();
		 driver.findElement(closeIcon).click();
	}
	

}
