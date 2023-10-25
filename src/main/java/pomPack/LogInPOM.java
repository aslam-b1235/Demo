package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPOM 
{	
	WebDriver driver;
	@FindBy(xpath="//div//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//div//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement button;
	
	public LogInPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendUserName(String name)
	{
		username.sendKeys(name);
	}
	
	public void sendPwd(String pd)
	{
		password.sendKeys(pd);
	}
	
	public void clickLogIn()
	{
		button.click();
	}
}
