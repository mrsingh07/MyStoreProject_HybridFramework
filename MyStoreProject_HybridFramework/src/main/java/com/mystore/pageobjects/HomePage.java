/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author HARVINDER
 *
 */
public class HomePage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//a[@title = 'My wishlists']//span")
	WebElement myWishList;
	
	@FindBy(xpath = "//a[@title = 'Orders']//span")
	WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyWishList()
	{
		return action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory()
	{
		return action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL()
	{
		String homePageCurrURL = action.getCurrentURL(getDriver());
		return homePageCurrURL;
	}
	
	public String getTitle()
	{
		String titleHomePage = action.getTitle(getDriver());
		return titleHomePage;
	}
	

}
