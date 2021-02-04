package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class ExternalSR extends BaseTestSuite {

	BasePageData basePageData = new BasePageData();

	@Test
	public void ExternalSR_VerifyRetailBackOfficeAgentRequested_Interest_PaymentLetter_002() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("ExternalSR",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_BackofficeAgent");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.serviceRequest_func.fillExternalRequestDetails(data);

	}

	@Test
	public void ExternalSR_VerifyLeaseBackOfficeAgentRequested_Interest_PaymentLetter_002_01() throws Throwable {

		HashMap<String, String> data = basePageData.fetchInputData("ExternalSR",getMethod());
		appFunc.login_func.open_CRMurl();
		appFunc.login_func.fillLoginCRM("Login","CRM_BackofficeAgent");
		appFunc.fraud_func.searchAccountNumAndEnter(data);
		appFunc.fraud_func.fraudNewServiceRequestAndContinue(data);
		appFunc.serviceRequest_func.fillExternalRequestDetails(data);

	}
}
