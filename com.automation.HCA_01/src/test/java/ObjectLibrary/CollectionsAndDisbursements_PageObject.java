package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CollectionsAndDisbursements_PageObject {

	@FindBy(xpath = "//input[contains(@name,'reference')]")
	public WebElement txt_ReferenceNumber;
	
	public String tbl_AccountCondition = "//div[contains(@id,'secId:mainBody:cont_note:')]//span[text()='%s']/../../../../td[3]//span[text()='%s']/../../../../td[4]//span[text()='%s']";
}
