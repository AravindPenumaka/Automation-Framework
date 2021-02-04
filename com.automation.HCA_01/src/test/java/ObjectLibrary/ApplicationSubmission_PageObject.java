package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationSubmission_PageObject {
	
	@FindBy(xpath="//td[@class='top']/a[text()='Switch']")
	public WebElement lnk_Switch;
	
	@FindBy(id="TxtState")
	public WebElement txt_StateCode;
	
	@FindBy(xpath="//input[@name='BtnSearch']")
	public WebElement btn_SearchDealer;
	
	@FindBy(xpath="//input[@title='Switch']")
	public WebElement btn_Switch;
	
	@FindBy(id="AppSub")
	public WebElement btn_SubmitApp;
	
	@FindBy(id="app_veh_status_N")
	public WebElement rb_VehicleCondition;
	
	@FindBy(id="app_prod_type_B")
	public WebElement rb_ProductTypeBalloon;
	
	@FindBy(id="app_prod_type_R")
	public WebElement rb_ProductTypeRetail;
	
	@FindBy(id="btnIndiv")
	public WebElement btn_IndividualApplication;
	
	@FindBy(id="app_first_name")
	public WebElement txt_DtFirstName;
	
	@FindBy(id="app_last_name")
	public WebElement txt_DtLastName;
	
	@FindBy(xpath="//input[@id='app_ss_num1']")
	public WebElement txt_SSN1;
	
	@FindBy(xpath="//input[@id='app_ss_num2']")
	public WebElement txt_SSN2;
	
	@FindBy(xpath="//input[@id='app_ss_num3']")
	public WebElement txt_SSN3;
	
	@FindBy(id="app_birth_month")
	public WebElement txt_DateOfBirth;
	
	@FindBy(id="app_street_num")
	public WebElement txt_Street;
	
	@FindBy(id="app_street_name")
	public WebElement txt_StreetName;
	
	@FindBy(id="app_city")
	public WebElement txt_City;
	
	@FindBy(id="app_state")
	public WebElement txt_State;
	
	@FindBy(id="app_zip_code")
	public WebElement txt_ZipCode;
	
	@FindBy(xpath="//table[@id='TABLE9111']//td//input[@id='app_years_at_address']")
	public WebElement txt_YearsAtAddress;
	
	@FindBy(xpath="//table[@id='TABLE9111']//td//input[@id='app_months_at_address']")
	public WebElement txt_MaonthsAtAddress;
	
	@FindBy(xpath="//input[@id='app_mortgage_rent']")
	public WebElement txt_MtgOrRent;
	
	@FindBy(xpath="//input[@id='app_home_phone3']")
	public WebElement txt_Phone3;
	
	@FindBy(xpath="//input[@id='app_other_phone1']")
	public WebElement txt_Phone1;
	@FindBy(xpath="//input[@id='app_other_phone2']")
	public WebElement txt_Phone2;
	@FindBy(xpath="//input[@id='app_other_phone3']")
	public WebElement txt_otherPhone3;
	
	@FindBy(id="app_employer_bus")
	public WebElement txt_EmployedBy;
	
	@FindBy(id="app_home_phone1")
	public WebElement txt_HomePhone;
	
	@FindBy(id="app_bus_phone1")
	public WebElement txt_BussinessPhone;
	
	@FindBy(id="app_years_employed")
	public WebElement txt_YearsEmployed;
	
	@FindBy(id="app_months_employed")
	public WebElement txt_MonthsEmployed;
	
	@FindBy(id="app_salary")
	public WebElement txt_GrossSalary;
	
	@FindBy(id="app_auto_yearList")
	public WebElement lst_VehicleYear;
	
	@FindBy(id="app_auto_makeList")
	public WebElement lst_VehicleMake;
	
	@FindBy(id="app_auto_modelList")
	public WebElement lst_VehicleModel;
	
	@FindBy(id="app_auto_trimList")
	public WebElement lst_VehicleTrim;
	
	@FindBy(xpath="//input[@name='app_terms']")
	public WebElement txt_TermMonths;
	
	@FindBy(xpath="//input[@name='app_price']")
	public WebElement txt_AppPrice;
	
	@FindBy(xpath="//input[@name='app_ttl']")
	public WebElement txt_AppTTL;
	
	@FindBy(xpath="//input[@name='app_sales_tax']")
	public WebElement txt_SalesTax;
	
	@FindBy(xpath="//input[@name='app_invoice_amt']")
	public WebElement txt_Invoice;
	
	@FindBy(xpath="//input[@name='app_mileage']")
	public WebElement txt_Mileage;
	
	@FindBy(xpath="//input[@name='contractTerms_MSRP' or @name='app_msrp']")
	public WebElement txt_MSRP;
	
	@FindBy(xpath="//input[@value='Select Lenders']")
	public WebElement btn_SelectLenders;
	
	@FindBy(xpath="//select[@id='LenderBoxHMF_Subform__HMF__PROGRAMSANDPROMOTIONS_ddlProgramCode']")
	public WebElement lst_ProgramCodeDealerTrack;
	
	@FindBy(xpath="//input[@id='SubmitButton']")
	public WebElement btn_SubmitLenderSpecificData;
	
	@FindBy(xpath="//table[@class='data2 online']//tr[2]//td[1]//input")
	public WebElement cb_ConfirmSubmit;
	
	@FindBy(xpath="//input[@id='btnContinue']")
	public WebElement btn_Continue;
	
	@FindBy(xpath="//input[@class='buttonBig100' and @value='OK']")
	public WebElement btn_PopupOk;
	
	@FindBy(xpath="//*[@id='frmAppSummary']/div[3]/center[2]/table//table//tr[2]//span")
	public WebElement txt_Message;
	
	@FindBy(xpath="//table[@class='main_l']//tr[4]//table//tr[2]//td[5]//a")
	public WebElement btn_LenderStatus;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath="//a[text()='New App']")
	public WebElement lst_NewApp;
	
	@FindBy(xpath="//a[text()='New Individual App']")
	public WebElement lnk_NewIndividualApp;
	
	@FindBy(xpath="//button[@data-id='show_hide_coapp']")
	public WebElement lst_CoApp;
	
	@FindBy(xpath="//div[@class='dropdown-menu open']//span[text()='Yes']")
	public WebElement lst_CoAppSelect;
	
	@FindBy(xpath="//input[@name='primaryApplicant_LastName']")
	public WebElement txt_LastName;
	
	@FindBy(xpath="//input[@name='coApplicant_LastName']")
	public WebElement txt_CoApplicantLastName;
	
	@FindBy(xpath="//input[@name='primaryApplicant_FirstName']")
	public WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@name='coApplicant_FirstName']")
	public WebElement txt_CoApplicantFirstName;
	
	@FindBy(xpath="//input[@name='primaryApplicant_SocialSecurityNumber']")
	public WebElement txt_SSN;
	
	@FindBy(xpath="//input[@name='primaryApplicant_PresentExtendedZipCode']")
	public WebElement txt_ExtendedZipCode;
	
	@FindBy(id="copyToCoApplicant")
	public WebElement btn_CopyApplicatDetails;
	
	@FindBy(xpath="//input[@name='coApplicant_YearsOnPresentJob']")
	public WebElement txt_CoAppTimeAtJobYears;
	
	@FindBy(xpath="//input[@name='coApplicant_MonthsOnPresentJob']")
	public WebElement txt_CoAppTimeAtJobMonths;
	
	@FindBy(xpath="//input[@name='coApplicant_SocialSecurityNumber']")
	public WebElement txt_CoAppSSN;
	
	@FindBy(id="contractTerms_VehicleMake")
	public WebElement lst_Make;
	
	@FindBy(id="contractTerms_VehicleModel")
	public WebElement lst_Model;
	
	@FindBy(id="contractTerms_VehicleStyle")
	public WebElement lst_Style;
	
	@FindBy(xpath="//input[@name='contractTerms_VehicleInceptionMiles']")
	public WebElement txt_InceptionMiles;
	
	@FindBy(xpath="//input[@name='contractTerms_BaseCostPrice']")
	public WebElement txt_CapCost;
	
	@FindBy(xpath="//input[@name='contractTerms_FinanceTerm']")
	public WebElement txt_Term;
	
	@FindBy(xpath="//input[@name='contractTerms_WholesaleOnPurchaseInvoice']")
	public WebElement txt_WholeSaleInvoice;
	
	@FindBy(xpath="//input[@name='contractTerms_MSRP']")
	public WebElement txt_MSRPRouteOne;
	
	@FindBy(xpath="//table[@class='data2 online']//tr[3]//td[1]//input")
	public WebElement cb_Finance;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	public WebElement btn_SubmitOrInquire;
	
	@FindBy(xpath="//select[@name='contractTerms_BureauSource']")
	public WebElement lst_CreditBureau;
	
	@FindBy(xpath="//input[@id='89802227_mirror']")
	public WebElement cb_KiaMotorFinance;
	
	@FindBy(xpath="//select[contains(@name,'PGMCODE')]")
	public WebElement lst_ProgramCode;
	
	@FindBy(xpath="//select[contains(@name,'PROMO')]")
	public WebElement lst_FinancePromotion;
	
	@FindBy(xpath="//textarea[@name='contractTerms_CommentsOther']")
	public WebElement txt_Comments;
	
	@FindBy(xpath="//table[@class='dmTable']")
	public WebElement tbl_CoApplicant;
	
	@FindBy(xpath="//a[text()='SUBMIT (F2)']")
	public WebElement btn_Submit;
	
	@FindBy(xpath="//a[@id='AppStatus']")
	public WebElement btn_AppStatus;
	
	@FindBy(xpath="//input[@value='Joint' or @name='btnJoint']")
	public WebElement btn_JointApplication;
	
	@FindBy(xpath="//td[text()='Relationship to Applicant']/../../tr[2]/td/select")
	public WebElement lst_RelationToApplicant;
	
	@FindBy(id="app_co_first_name")
	public WebElement txt_DtCoAppFirstName;
	
	@FindBy(id="app_co_last_name")
	public WebElement txt_DtCoAppLastName;
	
	@FindBy(id="app_co_ss_num1")
	public WebElement txt_DtCoAppSSN;
	
	@FindBy(id="app_co_birth_month")
	public WebElement txt_DtCoAppDateOfBirth;
	
	@FindBy(xpath="//input[@name='cmdbtncoappaddress' and @type='button']")
	public WebElement btn_CopyApplicantAddress;
	
	@FindBy(id="app_co_mortgage_rent")
	public WebElement txt_CoAppMtgOrRent;
	
	@FindBy(id="app_co_employer_bus")
	public WebElement txt_CoAppEmployedBy;
	
	@FindBy(id="app_co_bus_phone1")
	public WebElement txt_CoAppBussinessPhone;
	
	@FindBy(id="app_co_years_employed")
	public WebElement txt_CoAppYearsEmployed;
	
	@FindBy(id="app_co_months_employed")
	public WebElement txt_CoAppMonthsEmployed;
	
	@FindBy(id="app_co_salary")
	public WebElement txt_CoAppGrossSalary;
	
	@FindBy(xpath="//select[@id='app_ownership_type']")
	public WebElement lst_HousingStatus;

	@FindBy(xpath="//select[@id='app_employed']")
	public WebElement lst_EmployementStatus;

	@FindBy(id="app_salary_type")
	public WebElement lst_SalaryType;

	@FindBy(id="app_co_ownership_type")
	public WebElement lst_CoAppHousingStatus;

	@FindBy(id="app_co_employed")
	public WebElement lst_CoAppEmployementStatus;

	@FindBy(id="app_co_salary_type")
	public WebElement lst_CoAppSalaryType;
	
	
	
	
	
	
	
	

}
