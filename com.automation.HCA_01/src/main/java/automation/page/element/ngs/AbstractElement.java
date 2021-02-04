/**
 * <MANDATORY> Description Required
 * 1, Copyright Information
 * 2, Licensing Information
 * 3, Known Issues, Warranties and Support information
 */

package automation.page.element.ngs;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractElement {
	protected String name;
	protected WebDriver driver;
	protected WebElement nativeElement;
	protected long TIME_DELAY_IN_SECONDS = 10;
	protected int iStatus = 0;
	protected ElementActionStatus actSt = ElementActionStatus.SUCCESS;
	protected Log log = LogFactory.getLog(AbstractElement.class);
	
	public AbstractElement(WebDriver deviceDriver, WebElement webElement) {
		this.driver = deviceDriver;
		this.nativeElement = webElement;
	}
	
	
	public WebDriver getDriver() {
		
		return this.driver;
	}

	
	public void setDriver(WebDriver driver) {
		this.driver= driver;

	}

	
	public boolean compare(String text) {
		
		return false;
	}

	
	public boolean exists() {
		
		return false;
	}

	
	public boolean exists(long timeOut) {
		
		return false;
	}

	
	public boolean isVisible() {
		
		return getRectangle().getHeight()>0;
	}

	
	public boolean isEnabled() {
		
		return this.nativeElement.isEnabled();
	}

	
	public int getHeight() {
		
		return this.nativeElement.getRect().getHeight();
	}

	
	public int getWidth() {
		
		return this.nativeElement.getRect().getWidth();
	}

	
	public int getX() {
		
		return this.nativeElement.getLocation().getX();
	}

	
	public int getY() {
		
		return this.nativeElement.getLocation().getY();
	}

	
	public Point getPoint() {
		
		return this.nativeElement.getLocation();
	}

	
	public Rectangle getRectangle() {

		Rectangle rect = new Rectangle(nativeElement.getLocation().getX(),nativeElement.getLocation().getY(),nativeElement.getSize().getHeight(),nativeElement.getSize().getWidth());
		
		return rect;
	}

	
	public Rectangle getBorder() {
		
		return null;
	}

	
	public void highlight() {
		Rectangle rect = getRectangle();
		Rectangle highlighter = new Rectangle(rect.getX()+2,rect.getY()+2,rect.getHeight()+2,rect.getWidth()+2);
		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);", this.nativeElement,"aviva-selenium-highlighter");
		

	}
	
	/***
	 * @author Brahma
	 * @param element
	 * @throws InterruptedException 
	 * @description To highlight the element present on screen.
	 */
	public void highLightElement(WebElement element) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0; i<2;i++){
		js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid yellow;');", element);
		Thread.sleep(500);
		js.executeScript("arguments[0].setAttribute('style','border: ');", element);
		Thread.sleep(300);
		}
	}

	
	public String getText() {
		return this.nativeElement.getText();
	}

	public void clickAt(int offsetX, int offsetY) {
		Dimension elementSize = nativeElement.getSize();

		int useX = elementSize.getWidth() - offsetX;
		int useY = elementSize.getHeight() - offsetY;

		if (this.getDriver() instanceof HasInputDevices) {

			new Actions(this.getDriver()).moveToElement(nativeElement, useX, useY).click().build().perform();
		}
	}

	public void click(WebElement element) {
		element.click();

	}
	
	public void clickOffSet(int width, int height) {

	}

	public void waitForLoad() {
		driver.manage().timeouts().implicitlyWait(TIME_DELAY_IN_SECONDS, TimeUnit.SECONDS);
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
//			log.info("Exception while waiting for page load.");
		}
	}
	
	public void waitToElementClickable(WebElement element, long timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
