package com.bridgelabz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.qa.pages.ForgottPasswordPage;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.VideoPage;
import com.bridgelabz.qa.pages.WelcomePage;
/**
 * @author : Sachin Barpete
 * @purpose : Testcases  for video page
 * 
 */
public class VideoPageTest extends TestBase {

	public VideoPageTest() {
		super();
	}

	IndexPage indexPage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	VideoPage videoPage;
	ForgottPasswordPage forgottPasswordPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.loginLink();
		welcomePage = loginPage.loginBtn(properties.getProperty("username"), properties.getProperty("password"));
		videoPage = welcomePage.clickVideoLink();
	}

	@Test(priority = 1)
	public void videoPageTitleTest() {
		String videoPageTitle = videoPage.verifyVideoPageTitle();
		Assert.assertEquals(videoPageTitle, "Video page", "Video page title not matched");
	}

	@Test(priority = 2)
	public void logoutBtnTest() {
		loginPage = videoPage.logoutBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
