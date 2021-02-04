package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen_PageObject {
		
	public String tab_MenuItem = "//a[text()='%s']";
	public String sel_MenuListItem = "//div[@class='AFPopupMenuPopup']//td[text()='%s']";
	
	@FindBy(id = "firstId:globalSearch:pnlGSFields:s_be4_aad::content")
	public WebElement lst_GlobalSearchFind;
	
	@FindBy(xpath = "//input[@name='firstId:globalSearch:pnlGSFields:tf_s_be4_aae']")
	public WebElement txt_GlobalSearchCode;
	
	@FindBy(xpath = "//div[@class='x1nj xgc']//a[@onclick='this.focus();return false']")
	public WebElement btn_GobalSearch;
	
	@FindBy(xpath = "//a[@id='s_tu_aa0' and @title='Logout']")
	public WebElement btn_LogOutKSIOP;
	
}
	        
	