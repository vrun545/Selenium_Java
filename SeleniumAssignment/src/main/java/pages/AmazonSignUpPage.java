package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignUpPage {
	
	WebElement element = null;
	WebDriver driver = null;
	
	public AmazonSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@id=\"ap_customer_name\"])")
	public WebElement userName_TextArea;
	
	@FindBy(xpath="(//input[@id=\"ap_phone_number\"])")
	public WebElement phoneNo_TextArea;
	
	@FindBy(xpath="(//input[@id=\"ap_password\"])")
	public WebElement password_TextArea;
	
	@FindBy(xpath="(//input[@id=\"continue\"])")
	public WebElement submit_button;
	
	public void enter_UserName(String userName) {
		userName_TextArea.sendKeys(userName);
	}
	
	public void enter_PhoneNo(String phno) {
		phoneNo_TextArea.sendKeys(phno);
	}
	
	public void enter_Password(String password) {
		password_TextArea.sendKeys(password);
	}
	
	public void clickOnSubmitButton() {
		submit_button.sendKeys(Keys.RETURN);
	}

}
