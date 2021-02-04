package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class InvoiceCenterManagement extends BaseTestSuite{

	BasePageData basePageData = new BasePageData();

	@Test
	public void InvoiceCenterManagement_CheckBillingUnit_008() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");	
	    appFunc.actors_func.searchActorId(data);
	    appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
	    appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterSubstitution();
	    appFunc.invoiceCenterMgmt_func.updateTargetBAOption(data);
	}
	
	@Test
	public void InvoiceCenterManagement_GenerateBillingStatement_009() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
	    appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
	    appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
	    appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
	    appFunc.invoiceCenterMgmt_func.checkOrUncheckBillingUnitCheckbox();
	    //appFunc.invoiceCenterMgmt_func.navigateToTaskScreen();
	}
	
	@Test
	public void InvoiceCenterManagement_CheckConsolidatedBillingUnit_016() throws Throwable{
	  
	  	HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
		appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
		appFunc.invoiceCenterMgmt_func.checkOrUncheckBillingUnitCheckbox();
	}
	
	@Test
	public void InvoiceCenterManagement_UncheckConsolidatedBillingUnit_018() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
		appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
	 
	}
	@Test
	public void InvoiceCenterManagement_CreateNewAddress_014() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
    	appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
		appFunc.invoiceCenterMgmt_func.fillAddressDetails(data);
	 
	}
	
	@Test
	public void InvoiceCenterManagement_VerifyTheAddressForTheCustomerInKSIOP_015_N() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.invoiceCenterMgmt_func.verifyAssetAddressTab(data);
		
		
	}
	
	@Test
	public void InvoiceCenterManagement_VerifyAlternateRecipientAddressIsAssignedForActiveBankruptcyAccounts_016_01() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("CustomerInformationChange", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.customerInfoChange_func.retreiveCustomerAccountDetails(data);
		appFunc.customerInfoChange_func.selectServiceRequestType(data);
		appFunc.customerInfoChange_func.clickOnContactInfo();
		appFunc.customerInfoChange_func.fillandValidateAddressDetails(data);
		appFunc.customerInfoChange_func.fillCustomerDetails(data);
		appFunc.logout_func.logOutCRM();
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.invoiceCenterMgmt_func.verifyAssetAddressTab(data);
		
	}
	
	@Test
	public void InvoiceCenterManagement_CheckConsolidatedBillingUnitforCVF_017() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
		appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
		appFunc.invoiceCenterMgmt_func.checkOrUncheckBillingUnitCheckbox();
	}

	@Test
	public void InvoiceCenterManagement_UnCheckConsolidatedBillingUnitforCVF_017_01() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterModification();
		appFunc.invoiceCenterMgmt_func.fillInvoiceCenterModification(data);
		appFunc.invoiceCenterMgmt_func.checkOrUncheckBillingUnitCheckbox();
	}

	@Test
	public void InvoiceCenterManagement_GenerateBillingStatement_028() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.invoiceCenterMgmt_func.navigateToBillingAccount();
		appFunc.invoiceCenterMgmt_func.navigateToInvoiceCenterSubstitution();
		appFunc.invoiceCenterMgmt_func.updateTargetBAOption(data);

	}
	
	@Test
	public void InvoiceCenterManagement_VerifyAccountConditionToACH_029() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow","Collections and disbursements");
		appFunc.cashFlow_func.verifyAccountCondition(data);
	}
	
	@Test
	public void InvoiceCenterManagement_CustoemrPreference_Paperless_020_1() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();	
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
	@Test
	public void InvoiceCenterManagement_CustoemrPreference_StopStatement_020_2() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
	@Test
	public void InvoiceCenterManagement_CustoemrPreference_StatementReadyNotification_020_3() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
	@Test
	public void InvoiceCenterManagement_CustoemrPreference_PayemntReceiveNotification_020_4() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
		/*Currently this testcases is Blocked*/
	@Test
	public void InvoiceCenterManagement_GenerateBillingStatement_020_5() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.generateBillingStatement();
		
	}
	
	@Test
	public void InvoiceCenterManagement_CustomerPreference_StopStatement_020() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
	@Test
	public void InvoiceCenterManagement_CustomerPreference_PaymentDue_021() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Login");
		appFunc.invoiceCenterMgmt_func.retreiveCustomerAccountDetails(data);
		appFunc.invoiceCenterMgmt_func.selectServiceRequestType();
		appFunc.invoiceCenterMgmt_func.validateServiceRequestDetails(data);
	}
	
	@Test
	public void InvoiceCenterManagement_DisplayReason_For_StopPayment_24() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("InvoiceCenterManagement", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.actors_func.searchActorId(data);
		appFunc.actors_func.fillActorAssentDetails(data);
	}

	 
}