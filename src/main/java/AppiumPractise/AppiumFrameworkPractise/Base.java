package AppiumPractise.AppiumFrameworkPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	
	public static AndroidDriver<AndroidElement> driver;
	
	
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer() {  // start appium server
		
		boolean flag= checkIfServerIsRunning(4723);
		
		if(!flag) {
			service= AppiumDriverLocalService.buildDefaultService();
			service.start();
		}

		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		
		try {
			serverSocket= new ServerSocket(port);
			serverSocket.close();
			
		}catch (Exception e) {
			//if controls comes here then port is in use
			isServerRunning= true;
		}finally {
			serverSocket=null;
		}
		
		
		return isServerRunning;
		
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\resources\\startEmulator.bat");
		Thread.sleep(8000);
	}
	

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String serverLink = "http://127.0.0.1:4723/wd/hub";
		InputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\global.properties");
		//String propPath = System.getProperty("user.dir") + "\\resources\\global.properties";
		
		Properties prop = new Properties();
		prop.load(fis);
		
	
		File appDir= new File("resources");
		File app = new File(appDir, (String) prop.get(appName));

		DesiredCapabilities cap = new DesiredCapabilities();
		
		//for local run, add emulator to device property in global.properties.
		//String device = (String) prop.get("device");
		
		//for running via maven , remove emulator from device property in global.properties.
		String device = System.getProperty("deviceName");  // mvn test -DdeviceName=emulator

		if (device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumDemo2");
			startEmulator();
		} else if (device.equals("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}

		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumDemo2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver<>(new URL(serverLink), cap);

		return driver;

	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}

}
