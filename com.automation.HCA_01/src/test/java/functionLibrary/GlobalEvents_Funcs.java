package functionLibrary;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class GlobalEvents_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public GlobalEvents_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	@SuppressWarnings("unchecked")
	public void fillGlobalEventListDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Global Events"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(click(appPages.globalEvent_page.btn_NewEventList, "New Button"));
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		reportData.add(select(appPages.globalEvent_page.lst_EventtoRun, "Bulk Payment", "EventToRun Dropdown"));
		reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
		reportData.add(click(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));

		reportData = concatList(reportData, this.fillBatchInformation(data));
		createReportTableEntry(reportData, "fillGlobalEventListDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Global Event Details",
				attchedStepScreenShot("Successfully Filled Global Event Details", "Yes"));
	}

	public List<String> fillBatchInformation(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, data.get("PaymentMethod"),"PaymentMethod Dropdown"));
		reportData.add(select(appPages.globalEvent_page.lst_SpreadType, data.get("SpreadType"), "SpreadType Dropdown"));
		reportData.add(type(appPages.globalEvent_page.txt_Comments, "ok", "BatchComments TestBox"));
		return reportData;
	}

	/*public void fillCheckInformationDetails(HashMap<String, String> data) throws Exception {

		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.globalEvent_page.btn_CheckInformationNew, "New Button"));

		appPages.globalEvent_page.txt_CheckNumber.click();
		appPages.globalEvent_page.txt_CheckNumber.sendKeys(Keys.DELETE);
		reportData.add(type(appPages.globalEvent_page.txt_CheckNumber,data.get("CheckNumber"), "CheckNumber TextBox"));
		appPages.globalEvent_page.txt_CheckNumber.sendKeys(Keys.TAB);
		sleep(2000);

		appPages.globalEvent_page.txt_CheckAmount.click();
		appPages.globalEvent_page.txt_CheckAmount.sendKeys(Keys.DELETE);
		reportData.add(type(appPages.globalEvent_page.txt_CheckAmount, data.get("CheckAmount"), "CheckAmount TextBox"));
		appPages.globalEvent_page.txt_CheckAmount.sendKeys(Keys.TAB);
		sleep(2000);

		//reportData.add(select(appPages.globalEvent_page.lst_CheckTypes, data.get("CheckType"), "CheckType Dropdown"));

		appPages.globalEvent_page.txt_NoOfPayments.click();
		appPages.globalEvent_page.txt_NoOfPayments.sendKeys(Keys.DELETE);
		reportData.add(type(appPages.globalEvent_page.txt_NoOfPayments, data.get("NoOfPayments"), "No.OfPayments TextBox"));
		appPages.globalEvent_page.txt_NoOfPayments.sendKeys(Keys.TAB);
		sleep(2000);

		appPages.globalEvent_page.txt_CheckInformationComments.click();
		sleep(2000);
		reportData.add(type(appPages.globalEvent_page.txt_CheckInformationComments, "ok", "Comments TextBox"));
		reportData.add(scrollToView(appPages.globalEvent_page.btn_CheckInformationNext, "Next Button"));
		reportData.add(click(appPages.globalEvent_page.btn_CheckInformationNext, "Next Button"));
		createReportTableEntry(reportData, "fillCheckInformationDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Infomation Details",
				attchedStepScreenShot("Successfully Filled Infomation Details", "Yes"));
	}*/
	@SuppressWarnings("unchecked")
	public void fillPayment_ConsolidatedInformation(HashMap<String, String> data) throws Throwable {

		List<String> reportData = new ArrayList<String>();
		//fillCheckInformationDetails(data);
		for (int i = 0; i < Integer.parseInt(data.get("NoOfPayments")); i++) {
			reportData.add(click(appPages.globalEvent_page.btn_NewPayment, "New Button"));
			reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
			sleep(2000);
			reportData.add(click(appPages.globalEvent_page.chk_Consolidated, "Consolidate CheckBox"));
			reportData.add(select(appPages.globalEvent_page.lst_CheckNumber, data.get("CheckNumber"), "CheckNumber Dropdown"));
			if(appPages.globalEvent_page.txt_BillingAccount.isEnabled() )
				reportData.add(type(appPages.globalEvent_page.txt_BillingAccount, data.get("Billing Account"),"BillingAccountNumber TextBox"));
			else
				reportData.add(type(appPages.globalEvent_page.txt_AccountNum, data.get("AccountNumber"),"BillingAccountNumber TextBox"));
			//			appPages.globalEvent_page.txt_BillingAccount.sendKeys(Keys.TAB);
			appPages.globalEvent_page.txt_PaymentAmount.click();
			sleep(1500);
			acceptAlert("");
			reportData.add(click(appPages.globalEvent_page.btn_AccountSearchPopupClose, "CloseSearch Button"));
			sleep(5000);
			if (Integer.parseInt(data.get("NoOfPayments")) > 1) {
				String amt = data.get("CheckAmount");
				String CAmount = amt.replace(",", "");
				Double CheckAmount = Double.parseDouble(CAmount);
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount,true,Double.toString(CheckAmount / Double.parseDouble(data.get("NoOfPayments"))),"PaymentAmount TextBox"));
			} else {
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount, data.get("CheckAmount"),"TotalAmount TextBox"));
			}
			reportData.add(click(appPages.globalEvent_page.btn_PaymentInformationNext, "PaymentInformationNext Button"));
			if (isAlertPresent()) {
				reportData.add(acceptAlert("PaymentAmount Alert"));
			}
			sleep(2000);
		}
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To EventList Screen"));
		reportData.add(verifyText(appPages.globalEvent_page.vfy_GlobalEvents, "Events List", "EventList Screen"));
		createReportTableEntry(reportData, "fillPayment_ConsolidatedInformation");
		logger.log(LogStatus.INFO, "Successfully Filled Payment Consolidated Information",attchedStepScreenShot("Successfully Filled Payment Consolidated Information", "Yes"));
	}


	@SuppressWarnings("unchecked")
	public void fillPaymentInformationDeatils(HashMap<String, String> data) throws Throwable {

		List<String> reportData = new ArrayList<String>();

		//fillCheckInformationDetails(data);
		for (int i = 0; i < Integer.parseInt(data.get("NoOfPayments")); i++) {
			reportData.add(click(appPages.globalEvent_page.btn_NewPayment, "New Button"));
			sleep(2000);
			reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
			reportData.add(type(appPages.globalEvent_page.txt_AccountNumber, data.get("AccountNumber"),
					"AccountNumber TextBox"));

			reportData.add(
					select(appPages.globalEvent_page.lst_CheckNumber, data.get("CheckNumber"), "CheckNumber Dropdown"));
			sleep(5000);
			if (isAlertPresent()) {
				acceptAlert("Alert");
			}
			if (Integer.parseInt(data.get("NoOfPayments")) > 1) {
				String amt = data.get("CheckAmount");
				String CAmount = amt.replace(",", "");
				Double CheckAmount = Double.parseDouble(CAmount);
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount,
						Double.toString(CheckAmount / Double.parseDouble(data.get("NoOfPayments"))),
						"PaymentAmount TextBox"));
			} else {
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount, data.get("CheckAmount"),
						"TotalAmount TextBox"));
			}
			System.out.println("");
			reportData
			.add(click(appPages.globalEvent_page.btn_PaymentInformationNext, "PaymentInformationNext Button"));
		}
		reportData.add(scrollToView(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To EventList Screen"));
		reportData.add(verifyText(appPages.globalEvent_page.vfy_GlobalEvents, "Events List", "EventList Screen"));
		createReportTableEntry(reportData, "fillPaymentInformationDetails");
		sleep(3000);
		logger.log(LogStatus.INFO, "Successfully Filled Payment Information Deatils",
				attchedStepScreenShot("Successfully Filled Payment Information Deatils", "Yes"));
	}

	@SuppressWarnings("unchecked")
	public void verifyGroupTypeDropdownOptions(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, data.get("PaymentMethod"), "GroupType Dropdown"));
		Thread.sleep(3000);
		reportData = concatList(reportData, check_CheckType(data));
		createReportTableEntry(reportData, "verifyGroupTypeDropdownOptions");
		logger.log(LogStatus.INFO, "Successfully Verified GroupType Dropdown Options",
				attchedStepScreenShot("Successfully Verified GroupType Dropdown Options", "Yes"));
	}

	@SuppressWarnings("unchecked")
	public void verifyGroupTypeDropdownLockBoxOptions(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, data.get("PaymentMethod"),
				"GroupType Dropdown"));
		sleep(3000);
		reportData = concatList(reportData, check_CheckType(data));
		createReportTableEntry(reportData, "verifyGroupTypeDropdownLockBoxOptions");
		logger.log(LogStatus.INFO, "Successfully Verified GroupType LockBox Dropdown Options",
				attchedStepScreenShot("Successfully Verified GroupType LockBox Dropdown Options", "Yes"));
	}

	public void verifyGroupTypeDropdownAuctionOptions(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, data.get("PaymentMethod_1"),
				"GroupType Dropdown"));
		Thread.sleep(3000);
		reportData = concatList(reportData, check_Grouptype_1(data));
		createReportTableEntry(reportData, "verifyGroupTypeDropdownAuctionOptions");
		logger.log(LogStatus.INFO, "Successfully Verified GroupType Auction Dropdown Options",
				attchedStepScreenShot("Successfully Verified GroupType Auction Dropdown Options", "Yes"));
	}

	public List<String> check_CheckType(HashMap<String, String> data) throws Exception {
		String groupTypeElement = "//select[@id='s_cbd_5::content']//option";
		List<String> getGroupType = getListOfDropDownValues(groupTypeElement);
		List<String> lstGrpTyp = new ArrayList<String>();
		for (int k = 0; k < getGroupType.size(); k++) {
			if (getGroupType.get(k).contains("[")) {
				lstGrpTyp.add(getGroupType.get(k).split("\\[")[0].trim());
			} else {
				lstGrpTyp.add(getGroupType.get(k));
			}
		}

		String GrouptypeExcel = data.get("GroupType");
		List<String> lstExcelGrpTyp = splitInputData(GrouptypeExcel, ",");
		return verifyDropDownValue("CheckType", lstExcelGrpTyp, lstGrpTyp);
	}

	public List<String> check_Grouptype_1(HashMap<String, String> data) throws Exception {
		//String groupTypeElement = "//select[@id='s_cbd_5::content']//option";
		String groupTypeElement = "//select[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl:0:tmpcode::content']//option";

		List<String> getGroupType = getListOfDropDownValues(groupTypeElement);
		List<String> lstGrpTyp = new ArrayList<String>();
		for (int k = 0; k < getGroupType.size(); k++) {
			if (getGroupType.get(k).contains("[")) {
				lstGrpTyp.add(getGroupType.get(k).split("\\[")[0].trim());
			} else {
				lstGrpTyp.add(getGroupType.get(k));
			}
		}

		String GrouptypeExcel = data.get("GroupType_1");
		List<String> lstExcelGrpTyp = splitInputData(GrouptypeExcel, ",");
		return verifyDropDownValue("Group Type", lstExcelGrpTyp, lstGrpTyp);
	}

	@SuppressWarnings("unchecked")
	public void verifySpreadTypeDropdownOptions(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Global Events"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(click(appPages.globalEvent_page.btn_NewEventList, "New Button"));
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		reportData.add(select(appPages.globalEvent_page.lst_EventtoRun, "Bulk Payment", "EventToRun Dropdown"));
		reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
		reportData.add(click(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));

		reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, "Lockbox", "Selecting GroupType"));
		Thread.sleep(3000);
		reportData = concatList(reportData, check_Spreadtype(data));
		createReportTableEntry(reportData, "verifyGroupTypeDropdownOptions");
		logger.log(LogStatus.INFO, "Successfully Verified SpreadType Dropdown Options",
				attchedStepScreenShot("Successfully Verified SpreadType Dropdown Options", "Yes"));
	}

	public List<String> check_Spreadtype(HashMap<String, String> data) throws Exception {
		sleep(3000);
		String spreadTypeElement = "//select[@id='secId:frmManualBatchPosting:j_id_id5pc7::content']//option";
		List<String> getSpreadType = getListOfDropDownValues(spreadTypeElement);
		List<String> lstSprdTyp = new ArrayList<String>();
		for (int k = 0; k < getSpreadType.size(); k++) {
			if (getSpreadType.get(k).contains("[")) {
				lstSprdTyp.add(getSpreadType.get(k).split("\\[")[0].trim());
			} else {
				lstSprdTyp.add(getSpreadType.get(k));
			}
		}
		String spreadTypeExcel = data.get("SpreadType");
		List<String> lstExcelSprdTyp = splitInputData(spreadTypeExcel, ",");
		return verifyDropDownValue("SpreadType", lstExcelSprdTyp, lstSprdTyp);
	}

	// Verify KSIOP data in CenterCut
	@SuppressWarnings("unchecked")
	public void verifyCenterCutData(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		reportData.add(waitForVisibilityOfElement(appPages.globalEvent_page.btn_CCManagement, "Managemenmt"));
		reportData.add(click(appPages.globalEvent_page.btn_CCManagement, "HCACCManagement Button"));
		reportData.add(click(appPages.globalEvent_page.btn_WorkProcess, "WorkProcess Button"));
		reportData.add(waitForVisibilityOfElement(appPages.globalEvent_page.txt_CCId, ""));
		reportData.add(type(appPages.globalEvent_page.txt_CCId, data.get("CCId"), "CCID TextBox"));
		reportData.add(click(appPages.globalEvent_page.btn_SearchCCId, "SearchCCID Button"));
		waitForVisibilityOfElement(appPages.globalEvent_page.lnk_AccountInfo, "AccountInfo");
		reportData.add(click(appPages.globalEvent_page.lnk_AccountInfo, "AccountInfo"));
		reportData.add(click(appPages.globalEvent_page.btn_Execc, "Execc Button"));
		createReportTableEntry(reportData, "verifyCenterCutData");
		logger.log(LogStatus.INFO, "Successfully Verified CenterCut with KSIOP",
				attchedStepScreenShot("Successfully Verified CenterCut with KSIOP", "Yes"));
	}

	@SuppressWarnings("unchecked")
	public void verifyKSIOPData(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Cash flow", "Posting Result"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(type(appPages.globalEvent_page.txt_UserCode, "ORFI", "UserCode TextBox"));
		reportData.add(click(appPages.globalEvent_page.btn_SearchUserCode, "UserCodeSearch Button"));
		sleep(2000);
		waitForVisibilityOfElement(appPages.globalEvent_page.btn_Cancel, "Cancel Button");
		reportData.add(click(appPages.globalEvent_page.btn_Cancel, "Cancel Button"));
		
		sleep(2000);

		try{
			////div[contains(@id,'secId:tblPostingResultsv:j')]/table/tbody//td[3]
			String elementName = "(//span[text()='"+ data.get("PaymentMethod") + "']/../../../../td[7]//span[text()='" + data.get("CheckAmount")+ "'])[1]";
			if (getWebelement("XPATH", elementName) != null) {
				reportData.add(verifyTableValue(elementName, "PaymentMethod & CheckAmount"));
				//div[contains(@id,'secId:tblPostingResultsv:j')]/table/tbody//td[3]
				reportData.add(click(
						getWebelement("XPATH",
								"(//span[text()='"
										+ data.get("PaymentMethod") + "']/../../../../td[7]//span[text()='"
										+ data.get("CheckAmount") + "']/../../../..//td[3]//a[text()])[1]"),
						"Manual Link"));
				double amount = 0;
				try {
					for (int i = 1; i <= Integer.parseInt(data.get("NoOfPayments")); i++) {
						int j=1;
						waitForVisibilityOfElement(setStringValueInToWebElement(appPages.globalEvent_page.lnk_BatchRef, Integer.toString(i),"XPATH"),"BatchReference Link");
						reportData.add(click(getStringWebElement(appPages.globalEvent_page.lnk_BatchRef, Integer.toString(i)),"XPATH", "BatchReference Link"));
						String amt = getWebelement("XPATH","//div[contains(@id,':innerTbl::db')]/table/tbody//tr[" + j + "]/td[4]//span[text()]").getText();
						
						String floatAmt = amt.replace(",", "");

						double paymentAmount = Double.parseDouble(floatAmt);
						amount = amount + paymentAmount;
						reportData.add(click(appPages.globalEvent_page.tab_BatchList,"BatchList Tab"));
					}
				} catch (NumberFormatException e) {
					System.out.println(e);
				}

				String reportString;
				DecimalFormat df = new DecimalFormat("###,###.00");
				String dfAmount = df.format(amount);
				System.out.println(dfAmount);
				if (data.get("CheckAmount").equals(dfAmount)) {
					reportString = "Pass" + "~" + "Verify" + "~" + "CheckAmount" + "~" + "Match Found For " + dfAmount;
				} else {
					reportString = "Fail" + "~" + "Verify" + "~" + "CheckAmount" + "~" + "Expected- "
							+ data.get("CheckAmount") + " But Actual- " + dfAmount;
				}
				reportData.add(reportString);
			} else {
				reportData.add("Fail" + "~" + "ElementPresent" + "~" + "PostingResult Table" + "~" + " For Element "
						+ elementName);
			}
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "PostingResult" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}

		createReportTableEntry(reportData, "verifyKSIOPData");
		logger.log(LogStatus.INFO, "Successfully Verified KSIOP Data",
				attchedStepScreenShot("Successfully Verified KSIOP Data", "Yes"));
	}

	@SuppressWarnings("unchecked")
	public void fillCollectionGlobalEventListDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Collections", "Global Events"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(click(appPages.globalEvent_page.btn_NewEventList, "New Button"));
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		reportData.add(select(appPages.globalEvent_page.lst_EventtoRun, "Create BK Case", "EventToRun Dropdown"));
		reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
		reportData.add(click(appPages.globalEvent_page.btn_GeneralInformationNext, "Next Button"));
		try {
			reportData
			.add(waitForVisibilityOfElement(appPages.globalEvent_page.txt_BankoFileUpload, "Banko UploadBox"));
			reportData = concatList(reportData,
					uploadDocument(appPages.globalEvent_page.txt_BankoFileUpload, "D:\\Bankruptcy_BANKO_EN.xlsx"));
		} catch (Exception e) {
			System.out.println(e);
		}
		createReportTableEntry(reportData, "fillCollectionGlobalEventListDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Global Event Details",
				attchedStepScreenShot("Successfully Filled Global Event Details", "Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To create New Bk Case
	 */
	public void createNewBKCase(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homescreen_funcs=new HomeScreen_Funcs(driver,logger);
		reportData = concatList(reportData,homescreen_funcs.clickMenuListItem("Collections","Global Events"));

		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		reportData.add(click(appPages.commonSrn_page.btn_New,"New Button")); 
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		reportData.add(select(appPages.globalEvent_page.lst_EventtoRun,data.get("EventsToRun"),"EventToRun Dropdown"));
		reportData.add(scrollToView(appPages.globalEvent_page.btn_GeneralInformationNext,"Next Button"));
		reportData.add(click(appPages.globalEvent_page.btn_GeneralInformationNext,"Next Button"));
		createReportTableEntry(reportData, "createNewBKCase");
		logger.log(LogStatus.INFO, "Successfully Verified BKCase with KSIOP", attchedStepScreenShot("Successfully Verified BKCase with KSIOP","Yes"));
	}

	public void verifyBankoScreenNumber(HashMap<String, String> data) throws Throwable {	
		List<String> reportData =  new ArrayList<String>();
		String path=data.get("filepath");
		reportData = concatList(reportData,uploadDocument(appPages.globalEvent_page.txt_FileUpload,path));
		List<String> importedBankoList=new ArrayList<String>(); 
		try{
			int importdatasize=driver.findElements(By.xpath("//div[@id='j_id_id8pc8:innerTbl::db']//table//tr//td[4]//nobr//span//span")).size();
			String reportString;

			for(int i = 1;i<=importdatasize;i++){
				String importdata= String.format(appPages.globalEvent_page.tab_ImportedBANKOdataTest, i);
				WebElement importdataxpath=getWebelement("xpath", importdata);
				scrollToView(importdataxpath," ");
				String value=importdataxpath.getText();
				importedBankoList.add(value);
			}
			System.out.println(importedBankoList);
			int checkbitforimported=-1;
			for(int i=0;i<importedBankoList.size();i++){
				int importedBankoScreenNum=Integer.parseInt(importedBankoList.get(i));
				if(importedBankoScreenNum == 1 || importedBankoScreenNum == 2){
					checkbitforimported=1;
				}
				else{
					reportData.add("Fail" + "~" + "importedTableData" + "~" + "screenNumber" + "~" + "Not matched with screen number either of 1 or 2. As the presented values in the table are " + importedBankoList);
					break;
				}
			}
			if(checkbitforimported==1){
				reportString ="Pass" + "~" + "importedTableData" + "~" + "screenNumber" + "~" + "Matched with screen number either of 1 or 2. As the presented values in the table are " + importedBankoList;
				reportData.add(reportString);
			}
			else{
				reportString ="Error" + "~" + "importedTableData" + "~" + "screenNumber" + "~" + "No values are present";
				reportData.add(reportString);
			}

			reportData.add(JSClick(appPages.globalEvent_page.tab_NotImportedBANKOdata, "NotImportedBANKOdata Tab"));
			sleep(5000);
			List<String> nonImportedBankoList=new ArrayList<String>(); 
				int notimportdatasize=driver.findElements(By.xpath("//div[@id='j_id_id10pc8:innerTbl::db']//table//tr//td[3]//nobr//span//span")).size();
				for(int i = 1;i<=notimportdatasize;i++){
					String notimportdata = String.format(appPages.globalEvent_page.tab_NotImportedBANKOdataTest, i);
					WebElement importdataxpath=getWebelement("xpath", notimportdata);
					String value2=importdataxpath.getText();
					nonImportedBankoList.add(value2);
				}

				int checkbitforNotimported=-1;
				for(int i=0;i<nonImportedBankoList.size();i++){
					int nonImportedBankoScreenNum=Integer.parseInt(nonImportedBankoList.get(i));
					if(nonImportedBankoScreenNum == 3){
						checkbitforNotimported=1; 
					}
					else{
						reportString = "Fail" + "~" + "notImportedTableData" + "~" + "screenNumber" + "~" + "Not matched with screen number 3. As the presented values in the table are " + nonImportedBankoList;
						reportData.add(reportString);
						break;
					}
				}
				if(checkbitforNotimported==1){
					reportString ="Pass" + "~" + "notImportedTableData" + "~" + "screenNumber" + "~" + "matched with screen number 3. As the presented values in the table are " + nonImportedBankoList;
					reportData.add(reportString);
				}
				else{
					reportString ="Error" + "~" + "notImportedTableData" + "~" + "screenNumber" + "~" + "No values are present";
					reportData.add(reportString);
				}
			}catch(Exception e){
				reportData.add("Fail" + "~" + "isPresentelement" + "~" + "ScreenNumber" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
			}
		
		

		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		reportData.add(isPresentAndDisplayed(appPages.globalEvent_page.lbl_EventList, "EventList Label"));
		//reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		createReportTableEntry(reportData, "verifyBankoScreenNumber");
		logger.log(LogStatus.INFO, "Successfully Uploaded and Verified BANKO Screen Values", attchedStepScreenShot("Successfully Uploaded and Verified BANKO Screen Values","Yes"));
	} 

	@SuppressWarnings("unchecked")
	public void verifyGroupTypeDropdownValues(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Cash flow", "Manual Batch Posting"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CollectionsAndDisbursements Screen"));
		waitForVisibilityOfElement(appPages.globalEvent_page.txt_BatchAmount,  "BatchAmount TextBox");
		reportData.add(type(appPages.globalEvent_page.txt_BatchAmount, data.get("CheckAmount"), "BatchAmount TextBox"));
		reportData.add(type(appPages.globalEvent_page.txt_BatchNoOfChecks, data.get("NoOfPayments"), "BatchAmount TextBox"));
		waitForVisibilityOfElement(appPages.globalEvent_page.btn_CheckInfoNew, "New Button");
		reportData.add(click(appPages.globalEvent_page.btn_CheckInfoNew, "New Button"));

		//reportData.add(select(appPages.globalEvent_page.lst_PaymentMethod, data.get("PaymentMethod"),"GroupType Dropdown"));
		sleep(3000);
		reportData = concatList(reportData, check_Grouptype_1(data));
		createReportTableEntry(reportData, "verifyGroupTypeDropdownLockBoxOptions");
		logger.log(LogStatus.INFO, "Successfully Verified GroupType LockBox Dropdown Options",attchedStepScreenShot("Successfully Verified GroupType LockBox Dropdown Options", "Yes"));
	}


	@SuppressWarnings("unchecked")
	public void fillCheckInformation(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Cash flow", "Manual Batch Posting"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CollectionsAndDisbursements Screen"));
		waitForVisibilityOfElement(appPages.globalEvent_page.lst_InputType, "InputType Dropdown");
		reportData.add(select(appPages.globalEvent_page.lst_InputType,data.get("InputType"), "InputType Dropdown"));
		if(data.get("InputType").equals("Manual"))
		{
			waitForVisibilityOfElement(appPages.globalEvent_page.txt_BatchAmount,  "BatchAmount TextBox");
			reportData.add(type(appPages.globalEvent_page.txt_BatchAmount, data.get("CheckAmount"), "BatchAmount TextBox"));
			reportData.add(type(appPages.globalEvent_page.txt_BatchNoOfChecks, data.get("NoOfPayments"), "BatchAmount TextBox"));
			
			for (int i=1; i<=Integer.parseInt(data.get("NoOfPayments")) ; i++) {
				try{
					reportData.add(click(appPages.globalEvent_page.btn_CheckInfoNew, "New Button"));
					sleep(3000);
					String checkNumber =generateRandomString(5,false,true);
					setValueProperty("CheckNumber_"+i, checkNumber);
					reportData.add(type(getStringWebElement(appPages.globalEvent_page.txt_CheckNumber, Integer.toString(i)), "XPATH", true, checkNumber, "CheckNumber TextBox"));
					setStringValueInToWebElement(appPages.globalEvent_page.txt_CheckNumber, Integer.toString(i), "XPATH").sendKeys(Keys.TAB);
					sleep(3000);
					String Amount= data.get("CheckAmount").replace(",", "");
					Double CheckAmount = Double.parseDouble(Amount);
					//reportData.add(type(getStringWebElement(appPages.globalEvent_page.txt_CheckAmount, Integer.toString(i)),"XPATH", true, Double.toString(CheckAmount / Double.parseDouble(data.get("NoOfPayments"))), "CheckAmount TextBox"));
					reportData.add(JSType(getStringWebElement(appPages.globalEvent_page.txt_CheckAmount, Integer.toString(i)),"XPATH", Double.toString(CheckAmount / Double.parseDouble(data.get("NoOfPayments"))), "CheckAmount TextBox"));
					setStringValueInToWebElement(appPages.globalEvent_page.txt_CheckAmount, Integer.toString(i), "XPATH").sendKeys(Keys.TAB);
					
					WebElement checkGroupType = setStringValueInToWebElement(appPages.globalEvent_page.lst_CheckGroupType,  Integer.toString(i) , "XPATH");
					reportData.add(select(checkGroupType,data.get("GroupType_1"), "GroupType Dropdown"));
					WebElement checkCheckType = setStringValueInToWebElement(appPages.globalEvent_page.lst_CheckType,  Integer.toString(i) , "XPATH");
					reportData.add(select(checkCheckType,data.get("CheckType"), "CheckType Dropdown"));
					WebElement checkComments = setStringValueInToWebElement(appPages.globalEvent_page.txt_CheckInformationComments,  Integer.toString(i) , "XPATH");
					reportData.add(type(checkComments, "ok", "Comments TextBox"));
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}else if(data.get("InputType").equals("Excel"))
		{
			waitForVisibilityOfElement(appPages.globalEvent_page.txt_BatchAmount,  "BatchAmount TextBox");
			reportData.add(type(appPages.globalEvent_page.txt_BatchAmount, data.get("CheckAmount"), "BatchAmount TextBox"));
			waitForVisibilityOfElement(appPages.globalEvent_page.txt_BatchNoOfChecks,  "BatchAmount TextBox");
			reportData.add(type(appPages.globalEvent_page.txt_BatchNoOfChecks, data.get("NoOfPayments"), "BatchAmount TextBox"));
			//reportData.add(click(appPages.globalEvent_page.btn_FileUpload,"FileUpload Button"));
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\InputFiles\\"+ data.get("fileName");
			reportData = concatList(reportData,uploadDocument(appPages.globalEvent_page.txt_ManualPaymentFileUpload,path));
			reportData.add(acceptAlert("OK"));
			reportData.add(waitForVisibilityOfElement(appPages.globalEvent_page.vfy_CheckInformationTable, "CheckInformation Table"));
			reportData.add(waitForVisibilityOfElement(appPages.globalEvent_page.vfy_PaymentInformationTable, "PaymentInformationInformation Table"));
			reportData.add(click(appPages.globalEvent_page.btn_Save, "Save Button"));
		}
		createReportTableEntry(reportData, "fillCheckInformation");
		logger.log(LogStatus.INFO, "Successfully filled Check Information",attchedStepScreenShot("Successfully filled Check Information", "Yes"));
	}

	public void fillPaymentInformation(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		for (int i = 1; i <= Integer.parseInt(data.get("NoOfPayments")); i++) {
			sleep(1000);
			reportData.add(click(appPages.globalEvent_page.btn_PaymentInformationNew, "New Button"));
			sleep(2000);
			String checkNumber = getValueProperty("CheckNumber_"+i);

			reportData.add(select(appPages.globalEvent_page.lst_CheckNumber, checkNumber, "CheckNumber Dropdown"));
			//waitForVisibilityOfElement(appPages.globalEvent_page.chk_Consolidated, "Consolidate CheckBox");
			//reportData.add(click(appPages.globalEvent_page.chk_Consolidated, "Consolidate CheckBox"));
			sleep(2000);
			if(appPages.globalEvent_page.txt_BillingAccount.isEnabled() )
			{
				reportData.add(type(appPages.globalEvent_page.txt_BillingAccount, data.get("Billing Account"),"BillingAccountNumber TextBox"));
				appPages.globalEvent_page.txt_PaymentAmount.click();
				reportData.add(acceptAlert(""));
				waitForVisibilityOfElement(appPages.globalEvent_page.btn_AccountSearchPopupClose, "CloseSearch Button");
				reportData.add(click(appPages.globalEvent_page.btn_AccountSearchPopupClose, "CloseSearch Button"));
			}
			else{
				reportData.add(type(appPages.globalEvent_page.txt_AccountNum, data.get("AccountNumber"),"AccountNumber TextBox"));
				appPages.globalEvent_page.txt_PaymentAmount.click();
			}
			sleep(5000);
			if (Integer.parseInt(data.get("NoOfPayments")) > 1) {
				String amt = data.get("CheckAmount");
				String CAmount = amt.replace(",", "");
				Double CheckAmount = Double.parseDouble(CAmount);
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount,true,Double.toString(CheckAmount / Double.parseDouble(data.get("NoOfPayments"))),"PaymentAmount TextBox"));
				waitForVisibilityOfElement(appPages.globalEvent_page.lst_SpreadType,"SpreadType DropDown");
				reportData.add(select(appPages.globalEvent_page.lst_SpreadType,"Waterfall","SpreadType DropDown"));
			} else {
				reportData.add(type(appPages.globalEvent_page.txt_PaymentAmount, data.get("CheckAmount"),"TotalAmount TextBox"));
				waitForVisibilityOfElement(appPages.globalEvent_page.lst_SpreadType,"SpreadType DropDown");
				reportData.add(select(appPages.globalEvent_page.lst_SpreadType,"Waterfall","SpreadType DropDown"));
			}
			scrollToView(appPages.globalEvent_page.btn_Save, "Save Button");
			reportData.add(click(appPages.globalEvent_page.btn_Save, "Save Button"));

			if (isAlertPresent()) {
				reportData.add(acceptAlert("PaymentAmount Alert"));
			}
			sleep(2000);
		}
		createReportTableEntry(reportData, "fillPaymentInformation");
		logger.log(LogStatus.INFO, "Successfully filled Payment Information",attchedStepScreenShot("Successfully filled Payment Information", "Yes"));
	}


	public void verifySpreadTypeDropdownValues(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.globalEvent_page.btn_PaymentInformationNew, "New Button"));
		waitForVisibilityOfElement(appPages.globalEvent_page.lst_SpreadType,"SpreadType DropDown");
		reportData = concatList(reportData, check_Spreadtype(data));
		createReportTableEntry(reportData, "verifySpreadTypeDropdownValues");
		logger.log(LogStatus.INFO, "Successfully Verified Spread Type DropDown Values",attchedStepScreenShot("Successfully Verified Spread Type DropDown Values", "Yes"));
	}
}
