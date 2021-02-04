package frameworkFactory;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {
	
	private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
        	//System.out.println(System.getProperty("user.dir"));
            extent = new ExtentReports(filePath, true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
           /* extent
                .addSystemInfo("Host Name", "TCS")
                .addSystemInfo("Environment", "QA");*/
        }

        return extent;
    }

}
