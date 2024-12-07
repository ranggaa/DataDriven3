package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.AddEmp;
import config.Base;
import utilities.ExcelFileUtil;

public class AppTest extends Base{
String inputpath ="./FileInput/Employee.xlsx";	
String outputpath ="./FileOutput/DataDrivenResults.xlsx";
ExtentReports reports;
ExtentTest logger;
String TCSheet ="EmpData";
@Test
public void startTest() throws Throwable
{
	//define path of html report into target folder
	reports = new ExtentReports("./target/reports/AddEmp.html");
	//create reference object for excel file util class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows in TCSheet
	int rc = xl.rowCount(TCSheet);
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		//start test here
		logger=reports.startTest("Validate Add Emp");
		logger.assignAuthor("Ranga");
		//read all cells from TCSheet
		String Fname =xl.getCellData(TCSheet, i, 0);
		String mname = xl.getCellData(TCSheet, i, 1);
		String Lname = xl.getCellData(TCSheet, i, 2);
		logger.log(LogStatus.INFO, Fname+"    "+mname+"    "+Lname);
		AddEmp emp = PageFactory.initElements(driver, AddEmp.class);
		boolean res =emp.verifyEmp(Fname, mname, Lname);
		if(res)
		{
			//if res is true write as pass into status cell
			xl.setCellData(TCSheet, i, 3, "Pass", outputpath);
			logger.log(LogStatus.PASS, "Add Employee Success");
		}
		else
		{
			//if res is false write as Fail into status cell
			xl.setCellData(TCSheet, i, 3, "Fail", outputpath);
			logger.log(LogStatus.FAIL, "Add Employee Fail");
		}
		reports.endTest(logger);
		reports.flush();
	}
}
}










