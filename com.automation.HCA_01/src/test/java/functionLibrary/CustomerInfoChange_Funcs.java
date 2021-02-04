package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class CustomerInfoChange_Funcs extends BasePageMod{

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;


	public CustomerInfoChange_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	@SuppressWarnings("unchecked")
	public void retreiveCustomerAccountDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.customerInfoChange_page.lst_FindAccount,"FindingContact DropDown"));
		System.out.println(data.get("AccountNumber"));
		reportData.add(click(appPages.customerInfoChange_page.lst_Contacts, "Contacts Link"));
		reportData.add(type(appPages.customerInfoChange_page.txt_AccountNumber,data.get("AccountNumber"),"Account Number Input"));
		reportData.add(click(appPages.customerInfoChange_page.btn_FindAccount,"SearchContactName Button"));
		System.out.println(appPages.customerInfoChange_page.lnk_AccountNumber.getText());
		if(appPages.customerInfoChange_page.lnk_AccountNumber.getText().equals(data.get("AccountNumber")))
		{
			reportData.add(click(appPages.customerInfoChange_page.lnk_AccountNumber, "AccountNumber Link"));
		}
		waitForLoadingIconGone_CRM(20000);
		reportData.add(click(appPages.customerInfoChange_page.btn_CloseSearch, "CloseSearch Button"));
		createReportTableEntry(reportData, "retreiveCustomerAccountDetails");
		logger.log(LogStatus.INFO, "Successfully Retreived Customer Account Details", attchedStepScreenShot("Successfully Retreived Customer Account Details", "Yes"));
	}

	public void selectServiceRequestType(HashMap<String, String> data) throws Exception {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.customerInfoChange_page.lst_NewServiceRequest, "ServiceRequestName DropDown"));
		reportData.add(selectComboBoxList(appPages.customerInfoChange_page.lst_NewServiceRequest,data.get("ServiceRequest"), "ServiceRequestName DropDown"));
		reportData.add(click(appPages.customerInfoChange_page.btn_Go, "Go Button"));
		createReportTableEntry(reportData, "selectServiceRequestType");
		logger.log(LogStatus.INFO, "Successfully Selected Service Request", attchedStepScreenShot("Successfully Selected Service Request", "Yes"));
	}


	public void clickOnContactInfo() throws Exception {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.customerInfoChange_page.btn_ContactNameSearch,"ContactSelection Button"));
		reportData.add(click(appPages.customerInfoChange_page.btn_PickContactOk, "PickingContact Button"));
		waitForLoadingIconGone_CRM(20000);
		createReportTableEntry(reportData, "clickOnContactInfo");
		logger.log(LogStatus.INFO, "Successfully Clicked On Contact Info", attchedStepScreenShot("Successfully Clicked On Contact Info", "Yes"));
	}

	public void fillCustomerDetails(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		//reportData.add(click(appPages.customerInfoChange_page.btn_EmployerNameSearch,"EmployerNameSearch Button"));
		//reportData.add(click(appPages.customerInfoChange_page.btn_EmployerNameSearchOk,"EmpoyeSearchOk Button"));
		reportData.add(type(appPages.customerInfoChange_page.txt_NewEmployerName, data.get("EmployerName"), "EmployerName TextBox"));

		if(data.get("FromDate") == null || data.get("FromDate") == ""){
			reportData.add(type(appPages.customerInfoChange_page.txt_EmployementFromDate, getCurrentDate(), "FromDate TextBox"));
		} else {
			reportData.add(type(appPages.customerInfoChange_page.txt_EmployementFromDate, data.get("FromDate"), "FromDate TextBox"));
		}
		reportData.add(type(appPages.customerInfoChange_page.txt_NewEmail, data.get("Email"), "NewEmail TextBox"));

		reportData.add(click(appPages.customerInfoChange_page.btn_Submit,"Submit"));
		waitForLoadingIconGone_CRM(10000);
		if(isAlertPresent()){
			acceptAlert("Accepted Alert");
		}
		sleep(5000);
		reportData.add(scrollToView(appPages.customerInfoChange_page.txt_Status, "Status Scroll"));
		if(!(data.get("Status") == null || data.get("Status") == "")){
			reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Status,"value", data.get("Status"),"Status TextBox"));
			reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_SubStatus,"value", data.get("SubStatus"),"SubStatus TextBox"));
		}
		if(data.get("DocumentsReceived").equalsIgnoreCase("true"))
		{
			reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.cb_DocumentsReceived,"aria-checked", "true","DocumentsReceived CheckBox"));
		}
		createReportTableEntry(reportData, "fillCustomerDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Customer Deatils",attchedStepScreenShot("Successfully Filled Customer Deatils", "Yes"));
	}

	public void fillandValidateAddressDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.customerInfoChange_page.btn_NewCustomerAddress, "AddNewAddress Button"));
		sleep(5000);
		reportData.add(type(appPages.customerInfoChange_page.txt_NewAddressType, data.get("AddressType"),"AddressType TextBox"));
		appPages.customerInfoChange_page.txt_NewAddressType.sendKeys(Keys.TAB);
		reportData.add(type(appPages.customerInfoChange_page.txt_NewAddress, data.get("NewAddress"), "Address TextBox"));
		appPages.customerInfoChange_page.txt_NewAddress.sendKeys(Keys.TAB);
		reportData.add(click(appPages.customerInfoChange_page.btn_NewZipCode, "ZipCodeSearch Button"));
		reportData.add(click(appPages.customerInfoChange_page.btn_ZipCodeOk, "ZipCode Button"));
		
		try{
			String ZipCode=appPages.customerInfoChange_page.txt_ZipCodeMain.getText();
			setValueProperty("ZipCode", ZipCode);
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ZipCode" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}

		
		reportData.add(click(appPages.customerInfoChange_page.btn_Validate, "Validate Button"));
		waitForLoadingIconGone_CRM(9000);
		//reportData.add(verifyCheckBox(appPages.customerInfoChange_page.cb_Validate, "title", "checked", "Validate CheckBox"));
		if(data.get("Accept/Override").equals("Override"))
		{
			reportData.add(click(appPages.customerInfoChange_page.tbl_OverrideOrAccpet,"Override/Accept Table"));
			reportData.add(click(appPages.customerInfoChange_page.lst_AcceptOrOverride,"Override/Accept List"));
			highLightElement(appPages.customerInfoChange_page.lst_Override);
			reportData.add(click(appPages.customerInfoChange_page.lst_Override,"Override Option"));
		}
		else if(data.get("Accept/Override").equals("Accept"))
		{
			reportData.add(click(appPages.customerInfoChange_page.tbl_OverrideOrAccpet,"Override/Accept Table"));
			reportData.add(click(appPages.customerInfoChange_page.lst_AcceptOrOverride,"Override/Accept List"));
			highLightElement(appPages.customerInfoChange_page.lst_Accept);
			reportData.add(click(appPages.customerInfoChange_page.lst_Accept,"Accept Option"));
		}
		createReportTableEntry(reportData, "fillandValidateAddressDetails");
		logger.log(LogStatus.INFO, "Successfully Filled New Address",attchedStepScreenShot("Successfully Filled New Address", "Yes"));
	}


	public void retrieveAssetDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Asset", "Asset"));
		reportData.add(select(appPages.customerInfoChange_page.lst_Find, "Asset", "Asset Finding"));
		reportData.add(type(appPages.customerInfoChange_page.txt_Code, data.get("AssetCode"), "AssetCode"));
		reportData.add(click(appPages.customerInfoChange_page.btn_CodeSearch, "SearchCode"));
		if (isPresentAndDisplayed(appPages.customerInfoChange_page.lnk_Code, "Assert Code") != null) {
			reportData.add(click(appPages.customerInfoChange_page.lnk_Code, "SelectCode"));
		}
		reportData.add(type(appPages.customerInfoChange_page.txt_Name, "A", "Name TextBox"));
		reportData.add(click(appPages.customerInfoChange_page.lnk_ElementList, "EvenList Tab"));

		createReportTableEntry(reportData, "retrieveAssetDetails");
		logger.log(LogStatus.INFO, "Successfully Retrieved Asset Details",
				attchedStepScreenShot("Successfully Retrieved Asset Details", "Yes"));
	}

	public void fillAddressChangeValue() throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.customerInfoChange_page.tab_AddressList, "Address List"));
		reportData.add(click(appPages.customerInfoChange_page.lnk_AssetAddressChange,"AssetAddressChange Link"));
		reportData.add(select(appPages.customerInfoChange_page.lst_AddressToChange,"","AddressToChange DropDown"));
		reportData.add(click(appPages.customerInfoChange_page.btn_GeneralInfoNext,"Next Button"));
		createReportTableEntry(reportData, "fillAddressChangeValue");
		logger.log(LogStatus.INFO, "Successfully Filled Address Change Value", attchedStepScreenShot("Successfully Filled Address Change Value", "Yes"));
	}


	public void searchAssetNumber(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.customerInfoChange_page.lst_GlobalSearch, "Global Search List"));
		reportData.add(type(appPages.customerInfoChange_page.txt_CodeAssetNo,true, data.get("AssetCode"), "Asset Number Textbox"));
		reportData.add(click(appPages.customerInfoChange_page.img_Search, "Search Button"));
		createReportTableEntry(reportData, "searchAssetNumber");
		logger.log(LogStatus.INFO, "Succesfully Searched Asset Number",
				attchedStepScreenShot("Succesfully Searched Asset Number", "Yes"));
	}


	public void changeAssetAddress(HashMap<String, String> data) throws Throwable{

		searchAssetNumber(data);
		clickOnElementTab();
		verifyGeneralInfo(data);
		modifyAdressDetails(data);
		verifyCleansedAddressDetails(data);
	}

	public void clickOnElementTab() throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Element Screen"));
		reportData.add(click(appPages.customerInfoChange_page.tab_ElementList, "Elementlist Tab"));
		sleep(5000);
		switchToDefaultFrameContent();
		reportData.add(click(appPages.customerInfoChange_page.lnk_AssetAddressChange, "AssetAddress Change Link"));
		createReportTableEntry(reportData, "clickOnElementTab ");
		logger.log(LogStatus.INFO, "Successfully Clicked On Element Tab",
				attchedStepScreenShot("Successfully Clicked On Element Tab", "Yes"));
	}

	public void verifyGeneralInfo(HashMap<String, String> data) throws Exception{	
		List<String> reportData =  new ArrayList<String>();
		String Fieldvalue=data.get("VerifyElementListField");
		List<String> inpDataList = splitInputData(Fieldvalue, ",");
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To General Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To General Sub Screen"));
		sleep(2000);
		for(int i = 0;i<inpDataList.size();i++){
			String fldName = inpDataList.get(i);
			String fieldName1 = String.format(appPages.customerInfoChange_page.vfy_FieldName, fldName);
			reportData.add(verifyFieldName(fieldName1, fldName));
		}
		reportData.add(click(appPages.customerInfoChange_page.btn_NextGeneralInfoTab,"nextbutton"));
		createReportTableEntry(reportData, "verifyGeneralInfo");
		logger.log(LogStatus.INFO, "Successfully Verified General Information", attchedStepScreenShot("Successfully Verified General Information","Yes"));
	}

	public void modifyAdressDetails(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.customerInfoChange_page.txt_AdressOne, true, data.get("AddressOne"), "AdressOne Textbox "));
		reportData.add(type(appPages.customerInfoChange_page.txt_AdressTwo, true, data.get("AddressTwo"), "AdressTwo Textbox "));
		sleep(2000);
		reportData.add(click(appPages.customerInfoChange_page.btn_NextAddresstab, "nextbutton"));
		reportData.add(acceptAlert("VertexCleanActor PopUp"));
		createReportTableEntry(reportData, "modifyAdressDetails");
		logger.log(LogStatus.INFO, "Successfully Modified Address Details", attchedStepScreenShot("Successfully Modified Address Details","Yes"));
	}

	public void verifyCleansedAddressDetails(HashMap<String, String> data) throws Exception{	
		List<String> reportData =  new ArrayList<String>();

		sleep(1000);
		switchToFrame("s_bes_aae", "frame"); 
		//reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.vfy_ValidAccStatus, "value", data.get("ValidAddressStatus"), "AccountStatus TextField"));
		reportData.add(click(appPages.customerInfoChange_page.btn_NextCleansedAddresstab,"Next Button"));
		sleep(2000);
		reportData.add(acceptAlert("InvalidAddress PopUp"));
		sleep(2000);
		reportData.add(click(appPages.customerInfoChange_page.btn_BackCleansedAddresstab," Back Button "));
		createReportTableEntry(reportData, "verifyCleansedAddressDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Cleansed Address Details", attchedStepScreenShot("Successfully Verified Cleansed Address Details","Yes"));
	}

	public void verifyRecapInformation(HashMap<String, String> data) throws Exception{	
		List<String> reportData =  new ArrayList<String>();
		sleep(3000);

		if(data.get("OverrideAddress").equals("Yes")){
			reportData = concatList(reportData, this.clickOnOverrideAddress());
		}
		//reportData.add(click(appPages.customerInfoChange_page.btn_NextGeneralInfoTab,"nextbutton"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Newaddress1Recap, "value", "", "NewAddress1 TextField"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Newaddress2Recap, "value", "", "NewAddress2 TextField"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Oldaddress1Recap, "value", "", "OldAddress1 TextField"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Oldaddress2Recap, "value", "", "OldAddress2 TextField"));
		reportData.add(click(appPages.customerInfoChange_page.btn_FinishRecap,"Finish Button"));
		waitForVisibilityOfElement(appPages.customerInfoChange_page.btn_Close,"Close Button");
		reportData.add(click(appPages.customerInfoChange_page.btn_Close,"Close Button"));
		createReportTableEntry(reportData, "verifyRecapInformation");
		logger.log(LogStatus.INFO, "Successfully Verified Recap Information", attchedStepScreenShot("Successfully Verified Recap Information","Yes"));
	}

	@SuppressWarnings("unchecked")
	public void verifyModifiedAddress (HashMap<String, String> data) throws Throwable{	
		List<String> reportData =  new ArrayList<String>();  	

		reportData.add(click(appPages.customerInfoChange_page.lnk_AssetAddressChange,"assetaddresschange event"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Address Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To AddressSub Screen"));
		reportData.add(click(appPages.customerInfoChange_page.btn_NextGeneralInfoTab,"Next Button"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_AdressOne, "value", "", "ModifiedAddress1 TextField"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_AdressTwo, "value", "", "ModifiedAddress2 TextField"));
		sleep(3000);
		createReportTableEntry(reportData, "verifyModifiedAddress");
		logger.log(LogStatus.INFO, "Successfully Verified Modify-Address Details", attchedStepScreenShot("Successfully Verified Modify-Address Details","Yes"));
	}

	public List<String> clickOnOverrideAddress() throws Exception{	
		List<String> reportData =  new ArrayList<String>();
		waitForVisibilityOfElement(appPages.customerInfoChange_page.cb_OverrideAddress,"Override CheckBox");
		reportData.add(click(appPages.customerInfoChange_page.cb_OverrideAddress,"Override CheckBox")); 
		reportData.add(click(appPages.customerInfoChange_page.btn_NextAddresstab,"Next Button")); 
		return reportData;
	}

	public void fillNameChange(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.customerInfoChange_page.txt_LastName,true,data.get("LastName"), "LastName Textbox"));
		reportData.add(type(appPages.customerInfoChange_page.txt_Reason, "Name Change", "ReasonForClosure TextBox"));
		reportData.add(click(appPages.customerInfoChange_page.cb_DocumentReceived, "DocumentReceived CheckBox"));
		reportData.add(click(appPages.customerInfoChange_page.btn_Submit,"Submit"));
		waitForLoadingIconGone_CRM(10000);
		sleep(5000);
		reportData.add(scrollToView(appPages.customerInfoChange_page.txt_Status, "Status Scroll"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_Status,"value", data.get("Status"),"Status TextBox"));
		reportData.add(verifyFieldAttribute(appPages.customerInfoChange_page.txt_SubStatus,"value", data.get("SubStatus"),"SubStatus TextBox"));
		createReportTableEntry(reportData, "fillNameChange");
		logger.log(LogStatus.INFO, "Successfully Filled Name Change",attchedStepScreenShot("Successfully Filled Name Change", "Yes"));
	}

	public void verifyNameChange(HashMap<String, String> data) throws Exception {
		List<String> reportData = new ArrayList<String>();
		String reportString = null;
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To General Screen"));
		waitForVisibilityOfElement(appPages.customerInfoChange_page.txt_FullName, "FullName TextBox");
		String FullName= appPages.customerInfoChange_page.txt_FullName.getAttribute("value");
		String changeName= data.get("LastName");
		if(FullName.contains(changeName))
		{
			reportString = "Pass" + "~" + "validate" + "~" + "FullName" + "~" + "Match Found For Value: " + changeName ;
		}
		reportData.add(reportString);
		createReportTableEntry(reportData, "verifyNameChange");
		logger.log(LogStatus.INFO, "Successfully Verified Name Change",attchedStepScreenShot("Successfully Verified Name Change", "Yes"));
	}

	//modified
	public void verifyCleansedAddressDetailsWithOutOverRide(HashMap<String, String> data) throws Exception{ 
		List<String> reportData =  new ArrayList<String>();

		sleep(3000);
		//modified
		switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cleansed address Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Cleansed address Sub Screen"));


		reportData.add(click(appPages.customerInfoChange_page.btn_NextCleansedAddresstab,"Next Button"));
		sleep(2000);
		reportData.add(acceptAlert("InvalidAddress PopUp"));

		createReportTableEntry(reportData, "verifyCleansedAddressDetailsWithOutOverRide");
		logger.log(LogStatus.INFO, "Successfully Verified Cleansed Address Details WithOutOverRide", attchedStepScreenShot("Successfully Verified Cleansed Address Details WithOutOverRide","Yes"));
	}
   
   public void OverrrideAddress(HashMap<String, String> data) throws Exception{
	   List<String> reportData =  new ArrayList<String>();
	   reportData.add(click(appPages.customerInfoChange_page.btn_NewCustomerAddress, "AddNewAddress Button"));
	   waitForLoadingIconGone_CRM(5000);
	   reportData.add(type(appPages.customerInfoChange_page.txt_NewAddressType, data.get("AddressType"),"AddressType TextBox"));
	   appPages.customerInfoChange_page.txt_NewAddressType.sendKeys(Keys.TAB);
	   reportData.add(click(appPages.customerInfoChange_page.btn_ExistingAddress,"SelectExistingAddress Button"));
	   waitForLoadingIconGone_CRM(5000);
	   int i=2;
	   try{
		   for(int j=0;j<driver.findElements(By.xpath("//table[@summary='Address Applet']//tr")).size();j++){
			   if(driver.findElements(By.xpath("//table[@summary='Address Applet']//tr["+i+"]/td")).size()>3){
				   reportData.add(click("//table[@summary='Address Applet']//tr["+i+"]","XPATH","Address List"));
				   reportData.add(click(appPages.customerInfoChange_page.btn_AddressOk, "AddressOk Button"));
				   break;
			   }
		   }
	   }catch(Exception e){
		   reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AddressFeilds" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
	   }
	   waitForLoadingIconGone_CRM(5000);
	   reportData.add(click(appPages.customerInfoChange_page.btn_Validate, "Validate Button"));
	   waitForLoadingIconGone_CRM(5000);
	   reportData.add(click(appPages.customerInfoChange_page.tbl_OverrideOrAccpet,"Override/Accept Table"));
	   reportData.add(click(appPages.customerInfoChange_page.lst_AcceptOrOverride,"Override/Accept List"));
	   highLightElement(appPages.customerInfoChange_page.lst_Override);
	   reportData.add(click(appPages.customerInfoChange_page.lst_Override,"Override Option"));
	   reportData.add(click(appPages.customerInfoChange_page.btn_Submit,"Submit"));
	   waitForLoadingIconGone_CRM(5000);
	   createReportTableEntry(reportData, "OverrrideAddress");
	   logger.log(LogStatus.INFO, "Successfully Overrride selected Address", attchedStepScreenShot("Successfully Overrride selected Address","Yes"));
   }

	public void verifyAddressChange(HashMap<String, String> data) throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.customerInfoChange_page.tab_Contacts,"Contacts Tab"));
		reportData.add(click(appPages.customerInfoChange_page.tab_Contacts,"Contacts Tab"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(verifyText(appPages.customerInfoChange_page.vfy_Street, data.get("Street"), "verify Street"));
		reportData.add(verifyText(appPages.customerInfoChange_page.vfy_City, data.get("City"), "verify City"));
		reportData.add(verifyText(appPages.customerInfoChange_page.vfy_State, data.get("State"), "verify State"));
		reportData.add(verifyText(appPages.customerInfoChange_page.vfy_Zip, data.get("ZipCode"), "verify Zip"));
		scrollToView(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown");
		reportData.add(click(appPages.serviceRequest_page.btn_ThirdLevelMoreOption,"ThirdLevelMoreOption Dropdown"));
		reportData.add(select(appPages.serviceRequest_page.btn_ThirdLevelMoreOption, "Service Requests", "ServiceRequests Tab"));
		waitForLoadingIconGone_CRM(3000);
		reportData.add(waitForVisibilityOfElement(appPages.customerInfoChange_page.vfy_SRCreated, "ServiceRequests Created"));
		createReportTableEntry(reportData, "verifyAddressChange");
		logger.log(LogStatus.INFO, "Successfully Verified Address Change", attchedStepScreenShot("Successfully Verified Address Change","Yes"));
	}
}
