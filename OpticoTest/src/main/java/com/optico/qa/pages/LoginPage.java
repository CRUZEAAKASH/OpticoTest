package com.optico.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.optioc.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//span[contains(text(), ' Login ')]")
	WebElement login;

	@FindBy(xpath = "//*[@class='title']")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateLoginPageLogo() {
		return logo.getText();
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public RegisterCustomer login() {
		String un = prop.getProperty("useranem");
		String pswd = prop.getProperty("password");
		userName.sendKeys(un);
		password.sendKeys(pswd);
		login.click();

		return new RegisterCustomer();

	}
}
