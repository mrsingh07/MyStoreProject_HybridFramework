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

public class LoginPageTest extends BaseClass{
	
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
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable
	{
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	//username and password from config file
		homePage = loginPage.login(uname,pswd);	//uname and pswd from excel
		
		String actualTitle = homePage.getTitle();
		String expectedTitle = "My account - My Store";
		
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login Successfully");
		Log.endTestCase("loginTest");
		
	}

}
