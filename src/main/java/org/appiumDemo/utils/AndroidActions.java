package org.appiumDemo.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;	
	}
	
//	public void waitForElement(WebElement ele)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
//	}
	

	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration",2000));
		

	
	}
	
	public void scrollToButtomAction(String direction)
	{
		((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of("left",100, "top",100,"width",200, "height", 200, "direction",direction, "percent",3.0));

	}
	
	public void scrollToElement(String str)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	public void swipe(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction",direction, "percent", 0.25));
	}
	
	
	public void dragDropGesture(WebElement ele) throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 620,
			    "endY", 540
			    			    
			));
		Thread.sleep(2000);
	}
	

}
