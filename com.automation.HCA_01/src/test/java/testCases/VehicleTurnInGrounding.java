package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

public class VehicleTurnInGrounding  extends BaseTestSuite {
	BasePageData basePageData = new BasePageData();

	@Test
	public void VehicleTurnInGrounding_VerifyVehicleIsMovedToInventory_027() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyStepInValue(data);
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingOrAssetReturnDate_028() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyGroundingAssetReturnDate(data);//Grounding or asset return date field missing
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingFlagIsSet_029() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.modifyGoundingStatus(data);
	}
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingListHistoryDetails_030() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyGroundingListHistory(data);
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingListHistoryDetails_031() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyStepInValue(data);
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingListHistoryDetails_038() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyStepInValue(data);//function changed
		appFunc.asset_Func.verifyGroundingListHistory(data);
	}
	
	
	@Test
	public void VehicleTurnInGrounding_VerifyVehicleGroundingDetails_058() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyVehicleGroundingDetails(data);	//Dealer grounding date fiels missing in UI
	}
	
	
	@Test
	public void VehicleTurnInGrounding_VerifyDealerContactSection_059() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyDealerContactSection(data);	
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyDealerInformationSection_060() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyDealerInformationSection(data);	
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyVehicleGroundingDetails_061() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyVehicleGroundingDetails(data);	//Dealer grounded date and Actual return date field is missing
	}
	
	
	@Test
	public void VehicleTurnInGrounding_VerifyVehicleInformationSection_062() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyVehicleInformationSection(data);	
	}
	

	@Test
	public void VehicleTurnInGrounding_VerifyAssetPhase_091() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyAssetPhase(data);
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyGroundingDealerInfo_092() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyGroundingDealerInfo(data);
	}
	
	@Test
	public void VehicleTurnInGrounding_VerifyVehicleReturnDate_100() throws Throwable{
		HashMap<String, String> data = basePageData.fetchInputData("VehicleTurnInGrounding", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyCustomerGroundedDate(data);
	}
	
}