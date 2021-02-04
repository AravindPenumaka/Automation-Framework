package functionLibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

public class Web_Funcs extends BasePageMod {
	
	ApplicationPages appPages;
	BasePageData basePageData = new BasePageData();;
	HashMap<String, String> data;
		public Web_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description To open CRM url
	 */
	public void open_WebUrl() throws Throwable{
		String company;
		BaseTestSuite baseTestSuite = new BaseTestSuite();
		company = baseTestSuite.readInputControlVariables("Company", 2);
		System.out.println("");
		String webUrl = null;
		
		switch (company) {
			case "KMF":
				webUrl = baseTestSuite.readInputControlVariables("KMF Desktop URL", 2);
				break;
			case "HMF":
				webUrl = baseTestSuite.readInputControlVariables("HMF Desktop URL", 2);
				break;
			case "Genesis":
				webUrl = baseTestSuite.readInputControlVariables("Genesis Desktop URL", 2);
				break;
		}
		driver.manage().window().maximize();
		driver.get(webUrl);
		logger.log(LogStatus.PASS, "Entered URL With : <a target='_blank' style='color:aqua'>" + webUrl +"</a>" , " ");
		this.waitForPageLoad(0);
	}
	
	public void fillWebLoginDetails(HashMap<String, String> data) throws Throwable{
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		reportData.add(type(appPages.web_page.txt_UserName, data.get("KMFRetail_Username"), "UserName TextBox"));
		reportData.add(type(appPages.web_page.txt_Password, data.get("KMFRetail_Password"), "Password TextBox"));
		reportData.add(click(appPages.web_page.btn_LogIn, "LogIn Button"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_LogOnScreen, "Web-LogOn Screen"));
		createReportTableEntry(reportData, "fillWebLoginDetails");
	    logger.log(LogStatus.INFO, "Successfully Logged-In Web Application",attchedStepScreenShot("Successfully Logged-In Web Application","Yes"));
	}
	
	public void fillWebLoginDetailsRememberMe(HashMap<String, String> data) throws Throwable{
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		reportData.add(type(appPages.web_page.txt_UserName, data.get("KMFRetail_Username"), "UserName TextBox"));
		reportData.add(type(appPages.web_page.txt_Password, data.get("KMFRetail_Password"), "Password TextBox"));
		highLightElement(appPages.web_page.cb_RememberMe);
		reportData.add(click(appPages.web_page.cb_RememberMe,"RememberMe CheckBox"));
		reportData.add(click(appPages.web_page.btn_LogIn, "LogIn Button"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_LogOnScreen, "Web-LogOn Screen"));
		createReportTableEntry(reportData, "fillWebLoginDetails");
	    logger.log(LogStatus.INFO, "Successfully Logged-In Web Application",attchedStepScreenShot("Successfully Logged-In Web Application","Yes"));
	}
	
	public void verifyLoginDetais(HashMap<String, String> data) throws Throwable{
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		reportData.add(verifyFieldAttribute(appPages.web_page.txt_UserName,"value", data.get("KMFRetail_Username"), "UserName TextBox"));
		//reportData.add(verifyFieldAttribute(appPages.web_page.txt_Password,"", data.get("KMFRetail_Password"), "Password TextBox"));
		createReportTableEntry(reportData, "verifyLoginDetais");
	    logger.log(LogStatus.INFO, "Successfully Verified Log-In Detail",attchedStepScreenShot("Successfully Verified Log-In Detail","Yes"));
	}
	
