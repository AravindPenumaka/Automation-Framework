package Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ExcelUtility.getExcelData;
import Objects.ObjConnect;

public class LoginPage extends Reusables.Keywords {
	ObjConnect ob = new ObjConnect();

	public void LoginintoApplication(String User) throws Exception {

		List<String> result = new ArrayList<String>();
		HashMap<String, String> Usercred = new getExcelData().getLoginInfo(User);
		result.add(enterText(ob.loginobj.HRMUserName, Usercred.get("UserName"), "Username"));
		result.add(enterText(ob.loginobj.HRMPassword, Usercred.get("Password"), "Password"));
		result.add(click(ob.loginobj.HRMLogin, "Login Button"));
		addReport(result, "Login Application");
	}

}
