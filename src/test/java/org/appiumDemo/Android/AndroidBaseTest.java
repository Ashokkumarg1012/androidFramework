package org.appiumDemo.Android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.appiumDemo.pageObjects.android.FormPage;
import org.appiumDemo.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils {
	


	public AndroidDriver driver;	
	FormPage formPage;
	
	
	@BeforeClass(alwaysRun=true)
	public void appiumConfigure() throws URISyntaxException, IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//data.properties");
		prop.load(fis);
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
//		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service=startAppiumServer(ipAddress,Integer.parseInt(port));
		service.start();
	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable("C://Users//Ashok//Desktop//Udemy//chromedriver-win64//chromedriver.exe");
//		options.setApp("C://Users//Ashok//eclipse-workspace//Udem//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//General-store.apk");
		options.setAutomationName("UiAutomator2");
		options.setPlatformName("ANDROID");
//		options.setAppPackage("com.androidsample.generalstore");
//		options.setAppActivity("com.androidsample.generalstore.MainActivity");
		
	    driver = new AndroidDriver(service.getUrl(), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    formPage = new FormPage(driver);
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
	
	public Double formattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	

	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration",2000));
	
	}
	
	
	
	public void longPress(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000));

	}
	
	
	@AfterClass(alwaysRun=true)
	
	public void teardown() {
		driver.quit();
		service.stop();
	}

}
