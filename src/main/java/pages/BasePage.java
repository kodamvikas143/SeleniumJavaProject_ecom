package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.demoblaze.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "path/to/new/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
		context.setAttribute("WebDriver", driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		
	}
}
