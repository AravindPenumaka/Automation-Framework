package BasePack;


import ExcelUtility.getExcelData;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import ExcelUtility.*;

public class Screenshot extends BaseClass {

    public String getScreenshot(By ele) throws Exception {

        if(new ExcelUtility.getExcelData().getConfiguration("Screenshot").equalsIgnoreCase("yes")) {
            if (new ExcelUtility.getExcelData().getConfiguration("Highlight").equalsIgnoreCase("yes")) {

            } else {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.home")+"\\Desktop\\Result\\Screenshot.png"));
            }
        }
        return Path;
    }
}