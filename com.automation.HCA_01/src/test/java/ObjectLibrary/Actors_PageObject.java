package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Actors_PageObject {

	@FindBy(xpath = "//input[@name='secId:s_0q_aao:innerTbl:actsiret']")
	public WebElement txt_ActorId;
	
	@FindBy(xpath = "//div[@id='secId:s_0q_aao:tbTableToolbar::eoi']")
	public WebElement btn_MoreOption;
	
	@FindBy(xpath = "//a[@id='secId:s_0q_aao:innerTbl:0:actcode']")
	public WebElement lnk_Reference;
	
	@FindBy(xpath = "//a[@class='eventsPanelLinkClass']//span[text()='Modify Address']")
	public WebElement lnk_ModifyAddress;
	
	@FindBy(xpath = "//label[text()='Reference']/../..//td/input" )
	public WebElement lbl_Reference;
	
	@FindBy(xpath = "//button[text()='Next']")
	public WebElement btn_Next;
	
	@FindBy(xpath = "//div[@id='j_id_id3pc8:tbTableToolbar:new']//a//img[@title='New']")
	public WebElement btn_New;
	
	@FindBy(xpath = "//nobr/img[@src='/Cassiopae/images/framework/new_ena.png']")
	public WebElement cb_New;
	
	@FindBy(id = "s_yd_aaza::content")
	public WebElement txt_Address1;
	
	@FindBy(xpath = "//div//a//img[@title='Search']")
	public WebElement btn_Search;
	
	@FindBy(xpath = "//label[text()='Actor reference']/../..//td/input" )
	public WebElement lbl_ActorReference;

	@FindBy(xpath = "//label[text()='Phase']/../..//td//select" )
	public WebElement lbl_Phase;

	@FindBy(xpath = "//a[text()='Individual']" )
	public WebElement tab_Individual;
	
	@FindBy(xpath = "//label[text()='Fullname']/../../td/input" )
	public WebElement lbl_FullName;
	
	@FindBy(xpath = "//h1[text()='Job History']" )
	public WebElement lbl_JobHistory;
	
	@FindBy(xpath = "//a[text()='Addresses']" )
	public WebElement tab_Address;
	
	@FindBy(xpath = "(//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//span[text()='Home']/../../../../td[%s]//span/span)[1]" )
	public WebElement tbl_AddressList;
	
	public String tbl_AddList = "(//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//span[text()='Home']/../../../../td[%s]//span/span)[1]";
	public String tbl_AddListHeader = "//div[@id='secId:mainBody:s_yc_aac:innerTbl::ch']/table/tbody/tr[2]/th[%s]//div[2]";
	
	@FindBy(xpath = "//a[text()='Contacts']" )
	public WebElement tab_Contacts;
	
	@FindBy(xpath = "//h1[text()='Telecom']" )
	public WebElement lbl_Telecome;
	
	public String tbl_TelecomList="(//div[@id='secId:mainBody:s_y6_aad:innerTbl::db']//span[text()='%s']/../../../../td[%s]//span/span)[1]";
	
	public String tbl_TelecomListHeader= "//div[@id='secId:mainBody:s_y6_aad:innerTbl::ch']/table/tbody/tr[2]/th[%s]//div[2]";

	public String tab_Role = "//div[@id='secId:mainBody:s_yb_aao::ti' and not(@style='display: none;')]//a[text()='%s'] | //div[@id='secId:mainBody:s_yb_aac::tabh::eoc']//a[text()='Role']";
	
	@FindBy(xpath = "//h1[text()='List of Roles']" )
	public WebElement lbl_RoleList;
	
	@FindBy(xpath = "//label[text()='Last name']/../..//td/input" )
	public WebElement lbl_LastName;
	
	@FindBy(xpath = "(//td[@class='x51']//span//div//div//a//span[text()='More >>'])[1]" )
	public WebElement lnk_More;
	
//modified
     @FindBy(id="secId:mainBody:s_yb_aac::tabh::eoi" )
     public WebElement btn_MoreActorOption;

	
	@FindBy(xpath = "(//span[text()='Change tradename'])[2]" )
	public WebElement lnk_ChangeTradeName;
	
	@FindBy(id="cont_note:s_zn_aam::content")
	public WebElement txt_LastName;
	
	@FindBy(xpath = "//button[@title='Close']")
	public WebElement btn_Close;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:s_yb_aac::tabh::eoc']//a[text()='Assent']" )
	public WebElement tab_Assent;
	
	
	public String tbl_AssentHeader= "//div[@id='secId:mainBody:s_ye_aad:innerTbl::ch']/table/tbody/tr[3]//th[%s]//div[2]";
	public String tbl_AssentList ="(//div[@id='secId:mainBody:s_ye_aad:innerTbl::db']//td[%s]//span/span)[1]";

	
	
	
	@FindBy(xpath = "//*[contains(text(),'First Name')]" )
	public WebElement lbl_FName;
	
	@FindBy(xpath = "//*[contains(text(),'First Name')]//..//..//td//input" )
	public WebElement vfy_FirstName;
	
	@FindBy(xpath = "//*[contains(text(),'Last Name')]" )
	public WebElement lbl_LName;
	
	@FindBy(xpath = "//*[contains(text(),'Last Name')]//..//..//td//input" )
	public WebElement vfy_LastName;
	
	@FindBy(xpath = "//*[contains(text(),'Middle Name')]" )
	public WebElement lbl_MName;
	
	@FindBy(xpath = "//*[contains(text(),'Middle Name')]//..//..//td//input" )
	public WebElement vfy_MiddleName;
	
	@FindBy(xpath = "//*[text()='List of Roles']" )
	public WebElement lbl_List_Of_Roles;
	
	
	@FindBy(xpath = "//*[text()='Telecom']" )
	public WebElement lbl_Telecom;
	
	public String tbl_TelecomHeaders ="//*[text()='Telecom']//..//..//..//..//..//..//..//..//..//following-sibling::div//div[@class='xzg']/table/tbody/tr[2]/th[%s]/div/following-sibling::div";
	public String tbl_TelecomHeadersSize ="//*[text()='Telecom']//..//..//..//..//..//..//..//..//..//following-sibling::div//div[@class='xzg']/table/tbody/tr[2]/th/div/following-sibling::div";
	public String tbl_telecomRowSize="//*[text()='Telecom']//..//..//..//..//..//..//..//..//..//following-sibling::div//table[contains(@class,'xza')]/tbody/tr";
	
	@FindBy(xpath = "//div[@id='secId:mainBody:s_yb_aac::tabh::eoi']")
	public WebElement btn_ArrowMark_ActroListPage;
	
	@FindBy(xpath = "//div[@class='xjr']/a[text()='Past Events']")
	public WebElement sel_PastEvent;

	public String lnk_PastEvent="(//a[text()='%s'])[1]";
	//modified
	@FindBy(xpath = "(//div//a[text()='Past Events'])[2]" )
    public WebElement tab_PastEvents;

	
	@FindBy(xpath="//div[@id='secId:mainBody:s_bf7_aak']")
	public WebElement vfy_PastEventTable;
	
	@FindBy(xpath="(//div[@id='secId:mainBody:s_bf7_aal:innerTbl::db']//td[1]/nobr/a)[1]")
	public WebElement lnk_EventFirstRow;
	
	@FindBy(xpath = "//div[@id='eventReport:eventReportText:s_u4_aao']//div")
	public WebElement vfy_PastEventData;
	
	@FindBy(id="eventReport:eventReportText:s_u4_aao")
	public WebElement vfy_PastEventDetails;
	
	@FindBy(xpath = "//div[@title='New']/a")
	public WebElement lnk_NewActorList;
	
	@FindBy(xpath = "//*[text()='Actor Type']")
	public WebElement lbl_ActorType;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:s_zn_aau::content']")
	public WebElement lst_ActorType;
	
	@FindBy(xpath = "//*[text()='Residential Status']")
	public WebElement lbl_ResidentialStatus;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:s_zn_abv::content']")
	public WebElement lst_ResidentialStatus;
	
	@FindBy(xpath = "//*[text()='Business No.']")
	public WebElement lbl_BusinessNo;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:s_zn_aaj::content']")
	public WebElement txt_BusinessNo;
	
	@FindBy(xpath = "//*[text()='Business Name']")
	public WebElement lbl_BusinessName;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:s_zn_aag::content']")
	public WebElement txt_BusinessName;
	
	@FindBy(xpath = "//*[text()='Full name 2']")
	public WebElement lbl_FullName2;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:s_zn_aadp::content']")
	public WebElement txt_FullName2;
	
	@FindBy(xpath = "//label[@for='secId:mainBody:s_zn_aal::content']")
	public WebElement lbl_Role;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:s_zn_aal::content']")
	public WebElement lst_Role;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:bSr_s_zn_aa5']/a")
	public WebElement lnk_SearchLegalClassification;
	
	@FindBy(xpath = "//div[text()='Search Dialog']")
	public WebElement lbl_SearchDialog;
	
	@FindBy(xpath = "//button[text()='Validate']")
	public WebElement btn_Validate;
	
	@FindBy(xpath = "//input[@value='Business Customer']//..//..//..//..//..")
	public WebElement tbl_Searchdialog;
	
	@FindBy(xpath = "//*[text()='Business Opening Date']")
	public WebElement lbl_BusinessOpeningDate;
	
	@FindBy(xpath = "//*[text()='Business Opening Date']//..//..//td[2]/input")
	public WebElement dt_BusinessOpeningDate;
	
	@FindBy(xpath = "//div[@title='Save']/a")
	public WebElement lnk_SaveActorList;
	
	@FindBy(xpath = "//*[text()='Actor reference']")
	public WebElement lbl_ActorRef;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:s_zn_aad::content']")
	public WebElement txt_ActorRef;
	
	@FindBy(xpath = "//label[contains(text(),'Actors List')]")
	public WebElement lbl_ActorsListPage;
	
	
	public String tbl_ListOfRoleHeader ="//div[@id='secId:mainBody:s_0e_aac:_otrWpr::c']//table/tbody//tr[3]//th[%s]//div[2]";
	public String tbl_ListOfRole="(//div[@id='secId:mainBody:s_0e_aac:innerTbl::db']//td[%s]//span//span)[1]";
	
	@FindBy(xpath = "(//span[text()='Change tradename'])[2]" )
	public WebElement lst_ChangeTradename;
	
	//added for sanity test cases
	
	@FindBy(xpath = "//div[@id='firstId:s_be2_aab']")
	public WebElement vfy_Events;
	
	public String tab_ActorSubTabs = "//div[@id='secId:mainBody:s_yb_aac::tabh']//a[text()='%s']";
//	public String tab_ActorSubTabs = "//div[@id='secId:mainBody:s_yb_aac::tabh']//a[text()]";
	
	@FindBy(xpath = "//h1[text()='Credit Info']")
	public WebElement vfy_CreditInfo;
	
	@FindBy(xpath = "//h1[text()='Address List']")
	public WebElement vfy_AddressList;

	@FindBy(xpath = "//h1[text()='Bank accounts List']")
	public WebElement vfy_BankAccountList;
	
	@FindBy(xpath = "//h1[text()='Card Info']")
	public WebElement vfy_LoanCard;
	
	@FindBy(xpath = "//h1[text()='Invoice Center']")
	public WebElement vfy_BillingAccount;
	
	@FindBy(xpath = "//h1[text()='Contact Lists']")
	public WebElement vfy_ContractLists;
	
	@FindBy(xpath = "//span[text()='Change address']" )
	public WebElement lst_ChangeAddress;
	
	@FindBy(xpath = "//span[text()='Change Address']" )
	public WebElement lbl_ChangeAddress;

	public String lnk_ActorEvent = "//span[text()='%s']";
	
	public String vfy_EventPage = "//td//span[text()='%s']";
	
	@FindBy(id="s_1t_aaf:innerTbl:actsiret::content")
	public WebElement txt_ArchiveActorId;
	
	@FindBy(xpath="//div[@id='s_1t_aaf:tbTableToolbar::oc']//div//a//img[@title='Search']")
	public WebElement btn_SearchArchiveActor;
	
	@FindBy(xpath = "//div[@id='firstId:pnlEventsPanel_CollListMainPanel_']//span[text()='Change phase']")
	public WebElement lnk_ChangePhase;
	
	@FindBy(xpath = "//td[text()='General information']")
	public WebElement lbl_GeneralInformation;
	
	@FindBy(xpath = "//*[@id='cont_note:eventIdentity:actorIdentity:s_aq_aax::content']")
	public WebElement vfy_Phase;
	
	@FindBy(xpath = "//*[@for='cont_note:eventIdentity:actorIdentity:s_aq_aax::content']")
	public WebElement lbl_CurrentPhase;
	
	@FindBy(xpath = "//*[@for='cont_note:eventIdentity:actorIdentity:s_aq_aay::content']")
	public WebElement lbl_CurrentStep;
	
	@FindBy(xpath = "//*[@id='cont_note:eventIdentity:actorIdentity:s_aq_aay::content']")
	public WebElement vfy_CurrentStep;
	
	@FindBy(xpath = "//*[text()='New phase']")
	public WebElement lbl_NewPhase;
	
	@FindBy(xpath = "//*[@id='cont_note:s_00_aaf::content']")
	public WebElement lst_NewPhase;
	
	@FindBy(xpath = "//*[text()='New step']")
	public WebElement lbl_NewStep;
	
	@FindBy(xpath = "//*[@id='cont_note:s_00_aag::content']")
	public WebElement lst_NewStep;
	
	
	@FindBy(xpath = "//input[@id='cont_note:eventIdentity:actorIdentity:s_aq_aay::content']" )
	public WebElement vfy_Step;
	
	@FindBy(xpath = "//label[text()='External reference']" )
	public WebElement lbl_ExternalReference;
	
	@FindBy(xpath = "//label[text()='External reference']//..//..//td[2]/input" )
	public WebElement txt_ExternalReference;
	
	public String  tbl_roleRefernceValue= "//span[text()='%s']";
	
	@FindBy(xpath = "//h1[text()='Actor Telecom Info']/../../../../../../../../../../..//img[contains(@id,':tbTableToolbar:new::icon')]")
	public WebElement btn_newActorTelecomInfo;
	
	@FindBy(xpath = "//h1[text()='Actor Telecom Info']")
	public WebElement lbl_ActorTelecomInfo;
	
	@FindBy(xpath = "//select[contains(@id,':innerTbl:0:atetype::content')]")
	public WebElement lst_TelecomType;
	
	@FindBy(xpath = "//input[contains(@id,':innerTbl:0:atenum1::content')]")
	public WebElement txt_areaCode;
	
	@FindBy(xpath = "//input[contains(@id,':innerTbl:0:atenum2::content')]")
	public WebElement txt_prefix;
	
	@FindBy(xpath = "//input[contains(@id,':innerTbl:0:atenum3::content')]")
	public WebElement txt_lineNumber;
	
	@FindBy(xpath = "//*[text()='Finish']")
	public WebElement btn_finish;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement btn_confirm;
	
	@FindBy(xpath = "(//span[text()='Self']//..//..//..//..)[1]")
	public WebElement tbl_contactList;
	
	@FindBy(xpath = "//*[@id='secId:mainBody:s_y6_aad:innerTbl::db']/table/tbody/tr/td[3]")
	public WebElement tbl_telecomReferenceValue;
	
	@FindBy(xpath = "//span[text()='Change Role Status']")
	public WebElement lnk_changeRoleStaus;
	
	@FindBy(xpath = "//*[@id='cont_note:s_00_aah::content']")
	public WebElement lst_phase_changeRoleStatus;
	
	@FindBy(xpath = "//*[@id='secId:mainBody:s_0e_aac:innerTbl:0:phacode::content']")
	public WebElement vfy_phaseTable;
	
	@FindBy(xpath = "//span[text()='Change attribute']")
	public WebElement lnk_changeAttribute;
	
	@FindBy(xpath = "//*[@id='cont_note:s_07_aaj::content']")
	public WebElement lst_Reason;
	
	@FindBy(xpath = "//label[text()='Reason']")
	public WebElement lbl_Reason_ChangeAttributePage;
	
	@FindBy(xpath = "//h1[text()='Attributes']")
	public WebElement lbl_attribute;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:s_ye_aaf']")
    public WebElement tbl_CallForMarketing;
	
	@FindBy(xpath = "//span[text()='Bankruptcy']/..")
    public WebElement lnk_bankruptcy;
	
	@FindBy(xpath = "//label[text()='Type']")
    public WebElement lbl_type;
	
	@FindBy(xpath = "//label[text()='Type']/../..//td/select")
    public WebElement lst_type;
	
	@FindBy(xpath = "//label[text()='Mode']/../..//td/select")
    public WebElement lst_mode;
	
	@FindBy(xpath = "//div[@id='secId:mainBody:PANELTABLECCHSID4523:tbTableToolbar:new' and @title='New']/a")
	public WebElement btn_newBKChapter;
	
	@FindBy(xpath = "//label[text()='Court District']/../..//td/select")
    public WebElement lst_courtDistrict;
	
	@FindBy(xpath = "//label[text()='Case Number']/../..//td/input")
    public WebElement txt_caseNumber;
	
	@FindBy(xpath = "//label[text()='Status']/../..//td/select")
    public WebElement lst_status;
	
	@FindBy(xpath = "//label[text()='Filing Date']/../..//td/input")
    public WebElement txt_filingDate;
	
	@FindBy(xpath = "//a[text()='CONTRACT LIST']")
    public WebElement tab_contractList;
	
	@FindBy(xpath = "//h1[text()='Address List']//.././../../../../../../../../../div//img[@title='New']")
	public WebElement cb_NewAddressList;
	
	@FindBy(xpath = "//label[text()='Address Type']/../../td/select")
	public WebElement lst_AddressType;
	
	@FindBy(xpath = "//input[@name='tf_s_yd_ab1']")
	public WebElement txt_City;
	
	@FindBy(xpath = "//img[@id='bSr_s_yd_ab1::icon']/..")
	public WebElement btn_SearchCity;
	
	@FindBy(xpath = "//img[@id='srchDlg:s_be8_aaj:tbTableToolbar:find::icon']//..")
	public WebElement btn_SearchDialog;
	
	public String tbl_CityPostalCodeDirectory_SearchDialog="(//div[@id='srchDlg:s_be8_aaj:innerTbl::db']//table//tr//td//a[text()='%s']/../../..//td//span)[1]";
	
	@FindBy(xpath = "//span[text()='Valid Address.']")
	public WebElement btn_ValidateAddress;

	@FindBy(xpath = "//button[text()='setValidate']")
	public WebElement btn_SetValidate;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement btn_Confirm;
	
	@FindBy(xpath = "//input[@id='srcId:s_be8_aaj:innerTbl:cjucode::content']")
	public WebElement txt_Code;
	
	@FindBy(xpath = "//input[@id='srcId:s_be8_aaj:innerTbl:cjulibelle::content']")
	public WebElement txt_Name;
	
	@FindBy(xpath = "//tr[@id='secId:mainBody:s_zn_aap']/td//label[text()='DBA/AKA']")
	public WebElement lbl_DBAAKA;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:s_zn_aap::content']")
	public WebElement txt_DBAAKA;
	
	@FindBy(xpath = "//img[@id='srcId:s_be8_aaj:tbTableToolbar:find::icon']")
	public WebElement btn_Search_SearchDialog;
	
	public String vfy_AddressType= "//label[text()='%s']/../../td[2]//select";
	
	public String vfy_AddressDetails= "//label[text()='%s']/../../td[2]//input";
	
	@FindBy(xpath = "//img[@title='Next page']")
	public WebElement btn_TableNext;
	
	@FindBy(xpath = "//button[@id='s_u4_aav' and @title='Close']")
	public WebElement btn_Close_ChangePhase;
	
	@FindBy(xpath = "//select[@id='secId:mainBody:s_zn_aan::content']")
	public WebElement vfy_Step_IdentityTab;
	
	public String tbl_Assent = "//div[text()='%s']/../../../tr[2]/th[%s]//span//select";
	public String tbl_AssentDate = "//div[text()='%s']/../../../tr[2]/th[%s]//span//input";

	@FindBy(xpath = "//label[text()='Select Template']/../..//td/select" )
	public WebElement lst_SelectTemplate;
	
	@FindBy(id="eventReport:eventReportText:s_u4_aao")
	public WebElement vfy_ChangeTradenamePastEvent;
	
	@FindBy(xpath = "//label[text()='Assent Status']/../../td[2]/select")
	public WebElement lst_AssentStatus;
	
	@FindBy(xpath = "//label[text()='End Date']/../../td[2]/input")
	public WebElement lst_EndDate;
	
	public String vfy_Assent = "//div//span[text()='%s']/../../../..";
	
	@FindBy(xpath = "//div[@id='secId:mainBody:s_ye_aad']")
	public WebElement vfy_AssentTable;
	
	public String tbl_RowBasedOnAddressType = "//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//span[text()='%s']";
	public String btn_Edit_AddressTable = "//div[@id='secId:mainBody:s_yc_aac:innerTbl::db']//span[text()='%s']/../../../../td/nobr/img";
	public String vfy_AddressType_AddressTab ="//select[@id='secId:mainBody:s_yd_abe::content' and @title='%s']";
	
	@FindBy(xpath = "//label[text()='Birth Date']" )
	public WebElement lbl_BirthDate;
	
	@FindBy(xpath = "//label[text()='Full Name']/../../td/input")
	public WebElement txt_Full_Name;
	
	@FindBy(xpath = "//label[text()='Role']")
	public WebElement lbl_Role_Roletab;
	
	@FindBy(xpath = "//label[text()='Role']/../..//select")
	public WebElement lst_Role_Roletab;
	
	@FindBy(xpath = "//label[text()='Full Name']")
	public WebElement lbl_Full_Name;
	
	@FindBy(xpath = "//label[text()='Phase']/../..//td//select" )
	public WebElement lst_Phase;
	
	@FindBy(xpath = "//label[text()='Start date']")
	public WebElement lbl_Startdate;
	
	@FindBy(xpath = "//label[text()='Start date']/../..//input")
	public WebElement txt_Startdate;
	
	@FindBy(xpath = "//label[text()='End date']")
	public WebElement lbl_Enddate;
	
	@FindBy(xpath = "//label[text()='End date']/../..//input")
	public WebElement txt_Enddate;
	
	@FindBy(xpath = "//tr[@id='secId:mainBody:s_zn_aa5']/td/label[text()='Legal Classification']")
	public WebElement lbl_LegalClassification;
	
	@FindBy(xpath = "//span[@id='secId:mainBody:lbl_s_zn_aa5']/input")
	public WebElement txt_LegalClassification2;
	
	@FindBy(xpath = "//input[@id='secId:s_0q_aao:innerTbl:actcode::content']")
	public WebElement txt_ReferenceCode;
	
	public String tbl_AssentValue="//div[@id='secId:mainBody:s_ye_aad:innerTbl::db']//td//span/span[text()='%s']/../../../..//td//span/span[text()='%s']";

	//added on 5/29/2019
	@FindBy(xpath = "//div[text()='Chapter']/../../../../../..//select")
	public WebElement lst_Chapter;
	
	@FindBy(xpath = "//button[@id='s_u4_aav' and @title='Close']")
	public WebElement btn_Close_Footer;

	@FindBy(xpath = "(//label[text()='Case Number']/../..//td/input)[2]")
    public WebElement txt_caseNumber2;

	@FindBy(xpath = "//select[@id='cont_note:s_1c_aak::content']")
    public WebElement lst_ReasonTradename;
	
	public String vfy_CheckboxValue = "(//div[@id='secId:mainBody:s_ye_aaf:innerTbl::db']//table[@class='xza x102']/tbody//tr//td[2]//span//span[text()='%s']/../../../..//td//span//span//span//img)[%s]";
	public String vfy_CheckboxRowData = "//div[@id='secId:mainBody:s_ye_aaf:innerTbl::db']//table[@class='xza x102']/tbody//tr//span[text()='%s']";
	public String tbl_ColumnVal="//table//span[text()='%s']//../../../../../../../..//div//table//tr[2]//th[%s]//div[2]";
	
	@FindBy(xpath = "//label[text()='Reason']/../../td[2]//select")
    public WebElement lst_ValidationReason;
	
	@FindBy(xpath = "//select[@id='j_id_id13pc8:innerTbl:0:reason::content']")
    public WebElement lst_Reason_telecom;
	
	public String lst_availableAttributes=  "//li[text()='%s']";
	
	@FindBy(xpath = "//label[text()='Change to']")
	public WebElement lbl_ChangeTo_ChangeAttributePage;
	
	@FindBy(xpath = "//label[text()='Change to']/../..//select")
	public WebElement lst_ChangeTo;
	
	public String tbl_Attribute ="//span[text()='%s']/../../../..//span[text()='%s']";
	
}
