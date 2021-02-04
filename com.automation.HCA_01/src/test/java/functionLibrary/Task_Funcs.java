package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Task_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;

	public Task_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	public void verifyTaskDetails() throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		reportData.add(click(appPages.task_page.cb_SelectReferenceRow, "CheckBox"));
		sleep(2000);
		reportData.add(click(appPages.task_page.btn_Modify, "Modify Button"));
		sleep(6000);
		reportData.add(verifyText(appPages.task_page.tbl_Status, "Active", "Task Staus"));
		reportData.add(verifyFieldAttribute(appPages.task_page.vfy_Task, "value", "", "Task TextBox"));
		reportData.add(verifyFieldAttribute(appPages.task_page.vfy_IssueDate, "value", "", "IssueDate TextBox"));
		reportData.add(verifyFieldAttribute(appPages.task_page.vfy_Memo, "value", "", "MemoTextBox"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyTaskDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Task Details",attchedStepScreenShot("Successfully Verified Task Details", "Yes"));
	}
	
	public void searchReferenceActorCode(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(5000);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Tasks", "Tasks"));

		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(type(appPages.task_page.txt_ReferenceCode, data.get("ActorCode"), "ActorCode TextBox"));
		//reportData.add(select(appPages.task_page.lst_Status, data.get("Status"), "Status List"));
		
		reportData.add(type(appPages.task_page.txt_BaseDateFrom, true, data.get("BaseDateFrom"), "BaseDateFrom TextBox"));
		reportData.add(type(appPages.task_page.txt_BaseDateTo, true, data.get("BaseDateTo"), "BaseDateTo TextBox"));
		sleep(2000);
		reportData.add(click(appPages.task_page.btn_Search, "Search Button"));
		sleep(2000);
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchReferenceActorCode");
		logger.log(LogStatus.INFO, "Successfully Searched Reference Actor Code");

	}
	
	public void verifyTransactionHistory(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Tasks", "Tasks"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Actor Screen"));
		sleep(2000);
		reportData.add(type(appPages.task_page.txt_ReferenceCode, data.get("ActorCode"), "ActorCode TextBox"));
		reportData.add(select(appPages.task_page.lst_Status, "Terminated", "Staus List"));
		reportData.add(type(appPages.task_page.txt_BaseDateFrom, true, data.get("BaseDateFrom"), "BaseDateFrom TextBox"));
		reportData.add(type(appPages.task_page.txt_BaseDateTo, true, data.get("BaseDateTo"), "BaseDateTo TextBox"));
		sleep(2000);
		reportData.add(click(appPages.task_page.btn_Search, "Search Button"));
		sleep(2000);
		reportData.add(scrollToView(appPages.task_page.vfy_TransactionHistory, "TransactionHistory table"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyTransactionHistory");
		logger.log(LogStatus.INFO, "Successfully Verified Transaction History");
	}
	 

}
