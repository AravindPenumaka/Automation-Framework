package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy;
import pageDataFactory.BasePageData;

public class LogOut_Funcs extends BasePageMod {
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	
	
	public LogOut_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	/***
	 * @author Arvind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To logout from CRM application
	 */
	@SuppressWarnings("unchecked")
	public void logOutCRM() throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(click(appPages.fraud_page.lst_CrmSettingIcon, "CRMSettingIcon Button"));
	    sleep(2000);
	    reportData.add(acceptAlert("Confirmation PopUp"));
		reportData.add(click(appPages.fraud_page.lnk_Crm_Logout, "CRMLogOut Button"));
		createReportTableEntry(reportData, "logOutCRM");
		logger.log(LogStatus.INFO, "Successfully Logged-Out CRM Application",attchedStepScreenShot("Successfully Logged-Out CRM Application","Yes"));
	}
	
	/***
	 * @author Brahma
	 * @throws Throwable
	 * @description To logout from KSIOP application
	 */
	@SuppressWarnings("unchecked")
	public void logOutKSIOP() throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		switchToDefaultFrameContent();
		reportData.add(click(appPages.homeScreen_page.btn_LogOutKSIOP, "KsiopLogOut Button" ));
		sleep(2000);
		driver.close();
		reportData.add("Pass" + "~" + "close" + "~" + "Current Window" + "~" + "  ");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(tabs.size() - 1));
		reportData.add("Pass" + "~" + "switch To" + "~" + "Default Window" + "~" + "  ");
		createReportTableEntry(reportData, "logOutKSIOP");
		logger.log(LogStatus.INFO, "Successfully Logged-Out KSIOP Application",attchedStepScreenShot("Successfully Logged-Out KSIOP Application","Yes"));
	}
	
	
}
