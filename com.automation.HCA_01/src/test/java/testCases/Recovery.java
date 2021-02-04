package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class Recovery extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();

	//may
	@Test
	public void Recovery_verifyStepFieldValue_SettledInFull_067() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyStepFieldValue(data);
	}
	
	@Test
	public void Recovery_verifyStepFieldValue_PaidInFull_096() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyStepFieldValue(data);
	}

	@Test
	public void Recovery_verifyStepFieldValue_Dormant_098() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyStepFieldValue(data);
	}
	
	@Test
	public void Recovery_KSIOPToSendThe1099CFormToTheCustomer_100() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.contracts_func.fillContractSearch(data);
		appFunc.contracts_func.verifyStepFieldValue(data);
		appFunc.homeScreen_func.clickMenuListItem("Collections","Cases List");
		appFunc.contracts_func.verifyFormCheckBox(data);

	}
	
	@Test
	public void Recovery_KSIOPToZeroOuTheAccountBalance_103() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Collections","Cases List");
		appFunc.contracts_func.verifyFormCheckBox(data);
		appFunc.contracts_func.verifyAccountBalance(data);
	}
	
	
	@Test
	public void Recovery_VerifyCRMSendsTheRepoAConditionToKSIOP_147() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("Recovery", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login","Ksiop_Login");
		appFunc.homeScreen_func.clickMenuListItem("Asset","Asset");
		appFunc.asset_Func.searchAssetCode(data);
		appFunc.asset_Func.verifyRepossessionCondition(data);
	}
	
	
} 
