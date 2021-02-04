package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Bankruptcy_PageObject {

	@FindBy(xpath = "//div[text()='Customer Number']//..//..//../tr[2]/th[3]/span/input")
	public WebElement txt_CustomerNumber;
	
	public String lnk_CustomerNumber="//a[text()='%s']";
	
	@FindBy(xpath = "//label[text()='Mode']/../..//td/select/option[@selected]")
    public WebElement lst_Mode;
	
    public String cb_ContractList="//span[text()='%s']/../../../../td//input";
	
	@FindBy(xpath = " (//input[contains(@name,'bankruptContract')])[1]")
    public WebElement txt_ContractNumber;
   
	
}
