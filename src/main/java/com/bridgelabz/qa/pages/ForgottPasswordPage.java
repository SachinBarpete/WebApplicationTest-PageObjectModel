package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;

/**
 * @author : Sachin Barpete
 * @purpose : for taking the details of forgott password page from Application
 * 
 */
public class ForgottPasswordPage extends TestBase {

	// Initializing the page Objects
	public ForgottPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit_btn;

	// Actions
	/**
	 * @return title of forgottPasswordPage
	 */
	public String verifyForgottPasswordPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @param username
	 * @param email
	 * @return resetPasswordPage
	 */
	public ResetPasswordPage submit(String username, String email) {
		this.username.sendKeys(username);
		this.email.sendKeys(email);
		submit_btn.click();
		return new ResetPasswordPage();
	}

}
