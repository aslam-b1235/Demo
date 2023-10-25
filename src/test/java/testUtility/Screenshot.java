package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	public static String testProof(WebDriver driver) throws IOException
	{
		String r = System.getProperty("user.dir");
		System.out.println(r);
		
		String path = System.getProperty("user.dir")+"\\test-output\\ScreenShot\\TEST_"+System.currentTimeMillis()+".png";
		//String path = "C:\\Users\\aslam\\eclipse-workspace\\Demo\\test-output\\ScreenShot\\TEST_"+System.currentTimeMillis()+".png";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Destination = new File(path);
		
		FileHandler.copy(source, Destination);
		
		return path;
	}
}
