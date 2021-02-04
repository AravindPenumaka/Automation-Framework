package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contract_PageObject {
	
	@FindBy(xpath = "//a[@href = '#']/img[@title='Collapse Pane' and @style ='vertical-align:top;cursor:default']")
	public WebElement btn_Collapsepane;

	@FindBy(xpath = "//input[@id='secId:s_n5_aao:innerTbl:dosnum::content']")
	public WebElement txt_Contractno;
	
	@FindBy(xpath = "//img[@title='Search']")
	public WebElement btn_SearchContract;
	
	@FindBy(xpath = "//a[@id='secId:s_n5_aao:innerTbl:0:dosnum']")
	public WebElement lnk_Contract;
	
	
	@FindBy(xpath = "//div[@id='firstId:s_be2_aab']")
	public WebElement vfy_Events;
	
	public String lnk_Event = "//span[text()='%s']";
	public String vfy_Tabs = "//a[text()='%s']";	
	public String vfy_Label ="//label[text()='%s']";
	public String vfy_LabelText ="//h1[text()='%s']";
	public String tab_ContractsSubTabs = "//div[@id='secId:mainBody:cont_note:s_m1_aab::tabh']//a[text()='%s']";

	
	@FindBy(xpath  = "//div[@class='xyg p_AFFlow']")
	public WebElement vfy_MulticurrencyPage;
	
	@FindBy(id = "secId:mainBody:cont_note:frmdostblSbvw1:s_mx_aac")
	public WebElement vfy_FinancialElementPage;
	
	@FindBy(id = "secId:mainBody:cont_note:frmDossElementsTblAccElement:s_mx_aaf")
	public WebElement vfy_IncidentalElementPage;
		
	@FindBy(id = "s_oy_aaf_1:innerTbl:dosnum::content")
	public WebElement txt_ContractNumber;
	
	@FindBy(xpath="//div[@id='s_oy_aaf_1:tbTableToolbar:find']//a//img[@title='Search']")
	public WebElement btn_SearchArchiveContracts;
	
	
	@FindBy(xpath="//img[@title='Copy/Paste a contract']")
	public WebElement btn_CopyContract;
	
	@FindBy(xpath="//input[@id='secId:mainBody:cont_note:s_m9_aav::content']")
	public WebElement txt_NameDetails;
	
	@FindBy(id="secId:mainBody:cont_note:s_m9_aa4::content")
	public WebElement lst_PhaseDetails;
	
	@FindBy(xpath="//img[@id='secId:s_m4_aad:s_bey0_aab::icon']")
	public WebElement btn_Save;
	
	@FindBy(id="secId:s_m4_aad:s_b57_aab")
	public WebElement vfy_Status;
	
	@FindBy(xpath = "//a[text()='Attached actors']")
	public WebElement tab_AttachedActors;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:cont_note:s_kx_aad:innerTbl::db']//table")
	public WebElement tbl_AttachedActorsContract;
	
	public String tbl_AttachedActorsValue="//div[@id='secId:mainBody:cont_note:s_kx_aad:innerTbl::db']//table/../../../..//td[3]//span[text()='%s']/../../../..//td[11]//span[text()='%s']";
	
	@FindBy(xpath = "//a[text()='General information']")
	public WebElement tab_GeneralInformation;
	
	@FindBy(xpath = "//img[@title='Expand Attached actors']")
	public WebElement lnk_AttachedActors_Expand;
	
	//Update Actor Attached Event Objects
	
	@FindBy(xpath = "(//span[text()='Update Attached Actor Status'])[2]")
	public WebElement lnk_UpdateAttachedActorStatus;
	
	@FindBy(xpath = "//div[contains(text(),'Update Attached Actor Status')]")
	public WebElement lbl_UpdateAttachedActorStatus;
	
	@FindBy(xpath = "//table[@id='s_bgm_aan']//tr[contains(@class,'p_AFInactive xzy p_AFSelected')]/../..")
	public WebElement tbl_AttachedActors;
	
	@FindBy(xpath = "//label[text()='Status']//..//..//..//..//td//select")
	public WebElement lst_Status;
	
	@FindBy(xpath = "//button[text()='    Apply    ']")
	public WebElement btn_Apply;
	
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement btn_Close;
	
	@FindBy(xpath="//h1[text()='Billing addresses']")
	public WebElement lbl_BillingAddresses;
	
	@FindBy(xpath="//label[text()='Address']/../../td[2]/select")
	public WebElement lst_Address;
	
	@FindBy(xpath="//img[@title='Expand Billing addresses']")
	public WebElement btn_ExpandBillingAddresses;
	
	//Changed Assigned actor(s) Event Objects
	
	@FindBy(xpath = "//a[@class='eventsPanelLinkClass']//span[text()='Change assigned actor(s)']")
	public WebElement lnk_ChangeAssignedActors;
	
	@FindBy(xpath = "//div[contains(text(),'Change assigned actor(s)')]")
	public WebElement lbl_ChangeAssignedActors;
	
	@FindBy(xpath = "//select[@title='Add a third-party delegation']")
	public WebElement lst_TypeOfChange;

	@FindBy(xpath = "//div[@id='cont_note:s_km_aai']//select[@title='**None**']")
	public WebElement lst_SecondaryActors;
	
	public String lst_GeneralInformationLists = "//label[text()='%s']/../../td[2]//select";
	
	@FindBy(id="secId:frmListeCasesTblCasesList:s_el_aao:innerTbl:contractref::content")
	public WebElement txt_CasesContractNumber;
	
	@FindBy(xpath="//a[@id='secId:frmListeCasesTblCasesList:s_el_aao:innerTbl:0:ccanum']")
	public WebElement lnk_CaseReference;
	
	@FindBy(xpath="//a[text()='Forgiveness Enquiry']")
	public WebElement tab_ForgivenessEnquiry;
	
	@FindBy(xpath="//div[text()='1099C Y/N']/../../../../../../div[2]//tr[1]//td[9]//span/span")
	public WebElement vfy_Form1099C ;
	
	public String vfy_AccountBalance ="//div[text()='CESS Grade']/../../../../../../div[2]//tr//td[%s]//span//span";

	@FindBy(xpath="//span[text()='DetailedPaymentSchedule']")
	public WebElement btn_DetailedPaymentSchedule;
	
	@FindBy(xpath="//div[@id='secId:mainBody:cont_note:s_mo_aak']")
	public WebElement vfy_PaumentScheduleTable;
	
	public String lnk_Reference = "//a[text()='%s']/../../..";
	
	@FindBy(xpath="//label[text()='Role']/../..//select")
	public WebElement vfy_RoleStatus;
	
	@FindBy(xpath = "//div[@id='cont_note:s_km_aai']//select[@title='**None**']//option[not(contains(text(),'**None**'))]")
	public WebElement lst_SecondaryActorsValue;
	

	
	

}
