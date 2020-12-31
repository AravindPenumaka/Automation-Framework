package Objects;

import org.openqa.selenium.By;

public class LoginObj extends Reusables.Keywords{
	
	public By LoginWithEmail = By.xpath("//label[text()='Login with Phone/Email']");
	public By Username = By.xpath("//input[@id='username']");
	public By Continue=By.xpath("//span[text()='Continue']");
	public By password  = By.xpath("//input[@id='password']");
	public By Login = By.xpath("//span[text()='Login']");
	public By LoginOrCreate = By.xpath("//p[text()='Login or Create Account']");

}
