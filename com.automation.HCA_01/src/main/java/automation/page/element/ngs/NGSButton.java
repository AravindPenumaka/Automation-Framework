package automation.page.element.ngs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NGSButton extends AbstractElement{
	
	private String elementName;

	public NGSButton(WebDriver deviceDriver, WebElement webElement, String elementName) {
		super(deviceDriver, webElement);
		this.elementName = elementName;
	}
	
	public int click() {	
		try {
			this.waitToElementClickable(nativeElement, TIME_DELAY_IN_SECONDS);
			Thread.sleep(500);
			nativeElement.click();
			log.info("Clicked on an element :- " + elementName);
			Thread.sleep(800);
			this.actSt = ElementActionStatus.SUCCESS;
			return this.actSt.getElementActionStatus();
		}catch(NoSuchElementException | TimeoutException e){
			log.info("Unable to click on element :- " + elementName);
			this.actSt = ElementActionStatus.ELEMENTNOTFOUND;
			return this.actSt.getElementActionStatus();
		}catch (Exception e) {
			e.printStackTrace();
			this.actSt = ElementActionStatus.GENERICISSUE;
			return this.actSt.getElementActionStatus();
		}
	}

	public String getText() {
		return this.nativeElement.getAttribute("innertext");	
	}

	public int actionClick() {
		try {
			Actions action = new Actions(driver);
			action.click(this.nativeElement);
			action.build().perform();
			this.actSt = ElementActionStatus.SUCCESS;
			return this.actSt.getElementActionStatus();
		} catch (NoSuchElementException | TimeoutException e) {
			log.info("Unable to click on element :- " + elementName);
			this.actSt = ElementActionStatus.ELEMENTNOTFOUND;
			return this.actSt.getElementActionStatus();
		} catch (Exception e) {
			e.printStackTrace();
			this.actSt = ElementActionStatus.GENERICISSUE;
			this.iStatus = this.actSt.getElementActionStatus();
			return this.iStatus;
		}
	}
}
