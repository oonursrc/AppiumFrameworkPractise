package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AppiumDriver driver) { // FormPage(AndroidDriver<AndroidElement> driver) is also possible
		// TODO Auto-generated constructor stub

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement NameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	private WebElement FemaleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement ContrySelection;

	// @AndroidFindBy(xpath="//*[@text='Argentina']")
	// private WebElement FindArgentina;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	private WebElement SelectArgentina;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShopButton;

	public WebElement getNameField() {
		return NameField;
	}

	public WebElement getFenaleOption() {
		return FemaleOption;
	}

	public WebElement getCountrySelection() {
		return ContrySelection;
	}

	public WebElement getSelectArgentina() {
		return SelectArgentina;
	}

	public WebElement getLetsShopButton() {
		return LetsShopButton;
	}

}
