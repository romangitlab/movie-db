package testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int counter = 0;

	@Override
	public boolean retry(ITestResult result) {
		int retryLimit = 3;
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
