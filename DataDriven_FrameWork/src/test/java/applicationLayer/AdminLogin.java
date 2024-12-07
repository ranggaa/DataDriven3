package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
//define Repository for login
	@FindBy(name="txtUsername")
	WebElement ObjUser;
	@FindBy(name="txtPassword")
	WebElement ObjPass;
	@FindBy(id="btnLogin")
	WebElement ObjLogin;
	//write a method
	public void verifyLogin(String user,String pass)
	{
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		
		ObjLogin.click();
	}
	
	
	
}
