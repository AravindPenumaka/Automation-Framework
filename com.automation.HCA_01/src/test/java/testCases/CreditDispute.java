package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class CreditDispute extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	@Test
	public void CreditDispute_DirectDisputeScreen_026() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifyAuditTrailTable();
		appFunc.creditDispute_func.verifyCreditDisputeFields(data);
	}
	
	@Test
	public void CreditDispute_DirectOverRideData_024() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifyCreditDisputeTableData(data.get("CreditDisputeTableName"));
		//steps  need to be added ticking the checkbox
	}
	
	@Test
	public void CreditDispute_DirectCBReport_028() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifySpecifiedItems(data);
		
		//added
		appFunc.creditDispute_func.verifyDelinquencyCountersTables(data);
		appFunc.creditDispute_func.verifyPHPSection(data);
		//..
		appFunc.creditDispute_func.verifyEcoaValDropdownValues(data);
	}
	
	@Test
	public void CreditDispute_DirectDisputeScreen_026_1() throws Throwable{

		HashMap<String, String> data= basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifyAuditTrailTable();
		appFunc.creditDispute_func.verifyCreditDisputeFields(data);
		//modified
		appFunc.creditDispute_func.verifyPHPSection(data);
		appFunc.creditDispute_func.verifyDelliquencyTableData(data.get("DelliquencyTableName"));
	}
	
	@Test
	public void CreditDispute_DirectValidate_027() throws Throwable{
		
		HashMap<String, String> data= basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifySpecifiedItems(data);
		appFunc.creditDispute_func.checkEcoaVal(data);
	}
				/*out of scope*/
	/*@Test
	public void CreditDispute_DirectPermissions_030() throws Throwable{

		HashMap<String, String> data= basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Contracts", "Credit Dispute");
		//unauthorised access
	}
	
	
	@Test
	public void CreditDispute_DirectPermissions_030_1() throws Throwable{

		HashMap<String, String> data= basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Contracts", "Credit Dispute");
		//unauthorised access
	}*/
	
	@Test
	public void CreditDispute_DirectFinalCBReport_035() throws Throwable{
		
		HashMap<String, String> data= basePageData.fetchInputData("CreditDispute",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.creditDispute_func.searchCreditDisputeAccountDetails(data);
		appFunc.creditDispute_func.verifySpecifiedItems(data);
		//cbreport file validate
	}
}
