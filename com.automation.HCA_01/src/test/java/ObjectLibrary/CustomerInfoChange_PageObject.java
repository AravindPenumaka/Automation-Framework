package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInfoChange_PageObject {
	
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
	
	@FindBy(xpath="//input[@aria-label='Subtype']/../span[contains(@class,'siebui-icon-dropdown')]")
	public WebElement lst_NewServiceRequest;
	
	@FindBy(xpath="//button[@title='Financial Account:GO']")
	public WebElement btn_Go;
	
	@FindBy(xpath="//span[@id='s_3_1_10_0_icon']")
	public WebElement btn_ContactNameSearch;
	
	@FindBy(xpath="//button[@title='Pick Contact:OK']")
	public WebElement btn_PickContactOk;
	
	@FindBy(xpath="//span[text()='Employer Name']/../../../td[3]//span")
	public WebElement btn_EmployerNameSearch;
	
	@FindBy(xpath="//button[@title='Employer Addresses:OK']/span[text()='OK']")
	public WebElement btn_EmployerNameSearchOk;
	
	@FindBy(xpath="(//span[text()='Employer Name'])[2]/../../../td[11]//input")
	public WebElement txt_NewEmployerName;
	
	@FindBy(xpath="(//span[text()='From'])[1]/../../../td[10]//input")
	public WebElement txt_EmployementFromDate;
	
	@FindBy(xpath="//input[@name='s_3_1_31_0']")
	public WebElement txt_EmpAddress;
	
	@FindBy(xpath="//input[@name='s_3_1_81_0']")
	public WebElement txt_NewEmail;
	
	@FindBy(xpath="//button[@title='Account Address:New']")
	public WebElement btn_NewCustomerAddress;
	
	@FindBy(xpath="//input[@id='1_HISNA_SR_Address_Type']")
	public WebElement txt_NewAddressType;
	
	@FindBy(xpath="//input[@name='New_Address_Line_1']")
	public WebElement txt_NewAddress;
	
	@FindBy(xpath="//span[@class='siebui-icon-pick']")
	public WebElement btn_NewZipCode;
	
	@FindBy(xpath="//button[@title='Pick Contact Address:OK']")
	public WebElement btn_ZipCodeOk;
	
	@FindBy(xpath="//input[@name='New_City']")
	public WebElement txt_NewCity;
	
	@FindBy(xpath="//button[@name='s_3_1_122_0']/span[text()='Submit']")
	public WebElement btn_Submit;
	
	@FindBy(xpath="//span[text()='Validate']")
	public WebElement btn_Validate;
	
	@FindBy(xpath="(//div[text()='Validated']/../../../../../../../div[3]//td[12])[2]")
	public WebElement cb_Validate;
	
	@FindBy(xpath="//span[@id='Account_Status_Label']")
	public WebElement val_Status;
	
	@FindBy(xpath="//input[@aria-label='Status']")
	public WebElement txt_Status;
	
	@FindBy(xpath="//input[@aria-label='Sub Status']")
	public WebElement txt_SubStatus;
	
	@FindBy(xpath="//span[text()='Documents Received']/../../../td[3]//input")
	public WebElement cb_DocumentsReceived;
	
	@FindBy(xpath="//div[@id='gview_s_2_l']//table//tr[2]/td[13]")
	public WebElement tbl_OverrideOrAccpet;
	
	@FindBy(xpath="//div[text()='Override/Accept']/../../../../../../..//div[3]//td[13]/span")
	public WebElement lst_AcceptOrOverride;
	
	@FindBy(xpath="//li[text()='Override']")
	public WebElement lst_Override;
	
	@FindBy(xpath="//li[text()='Accept']")
	public WebElement lst_Accept;
	
	@FindBy(xpath="//a[text()='Asset']")
	public WebElement lst_Asset;
	
	@FindBy(xpath="//tr[@id='modulesMenu:s_tu_abz']//td[text()='Asset']")
	public WebElement lnk_Asset;
	
	@FindBy(id="firstId:globalSearch:pnlGSFields:s_be4_aad::content")
	public WebElement lst_Find;
	
	@FindBy(id="firstId:globalSearch:pnlGSFields:tf_s_be4_aae::content")
	public WebElement txt_Code;
	
	@FindBy(xpath="//div[@class='x1nj xgc']//a[@class='x12k']")
	public WebElement btn_CodeSearch;
	
	@FindBy(xpath="//div[@id='firstId:globalSearch:s_be4_aag']//a")
	public WebElement lnk_Code;
	
	@FindBy(xpath="//div[@id='secId:s_bge_aag']//input[@name='secId:vboxlist:s_cg_aaf']")
	public WebElement txt_Name;
	
	@FindBy(xpath="//div[@class='xym']/a[@id='secId:vboxlist:s_bu_aab::disAcr']")
	public WebElement lnk_ElementList;
	
	@FindBy(xpath="//div[@title='Address List']/h2")
	public WebElement tab_AddressList;
	
	@FindBy(xpath="//span[text()='Asset address change']")
	public WebElement lnk_AssetAddressChange;
	
	@FindBy(xpath="//select[@name='cont_note:j_id_id3pc10']")
	public WebElement lst_AddressToChange;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_GeneralInfoNext;
	
	
	@FindBy(xpath = "//select[@id='firstId:globalSearch:pnlGSFields:s_be4_aad::content']/option[@value='5']")
	public WebElement lst_GlobalSearch;
	
	@FindBy(xpath = "//input[@id='firstId:globalSearch:pnlGSFields:tf_s_be4_aae::content']")
	public WebElement txt_CodeAssetNo;
	
	@FindBy(xpath = "//div[@id='firstId:globalSearch:pnlGSFields:bSr_s_be4_aae']/a[@class='x12k']")
	public WebElement img_Search;
	
	@FindBy(xpath = "//a[text()='Elements list']")
	public WebElement tab_ElementList;
	
	public String vfy_FieldName = "//div[@id='cont_note:s_cz_aac']//label[text()='%s']";	

	@FindBy(xpath = "//div[@id='modulesMenu:s_tu_aa8']/div/table//a[@class='x10o']")
	public WebElement tab_Tasks;
	
	@FindBy(xpath = "//tr[@id='modulesMenu:s_tu_aba']//td[@class='x113']")
	public WebElement lst_Tasks;
	
	@FindBy(xpath = "//input[@id='secId:frmAgdTblSubVw:s_byb_aao:innerTbl:ciblenum::content']")
	public WebElement txt_Reference;
	
	@FindBy(xpath = "//button[@id='button_bar:btnNext']")
	public WebElement btn_NextGeneralInfoTab;
	
	@FindBy(xpath = "//div[@id='s_by_aaf']//input[@id='s_by_aa0::content']")
	public WebElement txt_AdressOne;
	
	@FindBy(xpath = "//div[@id='s_by_aaf']//input[@id='s_by_aaz::content']")
	public WebElement txt_AdressTwo;
	
	@FindBy(xpath = "//button[@id='button_bar:btnNext']")
	public WebElement btn_NextAddresstab;
	
	@FindBy(xpath = "//label[text()='Valid Address Status']")
	public WebElement vfyfld_validAccStatus;
	
	@FindBy(xpath = "//label[text()='Valid Address Status']/../../td[2]/input")
    public WebElement vfy_ValidAccStatus;
	
	@FindBy(xpath = "//button[@id='button_bar:btnNext']")
	public WebElement btn_NextCleansedAddresstab;
	
	@FindBy(xpath = "//button[@id='button_bar:btnBack']")
	public WebElement btn_BackCleansedAddresstab;
	
	@FindBy(xpath = "//input[@id='s_yd_aao::content']")
	public WebElement cb_OverrideAddress;
	
	@FindBy(xpath = "(//div[@class='xvo']//label[text()='Address1']/../../../tr[2]/td/input)[1]")
    public WebElement txt_Newaddress1Recap;
    
    @FindBy(xpath = "(//div[@class='xvo']//label[text()='Address2']/../../../tr[2]/td/input)[1]")
    public WebElement txt_Newaddress2Recap;
    
    @FindBy(xpath = "(//div[@class='xvo']//label[text()='Address1']/../../../tr[2]/td/input)[2]")
    public WebElement txt_Oldaddress1Recap;
    
    @FindBy(xpath = "(//div[@class='xvo']//label[text()='Address2']/../../../tr[2]/td/input)[2]")
    public WebElement txt_Oldaddress2Recap;

	@FindBy(xpath = "//button[@id='button_bar:btnFinish']")
	public WebElement btn_FinishRecap;
	
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	public WebElement txt_LastName;
	
	@FindBy(xpath = "//button[@id='s_u4_aat']")
	public WebElement btn_Confirm;
	
	@FindBy(xpath = "//input[@aria-label='Reason' and @aria-readonly='false']")
	public WebElement txt_Reason;
	
	@FindBy(xpath = "//input[@aria-label='Documents Received']")
	public WebElement cb_DocumentReceived;
	
	@FindBy(xpath = "//label[text()='Full Name']/./../../td[2]/input")
	public WebElement txt_FullName;
	
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement btn_Close;
	
	@FindBy(xpath = "//button/span[text()='Select Existing Address']")
	public WebElement btn_ExistingAddress;
	
	@FindBy(xpath = "//span[text()='OK']")
	public WebElement btn_AddressOk;

	@FindBy(xpath="//input[@name='HISNA_Zipcode_Lookup']/../../td[5]")
	public WebElement txt_ZipCodeMain;
	
	@FindBy(xpath="(//li//a[text()='Contacts'])[2]")
	public WebElement tab_Contacts;
	
	@FindBy(xpath="(//*[text()='Home']/../td[5])[1]")
	public WebElement vfy_Street;
	
	@FindBy(xpath="(//*[text()='Home']/../td[6])[1]")
	public WebElement vfy_City;
	
	@FindBy(xpath="(//*[text()='Home']/../td[7])[1]")
	public WebElement vfy_State;
	
	@FindBy(xpath="(//*[text()='Home']/../td[8])[1]")
	public WebElement vfy_Zip;
	
	@FindBy(xpath="(//table[@summary='Service Requests']//tr//td[text()='Customer Info Change']/../td[text()='Website'])[1]")
	public WebElement vfy_SRCreated;
	
	
}
