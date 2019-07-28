package com.optico.qa.util;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.optioc.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	private static Logger log = LogManager.getLogger(WebEventListener.class.getName());

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("Before Alerting accept");

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("After Alerting accept");

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

		System.out.println("After dismissing alert");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before dismissing alert");

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("Before Navigating to " + url);

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("After navigating to" + url);

	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before navigating back");

	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("After navigating back");

	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating forward");

	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("After navigating forward");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating Refresh");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("After Navigating refresh");

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before Find by " + element);

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("After find by" + element);

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("Before clicking on " + element);

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

		log.info("Clicked on " + element);

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

		log.info("Before changing value of" + element);

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

		log.info("After changing value of" + element);

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		log.error("Exception Occured");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
