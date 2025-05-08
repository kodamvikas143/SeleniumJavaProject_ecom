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
import pages.SignupPage;

public class signupTest {

	public class LoginPageTest extends BasePage{
		
		
		@Test(priority=0)
		@Parameters({"recipant_email", "recipant_name", "messageText"})
		public void verifyContact( String recipant_email, String recipant_name,String messageText) throws InterruptedException { 
			SignupPage signup = new SignupPage(driver);
			signup.signupAccount(recipant_email, messageText);
			logger.log(LogStatus.INFO, "User Sign Up Successful");
			

		}
		
		
	}
}
