package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogOutpage {
	@FindBy(xpath = "//a[@id='welcome']")
	public static WebElement clickwelcome;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	 public static WebElement clicklogout;
	public static void verify_Logout()
	
	{
	
		clickwelcome.click();
		clicklogout.click();
	}

}



