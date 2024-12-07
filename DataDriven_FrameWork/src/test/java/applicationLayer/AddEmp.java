package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
	WebDriver driver;
public 	AddEmp(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "//b[normalize-space()='PIM']")
WebElement ObjPim;
@FindBy(name="btnAdd")
WebElement ObjAdd;
@FindBy(name="firstName")
WebElement ObjFname;
@FindBy(name="middleName")
WebElement ObjMname;
@FindBy(name="lastName")
WebElement ObjLname;
@FindBy(name="employeeId")
WebElement ObjEID;
@FindBy(id="btnSave")
WebElement ObjSave;
@FindBy(name = "personal[txtEmployeeId]")
WebElement ObjId;
public boolean verifyEmp(String ObjFname,String MiddleName,String Lastname)throws Throwable
{
	Actions ac = new Actions(driver);
	ac.moveToElement(ObjPim).click().perform();
	Thread.sleep(2000);
	ac.moveToElement(ObjAdd).click().perform();
	Thread.sleep(2000);
	this.ObjFname.sendKeys(ObjFname);
	ObjMname.sendKeys(MiddleName);
	ObjLname.sendKeys(Lastname);
	String Exp_Data = ObjEID.getAttribute("value");
	ac.moveToElement(ObjSave).click().perform();
	Thread.sleep(2000);
	String Act_data =ObjId.getAttribute("value");
	if(Act_data.equals(Exp_Data))
	{
		return true;
	}
	else
	{
		return false;
	}
	
}
}










