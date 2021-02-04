package functionLibrary;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class PayoffQuotation_Funcs extends BasePageMod{
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	
	public PayoffQuotation_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Aravind
	 * @param SheetName
	 * @param testCase
	 * @throws Throwable
	 * @description select global events and fill contract details
	 */
	@SuppressWarnings("unchecked")
	public void fillGlobalEventListAndContractDetails(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Global Events"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(click(appPages.payoffQuotation_page.btn_NewEventList,"New Button"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		reportData.add(select(appPages.payoffQuotation_page.lst_EventtoRun,data.get("EventToRun"),"EventToRun Dropdown"));
		sleep(3000);
		reportData.add(scrollToView(appPages.payoffQuotation_page.btn_GeneralInformationNext,"Next Button"));
		reportData.add(click(appPages.payoffQuotation_page.btn_GeneralInformationNext,"Next Button"));
		reportData = concatList(reportData, this.SearchCriteria(data));
		
        createReportTableEntry(reportData, "fillGlobalEventListAndContractDetails");
        logger.log(LogStatus.INFO, "Successfully Filled Global Event and Contract Details",attchedStepScreenShot("Successfully Filled Global Event and Contract Details","Yes"));
	}
	
	/***
	 * @author Aravind
	 * @param data
	 * @return
	 * @throws Exception
	 * @description search contract details by giving contact number
	 */
	@SuppressWarnings("rawtypes")
	private List SearchCriteria(HashMap<String, String> data) throws Exception {
		List<String> reportData =  new ArrayList<String>();
		reportData.add(type(appPages.payoffQuotation_page.txt_ContractNo,data.get("ContractNo"),"ContractNo TextBox"));
		reportData.add(click(appPages.payoffQuotation_page.btn_SearchContract,"SearchContract Button"));
		sleep(2000);
		reportData.add(click(appPages.payoffQuotation_page.btn_FindContractDeatails,"FindContract Button"));
		reportData.add(click(appPages.payoffQuotation_page.btn_ValidateContract,"ValidateContract Button"));
		reportData.add(scrollToView(appPages.payoffQuotation_page.btn_SearchCriteriaNext, "SearchCriteriaNext Scroll"));
		reportData.add(click(appPages.payoffQuotation_page.btn_SearchCriteriaNext,"SearchCriteriaNext Button"));
		return reportData;
	}
	
	
	/***
	 * @author Aravind
	 * @param SheetName
	 * @param testCase
	 * @throws Throwable
	 * @description fill early payoff details
	 */
	@SuppressWarnings("unchecked")
	public void fillEarlyPayoffDetails(HashMap<String, String> data) throws Throwable
	{
		Double finalval=0.0;
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.payoffQuotation_page.btn_SearchCriteriaNext,"SearchCriteriaNext Button"));
		reportData.add(type(appPages.payoffQuotation_page.txt_Date,getCurrentDate(),"Date TextBox"));
		switchToDefaultFrameContent();
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "");
		switchToFrame(appPages.frame_page.frame_AccountCond,"");
		System.out.println(data.get("Buyer"));
		highLightElement(appPages.payoffQuotation_page.lst_Buyer);
		reportData.add(select(appPages.payoffQuotation_page.lst_Buyer,data.get("Buyer"),"Buyer Dropdown"));
 		reportData.add(scrollToView(appPages.payoffQuotation_page.btn_SettingsNext, "SettingsNext Scroll"));
		reportData.add(click(appPages.payoffQuotation_page.btn_SettingsNext,"SettingsNext Button"));
		sleep(5000);
		if(isAlertPresent())
		{
			reportData.add(acceptAlert("Accept"));
		}
		
		if(isTextPresent("Error(s)"))
		{
			if(Integer.parseInt(appPages.payoffQuotation_page.txt_Error.getAttribute("value"))>=1)
			{
				reportData.add(verifyFieldAttribute(appPages.payoffQuotation_page.txt_Error,"value","null", "Error TextBox"));
				String msg=appPages.payoffQuotation_page.txt_ErrorMsg.getText();
				reportData.add(verifyText(appPages.payoffQuotation_page.txt_ErrorMsg, msg, "ErrorMessage"));
				createReportTableEntry(reportData, "fillEarlyPayoffDetails");
		        logger.log(LogStatus.INFO, "Successfully filled EarlyPayoff Details",attchedStepScreenShot("Successfully Filled EarlyPayoff Details","Yes"));
			}
		}
		else
		{
			//String SuspenseAmount=appPages.payoffQuotation_page.txt_SuspenseAmount.getAttribute("value").replace(",", ""); 
			String OutStandingPrinciple=appPages.payoffQuotation_page.txt_OutStandingPrinciple.getText().replace(",", "");
			String AccuredInterest=appPages.payoffQuotation_page.txt_AccuredInterest.getText().replace(",", "");
			for(int i=2;i<=6;i++)
			{
				try{
					 String value = getWebelement("XPATH", "//span[contains(text(),'"+data.get("ContractNo")+"')]/../../../../td["+i+"]").getText().replace(",", "");
						if (value.isEmpty()) {
							value = "0";
						}
						finalval = finalval + Double.parseDouble(value);
				}catch(Exception e){
					reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ContactNoTextBox" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
				}
			   
			}
			DecimalFormat df = new DecimalFormat("##,##0.00");
			//finalval=finalval+Double.parseDouble(OutStandingPrinciple)+Double.parseDouble(AccuredInterest)-Double.parseDouble(SuspenseAmount);
			String Amount=df.format(finalval);
			String TotalAmount=appPages.payoffQuotation_page.txt_TotalAmount.getAttribute("value");
			if(Amount.equals(TotalAmount)){
				reportData.add(verifyText(appPages.payoffQuotation_page.txt_TotalAmount,Amount, Amount+" Verify"));
			}
			else{
				finalval=finalval+Double.parseDouble(OutStandingPrinciple)+Double.parseDouble(AccuredInterest);
				reportData.add(verifyText(appPages.payoffQuotation_page.txt_TotalAmount,Amount, Amount+" Verify"));
			}
			createReportTableEntry(reportData, "fillEarlyPayoffDetails");
	        logger.log(LogStatus.INFO, "Successfully filled EarlyPayoff Details",attchedStepScreenShot("Successfully Filled EarlyPayoff Details","Yes"));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void fillContractSearch(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Contracts"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));

		reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
		reportData.add(type(appPages.contract_page.txt_Contractno, data.get("ContractNo"), "Contract No. TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		sleep(5000);
		//reportData.add(click(appPages.contract_page.lnk_Contract, "Contract link"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "fillContractSearch");
		logger.log(LogStatus.INFO, "Successfully Filled Searched Contract Number",attchedStepScreenShot("Successfully Filled Searched Contract Number", "Yes"));
	}
	
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description navigate and select Quotation tab and verify data
	 */
	@SuppressWarnings("unchecked")
	public void navigateQuotationtabandVerifyData(HashMap<String, String> data) throws Throwable
	{
		sleep(5000);
		List<String> reportData = new ArrayList<String>();
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "frameName");
		String ContractNo="//a[text()='%s']";
		//String ContractLink=String.format(ContractNo,data.get("ContractNo"));
		reportData.add(click(getStringWebElement(ContractNo, data.get("ContractNo")),"XPATH","ContractLink"));
		sleep(2000);
		reportData.add(click(appPages.EOTBilling_page.lnk_More,"More"));
		reportData.add(click(appPages.EOTBilling_page.lnk_Quotation,"Quotation Link"));
		sleep(2000);
		reportData.add(click(appPages.EOTBilling_page.btn_CollapsePane1,"Pane1"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(click(appPages.EOTBilling_page.btn_CollapsePane2,"Pane2"));
		
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "frameName");
		try{
			
			int count=driver.findElements(By.xpath("//div[text()='Vendor']/../../../../../../div[2]//table//tr")).size();
			for(int i=1;i<=count;i++){
				String element="//div[text()='Vendor']/../../../../../../div//table//tr["+i+"]//td[6]//span[text()='"+data.get("Buyer")+"']";
				try{
					WebElement buyer=getWebelement("XPATH",element);
					if(isElementPresent(buyer)){
						reportData.add(isPresentAndDisplayed(getWebelement("XPATH","//div[text()='Vendor']/../../../../../../div//table//tr["+i+"]//td[6]//span[text()='"+data.get("Buyer")+"']"),data.get("Buyer")+" Verify"));
						break;
					}
				}catch(Exception e){
					continue;
				}
		}
		}catch(Exception e)
		{
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "QuotationDataTable" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		createReportTableEntry(reportData, "navigateQuotationtabandVerifyData");
		logger.log(LogStatus.INFO, "Successfully selected QuotationTab and VerifiedData");
	}
	
	@SuppressWarnings("unchecked")
	public void fillDealerandInsuranceEarlyPayoffDetails(HashMap<String, String> data) throws Throwable
	{
		Double finalval=0.0/*,finalval1=0.0*/;
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.payoffQuotation_page.btn_SearchCriteriaNext,"SearchCriteriaNext Button"));
		reportData.add(type(appPages.payoffQuotation_page.txt_Date,getCurrentDate(),"Date TextBox"));
		switchToDefaultFrameContent();
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "");
		switchToFrame(appPages.frame_page.frame_AccountCond,"");
		System.out.println(data.get("Buyer"));
		highLightElement(appPages.payoffQuotation_page.lst_Buyer);
		reportData.add(select(appPages. payoffQuotation_page.lst_Buyer,data.get("Buyer"),"Buyer Dropdown"));
 		reportData.add(scrollToView(appPages.payoffQuotation_page.btn_SettingsNext, "SettingsNext Scroll"));
		reportData.add(click(appPages.payoffQuotation_page.btn_SettingsNext,"SettingsNext Button"));
		if(isAlertPresent())
		{
			reportData.add(acceptAlert("Accept"));
		}
		if(isTextPresent("Error(s)"))
		{
			if(Integer.parseInt(appPages.payoffQuotation_page.txt_Error.getAttribute("value"))>=1)
			{
				reportData.add(verifyFieldAttribute(appPages.payoffQuotation_page.txt_Error,"value","1", "Error TextBox"));
				//String msg=appPages.payoffQuotation_page.txt_ErrorMsg.getText();
				if(!(data.get("Error").isEmpty()))
				{
					reportData.add(verifyText(appPages.payoffQuotation_page.txt_ErrorMsg, data.get("Error"), "ErrorMessage"));
				}
				createReportTableEntry(reportData, "fillEarlyPayoffDetails");
		        logger.log(LogStatus.INFO, "Successfully filled EarlyPayoff Details",attchedStepScreenShot("Successfully Filled EarlyPayoff Details","Yes"));
			}
		}
		else
		{
			String OutStandingMonthlyAmount=appPages.payoffQuotation_page.txt_MonthlyPayment.getText().replace(",", "");
			String UnpaidMonthlyPayment=appPages.payoffQuotation_page.txt_UnpaidMonthlyPayments.getText().replace(",", "");
			String PurchaseOptionFee=appPages.payoffQuotation_page.txt_PurchaseOptionFee.getText().replace(",", "");
			if (PurchaseOptionFee.isEmpty()) {
				PurchaseOptionFee = "0";
			}
			if (OutStandingMonthlyAmount.isEmpty()) {
				OutStandingMonthlyAmount = "0";
			}
			if (UnpaidMonthlyPayment.isEmpty()) {
				UnpaidMonthlyPayment = "0";
			}
			for(int i=2;i<=6;i++)
			{
				try{
					String element="//span[contains(text(),'"+data.get("ContractNo")+"')]/../../../../td["+i+"]";
					String value = getWebelement("XPATH", element).getText().replace(",", "");
					if (value.isEmpty()) {
						value = "0";
					}
					finalval = finalval + Double.parseDouble(value);
				}catch(Exception e){
					reportData.add("Fail" + "~" + "isPresentElement" + "~" + "UnapidAmountTextBox" + "~" + "Element Loked Not Found."+"~"+getExceptionMessage(e.getMessage()));
				}		
			}
			DecimalFormat df = new DecimalFormat("##,##0.00");
			String Amount=df.format(finalval);
			String TotalAmount=appPages.payoffQuotation_page.txt_TotalAmount.getAttribute("value");
			if(finalval.equals(TotalAmount)){
				reportData.add(verifyText(appPages.payoffQuotation_page.txt_TotalAmount,Amount, Amount+" Verify"));
			}
			else{
				finalval=finalval+Double.parseDouble(OutStandingMonthlyAmount)+Double.parseDouble(UnpaidMonthlyPayment)+Double.parseDouble(PurchaseOptionFee);
				reportData.add(verifyText(appPages.payoffQuotation_page.txt_TotalAmount,Amount, Amount+" Verify"));
			}
			createReportTableEntry(reportData, "fillDealerandInsuranceEarlyPayoffDetails");
	        logger.log(LogStatus.INFO, "Successfully filled Dealer Insurance Details",attchedStepScreenShot("Successfully Filled Dealer Insurance Details","Yes"));
		}
	}
	
	public void verifyGoodThroughDays(HashMap<String, String> data) throws Exception {

		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.payoffQuotation_page.btn_SearchCriteriaNext, "SearchCriteriaNext Button"));
		reportData.add(type(appPages.payoffQuotation_page.txt_Date, getCurrentDate(), "Date TextBox"));
		switchToDefaultFrameContent();
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "");
		switchToFrame(appPages.frame_page.frame_AccountCond, "");
		System.out.println(data.get("Buyer"));
		highLightElement(appPages.payoffQuotation_page.lst_Buyer);
		reportData.add(select(appPages.payoffQuotation_page.lst_Buyer, data.get("Buyer"), "Buyer Dropdown"));
		reportData.add(scrollToView(appPages.payoffQuotation_page.btn_SettingsNext, "SettingsNext Scroll"));
		reportData.add(click(appPages.payoffQuotation_page.btn_SettingsNext, "SettingsNext Button"));
		DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		String currentdate = getCurrentDate();
		Date Earlypayoff = date.parse(currentdate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(Earlypayoff);
		cal.add(Calendar.DATE, 10);
		Earlypayoff = cal.getTime();
		String GoodthruDate = DateFormatUtils.format(Earlypayoff, "MM-dd-yyyy");
		reportData.add(
				verifyFieldAttribute(appPages.payoffQuotation_page.vfy_GoodThroughDays, "value", GoodthruDate, "Date"));
		createReportTableEntry(reportData, "verifyGoodThroughDays");
		logger.log(LogStatus.INFO, "Successfully Verified Good Through Days",
				attchedStepScreenShot("Successfully Verified Good Through Days", "Yes"));
	}
}
