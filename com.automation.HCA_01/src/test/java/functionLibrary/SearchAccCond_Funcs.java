package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.element.ElementNotFoundException;
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class SearchAccCond_Funcs extends BasePageMod {

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;

	public SearchAccCond_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	public void verifyAccountCondition(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		reportData.add(click(appPages.contract_page.tab_GeneralInformation, "Generalinformation Tab"));
		//reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		reportData.add(scrollToView(appPages.searchAccCond_page.txt_acccond, "Account Condition Table"));

		List<String> accCondTblData = new ArrayList<String>();
		accCondTblData.add(data.get("AccountCondition"));
		accCondTblData.add(data.get("SubCondition"));
		if (data.get("StartDate") != "") {
			accCondTblData.add(data.get("StartDate"));
		} else {
			accCondTblData.add(getCurrentDate());
		}
		accCondTblData.add(data.get("EndDate"));
		accCondTblData.add(data.get("CreatedBy"));
		accCondTblData.add(data.get("ModifiedBy"));

		String accCondTableRow = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']";
		String elementAccCondTableHeader = "//table[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::ch::t']";
		String accCondValue = null;
		String accCondHeaderValue = null;
		WebElement accConditionElem = null;
		List<String> accCondTableDataList = new ArrayList<String>();
		try{
			for (int i = 0; i < accCondTblData.size(); i++) {
				if (accCondTblData.get(i) != null && !accCondTblData.get(i).equals("")) {
	
					String elementHeader = "/../..//th[" + (i + 2) + "]/div[2]";
					elementAccCondTableHeader = elementAccCondTableHeader + elementHeader;
					WebElement accCondHeaderElem = getWebelement("XPATH", elementAccCondTableHeader);
					accCondHeaderValue = accCondHeaderElem.getText();
					
					accCondValue = accCondTblData.get(i);
					String element = "/../../../..//td[" + (i + 2) + "]//span[text()='" + accCondTblData.get(i) + "']";
					accCondTableRow = accCondTableRow + element;
					accConditionElem = getWebelement("XPATH", accCondTableRow);
					
					accCondTableDataList.add(accCondHeaderValue + "=" + accCondValue + "\n");
					System.out.println(accCondHeaderValue + "=" + accCondValue + "\n");
				}
			}
		} catch(Exception e){
			String reportString = "Fail" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~" + "Unable To Find The Value Of [" + accCondHeaderValue + "] As [" + accCondValue + "] In Table. For " + accCondTableDataList;
			reportData.add(reportString);
			createReportTableEntry(reportData, "verifyAccountCondition");
		}
		reportData.add("Pass" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~" + "Verified With Table Data Are"+ accCondTableDataList);
		//WebElement accConditionElem = getWebelement("XPATH", accCondTableRow);
		//reportData.add(isPresentAndDisplayed(accConditionElem, "Account Condition Table Value"));
		//reportData.add(scrollToView(accConditionElem, "Account Condition List Item"));
		
		createReportTableEntry(reportData, "verifyAccountCondition");
		logger.log(LogStatus.INFO, "Successfully Verified Account Condition Table Value",
				attchedStepScreenShot("Successfully Verified Account Condition Table Value", "Yes"));
	}

	public void verifyAccountCondition_EndDate(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();

		switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		reportData.add(scrollToView(appPages.searchAccCond_page.txt_acccond, "Account Condition Table"));

		List<String> accCondTblData = new ArrayList<String>();

		accCondTblData.add(data.get("AccountCondition"));
		accCondTblData.add(data.get("SubCondition"));
		accCondTblData.add(data.get("StartDate"));
		accCondTblData.add(data.get("EndDate"));
		accCondTblData.add(data.get("CreatedBy"));
		accCondTblData.add(data.get("ModifiedBy"));

		String accCondTableRow = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']";
		String elementAccCondTableHeader = "//table[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::ch::t']";
		String accCondValue = null;
		String accCondHeaderValue = null;
		WebElement accConditionElem = null;
		List<String> accCondTableDataList = new ArrayList<String>();
		try{
			for (int i = 0; i < accCondTblData.size(); i++) {
				if (accCondTblData.get(i) != null && !accCondTblData.get(i).equals("")) {

					String elementHeader = "/../..//th[" + (i + 2) + "]/div[2]";
					elementAccCondTableHeader = elementAccCondTableHeader + elementHeader;
					WebElement accCondHeaderElem = getWebelement("XPATH", elementAccCondTableHeader);
					accCondHeaderValue = accCondHeaderElem.getText();
					
					String element = "/../../../..//td[" + (i + 2) + "]//span[text()='" + accCondTblData.get(i) + "']";
					accCondTableRow = accCondTableRow + element;
					accConditionElem = getWebelement("XPATH", accCondTableRow);
					
					accCondTableDataList.add(accCondHeaderValue + "=" + accCondValue + "\n");
					System.out.println(accCondHeaderValue + "=" + accCondValue + "\n");
				}
			}
		} catch(Exception e){
			String reportString = "Fail" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~"
					+ "Unable To Find The Value Of [" + accCondHeaderValue + "] As [" + accCondValue + "] In Table. For " + accCondTableDataList;
			reportData.add(reportString);
			createReportTableEntry(reportData, "verifyAccountCondition");
		}
		
		//accCondTableRow = accCondTableRow + "/../../../..//td[6]//span[text()]";
		accCondTableRow = accCondTableRow + "/../../../..//td[5]//nobr//span//span";
		System.out.println(accCondTableRow);
		accConditionElem = getWebelement("XPATH", accCondTableRow);

		//reportData.add(scrollToView(accConditionElem, "AccountCondition EndDate"));
		reportData.add(verifyText(accConditionElem, data.get("EndDate"), "EndDate"));
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "verifyAccountCondition_EndDate");
		logger.log(LogStatus.INFO, "Successfully Verified End-Date Account Condition Table Value",
				attchedStepScreenShot("Successfully Verified End-Date Account Condition Table Value", "Yes"));
	}
	//added 5/30/2019
	
	public void verifyAccountConditionWithGivenData(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
		sleep(2000);
		reportData.add(scrollToView(appPages.searchAccCond_page.txt_acccond, "Account Condition Table"));

		String[] AccountConditionList=data.get("AccountCondition").split(",");
		String[] SubConditionList=data.get("SubCondition").split(",");
		String[] StartDateList=data.get("StartDate").split(",");
		String[] EndDateList=data.get("EndDate").split(",");
		String[] CreatedByList=data.get("CreatedBy").split(",");
		String[] ModifiedByList=data.get("ModifiedBy").split(",");
			
		int n=(AccountConditionList.length)-1;
		String accCondHeaderValue = null;
		WebElement accConditionElem = null;
		String accCondTblValue = null;
		try {
			for (int k = 0; k <= n; k++) {
				String accCondTableRow = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']";
				List<String> accCondTblData = new ArrayList<String>();

				if (AccountConditionList.length != k
						&& !AccountConditionList[(AccountConditionList.length) - 1].equals("")) {
					accCondTblData.add(AccountConditionList[k]);
				} else {
					accCondTblData.add("");
				}

				if (SubConditionList.length != k && !SubConditionList[(SubConditionList.length) - 1].equals("")) {
					accCondTblData.add(SubConditionList[k]);
				} else {
					accCondTblData.add("");
				}

				if (StartDateList.length != k && !StartDateList[(StartDateList.length) - 1].equals("")) {
					accCondTblData.add(StartDateList[k]);
				} else {
					accCondTblData.add("");
				}
				if (EndDateList.length != k && !EndDateList[(EndDateList.length) - 1].equals("")) {
					accCondTblData.add(EndDateList[k]);
				} else {
					accCondTblData.add("");
				}
				if (CreatedByList.length != k && !SubConditionList[(SubConditionList.length) - 1].equals("")) {
					accCondTblData.add(CreatedByList[k]);
				}

				if (ModifiedByList.length != k && !SubConditionList[(SubConditionList.length) - 1].equals("")) {
					accCondTblData.add(ModifiedByList[k]);
				}

				String elementAccCondTableHeader = "//table[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::ch::t']";
				List<String> accCondTableDataList = new ArrayList<String>();
				for (int i = 0; i < accCondTblData.size(); i++) {
					if (accCondTblData.get(i) != null && !accCondTblData.get(i).equals("")) {

						String elementHeader = "/../..//th[" + (i + 2) + "]/div[2]";
						elementAccCondTableHeader = elementAccCondTableHeader + elementHeader;
						WebElement accCondHeaderElem = getWebelement("XPATH", elementAccCondTableHeader);
						accCondHeaderValue = accCondHeaderElem.getText();

						accCondTblValue = accCondTblData.get(i);
						String element = "/../../../..//td[" + (i + 2) + "]//span[text()='" + accCondTblData.get(i)
								+ "']";
						accCondTableRow = accCondTableRow + element;
						accConditionElem = getWebelement("XPATH", accCondTableRow);

						accCondTableDataList.add(accCondHeaderValue + "=" + accCondTblData.get(i) + "\n");
						System.out.println(accCondHeaderValue + "=" + accCondTblData.get(i) + "\n");
					}
				}
				reportData.add("Pass" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~"
						+ "Verified With Table Data Are" + accCondTableDataList);

				/*
				 * accConditionElem = getWebelement("XPATH", accCondTableRow);
				 * reportData.add(isPresentAndDisplayed(accConditionElem,
				 * "Account Condition Table Value"));
				 * reportData.add(scrollToView(accConditionElem,
				 * "Account Condition List Item"));
				 */
			}
		} catch (NoSuchElementException e) {
			String reportString = "Fail" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~"
					+ "Unable To Find The Value Of [" + accCondHeaderValue + "] As [" + accCondTblValue + "] In Table";
			reportData.add(reportString);
			createReportTableEntry(reportData, "verifyAccountConditionWithGivenData");
		} catch (Exception e) {
			System.out.println(e);
			reportData.add("Fail" + "~" + "verifyTableData" + "~" + "AccountConditionTable" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		createReportTableEntry(reportData, "verifyAccountConditionWithGivenData");
		logger.log(LogStatus.INFO, "Successfully Verified Account Condition Table Value",
				attchedStepScreenShot("Successfully Verified Account Condition Table Value", "Yes"));
	}
	
	 public void verifyAccountConditionPaymentHold(HashMap<String, String> data) throws Throwable {
		 List<String> reportData =  new ArrayList<String>();
	 	 reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
	     reportData.add(scrollToView(appPages.searchAccCond_page.lbl_Accountcondition,"AccountCondition Table"));
	     String tbl_rowVal = appPages.searchAccCond_page.tbl_AcntCondPaymentHold;
	     String startDate = getCurrentDate();
	     String tbl_accountConditionRowValue= String.format(tbl_rowVal,data.get("AccountCondition"),startDate);
	     WebElement accConditionElem = getWebelement("XPATH", tbl_accountConditionRowValue);
	     reportData.add(isPresentAndDisplayed(accConditionElem, "AccountCond TableValue"));
	     reportData.add(scrollToView(accConditionElem,"AccountCondition ListItem"));
	     sleep(2000);
	     //scrollToView(appPages.searchAccCond_page.lbl_SettlementMoneyFactor, "SettlementMoneyFactor TextBox");
	    // reportData.add(scrollToView(appPages.searchAccCond_page.lbl_HoldFlag, "Hold Flag"));
	     //reportData.add(click(appPages.searchAccCond_page.cb_HoldFlag, "HoldFlag CheckBox"));
	     reportData.add(switchToDefaultFrameContent());
	     createReportTableEntry(reportData, "verifyAccountConditionPaymentHold");
		 logger.log(LogStatus.INFO, "Successfully verified AccountConditionTableValue");
	 }
	 public void verifyAccountConditionEndDated(HashMap<String, String> data) throws Throwable {
			List<String> reportData = new ArrayList<String>();
			//reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Client Area"));
			reportData.add(click(appPages.contract_page.tab_GeneralInformation, "Generalinformation Tab"));
			reportData.add(scrollToView(appPages.searchAccCond_page.txt_acccond, "Account Condition Table"));

			List<String> accCondTblData = new ArrayList<String>();
			accCondTblData.add(data.get("AccountCondition"));
			accCondTblData.add(data.get("EndDated"));
		

			String accCondTableRow = "//div[@id='secId:mainBody:cont_note:j_id_id2pc24:innerTbl::db']";
			for (int i = 0; i < accCondTblData.size(); i++) {
				if (accCondTblData.get(i) != null && !accCondTblData.get(i).equals("")) {

					String element = "/../../../..//td[" + (i + 2) + "]//span[text()='" + accCondTblData.get(i) + "']";
					accCondTableRow = accCondTableRow + element;
				}
			}
			System.out.println(accCondTableRow);
			WebElement accConditionElem = getWebelement("XPATH", accCondTableRow);

			reportData.add(isPresentAndDisplayed(accConditionElem, "Account Condition Table Value"));
			reportData.add(scrollToView(accConditionElem, "Account Condition List Item"));
			createReportTableEntry(reportData, "verifyAccountCondition");
			logger.log(LogStatus.INFO, "Successfully Verified Account Condition Table Value",
					attchedStepScreenShot("Successfully Verified Account Condition Table Value", "Yes"));
		}

}
