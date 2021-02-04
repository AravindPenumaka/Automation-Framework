package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Web extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	
	@Test
	public void Web_Login() throws Throwable{

		HashMap<String, String> happyPath = basePageData.fetchInputData("TestData","Login – Happy Path");
		HashMap<String, String> multipleAcconts = basePageData.fetchInputData("TestData","Login – Multiple Linked Accounts");
		HashMap<String, String> bankruptcyStausAccount = basePageData.fetchInputData("TestData","Login – Bankruptcy Status Account");
		HashMap<String, String> chargeOffAccount = basePageData.fetchInputData("TestData","Login – Charge Off Status Account");
		HashMap<String, String> multipleConditionAcconts = basePageData.fetchInputData("TestData","Login – Multiple Conditions Account");
		HashMap<String, String> forgotUserName = basePageData.fetchInputData("Forgot UserName","KMFRetail");
		HashMap<String, String> forgotPassword = basePageData.fetchInputData("Forgot Password","KMFRetail");

		appFunc.web_func.open_WebUrl();
		appFunc.web_func.fillWebLoginDetails(happyPath);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.fillWebLoginDetails(multipleAcconts);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.fillWebLoginDetails(bankruptcyStausAccount);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.fillWebLoginDetails(chargeOffAccount);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.fillWebLoginDetails(multipleConditionAcconts);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.fillWebLoginDetailsRememberMe(happyPath);
		appFunc.web_func.logOutHMF();
		appFunc.web_func.verifyLoginDetais(happyPath);
		appFunc.web_func.fillForgotUsername(forgotUserName);
		appFunc.web_func.fillForgotPassword(forgotPassword);

	}
	
	@Test
	public void Web_MyProfile() throws Throwable
	{
		HashMap<String, String> data = basePageData.fetchInputData("TestData","My Profile – Edit Contact Details");
		HashMap<String, String> ContractDetailsdata=basePageData.fetchInputData("MyProfile_EditContactDetails",getMethod());
		HashMap<String, String> AddressDetailsdata=basePageData.fetchInputData("MyProfile_EditAddresses",getMethod());
		HashMap<String, String> UsernameDetailsdata=basePageData.fetchInputData("MyProfile_EditUsername",getMethod());
		HashMap<String, String> PasswordDetailsdata=basePageData.fetchInputData("MyProfile_EditPassword",getMethod());
		HashMap<String, String> SecurityQuestionDetailsdata=basePageData.fetchInputData("MyProfile_EditSecurityQuestion",getMethod());
		HashMap<String, String> EmailAlertDetailsdata=basePageData.fetchInputData("MyProfile_EditEmailAlertOptions",getMethod());
		HashMap<String, String> PreferrencesDetailsdata=basePageData.fetchInputData("MyProfile_EditPreferences",getMethod());
		HashMap<String, String> PaperlessDetailsdata=basePageData.fetchInputData("MyProfile_EditPaperlessOptions",getMethod());
		appFunc.web_func.open_WebUrl();
		appFunc.web_func.fillWebLoginDetails(data);
		appFunc.web_func.editContractDetails(ContractDetailsdata);
		appFunc.web_func.editAddressDetails(AddressDetailsdata);
		appFunc.web_func.editUsername(UsernameDetailsdata);
		appFunc.web_func.editPassword(PasswordDetailsdata);
		appFunc.web_func.editSecurityQuestion(SecurityQuestionDetailsdata);
		appFunc.web_func.editPaperlessStatement(PaperlessDetailsdata);
		appFunc.web_func.editEmailAlerts(EmailAlertDetailsdata);
		appFunc.web_func.editPreferences(PreferrencesDetailsdata);
	}
	
	@Test
	public void Web_Payment() throws Throwable {
		HashMap<String, String> data = basePageData.fetchInputData("TestData", "PendingPayments – Link");
		HashMap<String, String> Payment_PostOnetimePayment_RMT = basePageData.fetchInputData("Payment_PostOnetimePayment_RMT", getMethod());
		appFunc.web_func.open_WebUrl();
		appFunc.web_func.fillWebLoginDetails(data);
		appFunc.web_func.paymentHistory();
		appFunc.web_func.getBuyoutQuote();
		appFunc.web_func.OneTimePayment(Payment_PostOnetimePayment_RMT);
		appFunc.web_func.postAutoPay();
		appFunc.web_func.pendingPaymentsLink();
		appFunc.web_func.pendingPaymentsZeroRecords();
	
	}
	
	@Test
	public void Web_MyAccount() throws Throwable{
      
		HashMap<String, String> data = basePageData.fetchInputData("TestData","Home Page – Navigation Icons");
		appFunc.web_func.open_WebUrl();
		appFunc.web_func.fillWebLoginDetails(data);
		appFunc.web_func.myAccountSummary();
		appFunc.web_func.myAccountDetails();
		appFunc.web_func.myAccountStatements(); 
  
	}
	
	@Test
	public void Web_Registeration() throws Throwable{
		appFunc.web_func.open_WebUrl();
		HashMap<String, String> data = basePageData.fetchInputData("New User Registration_Acct","KMF-Retail");
		HashMap<String, String> data3 = basePageData.fetchInputData("New User Registration_VIN","KMF-Retail");
	    appFunc.web_func.registrationByAccountNum(data);
		appFunc.web_func.registrationByVIN(data3);
		
	}
	
}
