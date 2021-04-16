package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PageObject {
		
	@FindBy(name = "s_s0_aan")
	public WebElement txt_KsiopUserid;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement btn_KsiopLogin;
	
	@FindBy(id = "s_tu_aaj")
	public WebElement img_HomePagelogo;
	
	@FindBy(className = "siebui-logo")
	public WebElement img_CRMHomePagelogo;
	
	@FindBy(xpath = "//input[@name='SWEUserName']")
	public WebElement txt_CRMUsername;
	
	@FindBy(xpath = "//input[@name='SWEPassword']")
	public WebElement txt_CRMPassword;
	
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement btn_CRMLogin;
	
	
	@FindBy(xpath = "//a[@class='yello-cta']")
	public WebElement btn_LoginMain;
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement txt_DealerTrackUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement txt_DealerTrackPassword;
	
	@FindBy(xpath = "//input[@name='login']")
	public WebElement btn_DealerTrackSignin;
	
	@FindBy(xpath = "//input[@name='j_username']")
	public WebElement txt_RouteOneUsername;
	
	@FindBy(xpath = "//input[@name='j_password']")
	public WebElement txt_RouteOnePassword;
	
	@FindBy(xpath = "//button[@class='btn btn-success btn-block']")
	public WebElement btn_RouteOneLogin;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElement UsernameNew;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement PasswordNew;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement SubmitNew;
	
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	public WebElement CloseNew;
}
	        
	