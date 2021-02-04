package frameworkFactory;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import functionLibrary.ApplicationFunctions;
import utilities.ImageInToPPT;

/**
 * BaseTestSuite Class consists of methods that are commonly used across all Tests.
 * 
 */

public class BaseTestSuite {

	public static String url = null;
	String classname =null;
	private static String tool;	
	HSSFSheet sheet;
	HSSFWorkbook workbook;
	public static String testSheetPath = null;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public TestListener testlistener;
	public ApplicationFunctions appFunc;
	
	private static String fileSeperator = System.getProperty("file.separator");
	public String testName;
	private String reportPath;
	private String reportFolderPath;
	public static String folderPath = null;
	private static String imgpath;
	String TestInputDataSheetPath=null;

	Properties properties = new Properties();
	public static String methodname;
	private String browser;
	public static String screenShotCapture;
	public static String imgToPPT;
	
	public void GetProperties(String excelsheet) throws IOException {	

		properties.load(new FileInputStream("App.properties"));
		tool  = properties.getProperty("tool");
		
		if(excelsheet.contains("sanity")){
			testSheetPath = properties.getProperty("Sanity_TestDataSheet");
		} else {
			testSheetPath = properties.getProperty("TestDataSheet");
		}
		System.out.println(tool);
	}
	
