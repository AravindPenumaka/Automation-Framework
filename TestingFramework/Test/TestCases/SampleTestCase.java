package TestCases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import ExcelDataUtil.excelDataManager;
import Pages.pageConnect;


public class SampleTestCase extends BasePackage.baseTest{
	
	
	pageConnect page = new pageConnect();
	ExcelDataUtil.excelDataManager exceldata = new excelDataManager();
	
	
	@Test(dataProvider="TestData",dataProviderClass=excelDataManager.class)
	public void SearchData_TestCase1(Map<Object,Object> odata) throws Exception {
		
		HashMap<String, String> data = exceldata.getData(odata);
		
		page.loginpage.LoginintoApplication(driver,"User2");
		page.prodsearch.SearchProduct(driver,data);
		
	}

}
