package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;
import org.openqa.selenium.support.FindBy;

public class Fraud_Funcs extends BasePageMod {
	
	private static final String String = null;
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();
	

	String locatortype;
	WebElement element;
	List<String> reportData =  new ArrayList<String>();
	/*public LoginFunctions(WebDriver driver, ExtentTest logger) throws IOException {
		
		appPages = new ApplicationPages(driver,logger);
	}*/

	public Fraud_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	
	@SuppressWarnings("unchecked")
	public void searchAccountNumAndEnter(HashMap<String, String> data) throws Throwable{
		//
		//Thread.sleep(10000);
		waitForLoadingIconGone_CRM(60000);
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.lnk_CrmSearch,"SearchImage Button"));
		reportData.add(type(appPages.fraud_page.txt_SearchAccountNumber, true, data.get("AccountNumber"), "AccountNumber TextBox"));
		reportData.add(click(appPages.fraud_page.lnk_SearchEnter,"Enter Button"));
		waitForLoadingIconGone_CRM(60000);
		reportData = concatList(reportData, this.clickOnAccountNumLink(data.get("AccountNumber")));
	
		createReportTableEntry(reportData, "searchAccountNumAndEnter");
		logger.log(LogStatus.INFO, "Succesfully Searched Account Number", attchedStepScreenShot("Succesfully Searched Account Number","Yes"));
	}
	
	@SuppressWarnings("static-access")
	public List<String> clickOnAccountNumLink(String accNum) throws Throwable{
		waitForLoadingIconGone_CRM(60000);
		List<String> reportData =  new ArrayList<String>();
		//String elementName = String.format(appPages.fraud_page.lnk_AccountNum, accNum);
		//WebElement accountNum = getWebelement("XPATH", elementName);
		reportData.add(click(getStringWebElement(appPages.fraud_page.lnk_AccountNum, accNum),"XPATH", "AccountNumber Link"));
		waitForLoadingIconGone_CRM(60000);
		try{
			waitForVisibilityOfElement(getWebelement("XPATH", "//label[text()='" +  accNum +"']"), "AccountNumber Label");
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AccountNumberLabel" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		return reportData;
	}
	
	public void fraudNewServiceRequestAndContinue(HashMap<String, String> data) throws Throwable{

		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.lst_NewServiceRqstArrow,"NewServiceRequestArrow Button")); 
		waitForLoadingIconGone_CRM(60000);
		try{
			reportData.add(click("//li[text()='" +  data.get("NewSerRqstOpt") +"']","XPATH", "NewServiceRequest Select"));
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ServiceRequest" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		reportData.add(click(appPages.fraud_page.btn_NewServiceRqst_GO,"Go Button"));
		waitForLoadingIconGone_CRM(60000);
		createReportTableEntry(reportData, "fraudNewServiceRequestAndContinue");
		logger.log(LogStatus.INFO, "Succesfully Created New Service Request", attchedStepScreenShot("Succesfully Created New Service Request","Yes"));
	}
	
  //Part 2 To be executed after KSIOP deployment completed.
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description search contract number.
	 */
	public void verifyAccountCondition(HashMap<String, String> data) throws Throwable {
		 List<String> reportData =  new ArrayList<String>();
	 	 
	 	 
	 	 reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
	     reportData.add(scrollToView(appPages.searchAccCond_page.txt_acccond,"Account Condition Table"));
	         
	     String tbl_rowVal = appPages.searchAccCond_page.tbl_Accountcondition;
	     try{
	    	 String tbl_accountConditionRowValue= String.format(tbl_rowVal,data.get("AccCond"),data.get("AccSubCond"),data.get("StartDate"));
		     WebElement accConditionElem = getWebelement("XPATH", tbl_accountConditionRowValue);
		         
		     reportData.add(isPresentAndDisplayed(accConditionElem, "Account Condition Table Value"));
		     reportData.add(scrollToView(accConditionElem,"Account Condition List Item"));
	     }catch(Exception e){
	    	 reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AccountConditionTable" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
	     }
	     
	     createReportTableEntry(reportData, "verifyAccountCondition");
		 Thread.sleep(3000);
		 logger.log(LogStatus.INFO, "Successfully Verified Account Condition Table Value", attchedStepScreenShot("Successfully Verified Account Condition Table Value","Yes"));
	 }
  
  @SuppressWarnings("unchecked")
	public void fillContractSearch(HashMap<String, String> data) throws Throwable{
 		
 		System.out.println(data.get("AccountNumber"));
 		searchContract(data.get("AccountNumber"));
 	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description search contract number.
	 */
	public void searchContract(String contractnumber) throws Exception {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Contracts"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));

		reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
		reportData.add(type(appPages.contract_page.txt_Contractno, contractnumber, "Contract No. TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		sleep(2000);
		reportData.add(click(appPages.contract_page.lnk_Contract, "Contract link"));
		sleep(1000);
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "fillSearchContract");
		sleep(3000);
		logger.log(LogStatus.INFO, "Successfully Searched Contract", attchedStepScreenShot("Successfully Searched Contract", "Yes"));
	}
	
	
	/***
	 * @author Koyal
	 * @param data 
	 * @param sheetName
	 * @param testCase
	 * @throws Exception
	 * @description To select Fraud Type and Submit claim
	 */
	public void selectFraudTypeAndSubmitClaim(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		waitForLoadingIconGone_CRM(60000);
		reportData.add(scrollToView(appPages.fraud_page.lst_FraudTypeArrow, "FraudType Dropdown"));
        reportData.add(selectComboBoxList(appPages.fraud_page.lst_FraudTypeArrow, data.get("FraudType"), "FraudType DropDown"));
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (UnhandledAlertException e) {
			reportData.add(acceptAlert("SubmitClaim PopUp"));
		}
		sleep(2000);
		if (isAlertPresent()) {
			reportData.add(acceptAlert("SubmitClaim PopUp"));
		}
        waitForLoadingIconGone_CRM(60000);
		scrollToView(appPages.fraud_page.btn_submitClaim,"Submit Claim Button");
        reportData.add(click(appPages.fraud_page.btn_submitClaim,"SubmitClaim Button"));
       
        waitForLoadingIconGone_CRM(60000);
    	scrollToView(appPages.fraud_page.txt_Status, "Status");
        reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_Status, "value",data.get("AfterSubmitStatus"), "StatusCheck Verify"));
        reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus,"value",data.get("AfterSubmitSubStatus"),"SubStatus Verify"));
        String SR=appPages.fraud_page.txt_SRNo.getAttribute("value");
        setValueProperty("SR", SR);
		createReportTableEntry(reportData, "selectFraudTypeAndSubmitClaim");
		logger.log(LogStatus.INFO, "Successfully Submitted Claim Details",
				attchedStepScreenShot("Successfully Submitted Claim Details", "Yes"));
	}
	
	@SuppressWarnings("static-access")
	public void selectNewServiceRequest(HashMap<String, String> data) throws Throwable {

		List<String> reportData = new ArrayList<String>();
		highLightElement(appPages.fraud_page.lbl_ServiceRequest);
		reportData.add(click(appPages.fraud_page.lst_NewServiceRqstArrow, "NewServiceRequestArrow Button"));
		sleep(1000);
		
		String serviceRequest =getStringWebElement(appPages.fraud_page.lst_ServiceRequest, data.get("NewSerRqstOpt"));
		try{
			reportData.add(verifyText(driver.findElement(By.xpath(serviceRequest)), data.get("NewSerRqstOpt"),
					data.get("NewSerRqstOpt")));
			reportData.add(click(driver.findElement(By.xpath(serviceRequest)), "NewServiceRequest Select"));
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "NewServiceRequest" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		
		reportData.add(click(appPages.fraud_page.btn_NewServiceRqst_GO, "Go Button"));
		// Thread.sleep(18000);
		createReportTableEntry(reportData, "selectNewServiceRequest");
		logger.log(LogStatus.INFO, "Successfully Selected New-Service Request",
				attchedStepScreenShot("Successfully Selected New-Service Request", "Yes"));
	}
	 
	public void verifyGoodThroughDays(HashMap<String, String> data) throws Throwable {

		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.txt_GoodThroughDays, "GoodThroughDays TextBox"));
		sleep(10000);
		WebElement goodThroughDays = appPages.fraud_page.vfy_GoodThroughDays;
		String s = goodThroughDays.getText();
		reportData.add(verifyText(goodThroughDays, data.get("GoodThroughDays"), data.get("GoodThroughDays")));
		createReportTableEntry(reportData, "verifyGoodThroughDays");
		logger.log(LogStatus.INFO, "Successfully Verified Good Through Days",
				attchedStepScreenShot("Successfully Verified Good Through Days", "Yes"));
	}

	public void fillServiceRequestSubType(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForLoadingIconGone_CRM(10000);
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_PayOffSubType, data.get("SubType"), "SubType Dropdown"));
		createReportTableEntry(reportData, "fillServiceRequestSubType");
		logger.log(LogStatus.INFO, "Successfully Filled SR Sub-Type",attchedStepScreenShot("Successfully Filled SR Sub-Type", "Yes"));
	}

	@SuppressWarnings("static-access")
	public void verifySectionUnderSRType() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForLoadingIconGone_CRM(10000);
		try{
			WebElement sectionBuyout = driver
					.findElement(By.xpath(getStringWebElement(appPages.fraud_page.vry_SectionUnderSR, "Buyout Quote")));
			reportData.add(verifyText(sectionBuyout, "Buyout Quote", "BuyoutQuote Section"));
			WebElement sectionAccPosition = driver
					.findElement(By.xpath(getStringWebElement(appPages.fraud_page.vry_SectionUnderSR, "Account Position")));
			reportData.add(verifyText(sectionAccPosition, "Account Position", "AccountPosition Section"));
			WebElement sectionCalBuyoutQuote = driver.findElement(
					By.xpath(getStringWebElement(appPages.fraud_page.vry_SectionUnderSR, "Calculated Buyout Quote")));
			reportData.add(verifyText(sectionCalBuyoutQuote, "Calculated Buyout Quote", "CalculatedBuyoutQuote Section"));
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresent" + "~" + "SRTypeSection" + "~" + "Element Not Found.");
		}
		
		createReportTableEntry(reportData, "verifySectionUnderSRType");
		logger.log(LogStatus.INFO, "Successfully Verified Sections",
				attchedStepScreenShot("Successfully Verified Sections", "Yes"));
	}
		
	public void fillBuyoutquoteDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_CallerType, data.get("CallerType"), "CallerType Dropdown"));
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_RequestedBy, data.get("RequestedBy"), "RequestedBy Dropdown"));
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_RequestedFor, data.get("RequestedFor"), "RequestedFor Dropdown"));
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_Intent, data.get("Intent"), "Intent Dropdown"));
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_Reason, data.get("Reason"), "Reason Dropdown"));
		reportData.add(click(appPages.serviceRequest_page.btn_ServiceRequestSubmit,"Submit Button"));
		reportData.add(acceptAlert("OK Button"));
		
		createReportTableEntry(reportData, "fillBuyoutquoteDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Boyout Quote Details",
				attchedStepScreenShot("Successfully Filled Boyout Quote Details", "Yes"));
	}
	
	
	public void retriveAndClickAssignToMe(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		String SR = getValueProperty("SR");
		reportData.add(click(appPages.fraud_page.tab_ServiceRequest, "ServiceRequest Tab"));
		waitForVisibilityOfElement(appPages.fraud_page.lst_ServiceRequestList, "ServiceRequestTab");
		reportData.add(select(appPages.fraud_page.lst_ServiceRequestList, data.get("ServiceRequestList"),
 				"ServiceRequestList DropDown"));
		waitForLoadingIconGone_CRM(10000);
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_ServiceRequestListAppletArw, data.get("Type"),
				"SearchType DropDown"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(type(appPages.fraud_page.txt_SearchSR, SR, "SR TextBox"));
		reportData.add(click(appPages.fraud_page.btn_SerachSR, "SRSearch Button"));
		waitForLoadingIconGone_CRM(15000);
		reportData.add(click(appPages.fraud_page.btn_AssignSRToMe, "AssignToMe Button"));
		if (appPages.fraud_page.lnk_SRNo.getText().equals(SR)) {
			reportData.add(click(appPages.fraud_page.lnk_SRNo, "SRNo Link"));
		}
		waitForLoadingIconGone_CRM(5000);
		createReportTableEntry(reportData, "retriveAndClickAssignToMe");
	}

	public void confirmFraud(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(15000);
		 reportData.add(click("//ul[@role='tablist']//li//a[text()='Fraud'] | //option[text()='Fraud']", "XPATH","Fraud Tab"));
		reportData.add(click(appPages.fraud_page.btn_ConfirmFraud, "ConfirmFraud Button"));
		sleep(5000);
		scrollToView(appPages.fraud_page.txt_OwnerStatus, "OwnerStatus");
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_OwnerStatus, "value", data.get("AfterConfirmationStatus"), "Status Verify"));
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus, "value", data.get("AfterConfirmationSubStatus"), "SubStatus Verify"));
		createReportTableEntry(reportData, "confirmFraud");
	}

	public void closeSR() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.btn_Close, "CloseSR Button"));
		sleep(2000);
		if (isAlertPresent()) {
			reportData.add(acceptAlert("AcceptToClose"));
		}
		scrollToView(appPages.fraud_page.txt_OwnerStatus, "SRStatus");
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_OwnerStatus, "value", "Closed", "Status Verify"));
		createReportTableEntry(reportData, "closeSR");
	}
	
	public void submitClaimAndGetSR(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		waitForLoadingIconGone_CRM(60000);
		scrollToView(appPages.fraud_page.btn_submitClaim,"Submit Claim Button");
        reportData.add(click(appPages.fraud_page.btn_submitClaim,"SubmitClaim Button"));
        waitForLoadingIconGone_CRM(60000);
        sleep(2000);
    	if(isAlertPresent())
        {
        	reportData.add(acceptAlert("Alert"));
        	waitForLoadingIconGone_CRM(60000);
        	if(appPages.fraud_page.btn_submitClaim.isEnabled())
        	reportData.add(click(appPages.fraud_page.btn_submitClaim,"SubmitClaim Button"));
        	waitForLoadingIconGone_CRM(60000);
        }
    	
	    	if(data.get("AfterSubmitStatus")!="" || data.get("AfterSubmitStatus")!=null)
	    	{
		    	scrollToView(appPages.fraud_page.txt_Status, "Status");
		        reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_Status, "value",data.get("AfterSubmitStatus"), "StatusCheck Verify"));
		        reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus,"value",data.get("AfterSubmitSubStatus"),"SubStatus Verify"));
	    	}
        String SR=appPages.fraud_page.txt_SRNo.getAttribute("value");
        setValueProperty("SR", SR);
		createReportTableEntry(reportData, "submitClaimAndGetSR");
	}
	
	public void DeclineFraudandVerifyAccountCondition(HashMap<String, String> data) throws Exception
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click("//ul[@role='tablist']//li//a[text()='Fraud'] | //option[text()='Fraud']","XPATH","Fraud Tab")); 
		sleep(15000);
		reportData.add(click(appPages.fraud_page.btn_NotFraud, "NotFraud Button"));
		sleep(5000);
		reportData.add(scrollToView(appPages.fraud_page.txt_OwnerStatus, "OwnerStatus Scroll"));
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_Status, "value", data.get("AfterConfirmationStatus"), "Status Verify"));
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus, "value", data.get("AfterConfirmationSubStatus"), "SubStatus Verify"));
		reportData.add(click(appPages.fraud_page.btn_FinancialAccounts,"FinancialAccounts Button"));
		sleep(5000);
		//String FraudFlag="//span[text()='Fraud']/../../../td[11]//input[@aria-checked='%s']";
		reportData.add(verifyFieldAttribute(appPages.fraud_page.btn_FraudFlag,"aria-checked","False","FraudFlag CheckBox"));
		createReportTableEntry(reportData, "DeclineFraudandVerifyAccountCondition");
	}
	
	public void verifyFraudFlag(HashMap<String, String> data) throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.fraud_page.tab_Contacts,"ContactsTab Scroll"));
		reportData.add(click(appPages.fraud_page.tab_Contacts,"Contacts Tab"));
	}
	
}
