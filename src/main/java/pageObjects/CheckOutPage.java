package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
	
	public CheckOutPage(AppiumDriver driver) { //FormPage(AndroidDriver<AndroidElement> driver) is also possible
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement TotalPrice;
	
	public WebElement getTotalPrice() {
		return TotalPrice;
	}
	

}
