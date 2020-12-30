package Reusables;

import java.time.Duration;
import java.util.NoSuchElementException;

import BasePack.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.base.Function;

import Reporting.addReport;

public class Keywords extends BasePack.BaseClass {
	addReport report = new addReport();
	Screenshot sc = new Screenshot();
	public String scpath = "";
	public String status = "";

	/***
	 * @description performs click operation.
	 * @param loc
	 * @param msg
	 */
	public void click(By loc, String msg) {

		try {
			scpath = sc.getScreenshot(loc);
			driver.findElement(loc).click();
			status = "cliked on " + msg;
		} catch (Exception e) {
			try {
				Fluentwait(loc);
				click(loc, msg);
				status = "cliked on " + msg;
			} catch (Exception f) {
				status = "unable clik on " + msg;
				Assert.fail("Unable to Click");
			}
		}
		report.AssetMessage(scpath, status);
	}

	/***
	 * @description Enters Text into fields.
	 * @param loc
	 * @param textToEnter
	 * @param msg
	 */
	public void enterText(By loc, String textToEnter, String msg) {

		try {
			driver.findElement(loc).sendKeys(textToEnter);
			scpath = sc.getScreenshot(loc);
			status = "entered text " + msg;
		} catch (Exception e) {
			try {
				Fluentwait(loc);
				click(loc, msg);
				status = "entered text " + msg;
			} catch (Exception f) {
				status = "unable to enter text " + msg;
				Assert.fail("Unable to Enter text");
			}
		}
		report.AssetMessage(scpath,status);
	}

	/***
	 * @description Wait for element to be located
	 * @param loc
	 */
	public void Fluentwait(final By loc) {

		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(loc));
			if(!driver.findElement(loc).isEnabled()){
				Fluentwait(loc);
			}
		} catch (Exception e) {
			Assert.fail("Unable to locate element");
			e.printStackTrace();
		}
	}

	/***
	 * @description return the parent caller method name
	 * @return
	 */
	public String getMethodName() {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[2];
		return e.getMethodName();
	}

}