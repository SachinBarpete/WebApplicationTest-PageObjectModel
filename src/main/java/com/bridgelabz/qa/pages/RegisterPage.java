package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;

/**
 * @author : Sachin Barpete
 * @purpose : for taking the details of register page from Application
 */
public class RegisterPage extends TestBase {

	// Initializing the page Objects
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement mobileNo;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement address;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='register_submit_btn']")
	WebElement submit_btn;

	// Actions

	/**
	 * @return title of register page
	 */
	public String verifyRegisterPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @param username
	 * @param name
	 * @param mobileNo
	 * @param email
	 * @param address
	 * @param password
	 * @param confirmPassword
	 * @return welcome page
	 */
	public WelcomePage submit(String username, String name, String mobileNo, String email, String address,
			String password, String confirmPassword) {
		this.username.sendKeys(username);
		this.name.sendKeys(name);
		this.mobileNo.sendKeys(mobileNo);
		this.email.sendKeys(email);
		this.address.sendKeys(address);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
		submit_btn.click();
		return new WelcomePage();
	}

}
