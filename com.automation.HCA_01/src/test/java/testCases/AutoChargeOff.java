package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;
import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class AutoChargeOff extends BaseTestSuite {
	
	BasePageData basePageData = new BasePageData();
	
	/*
	 * Aravind Testcases Start----
	 */
	// Testcase 1
	@Test
	public void AutoChargeOff_VerifyCVFAccount_ChargeOffJobComplete_1() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 2
	@Test
	public void AutoChargeOff_VerifyActiveAccount_ChargeOffJobComplete_2() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

		// Testcase 3
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_01Fraud_053() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 4
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_02TotalLossBKActiveCh7_054() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 5
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_03TotalLossBKCh11_13_055() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}
	// Testcase 6

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_04TotalLossBKDischCh7_056() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 7
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_05TotalLossBKDischCh11_13_057() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 8
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_06TotalLoss_058() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 9
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_07AbandonImpoundBKActiveCh7_059() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 10
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_08AbandonImpoundBKCh11_13_060() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 11

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_08AbandonImpoundBKCh11_13DISCHCh7_061() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 12
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_10AbandonImpoundBKDischCh11_13_062() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}
	// Testcase 13

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_11AbandonImpound_063() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 14
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_12AbandonOtherBKActiveCh7_064() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 15
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_13AbandonOtherBKCh11_13_065() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 16
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_14AbandonOtherBKDischCh7_066() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 17
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_15AbandonOtherBKDischCh11_13_067() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 18
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_16AbandonOther_068() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 19
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_17BKActiveCh7_069() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 20
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_18BKCh11_13_070() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 21
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_19BKDischCh7_071() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}
	/*
	 * Aravind Testcases End----
	 */

	/*
	 * Koyal Testcases Start----
	 */

	// Testcase 22
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_20BKDischCh11_13_072() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 23
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_21Impound_073() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 24
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_22LitigationReplevin_074() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 25
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_23LegalDeptHold_075() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 26
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_24LitigationOther_076() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 27
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_25Deceased_077() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	// Testcase 28
	@Test
	public void AutoChargeOff_VerifyChargeOffReason_27Repo_078() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_28Skip_079() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_28Skip_080() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_29Misc_081() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_01Fraud_082() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_02TotalLossBKActiveCh7_083() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_03TotalLossBKCh11_13_084() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_04TotalLossBKDischCh7_085() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_05TotalLossBKDischCh11_13_086() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_06TotalLoss_087() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_07AbandonImpoundBKActiveCh7_088() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_08AbandonImpoundBKCh11_13_089() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_09AbandonImpoundBKDischCh7_090() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_10AbandonImpoundBKDischCh11_13_091() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_11AbandonImpound_13_092() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_12AbandonOtherBKActiveCh7_093() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_13AbandonOtherBKCh11_13_094() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_14AbandonOtherBKDischCh7_095() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_15AbandonOtherBKDischCh11_13_096() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_16AbandonOther_097() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_17BKActiveCh7_098() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_18BKCh11_13_099() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_19BKDischCh7_100() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_20BKDischCh11_13_101() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_21Impound_102() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_22Impound_103() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_23LegalDeptHold_104() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_24LitigationOther_105() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_25Deceased_106() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_27Repo_107() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_28Skip_108() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_28Skip_109() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_29Misc_110() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_30BKActiveCh7LeaseET_111() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_31BKChLeaseET_112() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_32BKDischCh7LeaseET_113() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_33BKDischCh11_13LeaseET_114() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_34NonBKLeaseET_115() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_35BKActiveCh7LeasePostTermPPTX_116() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_36BKCh11_13LeasePostTermPPTX_117() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_37BKDischCh7LeasePostTermPPTX_118() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_38BKDischCh11_13LeasePostTermPPTX_119() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_39LeasePostTermPPTX_120() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_30BKActiveCh7LeaseET_121() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_31BKCh11_13LeaseET_122() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_32BKDischCh7LeaseET_123() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_33BKDischCh11_13LeaseET_124() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_34NonBKLeaseET_125() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_35BKActveCh7LeasepostTermPPTX_126() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_36BKCh11_13LeasePostTermPPTX_127() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);

	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_37BKDischCh7LeasePostTermPPTX_128() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_38BKDischCh11_13LeasePostTermPPTX_129() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeOffReason_39LeasePostTermPPTX_130() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyChargeAccountStatus_018_3() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}

	@Test
	public void AutoChargeOff_VerifyBlackBookValue_131() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("AutoChargeOff", getMethod());
		appFunc.login_func.open_KSIOPurl();
		appFunc.login_func.fillLoginKSIOP("Login", "Ksiop_Login");
		appFunc.chargeoff_func.verifyChargeOffTableDetails(data);
	}
}
