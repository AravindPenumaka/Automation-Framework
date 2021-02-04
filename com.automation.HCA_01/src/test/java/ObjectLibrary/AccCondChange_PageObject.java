package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccCondChange_PageObject {
	
	@FindBy(xpath = "//a[@title='EVD_ACCCON']/span[text()='Account Condition Change'][1]")
	public WebElement lnk_ConditionChange;
	
	@FindBy(id= "cont_note:j_id_id1pc10:tbTableToolbar:new::icon")
	public WebElement btn_New;
	
	@FindBy(xpath = "//select[@id='cont_note:s_at_baa::content']/option[text()='Payment Hold']")
	public WebElement sel_AccConditionPaymentHold;
	
	@FindBy(id = "cont_note:s_at_baa::content")
	public WebElement lst_AccCondition;


	@FindBy(xpath = "//button[text()='Finish']")
	public WebElement btn_Finish;

	@FindBy(xpath = "//button[text()='Close']")
	public WebElement btn_Close;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement btn_Cancel;
	
	@FindBy(xpath = "//table[@id='s_bgm_aad']//span[text()='Account Condition Change']")
	public WebElement lbl_AccountCondition;
}