	public void fillForgotUsername(HashMap<String, String> data) throws Throwable{
		List<String> reportData = new ArrayList<String>();
		String reportString = null;
		sleep(2000);	
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		highLightElement(appPages.web_page.lnk_ForgotUserName);
		reportData.add(click(appPages.web_page.lnk_ForgotUserName,"ForgotUserName Link"));
		reportData.add(click(appPages.web_page.lnk_ForgotUserName,"ForgotUserName Link"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_ForgotUserNameScreen, "ForgotUserName Screen"));
		reportData.add(type(appPages.web_page.txt_Email, data.get("Email"), "Email TextBox"));
		//actionClick(appPages.web_page.lst_BirthMonth,"");
		reportData.add(actionSelect(appPages.web_page.lst_BirthMonth, data.get("BirthMonth"), "Month DropDown"));
		//actionClick(appPages.web_page.lst_BirthDay,"");
		reportData.add(actionSelect(appPages.web_page.lst_BirthDay, data.get("BirthDay"), "Day DropDown"));
		//actionClick(appPages.web_page.lst_BirthDay,"");
		reportData.add(actionSelect(appPages.web_page.lst_BirthYear, data.get("BirthYear"), "Year DropDown"));
		reportData.add(type(appPages.web_page.txt_LastFourDigitOfSSN, data.get("SSNNumber"), "SSNNumber TextBox"));
		reportData.add(click(appPages.web_page.btn_Next,"Next Button"));
		reportData.add(type(appPages.web_page.txt_SecurityAnswer, data.get("SecurityAnswer"), "SecurityAnswer TextBox"));
		reportData.add(click(appPages.web_page.btn_Next,"Next Button"));
		String newUserName=appPages.web_page.txt_NewUserName.getText();
		reportString = "Pass" + "~" + "verifyUserName" + "~" + newUserName + "~" + "UserName Retrieved";
		reportData.add(reportString);
		createReportTableEntry(reportData, "fillForgotUsername");
	    logger.log(LogStatus.INFO, "Successfully Filled Forgot Username",attchedStepScreenShot("Successfully Filled Forgot Username","Yes"));
	}
	
	
	public void fillForgotPassword(HashMap<String, String> data) throws Throwable{
		List<String> reportData = new ArrayList<String>();
		String reportString = null;
		sleep(2000);	
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		highLightElement(appPages.web_page.lnk_ForgotPassword);
		reportData.add(click(appPages.web_page.lnk_ForgotPassword,"ForgotPassword Link"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_ForgotUserNameScreen, "ForgotPassword Screen"));
		reportData.add(type(appPages.web_page.txt_ForgotPasswordUserName, data.get("UserName"), "UserName TextBox"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthMonth, data.get("BirthMonth"), "Month DropDown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthDay, data.get("BirthDay"), "Day DropDown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthYear, data.get("BirthYear"), "Year DropDown"));
		reportData.add(type(appPages.web_page.txt_LastFourDigitOfSSN, data.get("SSNNumber"), "SSNNumber TextBox"));
		reportData.add(click(appPages.web_page.btn_Next,"Next Button"));
		reportData.add(type(appPages.web_page.txt_SecurityAnswer, data.get("SecurityAnswer"), "SecurityAnswer TextBox"));
		reportData.add(click(appPages.web_page.btn_Next,"Next Button"));
		reportData.add(type(appPages.web_page.txt_NewPassword, data.get("NewPassword"), "NewPassword TextBox"));
		reportData.add(type(appPages.web_page.txt_ConfimPassword, data.get("NewPassword"), "ConfimPassword TextBox"));

		reportData.add(reportString);
		createReportTableEntry(reportData, "fillForgotPassword");
	    logger.log(LogStatus.INFO, "Successfully Fillrf Forgot Password",attchedStepScreenShot("Successfully Fillrf Forgot Password","Yes"));
	}
	
