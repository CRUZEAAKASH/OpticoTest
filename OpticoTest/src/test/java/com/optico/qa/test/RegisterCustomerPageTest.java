package com.optico.qa.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.optico.qa.pages.LoginPage;
import com.optico.qa.pages.RegisterCustomerPage;
import com.optico.qa.util.TestUtil;
import com.optioc.qa.base.TestBase;

public class RegisterCustomerPageTest extends TestBase {

	LoginPage loginPage;
	RegisterCustomerPage registercustomer;
	String sheetName = "CustomerDetails";

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
		AssertJUnit.assertEquals(heading, "Register Customer");
	}

	@Test(priority = 5, dataProvider = "getOpticoTestData")
	public void RegisterCustomerTest(String title, String Name, String Gender, String DOB, String Age, String Mobile,
			String Address) throws InterruptedException {
		//System.out.println("Executing Register CUstomer test case");
		LoginPageTest.registercustomer.registerCustomer(title, Name, Gender, DOB, Age, Mobile, Address);
	}

	@DataProvider
	public Object[][] getOpticoTestData() throws IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("Do nothing");
	}
}
