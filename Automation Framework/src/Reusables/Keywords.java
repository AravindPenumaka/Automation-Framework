package Reusables;

import java.time.Duration;
import java.util.NoSuchElementException;

import BasePack.Screenshot;
import ExcelUtility.getExcelData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import Reporting.addReport;

public class Keywords extends BasePack.BaseClass {
	addReport report = new addReport();
	Screenshot sc = new Screenshot();
	getExcelData data = new getExcelData();
	public String scpath = "";
	public String status = "";
	
	/***
	 * @description opens URL
	 * @param URLData
	 */
	public void openURL(String URLData){
		try{
			driver.manage().deleteAllCookies();
			driver.get(data.getURL(URLData));
			driver.manage().window().maximize();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/***
	 * @description performs click operation.
	 * @param loc
	 * @param msg
	 */
	public void click(By loc, String msg) {

		try {
			scpath = sc.getScreenshot(loc,msg);
			driver.findElement(loc).click();
			status = "cliked on " + msg;
		} catch (Exception e) {
			try {
				Fluentwait(loc);
				click(loc, msg);
				status = "cliked on " + msg;
			} catch (Exception f) {
				status = "unable clik on " + e;
				Assert.fail("Unable to Click");
			}
		}
		report.AssetMessage(scpath, status,getMethodName());
	}
	
	public void SimpleClick(By loc){

		try {
			driver.findElement(loc).click();
		} catch (Exception e) {
			try {
				Fluentwait(loc);
				SimpleClick(loc);
			} catch (Exception f) {
				Assert.fail("Unable to Click");
			}
		}
	}

	/***
	 * @description Enters Text into fields.
	 * @param loc
	 * @param textToEnter
	 * @param msg
	 */
	public void enterText(By loc, String textToEnter, String msg) {

		try {
			SimpleClick(loc);
			driver.findElement(loc).clear();
			driver.findElement(loc).sendKeys(textToEnter);
			scpath = sc.getScreenshot(loc,msg);
			status = "entered text " + msg;
		} catch (Exception e) {
			try {
				Fluentwait(loc);
				click(loc, msg);
				status = "entered text " + msg;
			} catch (Exception f) {
				status = "unable to enter text " + e;
				Assert.fail("Unable to Enter text");
			}
		}
		report.AssetMessage(scpath,status,getMethodName());
	}

	/***
	 * @description Wait for element to be located
	 * @param loc
	 */
	public void Fluentwait(By loc) {

		try {
			/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(AssertionError.class);*/
			WebDriverWait wait = new WebDriverWait(driver, 30);
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
		StackTraceElement e = stacktrace[3];
		return e.getMethodName();
	}
	
	/***
	 * @description returns true if element present on screen
	 * @param loc
	 * @return
	 */
	public boolean isElementPresent(By loc){
		
		try{
			if(driver.findElement(loc).isDisplayed()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

}
