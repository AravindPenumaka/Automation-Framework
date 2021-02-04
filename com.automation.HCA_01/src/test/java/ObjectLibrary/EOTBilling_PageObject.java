package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EOTBilling_PageObject {
	
	@FindBy(xpath = "//a[@id='secId:s_n5_aao:innerTbl:0:dosnum']")
	public WebElement lnk_Account;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:cont_note:s_m1_aab::tabh::eoi']")
	public WebElement lnk_More;
	
	@FindBy(xpath = "//div[@class='xjr']//a[@id='secId:mainBody:cont_note:j_id_id0pc53::disAcr']")
	public WebElement lnk_SettlementAutoLease;
	
	@FindBy(xpath = "//td[@class='xo7']//a[@id='secId:s_bgd_aaf::i']//img")
	public WebElement btn_CollapsePane1;
	
	@FindBy(xpath = "//td[@class='xo7']//a[@id='s_bgg_aae::i']//img")
	public WebElement btn_CollapsePane2;
	
	@FindBy(xpath = "//*[@id='secId:mainBody:cont_note:j_id_id89pc53']//label[contains(text(),'%s')]")
	public WebElement txt_Value;
	
	@FindBy(xpath = "//label[text()='Calculation Type']/../../../td[2]//select")
	public WebElement vfyLst_CalculationType;
	
	@FindBy(xpath = "(//label[contains(text(),'Due Unpaid Payments')])[2]/../../td[2]/input")
	public WebElement vfyTxt_DueUnpaidPayments;
	
	@FindBy(xpath = "//label[contains(text(),'Partial Payments')]/../../td[2]/input")
	public WebElement vfyTxt_PartialPayments;
	
	@FindBy(xpath = "//h3[text()='Other Amounts Due']/../../../../.././../.././../../../div//table//input")
	public WebElement vfyTxt_OtherAmountsDueFields;
	
	@FindBy(xpath = "//h3[text()='Reposession Expenses']/../../../../.././../.././../../../div//table//input")
	public WebElement vfyTxt_RepossisionExpenses;
	
	@FindBy(xpath = "//h3[text()='Auction Expenses']/../../../../.././../.././../../../div//table//input")
	public WebElement vfyTxt_AutionExpenses;
	
	/*@FindBy(xpath = "(//div[@id='secId:mainBody:cont_note:j_id_id33pc53']//table)[3]//tr[4]/td[2]/input")
	public WebElement txt_DueUnpaidPayments;
	
	@FindBy(xpath = "(//div[@id='secId:mainBody:cont_note:j_id_id33pc53']//table)[3]//tr[5]/td[2]/input")
	public WebElement PartialPayments;*/
	
	@FindBy(xpath = "//label[text()='Gross Sale Proceeds']/../../td[2]/input")
	public WebElement vfyTxt_GrossSalesProceeds;
	
	@FindBy(xpath = "//label[text()='Advance Lease Payments Suspense']/../../td[2]/input")
	public WebElement vfyTxt_AdvancedLeasePayments;
	
	@FindBy(xpath = "//label[text()='SecurityDeposit']/../../td[2]/input")
	public WebElement vfyTxt_SecurityDeposit;
	
	@FindBy(xpath = "//label[text()='Remaining Payments Excl. Tax']/../../td[2]//input")
	public WebElement vfyTxt_RemainingPaymentAmount;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:cont_note:j_id_id18pc53::content']")
	public WebElement vfyLst_TerminationType;
	
	@FindBy(xpath="//div[@class='AFPopupMenuContent']//a[text()='Quotation']")
	public WebElement lnk_Quotation;

}
