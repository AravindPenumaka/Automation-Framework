package TestCases;

import org.testng.annotations.Test;

import Reusables.Keywords;

public class Login extends Keywords{
	
	AllPageRef page = new AllPageRef();
	
	@Test
	public void LoginIntoApplication(){
		
		openURL("URL1");
		page.LoginPage.Login();
	}

}
