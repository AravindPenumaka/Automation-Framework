package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceRequest_PageObject {
	
	@FindBy(xpath="//span[text()='New Service Requests']")
	public WebElement lbl_ServiceRequest;
	
	@FindBy(xpath = "//span[@class='siebui-icon-dropdown applet-form-combo applet-list-combo']")
	public WebElement lst_NewServiceRqstArrow;

	public String lst_ServiceRequest="//li[text()='%s']";

	@FindBy(xpath = "//button[contains(@class,'siebui-ctrl-btn appletButton siebui-icon-autosr')]//span[text()='GO']")
	public WebElement btn_NewServiceRqst_GO;
	
	@FindBy(xpath ="//span[text()='SR Information']")
	public WebElement lbl_ServiceRequestInfo;
	
	
	public String lbl_AccountNum ="(//label[text()='%s'])";

	@FindBy(xpath="//a[text()='Financial Accounts']")
	public WebElement tab_FinancialAccounts;
	
	@FindBy(xpath="//a[text()='Financial Account List']")
	public WebElement lbl_FinancialAccountList;
	
	@FindBy(name = "s_vis_div")
	public WebElement lst_FinancialAccount;
	
	@FindBy(id = "s_1_1_1_0_icon")
	public WebElement btn_AccountSearchType;
	
	public String lst_SearchDrpdwnValue = "//li[contains(@class,'ui-menu-item') and text()='%s']";

	@FindBy(name = "s_1_1_2_0")
	public WebElement txt_SearchValue;
	
	@FindBy(xpath="(//button[@title='Financial Accounts:Go'])[2]")
	public WebElement btn_FinancialAccountSearch;
	
	public String lnk_AccountNum = "//a[@name='Account Number' and text()='%s']";
	
	@FindBy(id = "s_1_1_39_0_icon")
	public WebElement btn_PhoneType;
	
	@FindBy(id = "s_2_1_10_0_icon")
	public WebElement btn_InitialReason;
	
	public String cb_AttorneyDetails = "//input[@aria-label='%s']" ;
	
	@FindBy(xpath="//span[text()='Submit']")
	public WebElement btn_ServiceRequestSubmit;
	
	@FindBy(xpath="//span[text()='Go to Financial Account']")
	public WebElement btn_GoToFinancialAccount;
	
	public String cb_AccountCondition = "//input[@aria-label='%s']";
	
	@FindBy(xpath="//select[@aria-label='Third Level View Bar']")
	public WebElement btn_ThirdLevelMoreOption;
	
	@FindBy(xpath="//div[@title='Third Level View Bar']//ul//li//a[text()='Service Requests']")
	public WebElement tab_ServiceRequest;
	
	@FindBy(id = "gview_s_2_l")
	public WebElement vfy_ServiceRequests;
	
	public String lnk_ServiceRequestNumber = "//td[text()='In Progress']/../td[6][text()='%s']/../td[3]//a";
	
	@FindBy(xpath="//a[text()='Service Requests']")
	public WebElement tab_ServiceRequests;
	
	@FindBy(xpath="//a[text()='Service Requests List']")
	public WebElement lbl_ServiceRequestsList;
	
	@FindBy(id = "s_2_1_1_0_icon")
	public WebElement btn_ServiceRequestSearchType;
	
	@FindBy(name = "s_2_1_2_0")
	public WebElement txt_ServiceRequestSearchValue;
	
	@FindBy(xpath="(//button[@title='Service Requests:Go'])[2]")
	public WebElement btn_ServiceRequestSearch;
	
	@FindBy(xpath="//span[text()='Assign SR To Me']")
	public WebElement btn_AssignSRToMe;

	public String lnk_ServiceRequest = "//a[text()='%s']" ;
	
	@FindBy(xpath="//input[@aria-label='Resolution Reason']")
	public WebElement txt_ReasonForClosure;
	
	@FindBy(xpath="//span[text()='Close SR']")
	public WebElement btn_CloseSR;
	
	@FindBy(xpath="//div[text()='Correspondence']")
	public WebElement lbl_Correspondence;
	
	@FindBy(xpath="//button[@title='Correspondence:New']")
	public WebElement btn_NewCorrespondence;
	
	@FindBy(xpath="//input[@name='HISNA_Letter_Type']//../span")
	public WebElement lst_LetterType;
	
	@FindBy(xpath="//input[@name='Organization_Name']/../span")
	public WebElement lst_FulfilledCenter;
	
	@FindBy(xpath="//button[@title='Recipients:New']")
	public WebElement btn_NewRecipients;
	
	@FindBy(xpath="//button[@aria-label='Add Recipients:Add']")
	public WebElement btn_NewRecipientsAdd;
	
	@FindBy(xpath="//button[@title='Correspondence:Submit']")
	public WebElement btn_CorrespondenceSubmit;
	
	@FindBy(xpath="//input[@aria-labelledby='HCA_Contact_Name_Label']//..//span")
	public WebElement btn_ContactName;
	
	@FindBy(xpath="//button[@title='Pick Contact:OK']")
	public WebElement btn_PickContactOk;
	
	public String txt_BankruptcyCaseDeatails="//input[@aria-label='%s']";
	
	//modified on 6/21/2019
	public String tbl_PickContactRow="//table[@summary='Pick Contact']//td[@title='%s']";
	
	@FindBy(xpath="//table[@summary='Pick Contact']//tr//td[@title='Spouse' or @title='Secondary' or contains(@title,'Co')]")
	public WebElement tbl_PickContactRowSecondary;
	
	@FindBy(xpath="//td[@title='Primary']")
	public WebElement lbl_PrimaryContact;
	
	@FindBy(xpath="//span[text()='Towyard/Dealer Name']")
	public WebElement lbl_TowyardDealerName;
	
	@FindBy(xpath="//input[@aria-label='Towyard/Dealer Name']")
	public WebElement txt_TowyardDealerName;
	
	@FindBy(xpath="//span[text()='Address']")
	public WebElement lbl_Address;
	
	@FindBy(xpath="//input[@aria-label='Address']")
	public WebElement txt_Address;

	@FindBy(xpath="//span[@id='Towyard_Phone_Label']")
	public WebElement lbl_Phone;
	
	@FindBy(xpath="//input[@aria-labelledby='Towyard_Phone_Label']")
	public WebElement txt_Phone;
	
	@FindBy(xpath="//span[text()='Notice Received Date']")
	public WebElement lbl_NoticereceivedDate;
	
	@FindBy(xpath="//input[@aria-label='Notice Received Date']")
	public WebElement txt_NoticereceivedDate;
	
	@FindBy(xpath="//span[text()='Daily Storage Amount']")
	public WebElement lbl_DailyStorageAmount;
	
	@FindBy(xpath="//input[@aria-label='Daily Storage Amount']")
	public WebElement txt_DailyStorageAmount;
	
	@FindBy(xpath="//span[text()='Tow Date']")
	public WebElement lbl_TowDate;
	
	@FindBy(xpath="//input[@aria-label='Tow Date']")
	public WebElement txt_TowDate;
	
	@FindBy(xpath="//input[@aria-label='Resolution Reason']")
	public WebElement txt_ResolutionReason;
	
	@FindBy(xpath="//input[@aria-label='Resolution Date']")
	public WebElement txt_ResolutionDate;
	
	@FindBy(xpath="//span[text()='Move To Legal']")
	public WebElement btn_MoveToLegal;
	
	@FindBy(id="1_HISNA_Letter_Type")
	public WebElement txt_LetterType;
	
	@FindBy(id="1_s_4_l_SalesFileName")
	public WebElement txt_Template;
	
	@FindBy(xpath="//td//span[@class='siebui-icon-pick']")
	public WebElement btn_Template;
	
	@FindBy(xpath="//span[text()='Pick Template']")
	public WebElement lbl_PickTemplate;
	
	@FindBy(xpath="//button[@title='Pick Template:OK']")
	public WebElement btn_TemplateOK;
	
	@FindBy(xpath="//span[text()='Add Recipients']")
	public WebElement lbl_AddRecipient;
	
	@FindBy(xpath="//button[@title='Add Recipients:Add']")
	public WebElement btn_AddRecipient;

	@FindBy(id="1_s_4_l_Organization_Name")
	public WebElement txt_FulfilledCenter;
	
	@FindBy(xpath="//input[@name='Organization_Name']//../span")
	public WebElement btn_FulfilledCenter;

	@FindBy(xpath="//button[@title='Correspondence:Generate']")
	public WebElement btn_CorrespondenceGenerate;

	@FindBy(xpath="(//a[text()='Merged'])[1]")
	public WebElement lnk_Merged;
	
	@FindBy(xpath="//div[@id='downloadFileChooseDialog']")
	public WebElement vfy_DownloadPopUp;
	
	@FindBy(xpath="//span[text()='Download']")
	public WebElement btn_Download;
	
	@FindBy(xpath="//span[text()='External Request Details']")
	public WebElement lbl_ExternalRequestDetails;
	
	@FindBy(xpath="//input[@aria-label='Sub Type']")
	public WebElement lst_SubType;
	
	/*@FindBy(xpath="/input[@aria-labelledby='HCA_Reason_Label' and @role='combobox']/../span")
	public WebElement lst_Reason;*/
	
	@FindBy(xpath="//span[text()='Reason']/../../../td[3]//input")
	public WebElement lst_Reason;
	
	@FindBy(xpath="(//textarea[@aria-label='Comments'])[1]")
	public WebElement txt_Comments;
	
	@FindBy(xpath="//input[contains(@aria-label,'Delivery Method')]")
	public WebElement lst_DeliveryMethod;
	
	@FindBy(xpath="//input[contains(@aria-label,'Fax')]")
	public WebElement txt_Fax;
	
	@FindBy(xpath="//input[@aria-labelledby='HCA_Request_Type_Label' and @role='combobox']/../span")
	public WebElement lst_RequestType;
	
	@FindBy(xpath="//input[@aria-labelledby='HCA_Sales_Type_Label' and @role='combobox']/../span")
	public WebElement lst_SaleType;
	
	@FindBy(xpath="//input[@aria-labelledby='HISNA_Sale_Date_Label']")
	public WebElement lst_SaleDate;
//Modified on 
	
	//modified on 6/21/2019
	@FindBy(xpath="(//span[contains(@title,'Show more')])[2]")
	public WebElement btn_Showmore;
	
	@FindBy(xpath="//select[@aria-label='%s']")
	public WebElement btn_ThirdLevelMoreopt;
	
	@FindBy(xpath="//span[contains(@title,'Show less')]")
	public WebElement btn_Showless;
	//modified on 6/25/2019
	@FindBy(xpath="//input[@name='s_2_1_10_0']")
	public WebElement Filed_Status;

	@FindBy(xpath="//input[@name='s_2_1_4_0']")
	public WebElement Chapter;

	@FindBy(xpath="//textarea[@name='s_2_1_8_0']")
	public WebElement Comment; 
	


	@FindBy(xpath="//textarea[@aria-label='Resolution/Reason for Closure<font color=red>*</font>']")
	public WebElement txt_ResolutionReasonForClosure;
	
	@FindBy(xpath="//table[@summary='Pick Template']//td[@title='Legal Referral Request Form_GS.CRM']")
	public WebElement lbl_LegalReferalForm;
	
	public String lst_FiledStatus ="//li[text()='%s']";
	
	@FindBy(xpath="//span[text()='Filing Date']/../../..//div/input")
	public WebElement txt_FilingDate;
}
