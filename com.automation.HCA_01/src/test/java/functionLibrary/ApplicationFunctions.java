package functionLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ApplicationFunctions {
	
	public Login_Funcs login_func;
	public ChangeAccCond_Funcs chngAccCond_func;
	public SearchContract_Funcs srchCont_func;
	public CreditDispute_Funcs creditDispute_func;
	public HomeScreen_Funcs homeScreen_func;
	public SearchAccCond_Funcs searchAccCond_func;
	public GlobalEvents_Funcs globalEvents_func;
	public Actors_Funcs actors_func;
	public Task_Funcs task_func;
	public CustomerInfoChange_Funcs customerInfoChange_func;
	public Asset_Funcs asset_Func;
	public ApplicationSubmission_Funcs applicationSubmission_func;
	public Fraud_Funcs fraud_func;
	public LogOut_Funcs logout_func;
	public Contracts_Funcs contracts_func;
	public ChargeOff_Funcs chargeoff_func;
	public InvoiceCenterMgmt_Funcs invoiceCenterMgmt_func;
	public PayoffQuotation_Funcs payoffQuotation_func;
	public CollectionsAndDisbursements_Funcs collectionAndDisbursements_func;
	public CashFlow_Funcs cashFlow_func;
	public Legal_Funcs legal_func;
	public ServiceRequest_Funcs serviceRequest_func;
	public EOTBilling_Funcs EOTBilling_func;
	public Bankcruptcy_Funcs bankcruptcy_func;
	public Repossession_Funcs repossession_func;
	public PaymentReversals_Funcs paymentReversals_func;
	public Web_Funcs web_func;
	
	public ApplicationFunctions(WebDriver driver, ExtentTest logger) throws IOException
	{
		login_func = new Login_Funcs(driver, logger);
		srchCont_func = new SearchContract_Funcs(driver, logger);
		chngAccCond_func = new ChangeAccCond_Funcs(driver, logger);
		creditDispute_func = new CreditDispute_Funcs(driver,logger);
		homeScreen_func = new HomeScreen_Funcs(driver,logger);
		searchAccCond_func = new SearchAccCond_Funcs(driver, logger);
		globalEvents_func=new GlobalEvents_Funcs(driver, logger);
		actors_func = new Actors_Funcs(driver, logger);
		task_func = new Task_Funcs(driver, logger);
		customerInfoChange_func = new CustomerInfoChange_Funcs(driver, logger);
		asset_Func = new Asset_Funcs(driver, logger);
		applicationSubmission_func = new ApplicationSubmission_Funcs(driver, logger);
		fraud_func = new Fraud_Funcs(driver, logger);
		logout_func = new LogOut_Funcs(driver, logger);
		contracts_func = new Contracts_Funcs(driver, logger);
		chargeoff_func = new ChargeOff_Funcs(driver, logger);
		invoiceCenterMgmt_func = new InvoiceCenterMgmt_Funcs(driver, logger);
		payoffQuotation_func = new PayoffQuotation_Funcs(driver, logger);
		collectionAndDisbursements_func =  new CollectionsAndDisbursements_Funcs(driver, logger);
		cashFlow_func =  new CashFlow_Funcs(driver, logger);
		legal_func =  new Legal_Funcs(driver, logger);
		serviceRequest_func =  new ServiceRequest_Funcs(driver, logger);
		EOTBilling_func = new EOTBilling_Funcs(driver, logger);
		bankcruptcy_func = new Bankcruptcy_Funcs(driver, logger);
		repossession_func = new Repossession_Funcs(driver, logger);
		paymentReversals_func = new PaymentReversals_Funcs(driver, logger);
		web_func = new Web_Funcs(driver, logger);
	}


}
