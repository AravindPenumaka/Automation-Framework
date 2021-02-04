package automation.page.element.ngs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NGSEditBox extends AbstractElement {
	
	private String elementName;
	
	public NGSEditBox(WebDriver deviceDriver, WebElement webElement, String elementName) {
		super(deviceDriver, webElement);
		this.elementName = elementName;
	}
	
	public int setValue(String value) throws InterruptedException {
		this.setValue(value, 0, 0, false, false);
		return actSt.getElementActionStatus();
	}
	
	public int setValue(String value, boolean clear) throws InterruptedException {
		this.setValue(value, 0, 0, clear, false);
		return actSt.getElementActionStatus();
	}

	public int setValue(String value, int delay, int retry, boolean clearFirst, boolean validateAfter) throws InterruptedException {
		
		try{
			this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
			int retryIndex = 0;
			if (nativeElement == null) {
				actSt = ElementActionStatus.ELEMENTNOTFOUND;
				return actSt.getElementActionStatus();
			}
			
			if (value.isEmpty() || value.equals("")) {
				actSt = ElementActionStatus.SUCCESS;
				return actSt.getElementActionStatus();
			}
			while (retryIndex <= retry) {
				if (log.isDebugEnabled())
					log.debug("Retrying Action : " + retryIndex);
				try {
					if (log.isDebugEnabled())
						log.debug("Sleeping for [" + delay + " seconds]");
					Thread.sleep(delay * 1000);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
	
				if (nativeElement.getAttribute("value").equals(value)) {
					actSt = ElementActionStatus.SUCCESS;
					return actSt.getElementActionStatus();
				} else {
					if (clearFirst) {
						if (log.isDebugEnabled())
							log.debug("Clearing the field value for " + elementName);
						nativeElement.clear();
					}
					nativeElement.sendKeys(value);
					highLightElement(nativeElement);
					log.info("Entered value [" + value + "] in TextBox for :- " + elementName);
					if (validateAfter) {
						if (nativeElement.getAttribute("value").equals(value)) {
							if (log.isDebugEnabled())
								log.debug("Field [" + name + "] Validation is Success!!");
							actSt = ElementActionStatus.SUCCESS;
							break;
						}
					}
				}
				retryIndex++;
			}
		}catch(StaleElementReferenceException e){
			Thread.sleep(500);
			nativeElement.click();
			nativeElement.sendKeys(value);
			this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
			actSt = ElementActionStatus.SUCCESS;
			return actSt.getElementActionStatus();
		}catch(NoSuchElementException | TimeoutException e){
			log.info("Unable to enter value [" + value + "] in TextBox for :- " + elementName);
			actSt = ElementActionStatus.ELEMENTNOTFOUND;
			return actSt.getElementActionStatus();
		}
		//nativeElement.sendKeys(Keys.TAB);
		this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
		return actSt.getElementActionStatus();
	}

	public void clear() {
		this.nativeElement.clear();
	}

	public void select() {
		this.nativeElement.click();
		this.nativeElement.sendKeys(Keys.CONTROL + "a");
	}

	public void getValue() {
		if(this.nativeElement.getTagName().equals("input")) this.nativeElement.getAttribute("value");	
	}

}
