package BasePackage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseTest {

	protected WebDriver driver = null;
	Properties prop = new Properties();
	static int i = 0;
	public static String location = "";
	public static String SClocation = "";
	static HashMap<String, String> TestResult = new HashMap<String, String>();
	static ArrayList<String> TestCases = new ArrayList<String>();
	public static ExtentTest logger;
	public static ExtentTest child;
	@SuppressWarnings("deprecation")
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static org.apache.logging.log4j.Logger log;

	public void increment() {
		i++;
	}

	static PropertiesConfiguration p = null;

	@BeforeSuite
	public void setPath(ITestContext ctx) throws Exception {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		location = System.getProperty("user.home") + "\\Documents\\Results\\Reports\\" + getCurrentTime();
		SClocation = System.getProperty("user.home") + "\\Documents\\Results\\Screenshots\\" + getCurrentTime();
		p = new PropertiesConfiguration(System.getProperty("user.dir") + "\\Properties\\Paths.properties");
		p.setProperty("OutPutlocation", location);
		p.setProperty("SCOutPutlocation", SClocation);
		p.save();
		new File(location).mkdir();
		new File(SClocation).mkdir();
		TestRunner runner = (TestRunner) ctx;
		runner.setOutputDirectory(location + "\\");
		new Reporter().initializeReport();
		if (getProperty("Logs").equalsIgnoreCase("Yes")) {
			log = org.apache.logging.log4j.LogManager.getLogger(baseTest.class);
		}
	}

	@BeforeMethod
	public void onStart(Method m) throws Exception {

		if (getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (getProperty("Browser").equalsIgnoreCase("IE")) {
		} else {
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		increment();
		p.setProperty("OutPutlocation", location + "\\" + m.getName() + "_" + i);
		p.setProperty("SCOutPutlocation", SClocation + "\\" + m.getName() + "_" + i);
		new File("OutPutlocation", location + "\\" + m.getName() + "_" + i).mkdir();
		new File("SCOutPutlocation", SClocation + "\\" + m.getName() + "_" + i).mkdir();
		p.save();
		if(i>=2) {
			logger = extent.createTest(m.getName()+"_"+(i-1));
		}else {
			logger = extent.createTest(m.getName());
		}
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result, ITestContext ctx) throws Exception {
		extent.flush();
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestResult.put(new File(location).getName(), "pass");
			driver.quit();
		} else if (result.getStatus() == ITestResult.FAILURE) {
			TestResult.put(new File(location).getName(), "fail");
		} else {
			TestResult.put(new File(location).getName(), "skip");
		}
	}

	@AfterSuite
	public void getResult() throws IOException {
		File sfile = new File(location);
		File dfile = null;
		if (TestResult.containsValue("fail")) {
			dfile = new File(location + "[Fail]");
			location = location + "[Fail]";
		} else if (TestResult.containsValue("pass")) {
			dfile = new File(location + "[Pass]");
			location = location + "[Pass]";
		} else {
			dfile = new File(location + "[Fail]");
			location = location + "[Fail]";
		}
		sfile.renameTo(dfile);
		for (String key : TestResult.keySet()) {
			File stest = new File(location + "\\" + key);
			File dtest = new File(location + "\\" + key + "[" + TestResult.get(key) + "]");
			System.out.println(stest.renameTo(dtest));
		}
		if (new File(System.getProperty("user.dir") + "\\temp") != null) {
			new File(System.getProperty("user.dir") + "\\temp");
			FileUtils.moveFile(new File(System.getProperty("user.dir") + "\\temp\\AutomationReport.html"),
					new File(location + "\\AutomationReport.html"));
		}
		File html = new File(location + "\\AutomationReport.html");
		try {
			Desktop.getDesktop().browse(html.toURI());
			System.gc();
		}catch(Exception e) {}
	}

	public String getProperty(String Key) throws Exception {
		FileInputStream fi = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\Properties\\Config.properties"));
		prop.load(fi);
		return prop.getProperty(Key);
	}

	public String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	}

}
