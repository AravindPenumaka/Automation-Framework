package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CashFlow_PageObject {
	
	@FindBy(xpath = "//img[@title='Create Waterfall Payments']")
	public WebElement btn_CreateWaterfallPayment;
	
	@FindBy(xpath = "//label[text()='Payment method']/../../td[2]//select")
	public WebElement lst_PaymentMethod;
	
	@FindBy(xpath = "(//label[text()='Contract code']/../../td[2]//input)")
	public WebElement txt_ContractCode;
	
	@FindBy(xpath = "//label[text()='Total Amount to Pay']/../../td//input")
	public WebElement txt_TotalAmountToPay;
	
	@FindBy(xpath = "//label[text()='Amount']/../../td//input")
	public WebElement txt_Amount;
	
	@FindBy(xpath = "//img[@title='Expand Allocation']")
	public WebElement btn_ExpandAllocation;
	
	@FindBy(xpath = "//label[text()='Suspense Amount']")
	public WebElement lbl_SuspenseAmount;
	
	@FindBy(xpath = "//label[text()='Suspense Amount']/../../td/input")
	public WebElement txt_SuspenseAmount;
	
	@FindBy(xpath = "//input[@id='secId:fmlistmanpng34:s_x4_aam:innerTbl:actcode::content']")
	public WebElement txt_ActorCode;
	
	@FindBy(xpath = "//input[@id='secId:fmlistmanpng34:s_x4_aam:innerTbl:3:regselected::content']")
	public WebElement cb_CashFlowDetails;
	
	@FindBy(xpath = "//span[text()='Reject collection']")
	public WebElement lnk_RejectCollection;
	
	@FindBy(xpath = "//label[text()='Rejection reason']")
	public WebElement lbl_RejectionReason;
	
	@FindBy(xpath = "//select[@id='s_wo_aav::content']"/*xpath = "//label[text()='Rejection reason']/../../td[2]/select"*/)
	public WebElement lst_RejectionReason;
	
	public String lst_RejectionReasonList = "//label[text()='Rejection reason']/../../td[2]/select/option[text()='%s']";
	
	@FindBy(id="secId:fmlistmanpng34:s_x4_aam:innerTbl:reference::content")
	public WebElement txt_ReferenceCode;
	
	@FindBy(xpath = "(//tr[1]//td//input[@type='checkbox'])[1]" )
	public WebElement cb_CashFlowRow;
	
	@FindBy(xpath = "//label[text()='Payment date To']/../../td[2]/input" )
	public WebElement txt_PaymentDateTo;
	
	@FindBy(xpath = "//label[text()='Payment allocation Values']/../../td[2]/table" )
	public WebElement txt_PaymentAllocationvalue;
	
	@FindBy(xpath = "//label[text()='Comments']/../../td[2]/input" )
	public WebElement txt_Comments;
	
	@FindBy(xpath = "//label[text()='Contract']/../../td[2]//input" )
	public WebElement txt_ContractNumber;
	
	@FindBy(xpath = "//div[@id='s_xb_aal:tbTableToolbar:find']//a//img[@title='Search']" )
	public WebElement btn_Search;
	
	@FindBy(xpath = "//input[@id='s_xb_aal:innerTbl:0:inclure::content']" )
	public WebElement cb_UnallocatedEntry;
	
	@FindBy(xpath = "//div[@id='s_xb_aak']" )
	public WebElement vfy_UnallocatedEntry;
	
	public String txt_UnallocatedEntryDetail = "//div[@id='s_xb_aak']//label[text()='%s']/../../td[2]//input";
	public String lbl_UnallocatedEntryDetail = "//div[@id='s_xb_aak']//label[text()='%s']/../../td[2]//select";
	
	@FindBy(xpath = "(//div[@id='s_xb_aak']//label[text()='Name']/../../td[2]//input)[2]" )
	public WebElement txt_Name;
	
	@FindBy(xpath = "//label[text()='Company']/../../td[2]/select" )
	public WebElement lst_Company;
	
	@FindBy(xpath = "//div[@id='s_bd7_aaa']" )
	public WebElement vfy_SummaryPage;
	
	@FindBy(xpath = "//label[text()='Contract']/../../td[2]//tr//input" )
	public WebElement txt_Contract;
	
	@FindBy(xpath="//div[@id='secId:fmlistmanpng34:s_x4_aam:innerTbl::db']")
	public WebElement vfy_CashFlowTable;
}
