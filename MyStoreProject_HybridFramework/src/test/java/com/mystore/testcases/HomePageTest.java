package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

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
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void wishListTest(String uname, String pswd) throws Throwable
	{
		Log.startTestCase("wishListTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname,pswd);
		
		boolean res = homePage.validateMyWishList();
		Assert.assertTrue(res);
		Log.endTestCase("wishListTest");
		
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void orderHistoryTest(String uname, String pswd) throws Throwable
	{
		Log.startTestCase("orderHistoryTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname,pswd);
		
		boolean res = homePage.validateOrderHistory();
		Assert.assertTrue(res);
		Log.endTestCase("orderHistoryTest");
		
	}
	


}
