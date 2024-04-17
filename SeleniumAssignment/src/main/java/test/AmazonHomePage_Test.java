package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentManager;
import resources.drivers.ReadConfigFile;
import pages.AmazonAddToCart;
import pages.AmazonChangePinCode;
import pages.AmazonCheckMyOrder;
import pages.AmazonCheckProuductImages;
import pages.AmazonCheckoutProduct;
import pages.AmazonCustomerServices;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonSelectProduct;
import pages.AmazonSignUpPage;

public class AmazonHomePage_Test {

    private static final Logger logger = LogManager.getLogger(AmazonHomePage_Test.class);
	ReadConfigFile ConfigFile = new ReadConfigFile();
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;

	@BeforeTest
	@Parameters("browser")
	public void initializeDriver(String browser) {
	    if(browser.equals("chrome")) {
	        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	    } else if(browser.equals("firefox")) {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\varunbajpai\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
	        driver = new FirefoxDriver();
	    } else if(browser.equals("ie")) {
	        System.setProperty("webdriver.edge.driver", "src\\main\\java\\resources\\drivers\\msedgedriver.exe");
	        driver = new EdgeDriver();
	    }
	    driver.manage().window().maximize();
	    extent = ExtentManager.getInstance();
	    extent.setSystemInfo("Browser", browser);
	    extent.setSystemInfo("OS", "Windows 11");
	    logger.info("\n------------New Logging Details Added Below--------------\n\n");
	}


	@Test(priority = 1)
	public void getAmazonSite() {
		test = extent.createTest("getAmazonSite");
        test.log(Status.INFO, "Launching Amazon Site");
        logger.info("Launching Amazon Site");
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 2)
	public void searchProduct() {
		test = extent.createTest("searchProduct");
		test.log(Status.INFO, "Searching a product on serach box");
        logger.info("Searching product on Amazon Site");
		AmazonHomePage pageFactory = new AmazonHomePage(driver);
		pageFactory.searchProduct("IPhone 15");
		pageFactory.clickSearchButton();
	}
	
	@Test(priority = 3)
	public void selectProduct() {
		test = extent.createTest("selectProduct");
		test.log(Status.INFO, "Selecting a product and performing click operation");
        logger.info("Selecting Product Amazon Site");
		AmazonSelectProduct pageFactory = new AmazonSelectProduct(driver);
		pageFactory.clickOnProduct();
	}
	
	@Test(priority = 4)
	public void checkImagesOfProduct() {
		test = extent.createTest("checkImagesOfProduct");
		test.log(Status.INFO, "Checking Images of Product");
        logger.info("Checking Images of Product");
        AmazonCheckProuductImages pageFactory = new AmazonCheckProuductImages(driver);
        String url = pageFactory.getProductLink();
		driver.get(url);
		pageFactory.checkImage1();
	}
	
	@Test(priority = 5)
	public void addToCart() {
		test = extent.createTest("Add Product to Cart");
		test.log(Status.INFO, "Adding product into cart");
        logger.info("Add product to Cart");
		AmazonAddToCart pageFactory = new AmazonAddToCart(driver);
		String url = pageFactory.getProductLink();
		driver.get(url);
		pageFactory.clickAddToCart();
	}
	
	@Test(priority = 6)
	public void checkOutProduct() {
		test = extent.createTest("CheckOut Product");
		test.log(Status.INFO, "CheckOut Added Product");
        logger.info("CheckOut Added Product");
        AmazonCheckoutProduct pageFactory = new AmazonCheckoutProduct(driver);
		pageFactory.clickOnCheckOutButton();
	}
	
	@Test(priority = 7)
	public void checkCustomerServices() {
		test = extent.createTest("Checking Customer Services");
		test.log(Status.INFO, "Performing click operation on Customer Services");
        logger.info("click operation on Customer Services");
        AmazonCustomerServices pageFactory = new AmazonCustomerServices(driver);
        driver.get("https://www.amazon.in");
		pageFactory.clickCustomerService();
	}
	
	@Test(priority = 8)
	public void checkMyOrders() {
		test = extent.createTest("Checking My Orders");
		test.log(Status.INFO, "Checking My Orders Page");
        logger.info("Checking My Orders Page");
        AmazonCheckMyOrder pageFactory = new AmazonCheckMyOrder(driver);
		pageFactory.click_MyOrder();;
	}
	
	@Test(priority = 9)
	public void changePinCode() {
		test = extent.createTest("changePinCode");
		test.log(Status.INFO, "Changing Pincode");
        logger.info("Changing Pincode");
		AmazonChangePinCode pageFactory = new AmazonChangePinCode(driver);
		driver.get("https://amazon.in");
		pageFactory.click_pinCodeIcon();
		pageFactory.enter_PinCode();
		pageFactory.enter_SubmitButton();
		Assert.assertTrue(true, "Pincode Changed Successfully");
	}

	@Test(priority = 10)
	public void checkLogin() {
		AmazonLoginPage pageFactory = new AmazonLoginPage(driver);
		test = extent.createTest("checkLogin");
        test.log(Status.INFO, "Performing login with invalid credentials");
		String URL = ConfigFile.getLoginURL();
		String emailID = ConfigFile.getLoginEmail();
		String userPassword = ConfigFile.getLoginPassword();
		driver.get(URL);
		pageFactory.enterLoginEmail(emailID);
		pageFactory.enterLoginPassword(userPassword);
		pageFactory.enterContinueButton();
		Assert.assertTrue(false, "Wrong credentials entered");
	}
	
	@Test(priority = 11)
	public void checkSignUp() {
		AmazonSignUpPage pageFactory = new AmazonSignUpPage(driver);
		test = extent.createTest("checkSignUp");
        test.log(Status.INFO, "Performing sign-up with credentials");
		String URL = ConfigFile.getSignUpURL();
		String UserName = "John Doe";
		String PhoneNumber = ConfigFile.getPhoneNo();
		String Password = ConfigFile.getLoginPassword();
		driver.get(URL);
		pageFactory.enter_PhoneNo(PhoneNumber);
		pageFactory.enter_UserName(UserName);
		pageFactory.enter_Password(Password);
		Assert.assertTrue(false, "Credentials entered but didn't proceed");
	}

	@Test(priority = 12)
	public void anotherIntentionalFailure() {
		test = extent.createTest("Intentional Failure Test Case");
		Assert.assertTrue(false, "Intentionally failing test case");
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(result.getMethod().getMethodName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));
            logger.error(result.getName() + " Failed");
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed", ExtentColor.GREEN));
            logger.info(result.getName() + " Passed");
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skipped", ExtentColor.YELLOW));
            logger.warn(result.getName() + " Skipped");
		}
	}

	@AfterTest
	public void tearDownTest() {
		if (driver != null) {
			driver.quit();
		}
		ExtentManager.flushReport();
		System.out.println("Testing done successfully !!!");
	}
	
	
	public void takeScreenShot(String methodName) {
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		// Capture the screenshot as File
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			// Define the directory path for the screenshots
			String directory = "src/main/java/reports/extentreports/screenshots/";
			// Create the directory if it does not exist
			new File(directory).mkdirs();
			// Define the destination path for the screenshot
			Path destinationPath = Paths.get(directory + methodName + "_" + getCurrentTimeStamp() + ".png");
			// Copy the screenshot to the destination path
			Files.copy(source.toPath(), destinationPath);
			System.out.println("Screenshot taken: " + destinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	}
}
