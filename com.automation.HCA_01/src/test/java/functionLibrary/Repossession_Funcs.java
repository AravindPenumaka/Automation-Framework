package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Repossession_Funcs extends BasePageMod{
	
	private static final String String = null;
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	HashMap<String, String> data;
	String locatortype;
	WebElement element;
	List<String> reportData =  new ArrayList<String>();
	public Repossession_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	String elementpath="//li[text()='%s']";
	
	/***
	 * 
	 * @param data
	 * @throws Throwable
	 */
	public void fillRepossessionInfoandSubmit(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		//modified on 6/19/2019
		
		List<String> ServiceRequestOption =  splitInputData(data.get("NewSerRqstOpt"), ",");
		if(data.get("NewSerRqstOpt").contains(","))
		{
			reportData.add(click(appPages.fraud_page.lst_NewServiceRqstArrow, "NewServiceRequestArrow Button"));
			sleep(1000);
			//modified on 6/19/2019
			//String serviceRequest = String.format(appPages.fraud_page.lst_ServiceRequest, ServiceRequestOption.get(0));
			reportData.add(click(getStringWebElement(appPages.fraud_page.lst_ServiceRequest, ServiceRequestOption.get(0)),"XPATH","NewServiceRequest Select"));
			reportData.add(click(appPages.fraud_page.btn_NewServiceRqst_GO, "Go Button"));
			waitForLoadingIconGone_CRM(5000);
			if(isAlertPresent()){
				reportData.add(acceptAlert("Accept Alert"));
			}
			System.out.println("");
			waitForLoadingIconGone_CRM(5000);
		}
		reportData.add(click(appPages.repossession_page.lst_RepossessionType,"Repossessiontype DropDown"));
		reportData.add(click(getStringWebElement(elementpath, data.get("RepossessionType")),"XPATH","RepossesionType Select"));
		reportData.add(click(appPages.repossession_page.lst_RepossessionReason,"RepossessionReason DropDown"));
		reportData.add(click(getStringWebElement(elementpath,data.get("RepossessionReason")),"XPATH","RepossesionReason Select"));
		reportData.add(click(appPages.repossession_page.lst_CriteriaOverride,"CriteriaOverride DropDown"));
		reportData.add(click(getStringWebElement(elementpath,data.get("CriteriaOverride")),"XPATH","CriteriaOverride Select"));
		reportData.add(click(appPages.repossession_page.btn_Submit,"Submit Button"));
		waitForLoadingIconGone_CRM(5000);
		String SR=appPages.repossession_page.txt_SRNumber.getAttribute("value");
		
        setValueProperty("SR",SR);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterSubmitStatus"), "Status After Submit"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterSubmitSubStatus"), "SubStatus After Submit"));
		createReportTableEntry(reportData, "fillRepossessionInfoandSubmit");
		logger.log(LogStatus.INFO, "Successfully Submitted Repossession Details",
				attchedStepScreenShot("Successfully Submitted Repossession Details", "Yes"));
	}
	
	
	public void submitConditionReport(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(type(appPages.repossession_page.txt_RepossessionAssignedDate, getCurrentDate(),"RepossessionAssignedDate"));
		reportData.add(click(appPages.repossession_page.btn_AgencyAssigned,"AgencyAssigned Button"));
		waitForLoadingIconGone_CRM(10000);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterAgencyAssignedStatus"), "Status After AgencyAssigned"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterAgencyAssignedSubStatus"), "SubStatus After AgencyAssigned"));
		reportData.add(type(appPages.repossession_page.txt_ConditionReportDate,getCurrentDate(),"ConditionReportDate"));
		reportData.add(scrollToView(appPages.repossession_page.btn_RepoDate, "RepoDate Scroll"));
		reportData.add(click(appPages.repossession_page.btn_RepoDate,"RepoDate Button"));
		reportData.add(click(appPages.repossession_page.lnk_ActiveDate,"Selectdate Link"));
		reportData.add(click(appPages.repossession_page.btn_Done,"Done Button"));
		reportData.add(scrollToView(appPages.repossession_page.btn_SubmitConditionReport,"ConditionReport Scroll"));
		try{
			reportData.add(click("//ul[@role='tablist']//li//a[text()='Attachments'] | //option[text()='Attachments']","XPATH","Attachments Tab"));
			waitForLoadingIconGone_CRM(5000);
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\InputFiles\\"+ data.get("fileName");
			reportData = concatList(reportData,uploadDocument(appPages.repossession_page.txt_InputFile,path));
			//appPages.repossession_page.txt_InputFile.sendKeys(data.get("FilePath"));
			reportData.add(click("//ul[@role='tablist']//li//a[text()='Repossession'] | //option[text()='Repossession']","XPATH","Repossession Tab"));
			waitForLoadingIconGone_CRM(5000);
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AttachmentandRepossessionTab" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		reportData.add(click(appPages.repossession_page.cb_ManualReportCheckBox,"Manual Checkbox"));
		sleep(5000);
		reportData.add(scrollToView(appPages.repossession_page.btn_NewAddress,"NewAddress Scroll"));
		reportData.add(click(appPages.repossession_page.btn_NewAddress,"NewAddres Button"));
		sleep(2000);
		reportData.add(click(appPages.repossession_page.lst_AddressType,"AddressType DropDown"));
		reportData.add(click(getStringWebElement(elementpath, "Agency Address"),"XPATH","AddressType Select"));
		appPages.repossession_page.lst_MainAddressType.sendKeys(Keys.TAB);
		reportData.add(click(appPages.repossession_page.lst_AddressSubType,"AddressSubType DropDown"));
		reportData.add(click(getStringWebElement(elementpath, "Storage Address"),"XPATH","AddressSubType Select"));
		appPages.repossession_page.lst_MainAddressSubType.sendKeys(Keys.TAB);
		appPages.repossession_page.txt_ContractName.sendKeys(Keys.TAB);
		reportData.add(type(appPages.repossession_page.txt_OtherContract,data.get("OtherContractName"),"OtherContract TextBox"));
		appPages.repossession_page.txt_OtherContract.sendKeys(Keys.TAB);
		reportData.add(type(appPages.repossession_page.txt_Street,"123STReet","Street TextBox"));
		appPages.repossession_page.txt_Street.sendKeys(Keys.TAB);
		reportData.add(type(appPages.repossession_page.txt_City,"Testcity","City TextBox"));
		appPages.repossession_page.txt_City.sendKeys(Keys.TAB);
		reportData.add(click(appPages.repossession_page.lst_State,"State DropDown"));
		reportData.add(click(getStringWebElement(elementpath,data.get("State")),"XPATH","State Select"));
		appPages.repossession_page.lst_MainState.sendKeys(Keys.TAB);
		reportData.add(click(appPages.repossession_page.lst_Country,"Country DropDown"));
		reportData.add(click(getStringWebElement(elementpath,data.get("Country")),"XPATH","Country Select"));
		appPages.repossession_page.lst_MainCountry.sendKeys(Keys.TAB);
		reportData.add(type(appPages.repossession_page.txt_ZipCode,"522201","ZipCode TextBox"));
		reportData.add(scrollToView(appPages.repossession_page.btn_SubmitConditionReport,"ConditionReport Scroll"));
		reportData.add(click(appPages.repossession_page.btn_Settings,"Settings Button"));
		reportData.add(click(appPages.repossession_page.lst_SaveRecord,"SaveRecord Select"));
		reportData.add(click(appPages.repossession_page.btn_SubmitConditionReport,"SubmitCondotionReport Button"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterSubmitReportStatus"), "Status After Submit"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterSubmitReportSubStatus"), "SubStatus After Submit"));
		reportData.add(click(appPages.fraud_page.btn_FinancialAccounts,"FinancialAccounts Button"));
		createReportTableEntry(reportData, "submitConditionReport");
		logger.log(LogStatus.INFO, "Successfully Submitted Condiiotn Report",
				attchedStepScreenShot("Successfully Submitted Condiiotn Report", "Yes"));
	}
	
	
	public void fillRedemptiondeatilsandSubmit(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.lst_NewServiceRqstArrow, "NewServiceRequestArrow Button"));
		sleep(1000);
		List<String> SR=splitInputData(data.get("NewSerRqstOpt"), ",");
		String serviceRequest = getStringWebElement(appPages.fraud_page.lst_ServiceRequest, SR.get(1));
		reportData.add(verifyText(driver.findElement(By.xpath(serviceRequest)), SR.get(1),data.get("NewSerRqstOpt")));
		reportData.add(click(driver.findElement(By.xpath(serviceRequest)), "NewServiceRequest Select"));
		reportData.add(click(appPages.fraud_page.btn_NewServiceRqst_GO, "Go Button"));
		if(isAlertPresent()){
			reportData.add(acceptAlert("Accept Alert"));
		}
		waitForLoadingIconGone_CRM(5000);
		reportData.add(click(appPages.repossession_page.lst_SubType,"SubType DropdDown"));
		reportData.add(click(getStringWebElement(elementpath,data.get("SubType")),"XPATH", "SubType Select"));
		reportData.add(click(appPages.repossession_page.btn_ContactNameSearch,"ContactSearch Button"));
		reportData.add(click(appPages.repossession_page.btn_ContractOk,"OK Button"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(scrollToView(appPages.repossession_page.txt_RevisedAmount, "RevisedAmount Scroll"));
		reportData.add(type(appPages.repossession_page.txt_RevisedAmount,data.get("RevisedAmount"),"RevisedAmount TextBox"));
		reportData.add(type(appPages.repossession_page.txt_EstimatedRepoFee,"200","EstimatedRepoFee TextBox"));
		reportData.add(click(appPages.repossession_page.btn_FetchPayoffQuote,"FetchPayoffQuote Button"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(scrollToView(appPages.repossession_page.txt_OverrideReason, "OverrideReason Scroll"));
		reportData.add(type(appPages.repossession_page.txt_OverrideReason,"Other","OverrideReason TextBox"));
		reportData.add(scrollToView(appPages.repossession_page.btn_CheckFeeSubmit, "CheckFeeSubmit Scroll"));
		reportData.add(click(appPages.repossession_page.btn_CheckFeeSubmit,"CheckFeeRedemptionSubmit Button"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterRedemptionSubmitStatus"), "Status After Submit"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterRedemptionSubmitSubStatus"), "SubStatus After Submit"));
		createReportTableEntry(reportData, "fillRedemptiondeatilsandSubmit");
		logger.log(LogStatus.INFO, "Successfully Submitted Redemption Details",
				attchedStepScreenShot("Successfully Submitted Redemption Details", "Yes"));
	}
	
	
	public void vehicleReleaseandVerifyAccountCondition(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.repossession_page.btn_Completepaymentreceived,"CompltePaymentReceived Button"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterPaymentReceivedStatus"), "Status After Submit"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterPaymentReceivedSubStatus"), "SubStatus After Submit"));
		reportData.add(click(appPages.repossession_page.btn_VehicleReleased,"VehicleRelease Button"));
		waitForLoadingIconGone_CRM(5000);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_Status,"value",data.get("AfterReleaseStatus"), "Status After Submit"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_SubStatus,"value",data.get("AfterReleaseSubStatus"), "SubStatus After Submit"));
		createReportTableEntry(reportData, "vehicleReleaseandVerifyAccountCondition");
		logger.log(LogStatus.INFO, "Successfully vehicle Released and Verified Account Condition",
				attchedStepScreenShot("Successfully vehicle Released and Verified Account Condition", "Yes"));
	}
	
	public void verifyNOI(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData =  new ArrayList<String>();
		//reportData.add(click(appPages.fraud_page.btn_FinancialAccounts,"FinancialAccounts Button"));
		reportData.add(click(appPages.repossession_page.lst_DropDown,"DropDown Button"));
		try{
			reportData.add(click("//option[text()='Correspondence']","XPATH","Correspondence Tab"));
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "CorrespondenceTab" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		sleep(2000);
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_NOICorrespondence,"title",data.get("AccountNumber"),"AccountNumber Verify"));
		reportData.add(verifyFieldAttribute(appPages.repossession_page.txt_NOIStatus,"title","Submitted","NOIStatus Verify"));
		createReportTableEntry(reportData, "verifyNOI");
		logger.log(LogStatus.INFO, "Successfully verifyNOI Verified",
				attchedStepScreenShot("Successfully vehicle verifyNOI Verified", "Yes"));
	}
}