	public void logOutHMF() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		waitForVisibilityOfElement(appPages.web_page.btn_LogOut,"LogOut Button");
		reportData.add(click(appPages.web_page.btn_LogOut,"LogOut Button"));
		createReportTableEntry(reportData, "logOutHMF");
		logger.log(LogStatus.INFO, "Successfully Logged-Out HMF Application",attchedStepScreenShot("Successfully Logged-Out HMF Application","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param PaymentHistory
	 * @throws Exception
	 * @description Verify PaymentHistory
	 */
	public void paymentHistory() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
		
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_PaymentHistory, "paymentHistory link"));
        reportData.add(scrollToView(appPages.web_page.lbl_PaymentHistory, "paymentHistory Label"));
	    createReportTableEntry(reportData, "paymentHistory");
	    logger.log(LogStatus.INFO, "Successfully verified paymentHistory",attchedStepScreenShot("Successfully verified paymentHistory","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param getBuyoutQuote
	 * @throws Exception
	 * @description Verify PaymentHistory
	 */
	public void getBuyoutQuote() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_getBuyoutQuote, "getBuyoutQuote link"));
        reportData.add(scrollToView(appPages.web_page.lbl_requestPayoffQuote, "requestPayoffQuote Label"));
	    createReportTableEntry(reportData, "getBuyoutQuote");
	    logger.log(LogStatus.INFO, "Successfully verified RequestPayoffQuote",attchedStepScreenShot("Successfully verified RequestPayoffQuote","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param OneTimePayment
	 * @throws Exception
	 * @description Verify OneTimePayment
	 */
	public void OneTimePayment(HashMap<String, String> data) throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_makeAPayment, "makeAPayment link"));
        reportData.add(scrollToView(appPages.web_page.lbl_makeOTP, "makeAOneTimeOTP Label"));
        reportData.add(click(appPages.web_page.btn_payYourBill, "payYourBill button"));
        sleep(2000);
        String FirstName=generateRandomString(5, true, false);
        String LastName=generateRandomString(5, true, false);
		reportData.add(type(appPages.web_page.txt_firstName, FirstName, "FirstName TextBox"));
		reportData.add(type(appPages.web_page.txt_lastName, LastName, "LastName TextBox"));
		reportData.add(type(appPages.web_page.txt_street, data.get("VStreet_Address"), "Street TextBox"));
		reportData.add(type(appPages.web_page.txt_city, data.get("VCity"), "Street TextBox"));
		reportData.add(actionSelect(appPages.web_page.lst_state, data.get("VState"), "State Dropdown"));
		sleep(2000);
		reportData.add(type(appPages.web_page.txt_zipCode, data.get("VZipCode"), "Zipcode TextBox"));
		reportData.add(type(appPages.web_page.txt_emailAddress, data.get("VEmailAddress"), "EmailAddress TextBox"));
        reportData.add(scrollToView(appPages.web_page.lst_bankAccountType, "bankAccountType Dropdown"));
        sleep(2000);
		reportData.add(actionSelect(appPages.web_page.lst_bankAccountType, data.get("VAccountType"), "bankAccountType Dropdown"));
		sleep(2000);
		reportData.add(type(appPages.web_page.txt_routingNumber, data.get("VRoutingNumber"), "RoutingNumber TextBox"));
		reportData.add(type(appPages.web_page.txt_accountNumber, data.get("VBankAccountNumber"), "BankAccountNumber TextBox"));
        reportData.add(click(appPages.web_page.cb_saveAccountInfoForFuturePayment, "SaveThisAccountInfoForFuturePayments CheckBox"));
        sleep(2000);
        reportData.add(click(appPages.web_page.cb_agreeToTermsAndCondition, "IhaveReadAndAgreeToTheSpeedpayTermsAndConditions CheckBox"));
        sleep(2000);
        reportData.add(click(appPages.web_page.btn_next, "Next Button"));
        sleep(5000);
        reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_ReviewPage, "PleaseReviewYourPaymentInformationBeforeProceeding Label"));
        sleep(2000);
        reportData.add(scrollToView(appPages.web_page.btn_submit, "submit Button"));

	    createReportTableEntry(reportData, "OneTimePayment");
	    logger.log(LogStatus.INFO, "Successfully verified OneTimePayment",attchedStepScreenShot("Successfully verified OneTimePayment","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param postAutoPay
	 * @throws Exception
	 * @description Verify postAutoPay
	 */
	public void postAutoPay() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_setUpAutoPay, "setUpAutoPay link"));
        reportData.add(scrollToView(appPages.web_page.lbl_signUpForAutoPay, "signUpForAutoPay Label"));
        reportData.add(click(appPages.web_page.btn_setUp, "setUp button"));
        sleep(2000);
        reportData.add(click(appPages.web_page.btn_popupcancel, "setUpCancel button"));
	    createReportTableEntry(reportData, "postAutoPay");
	    logger.log(LogStatus.INFO, "Successfully verified postAutoPay",attchedStepScreenShot("Successfully verified postAutoPay","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param pendingPayments
	 * @throws Exception
	 * @description Verify postAutoPay
	 */
	public void pendingPaymentsLink() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_PaymentHistory, "paymentHistory link"));
        reportData.add(scrollToView(appPages.web_page.lbl_pendingPayments, "lbl_pendingPayments Label"));
	    createReportTableEntry(reportData, "pendingPayments");
	    logger.log(LogStatus.INFO, "Successfully verified pendingPayments",attchedStepScreenShot("Successfully verified pendingPayments","Yes"));
	}
	
	/***
	 * @author Koyal
	 * @param pendingPaymentsZeroRecords
	 * @throws Exception
	 * @description Verify pendingPaymentsZeroRecords
	 */
	public void pendingPaymentsZeroRecords() throws Exception{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(scrollToView(appPages.web_page.tab_Payments,"payments Tab"));
        reportData.add(moveTo("xpath",appPages.web_page.tab_Payment));
        reportData.add(click(appPages.web_page.lnk_PaymentHistory, "paymentHistory link"));
        reportData.add(scrollToView(appPages.web_page.lbl_pendingPayments, "lbl_pendingPayments Label"));
        sleep(2000);
        reportData.add(verifyText(appPages.web_page.lbl_zeroRecords_Message, "If blank, you do not have any pending payments.","ZeroRecords Message"));
	    createReportTableEntry(reportData, "pendingPayments");
	    logger.log(LogStatus.INFO, "Successfully verified pendingPayments",attchedStepScreenShot("Successfully verified pendingPayments","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description MyAccount Summary
	 */
	public void myAccountSummary() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(isPresentAndDisplayed(appPages.web_page.img_MyAccount, "MyAccount Image"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.tab_Summary, "Summary Tab"));
		reportData.add(click(appPages.web_page.tab_Summary, "Summary Tab"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_AccountSummary, "AccountSummary Label"));

		createReportTableEntry(reportData, "myAccountSummary");
		logger.log(LogStatus.INFO, "Successfully Verified MyAccount Summary Screens",attchedStepScreenShot("Successfully Verified MyAccount Summary Screens","Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description MyAccount Detail
	 */
	public void myAccountDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(isPresentAndDisplayed(appPages.web_page.img_MyAccount, "MyAccount Image"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.tab_Details, "Details Tab"));
		reportData.add(click(appPages.web_page.tab_Details, "Details Tab"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_AccountDetails, "AccountDetails Label"));

		createReportTableEntry(reportData, "myAccountDetails");
		logger.log(LogStatus.INFO, "Successfully Verified MyAccount Details Screens",attchedStepScreenShot("Successfully Verified MyAccount Details Screens","Yes"));
	}
  
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description MyAccount Statement
	 */
	public void myAccountStatements() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(isPresentAndDisplayed(appPages.web_page.img_MyAccount, "MyAccount Image"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.tab_Statements, "Statements Tab"));
		reportData.add(click(appPages.web_page.tab_Statements, "Statements Tab"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_MyCurrentStatement, "MyCurrentStatement Label"));
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_MyPastStatements, "MyPastStatements Label"));

		createReportTableEntry(reportData, "myAccountStatements");
		logger.log(LogStatus.INFO, "Successfully Verified MyAccount Statements Screens",attchedStepScreenShot("Successfully Verified MyAccount Statements Screens","Yes"));
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Registration Process
	 */
	public void registrationByAccountNum(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		
		reportData.add(click(appPages.web_page.btn_CreateAnAccount, "CreateAnAccount Button"));
		sleep(7000);
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_AccountNumOrVin, "AccountNumOrVin Label"));
		reportData.add(type(appPages.web_page.txt_AccountNumOrVin,data.get("VAcct_Num") ,"AccountNumOrVin Textbox"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthMonth,data.get("VBirth_Month") ,"BirthMonth Dropdown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthDay,data.get("VBirth_Day") ,"BirthDay Dropdown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthYear,data.get("VBirth_Year") ,"BirthYear Dropdown"));
		reportData.add(type(appPages.web_page.txt_SSNDigit,data.get("VSSN_Num") ,"SSNDigit Textbox"));
		reportData.add(click(appPages.web_page.btn_Verify, "Verify Button"));
		sleep(3000);
		reportData.add(type(appPages.web_page.txt_UserNameForReg,data.get("VUserName") ,"UserName Textbox"));
		reportData.add(type(appPages.web_page.txt_PasswordForReg,data.get("Vpassword") ,"Password Textbox"));
		reportData.add(type(appPages.web_page.txt_ReEnterPassword,data.get("VConfirmPassword") ,"ReEnterPassword Textbox"));
		reportData.add(type(appPages.web_page.txt_EmailId,data.get("Vemail") ,"Email Textbox"));
		reportData.add(type(appPages.web_page.txt_ReEnterEmail,data.get("Vemail") ,"ReEnterEmail Textbox"));
		reportData.add(select(appPages.web_page.lst_SecurityQue,data.get("VSecurityQuestionId") ,"SecurityQue Dropdown"));
		reportData.add(type(appPages.web_page.txt_SecurityAns,data.get("VSecurityAnswer") ,"SecurityAns Textbox"));
		reportData.add(click(appPages.web_page.cb_TermsAndConditions,"TermAndConditions Checkbox"));
		reportData.add(click(appPages.web_page.btn_Submit,"submit Button"));
		sleep(3000);
		
		

		createReportTableEntry(reportData, "registrationByAccountNum");
		logger.log(LogStatus.INFO, "Successfully Registration Process By Account",attchedStepScreenShot("Successfully Registration Process By Account","Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Registration Process by VIN
	 */
	public void registrationByVIN(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		try{
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch(NoSuchElementException e){
			
		}
		reportData.add(click(appPages.web_page.btn_CreateAnAccount, "CreateAnAccount Button"));
		sleep(3000);
		reportData.add(isPresentAndDisplayed(appPages.web_page.lbl_AccountNumOrVin, "AccountNumOrVin Label"));
		reportData.add(type(appPages.web_page.txt_AccountNumOrVin,data.get("VVIN_Num") ,"AccountNumOrVin Textbox"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthMonth,data.get("VBirth_Month") ,"BirthMonth Dropdown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthDay,data.get("VBirth_Day") ,"BirthDay Dropdown"));
		reportData.add(actionSelect(appPages.web_page.lst_BirthYear,data.get("VBirth_Year") ,"BirthYear Dropdown"));
		reportData.add(type(appPages.web_page.txt_SSNDigit,data.get("VSSN_Num") ,"SSNDigit Textbox"));
		reportData.add(click(appPages.web_page.btn_Verify, "Verify Button"));
		sleep(3000);
		reportData.add(type(appPages.web_page.txt_UserNameForReg,data.get("VUserName") ,"UserName Textbox"));
		reportData.add(type(appPages.web_page.txt_PasswordForReg,data.get("Vpassword") ,"Password Textbox"));
		reportData.add(type(appPages.web_page.txt_ReEnterPassword,data.get("VConfirmPassword") ,"ReEnterPassword Textbox"));
		reportData.add(type(appPages.web_page.txt_EmailId,data.get("Vemail") ,"Email Textbox"));
		reportData.add(type(appPages.web_page.txt_ReEnterEmail,data.get("Vemail") ,"ReEnterEmail Textbox"));
		reportData.add(actionSelect(appPages.web_page.lst_SecurityQue,data.get("VSecurityQuestionId") ,"SecurityQue Dropdown"));
		reportData.add(type(appPages.web_page.txt_SecurityAns,data.get("VSecurityAnswer") ,"SecurityAns Textbox"));
		reportData.add(click(appPages.web_page.cb_TermsAndConditions,"TermAndConditions Checkbox"));
		reportData.add(click(appPages.web_page.btn_Submit,"submit Button"));
		sleep(3000);

		createReportTableEntry(reportData, "registrationByVIN");
		logger.log(LogStatus.INFO, "Successfully Verified Registration Process by VIN",attchedStepScreenShot("Successfully Verified Registration Process by VIN","Yes"));
	}
	
	/***
	 * @author Aravind
	 * @param data
	 * @throws Throwable
	 */
	public void editContractDetails(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		Actions action = new Actions(driver);
		action.moveToElement(appPages.web_page.lnk_MyAccount).perform();
		reportData.add(click(appPages.web_page.btn_MyProfile,"MyProfile Button"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Contact Details"),"XPATH", "Contact Details List Link"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit,"Contact Details"),"XPATH", "Edit Button"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "First Name"),"XPATH",true, data.get("FirstName"), "FirstName Textbox"));
		if(!(data.get("MiddleName").isEmpty()))
		{
			reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Middle"),"XPATH",true, data.get("MiddleName"), "MiddleName Textbox"));
		}
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Last Name"),"XPATH",true, data.get("LastName"), "LastName Textbox"));
		reportData.add(actionSelect(appPages.web_page.lst_Suffix, data.get("Suffix"), "Suffix Dropdown"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Cell"),"XPATH",true, data.get("Cell"), "Cell Textbox"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Home"),"XPATH", true, data.get("Home"), "HomePhone Textbox"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Email"),"XPATH",true, data.get("Email"), "Email Textbox"));
		//reportData.add(click(appPages.web_page.btn_SaveContractDetails, "ContractDetailsSave Button"));
		reportData.add(click(appPages.web_page.btn_Cancel_ChangeRequest, "CancelRequestCancel Button"));
		sleep(3000);
		createReportTableEntry(reportData, "editContractDetails");
		logger.log(LogStatus.INFO, "Successfully edited Contract Details");
	}
	
	public void editAddressDetails(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Addresses"),"XPATH", "Addresses List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Addresses"),"XPATH","Edit Button"));
		reportData.add(type(appPages.web_page.txt_Address,data.get("Street"),"Street TextBox"));
		reportData.add(type(appPages.web_page.txt_City,data.get("City"),"City TextBox"));
		reportData.add(actionSelect(appPages.web_page.lst_State, data.get("State"), "State DropDown"));
		reportData.add(type(appPages.web_page.txt_ZipCode,data.get("ZipCode"),"ZipCode TextBox"));
		reportData.add(click(appPages.web_page.cb_BillingAddress, "BillingAddress Checkbox"));
		//reportData.add(click(appPages.web_page.btn_SaveChangesAddress, "SaveAddress Button"));
		reportData.add(click(appPages.web_page.btn_Cancel_Address, "CancelAddress Button"));
		
		
		createReportTableEntry(reportData, "editAddressDetails");
		logger.log(LogStatus.INFO, "Successfully edited Address Details");
	}
	
	public void editUsername(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Username"),"XPATH", "Username List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Username"),"XPATH", "Edit Button"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Username"),"XPATH",true,data.get("EditUserName"), "UserName TextBox"));
		//reportData.add(click(appPages.web_page.btn_SaveUsernameChange, "UserNameSave Button"));
		reportData.add(click(appPages.web_page.btn_CancelUsernameChange, "UserNameSave Button"));
		
		createReportTableEntry(reportData, "editUsername");
		logger.log(LogStatus.INFO, "Successfully edited Username");
	}
	
	public void editPassword(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Password"),"XPATH",  "Password List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Password"),"XPATH", "Edit Button"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Current Password"),"XPATH",true,data.get("CurrentPassword"), "CurrentPassword TextBox"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "New Password"),"XPATH",true,data.get("NewPassword"), "NewPassword TextBox"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Confirm Password"),"XPATH",true,data.get("NewPassword"), "ConfirmPassword TextBox"));
		//reportData.add(click(appPages.web_page.btn_SavePassword, "SavePassword Button"));
		reportData.add(click(appPages.web_page.btn_CancelPassword, "CancelPassword Button"));
		
		createReportTableEntry(reportData, "editPassword");
		logger.log(LogStatus.INFO, "Successfully edited Password");
	}
	
	public void editSecurityQuestion(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Security Question"),"XPATH", "SecurityQuestion List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Security Question"),"XPATH", "Edit Button"));
		reportData.add(actionSelect(appPages.web_page.lst_SecurityQuestion, data.get("SecurityQuestion"), "SecurityQuestion Dropdown"));
		reportData.add(type(getStringWebElement(appPages.web_page.txt_TextEdit, "Security Answer"),"XPATH",true,data.get("SecurityAnswer"), "SecurityAnswer TextBox"));
		//reportData.add(click(appPages.web_page.btn_SaveSecurityQuestion, "SaveSecurityQusetion Button"));
		reportData.add(click(appPages.web_page.btn_CancelSecurityQuestion, "CancelSecurityQusetion Button"));
		createReportTableEntry(reportData, "editSecurityQuestion");
		logger.log(LogStatus.INFO, "Successfully edited Security Question");
	}
	
	public void editPaperlessStatement(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Paperless Statements"),"XPATH", "PaperlessStatements List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Paperless Statements"),"XPATH", "Edit Button"));
		if(data.get("PaperlessOption").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_Paperless, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_Paperless, "PaperlessStatement Checkbox"));
		}
		//reportData.add(click(appPages.web_page.btn_SavePaperless, "SavePaperlessOption Button"));
		reportData.add(click(appPages.web_page.btn_CancelPaperless, "CancelPaperlessOption Button"));
		createReportTableEntry(reportData, "editPaperlessStatement");
		logger.log(LogStatus.INFO, "Successfully edited Paperless Statement");
	}
	
	private boolean isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}
	
	public void editEmailAlerts(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Email Alerts"),"XPATH",  "EmailAlerts List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Email Alerts"),"XPATH", "Edit Button"));

		if(data.get("EmailAlert1").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_PayementProcessed, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_PayementProcessed, "PayementProcessed Checkbox"));
		}
		if(data.get("EmailAlert2").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_PayementDuedays, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_PayementDuedays, "PayementDuedays Checkbox"));
		}
		if(data.get("EmailAlert3").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_AccountPastDue, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_AccountPastDue, "AccountPastDue Checkbox"));
		}
		if(data.get("EmailAlert4").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_StatementAvailable, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_StatementAvailable, "StatementAvailable Checkbox"));
		}
		//reportData.add(click(appPages.web_page.btn_SaveEmailAlerts, " Button"));
		reportData.add(click(appPages.web_page.btn_CancelEmailAlerts, "CancelEmailAlert Button"));
		createReportTableEntry(reportData, "editEmailAlerts");
		
		logger.log(LogStatus.INFO, "Successfully edited Email Alerts");
	}
	
	public void editPreferences(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Preferences"),"XPATH",  "Preferences List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Preferences"),"XPATH",  "Edit Button"));
		if(data.get("Preference1").equalsIgnoreCase("on")&&!(isAttribtuePresent(appPages.web_page.cb_EmailOffers, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_EmailOffers, " Checkbox"));
		}
		if(data.get("Preference2").equalsIgnoreCase("off")&&(isAttribtuePresent(appPages.web_page.cb_MailOffers, "checked")))
		{
			reportData.add(click(appPages.web_page.cb_MailOffers, " Checkbox"));
		}
	   //reportData.add(click(appPages.web_page.btn_SavePreferences, "SavePreferences Button"));
	    reportData.add(click(appPages.web_page.btn_CancelPreferences, "CancelPreferences Button"));
		createReportTableEntry(reportData, "editPreferences");
		logger.log(LogStatus.INFO, "Successfully edited Preferences");
	}
	public void editWebAddressDetails(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		Actions action = new Actions(driver);
		action.moveToElement(appPages.web_page.lnk_MyAccount).perform();
		reportData.add(click(appPages.web_page.btn_MyProfile,"MyProfile Button"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Details, "Addresses"),"XPATH", "Addresses List"));
		reportData.add(click(getStringWebElement(appPages.web_page.lnk_Edit, "Addresses"),"XPATH","Edit Button"));
		reportData.add(type(appPages.web_page.txt_Address,true,data.get("Street"),"Street TextBox"));
		reportData.add(type(appPages.web_page.txt_City,true,data.get("City"),"City TextBox"));
		reportData.add(actionSelect(appPages.web_page.lst_State, data.get("State"), "State DropDown"));
		reportData.add(type(appPages.web_page.txt_ZipCode,true,data.get("ZipCode"),"ZipCode TextBox"));
		reportData.add(click(appPages.web_page.cb_BillingAddress, "BillingAddress Checkbox"));
		reportData.add(click(appPages.web_page.btn_SaveChangesAddress, "SaveAddress Button"));
		//reportData.add(click(appPages.web_page.btn_Cancel_Address, "CancelAddress Button"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_HomeAddress,"HomeAddress Table" ));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_BillingAddress,"BillingAddress Table" ));
		createReportTableEntry(reportData, "editAddressDetails");
		logger.log(LogStatus.INFO, "Successfully edited Address Details",attchedStepScreenShot("Successfully edited Address Details", "Yes"));
	}
}
