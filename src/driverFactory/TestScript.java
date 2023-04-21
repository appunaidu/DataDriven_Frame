package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunction.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtilPom{
	String Inputpath = "E:\\11oclock_Selenium\\DDT_Fromework\\FileInput\\Employee.xlsx";
	String Outputpath = "E:\\11oclock_Selenium\\DDT_Fromework\\FileOutput\\EmpResults.xlsx ";
	@Test
	public  void startTest() throws Throwable
	{
		AddEmpPage emp = PageFactory.initElements(driver, AddEmpPage.class);
		// create object for ExcellFile Util 
		ExcelFileUtil xl = new ExcelFileUtil(Inputpath);
		// count no of rows in EmpData sheet
		int rc = xl.rowCount("EmpData");
		Reporter.log("No of rows are ::"+rc,true);
         for (int i=1;i<=rc;i++)
         {
        	String FirstName = xl.getCellData("EmpData",i, 0);
        	String MiddleName = xl.getCellData("EmpData", i, 1);	
        	String LastName = xl.getCellData("EmpData",i, 2);
		
	  boolean res = emp.verify_Emp("FirstName", "MiddleName","LastName");
	  if (res)
	  {
		// write as pass into status cell
		  xl.setCelldata("EmpData", i, 3,"Pass", Outputpath);	  
	}
	  else
	  {
		
		  xl.setCelldata("EmpData", i, 3, "Fail", Outputpath);
	  }
	}
}

}









