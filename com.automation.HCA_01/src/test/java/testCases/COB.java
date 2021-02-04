package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class COB extends BaseTestSuite {

	BasePageData basePageData = new BasePageData();

	/*Designed By Arpita*/
	/*Start----*/
	@Test
	public void COB_VerifyCustomerWithMultipleAccounts_015() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.createNewActor(data);
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);//function changed
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");//function changed
		appFunc.actors_func.validateModifiedAddress(data,"Home");//function changed
		appFunc.actors_func.validateIdentityDetails(data);//function changed
		appFunc.actors_func.fillModifyAddressDetails(data,"Billing");//function changed
		appFunc.actors_func.validateModifiedAddress(data,"Billing");//function changed
	}
	
	
	@Test
	public void COB_VerifyKSIOP_ManageCustomerInformation_020() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyCOBActorDetails();

	}
	

	@Test
	public void COB_VerifyKSIOP_ManagesSalesRelated_RolesForLoans_024() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyRoleDetails();
	}
	
	
	@Test
	public void COB_VerifyGeneral_DQProcess_076() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.task_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddress(data,"Home");
		appFunc.task_func.verifyTransactionHistory(data); //new function
	}
	
	/*End---- Arpita*/
	
	@Test
	public void COB_VerifyActorDetails_ExistingCustomer_048() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyCOBActorDetails();
	}
		
	@Test
	public void COB_CreateNewActors_ManagesDealers_027() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.navigateToActorListPage();
		appFunc.actors_func.createNewActor(data);
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddress(data,"Home");
		appFunc.actors_func.changeAndVerifyPhaseDetails(data);
		appFunc.actors_func.provideDealerNumberAndVerifyRoleDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.verifyModifiedActorTelecomInformation(data);
		appFunc.actors_func.verifyModifiedChangeRoleStatus();
		appFunc.actors_func.verifyModifiedChangeAttribute(data);
	}
	
	
	@Test
	public void COB_VerifyActorDetails_CustomerInfoValidation_056() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyCOBActorDetails();
	}
	
	
	@Test
	public void COB_VerifyActors_StoreCustomerInformation_077() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyPastEvents(data);
	}
	

	@Test
	public void COB_ActorsAllow_CustomerToModifyIncorrectDeatils_057() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyCOBActorDetails();
	}
	
	@Test
	public void COB_Verify_ExistingCustomerDetails_007() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyCOBActorDetailsLike_Indentity_Individual_Contact_Address(data);
		appFunc.actors_func.verifyRoleDetails();
	}
	
	@Test
	public void COB_Verify_CustomerDetails_Managed_HomeAddress_008() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
	
	}
	
	@Test
	public void COB_Verify_CustomerDetails_Managed_HomeAddress_As_BaseAddress_009() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddressForExistingCustomer(data,"Home");
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
	}
	
	@Test
	public void COB_Verify_Customer_DOB_BusinessOpeningDate_010() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.validateDOBAndBusinessOpeningDateOnDifferentTab();
	
	}
	
	@Test
	public void COB_Verify_InputField_For_Business_Consumer_Customer_011() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		//Here the data(Parameter) passed from excel which has been written in SVN build
		appFunc.actors_func.validateInputFieldsForBusinessConsumerCustomer(data,"BusinessCustomerActorID");
		appFunc.actors_func.validateInputFieldsForBusinessConsumerCustomer(data,"ConsumerCustomerActorID");
	}
	
	@Test
	public void COB_Verify_CustomerRoles_Loans_023() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyRoleDetails();
		appFunc.actors_func.verifyCustomerRoleDetails();
		
	}
	
	@Test
	public void COB_Verify_CompanyOrganizationRoles_Loans_025() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifyRoleDetails();
		appFunc.actors_func.verifyCustomerRoleDetails();
		
	}
	
	@Test
	public void COB_Verify_LegalClassification_Vendor_026() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyIdentityTabLegalClassificationTextbox(data);
		
	}
	
	//this 45 and 46 test cases are same as 008
	@Test
	public void COB_Verify_ExistingCustomerDetails_Managed_HomeAddress_045() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
	
	}
	
	@Test
	public void COB_Verify_UpdatingCustomerDetails_Managed_HomeAddress_046() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
	
	}
	
	
	//same as test case 77
	@Test
	public void COB_Verify_ImpItems_ChangeHistory_078() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("COB", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyPastEventsData(data);
	}
	//Need to write code for few As unavailability of screenshotfor test case 14
	
	@Test
	public void COB_Verify_MultipleAccount_Consistant_PII_014() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("COB", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyLastName(data,data.get("LastName"));
		appFunc.actors_func.fillChangeTradename(data);//function changed
		appFunc.actors_func.verifyLastName(data,data.get("LastName2"));
		appFunc.customerInfoChange_func.changeAssetAddress(data);
		appFunc.customerInfoChange_func.verifyRecapInformation(data);
		appFunc.asset_Func.verifyAssetAddressChange(data);
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyPastEventsData(data);

	}
	
	@Test
	public void COB_Verify_ExistingCustomerDetails_ModifiedAddress_047() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.verifySpecifiedAddressDetails(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddress(data,"Home");
	
	}
	
	@Test
	public void COB_Verify_DataSteward_WithWrongAddress_071() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
	
	}
	
	@Test
	public void COB_Verify_ModifyAddress_DataSteward_DQProcess_074() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddress(data,"Home");
		appFunc.task_func.verifyTransactionHistory(data);
		appFunc.homeScreen_func.searchActorCode(data); 
		appFunc.actors_func.clickPastEventTab();
	
	}
	
	//Scripting Done but will fail as has a defect(1503)
	@Test
	public void COB_Verify_ModifyAddress_DataSteward_DQProcess_075() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.clickPastEventTab();
		appFunc.actors_func.verifyPastEventsData(data);
		appFunc.actors_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
	
	}
	
	@Test
	public void COB_Verify_ModifyAddress_DQTransactionProcess_070() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data,"Home");
		appFunc.actors_func.validateModifiedAddress(data,"Home");
		appFunc.task_func.verifyTransactionHistory(data);
	
	}
	
	@Test
	public void COB_Verify_CustomerInfoChange_CPC_016() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("COB",getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchReferenceActorCodeActorPage(data);
		appFunc.actors_func.verifyCOBActorDetailsLike_Indentity_Individual_Contact_Address(data);
		appFunc.actors_func.verifyPrivacy_GLB_Information_AssentTab(data);
	}
	

}
