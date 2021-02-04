package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class SanityTestCase extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	
	@Test
	public void Sanity_Actors() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Sanity",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyEventUnderActors();
		appFunc.actors_func.verifyActorTabs(data);
		appFunc.actors_func.verifyChangeTradename();
		appFunc.actors_func.verifyAddressChange();
		appFunc.actors_func.verifyChangeBankAccount();
		appFunc.actors_func.verifyInvoiceChangeModification();
		appFunc.actors_func.verifyDeArchieveActors();
		
	}
	
	
	@Test
	public void Sanity_Contract() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Sanity",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyEventUnderContracts();
		appFunc.contracts_func.copyContractAndStartPermanentLoan();
		appFunc.contracts_func.verifyStartPermanentLoan();
		appFunc.contracts_func.verifyContractsTabs(data);
		appFunc.contracts_func.verifyChangedAssignedThirdParty();
		appFunc.contracts_func.verifyDeArchieveContracts();
		appFunc.contracts_func.verifyHoldUnHoldAccounts();
	}
	
	
}