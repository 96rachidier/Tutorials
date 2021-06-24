package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {  //PAGE OBJECT 2: video 4, Page Object Model con Selenium WebDriver cargo usuario
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By loginBtnLocator = By.name("submit");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void SignIn() {

		if(isDisplayed(userLocator)){
			type("qualityadmin", userLocator);
			type("pass1", passLocator);
			click(loginBtnLocator);
		}else{
			System.out.println("Register pages was not found");
		}
		
	}

	public boolean isHomePageDisplayed() {
		return true;
	}
}
