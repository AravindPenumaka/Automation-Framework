package functionLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import frameworkFactory.BasePageMod;
import pageDataFactory.BasePageData;

public class Bankcruptcy_Funcs extends BasePageMod{
	

	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();;
	HashMap<String, String> data;
	
	public Bankcruptcy_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	  * @author Koyal
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Click Finish and Confirm
	 
	  */
	public void navigateBankruptcyListPageAndVerifyModeValue(HashMap<String, String> data,String ActorType) throws Throwable
	{
		List<String> reportData = new ArrayList<String>();
       HomeScreen_Funcs homeScreen_func = new HomeScreen_Funcs(driver, logger);
   	reportData = concatList(reportData, homeScreen_func.clickMenuListItem("Collections","Bankruptcy List For Contract"));
   	reportData.add(switchToDefaultFrameContent());
   	sleep(2000);
   	reportData.add(switchToFrame(appPages.frame_page.frame_CassiopeClientArea, "To BankruptcyList Screen"));
   	sleep(2000);
	reportData.add(type(appPages.bankruptcy_page.txt_ContractNumber,data.get("AccountNumber"), "ContractNumber Textbox"));
	reportData.add(click(appPages.actors_page.btn_Search,"Search Button"));
	sleep(4000);
	reportData.add(click(appPages.contract_page.btn_Collapsepane, "Collapsepane Button"));
   	
   	String lnk_customerNumber="";
   	  if(ActorType.equalsIgnoreCase("Primary"))
   	    {
   	     lnk_customerNumber= String.format(appPages.bankruptcy_page.lnk_CustomerNumber,data.get("PrimaryActorCode"));
   	   
   	    }
   	  
   	  else if(ActorType.equalsIgnoreCase("Secondary"))
 	        {
 	         lnk_customerNumber= String.format(appPages.bankruptcy_page.lnk_CustomerNumber,data.get("SecondaryActorCode"));
 	        }
  	     reportData.add(click(lnk_customerNumber,"XPATH","CustomerNumber Link"));
  	     sleep(5000);
  		 reportData.add(switchToFrame(appPages.frame_page.frame_AccountCond, "To ChangeAttribute Screen"));
		 sleep(2000);
  	     reportData.add(verifyText(appPages.bankruptcy_page.lst_Mode, "Review", "Mode value"));
  	     reportData.add(scrollToView(appPages.actors_page.btn_Next, "Next Button"));
  	     sleep(2000);
  	     reportData.add(click(appPages.actors_page.btn_Next, "Next Button"));
  	     sleep(2000);
  	     reportData.add(select(appPages.actors_page.lst_status, data.get("Status"), "Status Dropdown"));
  	     reportData.add(scrollToView(appPages.actors_page.btn_finish, "Finish Button"));
  	     sleep(2000);
  	     reportData.add(click(appPages.actors_page.btn_finish, "Finish Button"));
  	     sleep(4000);
  	     reportData.add(scrollToView(appPages.actors_page.btn_Close_Footer, "Close Button"));
  	     sleep(2000);
  	     reportData.add(click(appPages.actors_page.btn_Close_Footer, "Close Button"));
  	     sleep(2000);
      	 createReportTableEntry(reportData, "navigateBankruptcyListPageAndVerifyModeValue");
		 logger.log(LogStatus.INFO, "Successfully verified Mode value",attchedStepScreenShot("Successfully filled Bankruptcy Details","Yes"));
	
	}
}
