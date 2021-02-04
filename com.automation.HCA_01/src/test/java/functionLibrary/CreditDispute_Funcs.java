package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.generic.TestExecException;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class CreditDispute_Funcs extends BasePageMod{
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();
	
	HomeScreen_Funcs homeScreen_func;
	
	
	public CreditDispute_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
		homeScreen_func = new HomeScreen_Funcs(driver, logger);
	}
	
	/***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 */
	
	public void searchCreditDisputeAccountDetails(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		
		
		reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Contracts", "Credit Dispute"));
		reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea,"To Credit Dispute Screen"));
		reportData.add(type(appPages.creditDispute_page.txt_AccountNum, data.get("AccountNumber"),"Account Number TextBox"));
		reportData.add(click(appPages.creditDispute_page.img_Search, "SearchImage Button" ));
		sleep(20000);
		reportData.add(click(appPages.creditDispute_page.img_ExpandCDManagement, "ExpandCDManagement Button" ));
		sleep(20000);
		createReportTableEntry(reportData, "searchCreditDisputeAccountDetails");
		logger.log(LogStatus.INFO, "Succesfully Searched Credit Dispute Account", attchedStepScreenShot("Successfully Searched Credit Dispute Account","Yes"));
	}
	
	
	public void verifyCreditDisputeFields(HashMap<String, String> data) throws Throwable{
		verifyCreditDisputeFieldName(data.get("FieldName"));
		verifyCreditDisputeTableData(data.get("CreditDisputeTableName"));
		verifyCustomerInformationTableData(data.get("CustomerInformationTableName"));
		
	}
	
	
	public void verifyFieldItems(HashMap<String, String> data) throws Throwable{
		verifyCreditDisputeTableData(data.get("CreditDisputeTableName"));
		verifyCreditDisputeFieldName(data.get("FieldName"));
		verifyDelliquencyTableData(data.get("DelliquencyTableName"));
	//changed for business req. column name-acc staus cond. is deleted
	//	verifyParticularAccountConditionTableData(data);
	}
	
	
	public void verifySpecifiedItems(HashMap<String, String> data) throws Throwable{
		verifyCreditDisputeTableData(data.get("CreditDisputeTableName"));
		verifyCreditDisputeFieldName(data.get("FieldName"));	
	}
	
	public void verifyCreditDisputeFieldName(String fieldNameValue) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		List<String> inpDataList = splitInputData(fieldNameValue, ",");
		for(int i = 0;i<inpDataList.size();i++){	
			String fldName = inpDataList.get(i);
			String fieldName1 = String.format(appPages.creditDispute_page.vfy_FieldName, fldName);
			reportData.add(verifyFieldName(fieldName1, fldName));
		}
		createReportTableEntry(reportData, "verifyCreditDisputeFieldName");
	}
	
	
	public void verifyCreditDisputeTableData(String tblFieldValue) throws TestExecException {
		List<String> reportData =  new ArrayList<String>();
		List<String> inpDataList = splitInputData(tblFieldValue, ",");
		for(int i = 0;i<inpDataList.size();i++){
			String tbl_fldname= inpDataList.get(i);
			
			String tblfieldName1 = String.format(appPages.creditDispute_page.vfy_CreditDisputeTable, tbl_fldname);
			reportData.add(verifyTableValue(tblfieldName1,tbl_fldname));
		}
		createReportTableEntry(reportData, "verifyCreditDisputeTableData");
	}

	
	public void verifyCustomerInformationTableData(String tblFieldValue) throws TestExecException{
		List<String> reportData =  new ArrayList<String>();
		List<String> inpDataList = splitInputData(tblFieldValue, ",");
		for(int i = 0;i<inpDataList.size();i++){
			String tbl_fldname= inpDataList.get(i);
			String tblfieldName1 = String.format(appPages.creditDispute_page.vfy_CustomerInfomationTable, tbl_fldname);
			reportData.add(verifyTableValue(tblfieldName1,tbl_fldname));
		}
		createReportTableEntry(reportData, "verifyCustomerInformationTableData");
	}
	

	
    public void verifyDelliquencyTableData(String tblFieldValue) throws TestExecException{
		List<String> reportData =  new ArrayList<String>();
		List<String> inpDataList = splitInputData(tblFieldValue, ",");
		for(int i = 0;i<inpDataList.size();i++){
			String tbl_fldname= inpDataList.get(i);
			String tblfieldName1 = String.format(appPages.creditDispute_page.vfy_Delliquency, tbl_fldname);
			reportData.add(verifyTableValue(tblfieldName1,tbl_fldname));
		}
		createReportTableEntry(reportData, "verifyDelliquencyTableData");
	}
 
    
    public void verifyParticularAccountConditionTableData(HashMap<String, String> data) throws Exception{
    	List<String> reportData =  new ArrayList<String>();
    	reportData.add(verifyText(appPages.creditDispute_page.vfy_AccStatusConditionTable, "", "AccountStatusCondition TableColoumn"));
    	createReportTableEntry(reportData, "verifyParticularAccountConditionTableData");
    }
    
    /*public void verifyParticularAccountConditionTableData(HashMap<String, String> data) throws Exception{
    	String reportString = null;
    	List<String> reportData =  new ArrayList<String>();
    	reportData.add(verifyText(appPages.creditDispute_page.vfy_AccStatusConditionTable, "", "AccountStatusCondition TableColoumn"));
    	 createReportTableEntry(reportData, "verifyParticularAccountConditionTableData");
    	 
    	List<String> inpDataList = splitInputData(data.get("AccountStatusCondition"),",");
    	List<String> inpTableDataList = splitInputData(Acc_condition_value, "/");
  	    Collections.sort(inpDataList); 
  	    Collections.sort(inpTableDataList); 
  	    
  	    for(int i=0;i<inpDataList.size();i++){
  	    	if(Acc_condition_value.trim().toLowerCase().contains(inpDataList.get(i).toLowerCase().trim())){
  	    		System.out.println(inpDataList.get(i)+"present");
  	    		reportString = "Pass" + "~" + "verifyTable" + "~" + inpDataList.get(i) + "~" + "Present";
  	    		reportData.add(reportString);
  	    	}
  	    	else{
  	    		System.out.println(inpDataList.get(i)+"Not Present");
  	    		reportString = "ERROR" + "~" + "verifyTable" + "~" + inpDataList.get(i) + "~" + "Not Present in Table value with : " + Acc_condition_value;
  	    		reportData.add(reportString);
  	    	}
  	    }
    }*/
    
    
    public List<String> fetchUiEcoaVal() throws Exception {
		List<String> reportData =  new ArrayList<String>();
		sleep(3000);
		switchToFrame("__CASSIOPAE_CLIENT_AREA_FRAME_ID__","frame");
    	List<String> list=new ArrayList<String>();
    	try{
    		int sizelength=driver.findElements(By.xpath("//select[@name='secId:cont_note:s_s6_aad:innerTbl:0:ecoa']/option")).size();
            int i;
             for(i=1;i<sizelength;i++)
               {
            	 scrollToView(driver.findElement(By.xpath("//select[@name='secId:cont_note:s_s6_aad:innerTbl:0:ecoa']")), "");
        		 String value=driver.findElements(By.xpath("//select[@name='secId:cont_note:s_s6_aad:innerTbl:0:ecoa']/option")).get(i).getText();
       		     list.add(value);
        	   }
    	} catch(Exception e){
    		reportData.add("Fail" + "~" + "isPresentElement" + "~" + "UiEcoaVal" + "~"
					+ "Unable To Find Element " + getExceptionMessage(e.getMessage()));
    	}
    	
         return list;
	}
    
    public void verifyEcoaValDropdownValues(HashMap<String, String> data) throws Exception{
    	List<String> reportData =  new ArrayList<String>();
    	List<String> ecoaVal_UI= fetchUiEcoaVal();
    	String reportString;
    	String ecoaExcel=data.get("EcoaVal");
    	String [] arrOfStr1 = ecoaExcel.split(","); 
		List<String> ecoaVal_Excel=new ArrayList<String>();
		ecoaVal_Excel = Arrays.asList(arrOfStr1); 
		Collections.sort(ecoaVal_UI);
		Collections.sort(ecoaVal_Excel);
		reportString = "Info" + "~" + "retriveValues" + "~" + "EcoaVal DropDown" + "~" + "List of DropDown Values Are: " + ecoaVal_UI;
		for(int i=0;i<ecoaVal_Excel.size();i++){
			if(ecoaVal_Excel.get(i).equals(ecoaVal_UI.get(i))){
				System.out.println("matched "+ ecoaVal_UI.get(i));
				reportString = "Pass" + "~" + "verify" + "~" + ecoaVal_Excel.get(i) + "~" + "Present In DropDown List";
				reportData.add(reportString);
			}
			else{
				System.out.println("unMatched "+ ecoaVal_UI.get(i));
				reportString = "Error" + "~" + "verify" + "~" + ecoaVal_Excel.get(i) + "~" + "Not Present In DropDown List";
				reportData.add(reportString);
			}
		}
     createReportTableEntry(reportData, "verifyEcoaValDropdownValues");
    } 
    
    
    public void verifyAuditTrailTable() throws Exception {
    	List<String> reportData =  new ArrayList<String>();
    	String reportString = null;
    	sleep(5000);
    	reportData.add(scrollToView(appPages.creditDispute_page.lbl_AuditTrail, "AuditTrail Label"));
        try{
        	int SpecialLineItemsCount=driver.findElements(By.xpath(appPages.creditDispute_page.vfy_AuditTrailTable)).size();
    		System.out.println(SpecialLineItemsCount);
            if (SpecialLineItemsCount >= 1) {
    			for (int i = 0; i < SpecialLineItemsCount; i++) {
    				String tblSpecialItem = String.format(appPages.creditDispute_page.vfy_AuditTrailTable, i);
    				scrollToView(driver.findElements(By.xpath(appPages.creditDispute_page.vfy_AuditTrailTable)).get(i),
    						"DescriptionChangeRow Table");
    				String specialItemFetched = driver.findElements(By.xpath(appPages.creditDispute_page.vfy_AuditTrailTable)).get(i).getText();
    				System.out.println(specialItemFetched);
    				if (specialItemFetched.contains("Special")) {
    					System.out.println(specialItemFetched);
    					reportString = "Pass" + "~" + "verifyAuditTrail" + "~" + specialItemFetched + "~"
    							+ "Present in Audit Trail Table";
    					reportData.add(reportString);
    				} else {
    					reportString = "Fail" + "~" + "verifyAuditTrail" + "~" + specialItemFetched + "~"
    							+ "Not Found in Audit Trail Table";
    					reportData.add(reportString);
    				}
    			}
    		} else {
    			reportString = "Error" + "~" + "verifyAuditTrail" + "~" + "--" + "~" + "No Data Available in Audit Trail Table";
    			reportData.add(reportString);
    		}
        } catch(Exception e){
        	reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AuditTrail Table" + "~"
					+ getExceptionMessage(e.getMessage()));
        }
    	
    	createReportTableEntry(reportData, "verifyAuditTrailTable");
    	logger.log(LogStatus.INFO, "Successfully Verified Audit Trail Table",
				attchedStepScreenShot("Successfully Verified Audit Trail Table","Yes"));
    }
    
    public void checkEcoaVal(HashMap<String, String> data) throws Exception{
    	List<String> reportData =  new ArrayList<String>();
    	List<String> ecoaVal_UI= fetchUiEcoaVal();
    	String reportString;
    	String ecoaExcel=data.get("EcoaVal");
    	String [] arrOfStr1 = ecoaExcel.split(","); 
		@SuppressWarnings("unused")
		List<String> ecoaVal_Excel=new ArrayList<String>();
		ecoaVal_Excel = Arrays.asList(arrOfStr1); 
		Collections.sort(ecoaVal_UI);
		Collections.sort(ecoaVal_Excel);
		for(int i=0;i<ecoaVal_Excel.size();i++){
			if(ecoaVal_Excel.get(i).equals(ecoaVal_UI.get(i))){
				System.out.println("matched "+ ecoaVal_UI.get(i));
				reportString = "Pass" + "~" + "verify" + "~" + ecoaVal_Excel.get(i) + "~" + "Exist";
				reportData.add(reportString);
			}
			else{
				System.out.println("unMatched "+ ecoaVal_UI.get(i));
				reportString = "Error" + "~" + "verify" + "~" + ecoaVal_Excel.get(i) + "~" + "Not Exist";
				reportData.add(reportString);
			}
		}
     createReportTableEntry(reportData, "checkEcoaVal");
    }
    public void verifyDelinquencyCounters(String DelinquencyCounters) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		List<String> inpDataList = splitInputData(DelinquencyCounters, ",");
		for(int i = 0;i<inpDataList.size();i++){	
			String fldName = inpDataList.get(i);
			String fieldName1 = String.format(appPages.creditDispute_page.vfy_FieldName, fldName);
			reportData.add(verifyFieldName(fieldName1, fldName));
		}
		createReportTableEntry(reportData, "verifyCreditDisputeFieldName");
	}  
    /***
	 * @author Preeti
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 */
	
	public void verifyDelinquencyCountersTables(HashMap<String, String> data) throws Throwable{
		List<String> reportData =  new ArrayList<String>();
		reportData.add(isPresentAndDisplayed(appPages.creditDispute_page.lbl_DelinquencyCounters,"DelinquencyCounters label"));
		reportData.add(isPresentAndDisplayed(appPages.creditDispute_page.lbl_DelinquencyCountersOverride,"DelinquencyCountersOverride label"));
		createReportTableEntry(reportData, "verifyDelinquencyCountersTables");
		logger.log(LogStatus.INFO, "Succesfully verified Delinquency Counters Tables", attchedStepScreenShot("Succesfully verified Delinquency Counters Tables","Yes"));
	}
	
	 /***
		 * @author Preeti
		 * @param sheetName
		 * @param testCase
		 * @throws Throwable
		 */
		
		public void verifyPHPSection(HashMap<String, String> data) throws Throwable{
			List<String> reportData =  new ArrayList<String>();
			reportData.add(isPresentAndDisplayed(appPages.creditDispute_page.lbl_PHPOverride,"PHPOverride label"));
			reportData.add(isPresentAndDisplayed(appPages.creditDispute_page.lbl_PHPRealtime,"PHPRealtime label"));
			reportData.add(isPresentAndDisplayed(appPages.creditDispute_page.lbl_PHPLastCBData,"PHPLastCBData label"));
			createReportTableEntry(reportData, "verifyPHPSection");
			logger.log(LogStatus.INFO, "Succesfully verified PHP Section", attchedStepScreenShot("Succesfully verified PHP Section","Yes"));
		}
		
}