	public String getScreenShotPath(){
		String screenShotPath = folderPath + "ScreenShots" + fileSeperator + getMethod() +fileSeperator;
		return screenShotPath;
	}
	
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "sanityExcelSheet" })
	public void setUp(@Optional("NGS_TestData") String excelSheet) throws IOException {		

		GetProperties(excelSheet);
		String browser = readInputControlVariables("Browser", 6);
		imgToPPT = readInputControlVariables("PPTFormat", 6);
		classname  = this.getClass().getSimpleName();
		reportFolderPath = readInputControlVariables("Result Path", 6)
				+ new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date()) + fileSeperator + browser.toLowerCase() + fileSeperator;
		reportPath = reportFolderPath + "ExecutionReport_"
				+ new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date()) + ".html";
		System.out.println(classname); 
		extent = ReportManager.getReporter(reportPath);
       
		this.folderPath = reportFolderPath;
		this.browser =browser;
	}
	
	/**
	 * Method initialize() initializes the driver object to launch a browser.	 
	 * @throws InterruptedException 
	 */

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "grid", "gridurl" })
	public void initialize(ITestContext context, Method method, @Optional("no") String grid, @Optional("http://localhost:4444/wd/hub") String gridurl)	throws IOException, InterruptedException {
		
		String methodname = method.getName();
		this.methodname = methodname;
		logger=extent.startTest(methodname);
				
		logger.log(LogStatus.INFO, "Start Of Execution----"+methodname,"");
		screenShotCapture = readInputExecutionSheetValue(methodname, 6 , "Execution_Sheet");
		System.out.println(tool);
		
		try {
			if (grid.equalsIgnoreCase("yes")) {
				driver = remortDriverSetUp("WINDOWS", "chrome", gridurl);
			} else {
				driver = getDriver(tool, browser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		testlistener= PageFactory.initElements(driver, TestListener.class);
		appFunc = new ApplicationFunctions(driver,logger);
	}
	
	public WebDriver remortDriverSetUp(@Optional("WINDOWS") String platform, @Optional("chrome") String browser, String gridurl)
			throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();

		if (browser.equals("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
		} else if (browser.equals("internet explorer")) {
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
		} 
		driver = new RemoteWebDriver(new URL(gridurl), capability);
		return driver;
	}
	
	/**
	 * List of all Browser currently supported by Selenium Web Driver.
	 */
	public enum DriverSupportedBrowsers {
		FIREFOX, CHROME, IE;
	}
	
	/**
	 * This Method is used to instantiate the respective driver with its browser
	 * type and version being passed. Method updates the newly instantiated
	 * driver to the driver thread pool list {@link #drivers}
	 * 
	 * @param browser
	 * @param browserVersion
	 *            TODO
	 * @return WebDriver
	 * @throws DataSourceException
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws Exception
	 */

	protected WebDriver getDriver(String tool,String browser) throws IOException, InterruptedException {
		System.out.println("Driver started : " + tool + " and Browser is : "+ browser );
		WebDriver driver = getNewDriver(DriverSupportedBrowsers.valueOf(browser.toUpperCase()), "", "");
		System.out.println("Succesfully instantiated driver :: " + tool +"&"+ browser);
		return driver;
	}

	/**
	 * This Method initializes the driver by taking driver type as the main input.
	 * 
	 * @param driverType
	 * @param browserVersion
	 * @param platform
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static WebDriver getNewDriver(DriverSupportedBrowsers driverType,String browser, String platform) throws IOException, InterruptedException {

		WebDriver driver;
		switch (driverType) {

		case CHROME:
		    System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\2.46\\chromedriver.exe");
		  	driver = new ChromeDriver();
		  	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    return driver;
		case IE:
			  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");	
			  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			  capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			  capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			  capabilities.setCapability("allow-blocked-content", true);
			  capabilities.setCapability("allowBlockedContent", true);
			  capabilities.setCapability("requireWindowFocus", true);
			  driver = new InternetExplorerDriver(capabilities);
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  return driver;
		default:
			throw new InvalidParameterException("You must choose one of the defined driver types");
		}
		
	}


	@AfterMethod
	public void tearDown(Method m, ITestResult result){

		try{
			if (result.getStatus() == ITestResult.FAILURE) 
			{
				String imgname = testlistener.takeScreenShot(result, folderPath);
				String imgpath = imgname;
				logger.log(LogStatus.FAIL, "Failed_Screenshot :-- <a href='"+ imgpath +"' target='_blank' style='color:red'> click here </a>", " "); 
				String x= result.getThrowable().toString();
				
				/*String testClassName = result.getInstance().getClass().getSimpleName();
				StringWriter sw =  new StringWriter();
				result.getThrowable().printStackTrace(new PrintWriter(sw));
				logger.log(LogStatus.FAIL, "Test Failed :----  " + sw.toString());*/
				
				System.out.println();
				logger.log(LogStatus.FAIL, "Test Failed :----  " + x , " ");
				writeExcelResult( m ,"Fail");
			} 
			else if (result.getStatus() == ITestResult.SUCCESS)
			{
				String imgname = testlistener.takeScreenShot(result, folderPath);
				String imgpath = imgname;
				logger.log(LogStatus.PASS, "TEST PASSED :-- <a href='"+ imgpath +"' target='_blank' style='color:green'> screen shot </a>", " " );
				writeExcelResult( m ,"Pass");
			} 
			else if (result.getStatus() == ITestResult.SKIP)
			{
				logger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable(), " ");
			} 
			
		} catch(Exception e){
			e.printStackTrace();
		}
			System.out.println("------End Execution of TestCase :"+m.getName()+ "-------------------");
			
			if(imgToPPT.equals("Yes")){
				ImageInToPPT imgToPpt = new ImageInToPPT();
				imgToPpt.addImageInToSlide(getScreenShotPath(),m);
			}
			extent.endTest(logger); 
			extent.flush();
			driver.close();
			driver.quit();
	}	
	
	@AfterSuite
	public void getResults() {
		
		File htmlFile = new File(reportPath);
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
			System.gc();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getMethod(){
		return methodname;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream("App.properties"));
		System.out.println("--Terst HCA----" + pro.getProperty("TestSheetPath"));
	}


	public WebElement waitForVisibilityOfElement(final WebElement element) {

		final long startTime = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
		int tries = 0;
		boolean found = false;
		WebElement elem = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {
			try {
				elem = wait.until(ExpectedConditions.visibilityOf(element));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {

		} else {
			/*close();
			log.info("Failed to find element after " + totalTime + " milliseconds.");*/
		}
		return elem;
	}
	
	
	
	public boolean elementIsPresent(WebElement element) {
	    try {
	        element.isDisplayed();
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public void writeExcelResult(Method method, String resultStatus) throws FileNotFoundException, IOException {
		String TestCasePath = System.getProperty("user.dir") + "\\src\\test\\resources\\InputData\\" + testSheetPath;
		workbook = new HSSFWorkbook(new FileInputStream(new File(TestCasePath)));
		sheet = workbook.getSheet("Execution_Sheet");
		int intRowNum = sheet.getPhysicalNumberOfRows();
		
		for (int i = 1; i < intRowNum; i++) {
			HSSFRow Exlrow = sheet.getRow(i);
			String testCaseName = Exlrow.getCell(2).getStringCellValue();
			
			if (testCaseName.equals(method.getName())) {
				int ColumnCount = Exlrow.getPhysicalNumberOfCells();
				
				for (int j = 0; j <= ColumnCount; j++) {
					String sheetHeader = sheet.getRow(0).getCell(j).getStringCellValue();
					
					if (sheetHeader.equalsIgnoreCase("ExecutionStatus")) {
						if (resultStatus.equalsIgnoreCase("Pass")) {
							sheet.getRow(i).createCell(j).setCellValue("Pass");
							HSSFCellStyle cell = workbook.createCellStyle();
							cell.setFillForegroundColor(IndexedColors.GREEN.getIndex());
							cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setAlignment(cell.ALIGN_CENTER);
							
							cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
							cell.setBorderBottom(cell.BORDER_MEDIUM);
							
							Font font = workbook.createFont();
							font.setColor(IndexedColors.WHITE.getIndex());
							cell.setFont(font);
							sheet.getRow(i).getCell(j).setCellStyle(cell);
						
						}else if(resultStatus.equalsIgnoreCase("Fail")){
							sheet.getRow(i).createCell(j).setCellValue("Failed");
							HSSFCellStyle cell = workbook.createCellStyle();
							cell.setFillForegroundColor(IndexedColors.RED.getIndex());
							cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setAlignment(cell.ALIGN_CENTER);
							
							cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
							cell.setBorderBottom(cell.BORDER_MEDIUM);
							
							Font font = workbook.createFont();
							font.setColor(IndexedColors.WHITE.getIndex());
							cell.setFont(font);
							sheet.getRow(i).getCell(j).setCellStyle(cell);
						}

						FileOutputStream fout = new FileOutputStream(TestCasePath);
						workbook.write(fout);
						break;
					}
				}
				break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	public String readInputExecutionSheetValue(String rowName ,int colNum, String sheetName) throws FileNotFoundException, IOException{
		
		int testCase = 2;
		properties.load(new FileInputStream("App.properties"));
		workbook = new HSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\InputData\\" + testSheetPath)));		  		  
		sheet = workbook.getSheet(sheetName);
		  int intRowNum = sheet.getPhysicalNumberOfRows();
		  String value = null;
		  for(int i =1;i<intRowNum;i++)
			{
			  try{
				  HSSFRow Exlrow = sheet.getRow(i);
				  String flag = Exlrow.getCell(testCase).getStringCellValue();
				  if(flag.equalsIgnoreCase(rowName)){
					  value = Exlrow.getCell(colNum).getStringCellValue();
					  break;
				  }
			  } catch(Exception e){
				  //System.out.println(e);
			  }
		  }
		return value;
	}
	
	@SuppressWarnings("resource")
	public String readInputControlVariables(String rowName ,int colNum) throws FileNotFoundException, IOException{
		
		properties.load(new FileInputStream("App.properties"));
		workbook = new HSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\InputData\\" + testSheetPath)));		  		  
		sheet = workbook.getSheet("Control Variables");
		  int intRowNum = sheet.getPhysicalNumberOfRows();
		  String value = null;
		  for(int i =1;i<intRowNum;i++)
			{
			  try{
				  HSSFRow Exlrow = sheet.getRow(i);
				  String flag = Exlrow.getCell(colNum).getStringCellValue();
				  if(flag.equalsIgnoreCase(rowName)){
					  value = Exlrow.getCell(colNum+1).getStringCellValue();
					  break;
				  }
			  } catch(Exception e){
				  //System.out.println(e);
			  }
		  }
		return value;
	}
	
}


