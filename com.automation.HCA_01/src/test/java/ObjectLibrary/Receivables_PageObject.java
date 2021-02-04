package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Receivables_PageObject {

	
	
	public String  lnk_Reversals="//a[text()='%s']";
	
	@FindBy(xpath="//span[text()='Generate credit note']/..")
	public WebElement  lnk_GenerateCreditNote;
	
	@FindBy(xpath="//span[text()='Reject collection']/..")
	public WebElement  lnk_RejectCollections;
	
	
	@FindBy(xpath="//div[@title='Search']//a//img[@id='secId:frmFactLstTblSV:s_q2_aao:tbTableToolbar:find::icon'] | //div[@title='Search']//a//img[@id='secId:fmlistmanpng34:s_x4_aam:tbTableToolbar:find::icon']")
	public WebElement  btn_LinkSearch;

	
	@FindBy(xpath="//label[text()='Rejection reason']/../..//td[2]//select")
	public WebElement  lst_RejectionReason;
	
	
	//modified 23 july
	//public String  cb_Rejection="//a[text()='%s']/../../../td[16]//nobr//img";
	
	
	
	public String  vfy_TableData="//a[text()='%s']/../../..//td[%s]//span//span";
	public String  vfy_ColumnCount="//a[text()='%s']/../../..//td";
	
	
	
	
	public   String vfy_RowCount="//div[text()='Rej.']/../../../../../../div[2]//table//tbody//tr";
	
	@FindBy(xpath="//label[text()='Review']/../..//td[2]//span//span//input")
	public   WebElement cb_Review;
	//modified 23 july
	//public String  vfy_RequiredLink="//div[@id='secId:fmlistmanpng34:s_x4_aam:innerTbl::db']//table[@class='xza x102']//tbody//tr[@_afrrk='%s']//td[3]//a";
	//modified 23 july
	//public String  vfy_RejectionData="//div[text()='Rej.']//../../../../../../../div[2]//table//tbody//tr[@_afrrk='%s']//td[16]//nobr//span//span//span//img";
	
	@FindBy(xpath="//label[text()='Contract']/../..//td[2]//table//span//input")
	public WebElement  txt_Contracts;
	
	@FindBy(xpath="//label[text()='Name']/../..//td[2]/input")
	public WebElement  txt_Name;
	
	@FindBy(xpath="//label[text()='Item #']/../..//td[2]/input")
	public WebElement  txt_Item;
	
	@FindBy(xpath="//label[text()='Payment reference']/../..//td[2]/input")
	public WebElement  txt_PaymentReference;
	
	@FindBy(xpath="//label[text()='Amount']/../..//td[2]/input")
	public WebElement  txt_Amount;
	
	@FindBy(xpath="//label[text()='Actor code']/../../td[2]//table//span//input")
	public WebElement  txt_ActorCode;
	
	@FindBy(xpath="//label[@for='s_wo_aam::content']//../..//td[2]//input")
	public WebElement  txt_PaymentDate;
	
	@FindBy(xpath="//img[@id='secId:s_xp_aan:tbTableToolbar:find::icon']")
	public WebElement  btn_MiscSearch;
	
	public String  vfy_SuspenceFee="//div[@id='secId:s_xp_aan:innerTbl::db']//table//tr//span[text()='%s']/../../../..";
	//added 5/30/2019

	@FindBy(xpath="//select[@id='s_qf_aal::content']")
	public WebElement  lst_GeneralCreditNoteReason;

	//modified under
	public String  vfy_getLink="(//span[text()='%s'])[%s]/../../../..//td[21]//img[@title='Unchecked']/../../../../../..//td[2]//a";
	public String  vfy_GeneralCreditNoteLink="(//span[text()='%s'])[%s]/../../../..//td[21]//img";
	public String vfy_RowCountForCreditNote="(//span[text()='%s'])";
	public String  vfy_RequiredLinkForCreditNote="//a[text()='%s']";

	//added 23 july


	@FindBy(xpath="//input[@id='secId:frmFactLstTblSV:s_q2_aao:innerTbl:facnum::content']")
	public WebElement  txt_Number;


	@FindBy(xpath="//div[text()='Process allocation']")
	public WebElement  tbl_processAllocation;

	@FindBy(xpath="//div[text()='Unpaid Amt.']")
	public WebElement  tbl_unpaidAmt;

	public String lnk_ReceivableTax="(//span[text()='%s'])[%s]/../../../..//td[2]//a";
	
	public String  cb_Rejection="//a[text()='%s']/../../../td[16]//img";

	public String  vfy_LinkAmount="//table//tbody//tr[@_afrrk='%s']//td[7]//span/span";

	public String  vfy_RejectionData="//div[text()='Rej.']//../../../../../../../div[2]//table//tbody//tr[@_afrrk='%s']//td[16]//nobr//span//img";

	public String  vfy_Amount="(//div[@id='secId:s_xp_aan:innerTbl::db']//table//tr//span[text()='%s']/../../../..//td[8]//span//span)[%s]";

	@FindBy(xpath="//a[text()='Unallocated entries']")
	public WebElement tab_UnallocatedEnries;
	
	@FindBy(xpath="//label[text()='Contract code']/../../td[2]//input")
	public WebElement txt_ContractCode;
	
	@FindBy(xpath="//label[text()='Contract code']/../../td[2]//a")
	public WebElement btn_ContractCodeSearch;
	
	@FindBy(xpath="(//div[@title='Search']//a)[2]")
	public WebElement btn_ContractCodeValidateSearch;
	
	@FindBy(xpath="//button[text()='Validate']")
	public WebElement btn_Validate;
	
	@FindBy(xpath="//div[@id='secId:cont_note:s_xj_aa3:innerTbl::db']//table")
	public WebElement tbl_SuspenseAmount;
	
	public String vfy_RequiredLink = "//table//tbody//tr[@_afrrk='%s']//td[3]//a"; 

	@FindBy(xpath = "//div[@id='firstId:pnlEventsPanel_CollListMainPanel_']//div//span[text()='Reject collection']")
	public WebElement lbl_RejectCollection;
	
}
