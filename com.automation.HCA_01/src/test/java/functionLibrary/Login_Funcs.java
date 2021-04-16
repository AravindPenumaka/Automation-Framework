package functionLibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import frameworkFactory.BaseTestSuite;
import pageDataFactory.BasePageData;

public class Login_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basePageData = new BasePageData();;
	HashMap<String, String> data;

	public Login_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	public void LoginURL() throws FileNotFoundException, IOException, TestExecException {
		List<String> reportData = new ArrayList<String>();
		openPage("KSIOP_URL");
		driver.manage().window().maximize();
		reportData.add(type(appPages.login_page.UsernameNew, "9492092422", "UserName TextBox"));
		reportData.add(type(appPages.login_page.PasswordNew, "Aravind250298", "UserName TextBox"));
		reportData.add(click(appPages.login_page.SubmitNew, "submit Button"));
		createReportTableEntry(reportData, "LoginSuccess");
	}

	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description To open CRM url
	 */
	public void open_CRMurl() throws Throwable {
		
		openPage("CRM_URL");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			logger.log(LogStatus.PASS, "Switching To Application Window");
		}
	}

	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description To open KSIOP url
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void open_KSIOPurl() throws Throwable {
		openPage("KSIOP_URL");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		String winSize = Integer.toString(tabs.size());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, "Switching To Application Window", "");

		/*LoginURL
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("document.body.style.zoom='100%'");
		 */
	}

	public void open_centerCuturl() throws FileNotFoundException, IOException {
		openPage("CenterCut_URL");
	}

	/***
	 * @author Arvind
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @description To open DealerTrack URL
	 */
	public void open_DealerTrackURL() throws FileNotFoundException, IOException {
		openPage("DealerTrack_URL");
	}

	public void open_WebURL() throws FileNotFoundException, IOException {
		openPage("Web_URL");
	}

	public void fillWebLoginDetails(String sheetName, String testCase) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		data = basePageData.fetchInputData(sheetName, testCase);
		try {
			appPages.web_page.vfy_FeedbackPopUp.isDisplayed();
			reportData.add(
					isPresentAndDisplayed(appPages.web_page.vfy_FeedbackPopUp, "FeedbackPopUp PresentAndDisplayed"));
			reportData.add(click(appPages.web_page.btn_NoThanks, "NoThanksFeedback Button"));
		} catch (NoSuchElementException e) {

		}
		reportData.add(type(appPages.web_page.txt_UserName, data.get("UserName"), "UserName TextBox"));
		reportData.add(type(appPages.web_page.txt_Password, data.get("Password"), "Password TextBox"));
		reportData.add(click(appPages.web_page.btn_LogIn, "LogIn Button"));
		reportData.add(waitForVisibilityOfElement(appPages.web_page.vfy_LogOnScreen, "Web-LogOn Screen"));
		createReportTableEntry(reportData, "fillWebLoginDetails");
		logger.log(LogStatus.INFO, "Successfully Logged-In Web Application",
				attchedStepScreenShot("Successfully Logged-In Web Application", "Yes"));
	}

	/***
	 * @author Arvind
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @description To open RouteOne URL
	 */
	public void open_RouteOneURL() throws FileNotFoundException, IOException {
		openPage("RouteOne_URL");
	}

	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description To get KSIOP login data from excel sheet
	 */
	@SuppressWarnings("unchecked")
	public void fillLoginKSIOP(String sheetName, String testCase) throws Throwable {
		data = basePageData.fetchInputData(sheetName, testCase);
		loginKSIOP(data.get("UserName"), data.get("Password"));
	}

	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To get CRM login data from excel sheet
	 */
	@SuppressWarnings("unchecked")
	public void fillLoginCRM(String sheetName, String testCase) throws Throwable {
		data = basePageData.fetchInputData(sheetName, testCase);
		loginCRM(data.get("UserName"), data.get("Password"));
	}

	/***
	 * @author Barhma
	 * @param UserName
	 * @param Password
	 * @throws Exception
	 * @description fill login details for KSIOP application
	 */
	public void loginKSIOP(String UserName, String Password) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(this.enterUserName(UserName));
		waitForVisibilityOfElement(appPages.login_page.btn_KsiopLogin, "KsiopLogin Button");
		reportData.add(click(appPages.login_page.btn_KsiopLogin, "KsiopLogin Button"));
		reportData.add(waitForVisibilityOfElement(appPages.login_page.img_HomePagelogo, "For KSIOP-HomeScreen Logo"));
		createReportTableEntry(reportData, "fillLoginDetails");
		logger.log(LogStatus.INFO, "Successfully Logged-In KSIOP Application",
				attchedStepScreenShot("Successfully Logged-In KSIOP Application", "Yes"));
	}

	/***
	 * @author Koyal
	 * @param UserName
	 * @param Password
	 * @throws Exception
	 * @description fill login details for CRM application
	 */
	public void loginCRM(String username, String password) throws Exception {
		List<String> reportData = new ArrayList<String>();
		reportData.add(type(appPages.login_page.txt_CRMUsername, username, "UserName TextBox"));
		reportData.add(type(appPages.login_page.txt_CRMPassword, password, "Password TextBox"));
		reportData.add(click(appPages.login_page.btn_CRMLogin, "CRMLogin Button"));
		waitForLoadingIconGone_CRM(60000);
		reportData.add(waitForVisibilityOfElement(appPages.login_page.img_CRMHomePagelogo, "For CRM-HomeScreen Logo"));
		createReportTableEntry(reportData, "fillLoginDetails");
		logger.log(LogStatus.INFO, "Successfully Logged-In CRM Application",
				attchedStepScreenShot("Successfully Logged-In CRM Application", "Yes"));
	}

	/***
	 * @author Brahma
	 * @param UserName
	 * @return
	 * @description enter userName
	 */
	public String enterUserName(String UserName) {
		return type(appPages.login_page.txt_KsiopUserid, UserName, "UserName TextBox");
	}

	/***
	 * @author Arvind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description fill login details for DealerTrack application
	 */
	@SuppressWarnings("unchecked")
	public void fillLoginDealerTrack(String sheetName, String testCase) throws Throwable {
		data = basePageData.fetchInputData(sheetName, testCase);
		List<String> reportData = new ArrayList<String>();
		reportData.add(click(appPages.login_page.btn_LoginMain, "DealerTrackLogin Button"));
		reportData.add(type(appPages.login_page.txt_DealerTrackUsername, data.get("UserName"), "UserName TextBox"));
		reportData.add(type(appPages.login_page.txt_DealerTrackPassword, data.get("Password"), "Password TextBox"));
		reportData.add(click(appPages.login_page.btn_DealerTrackSignin, "SignIn Button"));
		createReportTableEntry(reportData, "fillLoginDealerTrack");
		logger.log(LogStatus.INFO, "Successfully Logged-In DealerTrack Application",
				attchedStepScreenShot("Successfully Logged-In DealerTrack Application", "Yes"));
	}

	/***
	 * @author Arvind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description fill login details for RouteOne application
	 */
	@SuppressWarnings("unchecked")
	public void fillLoginRouteOne(String sheetName, String testCase) throws Throwable {
		data = basePageData.fetchInputData(sheetName, testCase);
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_RouteOneFrame, "RouteOneFrame"));
		reportData.add(type(appPages.login_page.txt_RouteOneUsername, data.get("UserName"), "UserName TextBox"));
		reportData.add(type(appPages.login_page.txt_RouteOnePassword, data.get("Password"), "Password TextBox"));
		reportData.add(click(appPages.login_page.btn_RouteOneLogin, "Login Button"));
		createReportTableEntry(reportData, "fillLoginRouteOne");
		logger.log(LogStatus.INFO, "Successfully Logged-In RouteOne Application",
				attchedStepScreenShot("Successfully Logged-In RouteOne Application", "Yes"));
	}

}
