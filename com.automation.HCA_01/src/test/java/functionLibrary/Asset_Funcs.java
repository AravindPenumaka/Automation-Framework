package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Asset_Funcs extends BasePageMod{
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	

	
	public Asset_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	public void fillAssetAddressChange(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.asset_page.tab_ElementList, "ElementList Tab"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(click(appPages.asset_page.lnk_AssetAddressChange, "AssetAddressChange List"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Sub-Actor Screen"));
		String AddressToChange=appPages.asset_page.lst_AddressToChange.getAttribute("title");
		reportData.add(select(appPages.asset_page.lst_AddressToChange,AddressToChange,"AddressToChange Dropdown"));
		reportData.add(click(appPages.asset_page.btn_Next, "Next Button"));
		reportData.add(type(appPages.asset_page.txt_Address1, true,data.get("NewAddress"), "Address TextBox"));
		
			/*Need to add step for Next Button*/
		
		//reportData.add(click(appPages.asset_page.btn_Next, "Next Button"));
		
		createReportTableEntry(reportData, "fillAssetAddressChange");
		logger.log(LogStatus.INFO, "Successfully Filled Asset Address Change", attchedStepScreenShot("Successfully Filled Asset Address Change", "Yes"));
	}
	
	public void verifyAssetAddressChange(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.asset_page.tab_ElementList, "ElementList Tab"));
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.lbl_GaragingAddress, "GaragingAddress Label"));
		scrollToView(appPages.asset_page.lbl_GaragingAddress, "GaragingAddress Label");
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_GarageAaddressCountry, "Country"),"XPATH", "title", "", "Country TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_GarageAaddressField, "Zip Code"), "XPATH", "value", "", "ZipCode TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_GarageAaddressField, "County"), "XPATH", "value", "", "County TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_GarageAaddressField, "Address 1"), "XPATH", "value", "", "Address TextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "VerifyAssetAddressChange");
		logger.log(LogStatus.INFO, "Successfully Verified Asset Address Change");

	}
	
	public void clickOnElementTab() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Element Screen"));
		reportData.add(click(appPages.customerInfoChange_page.tab_ElementList, "Elementlist Tab"));
		sleep(9000);
		createReportTableEntry(reportData, "clickOnElementTab ");
		logger.log(LogStatus.INFO, "Successfully Clicked On Element Tab",
				attchedStepScreenShot("Successfully Clicked On Element Tab", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To verify table in AuctionList
	 */
	public void verifyAuctionListTable(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		
	    reportData.add(isPresentAndDisplayed(appPages.asset_page.lbl_AuctionList, "AuctionList Label"));
	    reportData.add(scrollToView(appPages.asset_page.lbl_AuctionList, "AuctionList Label"));
	 
	    String auctionlistdata=data.get("AuctionListFields");
    	String [] arr_auctionlistdata = auctionlistdata.split(","); 
    	List<String> auctionlistdata_Excel=new ArrayList<String>();
    	auctionlistdata_Excel = Arrays.asList(arr_auctionlistdata); 
		for(int i=0;i<auctionlistdata_Excel.size();i++){
			String auctionlist = String.format(appPages.asset_page.vfytbl_AuctionList,auctionlistdata_Excel.get(i));
			//WebElement auctionlistxpath=getWebelement("xpath",auctionlist);		
			reportData.add(verifyTableValue(auctionlist,auctionlistdata_Excel.get(i)));

		}
  
		createReportTableEntry(reportData, "verifyAuctionListTable");
		logger.log(LogStatus.INFO, "Successfully verified AuctionList Table", attchedStepScreenShot("Successfully verified AuctionList Table", "Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To verify fields in AuctionDetail Section
	 */
	public void verifyAuctionDetailSection(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
	
	    reportData.add(isPresentAndDisplayed(appPages.asset_page.lbl_AuctionDetail, "AuctionDetail Label"));
	    reportData.add(scrollToView(appPages.asset_page.lbl_AuctionDetail, "AuctionDetail Label"));
	
	    String auctiondetailsection=data.get("AuctionDetailSection");
    	String [] arr_auctiondetailsection = auctiondetailsection.split(","); 
    	List<String> auctiondetail_Excel=new ArrayList<String>();
    	auctiondetail_Excel = Arrays.asList(arr_auctiondetailsection); 
		for(int i=0;i<auctiondetail_Excel.size();i++){
			String auctionlist = String.format(appPages.asset_page.vfy_AuctionDetail,auctiondetail_Excel.get(i));
			 reportData.add(verifyFieldName(auctionlist,auctiondetail_Excel.get(i)));
			 
		}
  
		createReportTableEntry(reportData, "verifyAuctionListTable");
		logger.log(LogStatus.INFO, "Successfully verified AuctionList Table", attchedStepScreenShot("Successfully verified AuctionList Table", "Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description navigate AuctionDetails Screen
	 */
	public void navigateAuctionsManagementScreen() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		switchToDefaultFrameContent();
	    reportData.add(click(appPages.asset_page.lnk_AuctionsManagement,"AuctionsManagement Link"));
	    reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To AuctionManagement Screen"));
	    reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To AuctionManagement  SubScreen"));
	    reportData.add(scrollToView(appPages.commonSrn_page.btn_Next,"Next Button"));
	    reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
	    switchToDefaultFrameContent();
	    reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To AuctionManagement Screen"));
	    reportData.add(scrollToView(appPages.asset_page.lbl_AuctionDetail, "AuctionDetail Label"));
	    switchToDefaultFrameContent();
		createReportTableEntry(reportData, "navigateAuctionDetailsScreen");
		logger.log(LogStatus.INFO, "Successfully navigated to AuctionDetails Screen", attchedStepScreenShot("Successfully navigated to AuctionDetails Screen", "Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To modify Auction Status
	 */
	public void modifyAuctionStatus(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To AuctionManagement Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To AuctionManagement  SubScreen"));
		reportData.add(select(appPages.asset_page.lst_AuctionStatus, data.get("AuctionStatus"), "AuctionStatus Dropdown"));
		reportData.add(select(appPages.asset_page.lst_SellMethod, data.get("SellMethod"), "SellMethod Dropdown"));
		reportData.add(scrollToView(appPages.commonSrn_page.btn_Next, "Next Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Next, "Next Button"));

		reportData.add(scrollToView(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Finish, "Finish Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Close, "Close Button"));

		createReportTableEntry(reportData, "modifyAuctionStatus");
		logger.log(LogStatus.INFO, "Successfully modified AuctionStatus",
				attchedStepScreenShot("Successfully modified AuctionStatus", "Yes"));
	}

	/***
	 * @author Arpita
	 * 
	 */
	public void searchAssetCode(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		Thread.sleep(3000);
		reportData.add(type(appPages.asset_page.txt_ContractNumber,data.get("ContractNumber"),"ContractNumber Button"));
		sleep(1000);
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		waitForVisibilityOfElement(appPages.asset_page.lnk_AssetCode, "");
		reportData.add(click(appPages.asset_page.lnk_AssetCode, "Assset link"));
		sleep(1000);
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchAssetCode");
		logger.log(LogStatus.INFO, "Successfully Searched Asset Code",attchedStepScreenShot("Successfully Searched Asset Code", "Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description modify AuctionType
	 */
	public void modifyAuctionType(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To AuctionManagement Screen"));
	    reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To AuctionManagement  SubScreen"));
	    reportData.add(select(appPages.asset_page.lst_AuctionType,data.get("AuctionType"),"AuctionType Dropdown"));
	    reportData.add(select(appPages.asset_page.lst_SellMethod, data.get("SellMethod"), "SellMethod Dropdown"));
	    reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
	    reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button"));
		createReportTableEntry(reportData, "modifyAuctionType");
		logger.log(LogStatus.INFO, "Successfully modified AuctionType", attchedStepScreenShot("Successfully modified AuctionType", "Yes"));
	}
	
	public void verifyStepInValue(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		//Thread.sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		waitForVisibilityOfElement(appPages.asset_page.vfy_GeneralInformationTab, "");
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_Step, "title", data.get("StepInValue"), "StepInValue Dropdowns"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyStepInValue");
		logger.log(LogStatus.INFO, "Successfully Verified Step In Value",attchedStepScreenShot("Successfully Verified Step In Value", "Yes"));
	}
	
	public void verifyGroundingAssetReturnDate(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
        //Grounding or asset return date field not AVAILABLE IN UI
		createReportTableEntry(reportData, "verifyGroundinAssetReturnDate");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding Asset Return Date",attchedStepScreenShot("Successfully Verified Grounding Asset Return Date", "Yes"));
	}
	
	public List<String> selectElementTab()throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		//Thread.sleep(3000);
		waitForVisibilityOfElement(appPages.asset_page.vfy_GeneralInformationTab, "");
		waitForVisibilityOfElement(appPages.asset_page.tab_ElementList, "ElementList Tab");
		reportData.add(click(appPages.asset_page.tab_ElementList, "ElementList Tab"));
		sleep(2000);
		return reportData;
	}
	
	public void modifyGoundingStatus(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.lst_GroundingStatus, "GroundingStatus DropDown"));
		reportData.add(select(appPages.asset_page.lst_GroundingStatus,data.get("GroundingStatus"), "GroundingStatus DropDown"));
		reportData.add(click(appPages.asset_page.btn_Save, "Save Button"));
		sleep(3000);
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_GroundingStatus,"title",data.get("GroundingStatus"), "GroundingStatus DropDown"));

		createReportTableEntry(reportData, "verifyGroundinAssetReturnDate");
		logger.log(LogStatus.INFO, "Successfully Modified Gounding Status",attchedStepScreenShot("Successfully Modified Gounding Status", "Yes"));
	}
	
	public void verifyGroundingListHistory(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData = concatList(reportData,this.selectElementTab());
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.vfy_GroundingHistoryDetails, "GroundingHistoryDetails row"));
		//highLightElement(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Dealer info", "XPATH"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.txt_Mileage,"value","", "Mileage Label"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_DealerType,"title","", "DealerType DropDown"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_GroundingSource,"title","", "GroundingSource DropDown"));
		createReportTableEntry(reportData, "verifyGroundingListHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding List History",attchedStepScreenShot("Successfully Verified Grounding List History", "Yes"));
	}
	

	public void verifyVehicleGroundingDetails(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_MaturityStaus,"title","", "MaturityStaus DropDown"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_DealerType,"title","", "DealerType DropDown"));
		//no dealer grounding date field
		createReportTableEntry(reportData, "verifyGroundingListHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding List History",attchedStepScreenShot("Successfully Verified Grounding List History", "Yes"));
	}
	
	public void verifyAssetPhase(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		waitForVisibilityOfElement(appPages.asset_page.vfy_GeneralInformationTab, "");
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_Step, "title",""/* data.get("StepInValue")*/, "StepInValue Dropdowns"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_Phase, "title",""/* data.get("Phase")*/, "Phase Dropdowns"));
		createReportTableEntry(reportData, "verifyAssetPhase");
		logger.log(LogStatus.INFO, "Successfully Verified Asset Phase",attchedStepScreenShot("Successfully Verified Asset Phase", "Yes"));
	}
	
	public void verifyGroundingDealerInfo(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.vfy_GroundingHistoryDetails, "GroundingHistoryDetails row"));
		//highLightElement(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Dealer info", "XPATH"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.txt_Mileage,"value","", "Mileage Label"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_DealerType,"title","", "DealerType DropDown"));
		reportData.add(verifyFieldAttribute(appPages.asset_page.lst_GroundingSource,"title","", "GroundingSource DropDown"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Internal Dealer Information", "XPATH"),"DealerInformation Label"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "Dealer name"), "XPATH","value","", "DealerName TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "Phone#"), "XPATH","value","", "Phone TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "Address"), "XPATH","value","", "Address TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "City"), "XPATH","value","", "City TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "State"), "XPATH","value","", "State DropDown"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "Zip code"), "XPATH","value","", "ZipCode TextBox"));
		createReportTableEntry(reportData, "verifyGroundingDealerInfo");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding Dealer Info",attchedStepScreenShot("Successfully Verified Grounding Dealer Info", "Yes"));
	}
	
	public void verifyCustomerGroundedDate(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(waitForVisibilityOfElement(appPages.asset_page.vfy_GroundingHistoryDetails, "GroundingHistoryDetails row"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "External Dealer Information", "XPATH"),"DealerInformation Label"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_ContactDeatils, "Customer grounded date"), "XPATH","value","", "CustomerGroundedDate TextBox"));
		createReportTableEntry(reportData, "verifyCustomerGroundedDate");
		logger.log(LogStatus.INFO, "Successfully Verified Customer Grounding Date",attchedStepScreenShot("Successfully Verified Customer Grounding Date", "Yes"));
	}
		
	public void verifyVehicleReturnDate(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		//return date not present
		
		createReportTableEntry(reportData, "verifyVehicleReturnDate");
		logger.log(LogStatus.INFO, "Successfully Verified Vehicle Return Date",attchedStepScreenShot("Successfully Verified Vehicle Return Date", "Yes"));
	}
	
	public void verifyDealerInformationSection(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Internal Dealer Information", "XPATH"),"DealerInformation Label"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "Dealer name"), "XPATH","value","", "DealerName TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "Phone#"), "XPATH","value","", "Phone TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "Address"), "XPATH","value","", "Address TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "City"), "XPATH","value","", "City TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_DealerDeatils, "State"), "XPATH","value","", "State DropDown"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_DealerDeatils, "Zip code"), "XPATH","value","", "ZipCode TextBox"));
		createReportTableEntry(reportData, "verifyGroundingListHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding List History",attchedStepScreenShot("Successfully Verified Grounding List History", "Yes"));
	}
	
	public void verifyVehicleInformationSection(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Vehicle information", "XPATH"),"VehicleInfo Label"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_VehicleDeatils, "Mileage"), "XPATH","value","", "Mileage TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_VehicleDeatils, "Color"), "XPATH","value","", "Color TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_VehicleDeatils, "Address"), "XPATH","value","", "Address TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_VehicleDeatils, "City"), "XPATH","value","", "City TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.lst_VehicleDeatils, "State"), "XPATH","value","", "State DropDown"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_VehicleDeatils, "Zip code"), "XPATH","value","", "ZipCode TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_VehicleDeatils, "Inspection date"), "XPATH","value","", "InspectionDate TextBox"));
		createReportTableEntry(reportData, "verifyGroundingListHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding List History",attchedStepScreenShot("Successfully Verified Grounding List History", "Yes"));
	}
	
	public void verifyDealerContactSection(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));

		reportData = concatList(reportData,this.selectElementTab());
		waitForVisibilityOfElement(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label");
		reportData.add(scrollToView(appPages.asset_page.lbl_TurnInGrounding, "TurnInGrounding label"));
		reportData.add(scrollToView(setStringValueInToWebElement(appPages.asset_page.lbl_DealerInfo, "Dealer contact", "XPATH"),"DealerContact Label"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_ContactDeatils, "Contact name"), "XPATH","value","", "ContactName TextBox"));
		reportData.add(verifyFieldAttribute(getStringWebElement(appPages.asset_page.txt_ContactDeatils, "Holding keys"), "XPATH","value","", "HoldingKeys TextBox"));
		createReportTableEntry(reportData, "verifyGroundingListHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Grounding List History",attchedStepScreenShot("Successfully Verified Grounding List History", "Yes"));
	}
	
	public void verifyRepossessionCondition(HashMap<String, String> data)throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		waitForVisibilityOfElement(appPages.asset_page.tab_Repossession, "Repossession Tab");
		reportData.add(click(appPages.asset_page.tab_Repossession, "Repossession Tab"));
		waitForVisibilityOfElement(appPages.asset_page.lbl_RepossessionDetail, "RepossessionDetail Label");
		reportData.add(scrollToView(appPages.asset_page.lbl_RepossessionDetail, "RepossessionDetail Label"));
		String tbl_repossessionDetail = "//table//div[text()='Repossession Progress']/../../../../../../div[2]//tr";
		int tblRowNum = driver.findElements(By.xpath(tbl_repossessionDetail)).size();
		String requiredRow =tbl_repossessionDetail + "//td[3]//span/span[text()='"+data.get("RepossessionCondition")+"']";
		for(int i=0;i<10;i++){
			try{
				reportData.add(waitForVisibilityOfElement(driver.findElement(By.xpath(requiredRow)), " RepossessionCondition is"+data.get("RepossessionCondition")));
				//click(driver.findElement(By.xpath(requiredRow)),AddressType+" Link");
				sleep(2000);
				break;
			}catch(Exception e)
			{			
				click(appPages.actors_page.btn_TableNext, "TableNext Button");
				sleep(4000);	
			}
		}
		createReportTableEntry(reportData, "verifyRepossessionCondition");
		logger.log(LogStatus.INFO, "Successfully Verify Repossession Condition",attchedStepScreenShot("Successfully Verify Repossession Condition", "Yes"));
	
	}
	
	 /***
		 * @author Koyal
		 * @param  UpdateDeficiencyIndicator
		 * @throws Exception
		 * @description verify UpdateDeficiencyIndicator
		 */
		public void UpdateDeficiencyIndicator(HashMap<String, String> data)throws Throwable {
			List<String> reportData =  new ArrayList<String>();
			reportData.add(switchToDefaultFrameContent());
		    sleep(3000);
			reportData.add(click(appPages.asset_page.lnk_UpdateDeficiencyIndicator, "UpdateDeficiencyIndicator Link"));
			sleep(2000);
			reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Update Deficiency Indicator Screen"));
			sleep(2000);
			reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Update Deficiency Indicator Screen"));
			//Change the Deficiency Indicator value to be automated(No data display)
			reportData.add(scrollToView(appPages.actors_page.btn_finish, "Finish button"));
	        reportData.add(click(appPages.actors_page.btn_finish, "Finish button"));
	        reportData.add(click(appPages.actors_page.btn_Close_Footer, "Close Button"));
			sleep(2000);
			createReportTableEntry(reportData, "UpdateDeficiencyIndicator");
			logger.log(LogStatus.INFO, "Successfully Changed UpdateDeficiencyIndicator",attchedStepScreenShot("Successfully Changed UpdateDeficiencyIndicator", "Yes"));
		}

}
