package testFunctionality;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.Base64;

public class CreateTestNGTest{
	
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static FileInputStream file;
	public static String strScenarioName ;
	public static String strGadgetName;
	public WebDriver Driver;
	public static int intIterationNum;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String Browser;
	public static String URL;	
	
	public static void main(String[] args) {
		
		XmlSuite xmlSuite=new XmlSuite();
		xmlSuite.setName("Suite1");
		//xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
		//xmlSuite.setThreadCount(2);
		xmlSuite.setVerbose(1);
		
		List<String> TCNames=new ArrayList<String>();
		List<String> scenarioName=new ArrayList<String>();
		try
		{
			  file= new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\InputData\\BackUp\\CRM.xls"));
			  workbook = new HSSFWorkbook(file);		  		  
			  sheet = workbook.getSheet("Execution_Sheet");
			  int intRowNum = sheet.getPhysicalNumberOfRows();
			  
			  	XmlTest xmlTest=new XmlTest(xmlSuite);
				xmlTest.setName("test");
				xmlTest.setPreserveOrder("true");
			  
			  for(int i =1;i<intRowNum;i++)
			  {
				  HSSFRow Exlrow = sheet.getRow(i);
				  String flag = Exlrow.getCell(4).getStringCellValue();
					  if(flag.equals("Yes"))
					  {
						  
						  strScenarioName = Exlrow.getCell(1).getStringCellValue();
						  strGadgetName = Exlrow.getCell(2).getStringCellValue();
						  String scName = strGadgetName.split("_")[0];
						  TCNames.add(strGadgetName);
						  scenarioName.add(scName);
					  }
			  }
							/*XmlTest xmlTest=new XmlTest(xmlSuite);
							xmlTest.setName("test");
							//xmlTest.addParameter("Browser", Browser );
							xmlTest.setPreserveOrder("true");*/
							
			 			System.out.println(scenarioName);
			  			ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
			  			
			  			for (int tc = 0; tc < scenarioName.size(); tc++) { 		       
							
						  String testCaseName = TCNames.get(tc);
						  String scName = testCaseName.split("_")[0];
						  
						  	/*if(TCNames.get(tc-1).contains(scName)){
						  		XmlClass test1Class=new XmlClass(Class.forName("testCases."+ scName));
								List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								methodsToRun.add(new XmlInclude(TCNames.get(tc)));
								listClass.get(0).setIncludedMethods(methodsToRun);
						  	} else {
						  		XmlClass test1Class=new XmlClass(Class.forName("testCases."+ scName));
						  		List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								methodsToRun.add(new XmlInclude(TCNames.get(tc)));
								listClass.get(0).setIncludedMethods(methodsToRun);
						  	}*/
						  	XmlClass test1Class=new XmlClass(Class.forName("testCases."+ scenarioName.get(tc)));
							List<XmlClass> listClass=new ArrayList<XmlClass>();
							listClass.add(test1Class);
							xmlTest.setXmlClasses(listClass);
					     } 
							
							
		}	  
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	catch(ClassNotFoundException e){
		e.printStackTrace();
		}
		
		TestNG testNG=new TestNG();
		
		List<XmlSuite> listSuite=new ArrayList<XmlSuite>();
		listSuite.add(xmlSuite);
		testNG.setXmlSuites(listSuite);
		System.out.println (listSuite.get(0).toXml());
		// initialisePageObjects();
//		testNG.run();
	}
	
}
