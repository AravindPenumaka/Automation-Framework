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

public class HomeScreen_Funcs extends BasePageMod {
	
	ApplicationPages appPages;
	BasePageData basepageData = new BasePageData();
	
	public HomeScreen_Funcs(WebDriver driver, ExtentTest logger) throws IOException {
		this.driver = driver;
		this.logger = logger;
		appPages = new ApplicationPages(driver);
	}
	
	/***
	 * @author Brahma
	 * @param menuItemTab
	 * @param menuListSubItem
	 * @return
	 */
	public List<String> clickMenuListItem(String menuItemTab, String menuListSubItem , String... menuTreeItem){
		List<String> reportData = new ArrayList<String>();
		//String tab_MenuItem = appPages.homeScreen_page.tab_MenuItem;
		//String locatorMenuElement = String.format(tab_MenuItem, menuItemTab);
		reportData.add(click(getStringWebElement(appPages.homeScreen_page.tab_MenuItem, menuItemTab),"XPATH", menuItemTab +" Tab"));
		
		//String sel_MenuListItem = appPages.homeScreen_page.sel_MenuListItem;
		//String locatorMenuListElement = String.format(sel_MenuListItem, menuListSubItem);
		reportData.add(click(getStringWebElement(appPages.homeScreen_page.sel_MenuListItem,menuListSubItem), "XPATH", menuListSubItem + " SubListItem"));
		
		try{
			if(menuTreeItem[0] != null){
				System.out.println(menuTreeItem.length);
				for(int i=0; i < menuTreeItem.length; i++){
					try{
						String subTreemItem = menuTreeItem[i].toString();
						WebElement element = setStringValueInToWebElement(appPages.homeScreen_page.sel_MenuListItem, subTreemItem, "XPATH");
						reportData.add(click(element, subTreemItem + " SubListItem"));
					}catch(Exception e){
						reportData.add("Fail" + "~" + "isPresentelement" + "~" + "MenuListItem" + "~" + "Element Not Found."+"~"+getExceptionMessage(e.getMessage()));
					}
					
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			
		}
		sleep(3000);
		return reportData;
	}
	
	/***
	 * @author Arpita
	 * @param sheetName
	 * @param testCase
	 * @throws Throwable
	 * @description Search Actor code
	 */
	public void searchActorCode(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(5000);
		String ActorCode = data.get("ActorCode");

		if (ActorCode.equals("")) {
			ActorCode =  getValueProperty("ActorCode");
			reportData.add(switchToDefaultFrameContent());
		}

		reportData.add(select(appPages.homeScreen_page.lst_GlobalSearchFind, "Actor Code", "ActorCode DropDown"));
		reportData.add(type(appPages.homeScreen_page.txt_GlobalSearchCode, true, ActorCode, "ActorCode TextBox"));
		reportData.add(click(appPages.homeScreen_page.btn_GobalSearch, "Search Button"));
		sleep(1000);
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchActorCode");
		sleep(3000);
		logger.log(LogStatus.INFO, "Successfully Searched Actor Code", attchedStepScreenShot("Successfully Searched Actor Code","Yes"));
	}
	 
	 /***
	  * @author Arpita
	  * @param sheetName
	  * @param testCase
	  * @throws Throwable
	  * @description Search Asset code
	  */
	public void searchAssetCode(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(5000);
		reportData.add(select(appPages.homeScreen_page.lst_GlobalSearchFind, "Asset", "Find Dropdown"));
		reportData.add(type(appPages.homeScreen_page.txt_GlobalSearchCode, true, data.get("AssetCode"), "AssetCode Textbox"));
		reportData.add(click(appPages.homeScreen_page.btn_GobalSearch, "Search Button"));
		sleep(1000);
		acceptAlert("Search PopUp");
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchAssetCode");
		logger.log(LogStatus.INFO, "Successfully Searched Asset Code", attchedStepScreenShot("Successfully Searched Asset Code","Yes"));
	}
	
	
	public void searchContractCode(HashMap<String, String> data) throws Throwable {
		List<String> reportData = new ArrayList<String>();
		sleep(5000);
		reportData.add(select(appPages.homeScreen_page.lst_GlobalSearchFind, "Contract", "Find Dropdown"));
		reportData.add(type(appPages.homeScreen_page.txt_GlobalSearchCode, true, data.get("ContractCode"), "AssetCode Textbox"));
		reportData.add(click(appPages.homeScreen_page.btn_GobalSearch, "Search Button"));
		sleep(1000);
		acceptAlert("Search PopUp");
		reportData.add(switchToDefaultFrameContent());
		createReportTableEntry(reportData, "searchContractCode");
		logger.log(LogStatus.INFO, "Successfully Searched Contract Code", attchedStepScreenShot("Successfully Searched Contract Code","Yes"));
	}
	
	
	public void globalSearchDetails(HashMap<String, String> data) throws Throwable{
        List<String> reportData =  new ArrayList<String>();
        
        //System.out.println(data.get("ContractNum"));
        sleep(7000);
        reportData.add(select(appPages.homeScreen_page.lst_GlobalSearchFind,data.get("GlobalSearchOption"), "GlobalSearch Option"));
        reportData.add(type(appPages.homeScreen_page.txt_GlobalSearchCode,true,data.get("GlobalSearchCode"), "GlobalSerach Code"));
        reportData.add(click(appPages.homeScreen_page.btn_GobalSearch,"Search Button"));
        
        reportData.add(switchToDefaultFrameContent());        
        createReportTableEntry(reportData, "GlobalSearch");
        sleep(5000);
        logger.log(LogStatus.INFO, "Successfully Searched in Global Search...");
	}

	
}
