package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class InvoiceCenterMgmt_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();
	HomeScreen_Funcs homeScreen_func;

	public InvoiceCenterMgmt_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
		homeScreen_func = new HomeScreen_Funcs(driver, logger);
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	public void navigateToBillingAccount() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.tab_BillingAccount, "Billing Account Tab"));
		switchToDefaultFrameContent();
		createReportTableEntry(reportData, "navigateToBillingAccount");
		logger.log(LogStatus.INFO, "Succesfully Navigate To Billing Account ",
				attchedStepScreenShot("Successfully Navigate To Billing Account", "Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 */
	public void navigateToInvoiceCenterModification() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(7000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_MoreEventOptions, "More Event Option"));
		sleep(8000);
		scrollToView(appPages.invoiceCenterMgmt_page.lst_InvoiceCenterModification,
				"Invoice Center Modification Option");
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_InvoiceCenterModification,
				"Invoice Center Modification List"));
		createReportTableEntry(reportData, "navigateToInvoiceCenterModification");
		logger.log(LogStatus.INFO, "Succesfully Navigate To Invoice Center Modification ", attchedStepScreenShot("Successfully Navigate To Invoice Center Modification", "Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Navigate to Invoice center Substitution Screen
	 */
	public void navigateToInvoiceCenterSubstitution() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(7000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_MoreEventOptions,"More Event Option")); 
		sleep(2000);
		scrollToView(appPages.invoiceCenterMgmt_page.lst_InvoiceCenterSubstitution, "Invoice Center Substitution Option");
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_InvoiceCenterSubstitution,"Invoice Center Substitution List")); 
		
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Invoice center Substitution Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Invoice center Substitution Sub Screen"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Next,"Next Button")); 
		
		createReportTableEntry(reportData, "navigateToInvoiceCenterSubstitution");
		logger.log(LogStatus.INFO, "Succesfully Navigate To Invoice Center Substitution", attchedStepScreenShot("Successfully Navigate To Invoice Center Substitution", "Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Fill details in Invoice center Modification Screen
	 */
	public void fillInvoiceCenterModification(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Invoice Center Modification Page"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, " To Invoice Center Modification Sub Page"));
        reportData.add(select(appPages.invoiceCenterMgmt_page.lst_TypeOfUpdate,data.get("TypesOfUpdate"),"TypesOfUpdate Dropdown"));
	    //no value is coming in reason dropdown
		reportData.add(select(appPages.invoiceCenterMgmt_page.lst_Reason, data.get("Reason"),"Reason Dropdown"));
        reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Next,"Next Button")); 
		createReportTableEntry(reportData, "FillInvoiceCenterModification");
		logger.log(LogStatus.INFO, "Succesfully Filled Invoice Center Modification Data Items ", attchedStepScreenShot("Succesfully Filled Invoice Center Modification Data Items  ", "Yes"));
	}

	/*
	 * public void navigateToTaskScreen() throws Throwable{ List<String>
	 * reportData = new ArrayList<String>();
	 * reportData.add(click(appPages.invoiceCenterMgmt_page.
	 * cb_consolidatedBillingUnit,"ConsolidatedBillingUnit CheckBox"));
	 * reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Next,
	 * "Next Button")); createReportTableEntry(reportData,
	 * "NavigateToTaskScreen"); logger.log(LogStatus.INFO,
	 * "Succesfully Navigate To Task Screen ", attchedStepScreenShot(
	 * "Succesfully Navigate To Task Screen ","Yes")); }
	 */
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Fill address details Invoice center Modification Screen 
	 */
	public void fillAddressDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.invoiceCenterMgmt_page.txt_AddressVal, data.get("AddressValue"), "AddressOne TextBox"));
     	reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button")); 
		createReportTableEntry(reportData, "fillAddressDetails");
		logger.log(LogStatus.INFO, "Succesfully Filled Address Details and finished", attchedStepScreenShot("Succesfully Filled Address Details and finished", "Yes"));
	}

	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description fin customer account details
	 */
	@SuppressWarnings("unchecked")
	public void retreiveCustomerAccountDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_FindAccount, "FindingContact DropDown"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_Contacts, "Contacts Link"));
		reportData.add(type(appPages.invoiceCenterMgmt_page.txt_AccountNumber, data.get("AccountNumber"), "Account Number Input"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_FindAccount, "SearchContactName Button"));
		System.out.println(appPages.invoiceCenterMgmt_page.lnk_AccountNumber.getText());
		if (appPages.invoiceCenterMgmt_page.lnk_AccountNumber.getText().equals(data.get("AccountNumber"))) {
			reportData.add(click(appPages.invoiceCenterMgmt_page.lnk_AccountNumber, "AccountNumber Link"));
		}
		waitForLoadingIconGone_CRM(30000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_CloseSearch, "CloseSearch Button"));
		createReportTableEntry(reportData, "retreiveCustomerAccountDetails");
		logger.log(LogStatus.INFO, "Successfully Retreived Customer Account Details", attchedStepScreenShot("Successfully Retreived Customer Account Details","Yes"));
	}

	/***
	 * @author Aravind
	 * @throws Exception
	 * @description select the type of service request
	 */
	public void selectServiceRequestType() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(scrollToView(appPages.invoiceCenterMgmt_page.lst_ServiceRequest, "ServiceRequest DropDown"));
		sleep(3000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_ServiceRequest, "ServiceRequestName DropDown"));
		sleep(3000);
		highLightElement(appPages.invoiceCenterMgmt_page.lnk_CustomerPreferenceChange);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lnk_CustomerPreferenceChange, "CustomerPreference Link"));
		sleep(2000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Go, "Go Button"));
		createReportTableEntry(reportData, "selectServiceRequestType");
		logger.log(LogStatus.INFO, "Successfully Selected Service Requset", attchedStepScreenShot("Successfully Selected Service Requset","Yes"));
	}

	/***
	 * @author Aravind
	 * @throws Exception
	 * @description validate service request details
	 */
	public void validateServiceRequestDetails(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		sleep(10000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_SubType, "SubType DropDown"));
		highLightElement(appPages.invoiceCenterMgmt_page.lst_StatementPreferenceChange);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lst_StatementPreferenceChange,"StatementPreferenceChange Dropdown"));
		sleep(2000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SearchContact, "ContactSearch Button"));
		sleep(2000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_ContactOk, "SelectContact Button"));
		reportData.add(scrollToView(appPages.invoiceCenterMgmt_page.cb_PaymentDue, "ScrollDown"));
		if(data.get("NotificationAlerts").equals("Stop Statement"))
		{
			highLightElement(appPages.invoiceCenterMgmt_page.txt_StopStatement);
			reportData.add(clickCheckBox(appPages.invoiceCenterMgmt_page.cb_StopStatement,"aria-checked",false,"Paperless CheckBox"));
			reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SubmitSR,"SubmitSR Button"));
		}
		else if(data.get("NotificationAlerts").equals("Paperless"))
		{
			highLightElement(appPages.invoiceCenterMgmt_page.txt_PaperlessStatement);
			reportData.add(clickCheckBox(appPages.invoiceCenterMgmt_page.cb_Paperless,"aria-checked",false,"Paperless CheckBox"));
			reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SubmitSR,"SubmitSR Button"));
		}
		else if(data.get("NotificationAlerts").equals("Statement Ready"))
		{
			highLightElement(appPages.invoiceCenterMgmt_page.txt_Statementready);
			reportData.add(clickCheckBox(appPages.invoiceCenterMgmt_page.cb_Statementready,"aria-checked",false,"StatementReady CheckBox"));
			reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SubmitSR,"SubmitSR Button"));
		}
		else if(data.get("NotificationAlerts").equals("Payment received notification"))
		{
			highLightElement(appPages.invoiceCenterMgmt_page.txt_PaymentReceived);
			reportData.add(clickCheckBox(appPages.invoiceCenterMgmt_page.cb_PaymentReceived,"aria-checked",false,"PaymentReceived CheckBox"));
			reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SubmitSR,"SubmitSR Button"));
		}
		else if(data.get("NotificationAlerts").equals("Payment due"))
		{
			highLightElement(appPages.invoiceCenterMgmt_page.txt_PaymentDue);
			reportData.add(clickCheckBox(appPages.invoiceCenterMgmt_page.cb_PaymentDue,"aria-checked",false,"PaymentDue CheckBox"));
			reportData.add(click(appPages.invoiceCenterMgmt_page.btn_SubmitSR,"SubmitSR Button"));
			
		}
		sleep(20000);
		if(isAlertPresent())
		{
			acceptAlert("Alert");
		}
		reportData.add(verifyFieldAttribute(appPages.invoiceCenterMgmt_page.txt_Status,"value","Closed","Status Field"));
		reportData.add(verifyFieldAttribute(appPages.invoiceCenterMgmt_page.txt_SubStatus,"value","Processed","SubStatus Field"));
		createReportTableEntry(reportData, "validateServiceRequestDetails");
		logger.log(LogStatus.INFO, "Successfully validated ServiceRequest Details", attchedStepScreenShot("Successfully validated ServiceRequest Details","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description TargetBA Option filled And Finished
	 */
	public void updateTargetBAOption(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.invoiceCenterMgmt_page.cb_BillingAccount, "BillingAccount Checkbox"));
	    reportData.add(select(appPages.invoiceCenterMgmt_page.lst_TargeteBA, data.get("UpdateBAOption"),"UpdateBA Dropdown"));
	    reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Next, "Next Button"));
	    waitForVisibilityOfElement(appPages.commonSrn_page.btn_Finish,"Finish Button");
	    reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish Button"));
	    reportData.add(click(appPages.commonSrn_page.btn_Confirm, "Confirm Button"));
	    createReportTableEntry(reportData, "updateTargetBAOption");
		
		logger.log(LogStatus.INFO, "Successfully Updated BA Option and Confirmed", attchedStepScreenShot("Successfully Updated BA Option and Finished","Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Check or uncheck billing unit Checkbox 
	 */
	public void checkOrUncheckBillingUnitCheckbox() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.invoiceCenterMgmt_page.cb_consolidatedBillingUnit,"ConsolidatedBillingUnit Checkbox")); 
		//nextbutton disabled
		reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button")); 
		reportData.add(click(appPages.commonSrn_page.btn_Confirm,"Confirm Button")); 
		createReportTableEntry(reportData, "checkOrUncheckBillingUnitCheckbox");
		logger.log(LogStatus.INFO, "Successfully clicked ConsolidatedBillingUnit Checkbox and Finished ", attchedStepScreenShot("Successfully clicked ConsolidatedBillingUnit Checkbox and Finished ","Yes"));
	}
	
	public void generateBillingStatement() throws Throwable {
		
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_DropDown,"More DropDown"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_Correspondence,"Correspondence Button"));
		createReportTableEntry(reportData, "generateBillingStatement");
		logger.log(LogStatus.INFO, "Successfully Generated Billing Statement", attchedStepScreenShot("Successfully Generated Billing Statement","Yes"));

	}
	
	public void verifyAssetAddressTab(HashMap<String, String> data) throws Throwable {
		
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Asset", "Asset"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "Cassiopae Frame"));
		reportData.add(type(appPages.invoiceCenterMgmt_page.txt_ContractNo,data.get("ContractNumber"),"ContractNumber TextBox"));
		reportData.add(click(appPages.invoiceCenterMgmt_page.btn_ContractSearch,"ContractSearch Button"));
		sleep(5000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.lnk_AssetCode,"AssetCodeLink"));
		sleep(3000);
		reportData.add(click(appPages.invoiceCenterMgmt_page.tab_ElementList,"ElementList Tab"));
		sleep(5000);
		reportData.add(scrollToView(appPages.invoiceCenterMgmt_page.tab_GarageAddress,"GarageAddress Scroll"));
		String ZipCode=getValueProperty("ZipCode");
		reportData.add(verifyFieldAttribute(appPages.invoiceCenterMgmt_page.txt_ZipCode, "value",ZipCode, "ZipCode Verify"));
		reportData.add(verifyFieldAttribute(appPages.invoiceCenterMgmt_page.txt_Address,"value",data.get("NewAddress"),"Address Verify"));
		reportData.add(verifyFieldAttribute(appPages.invoiceCenterMgmt_page.txt_DateModified,"value",getCurrentDate(),"Date Verify"));
		createReportTableEntry(reportData, "verifyAssetAddressTab");
		logger.log(LogStatus.INFO, "Successfully Verified Garage Address Tab", attchedStepScreenShot("Successfully Verified Garage Address Tab","Yes"));
	}


}
