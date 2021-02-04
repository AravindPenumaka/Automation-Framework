package testFunctionality;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import frameworkFactory.BaseTestSuite;
import functionLibrary.ApplicationFunctions;

@SuppressWarnings("unchecked")
public class ChromeTest3  extends BaseTestSuite {
	
	
	@Test
	public void TitleManagement_LienRelease_PaidOff() throws Throwable{
		
		/*driver.get("https://www.google.com/");
		appFunc.login_func.testURl();
		appFunc.login_func.login("9692387420", "1013191034");*/
		
		System.out.println("****1st Set*****");
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
			
	}
	
	/*@Test
	public void Fraud_Lease() throws Throwable{
		
		System.out.println("****2nd Set*****");
			
	}*/
	
}
