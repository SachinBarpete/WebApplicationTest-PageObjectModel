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
import com.bridgelabz.qa.pages.WelcomePage;
/**
 * @author : Sachin Barpete
 * @purpose : Testcases  for reset password page
 * 
 */
public class ResetPasswordPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	ForgottPasswordPage forgottPasswordPage;
	ResetPasswordPage resetPasswordPage;
	WelcomePage welcomePage;

	public ResetPasswordPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.loginLink();
		forgottPasswordPage = loginPage.forgottPassword();
		resetPasswordPage = forgottPasswordPage.submit(properties.getProperty("username"),
				properties.getProperty("email"));
	}

	@Test(priority = 1)
	public void resetPasswordPageTitleTest() {
		String resetPasswordPageTitle = resetPasswordPage.verifyResetPasswordPageTitle();
		Assert.assertEquals(resetPasswordPageTitle, "reset password", "Reset password page title not matched");
	}

	@Test(priority = 2)
	public void submitTest() {
		welcomePage = resetPasswordPage.submit(properties.getProperty("newPassword"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
