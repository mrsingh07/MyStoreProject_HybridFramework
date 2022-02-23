package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//a[@class = 'login']")
	WebElement lnkSignIn;
	
	@FindBy(xpath = "//img[@class = 'logo img-responsive']")
	WebElement mystoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchBox;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable
	{
		action.click(getDriver(), lnkSignIn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable
	{
		return action.isDisplayed(getDriver(), mystoreLogo);
	}
	
	public String getMyStoreTitle() throws Throwable
	{
		String mystoreTitle = getDriver().getTitle();
		return mystoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable
	{
		action.type(searchBox, productName);
		action.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}

}
