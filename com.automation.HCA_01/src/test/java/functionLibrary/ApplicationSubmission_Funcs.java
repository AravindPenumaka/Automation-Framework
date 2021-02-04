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

public class ApplicationSubmission_Funcs extends BasePageMod{
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	HashMap<String, String> data;
	
	public ApplicationSubmission_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	@SuppressWarnings("unchecked")
	public void searchDealerList(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		switchToFrame("iFrm", "Frame");
		switchToFrame("nav", "Top Frame");
		reportData.add(click(appPages.appSubmission_page.lnk_Switch, "Switch Link"));
		switchToDefaultFrameContent();
		switchToFrame("iFrm", "Frame");
		switchToFrame("main", "Frame");
		System.out.println(data.get("StateCode"));
		reportData.add(type(appPages.appSubmission_page.txt_StateCode, data.get("StateCode"), "StateCode TextBox"));
		reportData.add(click(appPages.appSubmission_page.btn_SearchDealer, "Search Button"));
		createReportTableEntry(reportData, "searchDealerList");
		logger.log(LogStatus.INFO, "Successfully Searched Dealer List", attchedStepScreenShot("Successfully Searched Dealer List", "Yes"));
	}
	
	public void clickOnSwitchDealer() throws Throwable
	{
		click(appPages.appSubmission_page.btn_Switch,"SwitchDealer Button");
		logger.log(LogStatus.PASS, "Click On SwitchDealer Button", "");
	}
	
