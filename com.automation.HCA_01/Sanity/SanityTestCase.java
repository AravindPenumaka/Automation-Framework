package testCases;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

public class SanityTestCase extends BaseTestSuite {
	
	public BasePageData basePagedata; 
	
	
	@Test
	public void Sanity_Actors() throws Throwable{

		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchActorId("Sanity",getMethod());
		appFunc.actors_func.verifyEventUnderActors();
		appFunc.actors_func.verifyActorTabs("Sanity",getMethod());
		appFunc.actors_func.verifyChangeTradename();
		appFunc.actors_func.verifyAddressChange();
		appFunc.actors_func.verifyChangeBankAccount();
		appFunc.actors_func.verifyInvoiceChangeModification();
		appFunc.actors_func.verifyDeArchieveActors();
		
	}
	
	
}