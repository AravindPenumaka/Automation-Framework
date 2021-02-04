package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Bankruptcy  extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	//1
	//modify on 6/21/2019
	@Test
	public void Bankruptcy_Verify_BKSR_Chapter7_Primary_Customer_002() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
	}
	//2
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_BothPrimary_SecondaryChapter7_004() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
	}
	//3
	//modify on 6/21/2019
	@Test
	public void Bankruptcy_Peripheral_VerifyBKChapter11_ForPrmaryCustomer_006() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
	}
	//4
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_BothPrimary_SecondaryChapter11_009() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
		
	}
	//5
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_PrimaryChapter11_SecondaryChapterOtherThan7_010() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.logout_func.logOutCRM();
		
	}
//6
	//modified on 6/21/2019
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSRChapter12_ForPrimaryCustomer_12_012() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
	}
	//7
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_PrimaryChapter12_SecondaryChapterOtherThan7_015() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
	}
	//8
	//modified on 6/21/2019
	@Test
	public void Bankruptcy_Peripheral_VerifyBKChapter13_ForPrimaryCustomer_017() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
		}
	//9
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_BothPrimary_SecondaryChapter13_019() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
		
	}
//10
	@Test
	public void Bankruptcy_Peripheral_VerifyBKSR_PrimaryChapter13_SecondaryChapterOtherThan7_020() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_CollectionSupervisor");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Primary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsBankruptcy(data,"Secondary");
		appFunc.serviceRequest_func.verifyFinancialAccountConditionThirdLevelView(data,"true");
		appFunc.logout_func.logOutCRM();
		
	}
	
	// 11
	@Test
	public void Bankruptcy_Application_VerifyBKSR_Chapter7_001() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
	}

	// 12
	@Test
	public void Bankruptcy_Application_Verify_BKSR_PrimaryChapter11_SecondaryOtherThanChapter7_010()
			throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);

	}

	// 13
	@Test
	public void Bankruptcy_Application_Verify_BKSR_PrimaryChapter12_SecondaryOtherThanChapter7_015()
			throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);

	}

	@Test
	public void Bankruptcy_Application_Verify_BKSR_PrimaryChapter13_017() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.srchCont_func.fillContractSearch(data);
		appFunc.searchAccCond_func.verifyAccountCondition(data);
		
	}

	@Test
	public void Bankruptcy_VerifyBKChapter7_061() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter11_070() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter12_075() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter13_079() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter7_081() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter7_084() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	@Test
	public void Bankruptcy_VerifyBKChapter12_091() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections", "Global Events");
		appFunc.globalEvents_func.createNewBKCase(data);
		appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}

	// 15
	@Test
	public void Bankruptcy_Application_VerifyBKSRPrimaryChapter7_SecondaryOtherThanChapter7_105() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data, "Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data, "Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data, "Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data, "Secondary");

	}

	// 16
	@Test
	public void Bankruptcy_Application_VerifyBKSR_Chapter11_106() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data, "Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data, "Primary");

	}
	
	
	@Test
	public void Bankruptcy_VerifyBKChapter7_021() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);
	}
	
	@Test
	public void Bankruptcy_VerifyBKChapter7_024() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}
	@Test
	public void Bankruptcy_VerifyBKChapter7_025() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);


	}
	@Test
	public void Bankruptcy_VerifyBKChapter11_030() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);
	}
	@Test
	public void Bankruptcy_VerifyBKChapter12_031() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);
	}
	@Test
	public void Bankruptcy_VerifyBKChapter13_038() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);


	}
	@Test
	public void Bankruptcy_VerifyBKChapter13_039() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);


	}
	@Test
	public void Bankruptcy_VerifyBKChapter13_040() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}
	@Test
	public void Bankruptcy_VerifyBKChapter11_047() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}
	@Test
	public void Bankruptcy_VerifyBKChapter12_051() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);


	}
	@Test
	public void Bankruptcy_VerifyBKChapter13_056() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	    appFunc.homeScreen_func.clickMenuListItem("Collections","Global Events");
	    appFunc.globalEvents_func.createNewBKCase(data);
	    appFunc.globalEvents_func.verifyBankoScreenNumber(data);

	}
	//Added on 5/30/2019
	@Test
	public void Bankruptcy_Application_VerifyBKSR_BothPrimary_SecondaryChapter12_114() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data, "Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data, "Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data, "Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data, "Secondary");
		
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyBKSR_PrimaryChapter13_117() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyBKSR_PrimaryChapter7_122() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyBKSR_SecondaryChapter11_128() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");					
	}
	
	@Test
	public void Bankruptcy_Application_VerifyBKSRPrimaryChapter12_SecondaryOtherThanChapter7_135() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyBKSRPrimaryChapter13_SecondaryOtherThanChapter7_140() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}
	@Test
	public void Bankruptcy_Application_VerifyDischargedBKSRBothPrimary_SecondaryChapter7_144() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}

	@Test
	public void Bankruptcy_Application_VerifyDischargedBKSR_PrimaryChapter11_147() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	@Test
	public void Bankruptcy_Application_VerifyDischargedBKSR_PrimaryChapter12_SecondaryOtherThanChapter7_155() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyDischargedBKSRChapter13_156() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyDismissedBKSRChapter7_161() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyDismissedBKSRChapter11_167() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyDismissedBKSR_SecondaryChapter12_173() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyDischargedBKSR_PrimaryChapter13_SecondaryOtherThanChapter7_180() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");

	}
	@Test
	public void Bankruptcy_Application_VerifyNotBKSR_PrimaryChapter7_SecondaryOtherThanChapter7_185() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");

	}
	
	@Test
	public void Bankruptcy_Application_VerifyNotBKSR_BothPrimary_SecondaryChapter11_189() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");

	}
	
	@Test
	public void Bankruptcy_Application_VerifyNotBKSR_SecondaryChapter12_193() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyNotBKSR_Chapter13_196() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		
	}
	
	@Test
	public void Bankruptcy_Application_VerifyNotBKSR_PrimaryChapter13_SecondaryOtherThanChapter7_200() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("Bankruptcy",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.fillDetailsBankruptcy(data,"Primary");
		appFunc.actors_func.fillDetailsBankruptcy(data,"Secondary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Primary");
		appFunc.bankcruptcy_func.navigateBankruptcyListPageAndVerifyModeValue(data,"Secondary");

	}

}
