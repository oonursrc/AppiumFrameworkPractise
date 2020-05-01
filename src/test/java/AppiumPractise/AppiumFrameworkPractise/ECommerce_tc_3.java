package AppiumPractise.AppiumFrameworkPractise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;
import resources.Utilities;

public class ECommerce_tc_3 extends Base {
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

	@Test
	public void totalValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		startServer(); // in Base class 

		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		FormPage formpage = new FormPage(driver);
		ProductsPage productspage= new ProductsPage(driver);
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		Utilities utilities = new Utilities(driver);

		
		formpage.getNameField().sendKeys("hello");

		driver.hideKeyboard();
		
		formpage.getFenaleOption().click();

		formpage.getCountrySelection().click();

		utilities.scrollToText("Argentina");
		
		formpage.getSelectArgentina().click();

		formpage.getLetsShopButton().click();

		
		productspage.getAddToCart().get(0).click();
		productspage.getAddToCart().get(0).click();// after clicking text is changed thats why again we click to get(0)

		productspage.getGoToCart().click();

		Thread.sleep(4000);
		
		

		int count = productspage.getProductPrice().size();

		double sum = 0;

		for (int i = 0; i < count; i++)

		{

			String amount1 = productspage.getProductPrice().get(i).getText();

			double amount = getAmount(amount1);

			sum = sum + amount;// 280.97+116.97

		}

		System.out.println(sum + " sum of added products");
		

		String total = checkoutpage.getTotalPrice().getText();

		total = total.substring(1);

		double totalValue = Double.parseDouble(total);

		System.out.println(totalValue + " Total value of products to be paid");

		if (sum == totalValue) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		service.stop();

	}

	public static double getAmount(String value)

	{

		value = value.substring(1);

		double amount2value = Double.parseDouble(value);

		return amount2value;

	}

}
