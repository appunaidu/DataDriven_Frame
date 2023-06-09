package driverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunction.Functionlibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
	String inputpath ="E:\\11oclock_Selenium\\DDT_Fromework\\FileInput\\LoginData.xlsx";
	String outputpath ="E:\\11oclock_Selenium\\DDT_Fromework\\FileOutput\\DDT_Results.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void satrtTest()throws Throwable {
	{
		//create object for excel file util
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//cont no ofrows in login sheet
		int rc =xl.rowCount("Login");
		report= new ExtentReports("./ExtenReports/Login.html");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("Validate Login");
			test.assignAuthor("Appu");
			//read username and password cell data
			String username =xl.getCellData("Login", i, 0);
			String password = xl.getCellData("Login", i, 1);
			//calling login method
			boolean res =Functionlibrary.verify_Login(username, password);
			if(res)
			{
				//if res is true write as login success into results cell
				xl.setCelldata("Login", i, 2, "Login success", outputpath);
				xl.setCelldata("Login", i, 3, "Pass", outputpath);
				test.log(LogStatus.PASS, "Login Success");
			}
			else 

			{
				File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./Screenshot/iteration/"+i+"Loginpage.png"));
				//if res is true write as login Fail into results cell
				xl.setCelldata("Login", i, 2, "Login Fail", outputpath);
				xl.setCelldata("Login", i, 3, "Fail", outputpath);
				test.log(LogStatus.FAIL, "Login Fail");
			}
			report.endTest(test);
			report.flush();

		}

	}


	}
}
























