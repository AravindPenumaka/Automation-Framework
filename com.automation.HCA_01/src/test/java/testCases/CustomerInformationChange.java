package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class CustomerInformationChange extends BaseTestSuite{
	
	BasePageData basePageData = new BasePageData();
	
	@Test
	public void CustomerInformationChange_CustomerInformationIntegration_007() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}

	
	@Test
	public void CustomerInformationChange_CustomerInformationIntegration_012() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	
	@Test
	public void CustomerInformationChange_CRM_CustomerIntegration_AddressValidation_014() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_VerifyKSIOPAddressChange_UsingCurrentAndFutureDate_058() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateModifiedAddress(data, "Home");//function chang
		appFunc.actors_func.verifyLastName(data,data.get("LastName"));
		appFunc.actors_func.fillChangeTradename(data);//function changed
		appFunc.actors_func.verifyLastName(data,data.get("LastName2"));
		appFunc.customerInfoChange_func.changeAssetAddress(data);
		appFunc.customerInfoChange_func.verifyRecapInformation(data);
		appFunc.asset_Func.verifyAssetAddressChange(data);
	}
	

	@Test
	public void CustomerInformationChange_VerifyTaxAmount_WhenGarageAddressIsChanged_059() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateModifiedAddress(data,"Home");//function chang
	}
	
				/*Out Of Scope*/
	/*@Test
	public void CustomerInformationChange_CustomerDataManagement_061() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.fillAddressChangeValue();
	}*/
	
	
	@Test
	public void CustomerInformationChange_ModifyAddressValidation_062() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.customerInfoChange_func.changeAssetAddress(data);
		appFunc.customerInfoChange_func.verifyRecapInformation(data);
		appFunc.customerInfoChange_func.verifyModifiedAddress(data);
	}
	
	@Test
	public void CustomerInformationChange_VerifyDemoChangeMethod_060() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyActorDetails();
	}
	
	
	@Test
	public void CustomerInformationChange_VerifyDataStewardAndModfyData_071() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.task_func.searchReferenceActorCode(data);
		appFunc.task_func.verifyTaskDetails();
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateIdentityDetails(data);
		appFunc.actors_func.fillModifyAddressDetails(data, "Home");
	}
	
	
	@Test
	public void CustomerInformationChange_VerifyCompleteCustomerInformation_ChangesKSIOP_091() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.verifyPastEvents(data);//function changed
	}
	
	
	@Test
	public void CustomerInformationChange_CRM_ChangeName_PendingDocument_096() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	//changes in steps
	@Test
	public void CustomerInformationChange_CRM_ChangeName_ReceivingDocument_097() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillNameChange(data);//new function
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.customerInfoChange_func.verifyNameChange(data);				
	}
	
	
	
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_008() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	
	
	
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_009() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_010() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_011() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);	
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_012() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);	
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_013_N() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_015() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_016() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_017() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_018() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}

	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_019() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.OverrrideAddress(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_020() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_021() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_022() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_023() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}

	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_024_N() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_025() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_026() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}

	@Test
	public void CustomerInformationChange_CRM_customerInformationCRMScreenOverride_027() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
	}
	
	
	/*Blocked in ALM
	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_039() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
	}*/

	@Test
	public void CustomerInformationChange_CRM_customerInformationintegrationKSIOP_040() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerNameChangeintegrationKSIOP_098() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRM_customerNameChangeintegrationKSIOP_100() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
	}
	
	@Test
	public void CustomerInformationChange_CRMToKsiopIntegration_039() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_WebURL();
		appFunc.login_func.fillWebLoginDetails("Login", "Web_Login");
		appFunc.web_func.editWebAddressDetails(data);
		appFunc.web_func.logOutHMF();
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.verifyAddressChange(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.searchActorCode(data);
		appFunc.actors_func.validateModifiedAddressForExistingCustomer(data,"Home");

		
	}
}
