package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSelectProduct {

	WebDriver driver;
	WebElement element;
	
	@FindBy(linkText="Apple iPhone 15 (128 GB) - Black")
	public WebElement product;
	
	public AmazonSelectProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProduct() {
		product.sendKeys(Keys.RETURN);
	}
}
