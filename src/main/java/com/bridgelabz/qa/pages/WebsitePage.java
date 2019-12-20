
package com.bridgelabz.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.base.TestBase;
/**
 * @author : Sachin Barpete
 * @purpose : website page details of application
 * 
 */
public class WebsitePage extends TestBase {

	// Initializing the page Objects
	public WebsitePage() {
		PageFactory.initElements(driver, this);
	}
}
