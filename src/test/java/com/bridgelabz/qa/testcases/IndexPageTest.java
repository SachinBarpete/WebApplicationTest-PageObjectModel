package com.bridgelabz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.base.TestBase;
import com.bridgelabz.qa.pages.IndexPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.RegisterPage;

/**
 * @author : Sachin Barpete
 * @purpose : Testcases for index page
 * 
 */
public class IndexPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginpage;
	RegisterPage registerPage;

	public IndexPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
	}

	@Test(priority = 1)
	public void indexPageTitleTest() {
		String indexPageTitle = indexPage.verifyIndexPageTitle();
		Assert.assertEquals(indexPageTitle, "Welcome in Bridgelabz", "Index page title not matched");
	}

	@Test(priority = 2)
	public void loginLinkTest() {
		loginpage = indexPage.loginLink();
	}

	@Test(priority = 3)
	public void registerLinkTest() {
		registerPage = indexPage.registerLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
