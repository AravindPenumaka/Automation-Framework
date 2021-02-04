package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Suspense extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	
	@Test
	public void Suspense_Account_InHold() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Suspense",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.chngAccCond_func.enterChangeAccountCondition(data);
	}
	
	@Test
	public void Suspense_AllowPaymentsToAccounts_IdentifiedAsDirectPay_033() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Suspense",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.cashFlow_func.createWaterfallPayment(data);
	}
	
	//may
	
	@Test
	public void Suspense_CreateLeaseOverPayment_ActiveLeaseAccount_001() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Suspense",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.cashFlow_func.createWaterfallPayment(data);
	}
	
	@Test
	public void Suspense_AllowPayment_ToPostToLeagalAccounts_031() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Suspense",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.chngAccCond_func.enterChangeAccountCondition(data);
		appFunc.cashFlow_func.createWaterfallPayment(data);
		appFunc.homeScreen_func.searchContractCode(data);
		appFunc.contracts_func.verifyPaymentSchedule();

	}
	
	@Test
	public void Suspense_Account_StopPayment_29() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Suspense",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.chngAccCond_func.enterChangeAccountCondition(data);
		appFunc.searchAccCond_func.verifyAccountConditionPaymentHold(data);
		
	}
	
	
	@Test
	public void Suspense_Account_InHold_30() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Suspense", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.chngAccCond_func.enterChangeAccountCondition(data); //function changed
		appFunc.searchAccCond_func.verifyAccountConditionPaymentHold(data);
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.cashFlow_func.createWaterfallPayment(data);
	}
}
