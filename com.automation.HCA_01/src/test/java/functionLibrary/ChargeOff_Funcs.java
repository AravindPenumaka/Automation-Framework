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
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class ChargeOff_Funcs extends BasePageMod{
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	
	public String telePhoneNumber;
	public ChargeOff_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Koyal
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description To Select chagreoff list under collection tab
	 */
	public void selectChargeOffListOption(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
		//Modified on 7/2/2019(Charge off list is now displayed under collection not under charge off )
		reportData = concatList(reportData,
				homeScreen_func.clickMenuListItem("Collections","Charge-off List"));
		sleep(2000);
		createReportTableEntry(reportData, "selectChargeOffListOption");
		logger.log(LogStatus.INFO, "Successfully Selected Charge-Off List Option", attchedStepScreenShot("Successfully Selected Charge-Off List Option", "Yes"));

	}
	 
	public void verifyChargeOffTableDetails(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		String RetailContarctNumber = data.get("RetailContractNumber");
		String LeaseContractNumber = data.get("LeaseContractNumber");
		String ChargeOffReason = data.get("ChargeOffReason");
		String ChargeOffStatus = data.get("ChargeOffStatus");
		// Verify the charge off list page
		ArrayList<String> ContractNumberList = new ArrayList<String>();
		if (RetailContarctNumber != null && RetailContarctNumber != "") {
			ContractNumberList.add(RetailContarctNumber);
		}
		if (LeaseContractNumber != null && LeaseContractNumber != "") {
			ContractNumberList.add(LeaseContractNumber);
		}
		for (int i = 0; i <= ContractNumberList.size() - 1; i++) {
			selectChargeOffListOption(data);
			reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Charge Off list Screen"));
			reportData.add(type(appPages.chargeoff_page.txt_ContractNumber, ContractNumberList.get(i), "ContractNumber TextBox"));
			reportData.add(click(appPages.commonSrn_page.btn_Search, "Search Button"));
			sleep(3000);
			
			if(isElementPresent(appPages.commonSrn_page.lbl_SearchDialog)){
				click(appPages.commonSrn_page.btn_CloseSearchDialog,"CloseSearchDialog Button");
				sleep(2500);
			}
			reportData.add(click(appPages.commonSrn_page.btn_Collapsepane, "Collapsepane Button"));
			sleep(1000);
			if(appPages.chargeoff_page.tbl_ChargeOff.getText().contains("No data")){
				reportData.add("Fail" + "~" + "isPresentTable" + "~" + "ChargeOffList" + "~" + "No Table Data Displayed In ChargeOffList Screen" + attchedStepScreenShot("No Data Displayed In ChargeOffList Table"));
			} else {
				if (ChargeOffReason != null && ChargeOffReason != "") {
					reportData.add(verifyTableValue(appPages.chargeoff_page.vfy_ChargeOffReasonVal, ChargeOffReason, "Charge-OffReason"));
				}
				if (ChargeOffStatus != null && ChargeOffStatus != "") {
					reportData.add(verifyTableValue(appPages.chargeoff_page.vfy_ChargeOffStatusVal, ChargeOffStatus, "Charge-OffStatus" ));
				}
			}
			reportData.add(switchToDefaultFrameContent());
		}
		createReportTableEntry(reportData, "verifyChargeOffTableDetails");
		logger.log(LogStatus.INFO, "Successfully Verified Charge-Off Table Details", attchedStepScreenShot("Successfully Verified Charge-Off Table Details", "Yes"));
	}
	
}
