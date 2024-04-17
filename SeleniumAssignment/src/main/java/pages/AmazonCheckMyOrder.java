package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCheckMyOrder {

	WebElement element = null;
	WebDriver driver = null;

	public AmazonCheckMyOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[5]/div/div[1]/div[1]/div[1]/a/div/div/div/div[2]/h3")
	public WebElement myOrder_Button;
	
	public void click_MyOrder() {
		myOrder_Button.click();
	}
}
