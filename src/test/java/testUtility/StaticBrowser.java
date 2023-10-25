package testUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticBrowser 
{	
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browser, String URL)
	{
		if ( browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}
		else if ( browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		else if ( browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		return driver;
	}
}
