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
	BasePageData basepageData = new BasePageData();
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
	public void validateIdentityDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForVisibilityOfElement(appPages.actors_page.lnk_ModifyAddress, " Modify Address Link");
		reportData.add(click(appPages.actors_page.lnk_ModifyAddress, " Modify Address Link"));
		sleep(4000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Sub-Actor Screen"));
		waitForVisibilityOfElement(appPages.actors_page.lbl_Reference, "Reference Textbox");
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_Reference, "value", "null", "Identity Detail"));
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		createReportTableEntry(reportData, "verifyIdentityDetails");
		logger.log(LogStatus.INFO, "Successfully Validated Identity Details",attchedStepScreenShot("Successfully Validated Identity Details","Yes"));
	}
	 
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Fill Modify Address Details
	 */
	public void fillModifyAddressDetails(HashMap<String, String> data, String AddressType) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		Thread.sleep(2000);
		reportData.add(click(appPages.actors_page.cb_NewAddressList, "New Row Selected"));
		scrollToView(appPages.actors_page.lst_AddressType, "AddtessType Dropdown");
		reportData.add(select(appPages.actors_page.lst_AddressType, AddressType, "AddressType Dropdown"));
		waitForVisibilityOfElement(appPages.actors_page.txt_City, "City Textbox");
		reportData.add(type(appPages.actors_page.txt_City, data.get("City"), "City Textbox"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_SearchCity, "SearchCity button"));
		waitForVisibilityOfElement(appPages.actors_page.btn_SearchDialog, "SearchDialog button");
		reportData.add(click(appPages.actors_page.btn_SearchDialog, "SearchDialog button"));
		sleep(6000);
		
		String tbl_CitypostalCodeDirectory= String.format(appPages.actors_page.tbl_CityPostalCodeDirectory_SearchDialog,data.get("City"));
		//waitForVisibilityOfElement(cityPostalCodeElem, "CityWithPostalCode Table Value");
		reportData.add(click(tbl_CitypostalCodeDirectory, "XPATH", "CityWithPostalCode TableValue"));
		
		reportData.add(click(appPages.actors_page.btn_Validate, "Validate button"));
		waitForVisibilityOfElement(appPages.actors_page.txt_Address1, "Address TextBox");
		reportData.add(type(appPages.actors_page.txt_Address1, data.get("NewAddress"), "Address TextBox"));
		reportData.add(select(appPages.actors_page.lst_ValidationReason,data.get("ValidationReason"),"ValidationReason Dropdown"));
		waitForVisibilityOfElement(appPages.actors_page.btn_ValidateAddress, "ValidateAddress button");
		reportData.add(click(appPages.actors_page.btn_ValidateAddress, "ValidateAddress button"));
		waitForVisibilityOfElement(appPages.actors_page.btn_SetValidate, "SetValidate button");
		reportData.add(click(appPages.actors_page.btn_SetValidate, "SetValidate button"));
		scrollToView(appPages.commonSrn_page.btn_Finish, "Finish button");
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish button"));
		sleep(5000);
		scrollToView(appPages.actors_page.btn_Confirm, "Confirm Button");
		reportData.add(click(appPages.actors_page.btn_Confirm, "Confirm Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillModifyAddressDetails");
		System.out.println("Successfully filled Modify Address Details");
		logger.log(LogStatus.INFO, "Successfully filled Modify Address Details");
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Search Actor ID
	 */
	public void searchActorId(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
     	System.out.println(data.get("AcctorId"));
     	HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
     	
     	reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(type(appPages.actors_page.txt_ActorId,data.get("ActorId"), "ActorId Textbox"));
		reportData.add(click(appPages.actors_page.btn_MoreOption,"MoreOptions Button"));
		reportData.add(click(appPages.actors_page.btn_Search,"Search Button"));
		reportData.add(click(appPages.actors_page.lnk_Reference,"Reference Link"));
		reportData.add(switchToDefaultFrameContent());
        createReportTableEntry(reportData, "SearchActorId");
        logger.log(LogStatus.INFO, "Successfully Searched ActorID",attchedStepScreenShot("Successfully Searched ActorID","Yes"));
	}
	
	public void verifyActorDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData,this.verifyActorIndentityDetails());
		reportData = concatList(reportData,this.verifyActorIndividualDetails());
		reportData = concatList(reportData,this.verifyActorAddressDetails());
		reportData = concatList(reportData, this.verifyActorContactDetails());
		reportData = concatList(reportData, this.verifyAssentDetails());
		createReportTableEntry(reportData, "verifyActorDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Actor Details",attchedStepScreenShot("Successfully Verified Actor Details","Yes"));
	}
	
	public void verifyCOBActorDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData, this.verifyActorIndentityDetails());
		reportData = concatList(reportData, this.verifyActorIndividualDetails());
		reportData = concatList(reportData, this.verifyActorAddressDetails());
		reportData = concatList(reportData, this.verifyActorContactDetails());
		createReportTableEntry(reportData, "verifyCOBActorDetails");
		logger.log(LogStatus.INFO, "Successfully Verified COB Actor Details",attchedStepScreenShot("Successfully Verified COB Actor Details","Yes"));
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
		sleep(5000);
		try{
			for (int i = 2; i <= 13; i++) {
				addressHead = String.format(tbl_addListHeader, i);
				scrollToView(driver.findElement(By.xpath(addressHead)), "");
				addHeader = driver.findElement(By.xpath(addressHead));
				addressList = String.format(tbl_addList, i);
				address = driver.findElement(By.xpath(addressList));
				fullAddressDetails.add(addHeader.getText() + "=" + address.getText() + "\n");
				System.out.println(addHeader.getText() + "=" + address.getText() + "\n");
			}
			reportData.add("Pass" + "~" + "VerifyText" + "~" + "Address Detail" + "~" + fullAddressDetails);
		} catch(Exception e){
			reportData.add("Fail" + "~" + "VerifyText" + "~" + "Address Detail" + "~" + "Unable To Retrive The Address Details");
		}
		return reportData;
	}
	
	public List<String> verifyActorContactDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.tab_Contacts, "Contacts Tab"));
		sleep(5000);
		scrollToView(appPages.actors_page.lbl_Telecome, "Telecom Table");
		reportData.add(verifyText(appPages.actors_page.lbl_Telecome, "Telecom", "Telecom Details Table"));
		return reportData;
	}
	
	public void verifyRoleDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		Thread.sleep(3000);
		reportData.add(click(appPages.actors_page.btn_MoreActorOption, "MoreActorOption Button"));
		reportData.add(click(getStringWebElement(appPages.actors_page.tab_Role, "Role"), "XPATH", "Role Tab"));
		Thread.sleep(5000);
		waitForVisibilityOfElement(appPages.actors_page.lbl_RoleList, "List of Roles");
		reportData.add(verifyText(appPages.actors_page.lbl_RoleList, "List of Roles", "List of Roles Table"));

		String tbl_listOfRoles = appPages.actors_page.tbl_ListOfRole;
		String tbl_listOfRolesHeader = appPages.actors_page.tbl_ListOfRoleHeader;
		List<String> fullRoleList = new ArrayList<String>();
		String roleList = null;
		String roleListHead = null;
		WebElement roleListHeader = null;
		WebElement listOfRole = null;
		sleep(1200);
		try{
			for (int i = 2; i <= 8; i++) {
				roleListHead = String.format(tbl_listOfRolesHeader, i);
				scrollToView(driver.findElement(By.xpath(roleListHead)), "scroll");
				roleListHeader = driver.findElement(By.xpath(roleListHead));
				roleList = String.format(tbl_listOfRoles, i);
				listOfRole = driver.findElement(By.xpath(roleList));
				fullRoleList.add(roleListHeader.getText() + "=" + listOfRole.getText() + "\n");
				System.out.println(roleListHeader.getText() + "=" + listOfRole.getText() + "\n");
			}
			reportData.add("Pass" + "~" + "VerifyText" + "~" + "Role Detail" + "~" + fullRoleList);
		} catch(Exception e){
			reportData.add("Fail" + "~" + "VerifyText" + "~" + "Role Detail" + "~" + "Unable To Find The Role Details");
		}

		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyRoleDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Role Details");
	}

	 
	// newly added for Cust_Info_Pref_Changes
	public void verifyLastName(HashMap<String, String> data,String lastName) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		System.out.println(data.get("LastName"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.actors_page.tab_Individual, "Individual Tab"));
		waitForVisibilityOfElement(appPages.actors_page.lbl_LastName, "LastName TextBox");
		if(data.get("LastName")!="")
		{
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_LastName, "value", data.get("LastName"), "LastName TextBox"));
		}
		else
		{
			reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_LastName, "value", "" , "LastName TextBox"));

		}
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyLastName");
		logger.log(LogStatus.INFO, "Successfully Verified Last Name",attchedStepScreenShot("Successfully Verified Last Name","Yes"));
	}
		
	// newly added for Cust_Info_Pref_Changes
	public void fillChangeTradename(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		System.out.println(data.get("LastName2"));
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.actors_page.lnk_ChangeTradeName, "ChangeTradeName Link"));
		reportData.add(click(appPages.actors_page.lnk_ChangeTradeName, "ChangeTradename Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Actor Sub-Screen"));
		reportData.add(type(appPages.actors_page.txt_LastName, true, data.get("LastName2"), "LastName Textbox"));
		if(data.get("Reason")!="")
		{
			reportData.add(select(appPages.actors_page.lst_ReasonTradename, data.get("Reason"), "Reason Dropdown"));
		}
		reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		/*reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));*/
		waitForVisibilityOfElement(appPages.actors_page.btn_finish, "Finish Button");
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(5000);
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillChangeTradename");
		logger.log(LogStatus.INFO, "Successfully Filled Change Trade Name",attchedStepScreenShot("Successfully Filled Change Trade Name","Yes"));
	}
		 
	// newly created for Cust_Info_Pref_Changes

	public List<String> verifyAssentDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.actors_page.btn_MoreActorOption, "MoreActorOption Button"));
		reportData.add(click(appPages.actors_page.tab_Assent, "Assent Tab"));
		String tbl_AssentList = appPages.actors_page.tbl_AssentList;
		String tbl_AssentHeader = appPages.actors_page.tbl_AssentHeader;
		List<String> fullAssentDetails = new ArrayList<String>();
		String AssentList = null;
		String AssentHead = null;
		WebElement assentHeader = null;
		WebElement assent = null;
		sleep(5000);
		try{
			for (int i = 2; i <= 7; i++) {
				AssentHead = String.format(tbl_AssentHeader, i);
				scrollToView(driver.findElement(By.xpath(AssentHead)), "");
				assentHeader = driver.findElement(By.xpath(AssentHead));
				AssentList = String.format(tbl_AssentList, i);
				assent = driver.findElement(By.xpath(AssentList));
				fullAssentDetails.add(assentHeader.getText() + "=" + assent.getText() + "\n");
				System.out.println(assentHeader.getText() + "=" + assent.getText() + "\n");
			}
			reportData.add("Pass" + "~" + "VerifyText" + "~" + "Assent Detail" + "~" + fullAssentDetails);
		} catch(Exception e){
			reportData.add("Fail" + "~" + "VerifyText" + "~" + "Assent Detail" + "~" + "Unable To Find The Assent Details");
		}
		return reportData;
	}
		 
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To click Past Event Data
	 */
	
	public void clickPastEventTab() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actors Screen"));
		sleep(3000);
		// switchToDefaultFrameContent();
		reportData.add(click(appPages.actors_page.btn_ArrowMark_ActroListPage, "Arrow Button"));
		reportData.add(click(appPages.actors_page.sel_PastEvent, "PastEvents Select"));

		createReportTableEntry(reportData, "clickPastEventTab");
		logger.log(LogStatus.INFO, "Successfully Pastevent tab is opened ", "");

	}

	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Verify PastEvent Pop up elements
	 */
	public void verifyPastEvents(HashMap<String, String> data) throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		String pastEvent=data.get("PastEvent");
		List<String> pastEventList = splitInputData(pastEvent, ",");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		waitForVisibilityOfElement(appPages.actors_page.btn_MoreActorOption,"MoreActorOption Button");
		reportData.add(click(appPages.actors_page.btn_MoreActorOption,"MoreActorOption Button"));
		reportData.add(click(appPages.actors_page.tab_PastEvents,"PastEvents Tab"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventTable,"PastEvent Table"));

		if(!pastEvent.equals("") && !pastEvent.equals(null)){
			for(int i=0;i<pastEventList.size();i++){
				reportData.add(click(getStringWebElement(appPages.actors_page.lnk_PastEvent, pastEventList.get(i)),"XPATH", pastEventList.get(i)+" Link"));
				sleep(4000);
				reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, pastEventList.get(i)+" Screen"));
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventDetails,  pastEventList.get(i)+" DialogBox"));
				reportData.add(click(appPages.actors_page.btn_Close,"Close Button"));
				sleep(2000);
				//reportData.add(switchToDefaultFrameContent());
				reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
			}
		} else{
			reportData.add(click(appPages.actors_page.lnk_EventFirstRow, "Event Link"));
			reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, " PastEventDetail Screen"));
			reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventDetails, "PastEventDetail DialogBox"));
			reportData.add(click(appPages.actors_page.btn_Close,"Close Button"));
			sleep(2000);
		}
		
		createReportTableEntry(reportData, "verifyPastEvents");
		logger.log(LogStatus.INFO, "Successfully Verified Past Events",attchedStepScreenShot("Successfully Verified Past Events","Yes"));
	}
	 
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description click on new button in ActorList page
	 */
	public List<String> actorListPageClickOnNew() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		WebElement NewLink = appPages.actors_page.lnk_NewActorList;
		reportData.add(isPresentAndDisplayed(NewLink, "New link"));
		reportData.add(click(NewLink, "New link"));
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
	public void createNewActor(HashMap<String, String> data) throws Throwable {
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
		reportData.add(type(appPages.actors_page.txt_FullName2, ToConcat.concat(FullName2), "FullName2 TextBox"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.lnk_SearchLegalClassification, "LegalClassification Link"));
		sleep(3000);
		
		
		appPages.actors_page.txt_Code.clear();
		sleep(3000);
		reportData.add(type(appPages.actors_page.txt_Name, data.get("SearchName"), "Name TextBox"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.btn_Search_SearchDialog, "Search button"));
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
		sleep(5000);
		String ActorCode=appPages.actors_page.txt_ActorRef.getAttribute("value");
	    setValueProperty("ActorCode", ActorCode);
		createReportTableEntry(reportData, "createNewActor");
		logger.log(LogStatus.INFO, "Successfully Created New Actor",attchedStepScreenShot("Successfully Created New Actor","Yes"));
	}
	 
	public void navigateToActorListPage() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		Thread.sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor List Page"));
		if (appPages.actors_page.lbl_ActorsListPage.isDisplayed()) {
			reportData.add(verifyText(appPages.actors_page.lbl_ActorsListPage, "Actors List", "Actors List"));
		}
		createReportTableEntry(reportData, "navigateToActorListPage");
		logger.log(LogStatus.INFO, "Successfully Navigated To Actor List Page",attchedStepScreenShot("Successfully Navigated To Actor List Page","Yes"));
	}


	// added for sanity test cases
	public void verifyActorTabs(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
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
		logger.log(LogStatus.INFO, "Successfully verified actors tab",attchedStepScreenShot("Successfully verified actors tab","Yes"));
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
		logger.log(LogStatus.INFO, "Successfully Verified Change Trade Name",attchedStepScreenShot("Successfully Verified Change Trade Name","Yes"));
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
		logger.log(LogStatus.INFO, "Successfully Verified Change Address",attchedStepScreenShot("Successfully Verified Change Address","Yes"));
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
		logger.log(LogStatus.INFO, "Successfully Verified Change Bank Account",attchedStepScreenShot("Successfully Verified Change Bank Account","Yes"));
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
		logger.log(LogStatus.INFO, "Successfully Verified Invoice Change Modification",attchedStepScreenShot("Successfully Verified Invoice Change Modification","Yes"));
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
		logger.log(LogStatus.INFO, "Successfully Verified De-Archive Actors",attchedStepScreenShot("Successfully Verified De-Archive Actors","Yes"));
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate Phase Details
	  */
	public void changeAndVerifyPhaseDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.actors_page.lnk_ChangePhase, "ChangePhase Link"));
		reportData.add(click(appPages.actors_page.lnk_ChangePhase, "Change Phase Link"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Change Phase Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Change Phase Screen"));
		sleep(4000);
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_GeneralInformation, "General Information"));
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_CurrentPhase, "Phase"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.vfy_Phase, "value", "null", "Phase"));
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_CurrentStep, "Current Step"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.vfy_Step, "value", "null", "Current Step"));
		
		//scroll down till new phase 
		
		reportData.add(scrollToView(appPages.actors_page.lbl_NewPhase, "New Phase"));
		
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_NewPhase, "New Phase"));
		reportData.add(select(appPages.actors_page.lst_NewPhase, "Active", "NewPhase Dropdown"));
		sleep(2000);
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_NewStep, "New Step"));
		reportData.add(select(appPages.actors_page.lst_NewStep, "Active", "NewStep Dropdown"));
		sleep(3000);
		//click on next
		reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		sleep(4000);
		System.out.println();
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(4000);
		reportData.add(click(appPages.actors_page.btn_Close_ChangePhase, "Close Button"));
		sleep(4000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor List Page"));
		sleep(2000);
	    homeScreen_func.searchActorCode(data);
	    reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor List Page"));
	    sleep(2000);
		//verify Modified Phase in Identity tab
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_Phase,"title","Active","IdentityPhase Dropdown"));
		
		//Verify Step in the Step
		reportData.add(verifyFieldAttribute(appPages.actors_page.vfy_Step_IdentityTab,"title","Active","IdentityStep Dropdown"));
	    
		createReportTableEntry(reportData, "ChangeAndVerifyPhaseDetails");
		logger.log(LogStatus.INFO, "Successfully Changed And Verified Phase Details",attchedStepScreenShot("Successfully Changed And Verified Phase Details","Yes"));
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate Role details after providing Dealer number
	  */
	public void provideDealerNumberAndVerifyRoleDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(1000);
		verifyRoleDetails();		
		//scroll upto External Reference
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Role Screen"));
		reportData.add(scrollToView(appPages.actors_page.lbl_ExternalReference, "External reference"));
		reportData.add(verifyText(appPages.actors_page.lbl_ExternalReference, "External reference", "External reference Label"));
		String ExternalReference = generateRandomString(10, false, true);
		reportData.add(type(appPages.actors_page.txt_ExternalReference, ExternalReference, "External Reference TextBox"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.lnk_SaveActorList,"Save Link"));
		sleep(5000);
		//Verify the modified ExternalReference in the role tab
		
		try{
			String tbl_roleReferenceValue= String.format(appPages.actors_page.tbl_roleRefernceValue,ExternalReference);
			WebElement tbl_roleReferenceValueElement = getWebelement("XPATH", tbl_roleReferenceValue);
			waitForVisibilityOfElement(tbl_roleReferenceValueElement, "ReferenceValue In Table");
			reportData.add(verifyText(tbl_roleReferenceValueElement, ExternalReference, "Role Reference Value In Table"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "verifyText" + "~" + "RoleReferenceTable" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "provideDealerNumberAndVerifyRoleDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Role Details By Providing Dealer Number",attchedStepScreenShot("Successfully Verified Role Details By Providing Dealer Number","Yes"));
	}
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Verify Modified ActorTelecomInformation
	  */

	public void verifyModifiedActorTelecomInformation(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
	
		//reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Modifyaddress Page"));
		scrollToView(appPages.actors_page.lbl_ActorTelecomInfo, "Actor telecom Info");
		reportData.add(click(appPages.actors_page.btn_newActorTelecomInfo, "New Button"));
		sleep(3000);
		scrollToView(appPages.actors_page.lbl_ActorTelecomInfo, "Actor telecom Info");
		reportData.add(select(appPages.actors_page.lst_TelecomType, data.get("TelecomType"), "TelecomType Dropdown"));
		
		//enter telecomRef Number
		String areaCode=generateRandomString(3, false, true);
		String prifix=generateRandomString(4, false, true);
		String lineNumber=generateRandomString(4, false, true);
		String telePhoneNumber = areaCode+"-"+prifix+"-"+lineNumber;
		reportData.add(type(appPages.actors_page.txt_areaCode, areaCode, "TeleCom-Ref AreaCode TextBox"));
		reportData.add(type(appPages.actors_page.txt_prefix, prifix, "TeleCom-Ref Prefix TextBox"));
		reportData.add(type(appPages.actors_page.txt_lineNumber, lineNumber, "TeleCom-Ref LineNumber TextBox"));
		reportData.add(select(appPages.actors_page.lst_Reason_telecom, data.get("ValidationReason"), "Reason Dropdown"));
		reportData = concatList(reportData, clickFinishAndConfirm());
		reportData = concatList(reportData, verifyActorContactDetails());
		reportData.add(scrollToView(appPages.actors_page.tbl_contactList, "Contact List Table Row"));
		sleep(3000);
		//reportData.add(click(appPages.actors_page.tbl_contactList,"Contact List Table Row"));
		
		//scroll up to Tele com
		scrollToView(appPages.actors_page.lbl_Telecom,"Telecom lebel");
		sleep(3000);
		String telecomReferenceValue=(appPages.actors_page.tbl_telecomReferenceValue).getText();
		System.out.println(telecomReferenceValue);
		reportData.add(verifyText(appPages.actors_page.tbl_telecomReferenceValue,telePhoneNumber , "Telecom Reference"));
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		createReportTableEntry(reportData, "verifyModifiedActorTelecomInformation");
		logger.log(LogStatus.INFO, "Successfully Verified Modify-Actor Telecom Information",attchedStepScreenShot("Successfully Verified Modify-Actor Telecom Information","Yes"));
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Verify Modified ChangeRoleStatus
	  */
	public void verifyModifiedChangeRoleStatus() throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		verifyRoleDetails();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.actors_page.lnk_changeRoleStaus, "ChangeRoleStatus Link"));
		reportData.add(click(appPages.actors_page.lnk_changeRoleStaus, "ChangeRoleStatus Link"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChangeRoleStatus Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To ChangeRoleStatus Screen"));
		reportData.add(select(appPages.actors_page.lst_phase_changeRoleStatus, "Active", "Phase"));
		
		reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_Close_Footer, "Close Button"));
		sleep(2000);
		//click Role tab and verify the phase
		verifyRoleDetails();
		sleep(4000);
		//As discussed with yasha on 7/8/2019 Instead of Active the phase should reflect as "In Service"
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChangeRoleStatus Screen"));
		reportData.add(verifyText(appPages.actors_page.vfy_phaseTable, "In service", "Phase value"));
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "verifyModifiedChangeRoleStatus");
		logger.log(LogStatus.INFO, "Successfully Verified Modify-Change Role Status",attchedStepScreenShot("Successfully Verified Modify-Change Role Status","Yes"));
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Verify Modified ChangeAttribute
	  */
	public void verifyModifiedChangeAttribute(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
	
		verifyRoleDetails();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.actors_page.lnk_changeAttribute, "ChangeAttribute Link"));
		reportData.add(click(appPages.actors_page.lnk_changeAttribute, "ChangeAttribute Link"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChangeAttribute Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To ChangeAttribute Screen"));
		sleep(2000);
		try{
			String lst_availableAttributes= String.format(appPages.actors_page.lst_availableAttributes,data.get("Attribute"));
	        WebElement availableAttributeElem = getWebelement("XPATH", lst_availableAttributes);
	        reportData.add(scrollToView(availableAttributeElem, "AvailableAttribute Link"));
	        sleep(2000);
	        reportData.add(click(availableAttributeElem, "AvailableAttribute Link"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AttributeLink" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
	
		//Verify and select Reason,Change To from respective drop downs
		reportData.add(verifyText(appPages.actors_page.lbl_Reason_ChangeAttributePage, "Reason", "Reason Lable"));
		reportData.add(select(appPages.actors_page.lst_Reason, data.get("ChangeAttributeReason"), "Reason Dropdown"));
		reportData.add(verifyText(appPages.actors_page.lbl_ChangeTo_ChangeAttributePage, "Change to", "Change to Lable"));
		reportData.add(select(appPages.actors_page.lst_ChangeTo, data.get("ChangeTo"), "ChangeTo Dropdown"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
		sleep(1000);
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(1000);
		reportData.add(click(appPages.actors_page.btn_Close_Footer, "Close Button"));
		sleep(1000);
		//click on Role to verify added Attribute
		verifyRoleDetails();
		sleep(1000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChangeAttribute Screen"));
		sleep(2000);
		reportData.add(scrollToView(appPages.actors_page.lbl_attribute, "Attribute"));
		reportData.add(isPresentAndDisplayed(appPages.actors_page.lbl_attribute, "Attribute Label"));
		
		try{
			String tbl_Attribute= String.format(appPages.actors_page.tbl_Attribute,data.get("Attribute"),data.get("ChangeTo"));
			WebElement tbl_AttributeElement = getWebelement("XPATH", tbl_Attribute);
			reportData.add(isPresentAndDisplayed(tbl_AttributeElement, "Attribute Table"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AttributeTable" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		
		createReportTableEntry(reportData, "verifyModifiedChangeAttribute");
		logger.log(LogStatus.INFO, "Successfully Verifed Modify-Change Attribute",attchedStepScreenShot("Successfully Verifed Modify-Change Attribute","Yes"));
	}
	
	/***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Click Finish and Confirm
	  * @return List Of String
	  */
	public List<String> clickFinishAndConfirm() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "FinishButton"));
		sleep(3000);
		scrollToView(appPages.actors_page.btn_confirm, "Confirm Button");
		reportData.add(click(appPages.actors_page.btn_confirm, "FinishButton"));
		logger.log(LogStatus.INFO, "Successfully Click on Finish and then Confirm");
		return reportData;
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Validate Modified Address
	 */
	public void validateModifiedAddress(HashMap<String, String> data ,String AddressType) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.tab_Address, "Addresses Tab"));
		reportData.add(click(appPages.actors_page.tab_Address, "Addresses Tab"));
		sleep(7000);
		String tbl_AddressList = "(//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//table/tbody/tr";
		/*int tblRowNum = driver.findElements(By.xpath(tbl_AddressList)).size();
		String lastRowNum = tbl_AddressList + "[" + tblRowNum  + "]/td";
		//scrollToView(driver.findElement(By.xpath(lastRowNum)), "");
		sleep(3000);
		tblRowNum = driver.findElements(By.xpath(tbl_AddressList)).size();*/
		String requiredRow = tbl_AddressList + "/td//span[text()='"+AddressType+"']/../../../../td//span[text()='"+data.get("NewAddress")+"'])[1]";		
		for (int i = 0; i < 10; i++) {
			try {
				scrollToView(driver.findElement(By.xpath(requiredRow)), AddressType + " Link");
				sleep(2000);
				actionClick(driver.findElement(By.xpath(requiredRow)), AddressType + " Link");
				sleep(2000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				click(appPages.actors_page.btn_TableNext, "Nextpage Button");
				sleep(4000);
			}
		}
		try{
			
			reportData.add(verifyFieldAttribute(getStringWebElement(appPages.actors_page.vfy_AddressType, "Address Type"), "XPATH", "title", AddressType, "AddressType Dropdown"));
			reportData.add(verifyFieldAttribute(getStringWebElement(appPages.actors_page.vfy_AddressDetails, "Zip Code"), "XPATH", "value", data.get("ZipCode"), "ZipCode TextBox"));
			reportData.add(verifyFieldAttribute(getStringWebElement(appPages.actors_page.vfy_AddressDetails, "Address 1"), "XPATH", "value", data.get("NewAddress"), "NewAddress TextBox"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ZipCode" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		
		//reportData.add(verifyFieldAttribute((setStringValueInToWebElement(appPages.actors_page.vfy_AddressDetails, "City", "XPATH")), "value", data.get("City"), "City TextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "ValidateModifiedAddress");
		logger.log(LogStatus.INFO, "Successfully Validated Modified Address");
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Validate Modified Address
	 */
	public void fillActorAssentDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		waitForVisibilityOfElement(appPages.actors_page.lnk_More,"More");
		reportData.add(click(appPages.actors_page.lnk_More,"More"));
		reportData.add(scrollToView(driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Actor Assent"))),"ActorAssent Link"));
		reportData.add(click(driver.findElement(By.xpath(String.format(appPages.actors_page.lnk_ActorEvent, "Actor Assent"))),"ActorAssent Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Sub-Actor Screen"));
		waitForVisibilityOfElement(appPages.actors_page.lbl_Reference, "Reference Textbox");
		reportData.add(verifyFieldAttribute(appPages.actors_page.lbl_Reference, "value", "null", "Identity Detail"));
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		waitForVisibilityOfElement(appPages.actors_page.lst_SelectTemplate, "SelectTemplate Dropdown");
		reportData.add(select(appPages.actors_page.lst_SelectTemplate, data.get("Template"), "Template Dropdow"));
		sleep(2000);
		String assentList=data.get("AssentDetails");
		List<String> assentDataList = splitInputData(assentList, ",");			
		for(int i=0;i<assentDataList.size();i++){
			if(i<4)
			{
				String assentInfo=String.format(appPages.actors_page.tbl_Assent,assentDataList.get(i),i+2);
				waitForVisibilityOfElement(driver.findElement(By.xpath(assentInfo)),"");
				reportData.add(click(driver.findElement(By.xpath(assentInfo)),assentDataList.get(i)+" dropdown"));
				sleep(1000);
				String x =assentDataList.get(i);
				x = x.replaceAll("\\s","");
				String assentData=data.get(x);
				reportData.add(select(driver.findElement(By.xpath(assentInfo)), assentData, assentDataList.get(i)+" dropdown"));
			}
			else
			{
				String assentInfo=String.format(appPages.actors_page.tbl_AssentDate,assentDataList.get(i),i+2);
				waitForVisibilityOfElement(driver.findElement(By.xpath(assentInfo)),"");
				reportData.add(click(driver.findElement(By.xpath(assentInfo)),assentDataList.get(i)+" dropdown"));
				sleep(1000);
				String x =assentDataList.get(i);
				x = x.replaceAll("\\s","");
				String assentData=data.get(x);
				reportData.add(type(driver.findElement(By.xpath(assentInfo)), assentData, assentDataList.get(i)+" dropdown"));
			}

		}
		sleep(1000);
		reportData.add(select(appPages.actors_page.lst_AssentStatus,data.get("Assentstatus"),"AssentStatus dropdown"));
		sleep(2000);
		reportData.add(type(appPages.actors_page.lst_EndDate,true,data.get("EndDate"),"EndDate TextBox"));
		scrollToView(appPages.actors_page.btn_finish,"Finish dropdown");
		reportData.add(click(appPages.actors_page.btn_finish,"Finish dropdown"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_ChangeTradenamePastEvent, "ActorAssent DialogBox"));
		reportData.add(scrollToView(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(click(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		waitForVisibilityOfElement(appPages.actors_page.btn_MoreActorOption,"MoreActorOption Button");
		reportData.add(click(appPages.actors_page.btn_MoreActorOption,"MoreActorOption Button"));
		highLightElement(appPages.actors_page.tab_Assent);
		reportData.add(click(appPages.actors_page.tab_Assent,"Assent Tab"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_AssentTable, "Assent Table"));
		reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages.actors_page.vfy_Assent, data.get("Assent"), "XPATH"), "Assent Row"));
		sleep(3000);
		createReportTableEntry(reportData, "fillActorAssentDetails");
		logger.log(LogStatus.INFO, "Successfully Validated Modified Address",attchedStepScreenShot("Successfully Validated Modified Address","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Verify Bankruptcy details
	 */
	public void fillDetailsBankruptcy(HashMap<String, String> data,String AccountType) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		
		String ActorCode="";
			 if(AccountType.equalsIgnoreCase("Primary"))
			   {
			     ActorCode=data.get("PrimaryActorCode");	
			   }
		     else if(AccountType.equalsIgnoreCase("Secondary"))
				{
					ActorCode=data.get("SecondaryActorCode");	
				}
		
		reportData.add(switchToDefaultFrameContent());
		reportData.add(select(appPages.homeScreen_page.lst_GlobalSearchFind, "Actor Code", "ActorCode DropDown"));
		reportData.add(type(appPages.homeScreen_page.txt_GlobalSearchCode, true, ActorCode, "ActorCode TextBox"));
		reportData.add(click(appPages.homeScreen_page.btn_GobalSearch, "Search Button"));
		sleep(1000);
		reportData.add(switchToDefaultFrameContent());
		reportData.add(click(appPages.actors_page.lnk_bankruptcy, "Bankruptcy Link"));
		
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Bankruptcy Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Bankruptcy Screen"));
		reportData.add(scrollToView(appPages.actors_page.lbl_type, "Type Label"));
		sleep(2000);
		   if(AccountType.equalsIgnoreCase("Primary"))
		    {
		        reportData.add(select(appPages.actors_page.lst_type, data.get("PrimaryType"), "Type Dropdown"));
        	}
		   else if(AccountType.equalsIgnoreCase("Secondary"))
			{
			    reportData.add(select(appPages.actors_page.lst_type, data.get("SecondaryType"), "Type Dropdown"));
			}
	
		sleep(2000);
		reportData.add(select(appPages.actors_page.lst_mode, data.get("Mode"), "Mode Dropdown"));
		sleep(2000);
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		sleep(2000);
		//Now it has been removed
		//reportData.add(click(appPages.actors_page.btn_newBKChapter, "BKChapter7 New button"));
		sleep(2000);
		reportData.add(select(appPages.actors_page.lst_courtDistrict, data.get("CourtDistrict"), "CourtDistrict Dropdown"));
		sleep(2000);
		String CaseNumber=data.get("CaseNumber");
		String CaseNumberTextBoxOne=CaseNumber.substring(0,2);
		System.out.println(CaseNumberTextBoxOne);
		String CaseNumberTextBoxTwo=CaseNumber.substring(2,CaseNumber.length());
		System.out.println(CaseNumberTextBoxTwo);
		reportData.add(type(appPages.actors_page.txt_caseNumber, CaseNumberTextBoxOne, "CaseNumber Textbox"));
		sleep(1000);
		reportData.add(type(appPages.actors_page.txt_caseNumber2, CaseNumberTextBoxTwo, "CaseNumber Textbox"));
		sleep(1000);
		reportData.add(type(appPages.actors_page.txt_filingDate,getCurrentDate(), "FilingDate Textbox"));
		sleep(1000);
			if(AccountType.equalsIgnoreCase("Primary"))
			    {
			        reportData.add(select(appPages.actors_page.lst_Chapter, data.get("PrimaryType"), "Chapter Dropdown"));
					
	     	    }
			else if(AccountType.equalsIgnoreCase("Secondary"))
				{
				    reportData.add(select(appPages.actors_page.lst_Chapter, data.get("SecondaryType"), "Chapter Dropdown"));
				}
		sleep(1000);
		reportData.add(select(appPages.actors_page.lst_status, data.get("Status"), "Status Dropdown"));
		sleep(1000);
		reportData.add(scrollToView(appPages.actors_page.tab_contractList, "ContractList Tab"));
		sleep(3000);
		reportData.add(click(appPages.actors_page.tab_contractList, "ContractList Tab"));
		sleep(3000);
		boolean isChecked;
		try{
			String CheckboxContractList=String.format(appPages.bankruptcy_page.cb_ContractList,data.get("AccountNumber"));
			WebElement cb_ContractListElement=getWebelement("XPATH", CheckboxContractList);
			reportData.add(scrollToView(cb_ContractListElement, "ContractList CheckBox"));
			try{
			String isCheckedxpath=CheckboxContractList+"[contains(@checked,'')]";
			WebElement isCheckedxpathele=getWebelement("XPATH", isCheckedxpath);
			isChecked=isCheckedxpathele.isDisplayed();
			}
			catch(Exception e)
			{
				isChecked=false;
			}
		if(isChecked==false)
		{
			reportData.add(click(cb_ContractListElement, "ContractList CheckBox"));
		}
		
		
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ContractList CheckBox" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		
		
		//The below code has been commented due to data deficiency (Should be uncomment while automation)
		reportData.add(scrollToView(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_Close_Footer, "Close Button"));
		createReportTableEntry(reportData, "fillDetailsBankruptcy");
		logger.log(LogStatus.INFO, "Successfully filled Bankruptcy Details",attchedStepScreenShot("Successfully filled Bankruptcy Details","Yes"));
	}
	

	
	/***
     * @author Koyal
     * @param sheetName
     * @param testCase
     * @throws Throwable
     * @description Validate Home Address details
     */ 
    public void verifySpecifiedAddressDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.tab_Address, "Addresses Tab"));
		sleep(5000);
		String tbl_addresstypeRow = appPages.actors_page.tbl_RowBasedOnAddressType;
		String tbl_addListHeader = appPages.actors_page.tbl_AddListHeader;
		List<String> fullAddressDetails = new ArrayList<String>();
		List<String> addressTypelistFromExcel = new ArrayList<String>();
		    
		String addressList = null;
	 	String addressHead = null;
	 	WebElement addHeader = null;
	 	WebElement address = null;
			
		String[] addressType=data.get("AddressType").split(",");
		int addressTypeCount=addressType.length;
		for (int i = 0; i <= addressTypeCount - 1; i++) {
			addressTypelistFromExcel.add(addressType[i]);
			sleep(1200);

			System.out.println(addressTypelistFromExcel.get(i));
			try{
				for (int j = 2; j < 3; j++) {
					addressHead = String.format(tbl_addListHeader, j);
					scrollToView(driver.findElement(By.xpath(addressHead)), "");
					addHeader = driver.findElement(By.xpath(addressHead));
					addressList = String.format(tbl_addresstypeRow, addressTypelistFromExcel.get(i));
					address = driver.findElement(By.xpath(addressList));
					fullAddressDetails.add(addHeader.getText() + "=" + address.getText() + "\n");
					System.out.println(addHeader.getText() + "=" + address.getText() + "\n");
				}
			} catch(Exception e){
				String reportString = "Fail" + "~" + "verifyTableData" + "~" + "Address Details" + "~"
						+ "Unable To Validate [" + addressTypelistFromExcel.get(i) + "] In Table";
				reportData.add(reportString);
			}
			
			reportData.add(click(getStringWebElement(tbl_addresstypeRow, addressTypelistFromExcel.get(i)),"XPATH", "AddressTypeEdit Button"));
			sleep(3000);
			reportData.add(isPresentAndDisplayed(getWebelement("XPATH",
					String.format(appPages.actors_page.vfy_AddressType_AddressTab, addressTypelistFromExcel.get(i))),
					""));
		}
		
		reportData.add("Pass" + "~" + "Verify" + "~" + "Address Detail" + "~" + fullAddressDetails);
		reportData.add(switchToDefaultFrameContent());
		sleep(3000);
		createReportTableEntry(reportData, "verifySpecifiedAddressDetails");
		logger.log(LogStatus.INFO, "Successfully Validated AddressDeatails based On AddressType", attchedStepScreenShot("Successfully Validated AddressDeatails baswed On AddressType", "Yes"));
	}
    
    /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate Business opening date on identity tab and DOB on Individual tab
	 
	  */
	public void validateDOBAndBusinessOpeningDateOnDifferentTab() throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor List Page"));
		sleep(2000);
		WebElement lbl_phase = appPages.actors_page.lst_Phase;
		reportData.add(verifyFieldAttribute(lbl_phase, "title", "", "IdentityPhase Dropdown"));
		reportData.add(verifyText(appPages.actors_page.lbl_BusinessOpeningDate, "Business Opening Date",
				"BusinessOpeningDate Label"));
		reportData = concatList(reportData,this.verifyActorIndividualDetails());
		reportData.add(verifyText(appPages.actors_page.lbl_BirthDate, "Birth Date",
				"BirthDate Label"));
		createReportTableEntry(reportData, "verifySpecifiedAddressDetails");
		logger.log(LogStatus.INFO, "Successfully Validated DOB and BusinessopeningDate", attchedStepScreenShot("Successfully Validated DOB and BusinessopeningDate", "Yes"));
	}

	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Search Actor ID with multiplse condition
	 */
	public List<String> searchActorIdMultipleActorType(HashMap<String, String> data ,String ActorIDType) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
    	HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
    	
    	reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		if(ActorIDType.equalsIgnoreCase("BusinessCustomerActorID"))
		{
		reportData.add(type(appPages.actors_page.txt_ActorId,data.get("ConsumerCustomerActorID"), "ActorId Textbox"));
		}
		else if(ActorIDType.equalsIgnoreCase("ConsumerCustomerActorID"))
		{
		reportData.add(type(appPages.actors_page.txt_ActorId,data.get("BusinessCustomerActorID"), "ActorId Textbox"));
		}
		reportData.add(click(appPages.actors_page.btn_MoreOption,"MoreOptions Button"));
		reportData.add(click(appPages.actors_page.btn_Search,"Search Button"));
		reportData.add(click(appPages.actors_page.lnk_Reference,"Reference Link"));
		reportData.add(switchToDefaultFrameContent());
       createReportTableEntry(reportData, "searchActorIdMultipleActorType");
       logger.log(LogStatus.INFO, "Successfully Searched ActorID With multiple Actortype",attchedStepScreenShot("Successfully Searched ActorID With multiple Actortype","Yes"));
		return reportData;
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate Input fields for Business/consumer Customer

	  */
	public void validateInputFieldsForBusinessConsumerCustomer(HashMap<String, String> data ,String ActorIdType) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData, searchActorIdMultipleActorType(data, ActorIdType));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
			 if(ActorIdType.equalsIgnoreCase("BusinessCustomerActorID"))
				 {
				 	reportData.add(verifyText(appPages.actors_page.lbl_Full_Name, "Full Name", "FullName Label"));
					reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_Full_Name,"FullName TextBox"));
					
				    reportData.add(verifyText(appPages.actors_page.lbl_DBAAKA, "DBA/AKA", "DBAAKA Label"));
					reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_DBAAKA,"DBAAKA TextBox"));
					sleep(3000);	 
				 }
			 else if(ActorIdType.equalsIgnoreCase("ConsumerCustomerActorID"))
			     {
				    //Depends on test data Full name will not be present
					// reportData.add(verifyText(appPages.actors_page.lbl_Full_Name, "Full Name", "FullName Label"));
					// reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_Full_Name,"FullName TextBox"));
					 
					 reportData.add(verifyText(appPages.actors_page.lbl_FullName2, "Full name 2", "FullName2 Label"));
					 reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_FullName2,"FullName2 TextBox"));
					 
					 reportData.add(verifyText(appPages.actors_page.lbl_DBAAKA, "DBA/AKA", "DBAAKA Label"));
					 reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_DBAAKA,"DBAAKA TextBox"));
					 sleep(3000);	
			     }
			 reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "validateInputFieldsForBusinessConsumerCustomer");
		logger.log(LogStatus.INFO, "Successfully Validated Input fields for Business consumer customer", attchedStepScreenShot("Successfully Validated DOB and BusinessopeningDate", "Yes"));
	}
	
	 /***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate customer Role details

	  */
	public void verifyCustomerRoleDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		
		reportData.add(verifyText(appPages.actors_page.lbl_Role_Roletab, "Role", "Role Label"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.lst_Role_Roletab,"title","null","Role Dropdown"));
		
		reportData.add(verifyText(appPages.actors_page.lbl_Phase, "Phase", "Phase Label"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.lst_Phase,"title","null","Phase Dropdown"));
		
		reportData.add(verifyText(appPages.actors_page.lbl_Startdate, "Start date", "Startdate Label"));
		reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_Startdate,"StartDate textbox"));
		
		reportData.add(verifyText(appPages.actors_page.lbl_Enddate, "End date", "Enddate Label"));
		reportData.add(isPresentAndDisplayed(appPages.actors_page.txt_Enddate,"Enddate textbox"));
		
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyCustomerRoleDetails");
		logger.log(LogStatus.INFO, "Successfully Verified CustomerRoleDetails",attchedStepScreenShot("Successfully Verified CustomerRoleDetails","Yes"));
	}
	
	
	/***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Validate classification test box

	  */
	public void verifyIdentityTabLegalClassificationTextbox(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(1500);
		
		//reportData.add(scrollToView(appPages.actors_page.lbl_LegalClassification, "LegalClassification Label"));
		//sleep(2000);
		reportData.add(verifyText(appPages.actors_page.lbl_LegalClassification, "Legal Classification", "LegalClassification Label"));
		reportData.add(verifyFieldAttribute(appPages.actors_page.txt_LegalClassification2,"value",data.get("LegalClassificationVal"),"LegalClassification textbox2"));
		
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyIdentityTabLegalClassificationTextbox");
		logger.log(LogStatus.INFO, "Successfully Verified verifyIdentityTabLegalClassificationTextbox",attchedStepScreenShot("Successfully Verified verifyIdentityTabLegalClassificationTextbox","Yes"));
	}
	
	// newly added for Cust_Info_Pref_Changes
	public void verifyModifiedLastNameIdentityTab() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		String LastName = getValueProperty("LastName");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		WebElement FullName = appPages.actors_page.lbl_Full_Name;
		reportData.add(verifyText(FullName, "Full Name", "FullName Lebel"));
		if (LastName == "") {
			reportData.add(verifyFieldAttribute(appPages.actors_page.txt_Full_Name, "value", null, "LastName TextBox"));
		} else {
			String FullnameFromUI = getAttributeValue(appPages.actors_page.txt_Full_Name, "value");
			String[] LastNameFromUI = FullnameFromUI.split("");
			reportData.add(verifyText(FullName, LastNameFromUI[1].trim(), LastName));
		}
		reportData.add(switchToDefaultFrameContent());
		setValueProperty("LastName", "");
		createReportTableEntry(reportData, "verifyLastName");
		logger.log(LogStatus.INFO, "Successfully Verified Last Name",
				attchedStepScreenShot("Successfully Verified Last Name", "Yes"));
	}

	
	public void verifyCOBActorDetailsLike_Indentity_Individual_Contact_Address(HashMap<String, String> data)
			throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData = concatList(reportData, this.verifyActorIndentityDetails());
		reportData = concatList(reportData, this.verifyActorIndividualDetails());
		verifySpecifiedAddressDetails(data);
		reportData = concatList(reportData, this.verifyActorContactDetails());
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		createReportTableEntry(reportData, "verifyCOBActorDetailsWithSpecifiedAddress");
		logger.log(LogStatus.INFO, "Successfully Verified COB Actor Details",
				attchedStepScreenShot("Successfully Verified COB Actor Details", "Yes"));
	}

	
	public void verifyPrivacy_GLB_Information_AssentTab(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.btn_MoreActorOption, "MoreActorOption Button"));
		sleep(2000);
		reportData.add(click(appPages.actors_page.tab_Assent, "Assent Tab"));
		sleep(5000);
		try{
			String tbl_AssentList = appPages.actors_page.tbl_AssentValue;
			String tbl_Assent = String.format(tbl_AssentList, data.get("AssentName"), data.get("AssentStatus"));
			WebElement tbl_Assentelement = getWebelement("XPATH", tbl_Assent);
			reportData.add(scrollToView(tbl_Assentelement, "Assent Table Data"));
			sleep(2000);
			reportData.add(isPresentAndDisplayed(tbl_Assentelement, "Assent Table Data"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "Assent TableData" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		

	}
	
	public void searchReferenceActorCode(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Tasks", "Tasks"));

		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(type(appPages.task_page.txt_ReferenceCode, data.get("ActorCode"), "ActorCode TextBox"));
		reportData.add(type(appPages.task_page.txt_BaseDateFrom, true, data.get("BaseDateFrom"), "BaseDateFrom TextBox"));
		reportData.add(type(appPages.task_page.txt_BaseDateTo, true, data.get("BaseDateTo"), "BaseDateTo TextBox"));
		sleep(2000);
		reportData.add(click(appPages.task_page.btn_Search, "Search Button"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchReferenceActorCode");
		logger.log(LogStatus.INFO, "Successfully Searched Actor Code",attchedStepScreenShot("Successfully Searched Actor Code","Yes"));

	}

	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Search Actor reference code in Actor Page
	 * 
	 */
	public void searchReferenceActorCodeActorPage(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Actors", "Actors"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(type(appPages.actors_page.txt_ReferenceCode, data.get("ActorCode"), "ActorCode TextBox"));
		reportData.add(click(appPages.actors_page.btn_MoreOption, "MoreOptions Button"));
		reportData.add(click(appPages.actors_page.btn_Search, "Search Button"));
		reportData.add(click(appPages.actors_page.lnk_Reference, "Reference Link"));
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "searchReferenceActorCodeActorPage");

		logger.log(LogStatus.INFO, "Successfully Searched Actor Code",
				attchedStepScreenShot("Successfully Searched Actor Code", "Yes"));

	}	
	
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Verify PastEvent Pop up elements
	 */
	public void verifyPastEventsData(HashMap<String, String> data) throws Exception {
		List<String> reportData =  new ArrayList<String>();
		String pastEvent=data.get("PastEvent");
		List<String> pastEventList = splitInputData(pastEvent, ",");
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		scrollToView(appPages.actors_page.btn_ArrowMark_ActroListPage, "Arrow Button");
		reportData.add(click(appPages.actors_page.btn_ArrowMark_ActroListPage, "Arrow Button"));
		reportData.add(click(appPages.actors_page.sel_PastEvent, "PastEvents Select"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventTable,"PastEvent Table"));

		if(!pastEvent.equals("") && !pastEvent.equals(null)){
			for(int i=0;i<pastEventList.size();i++){
				reportData.add(click(getStringWebElement(appPages.actors_page.lnk_PastEvent,pastEventList.get(i)), "XPATH", pastEventList.get(i)+" Link"));
				sleep(4000);
				reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, pastEventList.get(i)+" Screen"));
				reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventDetails,  pastEventList.get(i)+" DialogBox"));
				reportData.add(click(appPages.actors_page.btn_Close,"Close Button"));
				sleep(2000);
				//reportData.add(switchToDefaultFrameContent());
				reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
			}
		} else{
			reportData.add(click(appPages.actors_page.lnk_EventFirstRow, "Event Link"));
			reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, " PastEventDetail Screen"));
			reportData.add(waitForVisibilityOfElement(appPages.actors_page.vfy_PastEventDetails, "PastEventDetail DialogBox"));
			reportData.add(click(appPages.actors_page.btn_Close,"Close Button"));
			sleep(2000);
		}
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "verifyPastEvents");
		logger.log(LogStatus.INFO, "Successfully Verified Past Events",attchedStepScreenShot("Successfully Verified Past Events","Yes"));
	}
	
	public void validateModifiedAddressForExistingCustomer(HashMap<String, String> data ,String AddressType) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(waitForVisibilityOfElement(appPages.actors_page.tab_Address, "Addresses Tab"));
		reportData.add(click(appPages.actors_page.tab_Address, "Addresses Tab"));
		sleep(7000);
		String tbl_AddressList = "(//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//table/tbody/tr";
		/*int tblRowNum = driver.findElements(By.xpath(tbl_AddressList)).size();
		String lastRowNum = tbl_AddressList + "[" + tblRowNum  + "]/td";
		//scrollToView(driver.findElement(By.xpath(lastRowNum)), "");
		sleep(3000);
		tblRowNum = driver.findElements(By.xpath(tbl_AddressList)).size();*/
		String requiredRow = tbl_AddressList + "/td//span[text()='"+AddressType+"']/../../../../td//span[text()='"+data.get("NewAddress")+"'])[1]";		
		for(int i=0;i<10;i++){
			try{
				scrollToView(driver.findElement(By.xpath(requiredRow)), AddressType+" Link");
				sleep(2000);
				actionClick(driver.findElement(By.xpath(requiredRow)),AddressType+" Link");
				sleep(2000);
				break;
			}catch(Exception e)
			{
				e.printStackTrace();			
				click(appPages.actors_page.btn_TableNext, "Nextpage Button");
				sleep(4000);	
			}
		}
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.actors_page.vfy_AddressType, "Address Type"), "XPATH", "title", AddressType, "AddressType Dropdown"));

		try{
			String tblZipcode="(//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//table/tbody/tr/td//span[text()='%s']/../../../../td//span[text()='%s'])[1]/../../../..//td[3]//span/span"; 
			String tbl_Zipcode = String.format(tblZipcode, AddressType, data.get("NewAddress"));
			WebElement tbl_ZipcodeEle = getWebelement("XPATH", tbl_Zipcode);
			String tbl_ZipcodeUI = tbl_ZipcodeEle.getText();
			if(tbl_ZipcodeUI.contains(data.get("ZipCode")))
			{
				reportData.add("Pass" + "~" + "isPresentElement" + "~" + "ZipCode" + "~" +"Presented Value On Screen Is: " + tbl_ZipcodeUI + attchedStepScreenShot("Verified With Zipcode" ));
			}
			//reportData.add(verifyText(tbl_ZipcodeEle,data.get("ZipCode"),"Zipcode"));
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ZipCode" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.actors_page.vfy_AddressDetails, "Address 1"), "XPATH", "value", data.get("NewAddress"), "NewAddress TextBox"));
		//reportData.add(verifyFieldAttribute((setStringValueInToWebElement(appPages.actors_page.vfy_AddressDetails, "City", "XPATH")), "value", data.get("City"), "City TextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "validateModifiedAddressForExistingCustomer");
		logger.log(LogStatus.INFO, "Successfully Validated Modified Address");
	}
	
	
}
