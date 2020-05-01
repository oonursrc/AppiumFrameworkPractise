package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

	public ProductsPage(AppiumDriver driver) {//FormPage(AndroidDriver<AndroidElement> driver) is also possible
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private List<WebElement> AddToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> ProductPrice;
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement GoToCart;
	
	
	
	
	public List<WebElement> getAddToCart() {
		return AddToCart;
	}
	
	public List<WebElement> getProductPrice() {
		return ProductPrice;
	}
	
	public WebElement getGoToCart() {
		return GoToCart;
	}
	

}
