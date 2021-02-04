package ObjectLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPages {
	
	public Login_PageObject login_page;
	public AccCondChange_PageObject accCondChange_page;
	public Contract_PageObject contract_page;
	public CreditDispute_PageObject creditDispute_page;
	public HomeScreen_PageObject homeScreen_page;
	public Frame_PageObject frame_page;
	public SearchAccCond_PageObject searchAccCond_page;
	public GlobalEvents_PageObject globalEvent_page;
	public Actors_PageObject actors_page;
	public Task_PageObject task_page;
	public CustomerInfoChange_PageObject customerInfoChange_page;
	public Asset_PageObject asset_page;
	public ApplicationSubmission_PageObject appSubmission_page;
	public Fraud_PageObject fraud_page;
	public CommonScreen_PageObject commonSrn_page;
	public CollectionsAndDisbursements_PageObject collectionsAndDisbursements_page;
	public ChargeOff_PageObject chargeoff_page;
	public InvoiceCenterMgmt_PageObject invoiceCenterMgmt_page;
	public PayoffQuotation_PageObject payoffQuotation_page;
	public CashFlow_PageObject cashFlow_page;
	public ServiceRequest_PageObject serviceRequest_page;
	public Legal_PageObject legal_page;
	public EOTBilling_PageObject EOTBilling_page;
	public Bankruptcy_PageObject bankruptcy_page;
	public Repossession_PageObject repossession_page;
	public Receivables_PageObject receivables_page;
	public Web_PageObject web_page;
	
	public ApplicationPages(WebDriver driver) throws IOException
	{
		login_page = PageFactory.initElements(driver, Login_PageObject.class);
		accCondChange_page = PageFactory.initElements(driver, AccCondChange_PageObject.class);
		contract_page = PageFactory.initElements(driver, Contract_PageObject.class);
		creditDispute_page = PageFactory.initElements(driver, CreditDispute_PageObject.class);
		homeScreen_page = PageFactory.initElements(driver, HomeScreen_PageObject.class);
		frame_page = PageFactory.initElements(driver, Frame_PageObject.class);
		searchAccCond_page = PageFactory.initElements(driver, SearchAccCond_PageObject.class);
		globalEvent_page = PageFactory.initElements(driver, GlobalEvents_PageObject.class);
		actors_page = PageFactory.initElements(driver, Actors_PageObject.class);
		task_page = PageFactory.initElements(driver, Task_PageObject.class);
		customerInfoChange_page = PageFactory.initElements(driver, CustomerInfoChange_PageObject.class);
		asset_page = PageFactory.initElements(driver, Asset_PageObject.class);		
		appSubmission_page = PageFactory.initElements(driver, ApplicationSubmission_PageObject.class);		
		fraud_page = PageFactory.initElements(driver, Fraud_PageObject.class);		
		commonSrn_page = PageFactory.initElements(driver, CommonScreen_PageObject.class);	
		collectionsAndDisbursements_page = PageFactory.initElements(driver, CollectionsAndDisbursements_PageObject.class);
		chargeoff_page = PageFactory.initElements(driver, ChargeOff_PageObject.class);
		invoiceCenterMgmt_page = PageFactory.initElements(driver, InvoiceCenterMgmt_PageObject.class);
		payoffQuotation_page = PageFactory.initElements(driver, PayoffQuotation_PageObject.class);
		cashFlow_page = PageFactory.initElements(driver, CashFlow_PageObject.class);
		serviceRequest_page = PageFactory.initElements(driver, ServiceRequest_PageObject.class);
		legal_page = PageFactory.initElements(driver, Legal_PageObject.class);
		EOTBilling_page = PageFactory.initElements(driver, EOTBilling_PageObject.class);
		bankruptcy_page = PageFactory.initElements(driver, Bankruptcy_PageObject.class);
		repossession_page = PageFactory.initElements(driver, Repossession_PageObject.class);
		receivables_page = PageFactory.initElements(driver, Receivables_PageObject.class);
		web_page = PageFactory.initElements(driver, Web_PageObject.class);
	}
	

}
