package org.appiumDemo.Android;

import org.appiumDemo.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class MultipleTests extends AndroidBaseTest{
	

	@Test(priority=1)
	public void fillform_errorValidation()
	{
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalogue productCatalogue=formPage.letsShopClick();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()!=1);
	}
	
	@Test(priority=2, groups = {"smoke"})
	public void fillform_positivecase()
	{
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.setNameField("Suyash");
		ProductCatalogue productCatalogue=formPage.letsShopClick();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
	}

}
