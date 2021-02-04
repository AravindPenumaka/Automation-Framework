package testCases;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;


public class Suspense2 extends BaseTestSuite {
	
	public BasePageData basePagedata; 
	
	
	@Test
	public void Suspense_Account_InHold() throws Throwable{

		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.fillCollectionGlobalEventListDetails();
	}
	
}
