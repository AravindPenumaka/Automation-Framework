package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditDispute_PageObject {

	@FindBy(name ="secId:cont_note:s_10_aac:innerTbl:dosnum")
	public WebElement txt_AccountNum;
	
	@FindBy(xpath = "//a[text()='Contracts']")
	public WebElement tab_Contacts;
	
	@FindBy(xpath = "//div[@class='AFPopupMenuPopup']//td[text()='Credit Dispute']")
	public WebElement lst_ContractsItem;
	
	@FindBy(xpath = "//img[@id='secId:cont_note:s_10_aac:tbTableToolbar:find::icon']")
	public WebElement img_Search;

	public String vfy_FieldName = "//label[text()='%s']";
	public String vfy_CreditDisputeTable = "//div[@id='secId:cont_note:s_10_aac:innerTbl::ch']//tr[3]/th/div[text()='%s']";
	
	@FindBy(xpath = "//table[@class='xza x102']//tbody//tr//td//span[@id='secId:cont_note:s_10_aac:innerTbl:0:dcocondition::content']")
	public WebElement vfy_AccStatusConditionTable;
	
	public String vfy_CustomerInfomationTable = "//table[@id='secId:cont_note:s_s6_aad:innerTbl::ch::t']/tbody/tr[2]/th/div[2][text()='%s']";
	
	public String vfy_Delliquency="(//h2[text()='Delinquency Counters override']/../../../../../../../../../../div/div/div/div/div[2]//table)[1]//tr[2]//th//div[contains(text(),'%s')]";
	
	@FindBy(xpath = "//select[@name='secId:cont_note:s_s6_aad:innerTbl:0:ecoa']/option")
	public WebElement vfy_EcoaVal;
	
	public String vfy_AuditTrailTable ="(//div[@id='secId:cont_note:s_s6_aaf:innerTbl::db']/table/tbody//span[contains(text(),'Special')])";
    //modified
	@FindBy(xpath = "//h2[text()='Audit Trail']")
    public WebElement lbl_AuditTrail; 

	//added
	@FindBy(xpath = "//img[@title='Expand CD Management']")
	public WebElement img_ExpandCDManagement; 
	@FindBy(xpath = "//div[@title='Delinquency Counters']//h2[text()='Delinquency Counters']")
	public WebElement lbl_DelinquencyCounters; 
	@FindBy(xpath = "//div[@title='Delinquency Counters override']//h2[text()='Delinquency Counters override']")
	public WebElement lbl_DelinquencyCountersOverride;
	
	@FindBy(xpath = "//div[@title='Payment History Profile - Override']//h2[text()='Payment History Profile - Override']")
	public WebElement lbl_PHPOverride; 
	@FindBy(xpath = "//div[@title='Payment History Profile - Real time']//h2[text()='Payment History Profile - Real time']")
	public WebElement lbl_PHPRealtime; 
	@FindBy(xpath = "//div[@title='Payment History Profile - Last CB data']//h2[text()='Payment History Profile - Last CB data']")
	public WebElement lbl_PHPLastCBData; 
	
	
	
	
	

	
	
}
