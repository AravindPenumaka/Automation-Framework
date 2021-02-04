package testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

@SuppressWarnings("unchecked")
public class ApplicationSubmission extends BaseTestSuite{
	
	BasePageData basePageData = new BasePageData();
	
	@Test
	public void ApplicationSubmission_Balloon_AppSubmission_DTK_TC01() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_DealerTrackURL();
		appFunc.login_func.fillLoginDealerTrack("Login", "DealerTrackUser");
		appFunc.applicationSubmission_func.searchDealerList(data);
		appFunc.applicationSubmission_func.clickOnSwitchDealerandSubmitApp();
		appFunc.applicationSubmission_func.fillDealerTrackApplicantDetails(data);
		appFunc.applicationSubmission_func.verifyAppStatusandSubmit(data);
	}
	
	@Test
	public void ApplicationSubmission_Retail_AppSubmission_DTK_TC04() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_DealerTrackURL();
		appFunc.login_func.fillLoginDealerTrack("Login", "DealerTrackUser");
		appFunc.applicationSubmission_func.searchDealerList(data);
		appFunc.applicationSubmission_func.clickOnSwitchDealerandSubmitApp();
		appFunc.applicationSubmission_func.fillDealerTrackApplicantDetails(data);
		appFunc.applicationSubmission_func.verifyAppStatusandSubmit(data);
	}
	
	@Test
	public void ApplicationSubmission_Lease_AppSubmissionCoApplicant_R1_TC02() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_RouteOneURL();
		appFunc.login_func.fillLoginRouteOne("Login", "RouteOneUser");
		appFunc.applicationSubmission_func.applicantSelection(data);
		appFunc.applicationSubmission_func.fillApplicantDetails(data);
	}
	
	@Test
	public void ApplicationSubmission_Lease_AppSubmission_R1_TC05() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_RouteOneURL();
		appFunc.login_func.fillLoginRouteOne("Login", "RouteOneUser");
		appFunc.applicationSubmission_func.applicantSelection(data);
		appFunc.applicationSubmission_func.fillApplicantDetails(data);
	}
	
	/*********************************************May***********************************************/

	@Test
	public void ApplicationSubmission_RetailIndividual_App_Submission_DTK_TC01() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_DealerTrackURL();
		appFunc.login_func.fillLoginDealerTrack("Login", "DealerTrackUser");
		appFunc.applicationSubmission_func.searchDealerList(data);
		appFunc.applicationSubmission_func.clickOnSwitchDealerandSubmitApp();
		appFunc.applicationSubmission_func.fillDealerTrackApplicantDetails(data);
		appFunc.applicationSubmission_func.verifyAppStatusandSubmit(data);
	}
	
	@Test
	public void ApplicationSubmission_LeaseIndividual_App_Submission_R1_TC02() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_RouteOneURL();
		appFunc.login_func.fillLoginRouteOne("Login", "RouteOneUser");
		appFunc.applicationSubmission_func.applicantSelection(data);
		appFunc.applicationSubmission_func.fillApplicantDetails(data);
	}
	
	@Test
	public void ApplicationSubmission_CoAppRetailIndividual_App_Submission_R1_TC03() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_RouteOneURL();
		appFunc.login_func.fillLoginRouteOne("Login", "RouteOneUser");
		appFunc.applicationSubmission_func.applicantSelection(data);
		appFunc.applicationSubmission_func.fillApplicantDetails(data);
	}
	
	@Test
	public void ApplicationSubmission_RetailJoint_App_Submission_DTK_TC04() throws Throwable{
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_DealerTrackURL();
		appFunc.login_func.fillLoginDealerTrack("Login", "DealerTrackUser");
		appFunc.applicationSubmission_func.searchDealerList(data);
		appFunc.applicationSubmission_func.clickOnSwitchDealerandSubmitApp();
		appFunc.applicationSubmission_func.fillDealerTrackApplicantDetails(data);
		appFunc.applicationSubmission_func.verifyAppStatusandSubmit(data);
	}
	
	@Test
	public void ApplicationSubmission_BalloonIndividual_App_Submission_R1_TC05() throws Throwable {
		
		HashMap<String, String> data = basePageData.fetchInputData("ApplicationSubmission",getMethod());
		appFunc.login_func.open_RouteOneURL();
		appFunc.login_func.fillLoginRouteOne("Login", "RouteOneUser");
		appFunc.applicationSubmission_func.applicantSelection(data);
		appFunc.applicationSubmission_func.fillApplicantDetails(data);
	}
}
