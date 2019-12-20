
package com.bridgelabz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;
/**
 * @author : Sachin Barpete
 * @purpose : for taking the element details of welcome page from application
 * 
 */
public class WelcomePage extends TestBase {

	// Initializing the page Objects
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}

	// page factory -Object Repository(OR)
	@FindBy(xpath = "//b[contains(text(),'sachin@123')]")
	WebElement username_lable;

	@FindBy(xpath = "//a[@id='video_link']")
	WebElement video_link;

	@FindBy(xpath = "//a[@id='website_link']")
	WebElement website_link;

	@FindBy(xpath = "//input[@id='welcome_logout_btn']")
	WebElement logout_btn;

	// Actions
	
	/**
	 * @return title of Welcome Page
	 */
	public String verifyWelcomePageTitle() {
		return driver.getTitle();
	}

	/**
	 * @return username label from Welcome Page
	 */
	public boolean verifyUsernameLable() {
		return username_lable.isDisplayed();
	}

	/**
	 * @return Video Page
	 */
	public VideoPage clickVideoLink() {
		video_link.click();
		return new VideoPage();
	}

	/**
	 * @return true or false
	 */
	public boolean WebsiteLink() {
		return website_link.isDisplayed();
	}

	/**
	 * @return return website page
	 */
	public WebsitePage clickWebsiteLink() {
		website_link.click();
		return new WebsitePage();
	}

	/**
	 * @return login page
	 */
	public LoginPage logout() {
		logout_btn.click();
		return new LoginPage();
	}

}
