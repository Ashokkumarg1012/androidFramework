package org.appiumDemo.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {


	public AppiumDriverLocalService service;
	
	public Double formattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	} 
	
	public void waitForElement(WebElement ele,String expText, AppiumDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", expText));
	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Ashok//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress(ipAddress).usingPort(port).build();
			return service;
	}
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	


}
