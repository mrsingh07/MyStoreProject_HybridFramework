package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadconfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\Configuration\\config.properties");
			prop.load(ip);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver()
	{
		//Get driver from threadLocalmap
		return driver.get();
	}
	
	public static void launchApp(String browserName)
	{
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		 
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		
		String URL = prop.getProperty("baseURL");
		getDriver().get(URL);
		
	}
	
	@AfterSuite(groups = {"Smoke","Sanity","Regression"})
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	

}
