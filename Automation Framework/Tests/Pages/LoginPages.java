package Pages;

import Objects.LoginObj;
import Reusables.Keywords;

public class LoginPages extends Keywords{
	
	AllObjectRef ob = new AllObjectRef();
	
	public void Login(){
		
		
		click(ob.loginobj.LoginWithEmail, "Login with email");
		enterText(ob.loginobj.Username, "aravindpenumaka@gmail.com", "Email");
		click(ob.loginobj.Continue, "continue");
		enterText(ob.loginobj.password, "Ar@vind250298", "Password");
		click(ob.loginobj.Login, "Login");
		
	}

}
