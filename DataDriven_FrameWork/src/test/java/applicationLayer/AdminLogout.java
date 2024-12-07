package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath = "//a[@id='welcome']")
WebElement ObjWelCome;
@FindBy(xpath = "//a[normalize-space()='Logout']")
WebElement ObjLogout;
public void verifyLogout() throws Throwable
{
	ObjWelCome.click();
	Thread.sleep(2000);
	ObjLogout.click();
}

}
