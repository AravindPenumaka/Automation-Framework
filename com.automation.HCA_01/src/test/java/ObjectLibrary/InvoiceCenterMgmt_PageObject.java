package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceCenterMgmt_PageObject {
	@FindBy(xpath = "//a[@id='secId:mainBody:s_yb_aam::disAcr']")
	public WebElement tab_BillingAccount;
	
	@FindBy(xpath = "//span[text()='Invoice center modification']")
	public WebElement lst_InvoiceCenterModification;
	

	@FindBy(xpath = "//span[text()='Invoice center substitution']")
	public WebElement lst_InvoiceCenterSubstitution;
	
	@FindBy(xpath = "//div[@id='firstId:pnlEventsPanel_CollapsibleLinkContainer_']//span[text()='More >>']")
	public WebElement lst_MoreEventOptions;
	
	@FindBy(xpath = "//select[@id='cont_note:s_1d_aah::content']")
	public WebElement lst_TypeOfUpdate;

	@FindBy(xpath = "//select[@id='cont_note:s_1d_aag::content']")
	public WebElement lst_Reason;
	
	@FindBy(xpath = "//select[@id='cont_note:s_0p_aaf::content']//option[text()=' 8025 ohio dr, dt, Irvine, TX, 75024']")
	public WebElement lst_Address;
	
	//button[@id='button_bar:btnNext']
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_Next;
	
	@FindBy(id="//button[@id='button_bar:btnFinish']")
	public WebElement btn_Finish;
	
	@FindBy(xpath = "//input[@id='cont_note:s_0p_aat6::content' and @type='checkbox']")
	public WebElement cb_consolidatedBillingUnit;
	
	@FindBy(id="findcombobox")
	public WebElement lst_FindAccount;
	
	@FindBy(xpath="//option[@value='Contacts']")
	public WebElement lst_Contacts;
	
	@FindBy(id="field_textbox_0")
	public WebElement txt_AccountNumber;
	
	@FindBy(id="find_field_button")
	public WebElement btn_FindAccount;
	
	@FindBy(xpath="//td[@id='1_s_1000_l_title']/a[@class='drilldown']")
	public WebElement lnk_AccountNumber;
	
	@FindBy(xpath="//button[@aria-label='Search Results:Close']")
	public WebElement btn_CloseSearch;
	
	@FindBy(xpath="//span[@class='siebui-icon-dropdown applet-form-combo applet-list-combo']")
	public WebElement lst_ServiceRequest;
	
	@FindBy(xpath="//li[contains(text(),'Customer Preference Change')]")
	public WebElement lnk_CustomerPreferenceChange;
	
	@FindBy(xpath="//button[@title='Financial Account:GO']")
	public WebElement btn_Go;
	
	@FindBy(xpath="//span[@id='s_1_1_116_0_icon']")
	public WebElement lst_SubType;
	
	@FindBy(xpath="//li[contains(text(),'Statement Preference Change')]")
	public WebElement lst_StatementPreferenceChange;
	
	@FindBy(id="s_4_1_4_0_icon")
	public WebElement btn_SearchContact;
	
	@FindBy(xpath="//button[@title='Pick Contact:OK']")
	public WebElement btn_ContactOk;
	
	@FindBy(xpath="//span[text()='Paperless Statement']")
	public WebElement txt_PaperlessStatement;
	
	@FindBy(xpath="//span[contains(text(),'Paperless Statement')]/../../../td[4]//input")
	public WebElement cb_Paperless;
	
	@FindBy(xpath="//span[text()='Statement Ready']")
	public WebElement txt_Statementready;
	
	@FindBy(xpath="//span[contains(text(),'Statement Ready')]/../../../td[4]//input")
	public WebElement cb_Statementready;
	
	@FindBy(xpath="//span[text()='Stop Statement']")
	public WebElement txt_StopStatement;
	
	@FindBy(xpath="//span[contains(text(),'Stop Statement')]/../../../td[4]//input")
	public WebElement cb_StopStatement;
	
	@FindBy(xpath="//span[text()='Payment is Received']")
	public WebElement txt_PaymentReceived;
	
	@FindBy(xpath="//span[contains(text(),'Payment is Received')]/../../../td[3]//input")
	public WebElement cb_PaymentReceived;
	
	@FindBy(xpath="//span[text()='Payment Due in 10 Days']")
	public WebElement txt_PaymentDue;
	
	@FindBy(xpath="//span[contains(text(),'Payment Due in 10 Days')]/../../../td[8]//input")
	public WebElement cb_PaymentDue;
	
	@FindBy(xpath="//button[@name='s_4_1_21_0']")
	public WebElement btn_SubmitSR;
	
	@FindBy(xpath="//span[text()='Status']/../../../td[6]//input")
	public WebElement txt_Status;
	
	@FindBy(xpath="//span[text()='Sub Status']/../../../td[5]//input")
	public WebElement txt_SubStatus;
	
	@FindBy(xpath = "//select[@id='cont_note:s_0o_aba:innerTbl:0:aunordre::content']//option[@title='%s']")
	public String lst_UpdateBA ;
	
	@FindBy(xpath = "//input[@id='cont_note:s_0o_aba:innerTbl:0:aunflagselected::content']")
	public WebElement cb_BillingAccount;
	
	@FindBy(xpath = "//select[@id='cont_note:s_0o_aba:innerTbl:0:aunordre::content']")
	public WebElement lst_TargeteBA ;
	
	@FindBy(xpath="//input[@id='cont_note:s_yd_aaz::content']")
	public WebElement txt_AddressVal;
	
	@FindBy(xpath ="//select[@id='j_s_vctrl_div_tabScreen' and @role='combo']")
	public WebElement btn_DropDown;
	
	@FindBy(xpath ="//option[text()='Correspondence']")
	public WebElement btn_Correspondence;
	
	@FindBy(xpath ="//input[@id='secId:frmRubLsteTblSVw:s_cl_aao:innerTbl:dosnum::content']")
	public WebElement txt_ContractNo;
	
	@FindBy(xpath ="//img[@title='Search']")
	public WebElement btn_ContractSearch;
	
	@FindBy(xpath ="//div[@id='secId:frmRubLsteTblSVw:s_cl_aao:innerTbl::db']//table//tr//td[2]//a")
	public WebElement lnk_AssetCode;
	
	@FindBy(xpath ="//a[text()='Elements list']")
	public WebElement tab_ElementList;
	
	@FindBy(xpath ="(//div[@title='Garage Address List'])[1]")
	public WebElement tab_GarageAddress;
	
	@FindBy(xpath ="//label[text()='Zip Code']/../../td[2]//input")
	public WebElement txt_ZipCode;
	
	@FindBy(xpath ="(//label[text()='Address 1']/../../td[2]//input)[2]")
	public WebElement txt_Address;
	
	@FindBy(xpath ="(//label[text()='Date']/../../td[2]//input)[1]")
	public WebElement txt_DateModified;

	
	
}
