package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;

/**
 * @author : Sachin Barpete
 * @purpose : for taking the details of login page from Application
 * 
 */
public class LoginPage extends TestBase {

	// Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@id='login_login_btn']")
	WebElement login_btn;

	@FindBy(xpath = "//a[@id='forgott_password']")
	WebElement forgott_password_link;

	// Actions
	/**
	 * @return title of login page
	 */
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @param username
	 * @param password
	 * @return welcome page
	 */
	public WelcomePage loginBtn(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		login_btn.click();
		return new WelcomePage();
	}

	/**
	 * @return forgott password page
	 */
	public ForgottPasswordPage forgottPassword() {
		forgott_password_link.click();
		return new ForgottPasswordPage();
	}

	/**
	 * @param username
	 * @param password
	 * @return welcome page
	 */
	public WelcomePage login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		login_btn.click();
		return new WelcomePage();
	}

}
