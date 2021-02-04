package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class PaymentProcessing extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	
	@Test
	public void PaymentProcessing_ManualBulkPayments_NonConsolidatedPayment_001() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}
	
	
	@Test
	public void PaymentProcessing_ManualBulkPayments_ConsolidatedPayment_003() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}
	
	
	@Test
	public void PaymentProcessing_ManualBulkPayments_ExcelConsolidatedPayment_004() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}
	
	
	@Test
	public void PaymentProcessing_VerifyPaymentMethodValues_005() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.verifyGroupTypeDropdownValues(data);
	}
	
	
	@Test
	public void PaymentProcessing_VerifySpreadTypeValues_006() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.verifySpreadTypeDropdownValues(data);
	}
	
	
		/****************************Regression May******************************/
	
	@Test
	public void PaymentProcessing_ExcelPayment_Application_002() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}


	@Test
	public void PaymentProcessing_ConsolidatedPayoffSpreadType_Application_010() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}

	@Test
	public void PaymentProcessing_ManualPaymentReceivable_Application_011() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}

	@Test
	public void PaymentProcessing_ManualPaymentReceivable_Application_012() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}

	@Test
	public void PaymentProcessing_ManualPaymentAllotment_Application_013() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}

	@Test
	public void PaymentProcessing_ManualPayedOff_Application_014() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}

	@Test
	public void PaymentProcessing_ManualChargedOff_Application_015() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.fillCheckInformation(data);
		appFunc.globalEvents_func.fillPaymentInformation(data);
		appFunc.logout_func.logOutKSIOP();
		appFunc.login_func.open_centerCuturl();
		appFunc.globalEvents_func.verifyCenterCutData(data);
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyKSIOPData(data);
	}
	
	@Test
	public void PaymentProcessing_ManualPaymentApplication_007() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.globalEvents_func.verifyGroupTypeDropdownValues(data);
	}

	// payment reversal (reversal tab)
	@Test
	public void PaymentProcessing_PR_FeesCreditNoted_TC33() throws Throwable {


		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForGenerateCreditNoteEvent(data);
		appFunc.paymentReversals_func.navigateToGenerateCreditNoteScreen(data);
		appFunc.paymentReversals_func.fillingCreditNoteReason(data);
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		
		//added 23 july
		appFunc.paymentReversals_func.checkFeeCreditNoted(data);

	} 

	@Test
	public void PaymentProcessing_PR_WaivePropertyTax_Fees_TC40() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkToCheckException(data);
		// accept alert Done
		appFunc.paymentReversals_func.navigateToGenerateCreditNoteScreen(data);

	}

	@Test
	public void PaymentProcessing_PR_WaiveSalesTax_Fees_TC41() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		//modified 23july
		appFunc.paymentReversals_func.openRequiredLinkToCheckException(data);
		// accept alert Done
		appFunc.paymentReversals_func.navigateToGenerateCreditNoteScreen(data);
	}

	// payment reversal (cashflow tab)
	@Test
	public void PaymentProcessing_PR_CreateTasktoPaymentTeam_TC05() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.verifyRejectCheckbox(data);

	}

	@Test
	public void PaymentProcessing_PR_ReversePaymentNSF_TC06() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.verifyRejectCheckbox(data);

	}

	@Test
	public void PaymentProcessing_PR_ReversePaymentNSF_ForLease_TC08() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.verifyRejectCheckbox(data);

	}

	@Test
	public void PaymentProcessing_PR_ReversePaymentNSF_ForRetail_TC09() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.verifyRejectCheckbox(data);

	}

	@Test
	public void PaymentProcessing_PR_NSFReverse_TC10() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Miscellaneous entries");
		appFunc.paymentReversals_func.verifyInMiscellaneousEntries(data);

	}

	@Test
	public void PaymentProcessing_PR_UnallocatePaymentToReversePayment_TC14() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.validateRejectCollectionDescription(data);
	}
	@Test
	public void PaymentProcessing_PR_OperateReverseSuspense_TC18() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForRejection(data);
		appFunc.paymentReversals_func.navigateToRejectCollections(data);
		appFunc.homeScreen_func.clickMenuListItem("Cash flow", "Miscellaneous entries");
		appFunc.paymentReversals_func.verifyInMiscellaneousEntries(data);

	}

	@Test
	public void PaymentProcessing_PR_WaiveFeeAndCreditNote_TC28() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForGenerateCreditNoteEvent(data);
		appFunc.paymentReversals_func.navigateToGenerateCreditNoteScreen(data);
		appFunc.paymentReversals_func.fillingCreditNoteReason(data);
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		
		//added 23 july
		appFunc.paymentReversals_func.checkFeeCreditNoted(data);
	}

	@Test
	public void PaymentProcessing_PR_OriginalFeeWaived_TC38() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("PaymentProcessing", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		appFunc.paymentReversals_func.navigatetoListLinks(data);
		appFunc.paymentReversals_func.openRequiredLinkForGenerateCreditNoteEvent(data);
		appFunc.paymentReversals_func.navigateToGenerateCreditNoteScreen(data);
		appFunc.paymentReversals_func.fillingCreditNoteReason(data);
		
		appFunc.homeScreen_func.clickMenuListItem("Receivables", "Receivables");
		
		//added 23 july
		appFunc.paymentReversals_func.checkFeeCreditNoted(data);
	}

}