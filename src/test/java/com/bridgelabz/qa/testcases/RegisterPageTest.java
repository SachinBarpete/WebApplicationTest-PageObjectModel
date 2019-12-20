package com.bridgelabz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.RegisterPage;
import com.bridgelabz.qa.pages.WelcomePage;
import com.bridgelabz.qa.util.TestUtil;

/**
 * @author : Sachin Barpete
 * @purpose : Testcases for register page
 */
public class RegisterPageTest extends TestBase {

	IndexPage indexPage;
	RegisterPage registerPage;
	WelcomePage welcomePage;
	String sheetName = "registerTestData";

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		registerPage = indexPage.registerLink();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String registerPageTitle = registerPage.verifyRegisterPageTitle();
		Assert.assertEquals(registerPageTitle, "Register page", "Register page title not matched");
	}

	@DataProvider
	public Object[][] getRegisterTestData() {
		return TestUtil.getTestData(sheetName);
	}

	@Test(priority = 2, dataProvider = "getRegisterTestData")
	public void submitTest(String username, String name, String mobileNo, String email, String address, String password,
			String confirmPassword) {
		welcomePage = registerPage.submit(username, name, mobileNo, email, address, password, confirmPassword);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
