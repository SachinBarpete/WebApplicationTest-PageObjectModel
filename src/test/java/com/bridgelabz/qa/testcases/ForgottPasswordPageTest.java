package com.bridgelabz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.qa.pages.ForgottPasswordPage;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.ResetPasswordPage;
/**
 * @author : Sachin Barpete
 * @purpose : Testcases  for forgott password page
 * 
 */
public class ForgottPasswordPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	ForgottPasswordPage forgottPasswordPage;
	ResetPasswordPage resetPasswordPage;

	public ForgottPasswordPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.loginLink();
		forgottPasswordPage = loginPage.forgottPassword();
	}

	@Test(priority = 1)
	public void forgottPasswordPageTitleTest() {
		String forgottPasswordPageTitle = forgottPasswordPage.verifyForgottPasswordPageTitle();
		Assert.assertEquals(forgottPasswordPageTitle, "forgott password", "forgott password page title not matched");
	}

	@Test(priority = 2)
	public void submitTest() {
		resetPasswordPage = forgottPasswordPage.submit(properties.getProperty("username"),
				properties.getProperty("email"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
