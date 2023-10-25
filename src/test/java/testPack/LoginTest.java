package testPack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomPack.LogInPOM;
import testUtility.FetchData;

public class LoginTest extends BaseClass
{
	LogInPOM login;
	
	@BeforeClass
	public void beforeClass()
	{
		login = new LogInPOM(driver);
	}
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
	@Test
	public void verifyLogIn() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger = report.createTest("verifying login ");
		
		SoftAssert s = new SoftAssert();
		
		login.sendUserName(FetchData.testData(0, 0));
		
		login.sendPwd(FetchData.testData(0, 1));
		
		login.clickLogIn();
		
		Thread.sleep(1500);
		
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		String CurrentURL = driver.getCurrentUrl();
		
		s.assertEquals(CurrentURL, ExpectedURL);
		
		s.assertAll();
		
		logger.pass("test case is pass");
	}
	
	@Test
	public void verifyForLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger = report.createTest("verifyForLogin");
		
		SoftAssert s = new SoftAssert();
		
		login.sendUserName(FetchData.testData(2, 0));
		
		login.sendPwd(FetchData.testData(2, 1));
		
		login.clickLogIn();
		
		Thread.sleep(1500);
		
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		String CurrentURL = driver.getCurrentUrl();
		
		s.assertEquals(CurrentURL, ExpectedURL);
		
		s.assertAll();
		
		logger.pass("Test case is pass");
		
	}
	
	@Test
	public void verifySuccessfulLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger = report.createTest("verifySuccessfulLogin");
		
		SoftAssert s = new SoftAssert();
		
		login.sendUserName(FetchData.testData(3, 0));
		
		login.sendPwd(FetchData.testData(3, 1));
		
		login.clickLogIn();
		
		Thread.sleep(1500);
		
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		String CurrentURL = driver.getCurrentUrl();
		
		s.assertEquals(CurrentURL, ExpectedURL);
		
		s.assertAll();
		
		logger.pass("Test case is pass");
	}
	@AfterClass
	public void afterclass()
	{
		//driver.close();
	}
}
