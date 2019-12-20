package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;
/**
 * @author : Sachin Barpete
 * @purpose : for taking the details of reset password page from Application
 *
 */
public class IndexPage extends TestBase {

	// Initializing the page Objects
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(id = "index_login_btn")
	WebElement login_btn;

	@FindBy(id = "index_register_btn")
	WebElement register_btn;

	// Actions
	/**
	 * @return title of index page
	 */
	public String verifyIndexPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @return login page
	 */
	public LoginPage loginLink() {
		login_btn.click();
		return new LoginPage();
	}

	/**
	 * @return return register page
	 */
	public RegisterPage registerLink() {
		register_btn.click();
		return new RegisterPage();
	}
}
