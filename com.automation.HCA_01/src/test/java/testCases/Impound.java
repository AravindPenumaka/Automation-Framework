package testCases;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Impound extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();

	@Test
	public void Impound_Raising_ImpoundSR_Retail_006_01() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"true");
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login","CRM_RecoveryDepartment");
		appFunc.serviceRequest_func.fillCloseServiceRequestImpound(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"false");
		appFunc.logout_func.logOutCRM();
	
	}
	
	@Test
	public void Impound_Verify_ImpoundSR_013() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Impound", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}
	

	@Test
	public void Impound_Verify_AbandonSR_019() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
			
	}
	
	@Test
	public void Impound_Verify_ExistingImpoundCondition_CloseImpoundSR_020() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
			
	}
	
	@Test
	public void Impound_Verify_Not_Allow_Chargeoff_SmallBalanceWaiver_Account_028() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
			
	}
	
	@Test
	public void Impound_Verify_Not_Allow_Chargeoff_During_ChargeOff_Hold_Account_029() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
			
	}
	@Test
	public void Impound_Raising_ImpoundSR_Retail_006_02() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"true");
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login","CRM_RecoveryDepartment");
		appFunc.serviceRequest_func.fillCloseServiceRequestImpound(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"false");
		appFunc.logout_func.logOutCRM();
	
	}

	@Test
	public void Impound_Raising_ImpoundSR_HCA_Coll_Lien_Lease_ControlMjob_005_01() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
	
	}
	
	@Test
	public void Impound_VerifyImpoundApplication_RetailAccount_005_04() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"true");
		//appFunc.serviceRequest_func.verifyServiceRequestTable(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login","CRM_RecoveryDepartment");
		appFunc.serviceRequest_func.fillCloseServiceRequestImpound(data);
		appFunc.logout_func.logOutCRM();
	}
	
	@Test
	public void Impound_VerifyImpoundApplication_LeaseAccount_005_03() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"true");
		//appFunc.serviceRequest_func.verifyServiceRequestTable(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login","CRM_RecoveryDepartment");
		appFunc.serviceRequest_func.fillCloseServiceRequestImpound(data);
		appFunc.logout_func.logOutCRM();
	}


	@Test
	public void Impound_Verify_Impound_Application_005_021() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Impound",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillImpoundDetails(data);
		appFunc.fraud_func.submitClaimAndGetSR(data);
		appFunc.serviceRequest_func.moveToLegal();
		appFunc.serviceRequest_func.verifyFinancialAccountCondition(data,"true");
	}
}

