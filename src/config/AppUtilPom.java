package config;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunction.LogOutpage;
import commonFunction.LoginPage;
public class AppUtilPom 
{
	public static WebDriver driver;

	@BeforeTest
	public static void AdminLogin()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage login =PageFactory.initElements(driver, LoginPage.class);

		//call login

		login.verify_Login("Admin", "Qedge123!@#");
	}


	@AfterTest
     	
	public static void tearDown()

	{

	LogOutpage logout =PageFactory.initElements(driver, LogOutpage.class);

	logout.verify_Logout();

	driver.quit();

	}

	}
	

