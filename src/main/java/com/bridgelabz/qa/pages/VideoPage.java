
package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;
/**
 * @author : Sachin Barpete
 * @purpose : for taking the details of Video page from application
 * 
 */
public class VideoPage extends TestBase {

	// Initializing the page Objects
	public VideoPage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(xpath = "//input[@id='video_logout_btn']")
	WebElement logout_btn;

	// Actions
	/**
	 * @return title of video page
	 */
	public String verifyVideoPageTitle() {
		return driver.getTitle();
	}

	/**
	 * @return login page
	 */
	public LoginPage logoutBtn() {
		logout_btn.click();
		return new LoginPage();
	}

}
