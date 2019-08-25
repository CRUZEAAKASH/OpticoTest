/**
 * 
 */
package com.optico.qa.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.optico.qa.pages.NewLoginPage;
import com.optico.qa.pages.NewRegisterCustomerPage;

/**
 * @author aakas
 *
 */
public class NewLoginPageTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void ValidateLoginPageLogoTest() {
		String logo = page.getInstance(NewLoginPage.class).ValidateLoginPageLogo();
		System.out.println("Printing logo");
		// String logo = loginPage.ValidateLoginPageLogo();
		AssertJUnit.assertEquals(logo, "Optico");
	}

	@Test(priority = 2, enabled = true)
	public void verifyTitleTest() {
		String title = page.getInstance(NewLoginPage.class).verifyTitle();
		AssertJUnit.assertEquals(title, "Optico");
	}

	@Test(priority = 3, enabled = true)
	public void loginTest() {
		NewRegisterCustomerPage registercustomer = page.getInstance(NewLoginPage.class).login();
	}
}
