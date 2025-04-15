package org.appiumDemo.pageObjects.android;

import java.util.List;

import org.appiumDemo.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions 
{
    AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement displayPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsConditions;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeButton;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cart']")
	private WebElement toolBarTitle;
	
	public void waitFor()
	{
		waitForElement(toolBarTitle,"Cart",driver);
		
	}
	
	public Double totalPrice()
	{
		  int count = productPrice.size();
	        double totalPrice=0.0;
	        for(int i=0;i<count;i++)
	        {
	        	String amountText = productPrice.get(i).getText();
	        	Double price = formattedAmount(amountText);
	        	totalPrice = totalPrice + price;
	        	
	        }
	        return totalPrice;
	}
	
	public Double displayPrice()
	{
		String displayText = displayPrice.getText();
		return formattedAmount(displayText);
	}
	
	public void tnCAction()
	{
		longPressAction(termsConditions);
		closeButton.click();
	}
	
	public void checkBox()
	{
		checkBox.click();
	}
	
	public void proceed()
	{
		proceedButton.click();
	}

	
	
	
	
	

}
