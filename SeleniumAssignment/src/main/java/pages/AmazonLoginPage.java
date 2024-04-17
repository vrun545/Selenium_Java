package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

	WebElement element = null;
	WebDriver driver = null;
	
	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name=\"email\"])")
	public WebElement email_TextBox;
	
	
	@FindBy(xpath="(//input[@id=\"signInSubmit\"])")
	public WebElement signIn_Button;
	
	@FindBy(xpath="(//input[@id=\"ap_password\"])")
	public WebElement password_TextBox;
	
	public void enterLoginEmail(String emailId) {
		email_TextBox.sendKeys(emailId);
	}
	
	public void enterContinueButton() {
		signIn_Button.sendKeys(Keys.RETURN);;
	}
	
	public void enterLoginPassword(String password) {
		password_TextBox.sendKeys(password);
	}
	
}
