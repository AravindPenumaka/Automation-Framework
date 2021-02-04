package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class SearchContract_Funcs extends BasePageMod {
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	
	
	public SearchContract_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description get data from excel sheet.
	 */
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
		logger.log(LogStatus.INFO, "Successfully Searched Contract Details",
				attchedStepScreenShot("Successfully Searched Contract Details", "Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param updateAttachedActorStatus
	 * @throws Exception
	 * @description click and Update Attached Status under Event
	 */
	public void updateAttachedActorStatus(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		sleep(2000);
		reportData.add(scrollToView(appPages.contract_page.lnk_UpdateAttachedActorStatus, "UpdateAttachedActorStatus Link"));
		reportData.add(click(appPages.contract_page.lnk_UpdateAttachedActorStatus, "UpdateAttachedActorStatus Link"));
		sleep(7000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Update Attached Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Update Attached Actor Screen"));
		sleep(2000);
		reportData.add(isPresentAndDisplayed(appPages.contract_page.lbl_UpdateAttachedActorStatus,
				"UpdateAttachedActorStatus Label"));
		reportData.add(isPresentAndDisplayed(appPages.contract_page.tbl_AttachedActors, "AttachedActors Table"));

		String lnk_Reference= String.format(appPages.contract_page.lnk_Reference,data.get("Reference"));
	    WebElement lnk_ReferenceElemt = getWebelement("XPATH", lnk_Reference);
		
  
		reportData.add(scrollToView(appPages.contract_page.lst_Status, "Status Dropdown"));
		reportData.add(select(appPages.contract_page.lst_Status, data.get("UpdateStatus"), "StatusDropdown"));
		reportData.add(scrollToView(appPages.contract_page.btn_Apply, "Apply Button"));
		reportData.add(click(appPages.contract_page.btn_Apply, "Apply Button"));
		reportData.add(scrollToView(appPages.actors_page.btn_finish, "Finish Button"));
		reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
		sleep(4000);
		reportData.add(scrollToView(appPages.actors_page.btn_Close, "Close Button"));
		reportData.add(click(appPages.contract_page.btn_Close, "Close Button"));
		sleep(3000);

		createReportTableEntry(reportData, "updateAttachedActorStatus");
		logger.log(LogStatus.INFO, "Successfully Update Actor Attached Status",
				attchedStepScreenShot("Successfully Update Actor Attached Status", "Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param  updateAttachedActorStatus
	 * @throws Exception
	 * @description verify AttachedActorsTable 
	 */
	 public List<String> verifyAttachedActorsTable(HashMap<String, String> data) throws Throwable {
		 List<String> reportData = new ArrayList<String>();
		 sleep(3000);
		 reportData.add(switchToDefaultFrameContent());
		 reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Update Attached Actor Screen"));
		 reportData.add(click(appPages.contract_page.tab_AttachedActors, "AttachedActors Tab"));
		 sleep(3000);
		 reportData.add(click(appPages.contract_page.lnk_AttachedActors_Expand, "AttachedActors ExpandLink"));
		 sleep(1500);
		 reportData.add(isPresentAndDisplayed(appPages.contract_page.tbl_AttachedActorsContract, "AttachedActors Table"));
	     
		 String RoleCode= data.get("RoleCode");
		 String Status=data.get("Status");
		 try{
			 String tbl_actorsAttachedRowValue= String.format(appPages.contract_page.tbl_AttachedActorsValue,RoleCode,Status);
		     WebElement actorsAttachedElem = getWebelement("XPATH", tbl_actorsAttachedRowValue);
		     reportData.add(isPresentAndDisplayed(actorsAttachedElem, "Actors Attached Table Value"));
		 }catch(Exception e){
			 reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AttachedActorTable" + "~" + "Element being looked is not found." +getExceptionMessage(e.getMessage()));
		 }
		 createReportTableEntry(reportData, "verifyAttachedActorsTable");
		 logger.log(LogStatus.INFO, "Successfully verified Account Condition Table Value",attchedStepScreenShot("Successfully verified Account Condition Table Value","Yes"));
		return reportData;
	}

	 /***
	 * @author Koyal
	 * @param  updateAttachedActorStatus
	 * @throws Exception
	 * @description Change AssignedActorsTable 
	 */
	 public void changeAssignedActors(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		String TypeOfChange=data.get("TypeOfChange");
		String SecondaryActors=data.get("SecondaryActors");
		reportData.add(click(appPages.actors_page.lnk_More, "MoreArrow Button"));
		reportData.add(scrollToView(appPages.contract_page.lnk_ChangeAssignedActors, "ChangeAssignedActors Link"));
		reportData.add(click(appPages.contract_page.lnk_ChangeAssignedActors, "ChangeAssignedActors Link"));
		sleep(5000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To ChangeAssignedActors"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To ChangeAssignedActors"));
		sleep(2000);
		reportData.add(isPresentAndDisplayed(appPages.contract_page.lbl_ChangeAssignedActors, "ChangeAssignedActors Label"));
		reportData.add(select(appPages.contract_page.lst_TypeOfChange, TypeOfChange,"TypeOfChange Dropdown"));
		reportData.add(click(appPages.contract_page.lst_SecondaryActors,"SecondaryActors Dropdown"));
		sleep(2000);
		reportData.add(click(appPages.contract_page.lst_SecondaryActorsValue,"SecondaryActors Option"));
		
		reportData.add(verifyFieldAttribute(appPages.contract_page.vfy_RoleStatus, "title", "Borrower", "Role Status"));
		reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.actors_page.btn_Next, "Next button"));
		sleep(2000);
		scrollToView(appPages.commonSrn_page.btn_Finish, "Finish button");
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish button"));
		sleep(2000);
		scrollToView(appPages.actors_page.btn_Confirm, "Confirm Button");
		reportData.add(click(appPages.actors_page.btn_Confirm, "Confirm Button"));
		sleep(2000);
		reportData = concatList(reportData, verifyAttachedActorsTable(data));
		//Verify Attached Actors
	    createReportTableEntry(reportData, "changeAssignedActors");
		logger.log(LogStatus.INFO, "Successfully verified the Attached Actors after Modification",attchedStepScreenShot("Successfully verified the Attached Actors after Modification","Yes"));
	}	

}
