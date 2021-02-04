package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class EOTBilling extends BaseTestSuite {

	BasePageData basePageData = new BasePageData();

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_PullAheadFlagConfirmed_001() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_SCRAFlagConfirmed_002() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_AllPaymentsReceivedConfirmed_003() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CAContractStateRepoFlagChecked_004() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CTContractStateRepoFlagChecked_005() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_MDContractStateRepoFlagChecked_006() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_NYContractStateRepoFlagChecked_007() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_WIContractStateRepoFlagChecked_008() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_LAContractStateRepoFlagChecked_009() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ContractStateNotInCAorCTorMDorNYorWIorLA_010() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CTContractStateAndMaturityLessThan31Days_011() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CTContractStateAndMaturityBetween31and121Days_012()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CTContractStateAndMaturityBetween31and121DaysET_013()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CTContractStateAndMaturityGreaterThan31Days_014()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CAorILContractStateAndMaturityLessThan31Days_015()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CAContractStateAndMaturityGreaterThan31Days_016()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_CAContractStateAndMaturityGreaterThan31DaysFT_017()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ILContractStateAndMaturityGreaterThan31Days_018()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ILContractStateAndMaturityGreaterThan31DaysFT_019()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_NYContractStateAndMaturityLessThan31Days_020()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_NYContractStateAndMaturityGreaterThan31Days_021()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_MDContractStateAndMaturityLessThan31Days_022()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_MDContractStateAndMaturityGreaterThan31Days_023()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_MDContractStateAndMaturityGreaterThan31DaysFT_024()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_LAContractStateAndMaturityLessThan31Days_025()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_LAContractStateAndMaturityGreaterThan31Days_026()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_LAContractStateAndMaturityGreaterThan31DaysFT_027()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ContractStateNotInCAorCTorMDorNYorWIorLAMaturityLessThan31Days_028()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ContractStateNotInCAorCTorMDorNYorWIorLAMaturityGreaterThan31Days_029()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyCalculationTypeandTerminationType_ContractStateNotInCAorCTorMDorNYorWIorLAMaturityGreaterThan31DaysFT_030()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyCalculationTypeAndTerminationType(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_FullyTerminatedAccount_010() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_SCRAAccount_011() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_PullAheadConfirmedAccount_012() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_AllPaymentsreceivedConfirmedAccount_013() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_ALPSaleTypeAccount_014() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_GPOSaleTypeAccount_015() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_NullSaleTypeAccount_016() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_RepoFeeAssessedAccount_017() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_LoyalityFlagCheckedAccount_018() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_ALPSaleTypeAccount_019() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_GPOSaleTypeAccount_020() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountContractState_021() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountOriginationState_022() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountDealerSalesState_023() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountHomeState_024() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountBillingState_025() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountGarageState_026() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountDealerGroundingState_027() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_NullSaleTypeAccount_028() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_FullTerminationAccount_029() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_FullTerminationAccount_030() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_FullTerminationAccount_032() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_ALPSaleTypeAccount_033() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_GPOSaleTypeAccount_034() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountMDDealerSalesState_035() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountCTDealerSalesState_036() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPAOriginationState_037() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPAContractState_038() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPADealerSalesState_039() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPAHomeState_040() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPAAccountandBillingState_041() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPAGarageState_042() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccountPADealerGroundingState_043() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAAccount_044() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_PullAHeadConditionAccount_045() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_PullAHeadandSCRAConditionAccount_046() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTStateAccount_047() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NullSaleTypeAccount_048() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTOriginationandHomeStateAccount_050() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NJOriginationStateAccount_051() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NYorILorMDOriginationStateAccount_052() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NHOriginationStateAccount_053() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_WIOriginationStateAccount_054() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTDealerSaleStateAccount_055() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTDealerSaleStateandSCRAAccount_056() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_EarlyTerminatedAccount_057() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_ALPLeasePurchaseandEarlyTerminationAccount_059() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_GPOandEarlyTerminationAccount_060() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_NullSaleTypeandEarlyTerminationAccount_061() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_RepoFeeAssessedAccount_062() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_LoyalityConditionAccount_063() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_NullSaletypeandEarlyTerminationAccount_064() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_EarlyTerminationAccount_065() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_ALPLeasePurchaseandEarlyTerminationAccount_066() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_GPOandEarlyTerminationAccount_067() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountContractStatePAandEarlyTerminationAccount_068() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_SCRAAccountOriginationStatePAandEarlyTerminationAccount_069()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_EarlyTerminationAccount_070() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_EarlyTerminatedAccount_071() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_PADealerStateEarlyTerminatedSCRAAccount_072() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_PAHomeStateEarlyTerminatedSCRAAccount_073() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_PABillingStateEarlyTerminatedSCRAAccount_074() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_PAGarageStateEarlyTerminatedSCRAAccount_075() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_PADealerGroundStateEarlyTerminatedSCRAAccount_076() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_RepoFeeAssessedEarlyTerminatedAccount_077() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_EarlyTerminatedSCRAAccount_078() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_EarlyTerminatedAccount_079() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_ALPSaleTypeEarlyTerminatedAccount_080() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_GPOSaleTypeEarlyTerminatedAccount_081() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_MDOriginationStateEarlyTerminatedAccount_082() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTOriginationStateEarlyTerminatedAccount_083() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_PAOriginationStateEarlyTerminatedSCARAccount_084() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_PAContractStateEarlyTerminatedSCARAccount_085() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_EarlyTerminatedSCARAccount_086() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_ALPSaleTypeEarlyTerminatedAccount_087() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NullSaleTypeEarlyTerminatedAccount_088() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_GPOSaleTypeEarlyTerminatedAccount_089() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAEarlyTerminatedAccountPADealerSalesState_090() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAEarlyTerminatedAccountPAHomeState_091() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAEarlyTerminatedAccountPAAccountandBillingState_092() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAEarlyTerminatedAccountPAGarageState_093() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_SCRAEarlyTerminatedAccountPADealerGroundingState_094() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_RepoFeeAssessedEarlyTerminatedAccount_095() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_NullSaleTypeandEarlyTerminationAccount_096() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_LoyalityFlagCheckedEarlyTerminationAccount_097() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_EarlyTerminationAccountLAWContractVersion_098() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedEarlyTerminatedAccount_099() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLAGarageAddressEarlyTerminatedAccount_101()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLAHomeAddressEarlyTerminatedAccount_102()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLABillingAddressEarlyTerminatedAccount_103()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLAOriginationAddressEarlyTerminatedAccount_104()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLADealerSaleAddressEarlyTerminatedAccount_105()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLADealerGroundingAddressEarlyTerminatedAccount_106()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedMDorCRorNYorLAContractAddressEarlyTerminatedAccount_107()
			throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NYOriginationandEarlyTerminatedAccount_108() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_CTOriginationandEarlyTerminatedAccount_109() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractGPOSaleTypeGrossDealerPayoffAccount_110() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractNullSaleTypeAccount_111() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractALPSaleTypeAccount_112() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractRepoFeeAssessedAccount_114() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractAccount_115() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractSCRAAccount_116() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractPullAheadConfirmedAccount_117() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractPaymentReceiveConfirmedAccount_118() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_BLCContractLoyalityFlagCheckedAccount_119() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyDispositionFee_BLCContractAccount_120() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_BLCContractAccount_121() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyTurnInFee_RRorREVRRContractTypeAccount_122() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_LoyalityFlagCheckedFullyTerminatedAccount_123() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_LoyalityFlagCheckedEarlyTerminatedAccount_124() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_LoyalityFlagCheckedFullyTerminatedAccount_125() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_LoyalityFlagCheckedEarlyTerminatedAccount_126() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_IONIQ_EWU_FLGFlagCheckedFullyTerminatedAccount_127() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessMileageFee_IONIQ_EWU_FLGFlagCheckedEarlyTerminatedAccount_128() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_ValidateSettlementUI_129() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifyLeaseAgreementInformation(data);
		appFunc.EOTBilling_func.verifySettlementInformation(data);
		appFunc.EOTBilling_func.verifyTaxAmount(data);
		appFunc.EOTBilling_func.verifySettlementLiabilityFields(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForETCalculationType_130() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForFTCalculationType_131() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForCACalculationType_132() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForCTCalculationType_133() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForMDCalculationType_134() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForNYCalculationType_135() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForWICalculationType_136() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForLACalculationType_137() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForPULLAHEADCalculationType_138() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForLOYALCalculationType_139() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForSCRACalculationType_140() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}

	@Test
	public void EOTBilling_VerifySimulationResultForBALOONCalculationType_141() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySimulationResult(data);
	}
	// 141(other amounts Due under lease)
	
	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_FullTerminationAccount_031() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

	@Test
	public void EOTBilling_VerifyExcessWearUseFee_NullSaleTypeAccount_049() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}
	
	@Test
	public void EOTBilling_VerifyDispositionFee_EarlyTerminatedAccount_058() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}
	
	@Test
	public void EOTBilling_VerifyEarlyTerminationFee_RepoFeeAssessedEarlyTerminatedAccount_100() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("EOTBillingNormalandEarly", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.EOTBilling_func.verifySettlementLiablityData(data);
	}

}
