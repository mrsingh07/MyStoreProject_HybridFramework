package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

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
	
	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class, groups = "Regression")
	public void verifyTotalPrice(String product, String qty, String size) throws Throwable
	{
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(product);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty)))+2;
		
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
		
	}

}
