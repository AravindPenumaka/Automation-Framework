package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;
import org.openqa.selenium.support.FindBy;

public class PaymentReversals_Funcs extends BasePageMod {
	
	private static final String String = null;
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	HashMap<String, String> data;
	String locatortype;
	WebElement element;
	List<String> reportData =  new ArrayList<String>();
	
	public PaymentReversals_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description navigate to list of  links display
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void navigatetoListLinks(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		
        switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Screen"));
	    reportData.add(type(appPages.commonSrn_page.txt_Contracts,data.get("ContractNumber"), "ContractNumber Textbox"));
	    reportData.add(click(appPages.commonSrn_page.btn_ContractsSearch,"ContractsSearch Button"));
	    sleep(2000);
	    reportData.add(click(appPages.commonSrn_page.btn_SeachDialogPageSearch,"Search Button"));
	    sleep(2000);
	    reportData.add(click(appPages.commonSrn_page.btn_Validate, "Validate Button"));
	    sleep(4000);
	    reportData.add(click(appPages.receivables_page.btn_LinkSearch, "ReceivableSearch Button"));
	
		createReportTableEntry(reportData, "navigatetoListLinks");
		logger.log(LogStatus.INFO, "Succesfully Navigated to List Links", attchedStepScreenShot("Succesfully Navigated to List Links","Yes"));
	}
	

	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description navigate to RejectColllection Screen
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void navigateToRejectCollections(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		sleep(2000);
		
		reportData.add(click(appPages.receivables_page.lnk_RejectCollections,"RejectCollections Events"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Reject Collection Screen"));
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Reject Collection SubScreen"));
		
		reportData.add(select(appPages.receivables_page.lst_RejectionReason, data.get("RejectionReason").trim(), "RejectionReason Dropdown"));
		
		
		 
		
	   reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button"));
		sleep(3000);
		reportData.add(click(appPages.commonSrn_page.btn_Close,"close Button"));
		
		
		createReportTableEntry(reportData, "navigateToRejectCollections");
		logger.log(LogStatus.INFO, "Succesfully Navigated to Reject Collections", attchedStepScreenShot("Succesfully Navigated to Reject Collections","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  navigate to generate credit note screen
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void navigateToGenerateCreditNoteScreen(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
 	    switchToDefaultFrameContent();
 	
		reportData.add(click(appPages.receivables_page.lnk_GenerateCreditNote,"GeneralCreditNote Link"));
		   sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Generatecreditnote Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Generatecreditnote Sub Screen"));
		reportData.add(click(appPages.receivables_page.cb_Review, "Review Checkbox"));
		
		reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
		
		reportData.add(acceptAlert("Alert Accepted"));
		switchToDefaultFrameContent();
		createReportTableEntry(reportData, "navigateToGenerateCreditNoteScreen");
		logger.log(LogStatus.INFO, "Succesfully Navigated to GenerateCreditNote Screen", attchedStepScreenShot("Succesfully Navigated to GenerateCreditNote Screen","Yes"));
	}
   
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  Opened Required Link
	 * 
	 */
	@SuppressWarnings("static-access")
public void openRequiredLinkForRejection(HashMap<String, String> data) throws Throwable {
		
		List<String> reportData = new ArrayList<String>();
		reportData.add(switchToDefaultFrameContent());
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
		// reportData.add(click(appPages.receivables_page.lbl_PaymentDate,"PaymentDate
		// Label"));
		try {
			int count = driver.findElements(By.xpath(appPages.receivables_page.vfy_RowCount)).size();
			sleep(4000);
			reportData.add(click(appPages.commonSrn_page.btn_Collapsepane, "CollapsePane Button"));
			for (int i = count - 1; i >= 0; i--) {
				reportData.add(switchToDefaultFrameContent());
				reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
				scrollToView(getWebelement("XPATH", String.format(appPages.receivables_page.vfy_LinkAmount, i)), "Scroll");
				String amount = getWebelement("XPATH", String.format(appPages.receivables_page.vfy_LinkAmount, i))
						.getText();
				if (Double.parseDouble(amount) > 0) {
					String rowData = String.format(appPages.receivables_page.vfy_RejectionData, i);
					WebElement tablevalueXpath = getWebelement("XPATH", rowData);
					String titledata = getAttributeValue(tablevalueXpath, "title");
					if (titledata.equalsIgnoreCase("Unchecked")) {
						reportData.add(scrollToView(tablevalueXpath, "scroll"));
						reportData.add(click(tablevalueXpath, "Uncheked Checkbox"));
						sleep(2000);
						reportData.add(switchToDefaultFrameContent());
						if (isElementPresent(appPages.receivables_page.lbl_RejectCollection)) {
							reportData.add(
									switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To CashFlow Screen"));
							String linkval = String.format(appPages.receivables_page.vfy_RequiredLink, i);
							WebElement linkXpath = getWebelement("xpath", linkval);
							scrollToView(linkXpath, "Scroll");
							String fetchedData = linkXpath.getText();
							setValueProperty("Link", fetchedData);
							reportData.add(click(linkXpath, "Reference Number"));
							break;
						} else {
							continue;
						}
					}
				}
			}
		} catch (Exception e) {
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ReceivableTable" + "~" + "Element Not Found."
					+ "~" + getExceptionMessage(e.getMessage()));
		}
		createReportTableEntry(reportData, "openRequiredLinkForRejection");
		logger.log(LogStatus.INFO, "Succesfully Opened Require Link for Rejection",
				attchedStepScreenShot("Succesfully Opened Require Link for Rejection", "Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  verify Rejection status Checkbox
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void verifyRejectCheckbox(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		String  reportString;
		try{
			String RejectionString = String.format(appPages.receivables_page.cb_Rejection, data.get("LinkNum"));
			WebElement RejectCheckboxXpath=getWebelement("xpath", RejectionString);
			reportString=verifyCheckBox(RejectCheckboxXpath,"title", "Checked", "Rejection Checkbox");
			reportData.add(reportString);
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "RejectionCheckBox" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
		createReportTableEntry(reportData, "verifyRejectCheckbox");
		logger.log(LogStatus.INFO, "Succesfully verified Reject Checkbox", attchedStepScreenShot("Succesfully verified Reject Checkbox","Yes"));
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  verify Rejection Table
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void NavigateAndScrollToRejectionTable() throws Throwable{
      List<String> reportData =  new ArrayList<String>();
		
		try{
			String reportString;
		       String Link=getValueProperty("Link");
		        
				String ColumnString= String.format(appPages.receivables_page.vfy_ColumnCount, Link);
				int count=driver.findElements(By.xpath(ColumnString)).size();
				for(int i=1;i<count;i++){
				
					String TableData= String.format(appPages.receivables_page.vfy_TableData, Link,i);
					WebElement tablevalueXpath=getWebelement("xpath",TableData);
					reportData.add(scrollToView(tablevalueXpath,"table Value"));
					
					if(i==(count-1)){
						reportString = "Pass" + "~" + "Scrolled to " + "~" +"all Elements" + "~" + " Present in table" + "";
						reportData.add(reportString);
					}
				}
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "RejectionTable" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
		}
		
	    createReportTableEntry(reportData, "NavigateAndScrollToRejectionTable");
		logger.log(LogStatus.INFO, "Succesfully Navigate And Scroll To Rejection Table", attchedStepScreenShot("Succesfully Navigate And Scroll To Rejection Table","Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  Filling CreditNote Reason
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void fillingCreditNoteReason(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		//added 23 july
		sleep(2000);
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Generatecreditnote Screen"));
		reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To Generatecreditnote Sub Screen"));
		reportData.add(select(appPages.receivables_page.lst_GeneralCreditNoteReason, data.get("CreditNoteReason"),"ReasonForCreditNote Dropdown"));
		reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Next,"Next Button"));
		sleep(2000);
		reportData.add(click(appPages.commonSrn_page.btn_Finish,"Finish Button"));
		reportData.add(click(appPages.commonSrn_page.btn_Close,"Close Button"));
		sleep(2000);
		createReportTableEntry(reportData, "fillingCreditNoteReason");
		logger.log(LogStatus.INFO, "Succesfully filled CreditNote Reason", attchedStepScreenShot("Succesfully filled CreditNote Reason","Yes"));
	}
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  Filling CreditNote Reason
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void verifyInMiscellaneousEntries(HashMap<String, String> data) throws Throwable {

		List<String> reportData = new ArrayList<String>();
		switchToDefaultFrameContent();
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Miscellaneous Screen"));
		reportData.add(click(appPages.receivables_page.tab_UnallocatedEnries, "UnallocatedEnries Tab"));
		reportData.add(
				type(appPages.receivables_page.txt_ContractCode, data.get("ContractNumber"), "ContractCode TewxtBox"));
		reportData.add(click(appPages.receivables_page.btn_ContractCodeSearch, "ContractCodeSearch Button"));
		sleep(3000);
		reportData.add(click(appPages.receivables_page.btn_ContractCodeValidateSearch, "ValidateSearch Button"));
		reportData.add(click(appPages.receivables_page.btn_Validate, "Validate Button"));
		reportData.add(
				verifyTableValue("//div[@id='secId:cont_note:s_xj_aa3:innerTbl::db']//table", "SuspenseAmount Table"));

		createReportTableEntry(reportData, "verifyInMiscellaneousEntries");
		logger.log(LogStatus.INFO, "Succesfully verified in Miscallaneous Entries",
				attchedStepScreenShot("Succesfully verified in Miscallaneous Entries", "Yes"));
	} 
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  validate Reject Collection related Data in Description 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void validateRejectCollectionDescription(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		sleep(2000);
		 reportData.add(isPresentAndDisplayed(appPages.receivables_page.txt_Name, "Name Textbox"));
		 reportData.add(isPresentAndDisplayed(appPages.receivables_page.txt_Item, "Item Textbox"));
		 reportData.add(isPresentAndDisplayed(appPages.receivables_page.txt_PaymentReference, "PaymentReference Textbox"));
		 reportData.add(isPresentAndDisplayed(appPages.receivables_page.txt_Amount, "Amount Textbox"));
		
		createReportTableEntry(reportData, "validateRejectCollectionDescription");
		logger.log(LogStatus.INFO, "Succesfully validated RejectCollection Description", attchedStepScreenShot("Succesfully validated RejectCollection Description","Yes"));
	}
	

	//added on 5/30/2019
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description  Opened Required Link
	 */
	@SuppressWarnings("static-access")
	public void openRequiredLinkForGenerateCreditNoteEvent(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();

		try{
			
			reportData.add(click(appPages.commonSrn_page.btn_Collapsepane, "CollapsePane Button"));
			sleep(2000);
			String Rowcount= String.format(appPages.receivables_page.vfy_RowCountForCreditNote,data.get("ProcessAllocation"));
			int count=driver.findElements(By.xpath(Rowcount)).size();
			
			for(int i=1;i<count;i++){
				String rowData= String.format(appPages.receivables_page.vfy_GeneralCreditNoteLink,data.get("ProcessAllocation"),i);
				WebElement tablevalueXpath=getWebelement("xpath",rowData);
				String titledata= tablevalueXpath.getAttribute("title");
				  
				if(titledata.equalsIgnoreCase("Unchecked")){
					String linkval= String.format(appPages.receivables_page.vfy_getLink,data.get("ProcessAllocation"),i);
					WebElement linkXpath=getWebelement("xpath",linkval);
					String fetchedData=linkXpath.getText();
					setValueProperty("Link", fetchedData);
					reportData.add(click(linkXpath, "Reference Number"));
					break;
				}
				
			   
			}
			
		
		}catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ReceivableTable" + "~" + "Element Not Found." +"~"+getExceptionMessage(e.getMessage()));
		}
	
			
		createReportTableEntry(reportData, "openRequiredLinkForGenerateCreditNoteEvent");
		logger.log(LogStatus.INFO, "Succesfully Opened Require Link for Rejection", attchedStepScreenShot("Succesfully Opened Require Link for Rejection","Yes"));
	}
	//added23 july
		/***
		 * @author Preeti
		 * @param sheetName
		 * @param testCase
		 * @throws Throwable
		 * @description Check fee is  CreditNoted
		 * 
		 */
		@SuppressWarnings("unchecked")
		public void checkFeeCreditNoted(HashMap<String, String> data) throws Throwable{
			List<String> reportData =  new ArrayList<String>();
			 switchToDefaultFrameContent();
			 reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To Cassiope Screen"));
			sleep(3000);
			reportData.add(type(appPages.receivables_page.txt_Number,getValueProperty("Link"), "RecievableNumber Textbox"));
			reportData.add(click(appPages.receivables_page.btn_LinkSearch, "ReceivableSearch Button"));
			sleep(3000);
			reportData.add(scrollToView(appPages.receivables_page.tbl_processAllocation,"ProcessAllocation label"));
			reportData.add(scrollToView(appPages.receivables_page.tbl_unpaidAmt, "unpaidAmt. label"));
			
		
			createReportTableEntry(reportData, "checkFeeCreditNoted");
			logger.log(LogStatus.INFO, "Succesfully checked CreditNoted Fee", attchedStepScreenShot("Succesfully checked CreditNoted Fee","Yes"));
		}
		//added23 july
		/***
		 * @author Preeti
		 * @param sheetName
		 * @param testCase
		 * @throws Throwable
		 * @description PropertyTax and SalesTax exception
		 * 
		 */
		@SuppressWarnings("unchecked")
		public void openRequiredLinkToCheckException(HashMap<String, String> data) throws Throwable{
			List<String> reportData =  new ArrayList<String>();
		
			
			try{
				sleep(2000);
				reportData.add(click(appPages.commonSrn_page.btn_Collapsepane, "CollapsePane Button"));
				sleep(2000);
				String Rowcount= String.format(appPages.receivables_page.vfy_RowCountForCreditNote,data.get("ProcessAllocation"));
				int count=driver.findElements(By.xpath(Rowcount)).size();
				for(int i=1;i<count;i++){
					String rowData= String.format(appPages.receivables_page.lnk_ReceivableTax,data.get("ProcessAllocation"),i);
					WebElement tableLinkXpath=getWebelement("xpath",rowData);
					
					  
				
						String fetchedData=tableLinkXpath.getText();
						setValueProperty("Link", fetchedData);
						reportData.add(click(tableLinkXpath, "Reference Number"));
						break;
					}
					
			}catch(Exception e){
				reportData.add("Fail" + "~" + "isPresentElement" + "~" + "ReceivableTable" + "~" + "Element Not Found." +"~"+getExceptionMessage(e.getMessage()));
			}
		
			
			
		
			createReportTableEntry(reportData, "checkFeeCreditNoted");
			logger.log(LogStatus.INFO, "Succesfully checked CreditNoted Fee", attchedStepScreenShot("Succesfully checked CreditNoted Fee","Yes"));
		}

}
