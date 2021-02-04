package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalEvents_PageObject {
	
	@FindBy(xpath="//a[text()='Contracts']")
	public WebElement lst_Contracts;
	
	@FindBy(xpath="//table[@id='modulesMenu:s_tu_abl::ScrollContent']//tr[@id='modulesMenu:s_tu_abo']/td[text()='Global Events']")
	public WebElement lnk_GlobalEvents;
	
	@FindBy(xpath="//div[@id='secId:s_bd8_aam']//div[@id='secId:s_bd8_aam:_otrWpr::t']//table[@class='xmf']//div[@id='secId:s_bd8_aam:tbTableToolbar:new']")
	public WebElement btn_NewEventList;
	
	@FindBy(id="tabGeneralitiesEvtGlobCmbEvtGlob:s_bd6_aaf::content")
	public WebElement lst_EventtoRun;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_GeneralInformationNext;
	
	/*@FindBy(xpath="select[@id='s_cbd_1::content']")
	public WebElement lst_InputType;*/
	
	/*@FindBy(xpath="//select[@id='s_cbd_2::content']")
	public WebElement lst_SpreadType;*/
	
	@FindBy(xpath="//select[@name='s_cbd_3']")
	public WebElement lst_PaymentMethod;
	
	@FindBy(xpath="//select[@id='s_cbd_5::content']")
	public WebElement lst_GroupType;
	
	@FindBy(xpath="//input[@id='s_txta_1::content']")
	public WebElement txt_Comments;
	
	@FindBy(xpath="//img[contains(@id,'8:tbTableToolbar:new::icon') and @title='New']")
	public WebElement btn_CheckInformationNew;
	
	public String txt_CheckNumber="//div[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl::db']//tr[%s]//td[3]//input";
	//public WebElement txt_CheckNumber;
	
	public String txt_CheckAmount = "//div[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl::db']//tr[%s]//td[4]//input";
	
	@FindBy(xpath="//input[contains(@id,'0:regdtsaisie::content')]")
	public WebElement txt_EffectiveDate;
	
	@FindBy(xpath="//select[contains(@id,':innerTbl:0:checktype')]")
	public WebElement lst_CheckTypes;
	
	@FindBy(xpath="//input[contains(@id,'0:paymentcount::content')]")
	public WebElement txt_NoOfPayments;
	
	public String txt_CheckInformationComments ="//div[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl::db']//tr[%s]//td[8]//input";
	//public WebElementtxt_CheckInformationComments ;
	
	@FindBy(xpath="//button[@id='button_bar:btnNext']")
	public WebElement btn_CheckInformationNext;
	
	@FindBy(id="j_id_id5pc8:tbTableToolbar:new::icon")
	public WebElement btn_NewPayment;
	
	@FindBy(xpath="//input[@id='tf_j_id_id2pc9::content']")
	public WebElement txt_AccountNumber;
	
	@FindBy(xpath="//img[@id='bSr_j_id_id2pc9::icon']")
	public WebElement btn_AccountNumberSearch;
	
	@FindBy(xpath="//input[@id='srchDlg:s_be8_aaj:innerTbl:dosnum::content']")
	public WebElement txt_AccountNumber1;
	
	@FindBy(xpath="//img[@id='srchDlg:s_be8_aaj:tbTableToolbar:find::icon']")
	public WebElement btn_AccountNumberSubSearch;
	
	@FindBy(xpath="//button[@id='srchDlg:s_be8_aal']")
	public WebElement btn_ValidateAcctNo;
	
	@FindBy(xpath="//button[@id='button_bar:btnCancel']")
	public WebElement btn_CancelFrame;
	
	@FindBy(xpath="//input[@id='j_id_id4pc9::content']")
	public WebElement txt_PaymentAmt;
	
	@FindBy(xpath="//div[text()='Search Dialog']/../../td[3]//a[@title='Close']")
	public WebElement btn_AccountSearchPopupClose;
	
	@FindBy(id="bSr_j_id_id3pc9::icon")
	public WebElement btn_SearchAccountLogo;
	
	@FindBy(xpath="//label[text()='Consolidated']/../../td[2]//input")
	public WebElement chk_Consolidated;
	
	@FindBy(xpath="//label[text()='Billing Account']/../../td[2]//input")
	public WebElement txt_BillingAccount;
	
	@FindBy(xpath="//label[text()='Check number']/../../td[2]//select")
	public WebElement lst_CheckNumber;
	
	@FindBy(xpath="//label[text()='Payment amount']/../../td[2]//input")
	public WebElement txt_PaymentAmount;
	
	@FindBy(id="j_id_id5pc9::content")
	public WebElement lst_Spread;
	
	@FindBy(xpath="//button[text()='Next']")
	public WebElement btn_PaymentInformationNext;
	
	@FindBy(id="ui-id-1")
	public WebElement btn_CCManagement;
	
	@FindBy(xpath="//ul[@class='bw-sub']//li[text()='Work Process']")
	public WebElement btn_WorkProcess;
	
	@FindBy(xpath="//section[@id='workspace']//section[@class='on']//ul[@class='clr']//input[@data-form-param='ccId']")
	public WebElement txt_CCId;
	
	@FindBy(xpath="//section[@id='workspace']//section[@class='on']//i[@class='bw-icon i-25 i-func-search']")
	public WebElement btn_SearchCCId;
	
	@FindBy(xpath="//input[@class='bw-input ipt-cal a-center w-55 hasDatepicker']")
	public WebElement txt_ProcessDate;
	
	@FindBy(xpath="//tr[@id='gridview-1024-record-ext-record-1']")
	public WebElement lnk_AccountInfo;
	
	@FindBy(xpath="//button[text()=' Exec. CC']")
	public WebElement btn_Execc;
	
	@FindBy(id="secId:tf_j_id_id22pc6::content")
	public WebElement txt_UserCode;
	
	@FindBy(xpath="//button[@id='srcId:s_be8_aam']")
	public WebElement btn_Cancel;
	
	@FindBy(xpath="//img[@id='secId:tblPostingResultsv:j_id_id25pc6:tbTableToolbar:find::icon']")
	public WebElement btn_SearchUserCode;
	
	@FindBy(xpath="//a[@id='secId:tblPostingResultsv:j_id_id25pc6:innerTbl:0:tttlistesociete']")
	public WebElement lnk_Manual;
	
	public String lnk_BatchRef ="(//td/nobr/a[contains(@id,'secId:tblPostingResultBatchsv:j_id_id') and @href='#'])[%s]";
	
	
	@FindBy(xpath="//span[@id='secId:tblPostingResultPaymentsv:j_id_id33pc6:innerTbl:0:tdomtpaid::content']")
	public WebElement txt_Amount;
	
	@FindBy(xpath="//a[@id='s_tu_aa0']")
	public WebElement btn_Logout;
	
	@FindBy(xpath="//input[@id='j_id_id4pc8::content']")
	public WebElement txt_BankoFileUpload;
	
	@FindBy(xpath="//label[text()='Upload Banko File']/../input")
	public WebElement txt_FileUpload;
	
	
	@FindBy(xpath = "//a[text()='Imported BANKO data']")
    public WebElement tab_importedBANKOdata;
	
	//public String tblImportedBANKOdataScreenValue= "//*[@id='j_id_id8pc8:innerTbl::db']/table/tbody/tr[1]/td//span[text()='%s']/../../../../../tr[2]/td//span[text()='%s']/../../../../../tr[3]/td//span[text()='%s']";

	@FindBy(xpath = "//a[text()='Not Imported BANKO data']")
    public WebElement tab_NotImportedBANKOdata;
	
	//public String tblNotImportedBANKOdataScreenValue= "//*[@id='j_id_id10pc8:innerTbl::db']/table/tbody/tr[1]/td//span[text()='%s']";

	@FindBy(xpath = "//label[text()='Events List']")
    public WebElement lbl_EventList;
	
    public String tab_ImportedBANKOdataTest= "//div[@id='j_id_id8pc8:innerTbl::db']//table//tr[%s]//td[4]//nobr//span//span";
    public String tab_NotImportedBANKOdataTest="//div[@id='j_id_id10pc8:innerTbl::db']//table//tr[%s]//td[3]//nobr//span//span";

    @FindBy(xpath="//label[text()='Account number']/../../td[2]//input")
	public WebElement txt_AccountNum;
    
    @FindBy(xpath = "//span[@title='Screen Code : frmListGlobalEvent Template : DT_frmListGlobalEvent']/label")
    public WebElement vfy_GlobalEvents;
    
    @FindBy(xpath = "//label[text()='Batch Amount']/../../td[2]//input")
    public WebElement txt_BatchAmount;

    @FindBy(xpath = "//label[text()='Batch # of checks.']/../../td[2]//input")
    public WebElement txt_BatchNoOfChecks;
    
    @FindBy(xpath = "//div[@title='Check Information']/../../../../../../../../../div//img[@title='New']")
    public WebElement btn_CheckInfoNew;
    
    public String lst_CheckGroupType = "//div[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl::db']//tr[%s]//td[6]//select";
  //  public WebElement lst_CheckGroupType; 

    public String lst_CheckType = "//div[@id='secId:frmManualBatchPosting:j_id_id28pc6:innerTbl::db']//tr[%s]//td[7]//select";
  //  public WebElement lst_CheckType; 
    
    @FindBy(xpath = "//div[@title='Payment Information']/../../../../../../../../../div//img[@title='New']")
    public WebElement btn_PaymentInformationNew;
    
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement btn_Save;
    
    @FindBy(xpath = "//label[text()='Spread type']/../../td[2]//select")
    public WebElement lst_SpreadType;
    
    @FindBy(xpath = "//label[text()='Input Type']/../../td[2]//select")
    public WebElement lst_InputType;
    
    @FindBy(xpath = "//label[text()='File Upload']/../input")
    public WebElement txt_ManualPaymentFileUpload;
    
    @FindBy(xpath = "//h1[text()='Check Information']/../../../../../../../../../../../div/div/div/div/div[1]/div[2]/div/div[2]")
    public WebElement vfy_CheckInformationTable; 
    
    @FindBy(xpath = "//h1[text()='Payment Information']/../../../../../../../../../../../div/div/div/div/div[1]/div[2]/div/div[2]")
    public WebElement vfy_PaymentInformationTable; 
    
    @FindBy(xpath = "//a[text()='Batch list']")
    public WebElement tab_BatchList; 
  
}
