package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener
{	
	public void onTestStart(ITestResult result) {
		Log.info("");
		Log.info("=========== Test case execution started: " + result.getName() + " ================");
		Log.info("");
	}

	public void onTestSuccess(ITestResult result) {

		Log.info("================ Test case is PASSED: " + result.getName()+" ===================");
		Log.info("");
	}

	public void onTestFailure(ITestResult result) {

		Log.error("================= Test case is FAILED: " + result.getName() + " ==================");
		Log.info("");
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("Test case is SKIPPED: " + result.getName());
		Log.info("");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		Log.info("********************** Test case execution for suite is started. *****************************");
		Log.info("");
	}

	public void onFinish(ITestContext context) {
		Log.info("*********************** Test case execution for suite is completed. **************************");
		Log.info("");
	}
}
