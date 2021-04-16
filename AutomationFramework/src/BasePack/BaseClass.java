package BasePack;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.jetty.client.ValidatingConnectionPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExcelUtility.getExcelData;
import Reusables.Keywords;

public class BaseClass {

	protected ExcelUtility.getExcelData getexcelinfo = new getExcelData();
	public static WebDriver driver;
	public static String browser = "";
	public static String Path = "";
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentSparkReporter spark;
	public static ExtentTest child;
	public static String extentreportLocation = "";
	public static String ScreenshotsPath = "";
	public static String time = "";
	public static String srcPath = "";
	
	@BeforeSuite
	public void onStart() throws Exception {

		Keywords report = new Keywords();
		if (getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
			browser = "Chrome";
			
		}else if(getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("Chrome Headless")){
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
			browser = "Chrome headless";
		}else if(getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("HTML Unit")){
			
		}else if(getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\IEDriverServer.exe");
			browser = "IE";
		}else if(getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("HTML Unit")){
			browser = "HTMLUnitDriver";
		}
		time = getCurrentTime();
		extentreportLocation = System.getProperty("user.dir")+"./AutomationReports/"+time+"/Automationreport.html";
		srcPath  = "./AutomationReports/"+time+"/Screenshots/";
		report.initializeReport();
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void onMethodStrat(Method method) {

		ChromeOptions co=new ChromeOptions();
		if (browser.equalsIgnoreCase("chrome")) {
			co.addArguments("--start-maximized");
			driver = new ChromeDriver(co);
			System.out.println("----------Started exceution of "+method.getName()+"----------");
		}else if(browser.equalsIgnoreCase("Chrome headless")){
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
		}else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities ieCapabilities = new DesiredCapabilities();
			ieCapabilities.setCapability(InternetExplorerDriver
					 .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					ieCapabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("HTMLUnitDriver")){
			driver =new HtmlUnitDriver();
		}
		logger = extent.createTest(method.getName());
		logger.assignCategory(method.getName().split("_")[0]);
	}

	@AfterMethod
	public void onMethodEnd(Method m) {

		driver.close();
		System.out.println("----------End of exceution of "+m.getName()+"----------");
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
