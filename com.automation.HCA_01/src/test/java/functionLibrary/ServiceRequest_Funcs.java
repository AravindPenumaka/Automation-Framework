package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class ServiceRequest_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;

	public ServiceRequest_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	public void selectNewServiceRequest(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		highLightElement(appPages.serviceRequest_page.lbl_ServiceRequest);
		reportData.add(click(appPages.serviceRequest_page.lst_NewServiceRqstArrow,"NewServiceRequestArrow Button")); 
		sleep(1000);
		//String serviceRequest=String.format(appPages.serviceRequest_page.lst_ServiceRequest, data.get("NewSerRqstOpt"));
		try{
			reportData.add(verifyText(driver.findElement(By.xpath(appPages.serviceRequest_page.lst_ServiceRequest)), data.get("NewSerRqstOpt"),  data.get("NewSerRqstOpt")));
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "serviceRequestList" + "~" + "Unable To Find Element");
		}
		
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_ServiceRequest,data.get("NewSerRqstOpt")),"XPATH", "NewServiceRequest Select"));
		reportData.add(click(appPages.serviceRequest_page.btn_NewServiceRqst_GO,"Go Button"));
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.lbl_ServiceRequestInfo,"ServiceRequestInfo Label"));
		createReportTableEntry(reportData, "selectNewServiceRequest");
		logger.log(LogStatus.INFO, "Successfully Selected New Service Request",attchedStepScreenShot("Successfully Selected New Service Request","Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Fill Buy-out quote Details.
	 */	
	public void fillServiceRequestDetailsLegal(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.serviceRequest_page.btn_PhoneType,"PhoneType button")); 
		//WebElement PhoneType =driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("PhoneType"))));
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue,data.get("PhoneType")),"XPATH","PhoneType ListItem"));
		reportData.add(click(appPages.serviceRequest_page.btn_InitialReason,"InitialReason button")); 
		//WebElement Initiareason =setStringValueInToWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("InitialReason"),"XPATH");
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue,data.get("InitialReason")),"XPATH","InitiaReason ListItem"));		
		String checkList=data.get("Checklist");
		List<String> checkListDataList = splitInputData(checkList, ",");			
		for(int i=0;i<checkListDataList.size();i++){
			reportData.add(click(getStringWebElement(appPages.serviceRequest_page.cb_AttorneyDetails,checkListDataList.get(i)),"XPATH",checkListDataList.get(i)+" CheckBox"));
		}					
		reportData.add(click(appPages.serviceRequest_page.btn_ServiceRequestSubmit,"Submit Button"));
		reportData.add(acceptAlert("OK Button"));
		waitForLoadingIconGone_CRM(9000);
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_Status, "value",data.get("AfterSubmitStatus"), "StatusCheck Verify"));
        reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus,"value",data.get("AfterSubmitSubStatus"),"SubStatus Verify"));
        String SR=appPages.fraud_page.txt_SRNo.getAttribute("value");
        setValueProperty("Service Request Number", SR);
        waitForLoadingIconGone_CRM(12000);
		createReportTableEntry(reportData, "fillServiceRequestDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Service Request Details Legal",attchedStepScreenShot("Successfully Filled Service Request Details Legal","Yes"));
	}

	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Verify Financial Account Condition.
	 */	
	public void verifyFinancialAccountCondition(HashMap<String, String> data, String flag) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(10000);
		reportData.add(scrollToView(appPages.serviceRequest_page.btn_GoToFinancialAccount, "GoToFinancialAccount Label"));
		reportData.add(click(appPages.serviceRequest_page.btn_GoToFinancialAccount,"GoToFinancialAccount Button"));
		waitForLoadingIconGone_CRM(12000);
		WebElement accountCondition = setStringValueInToWebElement(appPages.serviceRequest_page.cb_AccountCondition, data.get("AccountCondition"), "XPATH");
		reportData.add(scrollToView(accountCondition,"AccountCondition Label"));
		String checkBox=accountCondition.getAttribute("aria-checked");
		reportData.add(verifyCheckBox(accountCondition, "aria-checked", flag, data.get("AccountCondition")));
		sleep(5000);
		createReportTableEntry(reportData, "verifyFinancialAccountCondition");
		logger.log(LogStatus.INFO, "Successfully Verified Financial Account Condition",attchedStepScreenShot("Successfully Verified Financial Account Condition","Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Verify Service Request Table.
	 */	 
	public void verifyServiceRequestTable(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown"));
		reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Service Requests", "ServiceRequests Tab"));
		sleep(5000);
		reportData.add(scrollToView(appPages.serviceRequest_page.vfy_ServiceRequests,"ServiceRequests Table"));
		String sRequestNumLink =getStringWebElement(appPages.serviceRequest_page.lnk_ServiceRequestNumber,data.get("NewSerRqstOpt"));
		WebElement serviceReqNum = getWebelement("xpath", sRequestNumLink);
		String serviceRequestNum = serviceReqNum.getText();
		setValueProperty("Service Request Number", serviceRequestNum);
		createReportTableEntry(reportData, "verifyServiceRequestTable");
		logger.log(LogStatus.INFO, "Successfully Verified Service Request Table",attchedStepScreenShot("Successfully Verified Service Request Table","Yes"));
	}

	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Fill Close Service Request.
	 */	
	
	public void fillCloseServiceRequestImpound(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		String SR = getValueProperty("SR");
		reportData.add(click(appPages.fraud_page.tab_ServiceRequest, "ServiceRequest Tab"));
		waitForVisibilityOfElement(appPages.fraud_page.lst_ServiceRequestList, "ServiceRequestTab");
		reportData.add(select(appPages.fraud_page.lst_ServiceRequestList, data.get("ServiceRequestList"),"ServiceRequestList DropDown"));
		waitForLoadingIconGone_CRM(10000);
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_ServiceRequestListAppletArw,data.get("Type"),"SearchType DropDown"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(type(appPages.fraud_page.txt_SearchSR, SR, "SR TextBox"));
		reportData.add(click(appPages.fraud_page.btn_SerachSR, "SRSearch Button"));
		waitForLoadingIconGone_CRM(15000);
		reportData.add(click(appPages.fraud_page.btn_AssignSRToMe, "AssignToMe Button"));
		if (appPages.fraud_page.lnk_SRNo.getText().equals(SR)) {
			reportData.add(click(appPages.fraud_page.lnk_SRNo, "SRNo Link"));
		}
		waitForVisibilityOfElement(appPages.fraud_page.txt_OwnerStatus, "Status");
		sleep(5000);		
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.txt_ReasonForClosure, "ReasonForClosure Label"));
		reportData.add(type(appPages.serviceRequest_page.txt_ReasonForClosure, data.get("ResolutionReason"), "ReasonForClosure TextBox"));
		String noticeReceivedDate = getCurrentDate();
		reportData.add(type(appPages.serviceRequest_page.txt_ResolutionDate,noticeReceivedDate, "ResolutionDate TextBox"));
		reportData.add(click(appPages.serviceRequest_page.btn_CloseSR,"CloseSR Button"));	
		reportData.add(acceptAlert("OK Button"));
		waitForLoadingIconGone_CRM(12000);
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_OwnerStatus, "value", data.get("AfterCloseSRStatus"), "Status Verify"));
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus, "value", data.get("AfterCloseSRSubStatus"), "SubStatus Verify"));
		createReportTableEntry(reportData, "fillCloseServiceRequest");
		logger.log(LogStatus.INFO, "Successfully Closed SR",attchedStepScreenShot("Successfully Closed SR", "Yes"));
	}
	
	public void fillCloseServiceRequestLegal(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		String SR = getValueProperty("Service Request Number");
		reportData.add(click(appPages.fraud_page.tab_ServiceRequest, "ServiceRequest Tab"));
		waitForVisibilityOfElement(appPages.fraud_page.lst_ServiceRequestList, "ServiceRequestTab");
		reportData.add(select(appPages.fraud_page.lst_ServiceRequestList, data.get("ServiceRequestList"),"ServiceRequestList DropDown"));
		waitForLoadingIconGone_CRM(10000);
		reportData.add(selectComboBoxList(appPages.fraud_page.btn_ServiceRequestListAppletArw,data.get("ServiceRequestType"),"SearchType DropDown"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(type(appPages.fraud_page.txt_SearchSR, SR, "SR TextBox"));
		reportData.add(click(appPages.fraud_page.btn_SerachSR, "SRSearch Button"));
		waitForLoadingIconGone_CRM(15000);
		reportData.add(click(appPages.fraud_page.btn_AssignSRToMe, "AssignToMe Button"));
		if (appPages.fraud_page.lnk_SRNo.getText().equals(SR)) {
			reportData.add(click(appPages.fraud_page.lnk_SRNo, "SRNo Link"));
		}
		waitForVisibilityOfElement(appPages.fraud_page.txt_OwnerStatus, "Status");	
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.txt_ResolutionReasonForClosure, "ReasonForClosure Label"));
		reportData.add(type(appPages.serviceRequest_page.txt_ResolutionReasonForClosure, data.get("ReasonForClosure"), "ReasonForClosure TextBox"));
		reportData.add(click(appPages.serviceRequest_page.btn_CloseSR,"CloseSR Button"));	
		reportData.add(acceptAlert("OK Button"));
		waitForLoadingIconGone_CRM(12000);
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_OwnerStatus, "value", data.get("AfterCloseSRStatus"), "Status Verify"));
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_SubStatus, "value", data.get("AfterCloseSRSubStatus"), "SubStatus Verify"));
		createReportTableEntry(reportData, "fillCloseServiceRequest");
		logger.log(LogStatus.INFO, "Successfully Closed SR",attchedStepScreenShot("Successfully Closed SR", "Yes"));
	}
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Fill Correspondence.
	 */	
	
	public void fillCorrespondence(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForVisibilityOfElement(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption dropdown"));
		reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Service Requests", "ServiceRequests Tab"));
		sleep(4000);
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.vfy_ServiceRequests,"ServiceRequests Table"));
		scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption dropdown"));
		reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Correspondence", "Correspondence Tab"));
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.lbl_Correspondence,"Correspondence Label"));
		reportData.add(click(appPages.serviceRequest_page.btn_NewCorrespondence,"NewCorrespondence Button"));
		waitForVisibilityOfElement(appPages.serviceRequest_page.txt_LetterType,  "LetterType TextBox");
		reportData.add(type(appPages.serviceRequest_page.txt_LetterType, data.get("LetterType"), "LetterType TextBox"));
		sleep(1000);
		reportData.add(click(appPages.serviceRequest_page.txt_Template,"Template TextBox"));
		sleep(2000);
		reportData.add(click(appPages.serviceRequest_page.btn_Template,"Template Button"));
		waitForVisibilityOfElement(appPages.serviceRequest_page.lbl_PickTemplate, "Picktemplate Label");
		reportData.add(click(appPages.serviceRequest_page.lbl_LegalReferalForm ,"LegalReferalForm Label"));
		sleep(3000);
		reportData.add(click(appPages.serviceRequest_page.btn_TemplateOK,"TemplateOK Button"));
		sleep(15000);
		click(appPages.serviceRequest_page.txt_FulfilledCenter, "FulfilledCenter TextBox");
		reportData.add(click(appPages.serviceRequest_page.btn_FulfilledCenter, "FulfilledCenter Button"));
		//WebElement fulfilledCenter =setStringValueInToWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("FulfilledCenter"),"XPATH");
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("FulfilledCenter")),"XPATH","FulfilledCenter ListItem"));
		reportData.add(click(appPages.serviceRequest_page.btn_NewRecipients,"NewRecipients Button"));
		waitForVisibilityOfElement(appPages.serviceRequest_page.lbl_AddRecipient, "AddRecipients Label");
		reportData.add(click(appPages.serviceRequest_page.btn_NewRecipientsAdd,"NewRecipientsAdd Button"));	
		sleep(4000);
		reportData.add(click(appPages.serviceRequest_page.btn_CorrespondenceGenerate,"CorrespondenceGenerate Button"));
		waitForLoadingIconGone_CRM(9000);
		sleep(7000);
		driver.navigate().refresh();
	//	driver.navigate().refresh();
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.lnk_Merged, "Merged Link"));
		reportData.add(click(appPages.serviceRequest_page.lnk_Merged, "Merged Link"));
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.vfy_DownloadPopUp, "Download PopUp"));
		reportData.add(click(appPages.serviceRequest_page.btn_Download, "Download Button"));
		createReportTableEntry(reportData, "fillCorrespondence");
		logger.log(LogStatus.INFO, "Successfully Filled Correspondence",attchedStepScreenShot("Successfully Filled Correspondence", "Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Fill Service Request Details Bankruptcy.
	 */	
	public void fillServiceRequestDetailsBankruptcy(HashMap<String, String> data, String ContractType) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.serviceRequest_page.btn_PhoneType,"PhoneType button")); 
		//WebElement PhoneType =driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("PhoneType"))));
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("PhoneType")),"XPATH","PhoneType ListItem"));
		reportData.add(click(appPages.serviceRequest_page.btn_ContactName,"ContactName Button"));
		sleep(2000);
		String tbl_rowVal = appPages.serviceRequest_page.tbl_PickContactRow;
	
		   if(ContractType.equalsIgnoreCase("Primary"))
			    {
			    /*String tbl_PickContactRowValue= String.format(tbl_rowVal,"Primary");
			    WebElement tbl_PickContactRowElem=getWebelement("XPATH", tbl_PickContactRowValue);*/
			    reportData.add(click(getStringWebElement(appPages.serviceRequest_page.tbl_PickContactRow,"Primary"),"XPATH","PickUpContact Table"));
			   		}
		   else if(ContractType.equalsIgnoreCase("Secondary"))
				{
					/*String tbl_PickContactRowValue= String.format(tbl_rowVal,"Secondary");
					WebElement tbl_PickContactRowElem=getWebelement("XPATH", tbl_PickContactRowValue);*/
					reportData.add(click(appPages.serviceRequest_page.tbl_PickContactRowSecondary,"PickUpContact Table"));
				}
		
		reportData.add(click(appPages.serviceRequest_page.btn_PickContactOk,"ContactOK Button"));
		sleep(3000);
		reportData.add(type(getStringWebElement(appPages.serviceRequest_page.txt_BankruptcyCaseDeatails, "Attorney Name"),"XPATH",true,data.get("AttorneyName"),data.get("AttorneyName")+" TextBox"));
		reportData.add(type(getStringWebElement(appPages.serviceRequest_page.txt_BankruptcyCaseDeatails, "Attorney Phone"),"XPATH",true,data.get("AttorneyPhone"),data.get("AttorneyPhone")+" TextBox"));
		reportData.add(type(appPages.serviceRequest_page.Filed_Status, data.get("Filed_Status"),
				data.get("Filed_Status")));
		//WebElement FiledStatus = driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_FiledStatus, data.get("Filed_Status"))));
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_FiledStatus, data.get("Filed_Status")),"XPATH", "FiledStatus ListItem"));
		 if(ContractType.equalsIgnoreCase("Primary"))
		    {
		reportData.add(type(appPages.serviceRequest_page.Chapter, data.get("PrimaryType"), "Chapter Dropdown"));
		//WebElement Chapter = driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_FiledStatus, data.get("PrimaryType"))));
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_FiledStatus, data.get("PrimaryType")),"XPATH", "Chapter ListItem"));
		    }
		 
		 else if(ContractType.equalsIgnoreCase("Secondary"))
			{
				reportData.add(type(appPages.serviceRequest_page.Chapter, data.get("SecondaryType"), "Chapter Dropdown"));
				//WebElement Chapter = driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_FiledStatus, data.get("SecondaryType"))));
				reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_FiledStatus, data.get("SecondaryType")),"XPATH", "Chapter ListItem"));
			}
		reportData.add(type(appPages.serviceRequest_page.txt_FilingDate, getCurrentDate(), "Comment TextBox")); 
		reportData.add(type(appPages.serviceRequest_page.Comment, "BK Filed", "Comment TextBox")); 

		reportData.add(click(appPages.serviceRequest_page.btn_ServiceRequestSubmit,"Submit Button"));
		reportData.add(acceptAlert("OK Button"));
		sleep(5000);
		//reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.btn_CloseSR, "CloseSR Button"));
		createReportTableEntry(reportData, "fillServiceRequestDetailsBankruptcy");
		logger.log(LogStatus.INFO, "Successfully Filled Service Request Details Bankruptcy",attchedStepScreenShot("Successfully Filled Service Request Details Bankruptcy","Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description Fill Buy-out quote Details.
	 */
	public void searchFinancialAccount(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(8000);
		reportData.add(click(appPages.serviceRequest_page.tab_FinancialAccounts, "FinancialAccounts Tab"));
		reportData.add(waitForVisibilityOfElement(appPages.serviceRequest_page.lbl_FinancialAccountList, "FinancialAccountList Label"));
		sleep(8000);
		reportData.add(select(appPages.serviceRequest_page.lst_FinancialAccount, "All Accounts Across Organizations", "FinancialAccountList Dropdown"));
		sleep(7000);
		reportData.add(click(appPages.serviceRequest_page.btn_AccountSearchType, "SearchType Button"));
		//WebElement SearchType = driver.findElement(By.xpath(String.format(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("SearchType"))));
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lst_SearchDrpdwnValue, data.get("SearchType")),"XPATH", "SearchType ListItem"));
		reportData.add(type(appPages.serviceRequest_page.txt_SearchValue, data.get("AccountNumber"), "AccountNumber TextBox"));
		reportData.add(click(appPages.serviceRequest_page.btn_FinancialAccountSearch, "Search Button"));
		waitForLoadingIconGone_CRM(9000);
		// String elementName = String.format(appPages.crm_page.lnk_AccountNum,
		// data.get("AccountNumber"));
		WebElement accountNum = setStringValueInToWebElement(appPages.serviceRequest_page.lnk_AccountNum,data.get("AccountNumber"), "XPATH");
		try{
			reportData.add(waitForVisibilityOfElement(accountNum, "AccountNumber Link"));
			reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lnk_AccountNum,data.get("AccountNumber")),"XPATH", "AccountNumber Link"));
			String accountNumber = getStringWebElement(appPages.serviceRequest_page.lbl_AccountNum, data.get("AccountNumber"));
			sleep(12000);
			reportData.add(scrollToView(driver.findElement(By.xpath(accountNumber)), "AccountNumber Label"));
		}
		catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" +"~"+"AccountNumberLink"+ "~" + "Element being looked is not found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		createReportTableEntry(reportData, "searchFinancialAccount");
		logger.log(LogStatus.INFO, "Successfully searched Account Number",
				attchedStepScreenShot("Successfully searched Account Number","Yes"));
	}
	
	
	/***
	 * @author Koyal
	 * @param Impound SR
	 * @throws Exception
	 * @description  Fill Impound details
	 */	
	public void fillImpoundDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(scrollToView(appPages.serviceRequest_page.lbl_Address, "Address Label"));
		sleep(3000);
		String towyardName = generateRandomString(5, true, false);
		reportData.add(type(appPages.serviceRequest_page.txt_TowyardDealerName, "HCA".concat(towyardName), "TowyardName TextBox"));
		sleep(3000);
		
		reportData.add(verifyText(appPages.serviceRequest_page.lbl_Address, "Address", "Address Label"));
		reportData.add(type(appPages.serviceRequest_page.txt_Address, data.get("Address"), "Address TextBox"));
		sleep(3000);
		
		reportData.add(verifyText(appPages.serviceRequest_page.lbl_Phone, "Phone #", "Phone Label"));
		String phone = generateRandomString(10, false, true);
		reportData.add(type(appPages.serviceRequest_page.txt_Phone, phone, "Phone TextBox"));
		sleep(3000);
		
		reportData.add(verifyText(appPages.serviceRequest_page.lbl_NoticereceivedDate, "Notice Received Date", "NoticeReceivedDate Label"));
		String noticeReceivedDate = getCurrentDate();
		reportData.add(type(appPages.serviceRequest_page.txt_NoticereceivedDate, noticeReceivedDate, "NoticereceivedDate TextBox"));
		sleep(3000);
		
		reportData.add(verifyText(appPages.serviceRequest_page.lbl_DailyStorageAmount, "Daily Storage Amount","DailyStorageAmount Label"));
		String dailyStorageAmount = generateRandomString(3, false, true);
		reportData.add(type(appPages.serviceRequest_page.txt_DailyStorageAmount, dailyStorageAmount, "DailyStorageAmount TextBox"));
		sleep(3000);
		
		reportData.add(verifyText(appPages.serviceRequest_page.lbl_TowDate, "Tow Date","TowDate Label"));
		String towDate = getCurrentDate();
		reportData.add(type(appPages.serviceRequest_page.txt_TowDate, towDate, "TowDate TextBox"));
		sleep(3000);
		
		createReportTableEntry(reportData, "fillImpoundDetails");
		logger.log(LogStatus.INFO, "Successfully filled ImpoundDetails",attchedStepScreenShot("Successfully filled ImpoundDetails","Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param Impound SR
	 * @throws Exception
	 * @description  Move To Legal
	 */	
	public void moveToLegal() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForVisibilityOfElement(appPages.serviceRequest_page.btn_MoveToLegal, "MoveToLegal Button");
		reportData.add(click(appPages.serviceRequest_page.btn_MoveToLegal, "MoveToLegal Button"));
		sleep(5000);
		createReportTableEntry(reportData, "moveToLegal");
		logger.log(LogStatus.INFO, "Successfully Moved To Legal",attchedStepScreenShot("Successfully Moved To Legal", "Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param External
	 *            request Details
	 * @throws Exception
	 * @description Fill External request Details.
	 */
	public void fillExternalRequestDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.serviceRequest_page.lst_SubType, data.get("SubType"), "Subtype Dropdown"));
		String SubtypeLnk = appPages.commonSrn_page.linkToClick;
		//String ExternalRequest = String.format(SubtypeLnk, data.get("SubType"));
		//WebElement SubtypeLnkEle = getWebelement("XPATH", ExternalRequest);
		reportData.add(click(getStringWebElement(appPages.commonSrn_page.linkToClick, data.get("SubType")),"XPATH", "Subtype Dropdown"));

		reportData.add(type(appPages.serviceRequest_page.lst_Reason, data.get("Reason"), "Reason Dropdown"));
		//String ReasonLnk = appPages.commonSrn_page.linkToClick;
		//String Reason = String.format(ReasonLnk, data.get("Reason"));
		//WebElement reasonEle = getWebelement("XPATH", Reason);
		reportData.add(click(getStringWebElement(appPages.commonSrn_page.linkToClick,data.get("Reason")),"XPATH", "Reason Dropdown"));
		reportData.add(type(appPages.serviceRequest_page.txt_Comments, "TEST", "Comments TextBox"));
		reportData.add(type(appPages.serviceRequest_page.lst_DeliveryMethod, data.get("DeliveryMethod"),
				"DeliveryMethod Dropdown"));
		//String DeliveryMethodLnk = appPages.commonSrn_page.linkToClick;
		//String DeliveryMethod = String.format(DeliveryMethodLnk, data.get("DeliveryMethod"));
		//WebElement DeliveryMethodEle = getWebelement("XPATH", DeliveryMethod);
		reportData.add(click(getStringWebElement(appPages.commonSrn_page.linkToClick,data.get("DeliveryMethod")),"XPATH", "DeliveryMethod Dropdown"));

		String Fax = generateRandomString(10, false, true);
		reportData.add(type(appPages.serviceRequest_page.txt_Fax, Fax, "Fax TextBox"));

		reportData.add(click(appPages.fraud_page.btn_submitClaim, "Submit Button"));

		createReportTableEntry(reportData, "fillExternalRequestDetails");
		logger.log(LogStatus.INFO, "Successfully searched Account Number",
				attchedStepScreenShot("Successfully searched Account Number", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param 
	 * @throws Exception
	 * @description  Fill Service Request Details Auction
	 */	
	public void fillServiceRequestDetailsAuction(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(selectComboBoxList(appPages.legal_page.lst_PhoneType,data.get("PhoneType"),"phone type Combobox"));
		reportData.add(selectComboBoxList(appPages.serviceRequest_page.lst_RequestType,data.get("RequestType"),"RequestType Combobox"));
		reportData.add(selectComboBoxList(appPages.serviceRequest_page.lst_Reason,data.get("Reason"),"Reason Combobox"));
		reportData.add(selectComboBoxList(appPages.serviceRequest_page.lst_SaleType,data.get("SaleType"),"SaleType Combobox"));
		reportData.add(selectComboBoxList(appPages.serviceRequest_page.lst_SaleDate,data.get("SaleDate"),"SaleDate Combobox"));
	
	//	reportData.add(click(appPages.serviceRequest_page.btn_ServiceRequestSubmit,"Submit Button"));
	//	reportData.add(acceptAlert("OK Button"));
		sleep(5000);
		String SR=appPages.fraud_page.txt_SRNo.getAttribute("value");
	    setValueProperty("SR", SR);
		createReportTableEntry(reportData, "fillServiceRequestDetailsAuction");
		logger.log(LogStatus.INFO, "Successfully Filled Service Request Details Auction",attchedStepScreenShot("Successfully Filled Service Request Details Auction", "Yes"));
	}
	
	//modified on 6/21/2019
	/***
	 * @author Koyal
	 * @throws Exception
	 * @description  Verify  Account Condition under Third level View.
	 */	
	public void verifyFinancialAccountConditionThirdLevelView(HashMap<String, String> data, String flag) throws Throwable {
		
			List<String> reportData = new ArrayList<String>();
			String AccountConditionFlag=data.get("AccountConditionFlag");
			reportData.add(click(appPages.legal_page.btn_GoToFinancialAccounts, "GoToFinacialAccounts Button"));
			sleep(5000);
			scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		
			reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown"));
			reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Account Conditions", "AccountCondition Tab"));
			sleep(5000);
			reportData.add(scrollToView(appPages.serviceRequest_page.btn_Showmore,"ShowMoreExpand Button"));
			sleep(5000);
			reportData.add(click(appPages.serviceRequest_page.btn_Showmore,"ShowMoreExpand Button"));
			sleep(5000);
			String AccountConditionReplace=String.format(appPages.serviceRequest_page.cb_AccountCondition, data.get("AccountCondition"));
			sleep(2000);
			WebElement accountCondition = getWebelement("xpath", AccountConditionReplace);
			sleep(4000);
			reportData.add(scrollToView(accountCondition,"accountCondition Button"));
			sleep(5000);
			reportData.add(verifyCheckBox(accountCondition, "aria-checked", flag, "AccountCondition Flag"));
			sleep(5000);
			reportData.add(scrollToView(appPages.serviceRequest_page.btn_Showless,"ShowLessExpand Button"));
			sleep(2000);
			reportData.add(click(appPages.serviceRequest_page.btn_Showless,"ShowLessExpand Button"));
			sleep(4000);
			createReportTableEntry(reportData, "verifyFinancialAccountConditionThirdLevelView");
			logger.log(LogStatus.INFO, "Successfully  verifyFinancialAccountConditionThirdLevelView",attchedStepScreenShot("Successfully Clicked Service Request Number","Yes"));
		} 
}
