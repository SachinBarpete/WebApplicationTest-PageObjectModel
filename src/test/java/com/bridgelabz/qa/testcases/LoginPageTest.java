package com.bridgelabz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.qa.pages.ForgottPasswordPage;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.WelcomePage;
import com.bridgelabz.qa.util.TestUtil;

/**
 * @author : Sachin Barpete
 * @purpose : Testcases for login page
 * 
 */
public class LoginPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	ForgottPasswordPage forgottPasswordPage;
	String sheetName = "loginTestData";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.loginLink();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login to Bridgelabz", "Login page title not matched");
	}

	@DataProvider
	public Object[][] getLoginTestdata() {
		return TestUtil.getTestData(sheetName);
	}

	@Test(priority = 2, dataProvider = "getLoginTestdata")
	public void loginTest(String username, String password) {
		welcomePage = loginPage.login(username, password);
	}

	@Test(priority = 3)
	public void forgottPasswordTest() {
		forgottPasswordPage = loginPage.forgottPassword();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
