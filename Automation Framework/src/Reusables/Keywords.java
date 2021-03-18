package Reusables;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import BasePack.Screenshot;
import BasePack.TestExceptions;
import ExcelUtility.getExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Keywords extends BasePack.BaseClass {
	Screenshot sc = new Screenshot();
	getExcelData data = new getExcelData();
	public String scpath = "";
	public String status = "";
	public int opstatus = 0;
	static String parentNode = "";

	/***
	 * @description opens URL
	 * @param URLData
	 */
	public void openURL(String URLData) {
		try {
			driver.manage().deleteAllCookies();
			driver.get(data.getURL(URLData));
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * @description performs click operation.
	 * @param loc
	 * @param msg
	 */
	public String click(By loc, String msg) {

		try {
			wait(loc);
			Handlers button = new Handlers();
			String scpath = sc.getScreenshot(msg, loc);
			opstatus = button.click(loc);
			acceptAlert();
			switch (opstatus) {
			case 0:
				status = "Pass" + "$" + "cliked on " + msg + "$" + scpath;
				break;
			case 1:
				status = "Fail" + "$" + "Unable to locate element-> " + loc.toString() + "$" + scpath;
				break;
			case 2:
				status = "Fail" + "$" + "Generic exception Unable to perform action -> " + loc.toString() + "$"
						+ scpath;
			}
		} catch (Exception e) {
			status = "Fail" + "$" + "Exception:" + e.getClass().getCanonicalName() + " Unable to locate element-> "
					+ loc.toString() + "$" + "";
		}
		return status;
	}

	/***
	 * @description Enters Text into fields.
	 * @param loc
	 * @param textToEnter
	 * @param msg
	 */
	public String enterText(By loc, String textToEnter, String msg) {

		try {
			wait(loc);
			Handlers button = new Handlers();
			opstatus = button.type(loc, textToEnter);
			String PassMsg = "Entered " + textToEnter + " on " + msg;
			String FailMsg = "Failed to Enter " + textToEnter + " in " + msg;
			switch (opstatus) {
			case 0:
				status = "Pass" + "$" + "Entered text " + textToEnter + " on " + msg + "$"
						+ sc.getScreenshot(PassMsg, loc);
				break;
			case 1:
				status = "Fail" + "$" + "Unable to locate element-> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
				break;
			case 2:
				status = "Fail" + "$" + "Generic exception Unable to enter text -> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
			}
		} catch (Exception e) {
			status = "Fail" + "$" + "Unable to Enter text in  element-> " + loc.toString() + "$" + "";
		}
		return status;
	}

	/***
	 * @description select data from drop down
	 * @param loc
	 * @param ValuetobeSelected
	 * @param msg
	 * @return
	 */
	public String select(By loc, String ValuetobeSelected, String msg) {

		try {
			wait(loc);
			Handlers button = new Handlers();
			opstatus = button.select(loc, ValuetobeSelected);
			String PassMsg = "Select " + ValuetobeSelected + " From " + msg;
			String FailMsg = "Failed to Select " + ValuetobeSelected + " From " + msg;
			switch (opstatus) {
			case 0:
				status = "Pass" + "$" + "Entered text " + ValuetobeSelected + " From " + msg + "$"
						+ sc.getScreenshot(PassMsg, loc);
				break;
			case 1:
				status = "Fail" + "$" + "Unable to locate element with text " + ValuetobeSelected + "-> "
						+ loc.toString() + "$" + sc.getScreenshot(FailMsg, loc);
				break;
			case 2:
				status = "Fail" + "$" + "Generic exception Unable to select from dropdown -> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
			}
		} catch (Exception e) {
			status = "Fail" + "$" + "Exception:" + e.getClass().getCanonicalName()
					+ " Unable to Enter text in  element-> " + loc.toString() + "$" + "";
		}
		return status;
	}

	/***
	 * @description Wait for element to be located
	 * @param loc
	 */
	public void wait(By loc) {

		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		try {
			wait2.until(ExpectedConditions.visibilityOfElementLocated(loc));
		} catch (ElementClickInterceptedException e) {
			wait2.until(ExpectedConditions.elementToBeClickable(loc));
		} catch (Exception e) {

		}
	}

	/***
	 * @description returns true if element present on screen
	 * @param loc
	 * @return
	 */
	public String isElementDisplayed(By loc, String msg) {

		try {
			wait(loc);
			Handlers button = new Handlers();
			opstatus = button.isDisplayed(loc);
			acceptAlert();
			String PassMsg = msg + " Present on screen";
			String FailMsg = msg + " Unable locate on screen";
			switch (opstatus) {
			case 0:
				status = "Pass" + "$" + "Element present on screen" + msg + "$" + sc.getScreenshot(PassMsg, loc);
				break;
			case 1:
				status = "Fail" + "$" + "Unable to locate element-> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
				break;
			case 2:
				status = "Fail" + "$" + "Generic exception Unable to Find Element -> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
			}
		} catch (Exception e) {
			status = "Fail" + "$" + "Unable to locate element  element-> " + loc.toString() + "$" + "";
		}
		return status;
	}

	/***
	 * @description validate data with the given data
	 * @param loc
	 * @param DatatoVerify
	 * @param msg
	 * @return
	 */
	public String VerifyText(By loc, String ExpectedData, String msg) {
		String actualdata = "";
		try {
			wait(loc);
			try {
				if (driver.findElement(loc).getText().equals(ExpectedData)) {
					opstatus = 0;
				} else {
					actualdata = driver.findElement(loc).getText();
					opstatus = 1;
				}
			} catch (NoSuchElementException | TimeoutException e) {
				opstatus = 1;
			} catch (Exception e) {
				opstatus = 2;
			}
			acceptAlert();
			String PassMsg = ExpectedData + " matches with onscreen data";
			String FailMsg = ExpectedData + "does not matches with onscreen data " + actualdata;
			switch (opstatus) {
			case 0:
				status = "Pass" + "$" + "Element present on screen" + msg + "$" + sc.getScreenshot(PassMsg, loc);
				break;
			case 1:
				status = "Fail" + "$" + FailMsg + "$" + sc.getScreenshot(FailMsg, loc);
				break;
			case 2:
				status = "Fail" + "$" + "Generic exception Unable to Find Element -> " + loc.toString() + "$"
						+ sc.getScreenshot(FailMsg, loc);
			}
		} catch (Exception e) {
			status = "Fail" + "$" + "Unable to locate element  element-> " + loc.toString() + "$" + "";
		}
		return status;

	}

	/***
	 * @description format xpath with data
	 * @param loc
	 * @param data
	 * @return
	 */
	public By formatString(String loc, String data) {

		try {
			return By.xpath(String.format(loc, data));
		} catch (Exception e) {
		}
		return null;
	}

	/***
	 * @description Switched to frames
	 */
	public void switchtoFrame(By loc) {

		try {
			driver.switchTo().frame(driver.findElement(loc));
		} catch (Exception e) {
		}
	}

	/***
	 * @description switch to default frame
	 */
	public void switchToDefaultFrame() {

		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}
	}

	/***
	 * @description Upload file
	 * @param loc
	 * @param fileName
	 */
	public void UploadFile(By loc, String fileName) {

		try {
			wait(loc);
			driver.findElement(loc).sendKeys(System.getProperty("user.dir") + "\\resources\\UploadFiles\\" + fileName);
		} catch (Exception e) {

		}

	}

	/***
	 * @description returns data from locator
	 * @param loc
	 * @return
	 */
	public String getText(By loc) {

		try {
			wait(loc);
			if (driver.findElement(loc).isDisplayed()) {
				return driver.findElement(loc).getText();
			} else {
				return null;
			}
		} catch (Exception e) {
		}

		return null;
	}

	/***
	 * @description Accept alerts
	 */
	public void acceptAlert() {

		try {
			if (isAlertPresent()) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
			}
		} catch (Exception e) {
		}
	}

	/***
	 * @description verify alert present
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void initializeReport() {
		reporter = new ExtentHtmlReporter(extentreportLocation);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Automation Framework");
		reporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	/***
	 * @description adding results to reports
	 * @param result
	 * @param methodname
	 * @throws Exception
	 */
	public void addReport(List<String> result, String methodname) throws Exception {

		parentNode = methodname;
		child = logger.createNode(parentNode);
		int failflag = 0;

		for (int i = 0; i < result.size(); i++) {
			String[] info = result.get(i).split("\\$");
			String StepStatus = info[0];
			String StepData = info[1];
			String screenshotPath = "";
			try {
				screenshotPath = info[2];
			} catch (ArrayIndexOutOfBoundsException e) {
				screenshotPath = "";
			}
			if (new ExcelUtility.getExcelData().getConfiguration("Screenshot").equalsIgnoreCase("yes")) {
				if (StepStatus.equalsIgnoreCase("pass")) {
					child.log(Status.PASS, StepData + "<a style='color:#32cd32;float: right'  data-featherlight = '"
							+ screenshotPath + "' href='" + scpath + "'>ScreenShot</a>");
				} else if (StepStatus.equalsIgnoreCase("fail")) {
					child.log(Status.FAIL, StepData + "<a style='color:red;float: right'  data-featherlight = '"
							+ screenshotPath + "' href='" + scpath + "'>ScreenShot</a>");
					failflag = 1;
				}
			} else {
				if (StepStatus.equalsIgnoreCase("pass")) {
					child.log(Status.PASS, StepData);
				} else if (StepStatus.equalsIgnoreCase("fail")) {
					child.log(Status.FAIL, StepData);
					failflag = 1;
				}
			}
		}
		if (failflag == 1) {
			throw new TestExceptions("Failure during test execution in the process [" + methodname + "]");
		}
	}

}
