package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChargeOff_PageObject {

	@FindBy(xpath = "//span[contains(@id,':0:chargeoffreason::content')]")
	public WebElement vfy_ChargeOffReasonVal;
	
	@FindBy(xpath = "//span[contains(@id,':0:status::content')]")
	public WebElement vfy_ChargeOffStatusVal;
	
	@FindBy(xpath = "//label[text()='Contract No']/../input")
	public WebElement txt_ContractNumber;
	
	@FindBy(id = "secId:frmChargeOffList:j_id_id17pc6:innerTbl::db")
	public WebElement tbl_ChargeOff;

}
