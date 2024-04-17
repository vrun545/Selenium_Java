package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAddToCart {
	
	WebElement element = null;
	WebDriver driver = null;

	@FindBy(xpath="(//*[@id=\"add-to-cart-button\"])[2]")
	public WebElement addToCart_Button;
	
	public AmazonAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductLink() {
		String URL = "https://www.amazon.in/Apple-iPhone-15-128-GB/dp/B0CHX1W1XY/ref=sr_1_4?crid=2IVFJSGU681I9&dib=eyJ2IjoiMSJ9.4Amcm6ymShwYf2cUNy6g86WDoB5h-9C6cHAj-CJcKnhhDPQn-fIYfKJxxKAv6p4vKyQ_nktDI7kGrnJr6WcwXGqouoKUq8M-65-fMWUPbqxZDzy6a1xlEFSa9dEFJELwVNNgiaEG8AYh2ZNmYKKmAyhJD5fUfpVpnDipADtkVUwNYAdXlu8NDnaeb28pqHQtr7YfBq0I2PJH6fmdleQjixFk4513dOU5vlhVp15vZWg.qVqxiFQNyGdM0lznuj1H2dE1l0UypCeY27VSd78WyVA&dib_tag=se&keywords=IPhone+15&qid=1711706160&sprefix=iphone+15%2Caps%2C302&sr=8-4";
		return URL;
	}
	
	public void clickAddToCart() {
		addToCart_Button.sendKeys(Keys.RETURN);
	}
}
