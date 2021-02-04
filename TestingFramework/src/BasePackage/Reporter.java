package BasePackage;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CustomException.MyException;

@SuppressWarnings("deprecation")
public class Reporter extends baseTest {

	static String parentNode = "";

	@SuppressWarnings("deprecation")
	public void initializeReport() {
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\temp\\AutomationReport.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Automation Framework");
		reporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void addReport(String method, String stat, String msg, String scpath, String... errStack)
			throws IOException {

		if (parentNode.equals("")) {
			parentNode = method;
			child = logger.createNode(parentNode);
		} else if (!parentNode.equals(method)) {
			parentNode = method;
			child = logger.createNode(parentNode);
		}
		if (stat.equalsIgnoreCase("pass")) {
			if (scpath != null) {
				child.log(Status.PASS, msg + "<a style='color:#32cd32;float: right'  data-featherlight = '" + scpath
						+ "' href='" + scpath + "'>ScreenShot</a>");
				org.testng.Reporter.log(msg + "<a style='color:#32cd32;float: right'  target='_blank' href='" + scpath
						+ "'>ScreenShot</a>");
			}
			log.info("passed");
		} else if (stat.equalsIgnoreCase("fail")) {

			if (scpath != null) {
				child.log(Status.FAIL,
						msg + "<br>" + "Check below Error Stack"
								+ "<a style='color:red;float: right'  data-featherlight = '" + scpath + "' href='"
								+ scpath + "'>ScreenShot</a>");

				org.testng.Reporter.log(msg + "<br>" + errStack[0] + "<a data-featherlight = '" + scpath + "' href='"
						+ scpath + "' target='_blank' style='color:#FFFFFF;float: right'>ScreenShot</a>");
			}
			child.fail(new MyException(errStack[0]));
			parentNode = "";
		} else {

			if (scpath != null) {
				child.log(Status.WARNING, msg + "<a data-featherlight = '" + scpath + "' href='" + scpath
						+ "' style='color:orange;float: right'>ScreenShot</a>");
				org.testng.Reporter.log(msg + "<a data-featherlight = '" + scpath + "' href='" + scpath
						+ "' target='_blank' style='color:orange;float: right'>ScreenShot</a>");
			}
			parentNode = "";

		}
	}

}
