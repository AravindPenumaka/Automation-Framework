package BasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ExcelUtility.getExcelData;

public class BaseClass {

	ExcelUtility.getExcelData getexcelinfo = new getExcelData();
	public static WebDriver driver;
	public static String browser = "";
	public static String Path = "";

	@BeforeSuite
	public void onStart() throws Exception {

		if (getexcelinfo.getConfiguration("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
			browser = "Chrome";
		}
	}

	@BeforeMethod
	public void onMethodStrat() {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
	}

	@AfterMethod
	public void onMethodEnd() {

		driver.close();
	}

	@AfterSuite
	public void onFinish() {

		driver.quit();
	}

}
