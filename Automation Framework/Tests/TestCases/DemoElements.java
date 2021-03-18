package TestCases;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import ExcelUtility.getExcelData;
import Pages.pageConnect;

public class DemoElements extends Reusables.Keywords{
	
	pageConnect page = new pageConnect();
	ExcelUtility.getExcelData exceldata = new getExcelData();
	
	@Test(dataProvider="TestData",dataProviderClass=getExcelData.class)
	public void DemoElements_demoElementTestcase(Map<Object,Object> odata) throws Exception{
		
		HashMap<String, String> data = exceldata.getData(odata);
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		page.demopage.demoElementInteraction(data);
		
		
	}

}
