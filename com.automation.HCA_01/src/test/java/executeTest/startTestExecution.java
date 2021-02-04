package executeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;

import utilities.NGS_ExcelToXMLTestNG;

public class startTestExecution {

	@Test
	public void runTestSuite() throws FileNotFoundException, IOException { 
		Properties pro = new Properties();
		pro.load(new FileInputStream("App.properties"));
		System.out.println("--Test HCA----" + pro.getProperty("TestDataSheet"));
		NGS_ExcelToXMLTestNG exlTotestNG = new NGS_ExcelToXMLTestNG();
		exlTotestNG.readElements(System.getProperty("user.dir") + "\\src\\test\\resources\\InputData\\" + pro.getProperty("TestDataSheet"));
	
		TestNG testng = new TestNG();
		List<String> suites=new ArrayList<String>();
		suites.add("testNG.xml");//path to xml..
		testng.setTestSuites(suites);
		testng.run();
	
	}

}
