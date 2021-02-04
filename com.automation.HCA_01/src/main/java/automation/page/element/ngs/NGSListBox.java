package automation.page.element.ngs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javafx.util.Pair;

import automation.exceptions.element.ElementNotFoundException;

public class NGSListBox extends AbstractElement {

	private String elementName;
	
	public NGSListBox(WebDriver deviceDriver, WebElement webElement, String elementName) {
		super(deviceDriver, webElement);
		this.elementName = elementName;
	}

	/****
	 * Added by Brahma(3rd Jan)
	 * @Purpose: To select value from dropdown list
	 ****/
	public int selectListItem(String value) {
		log.info("Going to select the dropdown value.");
		int iStatus = 0;
		ElementActionStatus actSt = ElementActionStatus.SUCCESS;
		this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
		switch (value) {
		case "!IGNORE!":
			break;
		default:
			try {
				Select dropDownElement = new Select(nativeElement);
				dropDownElement.selectByVisibleText(value);
				Thread.sleep(700);
				//this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
				log.info("Selected value [" + value + "] from DropDown field for :- " + elementName);
				this.actSt = ElementActionStatus.SUCCESS;
				return this.actSt.getElementActionStatus();
				
			} catch (org.openqa.selenium.StaleElementReferenceException e1) {
				try {
					Thread.sleep(300);
					nativeElement.click();
					Thread.sleep(100);
					WebElement elelistItem = driver.findElement(By.xpath("//option[text()='"+ value +"']"));
					elelistItem.click();
					Thread.sleep(300);
					this.actSt = ElementActionStatus.SUCCESS;
					return this.actSt.getElementActionStatus();
				} catch (org.openqa.selenium.StaleElementReferenceException e2) {
					actSt = ElementActionStatus.ELEMENTNOTFOUND;
					e2.printStackTrace();
				} catch (InterruptedException e) {
					actSt = ElementActionStatus.GENERICISSUE; // Generic exception
					e.printStackTrace();
				}
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				if(e.getMessage().startsWith("Cannot locate element with text")){
					actSt = ElementActionStatus.DROPDOWNVALNOTFOUND; // No Such Element
					e.printStackTrace();
				}else{
					actSt = ElementActionStatus.ELEMENTNOTFOUND; // No Such Element
				}
			} catch (InterruptedException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.GENERICISSUE; // Generic exception
				e.printStackTrace();
			}
			break;
		}
		iStatus = actSt.getElementActionStatus();
		return iStatus;
	}
	
	@SuppressWarnings("restriction")
	public Pair<Integer, String> selectComboBoxListItem(String value) {
		log.info("Going to select the dropdown value.");
		int iStatus = 0;
		ElementActionStatus actSt = ElementActionStatus.SUCCESS;
		this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
		switch (value) {
		case "!IGNORE!":
			break;
		default:
			try {
				Thread.sleep(500);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", nativeElement);
//				nativeElement.click();
				System.out.println("");
				Thread.sleep(800);
				WebElement elelistItem = driver.findElement(By.xpath("//ul[contains(@style,'display: block;')]/li[text()='"+ value +"']"));
				elelistItem.click();
				String locatorValue = returnElementValue(elelistItem);
				
				this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
				log.info("Selected value [" + value + "] from DropDown field for :- " + elementName);
				this.actSt = ElementActionStatus.SUCCESS;
				return new Pair<Integer, String>(this.actSt.getElementActionStatus(), "");
				
			} catch (org.openqa.selenium.StaleElementReferenceException e1) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.ELEMENTNOTFOUND;
			} catch (InterruptedException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.GENERICISSUE; // Generic exception
				e.printStackTrace();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.ELEMENTNOTFOUND; // No Such Element
				e.printStackTrace();
			}
			break;
		}
		iStatus = actSt.getElementActionStatus();
		return new Pair<Integer, String>(iStatus, "");
	}
	
	public int actionSelectListItem(String value) {
		log.info("Going to select the dropdown value.");
		Actions action = new Actions(driver);
		int iStatus = 0;
		switch (value) {
		case "!IGNORE!":
			break;
		default:
			try {
				action.click(this.nativeElement);
				action.build().perform();
				Thread.sleep(700);
				action.sendKeys(this.nativeElement, value);
				action.build().perform();
				log.info("Selected value [" + value + "] from DropDown field for :- " + elementName);
				this.actSt = ElementActionStatus.SUCCESS;
				return this.actSt.getElementActionStatus();
				
			} catch (org.openqa.selenium.StaleElementReferenceException e1) {
				try {
					action.click(this.nativeElement);
					action.build().perform();
					Thread.sleep(700);
					WebElement elelistItem = driver.findElement(By.xpath("//option[text()='"+ value +"']"));
					action.click(elelistItem);
					action.build().perform();
					Thread.sleep(300);
					this.actSt = ElementActionStatus.SUCCESS;
					return this.actSt.getElementActionStatus();
				} catch (org.openqa.selenium.StaleElementReferenceException e2) {
					actSt = ElementActionStatus.ELEMENTNOTFOUND;
					e2.printStackTrace();
				} catch (InterruptedException e) {
					actSt = ElementActionStatus.GENERICISSUE; // Generic exception
					e.printStackTrace();
				}
			} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.ELEMENTNOTFOUND; // No Such Element
				e.printStackTrace();
			} catch (InterruptedException e) {
				log.info("Unable to select value [" + value + "] from DropDown field for :- " + elementName);
				actSt = ElementActionStatus.GENERICISSUE; // Generic exception
				e.printStackTrace();
			}
			break;
		}
		iStatus = actSt.getElementActionStatus();
		return iStatus;
	}
	
	public boolean selectItem(int id) {
		return true;
	}

	public String getSelectedItem() {
		String selected = null;
		try {			 
		    selected = nativeElement.getAttribute("value");
		}catch(Exception e){
		}
		return selected;
	}

	public String[] getListedItems() {
		return null;
	}
	
	public String returnElementValue(WebElement element){
		String elementValue = null;
		try{
			elementValue = element.toString();
			if(elementValue.contains("->")){
				String[] splipValue = elementValue.split("->");
				elementValue = splipValue[1];
			}else if(elementValue.contains("By.")){
				String[] splipValue = elementValue.split("By.");
				elementValue = splipValue[1];
			}
		} catch(UnhandledAlertException alert){
		}
		return "["+elementValue;
	}
}
