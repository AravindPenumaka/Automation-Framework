package Pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import ExcelDataUtil.excelDataManager;
import Objects.ObjConnect;
import Reusables.Reusables;

public class LoginPage extends Reusables{
	
	public ObjConnect obj = new ObjConnect();
	
	
	public void LoginintoApplication(WebDriver driver,String User) throws Exception {
		
		HashMap<String,String> Usercred = new excelDataManager().getLoginInfo(User);
		openURL(driver);
		entertext(driver, obj.Loginobj.UsernameorNumber,Usercred.get("UserName"), "Phone Number");
		entertext(driver, obj.Loginobj.Passowrd, Usercred.get("Password"), "Password");
		click(driver, obj.Loginobj.Submit,"Submit Button");
		click(driver, obj.Loginobj.Close, "Close button");
	}

}
