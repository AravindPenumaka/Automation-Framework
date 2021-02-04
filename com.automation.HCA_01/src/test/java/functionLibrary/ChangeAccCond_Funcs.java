package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class ChangeAccCond_Funcs extends BasePageMod  {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	

	
	public ChangeAccCond_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	public void enterChangeAccountCondition(HashMap<String, String> data) throws Throwable {
		List<String> reportData =  new ArrayList<String>();
		highLightElement(appPages.accCondChange_page.lnk_ConditionChange);
		reportData.add(click(appPages.accCondChange_page.lnk_ConditionChange, "ConditionChange Link"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Contract Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Acc Condition"));
		sleep(2000);
		reportData.add(waitForVisibilityOfElement(appPages.accCondChange_page.lbl_AccountCondition, "AccountCondition Label"));
		String accountcondition= data.get("AccountCondition");
		if(data.get("AccountCondition").equals("Payment Hold"))
		{
			reportData.add(click(appPages.accCondChange_page.btn_New, "New Button"));
			reportData.add(select(appPages.accCondChange_page.lst_AccCondition, data.get("AccountCondition") , "From AccountCondtion"));
			reportData.add(click(appPages.accCondChange_page.btn_Finish, "Finish Button"));
			waitForVisibilityOfElement(appPages.accCondChange_page.btn_Close, "Close Button");
			reportData.add(click(appPages.accCondChange_page.btn_Close, "Close Button"));
		}
		else
		{
			reportData.add(click(appPages.accCondChange_page.btn_Cancel, "Cancel Button"));

		}
		reportData.add(switchToDefaultFrameContent());
		sleep(5000);
		createReportTableEntry(reportData, "enterChangeAccountCondition");
		logger.log(LogStatus.INFO, "Successfully Entered Change Acount Condition...",attchedStepScreenShot("Successfully Entered Change Acount Condition","Yes"));
		
	}


}
