package BasePack;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import java.io.File;

public class Screenshot extends BaseClass {

	public String getScreenshot(String msg, By ele) throws Exception {

		srcPath  = "./AutomationReports/"+time+"/Screenshots/";
		String returnPath = "./Screenshots/"+ msg + ".png";
		srcPath = srcPath + msg + ".png";
		try {
			if (new ExcelUtility.getExcelData().getConfiguration("Screenshot").equalsIgnoreCase("yes")) {
				if (new ExcelUtility.getExcelData().getConfiguration("Highlight").equalsIgnoreCase("yes")) {
					String style = driver.findElement(ele).getAttribute("Style");
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style','background: yellow;border:2px solid red; color:black');",
							driver.findElement(ele));
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(srcPath));
					((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','" + style + "');",
							driver.findElement(ele));
				} else {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(srcPath));
				}
			}
		} catch (UnhandledAlertException e) {
			driver.switchTo().alert().accept();
		}
		return returnPath;
		//return msg;
	}
}