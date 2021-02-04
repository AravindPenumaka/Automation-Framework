package testFunctionality;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;


public class ChromeTest2 extends BaseTestSuite {
	
	public BasePageData basePagedata; 
	
	
	@Test
	public void SuspenseApprove_SR_Lease() throws Throwable{
		
//		basePagedata.Suspense("Suspense", "SuspenseApprove_SR_Lease");
//		String from = Login.get("Amount");
		/*appFunc.login_func.testURl();
		appFunc.login_func.login("9692387420", "1013191034");*/
//		appFunc.login_func.testURl();
		appFunc.login_func.fillLoginKSIOP("Suspense",getMethod());
			
	}
	
	/*@Test
	public void SuspenseApprove_SR_Balloon() throws Throwable{
		
//		basePagedata.Suspense("Suspense", "SuspenseApprove_SR_Lease");
//		String from = Login.get("Amount");
		appFunc.login_func.testURl();
		appFunc.login_func.login("9692387420", "1013191034");
		appFunc.login_func.testURl();
		appFunc.login_func.fillLogin("Suspense",getMethod());
			
	}*/
	
	
}
