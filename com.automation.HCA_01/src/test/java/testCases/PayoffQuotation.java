package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class PayoffQuotation  extends BaseTestSuite {

	BasePageData basePageData = new BasePageData();

	@Test
	public void PayoffQuotation_ValidateGoodThroughdate_ActiveRetailAccount_1() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.verifyGoodThroughDays(data);
	}
	
	@Test	
	public void PayoffQuotation_ValidateGoodThroughdate_Lease_DueDateLessThan10Dys_2() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		//appFunc.fraud_func.verifyGoodThroughDays(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_NotAllowedForCustomer_AccountInCOState_8() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedToDealer_AccountInFLState_18() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedToInsurance_AccountInPAState_29() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedForCustomer_TerminateAccount_58() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedForCustomer_ChargedOffAccount_59() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedToDealer_ActiveAccountWithBKCond_60() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedToDealer_ActiveAccountWithFraudCond_61() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	
	@Test
	public void PayoffQuotation_ValidateLeaseBuyout_AllowedToInsurance_hargedOffAccount_67() throws Throwable{

		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_CollectionDepartment");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.fraud_func.fillServiceRequestSubType(data);
		appFunc.fraud_func.verifySectionUnderSRType();
		appFunc.fraud_func.fillBuyoutquoteDetails(data);
	}
	
	
	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_01() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}
	
	
	@Test
	public void PayoffQuotation_ValidatePayoffQuote_CustoemrRequset_04() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidatePayoffQuote_DealerRequset_05() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidatePayoffQuote_InsuranceRequset_06() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_DuedatelessThan10_07() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}

	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_DuedategreaterThan10_08() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}

	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_MaturitydatelessThan10_09() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}

	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_MaturitydateGreaterThan10_10() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}
	
	@Test
	public void PayoffQuotation_ValidateGoodThroughDate_MaturitydateGreaterThan10_11() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.verifyGoodThroughDays(data);
	}

	@Test
	public void PayoffQuotation_ValidateDCBuyOutState_14() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}
	
	
	/**********************************PayOff quotation May****************************************/
	
	@Test
	public void PayoffQuotation_ValidateClientTotalAmount_01() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateDealerTotalAmount_02() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseClientTotalAmount_04() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseClientTotalAmount_05() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceTotalAmount_06() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeasePastMaturityAccount_12() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseCOStateAccount_13() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseDCStateAccount_14() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseFLStateAccount_15() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseHIStateAccount_16() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseINStateAccount_17() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeasePAStateAccount_18() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseSCStateAccount_19() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseSDStateAccount_20() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateDealerCOStateTotalAmount_21() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseDCStateTotalAmount_22() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseFLStateTotalAmount_23() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseHIStateTotalAmount_24() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseINStateTotalAmount_25() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeasePAStateTotalAmount_26() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseSCStateTotalAmount_27() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseSDStateTotalAmount_28() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseCOStateTotalAmount_29() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceDCStateTotalAmount_30() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceFLStateTotalAmount_31() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceHIStateTotalAmount_32() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceINStateTotalAmount_33() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsurancePAStateTotalAmount_34() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceSCStateTotalAmount_35() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateLeaseInsuranceSDStateTotalAmount_36() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailCOStateTotalAmount_37() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailDCStateTotalAmount_38() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailFLStateTotalAmount_39() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailHIStateTotalAmount_40() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailINStateTotalAmount_41() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailPAStateTotalAmount_42() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailSCStateTotalAmount_43() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateRetailSDStateTotalAmount_44() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateBKStateAccountTotalAmount_45() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateFraudStateAccountTotalAmount_46() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateTerminateConditionAccountTotalAmount_47() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateChargedOffConditionAccountTotalAmount_48() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateInsuranceAccountTotalAmount_49() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillDealerandInsuranceEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateInsuranceAccountRedemptionQuoteAmount_50() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_ValidateInsuranceAccountReinstatementAmount_51() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillGlobalEventListAndContractDetails(data);
		appFunc.payoffQuotation_func.fillEarlyPayoffDetails(data);
	}

	@Test
	public void PayoffQuotation_validateCustomerRequestPayoffQuoteHistory_52() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillContractSearch(data);
		appFunc.payoffQuotation_func.navigateQuotationtabandVerifyData(data);
	}

	@Test
	public void PayoffQuotation_validateDelaerRequestPayoffQuoteHistory_53() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillContractSearch(data);
		appFunc.payoffQuotation_func.navigateQuotationtabandVerifyData(data);
	}

	@Test
	public void PayoffQuotation_validateDelaerRequestPayoffQuoteHistory_54() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillContractSearch(data);
		appFunc.payoffQuotation_func.navigateQuotationtabandVerifyData(data);
	}
	@Test
	public void PayoffQuotation_validateCustomerRequestPayoffQuoteHistory_62() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillContractSearch(data);
		appFunc.payoffQuotation_func.navigateQuotationtabandVerifyData(data);
	}

	@Test
	public void PayoffQuotation_validateCustomerRequestBuyoutQuoteHistory_63() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PayoffQuotation", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.payoffQuotation_func.fillContractSearch(data);
		appFunc.payoffQuotation_func.navigateQuotationtabandVerifyData(data);
	}

}
