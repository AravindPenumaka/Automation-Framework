package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.net.ftp.parser.ParserInitializationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class CashFlow_Funcs extends BasePageMod{


	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	


	public CashFlow_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Validate Identity Details
	 */
	public void createWaterfallPayment(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.btn_CreateWaterfallPayment, "CreateWaterfallPayment Button"));
		reportData.add(click(appPages.cashFlow_page.btn_CreateWaterfallPayment, "CreateWaterfallPayment Button"));
		waitForVisibilityOfElement(appPages.cashFlow_page.lst_PaymentMethod, "PaymentMethod Dropdown");
		reportData.add(select(appPages.cashFlow_page.lst_PaymentMethod, data.get("PaymentMethod"), "PaymentMethod Dropdown"));
		sleep(1000);
		reportData.add(type(appPages.cashFlow_page.txt_ContractCode, data.get("ContractCode"), "ContractCode textBox"));
		actionClick(appPages.cashFlow_page.txt_TotalAmountToPay, "TotalAmountToPay TextBox");
		sleep(1000);
		reportData.add(verifyFieldAttribute(appPages.cashFlow_page.txt_TotalAmountToPay, "value","","TotalAmountToPay textBox"));
		reportData.add(scrollToView(appPages.cashFlow_page.txt_Amount, "Amount textBox"));
		reportData.add(type(appPages.cashFlow_page.txt_Amount, data.get("Amount"), "Amount textBox"));
		//click(appPages.cashFlow_page.txt_TotalAmountToPay, "TotalAmountToPay TextBox");
		sleep(500);
		scrollToView(appPages.cashFlow_page.btn_ExpandAllocation, "ExpandAllocation Button");
		reportData.add(click(appPages.cashFlow_page.btn_ExpandAllocation, "Ex6pandAllocation Button"));
		waitForVisibilityOfElement(appPages.cashFlow_page.lbl_SuspenseAmount, "SuspenseAmount Label");
		reportData.add(scrollToView(appPages.cashFlow_page.lbl_SuspenseAmount, "SuspenseAmount Label"));
		String totalAmountToPay=(getAttributeValue(appPages.cashFlow_page.txt_TotalAmountToPay, "value"));
		/*float Amount =   Float.parseFloat(data.get("Amount")) ;
	    float total =   Float.parseFloat(totalAmountToPay);
		String suspenseAmountCalculated= Float.toString(Amount-total);*/
		reportData.add(verifyFieldAttribute(appPages.cashFlow_page.txt_SuspenseAmount, "value","","SuspenseAmount textBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "createWaterfallPayment");
		logger.log(LogStatus.INFO, "Successfully Created Waterfall Payment");
	}
	
	
	public void verifyAccountCondition(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.txt_Contract, "Contract textBox"));
		reportData.add(type(appPages.cashFlow_page.txt_Contract,data.get("ContractNumber"),"Contract textBox"));
		sleep(1000);
		reportData.add(click(appPages.commonSrn_page.btn_Search,"Search Button"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.vfy_CashFlowTable, "Contract textBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyAccountCondition");
		logger.log(LogStatus.INFO, "Successfully Verified Account Condition",attchedStepScreenShot("Successfully Verified Account Condition", "Yes"));
	}
	
	public void fillRejectCollection(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
		reportData.add(type(appPages.cashFlow_page.txt_ReferenceCode, data.get("ReferenceCode"), "ActorCode TextBox"));
		sleep(2000);
		reportData.add(click(appPages.commonSrn_page.btn_Search , "Search Button"));
		waitForVisibilityOfElement(appPages.cashFlow_page.cb_CashFlowRow, "");
		reportData.add(click(appPages.cashFlow_page.cb_CashFlowRow, "CashFlowRow Checkbox"));
		sleep(3000);
		reportData.add(switchToDefaultFrameContent());
		waitForVisibilityOfElement(appPages.cashFlow_page.lnk_RejectCollection, "RejectCollection Link");
		reportData.add(click(appPages.cashFlow_page.lnk_RejectCollection, "RejectCollection Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To RejectCollection Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.lbl_RejectionReason, "RejectionReason Label"));
		waitForVisibilityOfElement(appPages.cashFlow_page.lst_RejectionReason,"");
		reportData.add(select(appPages.cashFlow_page.lst_RejectionReason,"For refund", "RejectCollection Link"));
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		sleep(5000);
		scrollToView(appPages.actors_page.btn_Close, "Close Button");
		highLightElement(appPages.actors_page.btn_Close);
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillRejectCollection");
		logger.log(LogStatus.INFO, "Successfully Filled Reject Collection",attchedStepScreenShot("Successfully Filled Reject Collection", "Yes"));
	}
	
	public void verifySuspenceListFields(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To CashFlow Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.txt_PaymentDateTo, "PaymentDateTo TextBox"));
		reportData.add(verifyFieldAttribute(appPages.cashFlow_page.lst_Company, "value", "", "Company DropDown"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.txt_PaymentAllocationvalue, "PaymentAllocationvalue TextBox"));
		highLightElement(appPages.cashFlow_page.txt_Comments);
		reportData.add(type(appPages.cashFlow_page.txt_Comments,"Ok", "Comments TextBox"));
		highLightElement(appPages.commonSrn_page.btn_Next);
		reportData.add(click(appPages.commonSrn_page.btn_Next, "Next Button"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.txt_ContractNumber, "ContractNumber TextBox"));
		reportData.add(type(appPages.cashFlow_page.txt_ContractNumber,data.get("ContractNumber"),"Comments TextBox"));
		sleep(1000);
		reportData.add(click(appPages.cashFlow_page.btn_Search,"Search Button"));
		waitForVisibilityOfElement(appPages.cashFlow_page.cb_UnallocatedEntry, "UnallocatedEntry Row");
		reportData.add(click(appPages.cashFlow_page.cb_UnallocatedEntry, "UnallocatedEntry Row"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.vfy_UnallocatedEntry, "UnallocatedEntry Table"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.cashFlow_page.txt_UnallocatedEntryDetail, "Name"), "XPATH","value","", "Name TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.cashFlow_page.txt_UnallocatedEntryDetail, "Total Amount"), "XPATH","value","", "TotalAmount TextBox"));
		createReportTableEntry(reportData, "verifySuspenceListFields");
		logger.log(LogStatus.INFO, "Successfully Verified Suspence List Fields",attchedStepScreenShot("Successfully Verified Suspence List Fields", "Yes"));
	}
	
	public void fillSuspenseList(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		highLightElement(setStringValueInToWebElement(appPages.cashFlow_page.lbl_UnallocatedEntryDetail, "Actor role", "XPATH"));
		reportData.add(select(setStringValueInToWebElement(appPages.cashFlow_page.lbl_UnallocatedEntryDetail, "Actor role", "XPATH"),"3RD-PARTY", "ActorRole TextBox"));
		waitForVisibilityOfElement(appPages.cashFlow_page.txt_Name,  "Name TextBox");
		reportData.add(type(appPages.cashFlow_page.txt_Name,data.get("Name"), "Name TextBox"));
		reportData.add(type(getStringWebElement(appPages.cashFlow_page.txt_UnallocatedEntryDetail, "Address"), "XPATH", false, data.get("Address"), "Address TextBox"));
		reportData.add(type(getStringWebElement(appPages.cashFlow_page.txt_UnallocatedEntryDetail, "City"), "XPATH", false, data.get("City"), "City TextBox"));
		reportData.add(type(getStringWebElement(appPages.cashFlow_page.txt_UnallocatedEntryDetail, "Zipcode"), "XPATH", false, data.get("Zipcode"), "Zipcode TextBox"));
		reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
		reportData.add(waitForVisibilityOfElement(appPages.cashFlow_page.vfy_SummaryPage,  "SummaryPage DialogueBox"));
		reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button"));
        reportData.add(acceptAlert("Create Payment-Successful"));
		createReportTableEntry(reportData, "fillSuspenseList");
		logger.log(LogStatus.INFO, "Successfully Filled Suspense List",attchedStepScreenShot("Successfully Filled Suspense List", "Yes"));
	}

}
