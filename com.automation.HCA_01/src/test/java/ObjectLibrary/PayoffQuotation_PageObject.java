package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayoffQuotation_PageObject {
	
	@FindBy(xpath="//a[text()='Contracts']")
	public WebElement lst_Contracts;
	
	@FindBy(xpath="//table[@id='modulesMenu:s_tu_abl::ScrollContent']//tr[@id='modulesMenu:s_tu_abo']/td[text()='Global Events']")
	public WebElement lnk_GlobalEvents;
	
	@FindBy(xpath="//div[@id='secId:s_bd8_aam']//div[@id='secId:s_bd8_aam:_otrWpr::t']//table[@class='xmf']//div[@id='secId:s_bd8_aam:tbTableToolbar:new']")
	public WebElement btn_NewEventList;
	
	@FindBy(id="tabGeneralitiesEvtGlobCmbEvtGlob:s_bd6_aaf::content")
	public WebElement lst_EventtoRun;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_GeneralInformationNext;
	
	@FindBy(xpath="//input[@id='tf_j_id_id24pc8::content']")
	public WebElement txt_ContractNo;
	
	@FindBy(xpath="//img[@id='bSr_j_id_id24pc8::icon']")
	public WebElement btn_SearchContract;
	
	@FindBy(xpath="//img[@id='srchDlg:s_be8_aaj:tbTableToolbar:find::icon']")
	public WebElement btn_FindContractDeatails;
	
	@FindBy(xpath="//button[@id='srchDlg:s_be8_aal']")
	public WebElement btn_ValidateContract;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_SearchCriteriaNext;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_ContractsListNext;
	
	@FindBy(xpath="//input[@id='j_id_id2pc8::content']")
	public WebElement txt_Date;
	
	@FindBy(xpath="//select[@name='j_id_id3pc8']")
	public WebElement lst_Buyer;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_SettingsNext;
	//modified on 6/24/2019
	
	//@FindBy(xpath="//label[text()='Outstanding Monthly Amount']/../../td[2]/input")
	//public WebElement txt_MonthlyPayment;
	
	@FindBy(xpath="(//span[text()='Outstanding Monthly Amount']/../../../..//td[4]//span/span)[1]")
	public WebElement txt_MonthlyPayment;
	
	//modified on 6/24/2019
	//@FindBy(xpath="//label[text()='Unpaid Monthly Payment']/../../td[2]/input")
	//public WebElement txt_UnpaidMonthlyPayments;
	
	@FindBy(xpath="(//span[text()='Unpaid Monthly Payment']/../../../..//td[4]//span/span)[1]")
	public WebElement txt_UnpaidMonthlyPayments;
	
	@FindBy(xpath="//div[@id='j_id_id3pc8:innerTbl::db']//table//td[4]//span/span")
	public WebElement txt_UnapidFee;
	
	@FindBy(xpath="//label[contains(text(),'Unpaid Sales tax')]/../../td[2]/input")
	public WebElement txt_UnpaidSaleTax;
	
	@FindBy(xpath="//label[contains(text(),'Unpaid Property tax')]/../../td[2]/input")
	public WebElement txt_UnpaidPropertytTax;
	
	//Modified on 6/24/2019
	//@FindBy(xpath="//label[text()='Total Summation Amount']/../../td[2]/input")
	//public WebElement txt_TotalAmount;
	
	@FindBy(xpath="//span[@id='j_id_id4pc8:innerTbl:0:total::content']")
	public WebElement txt_TotalAmount;
	
	
	@FindBy(xpath="//label[text()='Error(s)']/../../td[2]/input")
	public WebElement txt_Error;
	
	@FindBy(xpath="//div[text()='Error']/../../../../../../div[2]//td[3]//span/span")
	public WebElement txt_ErrorMsg;
	//modified on 6/24/2019
	//@FindBy(xpath="//label[text()='Outstanding Principal']/../../td[2]/input")
	//public WebElement txt_OutStandingPrinciple;
	
	@FindBy(xpath="(//span[text()='Outstanding Principal']/../../../..//td[4]//span/span)[1]")
	public WebElement txt_OutStandingPrinciple;
	//modified on 6/24/2019
	//@FindBy(xpath="//label[text()='Accured interest']/../../td[2]/input")
	//public WebElement txt_AccuredInterest;
	
	@FindBy(xpath="//span[text()='Accured Interest']/../../../..//td[2]//span/span")
	public WebElement txt_AccuredInterest;
	
	//modified on 6/24/2019
	//@FindBy(xpath="//label[text()='Purchase option fee']/../../td[2]/input")
	//public WebElement txt_PurchaseOptionFee;
	
	@FindBy(xpath="//span[text()='Purchase Option Fee']/../../../..//td[2]//span/span")
	public WebElement txt_PurchaseOptionFee;
	
	@FindBy(xpath="//label[text()='Suspense amount']/../../td[2]/input")
	public WebElement txt_SuspenseAmount;
	
	//Modified on 7/1/2019
	@FindBy(xpath ="//label[text()='Good Thru Date']/../../td[2]//input")
	public WebElement vfy_GoodThroughDays; 
	
}
