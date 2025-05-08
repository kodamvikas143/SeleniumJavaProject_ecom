package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.CartPage;
import pages.ContactPage;
import pages.LoginPage;

public class contactPageTest {

	public class LoginPageTest extends BasePage{
		
		
		@Test(priority=0)
		@Parameters({"username", "password", "recipant_email", "recipant_name", "messageText"})
		public void verifyContact(String username, String password, String recipant_email, String recipant_name,String messageText) throws InterruptedException { 
			LoginPage login = new LoginPage(driver);
			login.typeUsername(username);
			logger.log(LogStatus.INFO, "Entering valid username");
			login.typePassword(password);
			logger.log(LogStatus.INFO, "Entering valid password");
			login.clickSignIn();
			logger.log(LogStatus.INFO, "Clicking Sign in button");
			Thread.sleep(3000);
			Assert.assertTrue(login.verifyNewPage());
			ContactPage contact = new ContactPage(driver);
			contact.contactFuction(recipant_email, recipant_name, messageText);
			
		}
		
		
	}
}
