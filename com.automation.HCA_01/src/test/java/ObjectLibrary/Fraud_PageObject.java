package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Fraud_PageObject {
		
	public String lnk_AccountNum = "//a[@name='Title' and text()='%s']";
	
	@FindBy(name = "SWEUserName")
	public WebElement userNameCRM;
	
	@FindBy(name = "SWEPassword")
	public WebElement pwdCRM;
	
	@FindBy(xpath = "//a[@un='LoginButton']")
	public WebElement loginCRM;
	
	@FindBy(xpath = "//span[text()='Home:']")
	public WebElement lbl_Home;
	
	@FindBy(xpath = "//div[@id='customSearchIcon']")
	public WebElement lnk_CrmSearch;
	
	@FindBy(xpath = "//input[@title='Account Number']")
	public WebElement txt_SearchAccountNumber;
	
	@FindBy(xpath = "//button[@id='find_field_button']")
	public WebElement lnk_SearchEnter;
	
	public String lnk_AccountNumber = "//a[@name='Title' and text()='%s']";
	
	@FindBy(xpath = "//span[text()='New Service Requests']")
	public WebElement lbl_NewServiceRequest;
	
	@FindBy(xpath = "//input[@aria-label='Subtype']//..//span")
	public WebElement lst_NewServiceRqstArrow;

	@FindBy(xpath = "//button[@type='button' and @title='Financial Account:GO']")
	public WebElement btn_NewServiceRqst_GO;
	
	@FindBy(xpath="//span[@id='Fraud_Label_Label']")
	public WebElement lbl_FraudDetails;
	
	@FindBy(xpath="//input[@aria-label='Fraud Type']//..//span")
	public WebElement lst_FraudTypeArrow;
	
	//Setting Button Icon on the top most corner for Log out
	@FindBy(xpath="//ul[@aria-label='Settings']/li")
	public WebElement lst_CrmSettingIcon;
	
	//log out option in the setting iconlist
	@FindBy(xpath="//button[@title='Logout']")
	public WebElement lnk_Crm_Logout;
	
	
	@FindBy(xpath="//*[contains(@title,'Submit')]")
	public WebElement btn_submitClaim;
	
	
	@FindBy(xpath ="//span[text()='Good Through Days']/../../../td[3]//input")
	public WebElement vfy_GoodThroughDays;
	
	@FindBy(xpath="//input[@name='s_2_1_3_0']")
	public WebElement txt_GoodThroughDays;
	
	public String vfy_GoodThroughDay ="//li[contains(@class,'ui-menu-item') and @id ='ui-id-805']";
	

	@FindBy(xpath="//span[text()='New Service Requests']")
	public WebElement lbl_ServiceRequest;
	
	@FindBy(id="s_1_1_116_0_icon")
	public WebElement btn_PayOffSubType;
	
	@FindBy(xpath="//button[@title='Service Request:Query']")
	public WebElement btn_ServiceRequestQuery;
	
	public String vry_SectionUnderSR="//span[text()='%s']";
	
	@FindBy(xpath ="//span[@id='s_4_1_24_0_icon']")
	public WebElement btn_CallerType;
	
	@FindBy(xpath ="//span[@id='s_4_1_3_0_icon']")
	public WebElement btn_RequestedBy;
	
	@FindBy(xpath ="//span[@id='s_4_1_4_0_icon']")
	public WebElement btn_RequestedFor;
	
	@FindBy(xpath ="//span[@id='s_3_1_22_0_icon' or @id ='s_4_1_22_0_icon']")
	public WebElement btn_Intent;
	
	@FindBy(xpath ="//span[@id='s_4_1_2_0_icon']")
	public WebElement btn_Reason;
	
	public String lst_SRDropdownValue = "//li[contains(@class,'ui-menu-item') and text()='%s']";
	public String lst_CallerType  ="(//li[contains(@class,'ui-menu-item') and text()='%s'])[1]";
	public String lst_RequestedBy  ="(//li[contains(@class,'ui-menu-item') and text()='%s'])[2]";
	public String lst_RequestedFor ="(//li[contains(@class,'ui-menu-item') and text()='%s'])[3]";
	
	@FindBy(xpath ="//td//div//span[text()='Caller Type']")
	public WebElement lbl_CallerType;
	
	public String lst_ServiceRequest="//li[text()='%s']";
	public String lbl_AccountNum ="(//label[text()='%s'])";

	@FindBy(xpath ="//a[text()='Service Requests']")
	public WebElement tab_ServiceRequests;
	
	@FindBy(xpath="//input[@name='s_3_1_28_0']")
	public WebElement lst_FraudType;
	
	@FindBy(xpath="//li[text()='Synthetic ID']")
	public WebElement txt_SynthaticId;
	
	@FindBy(xpath="//input[@name='s_1_1_133_0']")
	public WebElement txt_Status;
	
	@FindBy(xpath="//input[@name='s_1_1_135_0']")
	public WebElement txt_SubStatus;
	
	@FindBy(xpath="//input[@name='s_1_1_131_0']")
	public WebElement txt_SRNo;
	
	@FindBy(xpath="//li[@id='tb_0']")
	public WebElement btn_Settings;
	
	@FindBy(xpath="//button[text()='Logout']")
	public WebElement btn_Logout;
	
	@FindBy(xpath="//a[@class='ui-tabs-anchor']/span[@class='siebui-icon-service_requests_icon siebui-icon-screentab_icon']")
	public WebElement tab_ServiceRequest;
	
	@FindBy(xpath="//select[@name='s_vis_div']")
	public WebElement lst_ServiceRequestList;
	
	@FindBy(xpath="//input[@name='s_2_1_1_0']")
	public WebElement txt_TypeSearch;
	
	@FindBy(xpath="//input[@name='s_2_1_2_0']")
	public WebElement txt_SearchSR;
	
	@FindBy(xpath="//button[contains(@class,'siebui-ctrl-btn siebui-icon-find') and @title='Service Requests:Go']")
	public WebElement btn_SerachSR;
	
	@FindBy(xpath="//button[@title='Service Requests:Assign SR To Me']")
	public WebElement btn_AssignSRToMe;
	
	@FindBy(xpath="//a[@name='SR Number']")
	public WebElement lnk_SRNo;
	
	@FindBy(xpath="//input[@name='s_1_1_133_0']")
	public WebElement txt_OwnerStatus;
	
	@FindBy(xpath="//input[@name='s_1_1_135_0']")
	public WebElement txt_OwnerSubStatus;
	
	@FindBy(xpath="//button[contains(@class,'confirmfraud') and not (@disabled)]/span[text()='Confirm Fraud']")
    public WebElement btn_ConfirmFraud;

	@FindBy(xpath="(//button//span[text()='Close SR' or text()='Close'])[1]")
	public WebElement btn_Close;

	@FindBy(xpath="//input[@aria-labelledby='QueryComboBox_Label']/../span[@class='siebui-icon-dropdown applet-form-combo applet-list-combo']")
	public WebElement btn_ServiceRequestListAppletArw;
	
	@FindBy(xpath="(//li/a[text()='Contacts'])[2]")
	public WebElement tab_Contacts;
	
	@FindBy(xpath="//button/span[text()='Not A Fraud']")
	public WebElement btn_NotFraud;
	
	@FindBy(xpath = "//span[text()='Go to Financial Account']")
	public WebElement btn_FinancialAccounts;
	
	@FindBy(xpath = "//span[text()='Fraud']/../../../td[11]//input")
	public WebElement btn_FraudFlag;
	

}
	        
	