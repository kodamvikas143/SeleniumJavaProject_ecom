package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import pages.BasePage;


public class LoginPageTest extends BasePage{
	
	//* Test invalid login attempts using data from DataProvider
	@DataProvider(name="accounts")
	public Object[][] getData(){
		return new Object[][] {
			{"test_vikas1@gmail.com", "test@123"}, // Invalid email, correct password
			{"test_vikas@gmail.com", "test123"} // Correct email, Invalid password
		};
	}
	
	@Test(priority=0, dataProvider="accounts")
	public void verifyInvalidLoginCredentials(String testUsername, String testPassword) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.typeUsername(testUsername);
		logger.log(LogStatus.INFO, "Entering invalid username");
		login.typePassword(testPassword);
		logger.log(LogStatus.INFO, "Entering invalid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		login.errorContainerDisplayed();
		
//		logger.log(LogStatus.PASS, "Log in with invalid crendentials failed");
	}
	
	
	@Test(priority=1)
	@Parameters({"username", "password"})
	public void verifyLogin(String username, String password) throws InterruptedException { 
		LoginPage login = new LoginPage(driver);
		login.typeUsername(username);
		logger.log(LogStatus.INFO, "Entering valid username");
		login.typePassword(password);
		logger.log(LogStatus.INFO, "Entering valid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		Thread.sleep(3000);
		Assert.assertTrue(login.verifyNewPage());
	}
}	
