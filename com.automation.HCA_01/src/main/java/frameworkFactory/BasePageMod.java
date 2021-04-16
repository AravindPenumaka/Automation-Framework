package frameworkFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectLibrary.ApplicationPages;
import automation.exceptions.generic.TestExecException;
import automation.page.element.ngs.AbstractElement;
import automation.page.element.ngs.NGSButton;
import automation.page.element.ngs.NGSCheckBox;
import automation.page.element.ngs.NGSEditBox;
import automation.page.element.ngs.NGSListBox;
import javafx.util.Pair;
import utilities.ExcelExecutionStatusReport;

@SuppressWarnings("unused")
public class BasePageMod {

	private static final long TIME_DELAY_IN_SECONDS = 0;
	private static long timeoutInSecs = 15;
	public String PAGE_URL;
	public String PAGE_TITLE;
	public String IGNORE = "!IGNORE!";
	public ExtentTest logger;
	public WebDriver driver;
	ApplicationPages appPages;
	protected int iStepExecStatus = 0;
	public BaseTestSuite btstSuite;
	private static String imgpath;
	private static String fileSeperator = System.getProperty("file.separator");
	protected Log log = LogFactory.getLog(BasePageMod.class);
	
	/*
	public BasePageMod(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}*/

	/***
	 * @author Brahma
	 * @param appUrl
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @description To open application URL
	 */
	public void openPage(String appUrl) throws FileNotFoundException, IOException {
		
		BaseTestSuite baseTestSuite = new BaseTestSuite();
		String url = baseTestSuite.readInputControlVariables(appUrl, 6);
		driver.get(url);
		logger.log(LogStatus.PASS, "Entered URL With : <a target='_blank' style='color:aqua'>" + url +"</a>" , " ");
		this.waitForPageLoad(0);
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param frameName
	 * @description Switching to frame
	 */
	public String switchToFrame(String elementName, String frameName){
		String reportString = null;
		int waitFrame = 5;
		try{
			//driver.switchTo().frame(elementName);
			 WebDriverWait wait = new WebDriverWait(driver,waitFrame);
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementName));
			sleep(1500);
			reportString = "Pass" + "~" + "switch frame" + "~" + frameName + "~" + " ";
		} catch(Exception e) {
			reportString = "Fail" + "~" + "switch frame" + "~" + frameName + "~" + "Waited for " + waitFrame;
		}
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @return String: reportString
	 * @description Switching to default frame
	 */
	public String switchToDefaultFrameContent(){
		String reportString = null;
		try{
			driver.switchTo().defaultContent();
			sleep(1500);
			reportString = "Pass" + "~" + "switch frame" + "~" + "To Default Frame" + "~" + " ";
		} catch(Exception e) {
			reportString = "Fail" + "~" + "switch frame" + "~" + "To Default Frame" + "~" + " ";
		}
		return reportString;
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description To set the value in textbox by using setValue method in NGSEditBox class.
	 */
	public String type(WebElement elementName, String input, String msg) {
		String reportString = null;
		String alertMessage = null;
		switch (input) {
		case "!IGNORE!":
			break;
		default:
			try {
				String locatorValue = returnElementValue(elementName);
				NGSEditBox editbox = new NGSEditBox(driver, elementName, msg);
 				iStepExecStatus = editbox.setValue(input);
 				alertMessage = this.handleAlert();
				String imgDesc = "Entered Value ["+ input + "] In " + msg;
				String field_imgDesc = "failed_To Enter Value ["+ input + "] In " + msg;
				switch (iStepExecStatus) {
				case 0:
					reportString = "Pass" + "~" + "type" + "~" + msg + "~" + "Value [" + input + "]" + attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "type" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				}
			} catch (Exception e) {
				e.printStackTrace();
				reportString = "Fail" + "~" + "type" + "~" + msg + "~" + e.getMessage();
			}
		}
		return reportString + alertMessage;
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param clear
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description Set value by clearing textbox by using setValue method in NGSEditBox class.
	 */
	public String type(WebElement elementName, boolean clear, String input, String msg) {
		String reportString = null;
		String alertMessage = null;
		switch (input) {
		case "!IGNORE!":
			break;
		default:
			try {
				String locatorValue = returnElementValue(elementName);
				NGSEditBox editbox = new NGSEditBox(driver, elementName, msg);
				iStepExecStatus = editbox.setValue(input, clear);
				alertMessage = this.handleAlert();
				String imgDesc = "Entered Value ["+ input + "] In " + msg;
				String field_imgDesc = "failed_To Enter Value ["+ input + "] In " + msg;
				switch (iStepExecStatus) {
				case 0:
					reportString = "Pass" + "~" + "type" + "~" + msg + "~" + "Value [" + input + "]" +attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "type" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				}
			} catch (Exception e) {
				e.printStackTrace();
				reportString = "Fail" + "~" + "type" + "~" + msg + "~" + e.getMessage();
			}
		}
		return reportString + alertMessage;
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @param clear
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description Set value by clearing textbox by using setValue method in NGSEditBox class.
	 */
	public String type(String elementName, String byLocator, boolean clear, String input, String msg) {
		String reportString = null;
		String alertMessage = null;
		switch (input) {
		case "!IGNORE!":
			break;
		default:
			try {
				WebElement element = getWebelement(byLocator, elementName);
				String locatorValue = returnElementValue(element);
				NGSEditBox editbox = new NGSEditBox(driver, element, msg);
				iStepExecStatus = editbox.setValue(input, clear);
				alertMessage = this.handleAlert();
				String imgDesc = "Entered Value ["+ input + "] In " + msg;
				String field_imgDesc = "failed_To Enter Value ["+ input + "] In " + msg;
				switch (iStepExecStatus) {
				case 0:
					reportString = "Pass" + "~" + "type" + "~" + msg + "~" + "Value [" + input + "]" +attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "type" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				}
			} catch (Exception e) {
				e.printStackTrace();
				reportString = "Fail" + "~" + "type" + "~" + msg + "~" + e.getMessage();
			}
		}
		return reportString + alertMessage;
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String: reportString
	 * @description To click on element by using click method in NGSButton class.
	 */
	public String click(WebElement elementName, String msg) {
		String reportString = null;
		String alertMessage = null;
		try {
			String locatorValue = returnElementValue(elementName);
			NGSButton button = new NGSButton(driver, elementName, msg);
			iStepExecStatus = button.click();
			alertMessage = this.handleAlert();
			String imgDesc = "Clicked On " + msg;
			String field_imgDesc = "failed_To Click On " + msg;
			switch (iStepExecStatus) {
			case 0:
				reportString = "Pass" + "~" + "click" + "~" + msg + "~" + "  " + attchedStepScreenShot(imgDesc);
				break;
			case 1:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: "+ locatorValue + attchedStepScreenShot(field_imgDesc);
				break;
			case 4:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Generic Issue. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "click" + "~" + msg + "~" + e.getMessage();
		}
		return reportString + alertMessage;
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String reportString
	 * @description To click on element with passing locator by using click method in NGSButton class.
	 */
	public String click(String elementValue, String byLocator, String msg) {
		String reportString = null;
		String alertMessage = null;
		String imgDesc = "Clicked On " + msg;
		String field_imgDesc = "failed_To Click On " + msg;
		try {
			WebElement element = getWebelement(byLocator, elementValue);
			NGSButton button = new NGSButton(driver, element, msg);
			iStepExecStatus = button.click();
			alertMessage = this.handleAlert();
			String locatorValue = returnElementValue(element);
			switch (iStepExecStatus) {
			case 0:
				reportString = "Pass" + "~" + "click" + "~" + msg + "~" + "  " + attchedStepScreenShot(imgDesc);
				break;
			case 1:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				break;
			case 4:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Generic Issue" + attchedStepScreenShot(field_imgDesc);
				break;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			e.printStackTrace();
			try {
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + elementValue + attchedStepScreenShot(field_imgDesc);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "click" + "~" + msg + "~" + getExceptionMessage(e.getMessage());
		}
		return reportString + alertMessage;
	}
	
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String reportString
	 * @description To click on element with action class method by using click method in NGSButton class.
	 */
	public String actionClick(WebElement elementName, String msg) {
		String reportString = null;
		String alertMessage = null;
		try {
			String locatorValue = returnElementValue(elementName);
			NGSButton button = new NGSButton(driver, elementName, msg);
			iStepExecStatus = button.actionClick();
			alertMessage = this.handleAlert();
			String imgDesc = "Clicked On " + msg;
			String field_imgDesc = "failed_To Click On " + msg;
			switch (iStepExecStatus) {
			case 0:
				reportString = "Pass" + "~" + "click" + "~" + msg + "~" + "  " + attchedStepScreenShot(imgDesc);
				break;
			case 1:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				break;
			case 4:
				reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Generic Issue" + attchedStepScreenShot(field_imgDesc);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "click" + "~" + elementName + "~" + e.getMessage();
		}
		return reportString + alertMessage;
	}


	/***
	 * @author Brahma
	 * @param elementName
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description To select value from dropdown field(if element will be in select tag.)
	 */
	public String select(WebElement elementName, String input, String msg) {
		String reportString = null;
		String alertMessage = "";
		switch (input) {
		case "!IGNORE!":
			break;
		case "":
			reportString = "Info" + "~" + "select" + "~" + msg + "~" + "No Value Passing InTo Dropdown.";
			break;
		default:
			try {
				NGSListBox listBox = new NGSListBox(driver, elementName, msg);
				iStepExecStatus = listBox.selectListItem(input);
				alertMessage = this.handleAlert();
				String locatorValue = returnElementValue(elementName);
				String imgDesc = "Selected Dropdown value ["+ input +"] From " + msg;
				String field_imgDesc = "failed_To Select Dropdown value '"+ input +"' From " + msg;
				switch (iStepExecStatus) {
				case 0:
					reportString = "Pass" + "~" + "select" + "~" + msg + "~" + "Dropdown value set [" + input
							+ "]" + attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~"
							+ "Element being looked is not found. For LocatorElement Is:  "+ locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 2:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 3:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 4:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Configuration issues. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				}
			} catch (Exception e) {
				reportString = "Fail" + "~" + "select" + "~" + msg + "~" + e.getMessage();
				e.printStackTrace();
			}
		}
		return reportString + alertMessage;
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description To select value from dropdown field using action class method.
	 */
	public String actionSelect(WebElement elementName, String input, String msg) {
		String reportString = null;
		String alertMessage = "";
		switch (input) {
		case "!IGNORE!":
			break;
		case "":
			reportString = "Info" + "~" + "select" + "~" + msg + "~" + "No Value Passing InTo Dropdown.";
			break;
		default:
			try {
				NGSListBox listBox = new NGSListBox(driver, elementName, msg);
				iStepExecStatus = listBox.actionSelectListItem(input);
				alertMessage = this.handleAlert();
				String locatorValue = returnElementValue(elementName);
				String imgDesc = "Selected Dropdown value ["+ input +"] From " + msg;
				String field_imgDesc = "failed_To Select Dropdown value '"+ input +"' From " + msg;
				switch (iStepExecStatus) {
				case 0:
					reportString = "Pass" + "~" + "select" + "~" + msg + "~" + "Dropdown value set [" + input
							+ "]" + attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~"
							+ "Element being looked is not found. For LocatorElement Is:  "+ locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 2:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 3:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 4:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Configuration issues. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				}
			} catch (Exception e) {
				reportString = "Fail" + "~" + "select" + "~" + msg + "~" + e.getMessage();
				e.printStackTrace();
			}
		}
		return reportString + alertMessage;
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param input
	 * @param msg
	 * @return String: reportString
	 * @description To click on dropdown field and select dropdown values(if element is not with select tag.).
	 */
	@SuppressWarnings("restriction")
	public String selectComboBoxList(WebElement elementName, String input, String msg) {
		String reportString = null;
		String alertMessage = null;
		switch (input) {
		case "!IGNORE!":
			break;
		default:
			try {
				NGSListBox listBox = new NGSListBox(driver, elementName, msg);
				Pair<Integer, String> iStepExecStatus = listBox.selectComboBoxListItem(input);
				alertMessage = this.handleAlert();
				String locatorValue = returnElementValue(elementName);
				String imgDesc = "Selected Dropdown value ["+ input +"] From " + msg;
				String field_imgDesc = "failed_To Select Dropdown value ["+ input +"] From " + msg;
				switch (iStepExecStatus.getKey()) {
				case 0:
					reportString = "Pass" + "~" + "select" + "~" + msg + "~" + "Dropdown value set [" + input
							+ "]" + attchedStepScreenShot(imgDesc);
					break;
				case 1:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~"
							+ "Unable to select dropdown value ["+ input +"] As element being looked is not found. For LocatorElement Is:  "+ locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 2:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 3:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Dropdown value [" + input
							+ "] not found. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				case 4:
					reportString = "Fail" + "~" + "select" + "~" + msg + "~" + "Configuration issues. For LocatorElement Is:  " + locatorValue + attchedStepScreenShot(field_imgDesc);
					break;
				}
			} catch (Exception e) {
				//test.log(LogStatus.FATAL, "Failed selecting the value for the element [" + elementName + "]");
				reportString = "Fail" + "~" + "selectList" + "~" + elementName + "~" + e.getMessage();
				e.printStackTrace();
			}
		}
		return reportString + alertMessage;
	}

	/***
	 * @author Brahma
	 * @param dataValue
	 * @param checkboxType
	 * @param boolCheck
	 * @return String: reportString
	 * @description Check or uncheck the check box
	 */
	public String clickCheckBox(WebElement elementName, String attributeName, boolean boolCheck, String msg) {
		String reportString = null;
		String alertMessage = null;
		try {
			NGSCheckBox checkBox = new NGSCheckBox(driver, elementName);
			iStepExecStatus = checkBox.checkAndClick(attributeName, boolCheck);
			alertMessage = this.handleAlert();
			String locatorValue = returnElementValue(elementName);
			String imgDesc = "Clicked On CheckBox " + msg;
			String field_imgDesc = "failed_To Click On CheckBox " + msg;
			switch (iStepExecStatus) {
			case 0:
				reportString = "Pass" + "~" + "clickCheckBox" + "~" + msg + "~" + " " + attchedStepScreenShot(imgDesc);
				break;
			case 1:
				reportString = "Fail" + "~" + "clickCheckBox" + "~" + msg + "~"
						+ "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
				break;
			case 2:
				reportString = "Fail" + "~" + "clickCheckBox" + "~" + msg + "~" + " " + attchedStepScreenShot(field_imgDesc);
				break;
			case 4:
				reportString = "Fail" + "~" + "clickCheckBox" + "~" + msg + "~" + "Configuration issues." + attchedStepScreenShot(field_imgDesc);
				break;
			}
		} catch (Exception e) {
			reportString = "Fail" + "~" + "clickCheckBox" + "~" + msg +  "~" + e.getMessage();
			e.printStackTrace();
		}
		return reportString + alertMessage;
	}
	
	
	public String selectRadioBtn(String elementName, String input) {
		String reportString = null;
		switch (input) {
		case "!IGNORE!":
			break;
		default:
			try {
				this.handleAlert();
				int iStatus =1;
				switch (iStatus) {
				case 0:
					reportString = "Pass" + "~" + "selectRadioBtn" + "~" + elementName + "~" + "Clicked the option ["
							+ input + "]";
					break;
				case 1:
					reportString = "Fail" + "~" + "selectRadioBtn" + "~" + elementName + "~"
							+ "Element being looked is not found";
					break;
				case 5:
					reportString = "Fail" + "~" + "selectRadioBtn" + "~" + elementName + "~" + "Option [" + input
							+ "] not found.";
					break;
				case 3:
				case 4:
					reportString = "Fail" + "~" + "selectRadioBtn" + "~" + elementName + "~" + "Configuration issues.";
					break;
				}
			} catch (Exception e) {
				reportString = "Fail" + "~" + "selectRadioBtn" + "~" + elementName + "~" + e.getMessage();
				e.printStackTrace();
			}
		}
		return reportString;
	}

	public String textOf(String elementName) {
		String eleInnertext = null;
		String reportString = null;
		try {
			if(driver.findElement(By.id(elementName)) != null){
				List<WebElement> webEleList = driver.findElements(By.id(elementName));
				eleInnertext = webEleList.get(0).getText();
				reportString = "Pass" + "~" + "textOf" + "~" + elementName + "~" + " ";
			}
		} catch (NullPointerException e) {
			return "null";
					
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "textOf" + "~" + elementName + "~" + e.getMessage();
		}
		return eleInnertext + "~~~" + reportString;
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @return String: reportString
	 * @description Verify loaded page by page Title
	 */
	public String loadPage(String elementName) {
		String t = textOf(elementName).split("~~~")[0];
		String reportString = null;	
		Boolean bPageFound = t.contains(getPageTitle());			   
		if (bPageFound) {
			reportString = "Pass" + "~" + "loadPage" + "~" + elementName + "~" + t +" Page loaded successfully. ";

		} else {
			reportString = "Fail" + "~" + "loadPage" + "~" + elementName + "~" + "Page not loaded successfully. ";
		}
		return reportString;
	}

	public String getPageTitle() {
		return PAGE_TITLE;
	}
	
	public void testfail(ExtentTest test, String description) {
		if (test.getRunStatus() != LogStatus.PASS) {
//			test.log(LogStatus.FAIL, description + test.addScreenCapture(this.stepAttachment()));
		} else {
			test.getTest().setStatus(LogStatus.PASS);
			test.getRunStatus();
		}
	}

	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String: reportString
	 * @description To verify element is present on screen
	 */
	public String isPresentAndDisplayed(WebElement elementName, String msg) {
		String reportString = null;
		try {
			if (elementName != null) {
				reportString = "Pass" + "~" + "verifyIsPresent" + "~" + msg + "~" + "Present On Screen";
				
			} else {
				reportString = "Fail" + "~" + "verifyIsPresent" + "~" + msg + "~" + "Unable To Find On Screen ";
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			reportString = "Fail" + "~" + "verifyIsPresent" + "~" + msg + "~" + "No such element Present";
		}
		log.info(reportString);
		return reportString;
	}

	/***
	 * @author Brahma
	 * @param text
	 * @return Boolean
	 * @description To get the page source details and verify with text value.
	 */
	public boolean isTextPresent(String text) {
		if (driver.getPageSource().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author Brahma
	 * @param locator
	 * @param elementName
	 * @return String: reportString
	 * @description Hover element to show sub menu
	 */
	public String moveTo(String locator, String elementName) {
		String reportString = null;
		Actions action = new Actions(driver);
		WebElement webEle;
		try {
			webEle = getWebelement(locator, elementName);
			action.moveToElement(webEle);
			action.build().perform();
			reportString = "Pass" + "~" + "moveTo" + "~" + elementName + "~" + " ";
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "moveTo" + "~" + elementName + "~" + e.getMessage();
		}
		return reportString;
	}
	
	
	/***
	 * @author Brahma
	 * @param reportData
	 * @param processName
	 * @throws TestExecException
	 * @description To create report in tabular format in our html report. 
	 */
	public synchronized void createReportTableEntry(List<String> reportData, String processName) throws TestExecException {
		String tableHeader = "<ul class='collapsible' data-collapsible='accordion'> " + "<li class='displayed'> "
				+ " <div class='collapsible-header'> " + "<div class='left'> " + "<b>" + processName + "</b>"
				+ "</div> </div>" + "<div class='collapsible-body'>" + "<div>"
				+ "<table class='bordered table-results'> <thead> " + "<tr><th>Status</th>" + "<th>Action</th>"
				+ "<th>Element</th>" + "<th>Message</th>" + "</tr></thead> <tbody>";
		String tableEnd = "</tbody></table></div></div></li></ul>";
		String tableRecords = "";
		boolean boolFailInd = false;
		boolean boolError = false;
		System.out.println(reportData);
		List<String> reportDataStart = new ArrayList<String>();
		String reportString = "Info" + "~" + processName + "~Start~" + " ";
		reportDataStart.add(reportString);
		reportData = concatList(reportDataStart,reportData);
		for (int i = 0; i < reportData.size(); i++) {
			try {
				String[] strRecord;
				strRecord = reportData.get(i).split("~");
				tableRecords = tableRecords + "<tr>";
				
				if (strRecord[0].equalsIgnoreCase("PASS")) {
					tableRecords = tableRecords
							+ "<td width='10%' class='status pass' title='pass' alt='pass'><i class='mdi-action-check-circle'></i></td>";
				} else {
					if (strRecord[0].equalsIgnoreCase("INFO"))
					{
						tableRecords = tableRecords
								+ "<td width='10%' class='status info' title='info' alt='info'><i class='mdi-action-info-outline'></i></td>";
					}
					else if(strRecord[0].equalsIgnoreCase("ERROR"))
					{
						boolError = true;
						tableRecords = tableRecords
								+ "<td width='10%' class='status error' title='error' alt='error'><i class='mdi-alert-error'></i></td>";
					}else {
						boolFailInd = true;
						tableRecords = tableRecords
							+ "<td width='10%' class='status fail' title='fail' alt='fail'><i class='mdi-navigation-cancel'></i></td>";
					}
				}
				
				/*if(strRecord[3].contains(":-@")){
					String popMsg = strRecord[3].split(":-@")[1];
					tableRecords = tableRecords
							+ "<td width='10%' class='status alert' title='add_alert' alt='add_alert'><i class='mdi-alert-warning' style='color:yellow'></i></td>";
					tableRecords = tableRecords + "<td width='25%' >" + "Alert" + "</td>" + "<td width='25%'>" + "Alert Message" + "</td>" + "<td width='40%'>"
							+ popMsg + "</td>" + "</tr> ";
					strRecord[3] = strRecord[3].replace(":-@"+ popMsg, "");
					System.out.println(strRecord[3]);
				}*/
				
				if(strRecord[3].contains(":-@")){
					String popMsg = strRecord[3].split(":-@")[1];
					strRecord[3] = strRecord[3].replace(":-@"+ popMsg, "");
					System.out.println(strRecord[3]);
					tableRecords = tableRecords + "<td width='25%' >" + strRecord[1] + "</td>" + "<td width='25%'>" + strRecord[2] + "</td>" + "<td width='40%'>"
							+ strRecord[3] + "</td>" + "</tr> ";
					
					tableRecords = tableRecords
							+ "<td width='10%' class='status alert' title='add_alert' alt='add_alert'><i class='mdi-alert-warning' style='color:yellow'></i></td>";
					tableRecords = tableRecords + "<td width='25%' >" + "Alert" + "</td>" + "<td width='25%'>" + "Alert Message" + "</td>" + "<td width='40%'>"
							+ popMsg + "</td>" + "</tr> ";
				} else{
					tableRecords = tableRecords + "<td width='25%' >" + strRecord[1] + "</td>" + "<td width='25%'>" + strRecord[2] + "</td>" + "<td width='40%'>"
							+ strRecord[3] + "</td>" + "</tr> ";
				}
				
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(reportData.get(i));
			}
		}
		tableRecords = tableRecords + "<tr><td width='10%' class='status info' title='info' alt='info'><i class='mdi-action-info-outline'></i></td><td width='25%'>" 
		                            + processName + "</td>" + "<td width='25%'>End</td>" + "<td width='40%'></td></tr> ";
		if (boolFailInd) {
			this.logger.log(LogStatus.FAIL, tableHeader + tableRecords + tableEnd);
			throw new TestExecException("Failure during test execution in the process [" + processName + "]");
			
		}
		else if(boolError){
			this.logger.log(LogStatus.ERROR, tableHeader + tableRecords + tableEnd);
		}
		else {
			this.logger.log(LogStatus.PASS, tableHeader + tableRecords + tableEnd);
		}
	}

	@SafeVarargs
	public static <T> List<T> concatList(List<T>... collections) {
		return Arrays.stream(collections).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	/****
	 * @Purpose: Wait for Java script load to get completed
	 ****/
	public void waitForJSLoad() {
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
		}
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @throws Exception 
	 * @description To click using java script executor.
	 */
	public String JSClick(WebElement element, String msg) throws Exception {
		String reportString;
		String locatorValue = returnElementValue(element);
		String imgDesc = "Clicked On " + msg;
		String field_imgDesc = "failed_To Click On " + msg;
		try{
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			reportString = "Pass" + "~" + "click" + "~" + msg + "~" + "  " + attchedStepScreenShot(imgDesc);
		} catch (Exception e){
			reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + attchedStepScreenShot(field_imgDesc);
		}
		return reportString;
	}
	
	
	/***
	 * @author Brahma
	 * @param element
	 * @throws Exception 
	 * @description To click using java script executor.
	 */
	public String JSType(String elementName, String byLocator, String input, String msg) throws Exception {
		String reportString;
		String locatorValue = null ;
		String imgDesc = "Clicked On " + msg;
		String field_imgDesc = "failed_To Click On " + msg;
		try{
			WebElement element = getWebelement(byLocator, elementName);
			locatorValue = returnElementValue(element);
			String getWebElementID = element.getAttribute("ID");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById('" + getWebElementID + "').value=''");
			sleep(1200);
			js.executeScript("document.getElementById('" + getWebElementID + "').value='"+ input + "'");
			reportString = "Pass" + "~" + "type" + "~" + msg + "~" + "Value [" + input + "]" +attchedStepScreenShot(imgDesc);
		} catch (Exception e){
			
			reportString = "Fail" + "~" + "click" + "~" + msg + "~" + "Element being looked is not found. For LocatorElement Is: " + locatorValue + getExceptionMessage(e.getMessage()) + attchedStepScreenShot(field_imgDesc);
		}
		return reportString;
	}
	
	
	/***
	 * @author Brahma
	 * @param element
	 * @return String: elementValue
	 * @description To get element locator with path
	 */
	public String returnElementValue(WebElement element){
		String elementValue = null;
		String alertMessage = null;
		try{
			elementValue = element.toString();
			if(elementValue.contains("->")){
				String[] splipValue = elementValue.split("->");
				elementValue = splipValue[1];
			}else if(elementValue.contains("By.")){
				String[] splipValue = elementValue.split("By.");
				elementValue = splipValue[1];
			} else {
				return elementValue;
			}
		} catch(UnhandledAlertException alert){
			alertMessage = this.handleAlert();
			System.out.println(alertMessage);
		} catch(Exception e){
			return e.getMessage();
		}
		return "["+elementValue;
	}
	
	/***
	 * @author Brahma
	 * @param milliseconds
	 * @return Boolean: true/false
	 * @description To wait for perticular period of time.
	 */
	public boolean sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @param durationInSecs
	 * @description: Wait for page load default 60 seconds and check for Javascript load completed
	 *           and wait additional seconds if parameter supplied is greater than 0
	 */
	public void waitForPageLoad(int durationInSecs) {
		driver.manage().timeouts().implicitlyWait(TIME_DELAY_IN_SECONDS, TimeUnit.SECONDS);
		this.waitForJSLoad();
		if (durationInSecs > 0) {
			try {
				Thread.sleep(durationInSecs * 1000);
			} catch (InterruptedException e) {
				System.out.print("Exception while wait.");
			} 
		}
	}
	
	/***
	 * @author Brahma
	 * @param locator
	 * @param value
	 * @return WebElement
	 * @description To get WebElement using locator with value.
	 */
	public WebElement getWebelement(String locator, String value){
		WebElement element = findElementBy(webLocators.valueOf(locator.toUpperCase()),value);
		return element;
	}
	
	public enum webLocators {
		CSS, CLASS, ID, XPATH, LINK_TEXT, NAME, PARLINK_TEXT, TAG_NAME;
	}
	
	public WebElement findElementBy(webLocators locator, String value) {
		switch (locator) {
			case CSS:
				return driver.findElement(By.cssSelector(value));
			case CLASS:
				return driver.findElement(By.className(value));
			case ID:
				return driver.findElement(By.id(value));
			case XPATH:
				return driver.findElement(By.xpath(value));
			case LINK_TEXT:
				return driver.findElement(By.linkText(value));
			case NAME:
				return driver.findElement(By.name(value));
			case PARLINK_TEXT:
				return driver.findElement(By.partialLinkText(value));
			case TAG_NAME:
				return driver.findElement(By.tagName(value));
			default:
				return null;
		}
	}
	
	/***
	 * @author Brahma
	 * @param timeoutInSecs
	 * @description Wait Till Loading Icon To Be Gone
	 */
	public void waitForLoadingIconGone_CRM(long timeoutInSecs){
		//String plsWaitIcon = "/html/body/div[@id='pleaseWaitGlassPane' and contains(@style,'display: none;')] | //a[@id='s_s0_aab::skip' and contains(@style,'display: none;')]";
		try{
			String loadingIcon = "//div[@id='maskoverlay' and contains(@style,'display: none;')]";
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
			wait.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loadingIcon)));
			sleep(1500);
			wait.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loadingIcon)));
		} catch(UnhandledAlertException e){
			System.out.println(e);
		}
		
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param msg
	 * @return String: reportString
	 * @throws IOException
	 * @description Wait Till Element To Be Visible
	 */
	public String waitForVisibilityOfElement(final WebElement element, String msg) throws IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream("App.properties"));
		int waitTime  = Integer.parseInt(properties.getProperty("explicitWaitLoad"));
		String reportString = null;
		final long startTime = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);

		boolean found = false;
		WebElement elem = null;
		while ((System.currentTimeMillis() - startTime) < waitTime) {
			try {
				elem = wait.until(ExpectedConditions.visibilityOf(element));
				this.highLightElement(element);
				found = true;
				break;
			}catch (Exception e) {
				found = false;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found)
		{
			reportString = "Pass" + "~" + "WaitForVisibility" + "~" + "Find Element For" + "~" + msg;
		} else {
			reportString = "Fail" + "~" + "WaitForVisibility" + "~" + "Element Not Found For " + "~" + msg + " in " + totalTime
					+ " milliseconds.";
		}
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param desc
	 * @param funEndScreenShot
	 * @return String: image path
	 * @throws Exception
	 * @description To capture screenshots and show it in report during "onEachStep" and "onEachFunctionality".
	 */
	@SuppressWarnings("static-access")
	public String attchedStepScreenShot(String desc, Object...funEndScreenShot) throws Exception{
		try{
			btstSuite = new BaseTestSuite();
			String screenShotCapture = btstSuite.screenShotCapture;
			String imgfolderPath= btstSuite.getScreenShotPath();
			 if(screenShotCapture.equals("onEachStep")){
				 try{
					 if(funEndScreenShot[0].equals("Yes")){
							String imgname = takeScreenShot(imgfolderPath, desc);
							String image= logger.addScreenCapture(imgname);
							return image;
						 }else if(funEndScreenShot[0].equals("No")){
							 return " ";
						 }
				 } catch(ArrayIndexOutOfBoundsException e){
					String imgname = takeScreenShot(imgfolderPath, desc);
					String report = " #For ScreenShot <a href='"+ imgname +"' target='_blank' style='color:yellow'> click here </a>";
					return report;
				 }
			 }else if(screenShotCapture.equals("No")){
				 return " ";
				 
			 }else if(screenShotCapture.equals("onEachFunctionality")){
				 try{
					 if(desc.contains("failed_")){
						String imgname = takeScreenShot(imgfolderPath, desc);
						String report = " #For ScreenShot <a href='"+ imgname +"' target='_blank' style='color:yellow'> click here </a>";
						return report;
					 }
					 if(funEndScreenShot[0].equals("Yes")){
							String imgname = takeScreenShot(imgfolderPath, desc);
							String image= logger.addScreenCapture(imgname);
							return image;
						 }else{
							 return " ";
						 }
				 } catch(ArrayIndexOutOfBoundsException e){
					 return " ";
				 }
			 }
			return null;
		}catch (NullPointerException e){
			return " ";
		}
	}
	
	/***
	 * @author Brahma
	 * @param imgfolderPath
	 * @param eleName
	 * @return String: imagepath
	 * @description To capture screenshots and place it in proper path.
	 */
	public String takeScreenShot(String imgfolderPath, String eleName) {

		String fileName = null;
		try {
			File scrnshot;
			fileName = eleName + "_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date()) + ".jpeg";
			scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenShotPath = imgfolderPath + fileSeperator + fileName;
			FileUtils.copyFile(scrnshot, new File(screenShotPath));
			//this.imgpath = screenShotPath;
			this.imgpath = "ScreenShots\\" + btstSuite.getMethod() + "\\"+fileName;
		} catch (Exception e) {
			System.out.println("Exception occurred while taking the screenshot.");
			e.printStackTrace();
		}
		return imgpath;
	}
	
	/***
	 * @author Arpita
	 * @param element
	 * @param msg
	 * @throws Exception 
	 * @description Scroll till web-element to view
	 */
	public String scrollToView(WebElement element, String msg) throws Exception{
		 String reportString = null;
		 String imgDesc = "Scrolled To " + msg;
		 String field_imgDesc = "failed_To Scroll Till " + msg;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 try{
			 sleep(300);
             js.executeScript("arguments[0].scrollIntoView(true);", element);
             this.highLightElement(element);
             sleep(1500);
             reportString = "Pass" + "~" + "Scroll To" + "~" + msg + "~" + " " + attchedStepScreenShot(imgDesc); 
		 }catch(Exception e)
		 {
			 reportString = "Fail" + "~" + "Unable To Scroll To" + "~" + msg + "~" + " " + attchedStepScreenShot(field_imgDesc);
		 }
		return reportString;
	}
	
	/***
	 * @author Arpita
	 * @param element
	 * @param text
	 * @param msg
	 * @throws Exception 
	 * @description verify Text
	 */
	public String verifyText(WebElement element,String text, String msg) throws Exception{
		 String reportString = null;
		 boolean found = false;
		 String retrivedValue = null;
		 String imgDesc = "Verified With " + msg;
		 String field_imgDesc = "failed_To Verify " + msg + " As Expected ["+ text +"] But Actual ["+ retrivedValue + "]";
		 try{
			 retrivedValue = element.getText();
			 this.highLightElement(element);
			 if(!text.equals("") && !text.equals("null")){
				 if(retrivedValue.equals(text)){
					 found=true;
				 }else{
					 reportString = "Fail" + "~" + "VerifyText" + "~" + msg + "~" + "Expected- "+ text +" But Actual- "+ retrivedValue + " " + attchedStepScreenShot(field_imgDesc);
					 log.info(reportString);
					 return reportString;   
				 	}
			 	}
			 }catch(Exception e){
				 found=false;
			 }
			if (found){
				reportString = "Pass" + "~" + "VerifyText" + "~" + msg + "~" + "Presented Value On Screen Is: " + retrivedValue + attchedStepScreenShot(imgDesc);
			}
			else {
				reportString = "Fail" + "~" + "VerifyText" + "~" + msg + "~" + "Not Found On Screen" + attchedStepScreenShot("failed_To Verify For " + msg); 
			}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param attributeName
	 * @param attributeValue
	 * @param msg
	 * @throws InterruptedException 
	 * @description Verify with field attribute value.
	 */
	public String verifyFieldAttribute(WebElement element,String attributeName,String attributeValue, String msg){
		String reportString = null;
		try{
		 if(element.getAttribute(attributeName)!=null) {
			this.highLightElement(element);
			 String value = element.getAttribute(attributeName);
			 if(!attributeValue.equals("") && !attributeValue.equals("null")){
				 if(value.equalsIgnoreCase(attributeValue)){
					 reportString = "Pass" + "~" + "validateField" + "~" + msg + "~" + "Match Found For Value: " + attributeValue ;
				 	return reportString;
				 	} else
					 reportString = "Error" + "~" + "validateField" + "~" + msg + "~" + "Expected- [" + attributeValue +"] But Not Equals To Actual- [" + value + "]";
			 	}else{
			 		 reportString = "Pass" + "~" + "validateField" + "~" + msg + "~" + "Present Value Is: " + value;
			 	}
			} else {
			 reportString = "Fail" + "~" + "validateField" + "~" + msg + "~" + "Unable To Find Attribute Value";		
			}
		} catch(Exception e){
			//e.printStackTrace();
			reportString = "Fail" + "~" + "validateField" + "~" + msg + "~" + "Unable To Find Field Attribute Value";		
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param attributeName
	 * @param attributeValue
	 * @param byLocator
	 * @param msg
	 * @throws InterruptedException 
	 * @description Verify with field attribute value by giving element as String and byLocator.
	 */
	public String verifyFieldAttribute(String elementValue,String byLocator, String attributeName,String attributeValue, String msg){
		String reportString = null;
		try{
			WebElement element = getWebelement(byLocator, elementValue);
			
		 if(element.getAttribute(attributeName)!=null) {
			this.highLightElement(element);
			 String value = element.getAttribute(attributeName);
			 if(!attributeValue.equals("") && !attributeValue.equals("null")){
				 if(value.equalsIgnoreCase(attributeValue)){
					 reportString = "Pass" + "~" + "validateField" + "~" + msg + "~" + "Match Found For Value: " + attributeValue ;
				 	return reportString;
				 	} else
					 reportString = "Error" + "~" + "validateField" + "~" + msg + "~" + "Expected- [" + attributeValue +"] But Not Equals To Actual- [" + value + "]";
			 	}else{
			 		 reportString = "Pass" + "~" + "validateField" + "~" + msg + "~" + "Present Value Is: " + value;
			 	}
			} else {
			 reportString = "Fail" + "~" + "validateField" + "~" + msg + "~" + "Unable To Find Attribute Value";		
			}
		} catch (NoSuchElementException e) {
			reportString = "Fail" + "~" + "validateField" + "~" + msg + "~" + "Unable To Find The Element";
			
		} catch(Exception e){
			//e.printStackTrace();
			reportString = "Fail" + "~" + "validateField" + "~" + msg + "~" + "Unable To Find Field Attribute Value";		
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String: reportString
	 * @description Verify with field name, is present on screen.
	 */
	public String verifyFieldName(String elementName, String msg ) {
		String reportString = null;
		try {
			if (driver.findElement(By.xpath(elementName)) != null) {
				scrollToView(driver.findElement(By.xpath(elementName)), "");
				reportString = "Pass" + "~" + "verifyFieldName" + "~" + msg + "~" + "Present On Screen";
			}else {
				reportString = "Error" + "~" + "verifyFieldName" + "~" + msg + "~" + "Unable To Find On Screen";
			}
		} catch (Exception e) {
			reportString = "Error" + "~" + "verifyFieldName" + "~" + msg + "~" + "Unable To Find On Screen";
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param inputData
	 * @param delimiter
	 * @return List<String>
	 * @description To split the input data with delimiter
	 */
	public List<String> splitInputData(String inputData, String delimiter){

		String [] arrOfStrL = inputData.split(delimiter); 
		List<String> inpDataList=new ArrayList<String>();
		inpDataList = Arrays.asList(arrOfStrL);  
		return inpDataList;
	}
	
	/***
	 * @author Brahma
	 * @param elementName
	 * @param msg
	 * @return String: reportString
	 * @description Verify element present on table
	 */
	public String verifyTableValue(String elementName, String msg ) {
		String reportString = null;
		try {
			WebElement webElement = getWebelement("XPATH", elementName);
			if (webElement != null) {
				scrollToView(webElement, "");
				reportString = "Pass" + "~" + "verifyTableValue" + "~" + msg + "~" + "Present On Table ";
			}else {
				reportString = "Error" + "~" + "verifyTableValue" + "~" + msg + "~" + "Unable To Find On Table";
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportString = "Fail" + "~" + "verifyTableValue" + "~" + msg + "~" + getExceptionMessage(e.getMessage());
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Arpita
	 * @param element
	 * @param text
	 * @param msg
	 * @throws Exception 
	 * @description verify Text
	 */
	public String verifyTableValue(WebElement element, String text, String msg) throws Exception {
		String reportString = null;
		String retrivedValue = null;
		String excep;
		String imgDesc = "Verified With " + msg;
		String field_imgDesc = "failed_To VerifyTableValue " + msg + " As Expected [" + text + "] But Actual [" + retrivedValue + "]";
		try {
			retrivedValue = element.getText();
			this.highLightElement(element);
			if (retrivedValue.equals(text)) {
				reportString = "Pass" + "~" + "verifyTableValue" + "~" + msg + "~" + "Match Found For Table Value Is [" + retrivedValue + "]" + attchedStepScreenShot(imgDesc);
				return reportString;
			} else {
				reportString = "Error" + "~" + "verifyTableValue" + "~" + msg + "~" + "Expected- [" + text + "] But Actual- [" + retrivedValue + "]" + attchedStepScreenShot(field_imgDesc);
				return reportString;
			}
		} catch (Exception e) {
			excep = getExceptionMessage(e.getMessage());
			reportString = "Fail" + "~" + "verifyTableValue" + "~" + msg + "~" + "Not Found On Table" + attchedStepScreenShot("failed_To Verify For " + msg);
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param fieldName
	 * @param lstExcelDataValue
	 * @param lstDropdownDataValue
	 * @return List<String>
	 * @description Verify input data values present in dropdown values.
	 */
	public List<String> verifyDropDownValue(String fieldName,List<String> lstExcelDataValue, List<String> lstDropdownDataValue) {
		List<String> reportData = new ArrayList<String>();
		String reportString = null;
		Collections.sort(lstExcelDataValue);
		Collections.sort(lstDropdownDataValue);
		reportString = "info" + "~" + "presentDropdownValues" + "~" + fieldName + "~"
				+ lstDropdownDataValue;
		reportData.add(reportString);
		boolean match = false;
		for (int i = 0; i < lstExcelDataValue.size(); i++) {
			for (int j = 0; j < lstDropdownDataValue.size(); j++) {
				if (lstExcelDataValue.get(i).trim().equals(lstDropdownDataValue.get(j).trim())) {
					reportString = "Pass" + "~" + "verifyDropdownValue" + "~" + lstExcelDataValue.get(i) + "~"
							+ "Presented In Dropdown Field";
					match = true;
					break;
				}
			}
			if (match) {
				reportData.add(reportString);
				lstDropdownDataValue.remove(lstExcelDataValue.get(i).trim());
			} else {
				System.out.println("Data Not found for" + lstExcelDataValue.get(i).trim());
				reportString = "Error" + "~" + "verifyDropdownValue" + "~" + lstExcelDataValue.get(i) + "~"
						+ "Not Present In Dropdown Field";
				reportData.add(reportString);
			}
		}
		log.info("Verified DropDown Values");
		return reportData;
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param attributeName
	 * @param attributeValue
	 * @param msg
	 * @throws InterruptedException 
	 * @description Verify with field attribute value.
	 */
	public String verifyCheckBox(WebElement element, String attributeName, String attributeValue, String msg) {
		String reportString = null;
		if (element.getAttribute(attributeName) != null) {
			this.highLightElement(element);
			String value = element.getAttribute(attributeName);

			if (value.equalsIgnoreCase("checked") || value.equals("true")) {
				if (value.equals(attributeValue)) {
					reportString = "Pass" + "~" + "verifyCheckBox" + "~" + msg + "~" + "CheckBox Checked";
					return reportString;
				} else {
					reportString = "Error" + "~" + "verifyCheckBox" + "~" + msg + "~" + "CheckBox Un-Checked";
				}
			} else if (value.equalsIgnoreCase("unchecked") || value.equals("false")) {
				if (value.equals(attributeValue)) {
					reportString = "Pass" + "~" + "verifyCheckBox" + "~" + msg + "~" + "CheckBox Un-Checked";
					return reportString;
				} else {
					reportString = "Error" + "~" + "verifyCheckBox" + "~" + msg + "~" + "CheckBox Checked";
				}
			}
		} else {
			reportString = "Fail" + "~" + "verifyCheckBox" + "~" + msg + "~" + "Unable To Find Attribute Value";
		}
		log.info(reportString);
		return reportString;
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @description To highlight the element present on screen.
	 */
	public void highLightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0; i<2;i++){
		js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid yellow;');", element);
		sleep(500);
		js.executeScript("arguments[0].setAttribute('style','border: ');", element);
		sleep(300);
		}
	}
	
	/***
	 * @author Brahma
	 * @param elementValue
	 * @return List<String>
	 * @throws Exception
	 * @description To get the list of dropdown values.
	 */
	public List<String> getListOfDropDownValues(String elementValue) throws Exception {
		String reportString;
		List<String> reportData = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		int sizelength = driver.findElements(By.xpath(elementValue)).size();
		System.out.println(sizelength);
		int i;
		for (i = 0; i <= sizelength - 1; i++) {
			String value = driver.findElements(By.xpath(elementValue)).get(i).getText();
			list.add(value);
			System.out.println(value);
		}
		return list;
	}
	
	/***
	 * @author Arvind
	 * @param msg
	 * @return String: reportString
	 * @description To accept alert Pop up window.
	 */
	public String acceptAlert(String msg) {
		String reportString = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			//driver.switchTo().alert().accept();
			Alert alert = driver.switchTo().alert();
			reportString = "Pass" + "~" + "Alert" + "~" + msg + "~" + "Accepted For " + alert.getText();
            alert.accept();
		} catch (NoAlertPresentException | TimeoutException noAlert) {
		}
		return reportString;
	}

	/***
	 * @author Arvind
	 * @param msg
	 * @return String: reportString
	 * @description To decline alert Pop up window.
	 */
	public String declineAlert(String msg){
		driver.switchTo().alert().dismiss();
		String reportString="Pass" + "~" + "Alert" + "~" + msg + "~" + "Declined";
		return reportString;
	}
	
	/***
	 * @author Koyal
	 * @param length
	 * @param useLetters
	 * @param useNumbers
	 * @description To generate random string.
	 * @return String: generatedString
	 */
	public String generateRandomString(int length, boolean useLetters, boolean useNumbers) {
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString);
		return generatedString;
	}
	
	
	/***
	 * @author Koyal
	 * @return String: dateFormatted
	 * @description Get current date.
	 */
	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	/***
	 * @author Brahma
	 * @param element
	 * @param attributeName
	 * @description Get attribute value.
	 * @return String: getValue
	 */
	public String getAttributeValue(WebElement element, String attributeName) {
		String getValue = element.getAttribute(attributeName);
		return getValue;
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param value
	 * @param locator
	 * @description Get webelement from String input.
	 * @return WebElement
	 */
	public WebElement setStringValueInToWebElement(String element, String value, String locator) {
		String stringElement = String.format(element, value);
		WebElement webEle = getWebelement(locator, stringElement);
		return webEle;
	}

	/***
	 * @author Brahma
	 * @param element
	 * @param value
	 * @param locator
	 * @description Get webelement from String input.
	 * @return WebElement
	 */
	public String getStringWebElement(String element, String value){
		String stringElement = null;
		try{
			stringElement = String.format(element, value);
		} catch(Exception e){
			e.getStackTrace();
		}
		return stringElement;
	}
	
	/***
	 * @author Brahma
	 * @param inputValue
	 * @description Set input data into generated excel status report
	 */
	public void setInpDataInToStatusReport(String inputValue){
		ExcelExecutionStatusReport exlStatus = new ExcelExecutionStatusReport();
		btstSuite = new BaseTestSuite();
	    try {
			exlStatus.writeExcelInputTestData(btstSuite.getMethod(), inputValue);
		} catch (IOException | NullPointerException e) {
			System.err.println("Unable to write in status report" + e );
		}
	}
	
	/***
	 * @author Brahma
	 * @param key
	 * @param value
	 * @throws IOException
	 * @description To store the values in "AppInputData" property file.
	 */
	public void setValueProperty(String key ,String value) throws IOException{
        FileInputStream in = new FileInputStream("AppInputData.properties");
        Properties props = new Properties();
        props.load(in);
        in.close();
        btstSuite = new BaseTestSuite();
        String keyName =  btstSuite.getMethod() + "_" + key;
        props.setProperty(keyName, value);
        FileOutputStream out = new FileOutputStream("AppInputData.properties");
        props.store(out, null);
        out.close();
	}
	
	/***
	 * @author Brahma
	 * @param key
	 * @return String: value
	 * @throws IOException
	 * @description To get the value from "AppInputData" property file.
	 */
	public String getValueProperty(String key) throws IOException{
        FileInputStream in = new FileInputStream("AppInputData.properties");
        Properties props = new Properties();
        props.load(in);
        
        btstSuite = new BaseTestSuite();
        String keyName =  btstSuite.getMethod() + "_" + key;
        String value  = props.getProperty(keyName);
        in.close();
		return value;
	}
	
	/***
	 * @author Brahma
	 * @return
	 * @description To check if alert is present.
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		} 
	}
	
	/***
	 * @author Brahma
	 * @return
	 * @description To check if alert is present.
	 */
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception Ex) {
			return false;
		} 
	}
	
	/***
	 * @author Brahma
	 * @description To handle alert if it is present.
	 */
	public String handleAlert() {
		if (isAlertPresent()) {
			sleep(1500);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			alert.accept();
			sleep(1500);
			return ":-@"+alertMsg;
		}
		return "";
	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @param doc
	 * @return
	 * @description To upload file in upload box.
	 */
	public List<String> uploadDocument(WebElement element, String docPath) {
		List<String> reportData = new ArrayList<String>();
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			sleep(700);
			reportData.add("Pass" + "~" + "moveToElement" + "~" + "UploadDocument Box" + "~" + " ");
			element.sendKeys(docPath);
			sleep(3000);
			reportData.add("Pass" + "~" + "type" + "~" + "Upload Document" + "~" + "Provided Document Path Is [" + docPath + "]");
		} catch (Exception e) {
			reportData.add("Fail" + "~" + "type" + "~" + "Upload Document" + "~" + getExceptionMessage(e.getMessage()));
		}
		return reportData;
	}

	public String getExceptionMessage(String excpt){
		String getException = null;
		try{
			getException = excpt.split("}")[0];
		}catch(Exception e){
			System.out.println(e);
		}
		return "<a style='color:red'> #OccuredException:- </a>" + getException;
	}
	
	public String setZoomInZoomOut(int value) {
		String reportString = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + value + "%'");
		if(value == 100){
			reportString = "Info" + "~" + "ZoomLevel" + "~" + value + "~" + "SetTo DefaultLevel";
		} else if(value > 100){
			reportString = "Info" + "~" + "ZoomLevel" + "~" + value + "~" + "Zooming Out";
		} else if(value < 100){
			reportString = "Info" + "~" + "ZoomLevel" + "~" + value + "~" + "Zooming In";
		}
		return reportString;
	}
}