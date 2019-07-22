package com.optico.qa.util;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.optioc.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 10;

	public static WebDriverWait wait = new WebDriverWait(driver, 20);
}
