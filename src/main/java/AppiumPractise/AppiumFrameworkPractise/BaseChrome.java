package AppiumPractise.AppiumFrameworkPractise;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystemException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseChrome {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		String serverLink= "http://127.0.0.1:4723/wd/hub";
		
		/*File f = new File("src");
		File fs = new File(f, "original.apk");*/
		
		String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\chromedriver.exe";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability("chromedriverExecutable",chromeDriverLocation);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(serverLink),cap);
		
		
		return driver;
		
		
	}

}
