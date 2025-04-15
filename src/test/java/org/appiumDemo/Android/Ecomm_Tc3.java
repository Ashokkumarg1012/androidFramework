package org.appiumDemo.Android;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.appiumDemo.pageObjects.android.CartPage;
import org.appiumDemo.pageObjects.android.FormPage;
import org.appiumDemo.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Ecomm_Tc3 extends AndroidBaseTest {
	

	


	@Test(dataProvider="getData")
	public void addItems(String name,String gender,String country) throws InterruptedException
	{
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		ProductCatalogue productCatalogue = formPage.letsShopClick();
		productCatalogue.addToCart(0);
		productCatalogue.addToCart(0);
		CartPage cartPage = productCatalogue.gotoCartPage();
		cartPage.waitFor();
		Assert.assertEquals(cartPage.totalPrice(), cartPage.displayPrice());
		cartPage.tnCAction();
		cartPage.checkBox();
		cartPage.proceed();
	
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		Thread.sleep(2000);
			
//        List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//        int count = productPrice.size();
//        double totalPrice=0.0;
//        for(int i=0;i<count;i++)
//        {
//        	String amountText = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
//        	Double price = formattedAmount(amountText);
//        	totalPrice = totalPrice + price;
//        	
//        }
//        
//        String displayText = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//        Double displayPrice = formattedAmount(displayText);
//        
//        Assert.assertEquals(totalPrice, displayPrice);
//        
//        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//       longPressAction(ele);
//        driver.findElement(By.id("android:id/button1")).click();
 //       driver.findElement(By.className("android.widget.CheckBox")).click();
 //       driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(10000);
        Set<String> contexts = driver.getContextHandles();
        for(String c:contexts)
        {
        	System.out.println(c);
        	
        		
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        
        
        
        

	}
	
//	@BeforeMethod
	public void preSetup()
	{
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"Maxwell","male","Argentina"}};
		
	}
	

}
