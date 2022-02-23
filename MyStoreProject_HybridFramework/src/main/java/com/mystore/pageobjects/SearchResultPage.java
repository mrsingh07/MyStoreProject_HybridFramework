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
public class SearchResultPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//img[@alt = 'Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()
	{
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
