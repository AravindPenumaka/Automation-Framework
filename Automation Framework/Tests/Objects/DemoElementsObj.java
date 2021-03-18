package Objects;

import org.openqa.selenium.By;

public class DemoElementsObj {
	
	public By textarea = By.xpath("//h2[contains(text(),'Textarea')]/..//textarea");
	public By firstName = By.xpath("//form[contains(text(),'First name')]/input[@name='firstname']");
	public By Lastname = By.xpath("//input[@name='lastname']");
	public By Submit = By.xpath("//form[contains(text(),'First name')]//input[@type='submit']");
	public String Radio = "//input[@type='radio' and @value='%s']";
	public String Checkbox = "//input[@type='checkbox' and @value='%s']";
	public By inputButton = By.xpath("//input[@value ='Click Me!']");
	public By imgverify = By.xpath("//img[@alt = 'Selenium Automation']");
	public By Dropdown = By.xpath("//select[@name='cars']");
	public By SubmittonewWindow = By.xpath("//select[@name='cars']/../input");
	public By Tabledata = By.xpath("//h2[contains(text(),'WebTable')]/../table//td/..");
	public By ScrollFrame = By.xpath("//h2[contains(text(),'Frames')]");
	public By Iframe1 = By.xpath("//iframe[@name ='iframe_a']");
	public By PrintFrame1Data = By.xpath("//div[@id='banner-blm']//strong");
	public By Iframe2 = By.xpath("//iframe[@id ='iframe01']");
	public By PrintFrame2Data = By.xpath("//input[@id='searchInput']");
	public By Date = By.xpath("//input[@type='date']");
	public By FileUpload =By.xpath("//input[@type='file']");
	public By Waitscenario = By.xpath("//input[@id='testWait123']");
	public By WaitTest = By.xpath("//div[text()='Welcome To Automation Testing Insider']");

}
