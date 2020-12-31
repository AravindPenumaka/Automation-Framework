package Pages;

import Objects.LoginObj;
import Reusables.Keywords;

public class LoginPages extends Keywords{
	
	AllObjectRef ob = new AllObjectRef();
	
	public void Login(){
		
		if(isElementPresent(ob.loginobj.LoginWithEmail)){
			click(ob.loginobj.LoginWithEmail, "Login with email");
		}else{
			click(ob.loginobj.LoginOrCreate, "Login Or Create Account");
		}
		enterText(ob.loginobj.Username, "aravindpenumaka@gmail.com", "Email");
		click(ob.loginobj.Continue, "continue");
		enterText(ob.loginobj.password, "Ar@vind250298", "Password");
		click(ob.loginobj.Login, "Login");
		
	}

}
