package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;
import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Fraud extends BaseTestSuite {

	BasePageData basePageData = new BasePageData();

	@Test
	public void Fraud_VerifyConsumerIdentityTheft_TC005() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		//appFunc.fraud_func.closeSR();
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}

	@Test
	public void Fraud_TypeTitleWashing_017() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}

	
	@Test
	public void Fraud_TypeSynIdentityFraud_020() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login","CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}

	//out of scope
	/*@Test
	public void Fraud_VerifyUpdatedFraudCondition_TC045() throws Throwable{

		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Fraud",getMethod());
		appFunc.fraud_func.searchAccountNumAndEnter("Fraud",getMethod());
		appFunc.fraud_func.fraudNewServiceRequestAndContinue("Fraud",getMethod());
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.fraud_func.retriveAndClickAssignToMe("Fraud",getMethod());
		appFunc.fraud_func.confirmFraud();
		appFunc.fraud_func.closeSR();
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch("Fraud",getMethod());
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}*/

	@Test
	public void Fraud_VerifyDealerMisrepresentation_001() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();
	}
	
	
	
	
	@Test
	public void Fraud_Validate_Status_SynIdentityFraud_Sumbmitted_CRM_001() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_PaymentFraud_Sumbmitted_CRM_002() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_FraudRing_Sumbmitted_CRM_003() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_DealerMisrepresentation_Sumbmitted_CRM_005() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_TitleWashing_Cancelled_CRM_010() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_DealerMisrepresentation_Cancelled_CRM_011() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}
	
	@Test
	public void Fraud_Validate_Status_ConsumerIdentityTheft_Cancelled_CRM_012() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_Syntheticidentityfraud_Confirmed_CRM_013() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Verify_Status_PaymentFraud_Confirmed_014() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}
	
	@Test
	public void Fraud_Validate_Status_VictimOfConsumerIdentityTheft_018() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		appFunc.srchCont_func.updateAttachedActorStatus(data);
		
		
	}
	
	@Test
	public void Fraud_SwapRoleOf_NonPrimary_ToPrimaryCustomer_ConsumerIdentityTheft_019() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		appFunc.srchCont_func.changeAssignedActors(data);
		appFunc.searchAccCond_func.verifyAccountConditionEndDated(data);
	}
	
	@Test
	public void Fraud_Secondary_Customer_Victim_ConsumerIdentityTheft_020() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		appFunc.srchCont_func.updateAttachedActorStatus(data);
		//Step  10 is pending as element not found in the UI with the data
		
	}
	
	@Test
	public void Fraud_Primary_Customer_Victim_ConsumerIdentityTheft_021() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.srchCont_func.verifyAttachedActorsTable(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		//Step 6 and Step 9 is pending
		appFunc.srchCont_func.changeAssignedActors(data);
		//Step  12 is pending as element not found in the UI with the data
		
	}
	
	@Test
	public void Fraud_Primary_Secondary_Customer_Victim_ConsumerIdentityTheft_022() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		appFunc.srchCont_func.updateAttachedActorStatus(data);
		//Step  11 is pending as element not found in the UI with the data
		
	}
	
	@Test
	public void Fraud_FraudelentDisputeContract_SyntheticID_023() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

		
	}
	
	@Test
	public void Fraud_FraudelentDisputeContract_PaymentFraud_024() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

		
	}
	
	
	@Test
	public void Fraud_FraudelentDisputeContract_FraudRing_025() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

		
	}
	
	@Test
	public void Fraud_FraudelentDisputeContract_TitleWash_026() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

		
	}
	
	@Test
	public void Fraud_FraudelentDisputeContract_Misrepresentation_027() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

	}
	
	@Test
	public void Fraud_FraudelentDisputeContract_ConsumerIDTheft_028() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.confirmFraud(data);
		appFunc.fraud_func.closeSR();

	}
	
	@Test
	public void Fraud_TransferOfEquityFraudCondition_029() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.verifyFraudFlag(data);
	}
	
	@Test
	public void Fraud_TransferOfEquityFraudCondition_030() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.verifyFraudFlag(data);
	}
	
	@Test
	public void Fraud_SwappedFraudCondition_031() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.verifyFraudFlag(data);
	}
	
	@Test
	public void Fraud_CancelFraudFraudCondition_FraudRing_033() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Fraud",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.fraud_func.selectFraudTypeAndSubmitClaim(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.fillLoginCRM("Login", "CRM_OwnerLogin");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.DeclineFraudandVerifyAccountCondition(data);
		//appFunc.fraud_func.closeSR();
	}
}
