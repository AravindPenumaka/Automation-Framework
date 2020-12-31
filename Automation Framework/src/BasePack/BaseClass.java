package BasePack;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExcelUtility.getExcelData;

public class BaseClass {

	ExcelUtility.getExcelData getexcelinfo = new getExcelData();
	public static WebDriver driver;
	public static String browser = "";
	public static String Path = "";
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	@BeforeSuite
	public void onStart() throws Exception {

		spark = new ExtentSparkReporter(new File(System.getProperty("user.home")+"\\Desktop\\TestResult.html"));
		extent=new ExtentReports();
		extent.attachReporter(spark);
		if (getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
			browser = "Chrome";
		}
	}

	@BeforeMethod
	public void onMethodStrat(Method method) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void onMethodEnd() {

		driver.close();
	}

	@AfterSuite
	public void onFinish() {
		extent.flush();
	}

}
