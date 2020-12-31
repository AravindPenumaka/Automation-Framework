package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObj {
	
	public By UsernameorNumber = By.xpath("(//input[@type='text'])[2]");
	public By Passowrd  = By.xpath("//input[@type='password']");
	public By Submit = By.xpath("(//button[@type='submit'])[2]");
	public By Close  = By.xpath("//button[@class='_2AkmmA _29YdH8']");


}
