package AppiumPractise.AppiumFrameworkPractise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends Base {
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	@Test
	public void ApiDemoApp() throws IOException, InterruptedException {
		
		startServer(); // in Base class 

		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemoApp");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HomePage h = new HomePage(driver);
		Preferences p = new Preferences(driver);

		h.Preferences.click();
		p.Dependencies.click();

		/*
		 * driver.findElementByXPath("//android.widget.TextView[@text='Preference']").
		 * click();
		 * 
		 * driver.
		 * findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']"
		 * ).click();
		 * 
		 * driver.findElementById("android:id/checkbox").click();
		 * 
		 * driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		 * 
		 * driver.findElementByClassName("android.widget.EditText").sendKeys("Onur");
		 * 
		 * driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		 */

		service.stop();
	}

}
