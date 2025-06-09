package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


import Utils.ExtentReportManager;
import Utils.log;

public class BaseTest {

		protected WebDriver driver;
		
		protected static ExtentReports extent;
		//protected static ExtentTest test;
		protected ExtentTest test;
		
		@BeforeSuite
		public void setupReport() {
			extent = ExtentReportManager.getReportInstance();
		}
		
		@AfterSuite
		public void tearDownReport() {
			extent.flush();
		}
		
		@BeforeMethod
		public void setup() {
			
			log.info("Starting webdriver");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://admin-demo.nopcommerce.com/");
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			
			if(result.getStatus()== ITestResult.FAILURE) {
				
				String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
				test.fail("Test failed..", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				
			}
			
			if(driver != null) {
				log.info("Closing browser");
				driver.quit();
			}
		}
}
