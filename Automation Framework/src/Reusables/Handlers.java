package Reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Handlers extends Reusables.Keywords {

	public int click(By ele) {

		try {
			driver.findElement(ele).click();
			return 0;
		} catch (NoSuchElementException | TimeoutException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	public int type(By ele, String TextValue) {

		try {
			driver.findElement(ele).clear();
			driver.findElement(ele).sendKeys(TextValue);
			return 0;
		} catch (NoSuchElementException | TimeoutException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	public int select(By ele, String textValue) {

		try {
			new Select(driver.findElement(ele)).selectByVisibleText(textValue);
			return 0;
		} catch (NoSuchElementException | TimeoutException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	public int isDisplayed(By loc) {

		try {
			if (driver.findElement(loc).isDisplayed()) {
				return 0;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		}
		return 1;
	}

}
