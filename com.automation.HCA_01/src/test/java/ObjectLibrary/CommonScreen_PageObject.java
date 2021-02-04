package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonScreen_PageObject {

	public String vfy_EventPage = "//td//span[text()='%s']";
	public String vfy_ScreenLabel = "//h1[text()='%s']";
	
	@FindBy(id = "button_bar:btnCancel" )
	public WebElement btn_Cancel;
	
	@FindBy(xpath="//div[@id='firstId:pnlEventsPanel_CollListCollControlLink_']//span[text()='More >>']")
	public WebElement lnk_More;
	
	@FindBy(xpath = "//img[@title='Search']")
	public WebElement btn_Search;
	
	@FindBy(xpath = "//a[@href = '#']/img[@title='Collapse Pane' and @style ='vertical-align:top;cursor:default']")
	public WebElement btn_Collapsepane;
	
	@FindBy(xpath="//button[@id='button_bar:btnFinish' and not(@disabled)]")
	public WebElement btn_Finish;
	
	@FindBy(xpath="//div[@id='maskoverlay' and contains(@style,'display: none;')]")
	public WebElement vfy_CRMPageLoad;
	
	@FindBy(xpath = "//button[@id='button_bar:btnNext']")
	public WebElement btn_Next;
	
	@FindBy(xpath = "//button[@id='button_bar:btnBack']")
	public WebElement btn_Back;
	
	@FindBy(xpath="//button[text()='Confirm']")
	public WebElement btn_Confirm;
	
	@FindBy(xpath="//img[@title='New']")
	public WebElement btn_New;
	
	@FindBy(xpath = "//span[text()='Close SR']" )
	public WebElement btn_CloseSR;
	
	@FindBy(xpath="//label[text()='Contract']/..//input | //label[text()='Contract']/../..//input")
	public WebElement txt_Contracts;
	
	@FindBy(xpath="//img[@id='secId:bSr_s_q2_aa9::icon'] | //img[@id='secId:bSr_s_x4_aba::icon']")
	public WebElement btn_ContractsSearch;
	
	@FindBy(xpath="//img[@id='srcId:s_be8_aaj:tbTableToolbar:find::icon'] |//img[@id='srcId:s_be8_aaj:tbTableToolbar:find::icon']")
	public WebElement btn_SeachDialogPageSearch;
	
	@FindBy(xpath="//button[text()='Validate']")
	public WebElement btn_Validate;
	//added 5/30/2019
	
	public String linkToClick="//li[text()='%s']";
	
	@FindBy(xpath = "//button[text()='Close']")
    public WebElement btn_Close;
	
	@FindBy(xpath = "//div[contains(@id,'srcId:s_be') and text()='Search Dialog']")
	public WebElement lbl_SearchDialog;
	
	@FindBy(xpath = "//a[contains(@id,'srcId:s_be8_aah::close') and @title='Close']")
    public WebElement btn_CloseSearchDialog;
	

}
