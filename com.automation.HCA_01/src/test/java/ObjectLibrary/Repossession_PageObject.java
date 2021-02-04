package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Repossession_PageObject {
	
	@FindBy(xpath="//span[text()='Repo Type']/../../../td[3]//span")
	public WebElement lst_RepossessionType;
	
	@FindBy(xpath="//span[text()='Repo Reason']/../../../td[6]//span")
	public WebElement lst_RepossessionReason;
	
	@FindBy(xpath="//span[text()='Criteria Override']/../../../td[3]//span")
	public WebElement lst_CriteriaOverride;
	
	@FindBy(xpath="//div[@title='Repossess Vehicle Form Applet']//span[text()='Submit']")
	public WebElement btn_Submit;
	
	@FindBy(xpath="//span[text()='Repo Assigned Date']/../../../td[6]//input")
	public WebElement txt_RepossessionAssignedDate;
	
	@FindBy(xpath="//button//span[text()='Agency Assigned']")
	public WebElement btn_AgencyAssigned;
	
	@FindBy(xpath="//button//span[text()='Submit Condition Report']")
	public WebElement btn_SubmitConditionReport;
	
	@FindBy(xpath="//span[text()='SR #']/../../../td[3]//input")
	public WebElement txt_SRNumber;
	
	@FindBy(xpath="//span[text()='Status']/../../../td[6]//input")
	public WebElement txt_Status;
	
	@FindBy(xpath="//span[text()='Sub Status']/../../../td[5]//input")
	public WebElement txt_SubStatus;
	
	@FindBy(xpath="//button[@title='Repossess Vehicle Menu']")
	public WebElement btn_Settings;
	
	@FindBy(xpath="//span[@class='miniBtnUIC']//a[contains(text(),'Save Record')]")
	public WebElement lst_SaveRecord;
	
	@FindBy(xpath="//span[text()='Sub Type']/../../../td[3]//span")
	public WebElement lst_SubType;
	
	@FindBy(xpath="//span[text()='Contact Name']/../../../td[3]//span")
	public WebElement btn_ContactNameSearch;
	
	@FindBy(xpath="//div[@class='AppletStylePopup']//span[text()='OK']")
	public WebElement btn_ContractOk;
	
	@FindBy(xpath="//span[text()='Revised Redemption Amount']/../../../td[3]//input")
	public WebElement txt_RevisedAmount;
	
	@FindBy(xpath="//button//span[text()='Fetch PayOff Quote']")
	public WebElement btn_FetchPayoffQuote;
	
	@FindBy(xpath="//button[@title='Redemption Service Request:Submit']//span[text()='Submit']")
	public WebElement btn_SubmitRedemptionSR;
	
	@FindBy(xpath="//button//span[text()='Complete Payment Received']")
	public WebElement btn_Completepaymentreceived;
	
	@FindBy(xpath="//button//span[text()='Vehicle Released']")
	public WebElement btn_VehicleReleased;
	
	@FindBy(xpath="//span[text()='Repossessed']/../../../td[3]//input")
	public WebElement cb_RepossessedFlag;
	
	@FindBy(xpath="//span[text()='Reinstated']/../../../td[3]//input")
	public WebElement cb_ReinstatedFlag;
	
	@FindBy(xpath="//span[contains(text(),'New File')]//input[@type='file']")
	public WebElement txt_InputFile;
	
	@FindBy(xpath="//input[@aria-labelledby='HCA_CR_Manually_Attached_Label']")
	public WebElement cb_ManualReportCheckBox;
	
	@FindBy(xpath="//span[text()='Condition Report Date']/../../../td[3]//input")
	public WebElement txt_ConditionReportDate;
	
	@FindBy(xpath="//span[text()='Repo Date']/../../../td[3]//span")
	public WebElement btn_RepoDate;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td[contains(@class,'today')]//a")
	public WebElement lnk_ActiveDate;
	
	@FindBy(xpath="//button[text()='Done']")
	public WebElement btn_Done;
	
	@FindBy(xpath="//button[@title='Address and Contact Details:New' and @data-display='New']")
	public WebElement btn_NewAddress;
	
	@FindBy(xpath="//table[@summary='Address and Contact Details']//tr[2]//td[2]//span")
	public WebElement lst_AddressType;
	
	@FindBy(xpath="//table[@summary='Address and Contact Details']//tr[2]//td[2]//input")
	public WebElement lst_MainAddressType;
	
	//li[text()='Agency Address']  %s  
	
	@FindBy(xpath="//table[@summary='Address and Contact Details']//tr[2]//td[3]//span")
	public WebElement lst_AddressSubType;
	
	@FindBy(xpath="//table[@summary='Address and Contact Details']//tr[2]//td[3]//input")
	public WebElement lst_MainAddressSubType;
	
	//li[text()='Storage Address']  %s
	
	@FindBy(xpath="//td[@id='1_s_2_l_HISNA_Contact_Name']//input")
	public WebElement txt_ContractName;
	
	@FindBy(xpath="//input[@name='HISNA_Other_Contact']")
	public WebElement txt_OtherContract;
	
	@FindBy(xpath="//input[@name='HISNA_Street_Address']")
	public WebElement txt_Street;
	
	@FindBy(xpath="//input[@name='HISNA_Address_City']")
	public WebElement txt_City;
	
	@FindBy(xpath="//td[contains(@id,'State')]//span")
	public WebElement lst_State;
	
	@FindBy(xpath="//td[contains(@id,'State')]//input")
	public WebElement lst_MainState;
	
	//li[text()='CA']  %s
	
	@FindBy(xpath="//td[contains(@id,'Country')]//span")
	public WebElement lst_Country;
	
	@FindBy(xpath="//td[contains(@id,'Country')]//input")
	public WebElement lst_MainCountry;
	
	//li[text()='USA']
	
	@FindBy(xpath="//input[@name='HISNA_Address_Zipcode']")
	public WebElement txt_ZipCode;
	
	@FindBy(xpath="//button[span[text()='Check Fee Assessment']]")
	public WebElement btn_CheckFee;
	
	@FindBy(xpath="//select[@id='j_s_vctrl_div_tabScreen']")
	public WebElement  lst_DropDown;
	
	@FindBy(xpath="//table[@summary='Correspondence']//tr[2]//td[2]")
	public WebElement txt_NOICorrespondence;
	
	@FindBy(xpath="//table[@summary='Correspondence']//tr[2]//td[8]")
	public WebElement txt_NOIStatus;
	
	@FindBy(xpath="//input[@aria-label='Estimated Repo Fees']")
	public WebElement txt_EstimatedRepoFee;
	
	@FindBy(xpath="(//span[text()='Submit'])[1]")
	public WebElement btn_CheckFeeSubmit;
 
	@FindBy(xpath="//input[contains(@aria-label,'Override Reason')]")
	public WebElement txt_OverrideReason;




}
