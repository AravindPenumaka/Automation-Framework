package pageDataFactory;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import excelDataManager.TestInputData;
import frameworkFactory.BaseTestSuite;

public class BasePageData {
	
	
	HashMap<String, String> data;
	Properties properties = new Properties();
	
	/*
	 * This method fetchInputData calls fetchInputData() of TestInputData.class
	 *  
	 * @return String
	 * @throws Throwable 
	 */	
	@SuppressWarnings({ "rawtypes", "static-access" })
	public HashMap fetchInputData(String sheetName,String tcName) throws Throwable {

		BaseTestSuite btSuite = new BaseTestSuite();
		TestInputData td = new TestInputData();	
		HashMap inputDataSet = null;
		String TestCasePath = System.getProperty("user.dir")+ "\\src\\test\\resources\\InputData\\" + btSuite.testSheetName;
		try {
			inputDataSet = td.fetchInputData(TestCasePath, sheetName, tcName);
		} catch (NullPointerException nullEx) {
			nullEx.printStackTrace();
			throw new NullPointerException(
					" -- As Unable To Fetch Input Data From SheetName: <a style='color:orange'>" + sheetName
							+ "</a> For RowName: <a style='color:orange'>" + tcName + "</a>");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.toString());
		}
		return inputDataSet;
	}
     
}
