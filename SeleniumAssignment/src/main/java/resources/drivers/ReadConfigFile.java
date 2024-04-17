package resources.drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties properties;
	String path = "C:\\Users\\varunbajpai\\eclipse-workspace\\SeleniumAssignment\\src\\main\\java\\resources\\drivers\\Properties Files\\Config.properties";

	public ReadConfigFile() {
		properties = new Properties();
		try {
		FileInputStream fis = new FileInputStream(path);
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		} 
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		String URL = properties.getProperty("url");
		if (URL != null)
			return URL;
		else
			throw new RuntimeException("URL not found in Config File");
	}
	
	public String getLoginURL() {
		String loginURL = properties.getProperty("loginURL");
		if (loginURL != null)
			return loginURL;
		else
			throw new RuntimeException("Login URL not found in Config File");
	}
	
	public String getSignUpURL() {
		String registrationURL = properties.getProperty("registrationURL");
		if (registrationURL != null)
			return registrationURL;
		else
			throw new RuntimeException("Sign-Up URL not found in Config File");
	}
	
	public String getLoginUserName() {
		String userName = properties.getProperty("username");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("UserName not found in Config File");
	}
	
	public String getLoginPassword() {
		String loginPassword = properties.getProperty("password");
		if (loginPassword != null)
			return loginPassword;
		else
			throw new RuntimeException("LoginPassword not found in Config File");
	}
	
	public String getPhoneNo() {
		String phoneNo = properties.getProperty("phoneNo");
		if (phoneNo != null)
			return phoneNo;
		else
			throw new RuntimeException("Sign-Up URL not found in Config File");
	}
	
	public String getLoginEmail() {
		String loginEmail = properties.getProperty("email");
		if (loginEmail != null)
			return loginEmail;
		else
			throw new RuntimeException("LoginEmail not found in Config File");
	}
}
