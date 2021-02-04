package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Repossession  extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	@Test
	public void Repossession_Peripheral_LienReason_001() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.repossession_func.fillRepossessionInfoandSubmit(data);
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.repossession_func.submitConditionReport(data);
		appFunc.repossession_func.fillRedemptiondeatilsandSubmit(data);
		appFunc.repossession_func.vehicleReleaseandVerifyAccountCondition(data);
	}

	@Test
	public void Repossession_Peripheral_BKReason_002() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.repossession_func.fillRepossessionInfoandSubmit(data);
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.repossession_func.submitConditionReport(data);
		appFunc.repossession_func.fillRedemptiondeatilsandSubmit(data);
		appFunc.repossession_func.vehicleReleaseandVerifyAccountCondition(data);
	}

	@Test
	public void Repossession_Peripheral_ActivePTP_025() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.repossession_func.fillRepossessionInfoandSubmit(data);
	}

	@Test
	public void Repossession_Peripheral_RetailRTC_026() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.repossession_func.fillRepossessionInfoandSubmit(data);
	}

	@Test
	public void Repossession_Peripheral_VerifyNOI_029() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.repossession_func.verifyNOI(data);
	}

	@Test
	public void Repossession_Peripheral_VerifyNOICAStateAccount_030() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.repossession_func.verifyNOI(data);
	}

	@Test
	public void Repossession_Peripheral_GenerateNOICAStateAccount_031() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionSupervisor");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.repossession_func.verifyNOI(data);
	}
	//added koyal
	
	@Test
	public void Repossession_Application_VerifyLeaseVoluntaryRepoAcountCondition_001() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	
	@Test
	public void Repossession_Application_VerifyRepositionFee_002() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
		appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.UpdateDeficiencyIndicator(data);
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
	}
	@Test
	public void Repossession_Application_VerifyVoluntaryRepoRedemptionAcountCondition_003() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	
	@Test
	public void Repossession_Application_VerifyVoluntaryRepoReinStatementAcountCondition_004() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	
	@Test
	public void Repossession_Application_VerifyRepoReinStatementClosedAcountCondition_006() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	@Test
	public void Repossession_Application_VerifyInadveratntClosedRepoAcountCondition_007() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	
	@Test
	public void Repossession_Application_VerifyRetailInvoluntaryReinstatementRepoAcountCondition_028() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	//to be automated the last step(Will be given by prasad test data)
	@Test
	public void Repossession_Application_VerifyRetailInvoluntaryRedemptionRepoAcountCondition_029() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountConditionWithGivenData(data);
	}
	//to be automated the last step(Will be given by prasad test data)
	@Test
	public void Repossession_Application_VerifyLease_GroundingDateMaturedVehicle_Voluntary_Repo_001() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
	}
	
	//to be automated the last step(Will be given by prasad test data)
	@Test
	public void Repossession_Application_VerifyBalloon_GroundingDateMaturedVehicle_Voluntary_Repo_002() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("Repossession", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
	}

}
