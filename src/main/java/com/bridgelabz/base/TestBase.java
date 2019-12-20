package com.bridgelabz.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.bridgelabz.qa.util.TestUtil;
import com.bridgelabz.qa.util.WebEventListener;

/**
 * @author : Sachin Barpete
 * @purpose : for set system property, Initializing the browser and launch the
 *          url
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	public static EventFiringWebDriver eventFiringWebdriver;
	public static WebEventListener eventListener;

	public TestBase() {
		properties = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(
					"/home/bridglabz/workspace/WebAppTest/src/main/java/com/bridgelabz/qa/config/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// for launching the browser
	public void initialization() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/bridglabz/selenium webdriver/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/bridglabz/selenium webdriver/geckodriver-v0.26.0-linux64/geckodriver");
			driver = new FirefoxDriver();
		}

		eventFiringWebdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFiringWebdriver.register(eventListener);
		driver = eventFiringWebdriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

	}
}
