package com.optico.qa.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.optioc.qa.base.TestBase;

public class ListenerTest extends TestBase implements ITestListener {

	private static Logger log = LogManager.getLogger(ListenerTest.class.getName());

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName() + " test case started");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName() + " test case succesfully finished");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("The name of the testcase failed is :" + result.getName());
		log.error("Exception Occured");
		try {
			TestUtil.takeScreenShot(result.getName().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("The name of the testcase skipped is :" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
