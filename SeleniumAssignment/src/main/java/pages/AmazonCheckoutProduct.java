package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCheckoutProduct {
	
	WebDriver driver;
    WebElement element;
    
    public AmazonCheckoutProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
    public WebElement checkOutButton;
    
    public void clickOnCheckOutButton() {
    	checkOutButton.sendKeys(Keys.RETURN);
    }

}
