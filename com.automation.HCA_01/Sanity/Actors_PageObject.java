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
	
	
	@FindBy(xpath = "//a[@id='ACTEUR_EVACT_MODADDR_GLOBAL_run166744487']//span[text()='Modify Address']")
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
	
	@FindBy(xpath = "//a[text()='Role']" )
	public WebElement tab_Role;
	
	@FindBy(xpath = "//h1[text()='List of Roles']" )
	public WebElement lbl_RoleList;
	
	@FindBy(xpath = "//label[text()='Last name']/../..//td/input" )
	public WebElement lbl_LastName;
	
	@FindBy(xpath = "(//td[@class='x51']//span//div//div//a//span[text()='More >>'])[1]" )
	public WebElement lnk_More;
	
	@FindBy(id="secId:mainBody:s_yb_aac::tabh::eoi" )
	public WebElement btn_MoreActorOption;
	
	@FindBy(xpath = "(//span[text()='Change tradename'])[2]" )
	public WebElement lnk_ChangeTradeName;
	
	@FindBy(id="cont_note:s_zn_aam::content")
	public WebElement txt_LastName;
	
	@FindBy(xpath = "//div[@id='basicPopupPanelWindowId']//a[@title='Close']")
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
	
	@FindBy(xpath = "//a[text()='Role']" )
	public WebElement tab_role;
	
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
	

	@FindBy(xpath = "//a[@id='secId:mainBody:s_bf7_aal:innerTbl:10:tevlibelle']")
	public WebElement lnk_PastEvent;
	
	@FindBy(xpath = "//div[@id='eventReport:eventReportText:s_u4_aao']//div")
	public WebElement vfy_PastEventData;
	
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
	
//	public String tab_ActorSubTabs = "//div[@id='secId:mainBody:s_yb_aac::tabh']//a[text()='%s']";
	public String tab_ActorSubTabs = "//div[@id='secId:mainBody:s_yb_aac::tabh']//a[text()]";
	
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
	
	
}
