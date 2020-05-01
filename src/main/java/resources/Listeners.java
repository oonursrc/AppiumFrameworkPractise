package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AppiumPractise.AppiumFrameworkPractise.Base;

public class Listeners implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Start Success _ Listener onTestStart");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String s = result.getName();
		try {
			Base.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}
	
}
