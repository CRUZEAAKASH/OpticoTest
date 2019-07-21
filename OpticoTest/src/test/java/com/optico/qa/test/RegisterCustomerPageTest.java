package com.optico.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.optico.qa.pages.LoginPage;
import com.optico.qa.pages.RegisterCustomerPage;
import com.optioc.qa.base.TestBase;

public class RegisterCustomerPageTest extends TestBase {

	LoginPage loginPage;
	RegisterCustomerPage registercustomer;

	public RegisterCustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		/*
		 * initalization(); loginPage = new LoginPage(); registercustomer =
		 * loginPage.login();
		 */
	}

	@Test(priority = 4)
	public void verifyHeadingTest() {
		String heading = LoginPageTest.registercustomer.verifyHeading();
		System.out.println("printing heading" + heading);
		Assert.assertEquals(heading, "Register Customer");
	}

	@Test(priority = 5)
	public void RegisterCustomerTest() throws InterruptedException {
		System.out.println("Executing Register CUstomer test case");
		LoginPageTest.registercustomer.registerCustomer();
	}

	@AfterMethod
	public void TearDown() {
		// System.out.println("Do nothing");
	}
}
