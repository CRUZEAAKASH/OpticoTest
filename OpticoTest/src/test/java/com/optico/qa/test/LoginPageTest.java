package com.optico.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.optico.qa.pages.LoginPage;
import com.optico.qa.pages.RegisterCustomerPage;
import com.optioc.qa.base.TestBase;

public class LoginPageTest extends TestBase {

	static LoginPage loginPage;
	static RegisterCustomerPage registercustomer;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initalization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void ValidateLoginPageLogoTest() {
		String logo = loginPage.ValidateLoginPageLogo();
		Assert.assertEquals(logo, "Optico");
	}

	@Test(priority = 2)
	public void verifyTitleTest() {
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "Optico");
	}

	@Test(priority = 3)
	public void loginTest() {
		registercustomer = loginPage.login();
	}

	@AfterTest()
	public void TearDown() {
		driver.close();
	}

}
