package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Legal_PageObject {
	@FindBy(xpath = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']//span[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl:0:dcocondition::content']")
	public WebElement vfyfld_AccountChange;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']//span[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl:0:dcodtend::content']")
	public WebElement vfyfld_EndDate;
   
	@FindBy(xpath = "//select[@id='secId:mainBody:cont_note:j_id_id2pc27:innerTbl:0:dcrresreason::content']")
	public WebElement vfyfld_ReserveReason;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:cont_note:j_id_id2pc27:innerTbl:0:dcrresstatus::content']")
	public WebElement vfyfld_ReserveStatus;
	
	/*@FindBy(xpath = "//span[@id='s_1_1_39_0_icon']")
	public WebElement btn_PhoneTypeArrow ;*/
	
	@FindBy(xpath = "//input[@aria-labelledby='HISNA_SR_Phone_Type_Label' and @role='combobox']/../span")
	public WebElement lst_PhoneType ;
	
	@FindBy(xpath = "//input[@aria-labelledby='Type_Label' and @role='combobox']/../span")
	public WebElement lst_SRType;

	@FindBy(xpath = "//button[@aria-label='Legal:Submit' and @type='button']")
	public WebElement btn_Submit ;
	
	@FindBy(xpath = "//button[@aria-label='Service Request:Go to Financial Account' and @type='button']")
	public WebElement btn_GoToFinancialAccounts ;
	
	@FindBy(xpath = "//input[@aria-labelledby='HISNA_Legal_Label' and @type='checkbox']")
	public WebElement cb_Legal ;
	
	@FindBy(xpath = "//div[@title='CB Report']//h1[text()='CB Report']")
    public WebElement lbl_CBReport;
	
	@FindBy(xpath = "//input[@aria-label='Status']")
    public WebElement vfyfld_Status;
	
	@FindBy(xpath = "//span[text()='Close SR']")
    public WebElement btn_CloseSR;

	
	public String vfy_AccontCondition = "//span[text()='%s']/../../../../td[2]//span//span";
	public String vfy_EndDate = "//span[text()='%s']/../../../../td[5]//span//span";
	public String vfy_StartDate="//span[text()='%s']/../../../../td[4]//span//span";
	public String vfy_PersonIdCreated="//span[text()='%s']/../../../../td[6]//span//span";
	
}
