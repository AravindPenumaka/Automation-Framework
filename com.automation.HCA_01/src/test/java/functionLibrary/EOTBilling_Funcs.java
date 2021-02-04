package functionLibrary;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class EOTBilling_Funcs extends BasePageMod{
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
		public EOTBilling_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description navigate and select SettleH tab
	 */
	@SuppressWarnings("unchecked")
	public void navigateSettleHtab(HashMap<String, String> data) throws Throwable {
		sleep(5000);
		List<String> reportData = new ArrayList<String>();
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "frameName");
		/*String ContractNo="//a[text()='%s']";
		String ContractLink=String.format(ContractNo, data.get("ContractNumber"));
		reportData.add(click(getWebelement("XPATH",ContractLink),"ContractLink"));*/
		sleep(2000);
		String endOfTerm = "//label[text()='Step']/../../td[2]//select";
		reportData.add(verifyFieldAttribute(endOfTerm, "XPATH", "title","End of Term Billed","Step Verify"));
		reportData.add(click(appPages.EOTBilling_page.lnk_More,"More"));
		reportData.add(click(appPages.EOTBilling_page.lnk_SettlementAutoLease,"Settlement"));
		sleep(2000);
		reportData.add(click(appPages.EOTBilling_page.btn_CollapsePane1,"Pane1"));
		reportData.add(switchToDefaultFrameContent());
		reportData.add(click(appPages.EOTBilling_page.btn_CollapsePane2,"Pane2"));
		switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "frameName");
		createReportTableEntry(reportData, "selectSettlehtab");
		logger.log(LogStatus.INFO, "Successfully selected settlehtab");
	}
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verifySettlementLiablity Panel Data
	 */
	@SuppressWarnings("unchecked")
	public void verifySettlementLiablityData(HashMap<String, String> data) throws Throwable {
 		List<String> reportData = new ArrayList<String>();
		navigateSettleHtab(data);
		String fldValue=null;
		Double fldValuesum=0.00;
		String Key="//label[contains(text(),'%s')]";
		if(!(data.get("Field").equals("Dispo Fee") || data.get("Field").equals("EarlyTerm Fee") || data.get("Field").equals("Turn-In Fee")))	
		{
			scrollToView(getWebelement("XPATH",String.format(Key,data.get("Field"))),"Scroll");
		}
		String state[]={"Original","Waived","Final"};
		for(int i=0;i<state.length;i++){
			String value=data.get("Field")+" "+ state[i];		
			if(data.get("Field").equals("Dispo Fee")|| data.get("Field").equals("Excess Mileage") || data.get("Field").equals("Excess WearUse") || data.get("Field").equals("EarlyTerm Fee") || data.get("Field").equals("Turn-In Fee"))
			 {
				if(state[i].equalsIgnoreCase("Final")){
					fldValue = String.format(Key,value) + "/../../td[2]//input";
					fldValuesum=Double.parseDouble(getWebelement("XPATH", fldValue).getAttribute("value"));
					
					if(format(fldValuesum).equals(data.get("Value"))){
						reportData.add(verifyFieldAttribute(fldValue, "XPATH", "value",data.get("Value"),data.get("Field")));
						break;
					}
					else{
						reportData.add("Error" + "~" + "validateField" + "~" + data.get("Field") +"~" + "Expected- [" + data.get("Value") +"] But Not Equals To Actual- [" + fldValuesum + "]");
						break;
					}
				}
				fldValue = String.format(Key,value) + "/../../td[2]//input";
				fldValuesum=fldValuesum+Double.parseDouble(getWebelement("XPATH", fldValue).getAttribute("value"));
			 }
			  }
/*			else
			{
				fldValue = String.format(Key,value) + "/../../../td[2]//input";
			}*/
		//reportData.add(verifyFieldAttribute(fldValue, "XPATH", "value",data.get("Value"),data.get("Field")));
		createReportTableEntry(reportData, "verifySettlementLiablity");
		logger.log(LogStatus.INFO, "Successfully verified  KSIOP");
	}
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verify Lease Agreement Information
	 */
	@SuppressWarnings("unchecked")
	public void verifyLeaseAgreementInformation(HashMap<String, String> data) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
		navigateSettleHtab(data);
		String LeasedataValues=data.get("LeaseAgreementFieldValues");
		List<String> LeaseFieldData=splitInputData(LeasedataValues,",");
		String dataval="//label[contains(text(),'%s')]";
		try{
			for(int i=0;i<=LeaseFieldData.size()-1;i++)
			{
					reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,LeaseFieldData.get(i))),LeaseFieldData.get(i),LeaseFieldData.get(i)));
			}
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "LeaseField" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		
		createReportTableEntry(reportData, "LeaseAgreementInformation");
		logger.log(LogStatus.INFO, "Successfully verified  LeaseAgreementInformation");
	}
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verify SettlementInformation tab data
	 */
	@SuppressWarnings("unchecked")
	public void verifySettlementInformation(HashMap<String, String> data) throws Throwable
	{
		
		List<String> reportData = new ArrayList<String>();
		String GeneralInfodataValues=data.get("GeneralInfoFieldValues");
		List<String> GeneralInfoFieldData=splitInputData(GeneralInfodataValues,",");
		String dataval="//label[text()='%s']";
		for(int i=0;i<=GeneralInfoFieldData.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,GeneralInfoFieldData.get(i))),GeneralInfoFieldData.get(i),GeneralInfoFieldData.get(i)));
		}

		String OtherDues=data.get("OtherAmountsDue");
		List<String> OtherAmountsDue=splitInputData(OtherDues,",");
		for(int i=0;i<=OtherAmountsDue.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,OtherAmountsDue.get(i))),OtherAmountsDue.get(i),OtherAmountsDue.get(i)));
		}
		
		String EarlyTerminations=data.get("ModifyEarlyterminations");
		List<String> ModifyEarlyterminations=splitInputData(EarlyTerminations,",");
		for(int i=0;i<=ModifyEarlyterminations.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,ModifyEarlyterminations.get(i))),ModifyEarlyterminations.get(i),ModifyEarlyterminations.get(i)));
		}
		
		String Reposession=data.get("ReposessionExpenses");
		List<String> ReposessionExpenses=splitInputData(Reposession,",");
		for(int i=0;i<=ReposessionExpenses.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,ReposessionExpenses.get(i))),ReposessionExpenses.get(i),ReposessionExpenses.get(i)));
		}
		
		String Auction=data.get("AuctionExpenses");
		List<String> AuctionExpenses=splitInputData(Auction,",");
		for(int i=0;i<=AuctionExpenses.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,AuctionExpenses.get(i))),AuctionExpenses.get(i),AuctionExpenses.get(i)));
		}
		createReportTableEntry(reportData, "verifySettlementInformation");
		logger.log(LogStatus.INFO, "Successfully verified  verifySettlementInformation");
	}
	
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verify TaxAmount Panel data
	 */
	@SuppressWarnings("unchecked")
	public void verifyTaxAmount(HashMap<String, String> data) throws Throwable
	{
		
		List<String> reportData = new ArrayList<String>();
		String Tax=data.get("TaxAmount");
		List<String> TaxAmount=splitInputData(Tax,",");
		String dataval="(//label[text()='%s'])[1]";
		for(int i=0;i<TaxAmount.size()-1;i++)
		{
			reportData.add(verifyText(getWebelement("XPATH",String.format(dataval,TaxAmount.get(i))),TaxAmount.get(i),TaxAmount.get(i)));
		}
		createReportTableEntry(reportData, "verifyTaxAmount");
		logger.log(LogStatus.INFO, "Successfully verified  verifyTaxAmount");
	}
	
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verify SettlementLiability Fields data
	 */
	@SuppressWarnings("unchecked")
	public void verifySettlementLiabilityFields(HashMap<String, String> data) throws Throwable
	{
		
		List<String> reportData = new ArrayList<String>();
		String Settlement=data.get("SettlementLiability");
		List<String> SettlementLiability=splitInputData(Settlement,";");
		String Fields = "//h2[text()='Settlement Liability']//../../../../../../../../../../div//label[text()='%s']";
		try{
			for(int i=1;i<=SettlementLiability.size()-1;i++)
			{
				reportData.add(verifyText(getWebelement("XPATH",String.format(Fields,SettlementLiability.get(i))),SettlementLiability.get(i),SettlementLiability.get(i)));
			}
		} catch(Exception e){
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "SettlementLiability" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		createReportTableEntry(reportData, "verifySettlementLiabilityFields");
		logger.log(LogStatus.INFO, "Successfully verified  verifySettlementLiabilityFields");
	}
	
	
	
	
	double ParseDouble(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Double.parseDouble(String.format(strNumber));
		       } catch(Exception e) {
		          return 0.00; 
		       }
		   }
		   else return 0;
		}
	
	String format(double dec)
	{
		DecimalFormat df = new DecimalFormat("##,##0.00");
		String format =df.format(dec);
		return format;
	}
	
	
	
	
	String SettlementLiabilityFields="//h2[text()='Settlement Liability']//../../../../../../../../../../div//label[text()='%s']/../../../td[2]//input";
	String Feild = "//label[text()='%s']/../../td[2]/input";
	/***
	 * @author Aravind
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description verify Simulation Result
	 */
	@SuppressWarnings("unchecked")
	public void verifySimulationResult(HashMap<String, String> data) throws Throwable {

		navigateSettleHtab(data);
		Double val = 0.00;
		List<String> reportData = new ArrayList<String>();

		// Unpaid MonthlyPayments
		String DueUnpaidMonthlyPayments = getStringWebElement(SettlementLiabilityFields, "Due Unpaid Monthly Payments");
		val = ParseDouble(appPages.EOTBilling_page.vfyTxt_DueUnpaidPayments.getAttribute("value"))
				- ParseDouble(appPages.EOTBilling_page.vfyTxt_PartialPayments.getAttribute("value"));
		reportData.add(verifyFieldAttribute(DueUnpaidMonthlyPayments, "XPATH", "value", format(val),
				"DueUnpaidMonthlyPayments"));

		// EarlyTermination Fee
		String EarlyTerminationFee = getStringWebElement(SettlementLiabilityFields, "Early Termination Fee");
		if(!(data.get("EarlyTerminationFee").equals("0.00"))){
			String ETvalue=getWebelement("XPATH", EarlyTerminationFee).getAttribute("value");
			reportData.add(verifyFieldAttribute(EarlyTerminationFee, "XPATH","value",ETvalue,"EarlyTermination Fee"));
		}
		else{
			reportData.add(verifyFieldAttribute(EarlyTerminationFee, "XPATH", "value", "0.00", "EarlyTermination Fee"));
		}
		

		// Disposition
		String DispositionFee = getStringWebElement(SettlementLiabilityFields, "Disposition Fee");
		if(!(data.get("DispositionFee").equals("0.00"))){
			String Dispovalue=getWebelement("XPATH", DispositionFee).getAttribute("value");
			reportData.add(verifyFieldAttribute(DispositionFee, "XPATH","value",Dispovalue,"DispositionFee Fee"));
		}
		else{
			double DispoFee=Double.parseDouble(getWebelement("XPATH", DispositionFee).getAttribute("value"));
			reportData.add(
					verifyFieldAttribute(DispositionFee, "XPATH", "value", format(DispoFee), "DispositionFee"));
		}
		

		// OtherAmountsDue Lease
		String AmountDueUnderLease = getStringWebElement(SettlementLiabilityFields,
				"Other Amounts Due Under the Lease");
		Double d = 0.00;
		String OtherAmountsDue = data.get("Other Amounts Due Under the Lease");
		List<String> OtherAmountsDuedatavalue = splitInputData(OtherAmountsDue, ",");
		for (int i = 0; i < OtherAmountsDuedatavalue.size(); i++) {
			/* appPages.EOTBilling_page.vfyTxt_OtherAmountsDueFields */
			try {
				d = d + ParseDouble(getWebelement("XPATH", getStringWebElement(Feild, OtherAmountsDuedatavalue.get(i)))
						.getAttribute("value"));
			} catch (Exception e) {
				reportData.add("Fail" + "~" + "isPresentElement" + "~" + "OtherAmountsDuedatavalue" + "~"
						+ "Element Not Found. For " + OtherAmountsDuedatavalue.get(i) + "~"
						+ getExceptionMessage(e.getMessage()));
			}
		}
		reportData.add(verifyFieldAttribute(AmountDueUnderLease, "XPATH", "value", format(d), "AmountDueUnderLease"));

		// REalizedValue
		String RealizedValue = getStringWebElement(SettlementLiabilityFields, "Realized Value");
		if (data.get("RealizedValue").equals("Realized Value")||data.get("RealizedValue")==null||data.get("RealizedValue").equals("")) {
			String Realizedvalue=getWebelement("XPATH", RealizedValue).getAttribute("value");
			reportData.add(verifyFieldAttribute(RealizedValue, "XPATH","value",Realizedvalue,"DispositionFee Fee"));
			reportData.add(verifyFieldAttribute(RealizedValue, "XPATH", "value", "0.00", "RealizedValue"));

		} else {
			d = (ParseDouble(appPages.EOTBilling_page.vfyTxt_GrossSalesProceeds.getAttribute("value").replace(",", "")) * -1);
			if(d!=-0.00){
				reportData.add(verifyFieldAttribute(RealizedValue, "XPATH", "value", format(d), "RealizedValue"));
			}else
			{
				reportData.add(verifyFieldAttribute(RealizedValue, "XPATH", "value", "0.00", "RealizedValue"));
			}
			
		}
		reportData = concatList(reportData, verifyRepossessionFee(data));
		reportData = concatList(reportData, verifyAuctionExpenses(data));
		reportData = concatList(reportData, verifyExcessWearUseMileageRemainingAmount(data));
		reportData = concatList(reportData, verifySubTotalETLiabilityAdvancedLeasePayment(data));
		createReportTableEntry(reportData, "verifySimulationResult");
		logger.log(LogStatus.INFO, "Successfully verified  verifySimulationResult");
	}

	public List<String> verifyRepossessionFee(HashMap<String, String> data) {
		List<String> reportData = new ArrayList<String>();
		double d = 0.0;
		// Repossession Fee
		String ReposissionFee = getStringWebElement(SettlementLiabilityFields, "Repossession And Other Fees");
		d = 0.00;
		String Repossession = data.get("ReposessionExpenses");
		if (data.get("ReposessionExpenses").equals("0.00")) {
			reportData.add(verifyFieldAttribute(ReposissionFee, "XPATH", "value", data.get("ReposessionExpenses"),
					"ReposissionFee"));
		} else {
			List<String> Repossessiondatavalue = splitInputData(Repossession, ",");
			for (int i = 0; i < Repossessiondatavalue.size(); i++) {
				d = d + ParseDouble(getWebelement("XPATH",getStringWebElement(Feild, Repossessiondatavalue.get(i))).getAttribute("value"));
			}
			reportData.add(verifyFieldAttribute(ReposissionFee, "XPATH", "value", format(d), "ReposissionFee"));
		}
		return reportData;
	}

	public List<String> verifyAuctionExpenses(HashMap<String, String> data) {
		List<String> reportData = new ArrayList<String>();
		double d = 0.0;
		// AuctionExpenses
		String AuctionFee = getStringWebElement(SettlementLiabilityFields, "Auction Expenses");
		d = 0.00;
		if (data.get("AuctionExpenses").equals("0.00")) {
			reportData.add(
					verifyFieldAttribute(AuctionFee, "XPATH", "value", data.get("AuctionExpenses"), "AuctionExpenses"));
		} else {
			String auctionExpenses = data.get("AuctionExpenses");
			List<String> AuctionExpensesvalues = splitInputData(auctionExpenses, ",");
			int validate = AuctionExpensesvalues.size();
			System.out.println(validate);
			for (int i = 0; i < AuctionExpensesvalues.size(); i++) {
				try {
					String AuctionFeeFeilds = getStringWebElement(Feild, AuctionExpensesvalues.get(i));
					d = d + ParseDouble(getWebelement("XPATH", AuctionFeeFeilds).getAttribute("value"));
				} catch (Exception e) {
					reportData.add("Fail" + "~" + "isPresentElement" + "~" + "AuctionFeeFeilds" + "~"
							+ "AuctionExpensesvalues.get(i)" + "~" + "Element Not Found." + "~"
							+ getExceptionMessage(e.getMessage()));
				}

			}
			reportData.add(verifyFieldAttribute(AuctionFee, "XPATH", "value", format(d), "AuctionExpenses"));
		}
		return reportData;
	}

	public List<String> verifyExcessWearUseMileageRemainingAmount(HashMap<String, String> data) {
		List<String> reportData = new ArrayList<String>();
		// ExcessWearUseMileageRemainingAmount
		String remaingamount = null;
		String ExcessWearUse = getStringWebElement(SettlementLiabilityFields, "Excess Wear Use");
		String ExcessMileage = getStringWebElement(SettlementLiabilityFields, "Excess Mileage");
		String RemainingLeasePayments = getStringWebElement(SettlementLiabilityFields, "Remaining Lease Payments");
		try {
			remaingamount = getWebelement("XPATH", RemainingLeasePayments).getAttribute("value");
		} catch (Exception e) {
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "RemainingLeasePayments" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		if(data.get("ExcessWearUse").contains("MD")){
			if(getWebelement("XPATH", getStringWebElement(Feild, "ContractState")).getAttribute("value").equalsIgnoreCase("md")){
				reportData
				.add(verifyFieldAttribute(ExcessWearUse, "XPATH", "value", "0.00", "ExcessWearUse"));
			}
			else{
				String value=getWebelement("XPATH", getStringWebElement(SettlementLiabilityFields, "Excess Wear Use")).getAttribute("value");
				reportData
				.add(verifyFieldAttribute(ExcessWearUse, "XPATH", "value", value, "ExcessWearUse"));
			}
		}
		else{
			reportData
			.add(verifyFieldAttribute(ExcessWearUse, "XPATH", "value", data.get("ExcessWearUse"), "ExcessWearUse"));
		}
		if(data.get("ExcessMileage").contains("ExcessMileage")){
			String excessmileage=getStringWebElement(SettlementLiabilityFields, "Excess Mileage");
			String value=getWebelement("XPATH",excessmileage).getAttribute("value");
			reportData
			.add(verifyFieldAttribute(excessmileage, "XPATH", "value", value, "ExcessMileage"));
		}
		else{
			reportData
			.add(verifyFieldAttribute(ExcessMileage, "XPATH", "value", data.get("ExcessMileage"), "ExcessMileage"));
		}
		
		if (data.get("RemainingLease").equals("0.00")) {
			reportData.add(
					verifyFieldAttribute(RemainingLeasePayments, "XPATH", "value", "0.00", "RemainingLeasePayments"));
		} else /* if (data.get("RemainingLease").equals(null)) */ {
			reportData.add(verifyFieldAttribute(RemainingLeasePayments, "XPATH", "value", remaingamount,
					"RemainingLeasePayments"));
		}
		return reportData;
	}

	public List<String> verifySubTotalETLiabilityAdvancedLeasePayment(HashMap<String, String> data)
		{
		List<String> reportData = new ArrayList<String>();
		double d = 0.0;
		// SubTotalETLiability
		String dataval = data.get("SubTotal");
		List<String> total = splitInputData(dataval, ";");
		d = 0.00;
		String SubTotalETLiability = getStringWebElement(SettlementLiabilityFields, "Subtotal E/T Liability");
		for (int i = 2; i <= total.size() + 1; i++) {
			try {
				String SubtottalFields = getStringWebElement(SettlementLiabilityFields, total.get(i - 2));
				d = d + ParseDouble(getWebelement("XPATH", SubtottalFields).getAttribute("value"));
			} catch (Exception e) {
				reportData.add("Fail" + "~" + "isPresentElement" + "~" + "SubtottalFields" + "~"
						+ getExceptionMessage(e.getMessage()));
			}
		}
		Double subTotal = d;
		try {
			reportData.add(verifyFieldAttribute(getWebelement("XPATH", SubTotalETLiability), "value", format(d),
					"SubTotalETLiability"));
		} catch (Exception e) {
			reportData.add("Fail" + "~" + "isPresentElement" + "~" + "SubTotalETLiability" + "~"
					+ getExceptionMessage(e.getMessage()));
		}
		// Advanced Lease Payments and security deposite and total
		String AdvancedLeasePayment = getStringWebElement(SettlementLiabilityFields, "Minus:AdvanceLeasePayements");
		String securityDeposite = getStringWebElement(SettlementLiabilityFields, "Minus:Security Deposit");
		String totalETLiability = getStringWebElement(SettlementLiabilityFields, "Total E/T Liability");
		String Credit = getStringWebElement(SettlementLiabilityFields, "Minus:NewYork Credit");
		d = 0.00;
		d = (ParseDouble(appPages.EOTBilling_page.vfyTxt_AdvancedLeasePayments.getAttribute("value")) * -1);
		double d1 = (ParseDouble(appPages.EOTBilling_page.vfyTxt_SecurityDeposit.getAttribute("value")) * -1);
		double d2 = subTotal + ParseDouble(appPages.EOTBilling_page.vfyTxt_SecurityDeposit.getAttribute("value"))
				+ ParseDouble(getWebelement("XPATH", AdvancedLeasePayment).getAttribute("value"))
				+ ParseDouble(getWebelement("XPATH", Credit).getAttribute("value"));
			reportData.add(verifyFieldAttribute(AdvancedLeasePayment, "XPATH", "value", format(d), "AdvancedLeasePayment"));
			reportData.add(verifyFieldAttribute(securityDeposite, "XPATH", "value", format(d1), "securityDeposite"));
			reportData.add(verifyFieldAttribute(totalETLiability, "XPATH", "value", format(d2), "totalETLiability"));
		
		return reportData;
	}
	
	public void verifyCalculationTypeAndTerminationType(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		navigateSettleHtab(data);
		reportData.add(verifyFieldAttribute(appPages.EOTBilling_page.vfyLst_CalculationType,"title",data.get("CalculationType"),"CalculationType DropDown"));
		reportData.add(verifyFieldAttribute(appPages.EOTBilling_page.vfyLst_TerminationType,"title",data.get("TerminationType"),"TerminationType DropDown"));
		createReportTableEntry(reportData, "verifyCalculationTypeAndTerminationType");
		logger.log(LogStatus.INFO, "Successfully verified CalculationType And TerminationType ");
	}

}
