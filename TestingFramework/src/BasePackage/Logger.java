package BasePackage;

import org.testng.Reporter;

public class Logger {
	
	public void addLog(String msg,String... errStack) {
		
		Reporter.log(msg);
		if(errStack.length!=0) {
			Reporter.log(errStack[0]);
		}
	}

}
