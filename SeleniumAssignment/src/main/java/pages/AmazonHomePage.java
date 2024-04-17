package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	WebElement element = null;
	WebDriver driver = null;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	public WebElement searchButton;
	
	public void searchProduct(String productName) {
		    searchBox.sendKeys(productName);	    
    }
	
	public void clickSearchButton() {
		searchButton.sendKeys(Keys.RETURN);
	}
    
}
