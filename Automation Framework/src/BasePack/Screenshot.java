package BasePack;

import ExcelUtility.getExcelData;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import ExcelUtility.*;

public class Screenshot extends BaseClass {

	public String getScreenshot(String msg, By ele) throws Exception {

		String path = ScreenshotsPath + msg + ".png";
		try {
			if (new ExcelUtility.getExcelData().getConfiguration("Screenshot").equalsIgnoreCase("yes")) {
				if (new ExcelUtility.getExcelData().getConfiguration("Highlight").equalsIgnoreCase("yes")) {
					String style = driver.findElement(ele).getAttribute("Style");
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style','background: yellow;border:2px solid red; color:black');",
							driver.findElement(ele));
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(path));
					((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','" + style + "');",
							driver.findElement(ele));
				} else {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(path));
				}
			}
		} catch (UnhandledAlertException e) {
			driver.switchTo().alert().accept();
		}
		return path;
	}
}