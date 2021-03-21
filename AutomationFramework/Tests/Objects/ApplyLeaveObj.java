package Objects;

import org.openqa.selenium.By;

public class ApplyLeaveObj {
	
	public By applyleave = By.xpath("//img[contains(@ng-src,'apply_leave')]");
	public By SelectLeaveType = By.xpath("//input[@class='select-dropdown']");
	public By Fromdate = By.xpath("(//input[@name='dateTextInput'])[1]");
	public By ToDate = By.xpath("(//input[@name='dateTextInput'])[2]");
	public By Commentlabel = By.xpath("//label[@for='comment']");
	public By Comment = By.xpath("//textarea");
	public By Apply = By.xpath("//button[text()='Apply']");
	public By Close = By.xpath("//a[text()='Close']");
	public By Home = By.xpath("//span[text()='Home']");
	public By Myleave = By.xpath("//img[contains(@ng-src,'my_leave')]");
	public By LeaveTypeVerify = By.xpath("(//span[text()='Jacqueline White']/../../..//td)[3]");
	public By SelectLeavetype = By.xpath("//input[@class='select-dropdown']");

}
