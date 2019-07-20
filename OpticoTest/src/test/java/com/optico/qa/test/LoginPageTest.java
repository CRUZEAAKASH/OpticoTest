package com.optico.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.optico.qa.pages.LoginPage;
import com.optico.qa.pages.RegisterCustomer;
import com.optioc.qa.base.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	RegisterCustomer registercustomer;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initalization();
		loginPage = new LoginPage();
	}

	@Test
	public void ValidateLoginPageLogoTest() {
		String logo = loginPage.ValidateLoginPageLogo();
		Assert.assertEquals(logo, "Optico");
	}

	@Test
	public void verifyTitle() {
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "Optico");
	}

	@Test
	public void login() {
		registercustomer = loginPage.login();
	}

	@AfterTest()
	public void TearDown() {
		// driver.close();
	}

}
