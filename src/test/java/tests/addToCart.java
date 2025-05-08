package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.CartPage;
import pages.LoginPage;

public class addToCart {

	public class LoginPageTest extends BasePage{
		
		
		@Test(priority=0)
		@Parameters({"username", "password"})
		public void verifyAddToCart(String username, String password) throws InterruptedException { 
			LoginPage login = new LoginPage(driver);
			login.typeUsername(username);
			logger.log(LogStatus.INFO, "Entering valid username");
			login.typePassword(password);
			logger.log(LogStatus.INFO, "Entering valid password");
			login.clickSignIn();
			logger.log(LogStatus.INFO, "Clicking Sign in button");
			Thread.sleep(3000);
			Assert.assertTrue(login.verifyNewPage());
			CartPage addToCart = new CartPage(driver);
			addToCart.addToCart();
			logger.log(LogStatus.INFO, "Product Added in Cart");
		}
		
		@Test(priority=1)
		@Parameters({"username", "password", "in_name", "in_country", "in_city", "in_card", "in_month", "in_year"})
		public void verifyPurchase(String username, String password, String in_name, String in_country,String in_city,String in_card,String in_month,String in_year) throws InterruptedException { 
			LoginPage login = new LoginPage(driver);
			login.typeUsername(username);
			logger.log(LogStatus.INFO, "Entering valid username");
			login.typePassword(password);
			logger.log(LogStatus.INFO, "Entering valid password");
			login.clickSignIn();
			logger.log(LogStatus.INFO, "Clicking Sign in button");
			Thread.sleep(3000);
			Assert.assertTrue(login.verifyNewPage());
			
			CartPage addToCart = new CartPage(driver);
			addToCart.addToCart();
			logger.log(LogStatus.INFO, "Product Added in Cart");
			addToCart.placeOrder(in_name, in_country, in_city, in_card, in_month, in_year);
			logger.log(LogStatus.INFO, "Order Placed Sucessfully");
		}
		@Test(priority=2)
		@Parameters({"username", "password"})
		public void verifyDeleteItem(String username, String password ) throws InterruptedException { 
			LoginPage login = new LoginPage(driver);
			login.typeUsername(username);
			logger.log(LogStatus.INFO, "Entering valid username");
			login.typePassword(password);
			logger.log(LogStatus.INFO, "Entering valid password");
			login.clickSignIn();
			logger.log(LogStatus.INFO, "Clicking Sign in button");
			Thread.sleep(3000);
			Assert.assertTrue(login.verifyNewPage());
			
			CartPage addToCart = new CartPage(driver);
			addToCart.addToCart();
			logger.log(LogStatus.INFO, "Product Added in Cart");
			addToCart.deleteItem();
			logger.log(LogStatus.INFO, "Order Deleted Sucessfully");
		}
		
		
	}
}
