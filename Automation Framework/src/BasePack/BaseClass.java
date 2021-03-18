package BasePack;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ExcelUtility.getExcelData;
import Reusables.Keywords;

public class BaseClass {

	ExcelUtility.getExcelData getexcelinfo = new getExcelData();
	public static WebDriver driver;
	public static String browser = "";
	public static String Path = "";
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest child;
	public static String extentreportLocation = "";
	public static String ScreenshotsPath = "";
	
	@BeforeSuite
	public void onStart() throws Exception {

		Keywords report = new Keywords();
		if (getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
			browser = "Chrome";
			String time = getCurrentTime();
			extentreportLocation = System.getProperty("user.home")+"\\Documents\\AutomationReports\\"+time+"\\Automationreport.html";
			ScreenshotsPath = System.getProperty("user.home")+"\\Documents\\AutomationReports\\"+time+"\\Screenshots\\";
			report.initializeReport();
		}
	}

	@BeforeMethod
	public void onMethodStrat(Method method) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--start-maximized");
			driver = new ChromeDriver(co);
		}
		logger = extent.createTest(method.getName());
	}

	@AfterMethod
	public void onMethodEnd() {

		driver.close();
	}

	@AfterSuite
	public void onFinish() {
		extent.flush();
		File html = new File(extentreportLocation);
		try {
			Desktop.getDesktop().browse(html.toURI());
			System.gc();
		}catch(Exception e) {}
		
	}
	
	public String getCurrentTime(){
		
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

	}

}
