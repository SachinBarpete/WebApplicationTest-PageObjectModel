package com.bridgelabz.qa.testcases;

import com.bridgelabz.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.VideoPage;
import com.bridgelabz.qa.pages.WebsitePage;
import com.bridgelabz.qa.pages.WelcomePage;
/**
 * @author : Sachin Barpete
 * @purpose : Testcases  for welcome page
 * 
 */
public class WelcomePageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	VideoPage videoPage;
	WebsitePage websitePage;

	public WelcomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.loginLink();
		welcomePage = loginPage.loginBtn(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void welcomePageTitleTest() {
		String welcomePageTitle = welcomePage.verifyWelcomePageTitle();
		Assert.assertEquals(welcomePageTitle, "welcome to Bridgelabz", "welcome page title is not matched");
	}

	@Test(priority = 2)
	public void UsernameLableTest() {
		boolean flag = welcomePage.verifyUsernameLable();
		Assert.assertEquals(flag, true, "Username lable is not displayed on welcome page");
	}

	@Test(priority = 3)
	public void videoLinkTest() {
		videoPage = welcomePage.clickVideoLink();
	}

	@Test(priority = 4)
	public void websiteLinkDisplayTestTest() {
		boolean flag = welcomePage.WebsiteLink();
		Assert.assertEquals(flag, true, "Website Link is not displayed");
	}

	@Test(priority = 5)
	public void websiteLinkTest() {
		websitePage = welcomePage.clickWebsiteLink();
	}

	@Test(priority = 6)
	public void logoutTest() {
		loginPage = welcomePage.logout();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
