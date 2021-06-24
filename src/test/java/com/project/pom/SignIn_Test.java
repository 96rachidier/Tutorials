package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test { // video 4:Page Object Model con Selenium WebDriver testeo usuario cargado (page object 2)

	
	private WebDriver driver;
	SignInPage signInPage; //objeto registerpage 
	
	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("http://demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException{
		signInPage.SignIn();
		Thread.sleep(2000);
		assertTrue(signInPage.isHomePageDisplayed());
	}

}
