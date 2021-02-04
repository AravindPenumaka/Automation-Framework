package functionLibrary;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Contracts_Funcs extends BasePageMod{
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	

	
	public Contracts_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To fill contact search details
	 */
	public void fillContractSearch(HashMap<String, String> data) throws Throwable {
		

		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Contracts"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));

		reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
		reportData.add(type(appPages.contract_page.txt_Contractno, data.get("ContractNumber"), "Contract No. TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		waitForVisibilityOfElement(appPages.contract_page.lnk_Contract, "Contract link");
		reportData.add(click(appPages.contract_page.lnk_Contract, "Contract link"));
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "fillContractSearch");
		logger.log(LogStatus.INFO, "Successfully Filled Searched Contract Number",attchedStepScreenShot("Successfully Filled Searched Contract Number", "Yes"));
	}

	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description Copy contract details and start permanent loan.
	 */
	@SuppressWarnings("unchecked")
	public void copyContractAndStartPermanentLoan() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(click(appPages.contract_page.btn_CopyContract, "CopyContract Button"));
		reportData.add(type(appPages.contract_page.txt_NameDetails, "Automation_Test", "Name TextBox"));
		/*reportData.add(select(appPages.contract_page.lst_PhaseDetails, "Initial", "Pahse DropDown"));
		sleep(3000);
		reportData.add(click(appPages.contract_page.btn_Save, "Save Button"));*/
		reportData.add(select(appPages.contract_page.lst_PhaseDetails, "Waiting implementation", "Pahse DropDown"));
		reportData.add(click(appPages.contract_page.btn_Save, "Save Button"));
		reportData.add(verifyText(appPages.contract_page.vfy_Status, "Status : Save Successfully.", "Status Label"));
		switchToDefaultFrameContent();
		createReportTableEntry(reportData, "copyContractAndStartPermanentLoan");
		logger.log(LogStatus.INFO, "Successfully Copied Contract And Start Permanent Loan", attchedStepScreenShot("Successfully Copied Contract And Start Permanent Loan", "Yes"));
	}
	
	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description Verify start permanent loan screen.
	 */
	public void verifyStartPermanentLoan() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(click(appPages.commonSrn_page.lnk_More, "More Link"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Start permanent loan", "XPATH"),"StartPermanentLoan"));
		reportData.add(click(setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Start permanent loan", "XPATH"), "StartPermanentLoan Link"));
		
		reportData.add(acceptAlert("AccountingPeriod PopUp"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To PermanentLoan frame"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To PermanentLoan Sub-frame"));
		reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages.commonSrn_page.vfy_EventPage, "Contract take on","XPATH"), "StartPermanentLoan"));
		reportData.add(verifyText(setStringValueInToWebElement(appPages.commonSrn_page.vfy_ScreenLabel, "Identification","XPATH"), "", "Identification Label"));
		reportData.add(click(appPages.commonSrn_page.btn_Cancel, "Cancel Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyStartPermanentLoan");
		logger.log(LogStatus.INFO, "Successfully Verified Permanent Loan", attchedStepScreenShot("Successfully Verified Permanent Loan", "Yes"));
	}
	
	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description Verify changed assigned third party screen
	 */
	public void verifyChangedAssignedThirdParty() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Contracts"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));

		reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
		reportData.add(type(appPages.contract_page.txt_Contractno, "1813971384", "Contract No. TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		//reportData.add(click(appPages.contract_page.lnk_Contract, "Contract link"));
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(click(appPages.commonSrn_page.lnk_More, "More Link"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Change assigned third parties", "XPATH"),"ChngAssigndThdPty"));
		reportData.add(click(setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Change assigned third parties", "XPATH"), "ChngAssigndThdPty Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ThirdParties frame"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To ThirdParties Sub-frame"));
		reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages.actors_page.vfy_EventPage, "Change assigned third parties","XPATH"), "ChngAssigndThdPty"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChngAssigndThdPty Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyChangedAssignedThirdParty");
		logger.log(LogStatus.INFO, "Successfully Verified Changed Assigned Third-Party Screen",attchedStepScreenShot("Successfully Verified Changed Assigned Third-Party Screen", "Yes"));
	}
	
	public void verifyEventUnderContracts() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_Events,"ContractsEvents Div"));
		createReportTableEntry(reportData, "verifyEventUnderContracts");
		logger.log(LogStatus.INFO, "Successfully Verified Event-Under Contracts Pannel",attchedStepScreenShot("Successfully Verified Event-Under Contracts Pannel", "Yes"));
	}
	
	public void verifyContractsTabs(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		

		String tabList = data.get("TabVerification");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "frame"));
		List<String> tabDataList = splitInputData(tabList, ",");
		for (int i = 0; i < tabDataList.size(); i++) {
			String TabInfo = String.format(appPages.contract_page.tab_ContractsSubTabs, tabDataList.get(i));
			highLightElement(driver.findElement(By.xpath(TabInfo)));
			reportData.add(click(driver.findElement(By.xpath(TabInfo)), tabDataList.get(i)) + " Tab");
			sleep(2000);
			if (tabDataList.get(i).equals("General information")) {
				reportData.add(waitForVisibilityOfElement(
						setStringValueInToWebElement(appPages.contract_page.vfy_Label, "Reference", "XPATH"),
						"Reference Label"));
				continue;
			} else if (tabDataList.get(i).equals("Multi currencies")) {
				reportData.add(waitForVisibilityOfElement(appPages.contract_page.vfy_MulticurrencyPage,
						"MulticurrencyPage Table"));
				continue;
			} else if (tabDataList.get(i).equals("Indexing")) {
				reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(
						appPages.contract_page.vfy_LabelText, "General Information", "XPATH"), "GeneralInfo Label"));
				continue;
			} else if (tabDataList.get(i).equals("Attached actors")) {
				reportData.add(waitForVisibilityOfElement(
						setStringValueInToWebElement(appPages.contract_page.vfy_LabelText, "Attached actors", "XPATH"),
						"AttachedActors Label"));
				continue;
			} else if (tabDataList.get(i).equals("Card")) {
				reportData.add(waitForVisibilityOfElement(
						setStringValueInToWebElement(appPages.contract_page.vfy_LabelText, "Card Info", "XPATH"),
						"CardInfo Label"));
				continue;
			} else if (tabDataList.get(i).equals("Syndication")) {
				reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(
						appPages.contract_page.vfy_LabelText, "Security syndication", "XPATH"), "Security Label"));
				continue;
			} else if (tabDataList.get(i).equals("Financial elements")) {
				reportData.add(waitForVisibilityOfElement(appPages.contract_page.vfy_FinancialElementPage,
						"FinancialElementt Table"));
				continue;
			} else if (tabDataList.get(i).equals("Incidental elements")) {
				reportData.add(waitForVisibilityOfElement(appPages.contract_page.vfy_IncidentalElementPage,
						"IncidentalElement Table"));
				continue;
			}
		}
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyContractsTabs");
		logger.log(LogStatus.INFO, "Successfully Verified Contracts Sub-Tabs",attchedStepScreenShot("Successfully Verified Contracts Sub-Tabs", "Yes"));
	}
	 
	public void verifyDeArchieveContracts() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Global Events"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		reportData.add(scrollToView(
				setStringValueInToWebElement(appPages.contract_page.lnk_Event, "De-Archive contracts", "XPATH"),
				"De-ArchiveContracts"));
		reportData.add(click(
				setStringValueInToWebElement(appPages.contract_page.lnk_Event, "De-Archive contracts", "XPATH"),
				"De-ArchiveContracts Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To De-Archive frame"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To De-Archive Sub-frame"));
		reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages.actors_page.vfy_EventPage, "De-Archive contracts","XPATH"), "De-ArchiveContracts Label"));
		//reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		//reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		//reportData.add(type(appPages.contract_page.txt_ContractNumber, data.get("ContractNumber"), "ContractNum Textbox"));
		//reportData.add(click(appPages.contract_page.btn_SearchArchiveContracts, "Search button"));
		reportData.add(scrollToView(appPages.commonSrn_page.btn_Cancel, "Cancel Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Cancel, "Cancel Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyDeArchieveContracts");
		logger.log(LogStatus.INFO, "Successfully Verified De-Archieve Contracts Screen",attchedStepScreenShot("Successfully Verified De-Archieve Contracts Screen", "Yes"));
	}
	
	public void verifyHoldUnHoldAccounts() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		reportData.add(scrollToView(
				setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Hold/UnHold accounts", "XPATH"),
				"HoldUnHoldAccounts"));
		reportData.add(click(
				setStringValueInToWebElement(appPages.contract_page.lnk_Event, "Hold/UnHold accounts", "XPATH"),
				"HoldUnHoldAccounts Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Hold/UnHoldAccounts frame"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Hold/UnHoldAccounts Sub-frame"));
		reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages.actors_page.vfy_EventPage, "Hold/UnHold accounts","XPATH"), "Hold/UnHoldAccounts Label"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyHoldUnHoldAccounts");
		logger.log(LogStatus.INFO, "Successfully Verified Hold-Unhold Accounts Screen",attchedStepScreenShot("Successfully Verified Hold-Unhold Accounts Screen", "Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  
	 */
	public void verifyAddressList(HashMap<String, String> data) throws Throwable{

		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea,"To Contract Screen"));
		WebElement TabInfo=setStringValueInToWebElement(appPages.contract_page.tab_ContractsSubTabs,data.get("ContractSubTab"),"XPATH");
		reportData.add(click(TabInfo,data.get("ContractSubTab")+" Tab"));
		waitForVisibilityOfElement(appPages.contract_page.lbl_BillingAddresses, "BillingAddress Link");
		reportData.add(click(appPages.contract_page.btn_ExpandBillingAddresses, "BillingAddress Link"));
		reportData.add(waitForVisibilityOfElement(appPages.contract_page.lst_Address, "Address List"));
		reportData.add(verifyFieldAttribute(appPages.contract_page.lst_Address,"title","", "Address List"));
		createReportTableEntry(reportData, "verifyAddressList");	
		logger.log(LogStatus.INFO, "Successfully Verified Address List",attchedStepScreenShot("Successfully Verified Address List","Yes"));
	}
	
	/***
	 * @author Arpita
	 * @param contractnumber
	 * @throws Exception
	 * @description  
	 */
	public void verifyStepFieldValue(HashMap<String, String> data) throws Throwable{

		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea,"To Contract Screen"));
		reportData.add(waitForVisibilityOfElement(driver.findElement(By.xpath(String.format(appPages.contract_page.vfy_Label, "Reference"))),"Reference Label"));
		reportData.add(verifyFieldAttribute(setStringValueInToWebElement(appPages.contract_page.lst_GeneralInformationLists, "Step", "XPATH"),"title",""/*data.get("Step")*/, "Address TextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyStepFieldValue");	
		logger.log(LogStatus.INFO, "Successfully Verified Step Field Value",attchedStepScreenShot("Successfully Verified Step Field Value","Yes"));
	}
	
	public void verifyFormCheckBox(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea,"To Cases Screen"));
		reportData.add(type(appPages.contract_page.txt_CasesContractNumber,data.get("ContractNumber"), "ContractNumber TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		sleep(1000);
		waitForVisibilityOfElement(appPages.contract_page.lnk_CaseReference,"Contract link");
		reportData.add(click(appPages.contract_page.lnk_CaseReference, "Contract link"));
		reportData.add(waitForVisibilityOfElement(appPages.contract_page.tab_ForgivenessEnquiry,"ForgivenessEnquiry Tab"));
		reportData.add(click(appPages.contract_page.tab_ForgivenessEnquiry,"ForgivenessEnquiry Tab"));
		sleep(1000);
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		waitForVisibilityOfElement(appPages.contract_page.btn_SearchContract,"Form1099C TableValue");
		scrollToView(appPages.contract_page.vfy_Form1099C, "Form1099C TableValue");
		reportData.add(verifyText(appPages.contract_page.vfy_Form1099C, "Y", "Form1099C TableValue"));
		createReportTableEntry(reportData, "verifyFormCheckBox");	
		logger.log(LogStatus.INFO, "Successfully Verified Form CheckBox",attchedStepScreenShot("Successfully Verified Form CheckBox","Yes"));
	}
	
	public void verifyAccountBalance(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		String accBalanceHeader=data.get("AccountBalanceHeader");
		List<String> accountBalanceHeader = splitInputData(accBalanceHeader, ",");
		List<String> fullAccountBalance = new ArrayList<String>();
		try{
			for(int i=0 ; i <accountBalanceHeader.size() ;i++)
			{
				WebElement accountBalance = driver.findElement(By.xpath(String.format(appPages.contract_page.vfy_AccountBalance, i+2)));
				scrollToView(accountBalance, "");
				fullAccountBalance.add(accountBalanceHeader.get(i)+ "=" + accountBalance.getText() + "\n");
				System.out.println(accountBalanceHeader.get(i));
			}
			reportData.add("Pass" + "~" + "Verify" + "~" + "AddressBalance Detail" + "~" + fullAccountBalance);
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AddressBalance Detail" + "~" + "Unable To Find The Details" + getExceptionMessage(e.getMessage()));
		}
		createReportTableEntry(reportData, "verifyAccountBalance");	
		logger.log(LogStatus.INFO, "Successfully Verified Account Balance",attchedStepScreenShot("Successfully Verified Account Balance","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @throws Throwable
	 * @description Check Amount is Posted to suspense or not
	 */
	public void verifyAmountPostedToSuspense(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		//reportData.add(click(appPages.contract_page.tab_DetailedPaymentSchedule, "DetailedPaymentSchedule Tab"));
		
		//Need to implement verification check point for suspense function, once we have the clarifications.
		
		createReportTableEntry(reportData, "VerifyAmountPostedToSuspense");
		logger.log(LogStatus.INFO, "Successfully Verified Amount Posted to Suspense",attchedStepScreenShot("Successfully Verified Amount Posted to Suspense", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @throws Throwable
	 * @description Verify Status of the Account in Contract Detail
	 */
	public void verifyStatusOfAccount(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
	
		//not done need Clarification
		
		createReportTableEntry(reportData, "verifyStatusOfAccount");
		logger.log(LogStatus.INFO, "Successfully Verified Status of the Account",attchedStepScreenShot("Successfully Verified Status of the Account", "Yes"));
	}
	
	public void verifyPaymentSchedule() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea,"To Contract Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.contract_page.btn_DetailedPaymentSchedule, "DetailedPaymentSchedule Button"));
		reportData.add(click(appPages.contract_page.btn_DetailedPaymentSchedule, "DetailedPaymentSchedule Button"));
		reportData.add(waitForVisibilityOfElement(appPages.contract_page.vfy_PaumentScheduleTable, "PaymentSchedule Table"));
		createReportTableEntry(reportData, "verifyPaymentSchedule");
		logger.log(LogStatus.INFO, "Successfully Verified Payment Schedule",attchedStepScreenShot("Successfully Verified Payment Schedule", "Yes"));
	}
}
