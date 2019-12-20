
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
public class ResetPasswordPage extends TestBase {

	// Initializing the page Objects
	public ResetPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(xpath = "//input[@id='password']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@id='resetpass_submit_btn']")
	WebElement submit_btn;

	// Actions
	
	/**
	 * @return title of Reset password page 
	 */
	public String verifyResetPasswordPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @param newPassword
	 * @return return welcome page
	 */
	public WelcomePage submit(String newPassword) {
		this.newPassword.sendKeys(newPassword);
		submit_btn.click();
		return new WelcomePage();
	}

}
