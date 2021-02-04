package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Auction extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	

	// Regression
	@Test
	public void Auction_PhysicalAuctionSalefile_052_1() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.navigateAuctionsManagementScreen();
		appFunc.asset_Func.modifyAuctionStatus(data);

	}

	@Test
	public void Auction_ValidateArbitrationProcess_052_2() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.navigateAuctionsManagementScreen();
		appFunc.asset_Func.modifyAuctionStatus(data);

	}

	@Test
	public void Auction_AuctionAndSalefileProcessed_069() throws Throwable {
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.customerInfoChange_func.searchAssetNumber(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.verifyAuctionDetailSection(data);
		appFunc.asset_Func.navigateAuctionsManagementScreen();

		// step09

	}

	@Test
	public void Auction_PhysicalAuctionCreated_070() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.customerInfoChange_func.searchAssetNumber(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.verifyAuctionDetailSection(data);
		appFunc.asset_Func.navigateAuctionsManagementScreen();
		appFunc.asset_Func.modifyAuctionType(data);
		// step09

	}

	@Test
	public void Auction_AuctionArbitrationSR_054() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login", "CRM_Remarketing Agent");
		appFunc.serviceRequest_func.searchFinancialAccount(data);
		appFunc.fraud_func.selectNewServiceRequest(data);
		appFunc.serviceRequest_func.fillServiceRequestDetailsAuction(data);

		appFunc.login_func.fillLoginCRM("Login", "CRM_PaymentProcessing Agent");
		appFunc.fraud_func.retriveAndClickAssignToMe(data);
		appFunc.fraud_func.closeSR();

	}

	@Test
	public void Auction_LeasePostedToSuspense_01() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyAmountPostedToSuspense(data);

	}

	@Test
	public void Auction_AccountStatusPayoff_02() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyStatusOfAccount(data);

	}

	/*
	 * //deferred
	 * 
	 * @Test public void Auction_GainORLossBlackbook_50() throws Throwable{
	 * HashMap<String, String> data =
	 * basePageData.fetchInputData("Auction",getMethod());
	 * appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
	 * appFunc.asset_Func.searchAssetCode(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * 
	 * 
	 * }
	 */
	@Test
	public void Auction_ReCalculategainORLoss_51() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.verifyAuctionListTable(data);
	}

	@Test
	public void Auction_DoubleReconcillationCRM_53() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("Auction", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.clickOnElementTab();
		appFunc.asset_Func.verifyAuctionListTable(data);
	}

	// outof scopee
	/*
	 * @Test public void Auction_ApplicationLease_016_1() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data);
	 * 
	 * //R2952076 }
	 * 
	 * @Test public void Auction_ApplicationRetail_016_2() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data); //steps need to be
	 * done
	 * 
	 * }
	 * 
	 * @Test public void Auction_ApplicationBalloon_016_3() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data);
	 * 
	 * }
	 * 
	 * @Test public void Auction_ApplicationLease_016_4() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data);
	 * 
	 * }
	 * 
	 * @Test public void Auction_ApplicationRetail_016_5() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data);
	 * 
	 * }
	 * 
	 * @Test public void Auction_ApplicationBallon_016_6() throws Throwable{
	 * 
	 * HashMap<String, String> data = basePageData.fetchInputData("Auction",
	 * getMethod()); appFunc.login_func.open_KSIOPurl();
	 * appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
	 * //appFunc.homeScreen_func.clickMenuListItem("Asset", "Asset");
	 * appFunc.customerInfoChange_func.searchAssetNumber(data);
	 * appFunc.asset_Func.clickOnElementTab();
	 * appFunc.asset_Func.verifyAuctionListTable(data);
	 * appFunc.asset_Func.verifyAuctionDetailSection(data);
	 * 
	 * }
	 */
}
