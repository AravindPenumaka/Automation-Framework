package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Web_PageObject {
		
	@FindBy(xpath = "//div[@class='cfno' and  contains(@onclick,'CancelSurvey')]")
	public WebElement btn_NoThanks;
	
	@FindBy(xpath = "//div[@id='confirmit_invitecontainer' and not (contains(@style,'display: none;'))]")
	public WebElement vfy_FeedbackPopUp;
	
	@FindBy(id = "Username")
	public WebElement txt_UserName;
	
	@FindBy(id = "Password")
	public WebElement txt_Password;
	
	@FindBy(id = "btnLogin")
	public WebElement btn_LogIn;
	
	@FindBy(xpath = "//div[@class='log-on']")
	public WebElement vfy_LogOnScreen;
	
	@FindBy(xpath = "//a[text()='Log Out']" )
	public WebElement btn_LogOut;
	
	@FindBy(id = "RememberMe" )
	public WebElement cb_RememberMe;
	
	@FindBy(xpath = "//a[text()='Username']" )
	public WebElement lnk_ForgotUserName;
	
	@FindBy(xpath = "//div[@class='content-mod']" )
	public WebElement vfy_ForgotUserNameScreen;
	//modified on 7/1/2019
	@FindBy(id = "email" )
	public WebElement txt_Email;
	
	@FindBy(id = "txtEmail" )
	public WebElement txt_EmailId;
	
	@FindBy(xpath = "//select[@name='birthMonth']" )
	public WebElement lst_BirthMonth;
	
	@FindBy(xpath = "//select[@name='birthDay']" )
	public WebElement lst_BirthDay;
	
	@FindBy(xpath = "//select[@name='birthYear']" )
	public WebElement lst_BirthYear;
	
	@FindBy(id = "lastFourDigitSSN" )
	public WebElement txt_LastFourDigitOfSSN;
	
	@FindBy(xpath = "//input[@title='Next']" )
	public WebElement btn_Next;
	
	@FindBy(id = "securityAnswer" )
	public WebElement txt_SecurityAnswer;
	
	@FindBy(xpath = "//td[@class='right-fgt-pass']/label" )
	public WebElement txt_NewUserName;
	
	@FindBy(xpath = "//a[text()='Password?']" )
	public WebElement lnk_ForgotPassword;
	
	@FindBy(id = "username" )
	public WebElement txt_ForgotPasswordUserName;
	
	@FindBy(id = "newPassword" )
	public WebElement txt_NewPassword;
	
	@FindBy(id = "confirmPassword" )
	public WebElement txt_ConfimPassword;
	
	@FindBy(xpath = "//div[text()='PAYMENTS']/..")
	public WebElement tab_Payments;
	
	@FindBy(xpath = "//a[text()='PAYMENT HISTORY']")
	public WebElement lnk_PaymentHistory;
	
	@FindBy(xpath = "//div[text()='Payment History']")
	public WebElement lbl_PaymentHistory;
	
	public String tab_Payment="//div[text()='PAYMENTS']/..";
	
	@FindBy(xpath = "//a[text()='GET A BUYOUT QUOTE']")
	public WebElement lnk_getBuyoutQuote;
	
	@FindBy(xpath = "//h3[contains(text(),'Request a Payoff Quote')]")
	public WebElement lbl_requestPayoffQuote;
	
	@FindBy(xpath = "//a[text()='MAKE A PAYMENT']")
	public WebElement lnk_makeAPayment;
	
	@FindBy(xpath = "//div[contains(text(),' Make a One-Time Payment')]")
	public WebElement lbl_makeOTP;
	
	@FindBy(xpath = "//a[text()='PAY YOUR BILL']")
	public WebElement btn_payYourBill;
	
	@FindBy(xpath = "//div[contains(text(),' Sign Up for AutoPay')]")
	public WebElement lbl_signUpForAutoPay;
	
	@FindBy(xpath = "//a[contains(@title,'SET UP')]")
	public WebElement btn_setUp;
	
	@FindBy(xpath = "//a[text()='SET UP AUTOPAY']")
	public WebElement lnk_setUpAutoPay;
	
	@FindBy(xpath = "//div[contains(text(),'Pending Payments')]")
	public WebElement lbl_pendingPayments;
	
	@FindBy(xpath = "//input[@id='BankHolder_FirstNameHolder']")
	public WebElement txt_firstName;
	
	@FindBy(xpath = "//input[@id='BankHolder_LastNameHolder']")
	public WebElement txt_lastName;
	
	@FindBy(xpath = "//input[@id='BankHolder_StreetAddressOrPOBox']")
	public WebElement txt_street;
	
	@FindBy(xpath = "//input[@id='BankHolder_City']")
	public WebElement txt_city;
	
	@FindBy(xpath = "//select[@id='BankHolder_State']")
	public WebElement lst_state;
	
	@FindBy(xpath = "//input[@id='BankHolder_ZipCode']")
	public WebElement txt_zipCode;
	
	@FindBy(xpath = "//input[@id='BankHolder_EmailAddress']")
	public WebElement txt_emailAddress;
	
	@FindBy(xpath = "//select[@id='BankAccount_BankAccountType']")
	public WebElement lst_bankAccountType;
	
	@FindBy(xpath = "//input[@id='RoutingNumberField']")
	public WebElement txt_routingNumber;
	
	@FindBy(xpath = "//input[@id='AccountNumberField']")
	public WebElement txt_accountNumber;
	
	@FindBy(xpath = "//input[@id='AccountNumberField']")
	public WebElement cb_saveAccountInfoForFuturePayment;
	
	@FindBy(xpath = "//input[@id='chkAgreeToPayConvenienceFee']")
	public WebElement cb_agreeToTermsAndCondition;
	
	@FindBy(xpath = "//input[@value='Next']")
	public WebElement btn_next;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	public WebElement btn_cancel;
	
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement btn_submit;
	
	@FindBy(xpath = "//div[@id='divPaymentProgressBar']/../div[2]")
	public WebElement lbl_ReviewPage;
	
	@FindBy(xpath = "//p[contains(text(),'blank')]")
	public WebElement lbl_zeroRecords_Message;
	
	@FindBy(xpath = "//input[@value='CANCEL']")
	public WebElement btn_popupcancel;
	
	@FindBy(xpath = "//div[text()='My Account']/..")
	public WebElement img_MyAccount;
	
	@FindBy(xpath = "//div[@id='my-account']")
	public WebElement lbl_MyAccount;
	
	@FindBy(xpath = "//span[text()='Summary']/..")
	public WebElement tab_Summary;
	
	@FindBy(xpath = "//span[text()='Details']/..")
	public WebElement tab_Details;
	
	@FindBy(xpath = "//span[text()='Statements']/..")
	public WebElement tab_Statements;
	
	@FindBy(xpath = "//div[@id='tabs-1']//label[text()='Vehicle Description']")
	public WebElement lbl_VehicleDescription;
	
	@FindBy(xpath = "//div[@class='wrapper-my-account-summary']//h3")
	public WebElement lbl_AccountSummary;
	
	@FindBy(xpath = "//div[@class='wrapper-my-account-details']//h3")
	public WebElement lbl_AccountDetails;
	
	@FindBy(xpath = "//h3[contains(text(),'My Current Statement')]")
	public WebElement lbl_MyCurrentStatement;
	
	@FindBy(xpath = "//h3[contains(text(),'My Past Statements')]")
	public WebElement lbl_MyPastStatements;
	//modified on 7/1/2019
	@FindBy(xpath = "//a[text()='Create an Account']")
	public WebElement btn_CreateAnAccount;
	
	@FindBy(xpath = "//div[text()='ACCOUNT NUMBER OR VIN']")
	public WebElement lbl_AccountNumOrVin;
	
	@FindBy(xpath = "//div[@id='account-number-container']//input")
	public WebElement txt_AccountNumOrVin;
	
	@FindBy(xpath = "//input[@data-val-required='Enter last 4 digits of SSN.']")
	public WebElement txt_SSNDigit;
	
	@FindBy(xpath = "//input[@value='Verify']")
	public WebElement btn_Verify;
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement txt_UserNameForReg;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement txt_PasswordForReg;
	
	@FindBy(xpath = "//input[@name='confirmPassword']")
	public WebElement txt_ReEnterPassword;
	
	@FindBy(xpath = "//input[@name='confirmEmailAddress']")
	public WebElement txt_ReEnterEmail;
	
	@FindBy(xpath = "//select[@name='securityQuestionId']")
	public WebElement lst_SecurityQue;
	
	@FindBy(xpath = "//input[@name='securityAnswer']")
	public WebElement txt_SecurityAns;
	
	@FindBy(xpath = "//input[@id='TermsConditionsId']")
	public WebElement cb_TermsAndConditions;
	
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement btn_Submit;
	
	
	public String lnk_Details="//a[text()='%s']/../span";
	public String lnk_Edit="//a[text()='%s']/../../div//div//a[contains(text(),'EDIT')]";
	public String txt_TextEdit="//label[text()='%s']/../../../div[2]//div/input";
	
	@FindBy(xpath="(//a[text()='Addresses']/../../div[@id='addressInfoSectionDetail']//div[@class='row-item editMode-addressinfo Address']//input)[1]")
	public WebElement txt_Address;
	
	@FindBy(xpath="(//a[text()='Addresses']/../../div[@id='addressInfoSectionDetail']//div[@class='row-item editMode-addressinfo Address']//input)[2]")
	public WebElement txt_City;
	
	@FindBy(xpath="(//a[text()='Addresses']/../../div[@id='addressInfoSectionDetail']//div[@class='row-item editMode-addressinfo Address']//input)[3]")
	public WebElement txt_ZipCode;
	
	@FindBy(xpath="//div[text()='My Account']")
	public WebElement lnk_MyAccount;
	
	@FindBy(xpath="//div[text()='My Account']/../../div//a[text()='MY PROFILE']")
	public WebElement btn_MyProfile;
	
	@FindBy(xpath="//div[@id='accountInfoSectionDetail']//label[text()='Suffix']/../../../div[2]//div/select")
	public WebElement lst_Suffix;
	
	@FindBy(xpath="(//a[text()='Addresses']/../../div[@id='addressInfoSectionDetail']//div[@class='row-item editMode-addressinfo Address']//select)[1]")
	public WebElement lst_State;
	
	@FindBy(xpath="//input[@id='billibgCheckbox']")
	public WebElement cb_BillingAddress;
	
	@FindBy(xpath="//div[@id='accountInfoSectionDetail']//div//button")
	public WebElement btn_SaveContractDetails;
	
	@FindBy(xpath="//div[@id='addressInfoSectionDetail']//div//button")
	public WebElement btn_SaveChangesAddress;
	
	@FindBy(xpath="//div[@id='userNameSectionDetail']//div//button")
	public WebElement btn_SaveUsernameChange;
	
	@FindBy(xpath="//div[@id='passwordSectionDetail']//div//button")
	public WebElement btn_SavePassword;
	
	@FindBy(xpath="//div[@id='securityQuestionSectionDetail']//div//button")
	public WebElement btn_SaveSecurityQuestion;
	
	@FindBy(xpath="//div[@id='paperlessSectionDetail']//div//button")
	public WebElement btn_SavePaperless;
	
	@FindBy(xpath="//div[@id='emailAlertsSectionDetail']//div//button")
	public WebElement btn_SaveEmailAlerts;
	
	@FindBy(xpath="//div[@id='marketingPreferencesSectionDetail']//div//button")
	public WebElement btn_SavePreferences;
	
	@FindBy(xpath="//label[text()='Security Question']/../../../div[2]//div/select")
	public WebElement lst_SecurityQuestion;
	
	@FindBy(xpath="//input[@id='editPaperlessSection_confirm']")
	public WebElement cb_Paperless;
	
	@FindBy(xpath="((//label[contains(text(),'My Payment Is Processed')])[2]/../../input)[1]")
	public WebElement cb_PayementProcessed;
	
	@FindBy(xpath="((//label[contains(text(),'My Payment Is Due In 10 Days')])[2]/../../input)[1]")
	public WebElement cb_PayementDuedays;
	
	@FindBy(xpath="((//label[contains(text(),'My Account Is Past Due')])[2]/../../input)[1]")
	public WebElement cb_AccountPastDue;
	
	@FindBy(xpath="((//label[contains(text(),'My Statement Is Available To View Online')])[2]/../../input)[1]")
	public WebElement cb_StatementAvailable;
	
	@FindBy(xpath="//input[@id='marketingPreferencesSection_sendMeEmail']")
	public WebElement cb_EmailOffers;
	
	@FindBy(xpath="//input[@id='marketingPreferencesSection_sendMeDirectEmail']")
	public WebElement cb_MailOffers;
	
	public String tab_MyAccount="//div[text()='My Account']/..";
	
	@FindBy(xpath="//div[@id='accountInfoSectionDetail']//div//button/../a")
	public WebElement btn_Cancel_ChangeRequest;
	
	@FindBy(xpath="//div[@id='addressInfoSectionDetail']//div//a")
	public WebElement btn_Cancel_Address;
	
	@FindBy(xpath="//div[@id='userNameSectionDetail']//div//a")
	public WebElement btn_CancelUsernameChange;
	
	@FindBy(xpath="//div[@id='passwordSectionDetail']//div//a")
	public WebElement btn_CancelPassword;
	
	@FindBy(xpath="//div[@id='securityQuestionSectionDetail']//div//a")
	public WebElement btn_CancelSecurityQuestion;
	
	@FindBy(xpath="//div[@id='paperlessSectionDetail']//div//button/../a")
	public WebElement btn_CancelPaperless;
	
	@FindBy(xpath="//div[@id='emailAlertsSectionDetail']//div//button/../a")
	public WebElement btn_CancelEmailAlerts;
	
	@FindBy(xpath="//div[@id='marketingPreferencesSectionDetail']//div//a")
	public WebElement btn_CancelPreferences;
	
	@FindBy(xpath="//div[@class='t-section home-address']")
	public WebElement vfy_HomeAddress;
	
	@FindBy(xpath="//div[@class='t-section billing-address']")
	public WebElement vfy_BillingAddress;
}
	        
	