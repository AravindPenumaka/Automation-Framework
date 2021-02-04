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
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Actors_Funcs extends BasePageMod{
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	HashMap<String, String> data;
	
	public Actors_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
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
	public void validateIdentityDetails(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName, testCase);
		reportData.add(click(appPages.actors_page.lnk_ModifyAddress, " Modify Address Link"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Sub-Actor Screen"));

		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_Reference, "value", "null", "Identity Detail"));
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		createReportTableEntry(reportData, "verifyIdentityDetails");
		logger.log(LogStatus.INFO, "Successfully Validated Identity Details");
	}
	 
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Fill Modify Address Details
	 */
	public void fillModifyAddressDetails(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName, testCase);
		System.out.println(data.get("NewAddress"));
		reportData.add(click(appPages.actors_page.btn_New, "New Button"));
		Thread.sleep(2000);
		reportData.add(click(appPages.actors_page.cb_New, "New Row Selected"));
		reportData.add(type(appPages.actors_page.txt_Address1, data.get("NewAddress"), "Address"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillModifyAddressDetails");
		System.out.println("Successfully filled Modify Address Details");
		logger.log(LogStatus.INFO, "Successfully filled Modify Address Details");
		Thread.sleep(3000);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Search Actor ID
	 */
	public void searchActorId(String sheetName, String testCase) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName,testCase);
     	System.out.println(data.get("AcctorId"));
     	HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
     	
     	reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(type(appPages.actors_page.txt_ActorId,data.get("ActorId"), "ActorId Textbox"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_MoreOption,"MoreOptions Button"));
		reportData.add(click(appPages.actors_page.btn_Search,"Search Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_Reference,"Reference Link"));
		reportData.add(switchToDefaultFrameContent());
        createReportTableEntry(reportData, "SearchActorId");
        logger.log(LogStatus.INFO, "Successfully Searched Actor ID");
	}
	
	public void verifyActorDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData,this.verifyActorIndentityDetails());
		reportData = concatList(reportData,this.verifyActorIndividualDetails());
		reportData = concatList(reportData,this.verifyActorAddressDetails());
		reportData = concatList(reportData, this.verifyActorContactDetails());
		reportData = concatList(reportData, this.verifyAssentDetails());
		createReportTableEntry(reportData, "verifyActorDetails");
	}
	
	public void verifyCOBActorDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData,this.verifyActorIndentityDetails());
		reportData = concatList(reportData,this.verifyActorIndividualDetails());
		reportData = concatList(reportData,this.verifyActorAddressDetails());
		reportData = concatList(reportData, this.verifyActorContactDetails());
		createReportTableEntry(reportData, "verifyCOBActorDetails");
	}
	
	public List<String> verifyActorIndentityDetails(){
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_ActorReference,"value","null"," ActorReference TextBox"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_Phase,"title","null","IdentityPhase Dropdown"));
		return reportData;
	}
	
	public List<String> verifyActorIndividualDetails() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.actors_page.tab_Individual, "Individual Tab"));
		sleep(2000);
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_FullName, "value", "null", "FullName TextBox"));
		reportData.add(verifyText(appPages.actors_page.lbl_JobHistory, "Job History", "JobHistory Table"));
		return reportData;
	}

	public List<String> verifyActorAddressDetails() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.actors_page.tab_Address, "Addresses Tab"));
		String tbl_addList = appPages.actors_page.tbl_AddList;
		String tbl_addListHeader = appPages.actors_page.tbl_AddListHeader;
		List<String> fullAddressDetails = new ArrayList<String>();
		String addressList = null;
		String addressHead = null;
		WebElement addHeader = null;
		WebElement address = null;
		sleep(1200);
		for (int i = 2; i <= 13; i++) {
			addressHead = String.format(tbl_addListHeader, i);
			scrollToView(driver.findElement(By.xpath(addressHead)), "");
			addHeader = driver.findElement(By.xpath(addressHead));
			addressList = String.format(tbl_addList, i);
			address = driver.findElement(By.xpath(addressList));
			fullAddressDetails.add(addHeader.getText() + "=" + address.getText() + "\n");
			System.out.println(addHeader.getText() + "=" + address.getText() + "\n");
		}

		reportData.add("Pass" + "~" + "Verify" + "~" + "Address Detail" + "~" + fullAddressDetails);
		return reportData;
	}
	
	public List<String> verifyActorContactDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.actors_page.tab_Contacts, "Contacts Tab"));
		sleep(2000);
		reportData.add(verifyText(appPages.actors_page.lbl_Telecome, "Telecom", "Contacts Details Table"));
		return reportData;
	}
	
	 public void verifyRoleDetails() throws Throwable {
		 List<String> reportData =  new ArrayList<String>();
		 reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
	     Thread.sleep(2000);
		 reportData.add(click(appPages.actors_page.tab_Role,"Role Tab"));
		 sleep(2000);
		 reportData.add(verifyText(appPages.actors_page.lbl_RoleList,"List of Roles","List of Roles Table"));
		 createReportTableEntry(reportData, "verifyRoleDetails");
	     Thread.sleep(3000);
	 }
	 
	public void searchReferenceActorCode(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(5000);
		data = basepageData.fetchInputData(sheetName, testCase);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Tasks", "Tasks"));

		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(type(appPages.task_page.txt_ReferenceCode, data.get("ActorCode"), "ActorCode TextBox"));
		reportData
				.add(type(appPages.task_page.txt_BaseDateFrom, true, data.get("BaseDateFrom"), "BaseDateFrom TextBox"));
		reportData.add(type(appPages.task_page.txt_BaseDateTo, true, data.get("BaseDateTo"), "BaseDateTo TextBox"));
		sleep(2000);
		reportData.add(click(appPages.task_page.btn_Search, "Search Button"));
		sleep(2000);
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchReferenceActorCode");
		logger.log(LogStatus.INFO, "Successfully Searched Actor Code...");

	}
	
	
	// newly added for Cust_Info_Pref_Changes
	public void verifyLastName(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName, testCase);
		System.out.println(data.get("LastName"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		Thread.sleep(2000);
		WebElement lbl_lastName = appPages.actors_page.lbl_LastName;
		reportData.add(verifyFieldAttribute(lbl_lastName, "value", data.get("LastName"), "LastName TextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyLastName");
	}
		
	// newly added for Cust_Info_Pref_Changes
	public void fillChangeTradename(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName, testCase);
		System.out.println(data.get("NewLastName"));
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.actors_page.lnk_ChangeTradeName, "ChangeTradeName Link"));
		reportData.add(click(appPages.actors_page.lnk_ChangeTradeName, "ChangeTradename Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(type(appPages.actors_page.txt_LastName, true, data.get("NewLastName"), "LastName Textbox"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillChangeTradename");

	}
		 
	// newly created for Cust_Info_Pref_Changes

	public List<String> verifyAssentDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		Thread.sleep(3000);
		reportData.add(click(appPages.actors_page.btn_MoreActorOption, "MoreActorOption Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.tab_Assent, "Assent Tab"));
		Thread.sleep(3000);
		String tbl_AssentList = appPages.actors_page.tbl_AssentList;
		String tbl_AssentHeader = appPages.actors_page.tbl_AssentHeader;
		List<String> fullAssentDetails = new ArrayList<String>();
		String AssentList = null;
		String AssentHead = null;
		WebElement assentHeader = null;
		WebElement assent = null;
		sleep(1200);
		for (int i = 2; i <= 7; i++) {
			AssentHead = String.format(tbl_AssentHeader, i);
			scrollToView(driver.findElement(By.xpath(AssentHead)), "");
			assentHeader = driver.findElement(By.xpath(AssentHead));
			AssentList = String.format(tbl_AssentList, i);
			assent = driver.findElement(By.xpath(AssentList));
			fullAssentDetails.add(assentHeader.getText() + "=" + assent.getText() + "\n");
			System.out.println(assentHeader.getText() + "=" + assent.getText() + "\n");
		}

		reportData.add("Pass" + "~" + "Verify" + "~" + "Assent Detail" + "~" + fullAssentDetails);
		return reportData;
	}
		 
	
	
	
	
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To click Past Event Data
	 */
	
	 public void clickPastEventTab() throws Exception{
			List<String> reportData =  new ArrayList<String>();
	        reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actors Screen"));
	        sleep(3000);
	        //switchToDefaultFrameContent();
		    reportData.add(click(appPages.actors_page.btn_ArrowMark_ActroListPage,"Arrow Button"));
		    reportData.add(click(appPages.actors_page.sel_PastEvent,"PastEvents Select"));
		  
		    createReportTableEntry(reportData, "clickPastEventTab");
		    logger.log(LogStatus.INFO, "Successfully Pastevent tab is opened ","");
		    
		}
	 /***
		 * @author Koyal
		 * @param sheetName
		 * @param testCase
		 * @throws Throwable
		 * @description To Verify PastEvent Pop up elements
		 */
	 public void verifyPastEventsData() throws Exception{
			List<String> reportData =  new ArrayList<String>();
	        
		    reportData.add(click(appPages.actors_page.lnk_PastEvent,"PastEvent Tab"));
		    sleep(2000);
		    reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To PastEvent Screen"));
		    Thread.sleep(2000);
		    String data=appPages.actors_page.vfy_PastEventData.getText();
		    System.out.println(data);
		    String reportString = "Pass" + "~" + "getData" + "~" + "Details" + "~" + data;
		    reportData.add(reportString);
		    createReportTableEntry(reportData, "verifyPastEventsData");
		    logger.log(LogStatus.INFO, "Successfully Pastevent data link is opened ","");
		    
		}
	 
	 /***
		 * @author Koyal
		 * @param sheetName
		 * @param testCase
		 * @throws Throwable
		 * @description click on new button in ActorList page
		 */
	 public List<String> actorListPageClickOnNew() throws Throwable 
	 {
		 List<String> reportData =  new ArrayList<String>();
		 WebElement NewLink=appPages.actors_page.lnk_NewActorList;
		 reportData.add(isPresentAndDisplayed(NewLink,"New link"));
		 reportData.add(click(NewLink,"New link"));
		 sleep(3000);
		return reportData;
	 }
	 
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Input data to create new Actor
	 */
	public void createNewActor(String sheetName, String testCase) throws Throwable {
		data = basepageData.fetchInputData(sheetName, testCase);
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData, this.actorListPageClickOnNew());
		WebElement lbl_phase = appPages.actors_page.lbl_Phase;
		reportData.add(verifyFieldAttribute(lbl_phase, "title", "", "IdentityPhase Dropdown"));
		reportData.add(verifyText(appPages.actors_page.lbl_ActorType, "Actor Type", "ActorType"));
		reportData.add(select(appPages.actors_page.lst_ActorType, data.get("ActorType"), "ActorType Dropdown"));
		reportData.add(verifyText(appPages.actors_page.lbl_ResidentialStatus, "Residential Status",
				"ResidentialStatus Lable"));
		System.out.println(data.get("ResStatus"));
		reportData.add(select(appPages.actors_page.lst_ResidentialStatus, data.get("ResStatus"),
				"ResidentialStatus Dropdown"));
		sleep(5000);
		reportData.add(verifyText(appPages.actors_page.lbl_BusinessNo, "Business No.", "BusinessNumber Lable"));
		String BusinessNumber = generateRandomString(10, false, true);
		reportData.add(type(appPages.actors_page.txt_BusinessNo, BusinessNumber, "BusinessNumber TextBox"));
		sleep(2000);
		reportData.add(verifyText(appPages.actors_page.lbl_BusinessName, "Business Name", "BusinessName Label"));

		String BusinessName = generateRandomString(3, false, true);
		String ToConcat = "HCA_";
		reportData.add(type(appPages.actors_page.txt_BusinessName, ToConcat.concat(BusinessName), "BusinessName TextBox"));
		sleep(3000);

		reportData.add(verifyText(appPages.actors_page.lbl_FullName2, "Full name 2", "FullName2 Label"));
		String FullName2 = generateRandomString(5, true, false);
		reportData.add(type(appPages.actors_page.lbl_FullName2, ToConcat.concat(FullName2), "FullName2 TextBox"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.lnk_SearchLegalClassification, "LegalClassification Link"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.btn_Validate, "Validate button"));
		reportData.add(verifyText(appPages.actors_page.lbl_BusinessOpeningDate, "Business Opening Date",
				"BusinessOpeningDate Label"));

		String currentdate = getCurrentDate();
		reportData.add(type(appPages.actors_page.dt_BusinessOpeningDate, currentdate, "CurrentDate TextBox"));
		reportData.add(verifyText(appPages.actors_page.lbl_Role, "Role", "Role Label"));
		reportData.add(select(appPages.actors_page.lst_Role, data.get("Role"), "Role Dropdown"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_SaveActorList,"Save Link"));
		createReportTableEntry(reportData, "createNewActor");

	}
	 
	 public String fetchRefActorCode() throws Throwable 
	 {
		 List<String> reportData =  new ArrayList<String>();
		 WebElement lbl_ActorRefenceCode=appPages.actors_page.lbl_ActorRef;
		 reportData.add(verifyFieldAttribute(lbl_ActorRefenceCode,"title","","Identity Phase Dropdown"));
		 createReportTableEntry(reportData, "Fetch_Ref_ActorCode");
		 
		 //Get the Actor refence value
		String ActorRefCode= getAttributeValue(appPages.actors_page.txt_ActorRef,"value");
		return ActorRefCode;
		 
	 }
	 
	 public void referenceCodeForGlobalSearch(String sheetName, String testCase) throws Throwable 
	 {
		 String RefCodeUI=fetchRefActorCode();
		 data = basepageData.fetchInputData(sheetName,testCase);
		 String ActorReference=data.get("ActorCode");
		 switchToDefaultFrameContent();
	 }
	 
	 
	public void navigateToActorListPage(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		Thread.sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor List Page"));
		if (appPages.actors_page.lbl_ActorsListPage.isDisplayed()) {
			reportData.add(verifyText(appPages.actors_page.lbl_ActorsListPage, "Actors List", "Actors List"));
		}
		createReportTableEntry(reportData, "navigateToActorListPage");
		logger.log(LogStatus.INFO, "Successfully Navigated to Actors List Page","");
	}


	// added for sanity test cases
	public void verifyActorTabs(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		data = basepageData.fetchInputData(sheetName, testCase);
		String tabList = data.get("TabVerification");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "Actor Screen"));
		List<String> tabDataList = splitInputData(tabList, ",");
		
		for (int i = 0; i < tabDataList.size(); i++) {
			String TabInfo = String.format(appPages.actors_page.tab_ActorSubTabs, tabDataList.get(i));
			highLightElement(driver.findElement(By.xpath(TabInfo)));
			reportData.add(click(driver.findElement(By.xpath(TabInfo)), tabDataList.get(i)) + " Tab");
			if (tabDataList.get(i).equals("Identity")) {
				reportData.add(
						waitForVisibilityOfElement(appPages.actors_page.lbl_ActorReference, "ActorReference TextBox"));
				continue;
			} else if (tabDataList.get(i).equals("Credit Info")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_CreditInfo, "CreditInfo Label"));
				continue;

			} else if (tabDataList.get(i).equals("Individual")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.lbl_FullName, "FullName TextBox"));
				continue;

			} else if (tabDataList.get(i).equals("Addresses")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_AddressList, "AddressList Label"));
				continue;

			} else if (tabDataList.get(i).equals("Bank accounts")) {
				reportData.add(
						waitForVisibilityOfElement(appPages.actors_page.vfy_BankAccountList, "BankAccountList Label"));
				continue;

			} else if (tabDataList.get(i).equals("LoanCard")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_LoanCard, "LoanCard Label"));
				continue;

			} else if (tabDataList.get(i).equals("Billing Account")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_BillingAccount, "LoanCard Label"));
				continue;

			} else if (tabDataList.get(i).equals("Contacts")) {
				reportData.add(
						waitForVisibilityOfElement(appPages.actors_page.vfy_ContractLists, "Contacts Details Table"));
				continue;

			} else if (tabDataList.get(i).equals("Role")) {
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.lbl_RoleList, "List of Roles Table"));
				continue;
			}

		}
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		createReportTableEntry(reportData, "verifyActorTabs");
	}

	public void verifyEventUnderActors() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_Events, "UpdateTradeNames Label"));
		// highLightElement(appPages.actors_page.vfy_Events);
		createReportTableEntry(reportData, "verifyEventUnderActors");
	}

	public void verifyChangeTradename() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		sleep(2000);
		reportData.add(scrollToView(appPages.actors_page.lst_ChangeTradename, "ChangeTradename"));
		reportData.add(click(appPages.actors_page.lst_ChangeTradename, "ChangeTradename Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(waitForVisibilityOfElement(
				driver.findElement(By.xpath(String.format(appPages.actors_page.vfy_EventPage, "Update Trade Names"))),
				"UpdateTradeNames Label"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyChangeTradename");
	}

	public void verifyAddressChange() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(waitForVisibilityOfElement(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Change address"))),
				"ChangeAddress"));
		reportData.add(click(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Change address"))),
				"ChangeAddress Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(waitForVisibilityOfElement(
				driver.findElement(By.xpath(String.format(appPages.actors_page.vfy_EventPage, "Change Address"))),
				"ChangeAddress"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyAddressChange");
	}

	public void verifyChangeBankAccount() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		reportData.add(scrollToView(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Change bank account"))),
				"ChangeBankAccount"));
		reportData.add(click(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Change bank account"))),
				"ChangeBankAccount Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(waitForVisibilityOfElement(
				driver.findElement(By.xpath(String.format(appPages.actors_page.vfy_EventPage, "Change bank account"))),
				"ChangeBankAccount Label"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyChangeBankAccount");
	}

	public void verifyInvoiceChangeModification() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		reportData.add(scrollToView(
				driver.findElement(
						By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Invoice center modification"))),
				"InvoiceChange"));
		reportData.add(click(
				driver.findElement(
						By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Invoice center modification"))),
				"InvoiceChange Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(waitForVisibilityOfElement(
				driver.findElement(
						By.xpath(String.format(appPages.actors_page.vfy_EventPage, "Invoice center update"))),
				"InvoiceChange Label"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyInvoiceChangeModification");
	}

	public void verifyDeArchieveActors() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actor Global Events"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "More"));
		reportData.add(scrollToView(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "De-Archive actors"))),
				"De-ArchiveActors"));
		reportData.add(click(
				driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "De-Archive actors"))),
				"De-ArchiveActors Link"));
		createReportTableEntry(reportData, "verifyDeArchieveActors");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		//reportData.add(type(appPages.actors_page.txt_ArchiveActorId, data.get("ActorId"), "ActorId Textbox"));
		//reportData.add(click(appPages.actors_page.btn_SearchArchiveActor, "Next button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyDeArchieveActors");

	}

}
