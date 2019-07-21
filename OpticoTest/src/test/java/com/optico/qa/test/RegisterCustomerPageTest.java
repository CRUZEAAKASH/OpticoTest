package com.optico.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.optico.qa.pages.LoginPage;
import com.optico.qa.pages.RegisterCustomerPage;
import com.optioc.qa.base.TestBase;

public class RegisterCustomerPageTest extends TestBase {

	LoginPage loginPage;
	RegisterCustomerPage registercustomer;

	public RegisterCustomerPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		/*initalization();
		loginPage = new LoginPage();
		registercustomer = loginPage.login();*/
	}

	public void verifyHeadingTest() {
		String heading = registercustomer.verifyHeading();
		Assert.assertEquals(heading, "Register Customer");
	}

	public void RegisterCustomerTest() {
		System.out.println("Executing Register CUstomer test case");
		registercustomer.registerCustomer();
	}

	@AfterTest
	public void TearDown() {
		System.out.println("Do nothing");
	}
}
