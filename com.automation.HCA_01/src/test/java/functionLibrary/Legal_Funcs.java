package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Legal_Funcs extends BasePageMod{
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public Legal_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To verify Flags in "DO NOT CALL INFO FOR MARKETING" Section
	 */
	public void verifyFlagsSection(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		

		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Assent tab Section"));
		reportData.add(click(appPages.actors_page.btn_ArrowMark_ActroListPage, "More Button"));
		reportData.add(click(appPages.actors_page.tab_Assent, "Assent tab"));
		sleep(7000);
		reportData.add(scrollToView(appPages.actors_page.tbl_CallForMarketing, "Scroll"));
		WebElement rowDataXpath= setStringValueInToWebElement(appPages.actors_page.vfy_CheckboxRowData, data.get("GlobalSearchCode"), "XPATH");
		waitForVisibilityOfElement(rowDataXpath, "");
		scrollToView(rowDataXpath, "");
		for(int j=1;j<=4;j++){
			 String checkbox= String.format(appPages.actors_page.vfy_CheckboxValue,data.get("GlobalSearchCode"),j);
			 WebElement checkboxXpath=getWebelement("xpath",checkbox);
			 String column= getStringWebElement(appPages.actors_page.tbl_ColumnVal,data.get("GlobalSearchCode"));
			 WebElement columnNameXpath=getWebelement("xpath",column);
			 scrollToView(columnNameXpath,"Scroll");
			 String ColumnData=columnNameXpath.getText();
			 reportData.add(verifyCheckBox(checkboxXpath, "title", data.get("CheckBoxValue"),ColumnData));
		}

		switchToDefaultFrameContent();
		createReportTableEntry(reportData, "verifyFlagsSection");
		logger.log(LogStatus.INFO, "Succesfully verified Specify Flags for DoNotCallForMarketing", attchedStepScreenShot("Succesfully verified Specify Flags for DoNotCallForMarketing","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To verify CB Data Section
	 */
	public void verifyCBDataSection(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Address Screen"));
		reportData.add(scrollToView(appPages.legal_page.lbl_CBReport,"CB Report Label"));
		reportData.add(verifyFieldAttribute(appPages.legal_page.vfyfld_ReserveReason,"title",data.get("ReserveReason"),"Reserve Reason Value"));
		reportData.add(verifyFieldAttribute(appPages.legal_page.vfyfld_ReserveStatus,"title",data.get("ReserveStatus"),"Reserve Status Value"));
		createReportTableEntry(reportData, "verifyCBDataSection");
		logger.log(LogStatus.INFO, "Succesfully Verified CB Data Section", attchedStepScreenShot("Succesfully Verified CB Data Section","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Select a SR type in CRM
	 */
	public void selectServiceRequestType(HashMap<String, String> data) throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(selectComboBoxList(appPages.customerInfoChange_page.lst_NewServiceRequest,data.get("Service Requset"), "ServiceRequestName DropDown"));
		reportData.add(click(appPages.customerInfoChange_page.btn_Go, "Go Button"));
		createReportTableEntry(reportData, "selectServiceRequestType");
        logger.log(LogStatus.INFO, "Successfully Selected Service Requset");
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Fill phone type and SR type in CRM
	 */
	public void fillPhoneTypeAndSRType(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForLoadingIconGone_CRM(90000);
		reportData.add(selectComboBoxList(appPages.legal_page.lst_PhoneType, data.get("PhoneType"), "phone type Combobox"));
		sleep(2000);
		reportData.add(selectComboBoxList(appPages.legal_page.lst_SRType, data.get("SRType"), "SR type Combobox"));
		WebElement inputField = driver.findElement(By.id("Type_Label"));
		inputField.click();
		sleep(5000);
		reportData.add(click(appPages.legal_page.btn_Submit, "Submit Button"));
		createReportTableEntry(reportData, "fillPhoneTypeAndSRType");
		logger.log(LogStatus.INFO, "Successfully filled Phone Type and SR Type",
				attchedStepScreenShot("Successfully filled Phone Type and SR Type", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Check the Account condition is checked or unchecked in CRM
	 */
	public void verifyCRMAccountCondition(String accConditionCheckStatus) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForLoadingIconGone_CRM(9000);
		reportData.add(click(appPages.legal_page.btn_GoToFinancialAccounts, "GoToFinacialAccounts Button"));
		waitForVisibilityOfElement(appPages.legal_page.cb_Legal,"Legal CheckBox");
		reportData.add(verifyCheckBox(appPages.legal_page.cb_Legal, "aria-checked", accConditionCheckStatus, "Legal"));
		createReportTableEntry(reportData, "verifyCRMAccountCondition");
		logger.log(LogStatus.INFO, "Successfully verified CRM Account Condition ",
				attchedStepScreenShot("Successfully verified CRM account Condition", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Close the SR
	 */
	public void closeSRLegal() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(click(appPages.serviceRequest_page.btn_CloseSR, "CloseSR Button"));
		if (isAlertPresent()) {
			reportData.add(acceptAlert("AcceptToClose"));
		}
		waitForLoadingIconGone_CRM(10000);
		scrollToView(appPages.fraud_page.txt_OwnerStatus, "SRStatus");
		reportData.add(verifyFieldAttribute(appPages.fraud_page.txt_OwnerStatus, "value", "Closed", "Status Verify"));
		createReportTableEntry(reportData, "CloseSRLegal");
		logger.log(LogStatus.INFO, "Succesfully closed SR", attchedStepScreenShot("Succesfully closed SR", "Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  Verify Service Request Table.
	 */	 
	public void clickServiceRequestNumber(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown"));
		reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Service Requests", "ServiceRequests Tab"));
		waitForLoadingIconGone_CRM(60000);
		
		reportData.add(scrollToView(appPages.serviceRequest_page.vfy_ServiceRequests,"ServiceRequests Table"));
		//String serviceStatus = String.format(appPages.serviceRequest_page.lnk_ServiceRequestNumber, data.get("NewSerRqstOpt"));
		//WebElement serviceStatusLinkfetch=getWebelement("xpath", serviceStatus);
		reportData.add(click(getStringWebElement(appPages.serviceRequest_page.lnk_ServiceRequestNumber, data.get("NewSerRqstOpt")),"XPATH","ServiceRequests Link"));
		sleep(9000);
		createReportTableEntry(reportData, "clickServiceRequestNumber");
		logger.log(LogStatus.INFO, "Successfully Clicked Service Request Number",attchedStepScreenShot("Successfully Clicked Service Request Number","Yes"));
	}

}
