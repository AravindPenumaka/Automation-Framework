package testCases;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Refund extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	
				/*Out Of scope*/
	/*@Test
	public void Refund_SelectionReverseReason_AsRefund_001() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Collections and disbursements");
		appFunc.cashFlow_func.fillRejectCollection(data);

	}*/

	@Test
	public void Refund_VerifyRefundAddressReverseAmountAccountNumberPrimaryBillingAddress_004() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);

	}

	@Test
	public void Refund_TransmissionOfTerminatedAccountsOverageToAutoRefund_013() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);		
		appFunc.cashFlow_func.fillSuspenseList(data);		

	}

	@Test
	public void Refund_TransmissionOfTerminatedAccountsOverageToAutoRefund_013_01() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);	
		appFunc.cashFlow_func.fillSuspenseList(data);		

	}

	@Test
	public void Refund_CreatesBulkAutomaticRefundRequests_027() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);	
		appFunc.cashFlow_func.fillSuspenseList(data);		

	}

	@Test
	public void Refund_KSIOPToStoreRefundResultsFromERPAndStatusOfRefundCashFlow_031() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);		
		appFunc.cashFlow_func.fillSuspenseList(data);		

	}

	@Test
	public void Refund_KSIOPToConfigureHoldDateForRefund_026_N() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);		
	}

	@Test
	public void Refund_SearchCriteriaForSearchinRefundSuspense_003() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Manual Refund");
		appFunc.cashFlow_func.verifySuspenceListFields(data);		
		appFunc.cashFlow_func.fillSuspenseList(data);		

	}

	
	@Test
	public void Refund_VerifyThatReverseReasonIsSelectedForRefund_007() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Collections and disbursements");
		appFunc.cashFlow_func.fillRejectCollection(data);	
	}
	
	
	@Test
	public void Refund_VerifyThatKSIOPIsAbleToSelectAndCreateAutomaticRefundItems_008() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Collections and disbursements");
		appFunc.cashFlow_func.fillRejectCollection(data);	
	}
	
	
	@Test
	public void Refund_VerifyThatKSIOPIsAbleToCreateBulkAutomaticRefundRequests_027_01() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Refund", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Collections and disbursements");
		appFunc.cashFlow_func.verifySuspenceListFields(data);		
		appFunc.cashFlow_func.fillSuspenseList(data);		

		
	}

		
}

