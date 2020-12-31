package Reusables;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.baseTest;
import CustomException.MyException;

public class Reusables {

	BasePackage.baseTest base = new baseTest();
	WebElement element;
	BasePackage.Reporter report = new BasePackage.Reporter();

	public String callerMethod(String... method) {
		StackTraceElement e;
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		if (method.length != 0) {
			e = stacktrace[4];
		} else {
			e = stacktrace[3];
		}
		return e.getMethodName();
	}

	/***
	 * @description opens URL
	 * @param driver
	 * @throws Exception
	 */
	public void openURL(WebDriver driver) throws Exception {
		try {
			driver.get(base.getProperty("URL"));
			takeScreenshot(driver, "Opened URL");
			report.addReport(callerMethod(), "pass", "Opend URL", takeScreenshot(driver, element, "Opened URL"));
		} catch (Exception e) {
			report.addReport(callerMethod(), "fail", "unable to Opend URL",
					takeScreenshot(driver, element, "unable to Opened URL"));
			throw new MyException(e.getMessage());
		}

	}

	/***
	 * @description click on An element
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public void click(WebDriver driver, By ele, String msg) throws Exception {
		String pmsg = "clicked on " + msg;
		String fmsg = "Failed to click on " + msg;
		waitforEle(driver, ele);
		scroll(driver, ele);
		element = driver.findElement(ele);
		try {
			element.click();
			report.addReport(callerMethod(), "pass", pmsg, takeScreenshot(driver, element, pmsg));
		} catch (Exception e) {
			report.addReport(callerMethod(), "Fail", fmsg, takeScreenshot(driver, fmsg), e.getMessage());
			throw new MyException(e.getMessage());
		}
	}

	/***
	 * @description enter text into text box
	 * @param driver
	 * @param ele
	 * @param TextToEnter
	 * @throws Exception
	 */
	public void entertext(WebDriver driver, By ele, String TextToEnter, String msg) throws Exception {
		String pmsg = "Entered " + msg;
		String fmsg = "Failed to enter " + msg;
		waitforEle(driver, ele);
		scroll(driver, ele);
		element = driver.findElement(ele);
		try {
			element.sendKeys(TextToEnter);
			report.addReport(callerMethod(), "pass", pmsg, takeScreenshot(driver, element, pmsg));
		} catch (Exception e) {
			report.addReport(callerMethod(), "fail", fmsg, takeScreenshot(driver, pmsg));
			throw new MyException("Unable to " + pmsg + e.getMessage());
		}
	}

	/***
	 * @description wait for element to load
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public void waitforEle(WebDriver driver, By ele) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(base.getProperty("DefaultWaitTime")));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			report.addReport(callerMethod("wait"), "fail",
					"waited for " + base.getProperty("DefaultWaitTime") + "sec for element",
					takeScreenshot(driver, "Unable to locate element"), e.getMessage());
			throw new MyException("Unable to locate element " + ele + e.getMessage());
		}

	}

	/***
	 * @description take screenshot
	 * @param driver
	 * @throws Exception
	 */
	public String takeScreenshot(WebDriver driver, WebElement ele, String pmsg) throws Exception {
		File scrFile = null;
		if (getScreenshot()) {
			if (base.getProperty("Highlight").equalsIgnoreCase("yes")) {
				try {
					String attr = ele.getAttribute("style");
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", ele);
					scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', '" + attr + "')",
							element);
				} catch (Exception e) {
					scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				}
			} else {
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			}
			String SClocation = base.getProperty("SCOutPutlocation") + "\\" + pmsg + ".JPEG";
			FileUtils.copyFile(scrFile, new File(SClocation));
			return SClocation;
		}
		return null;
	}

	/***
	 * @description fail case Screenshot
	 * @param driver
	 * @param pmsg
	 * @throws Exception
	 */
	public String takeScreenshot(WebDriver driver, String pmsg) throws Exception {
		File scrFile = null;
		if (getScreenshot()) {
			try {
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			} catch (Exception e) {
				throw new AssertionError(e.getMessage());
			}
			String SClocation = base.getProperty("SCOutPutlocation") + "\\" + pmsg + ".JPEG";
			FileUtils.copyFile(scrFile, new File(SClocation));
			return SClocation;
		}
		return null;
	}

	/***
	 * @description scroll functionality
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public void scroll(WebDriver driver, By ele) throws Exception {
		try {
			element = driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}

	}

	/***
	 * @description return screen shot required
	 * @return
	 * @throws Exception
	 */
	public boolean getScreenshot() throws Exception {
		if (base.getProperty("ScreenshotMode").equalsIgnoreCase("All")
				|| base.getProperty("ScreenshotMode").equalsIgnoreCase("pass")) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * @description verify element present on screen
	 * @return
	 */
	public boolean isElementDisplayed(WebDriver driver, By ele) {
		try {
			element = driver.findElement(ele);
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/***
	 * @description verify the element with given text
	 * @param driver
	 * @param ele
	 * @throws MyException
	 */
	public boolean verfiyText(WebDriver driver, By ele, String TextToBeVerified) throws MyException {
		String pmsg = "Element verified";
		try {
			waitforEle(driver, ele);
			scroll(driver, ele);
			element = driver.findElement(ele);
			if (element.getText().equalsIgnoreCase(TextToBeVerified)) {
				report.addReport(callerMethod(), "pass", pmsg, takeScreenshot(driver, element, pmsg));
				return true;
			} else {
				report.addReport(callerMethod(), "fail",
						"Expected Text:" + TextToBeVerified + " But Actual is:" + element.getText(),
						takeScreenshot(driver, element, pmsg));
				throw new MyException("Expected Text:" + TextToBeVerified + " But Actual is:" + element.getText());
			}
		} catch (Exception e) {
			throw new MyException("Unable to fin element");
		}
	}

	/***
	 * @description verify given element enabled for edit or not
	 * @param driver
	 * @param ele
	 * @return
	 */
	public boolean isEnabled(WebDriver driver, By ele) {
		try {
			waitforEle(driver, ele);
			scroll(driver, ele);
			element = driver.findElement(ele);
			if (element.isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
