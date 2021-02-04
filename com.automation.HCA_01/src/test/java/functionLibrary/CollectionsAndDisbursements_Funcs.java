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

public class CollectionsAndDisbursements_Funcs extends BasePageMod {
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	
	public CollectionsAndDisbursements_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description get data from excel sheet.
	 */
	@SuppressWarnings("unchecked")
	public void fillReferenceSearch(HashMap<String, String> data) throws Throwable{
   		System.out.println(data.get("ReferenceNumber"));
   		searchReference(data.get("ReferenceNumber"));
   	}
	
	/***
	 * @author Koyal
	 * @param Referencenumber
	 * @throws Exception
	 * @description search Reference number in Cashflow
	 *              collectionsAndDisbursements page.
	 */
	public void searchReference(String referencenumber) throws Exception {
		List<String> reportData = new ArrayList<String>();
		sleep(2000);
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Cash flow", "Collections and disbursements"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cash Flow Screen"));

		reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
		reportData.add(type(appPages.collectionsAndDisbursements_page.txt_ReferenceNumber, referencenumber, "Reference Number TextBox"));
		reportData.add(click(appPages.contract_page.btn_SearchContract, "SearchContract Button"));
		reportData.add(click(appPages.contract_page.lnk_Contract, "Contract link"));
		reportData.add(switchToDefaultFrameContent());

		createReportTableEntry(reportData, "searchReference");
		logger.log(LogStatus.INFO, "Successfully Searched Reference Number", attchedStepScreenShot("Successfully Searched Reference Number", "Yes"));
	}

}
