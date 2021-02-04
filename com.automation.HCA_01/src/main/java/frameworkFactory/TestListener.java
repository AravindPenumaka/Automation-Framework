package frameworkFactory;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.tools.ant.util.FileUtils;
//import org.apache.tools.ant.util.FileUtils;
//import org.apache.tools.ant.util.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.LogStatus;
//import com.sun.jna.platform.FileUtils;
//import com.sun.jna.platform.FileUtils;

public class TestListener extends TestListenerAdapter {
	private static String fileSeperator = System.getProperty("file.separator");
	private static ITestResult result;
	public static Properties path = new Properties();
	private static String imgpath;
	WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		driver = BaseTestSuite.driver;
		this.result = result;

		//takeScreenShot(result);
	}
	
	@Override
	public void onTestSuccess(ITestResult result){
		
		System.out.println("***** Executed " + result.getName() + " test has Passed *****");
		driver = BaseTestSuite.driver;
		this.result = result;

		//takeScreenShot(result);
	}

	public String takeScreenShot(ITestResult result, String folderPath) {

		String fileName = null;
		try {
			String testClassName = result.getInstance().getClass().getSimpleName();
			String testMethodName = result.getName();
			File scrnshot;
			driver = BaseTestSuite.driver;
			
			path.load(new FileInputStream("App.properties"));
			
			if(result.isSuccess()){
				fileName = "Passed_Testcase_"+ testMethodName + "_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date()) + ".jpeg";
			}else if(!result.isSuccess()){
				fileName = "Failed_Testcase_" + testMethodName + "_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date()) + ".jpeg";
			}
			
			String ScreenShotPath = folderPath + "ScreenShots" + fileSeperator+ testMethodName + fileSeperator + fileName;
			scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnshot, new File(ScreenShotPath));
			//this.imgpath = ScreenShotPath;
			
			this.imgpath = "ScreenShots\\" + testMethodName + "\\"+fileName;
		} catch (Exception e) {
			System.out.println("Exception occurred while taking the screenshot.");
			e.printStackTrace();
		}
		return imgpath;
	}
	
}
