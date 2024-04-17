package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCustomerServices {

    WebDriver driver;
    WebElement element;

    @FindBy(xpath="//*[@id=\"nav-xshop\"]/a[7]")
    public WebElement customerServicesButton;
    
    public AmazonCustomerServices(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCustomerService() {
        customerServicesButton.click();
    }
}
