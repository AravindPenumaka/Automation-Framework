package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAccCond_PageObject {

	@FindBy(xpath = "//div[@title='Account Condition']/h1[text()='Account Condition']")
	public WebElement txt_acccond;
	
	public String tbl_Accountcondition = "//div[contains(@id,'secId:mainBody:cont_note:')]//span[text()='%s']/../../../../td[3]//span[text()='%s']/../../../../td[4]//span[text()='%s']";

	public String tbl_AcntCondPaymentHold ="(//div[contains(@id,'secId:mainBody:cont_note:')]//span[text()='%s']/../../../../td[4]//span[text()='%s'])[1]";
	 
	@FindBy(xpath = "//label[text()='Hold Flag']/../../td[2]//input")
	public WebElement cb_HoldFlag;
	
	@FindBy(xpath = "//label[text()='Hold Flag']")
	public WebElement lbl_HoldFlag;
	
	@FindBy(xpath = "//label[text()='Settlement Money Factor']")
	public WebElement lbl_SettlementMoneyFactor;
	
	@FindBy(xpath = "//div[@title='Account Condition']/h1[text()='Account Condition']")
	public WebElement lbl_Accountcondition;
}
