package automation.page.element.ngs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NGSCheckBox extends AbstractElement {

	public NGSCheckBox(WebDriver deviceDriver, WebElement elementName) {
		super(deviceDriver, elementName);
		this.nativeElement = elementName;
	}
	
	public int checkAndClick(String attributeName, boolean boolCheck) {
			try {
				//Code to check if checkbox is already checked or not. If not then check it.
				if (nativeElement.getAttribute(attributeName) != null) {
					String value = nativeElement.getAttribute(attributeName);

					if (value.equalsIgnoreCase("unchecked") || value.equals("false")) {
						if (boolCheck = true) {
							try {
								nativeElement.click();
								this.waitForLoad();
								Thread.sleep(500);
							} catch (org.openqa.selenium.StaleElementReferenceException | InterruptedException e) {
								nativeElement.click();
								this.waitForLoad();
								Thread.sleep(500);
							}
							actSt = ElementActionStatus.SUCCESS;
						} else if (boolCheck = false){
							log.info("Check box is already unchecked");
							log.info("No need to click on checkbox");
						}
					} else if(value.equalsIgnoreCase("checked") || value.equals("true")) {
						if (boolCheck = true) {
							log.info("Check box is already checked");
						} else {
							try {
								nativeElement.click();
								this.waitForLoad();
								Thread.sleep(500);
							} catch (org.openqa.selenium.StaleElementReferenceException | InterruptedException e) {
								nativeElement.click();
								this.waitForLoad();
								Thread.sleep(500);
							}
							actSt = ElementActionStatus.SUCCESS;
						}
					}
				} 
			} catch (org.openqa.selenium.NoSuchElementException e) {
				actSt = ElementActionStatus.ELEMENTNOTFOUND;
			} catch (InterruptedException e) {
				actSt = ElementActionStatus.SUCCESS;
			} catch (Exception e) {
				actSt = ElementActionStatus.GENERICISSUE;
			}
		return this.actSt.getElementActionStatus();
	}
}
