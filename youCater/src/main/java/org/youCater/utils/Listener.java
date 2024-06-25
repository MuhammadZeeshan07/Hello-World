package org.youCater.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener implements ITestListener {

	private WebActions webActions;
	private WebDriver driver;
	private ExtentTest test;
	private ExtentReports extent = HTMLReport.getReporterObject();

	private static final SharedContextAttributeManager sharedContextAttributeManager = new SharedContextAttributeManager();
	private static int finishedSuiteCount = 0;

	public Listener() {

		webActions = new WebActions(driver);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);

		String testName = result.getMethod().getMethodName();
		String testDescription = "";

		if (result.getMethod().getConstructorOrMethod().getMethod()
				.isAnnotationPresent(org.testng.annotations.Test.class)) {
			org.testng.annotations.Test testAnnotation = result.getMethod().getConstructorOrMethod().getMethod()
					.getAnnotation(org.testng.annotations.Test.class);
			testDescription = testAnnotation.description();
		}

		if (!testDescription.isEmpty()) {
			testName = testDescription;
		}

		test = extent.createTest(testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath = webActions.getScreenShot(result.getMethod().getMethodName(), driver);
			test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		extent.flush();
		finishedSuiteCount++;

		if (sharedContextAttributeManager.isEmailNotSent() && isLastSuite(context)) {
			SendReportEmail.sendReportViaEmail();
			sharedContextAttributeManager.setEmailSent(true);
		}
	}

	private boolean isLastSuite(ITestContext context) {
		return finishedSuiteCount == context.getSuite().getXmlSuite().getTests().size();
	}

}