	@SuppressWarnings("unchecked")
	public void applicantSelection(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.appSubmission_page.lst_NewApp, "NewApp DropDown"));
		click(appPages.appSubmission_page.lnk_NewIndividualApp, "IndividualApp Link");
		if (data.get("CoApplicant").equalsIgnoreCase("Yes")) {
			reportData.add(click(appPages.appSubmission_page.lst_CoApp, "CoApp"));
			reportData.add(click(appPages.appSubmission_page.lst_CoAppSelect, "CoApp Link"));
		}
		createReportTableEntry(reportData, "applicantSelection");
		sleep(3000);
		logger.log(LogStatus.INFO, "Successfully Applicant Selected", attchedStepScreenShot("Successfully Applicant Selected", "Yes"));
	}
	
	@SuppressWarnings("unchecked")
	public void fillApplicantDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.appSubmission_page.txt_LastName, data.get("LastName"), "LastName TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_FirstName, data.get("FirstName"), "FirstName TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_SSN, data.get("SSN"), "SSN TextBox"));
		System.out.println(data.get("SSN"));
		reportData.add(type(appPages.appSubmission_page.txt_ExtendedZipCode, data.get("Zip"), "ZIPCode TextBox"));

		if (data.get("CoApplicant").equalsIgnoreCase("Yes")) {
			reportData.add(click(appPages.appSubmission_page.btn_CopyApplicatDetails, "CopyApplicantDetails Button"));
			switchToFrame("creditAppDynaValidatorActionForm", "Time Fframe");
			reportData.add(type(appPages.appSubmission_page.txt_CoApplicantLastName, data.get("CoApplicantLastName"),
					"CoApplicantLastName TextBox"));
			reportData.add(type(appPages.appSubmission_page.txt_CoApplicantFirstName, data.get("CoApplicantFirstName"),
					"CoApplicantFirstName TextBox"));
			reportData.add(type(appPages.appSubmission_page.txt_CoAppTimeAtJobYears,
					data.get("CoApplicantWorkingHours"), "CoApplicantWorkingHoursYears TextBox"));
			reportData.add(type(appPages.appSubmission_page.txt_CoAppTimeAtJobMonths,
					data.get("CoApplicantWorkingHours"), "CoApplicantWorkingHoursMonths TextBox"));
			reportData.add(type(appPages.appSubmission_page.txt_CoAppSSN,data.get("COSSN"),"COAppSSN TextBox"));
		}

		reportData.add(select(appPages.appSubmission_page.lst_Make, data.get("Make"), "CarSelection DropDown"));
		reportData.add(select(appPages.appSubmission_page.lst_Model, data.get("Model"), "Model DropDown"));
		reportData.add(select(appPages.appSubmission_page.lst_Style, data.get("Style"), "Style DropDown"));
		reportData.add(type(appPages.appSubmission_page.txt_InceptionMiles, data.get("InceptionMiles"),
				"InceptionMiles TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_CapCost, data.get("CapCost"), "CapitalCost TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_Term, data.get("Term"), "Term TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_WholeSaleInvoice, data.get("Invoice"),
				"WholeSaleInvoice TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_MSRPRouteOne, data.get("MSRP"), "MSRP TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_Comments, data.get("Comments"), "Comments TextBox"));
		reportData.add(select(appPages.appSubmission_page.lst_CreditBureau, "TransUnion", "CreditBureau DropDown"));
		reportData.add(click(appPages.appSubmission_page.cb_KiaMotorFinance, "KiaFinance CheckBox"));
		reportData.add(
				select(appPages.appSubmission_page.lst_ProgramCode, data.get("ProgramCode"), "ProgramCode DropDown"));
		reportData.add(select(appPages.appSubmission_page.lst_FinancePromotion, data.get("FinancePromotion"),
				"FinancePromotion DropDown"));
		reportData.add(click(appPages.appSubmission_page.btn_Submit, "Submit Button"));
		reportData.add(acceptAlert("Submit Alert"));
		createReportTableEntry(reportData, "fillApplicantDetails");
		logger.log(LogStatus.INFO, "Successfully Filled Applicant Details", attchedStepScreenShot("Successfully Filled Applicant Details", "Yes"));
	}
	
	public void clickOnSwitchDealerandSubmitApp() throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		System.out.println(driver.findElement(By.xpath("//table[@id='GridViewSearchResult']//tr[3]//td[6]")).getText());
		int i=3;
		while(true)
		{
			if(driver.findElement(By.xpath("//table[@id='GridViewSearchResult']//tr["+i+"]//td[6]")).getText().contains("1"))
			{
				click(driver.findElement(By.xpath("//table[@id='GridViewSearchResult']//tr["+i+"]//td[2]//input")),"Switch");
				break;
			}
			else {
				i++;
			}
		}
		sleep(3000);
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrack,"MainFrame"));
		switchToFrame("nav", "frameName");
		reportData.add(click(appPages.appSubmission_page.btn_SubmitApp,"SubmitAnApp Link"));
		switchToDefaultFrameContent();
		createReportTableEntry(reportData, "clickOnSwitchDealerandSubmitApp");
		logger.log(LogStatus.PASS, "Successfully Clicked On SwitchDealer Button And SubmitApp", attchedStepScreenShot("Successfully Clicked On SwitchDealer Button And SubmitApp", "Yes"));
	}
	
	@SuppressWarnings("unchecked")
	public void fillDealerTrackApplicantDetails(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		//waitForVisibilityOfElement(appPages.appSubmission_page.rb_VehicleCondition, "");
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrack,"MainFrame"));
		switchToFrame("main", "frameName");
		sleep(2000);
		reportData.add(click(appPages.appSubmission_page.rb_VehicleCondition, "NewVehicleCondition RadioButton"));
		
		if (data.get("Account").equalsIgnoreCase("Balloon")) {
			reportData.add(click(appPages.appSubmission_page.rb_ProductTypeBalloon, "BalloonProductType RadioButton"));
		
		} else if (data.get("Account").equalsIgnoreCase("Retail")) {
			reportData.add(click(appPages.appSubmission_page.rb_ProductTypeRetail, "RetailProductType RadioButton"));
		}
		if(data.get("ApplicationType").equals("Individual"))
		{
			reportData.add(click(appPages.appSubmission_page.btn_IndividualApplication, "IndividualApplication Button"));
		}
		else if(data.get("ApplicationType").equals("Joint")){
			reportData.add(click(appPages.appSubmission_page.btn_JointApplication,"JointApplicationButton"));
		}
		reportData.add(type(appPages.appSubmission_page.txt_DtFirstName, data.get("FirstName"), "FirstName Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_DtLastName, data.get("LastName"), "LastName Textbox"));
		sleep(200);
		reportData.add(type(appPages.appSubmission_page.txt_SSN1, data.get("SSN"), "SSN Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_DateOfBirth, data.get("DateOfBirth"), "DateOfBirth Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_Street, data.get("Street"), "Street Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_StreetName, data.get("StreetName"), "StreetName Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_City, data.get("City"), "City Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_State, data.get("State"), "State Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_ZipCode, data.get("Zip"), "ZipCode Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_HomePhone,data.get("BussinessPhone"),"HomePhone TextBox"));
		sleep(3000);
		appPages.appSubmission_page.txt_Phone3.sendKeys(Keys.TAB);
		appPages.appSubmission_page.txt_Phone1.sendKeys(Keys.TAB);
		appPages.appSubmission_page.txt_Phone2.sendKeys(Keys.TAB);
		appPages.appSubmission_page.txt_otherPhone3.sendKeys(Keys.TAB);

		
		//*[@id="app_ownership_type"]/option[2]
		
		reportData.add(type(appPages.appSubmission_page.txt_YearsAtAddress,data.get("YearsAtAddress"),"YearsAtAddress TextBox"));
		appPages.appSubmission_page.txt_YearsAtAddress.sendKeys(Keys.TAB);
		reportData.add(type(appPages.appSubmission_page.txt_MaonthsAtAddress,data.get("MaonthsAtAddress"),"MonthsAtAddress TextBox"));
		appPages.appSubmission_page.txt_MaonthsAtAddress.sendKeys(Keys.TAB);
		reportData.add(select(appPages.appSubmission_page.lst_HousingStatus, data.get("HousingStatus"), "HousingStatus Dropdown"));
		//appPages.appSubmission_page.lst_HousingStatus.sendKeys(Keys.TAB);
		reportData.add(type(appPages.appSubmission_page.txt_MtgOrRent, data.get("Rent"), "Rent Textbox"));
		reportData.add(select(appPages.appSubmission_page.lst_EmployementStatus, data.get("EmployementStatus"), "EmployementStatus Dropdown"));
		reportData.add(type(appPages.appSubmission_page.txt_EmployedBy, data.get("EmployedBy"), "EmployedBy Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_BussinessPhone, data.get("BussinessPhone"), "BussinessPhone Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_YearsEmployed, data.get("YearsEmployed"), "YearsEmployed Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_MonthsEmployed, data.get("MonthsEmployed"), "MonthsEmployed Textbox"));
		reportData.add(type(appPages.appSubmission_page.txt_GrossSalary, data.get("GrossSalary"), "GrossSalary Textbox"));
		reportData.add(select(appPages.appSubmission_page.lst_SalaryType, data.get("SalaryType"), "SalaryType Dropdown"));
		
		
		if(data.get("ApplicationType").equals("Joint")){
		reportData.add(select(appPages.appSubmission_page.lst_RelationToApplicant,data.get("RelationToApplicant"),"RelationshipToApplicant DropDown"));
		reportData.add(type(appPages.appSubmission_page.txt_DtCoAppFirstName,data.get("CoApplicantFirstName"),"CoApplicantFirstName TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_DtCoAppLastName,data.get("CoApplicantLastName"),"CoApplicantLastName TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_DtCoAppSSN,data.get("COSSN"),"CoApplicantSSN"));
		reportData.add(type(appPages.appSubmission_page.txt_DtCoAppDateOfBirth,data.get("CoApplicantDOB"),"CoApplicantDateOfBirth"));
		reportData.add(click(appPages.appSubmission_page.btn_CopyApplicantAddress,"CopyApplicantAddress Button"));
		sleep(2000);
		reportData.add(select(appPages.appSubmission_page.lst_CoAppHousingStatus,data.get("COAppHousingStatus"),"CoAppHousingStatus DropDown"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppMtgOrRent,data.get("Rent"),"Rent TextBox"));
		reportData.add(select(appPages.appSubmission_page.lst_CoAppEmployementStatus,data.get("COAppEmployementStatus"),"CoAppEmployemntStatus DropDown"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppEmployedBy,data.get("EmployedBy"),"CoAppEmployedBy TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppBussinessPhone,data.get("BussinessPhone"),"CoAppPhone TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppYearsEmployed,data.get("YearsEmployed"),"CoAppYearsEmployed TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppMonthsEmployed,data.get("MonthsEmployed"),"CoAppMonthsEmployed"));
		reportData.add(type(appPages.appSubmission_page.txt_CoAppGrossSalary,data.get("GrossSalary"),"CoAppGrossSalary TextBox"));
		reportData.add(select(appPages.appSubmission_page.lst_CoAppSalaryType,data.get("CoAppSalaryType"),"CoAppSalaryType DropDown"));
		}
		
		
		reportData.add(select(appPages.appSubmission_page.lst_VehicleYear, data.get("VehicleYear"), "VehicleYear Dropdown"));
		sleep(1000);
		reportData.add(select(appPages.appSubmission_page.lst_VehicleMake, data.get("VehicleMake"), "VehicleMake Dropdown"));
		sleep(1000);
		reportData.add(select(appPages.appSubmission_page.lst_VehicleModel, data.get("VehicleModel"), "VehicleModel Dropdown"));
		sleep(2000);
		reportData.add(select(appPages.appSubmission_page.lst_VehicleTrim, data.get("VehicleTrim"), "VehicleTrim Dropdown"));
		reportData.add(type(appPages.appSubmission_page.txt_TermMonths,"2","TermMonths TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_AppPrice,"16000","AppPrice TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_SalesTax,"152","SalesTax TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_AppTTL,"200","APPTTl TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_Invoice,"20000","Invoice TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_Mileage,"25","Mileage TextBox"));
		reportData.add(type(appPages.appSubmission_page.txt_MSRP,"25000","MSRP TextBox"));
		
		reportData.add(click(appPages.appSubmission_page.btn_SelectLenders, "SelectLenders Button"));
		sleep(3000);
		createReportTableEntry(reportData, "fillDealerTrackApplicantDetails");
		logger.log(LogStatus.PASS, "Successfully Filled DealerTrack Applicant Details", attchedStepScreenShot("Successfully Filled DealerTrack Applicant Details", "Yes"));
	}
	
	
	public void verifyAppStatusandSubmit(HashMap<String, String> data) throws Exception {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.appSubmission_page.cb_Finance,"Finance CheckBox"));
		reportData.add(click(appPages.appSubmission_page.btn_SubmitOrInquire,"Submit Button"));
		sleep(1500);
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrackLanderSpecific,"LenderSpecific Frame"));
		waitForVisibilityOfElement(appPages.appSubmission_page.lst_ProgramCodeDealerTrack,"ProgramCode Dropdown");
		reportData.add(select(appPages.appSubmission_page.lst_ProgramCodeDealerTrack,data.get("ProgramCode"),"ProgramCode Dropdown"));
		reportData.add(click(appPages.appSubmission_page.btn_SubmitLenderSpecificData,"Submit Button"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrack,"DealerTrack Frame"));
		switchToFrame("main","main Frame");
		reportData.add(click(appPages.appSubmission_page.cb_ConfirmSubmit,"ConfirmSubmit CheckBox"));
		reportData.add(click(appPages.appSubmission_page.btn_Continue,"Continue Button"));

		/*reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrackPopup,"Popup Frame"));
		reportData.add(click(appPages.appSubmission_page.btn_PopupOk,"PopupOk"));*/
		reportData.add(verifyText(appPages.appSubmission_page.txt_Message, "Your Application Has Been Sent", "ConfirmMeaasge Verify"));
		
		switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrack, "DealerTrack Frame"));
		switchToFrame("nav", "Farme");
		
		reportData.add(click(appPages.appSubmission_page.btn_AppStatus,"AppStatus Button"));
		sleep(200);
		switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_DealerTrack,"DealerTrack Frame"));
		switchToFrame("main","main Frame");
		reportData.add(click(appPages.appSubmission_page.btn_LenderStatus,"LenderStatus Button"));
		createReportTableEntry(reportData, "verifyAppStatusandSubmit");
        sleep(3000);
        logger.log(LogStatus.INFO, "Successfully App Status Verified and Submitted", attchedStepScreenShot("Successfully App Status Verified and Submitted", "Yes"));
	}
	
	
	/***
	 * @author Aravind
	 * @param producttype
	 * @throws Throwable
	 * @description submit an application
	 */
	public void submitAnApplication(String producttype) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.appSubmission_page.btn_Switch,"SwitchDealer Button"));
		reportData.add(click(appPages.appSubmission_page.btn_SubmitApp,"SubmitAnApp Button"));
		reportData.add(selectRadioBtn("appPages.appSubmission_page.rb_VehicleCondition","New RadioButton"));
		if(producttype.contains("balloon"))
		{
			reportData.add(selectRadioBtn("appPages.appSubmission_page.rb_ProductTypeBalloon","BalloonProductType RadioButton"));
		}
		else if(producttype.contains("retail"))
		{
			reportData.add(selectRadioBtn("appPages.appSubmission_page.rb_ProductTypeRetail","RetailProductType RadioButton"));
		}
		
		reportData.add(click(appPages.appSubmission_page.btn_IndividualApplication,"IndividualApplication Button"));
		
		
		createReportTableEntry(reportData, "submitAnApplication");
        sleep(3000);
		logger.log(LogStatus.PASS, "submitAnApplication", "");
	}
}
