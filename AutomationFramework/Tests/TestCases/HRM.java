package TestCases;


import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import ExcelUtility.getExcelData;
import Pages.pageConnect;
import Reusables.Keywords;

public class HRM extends Keywords{
	
	pageConnect page = new pageConnect();
	ExcelUtility.getExcelData exceldata = new getExcelData();
	
	@Test(dataProvider="TestData",dataProviderClass=getExcelData.class)
	public void HRM_ApplyLeave(Map<Object,Object> odata) throws Exception{
		
		HashMap<String, String> data = exceldata.getData(odata);
		openPage("HRM");
		page.login.LoginintoApplication("HRM");
		page.applyleave.ApplyLeave(data);
	}
	

}
