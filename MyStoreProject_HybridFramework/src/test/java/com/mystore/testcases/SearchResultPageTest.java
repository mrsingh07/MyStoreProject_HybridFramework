package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void productAvailabilityTest(String product) throws Throwable
	{
		Log.startTestCase("productAvailabilityTest");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(product);
		boolean result = searchResultPage.isProductAvailable();
		
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}
