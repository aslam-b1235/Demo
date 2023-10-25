package testPack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.Screenshot;
import testUtility.StaticBrowser;

public class BaseClass 
{
	static WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extents;
	public static ExtentTest logger;
	@Parameters({"browser"})
	
	@BeforeTest
	public void setUp(String browser)
	{
		driver = StaticBrowser.launchBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		report = new ExtentReports();
		
		extents = new ExtentHtmlReporter("test-output//Report/"+System.currentTimeMillis()+".html");
		
		report.attachReporter(extents);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void testSnap(ITestResult result) throws IOException
	
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			String path = Screenshot.testProof(driver);
		
		
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
