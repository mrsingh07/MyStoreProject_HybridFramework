package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//p[@id = 'add_to_cart']//span")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//div[@id = 'layer_cart']//h2/i")
	WebElement productAddedMsg;
	
	@FindBy(xpath = "//a[@class = 'btn btn-default button button-medium']/span")
	WebElement btnProceedToCheckOut;
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String qty)
	{
		action.type(quantity, qty);
	}
	
	public void selectSize(String s)
	{
		action.selectByVisibleText(s, size);
	}
	
	public void clickOnAddToCart()
	{
		action.click(getDriver(), btnAddToCart);
	}
	
	public boolean validateAddToCart() throws Throwable
	{
		action.fluentWait(getDriver(), productAddedMsg, 10);
		return action.isDisplayed(getDriver(), productAddedMsg);
	}
	
	public OrderPage clickOnCheckOut() throws Exception
	{
		action.fluentWait(getDriver(), btnProceedToCheckOut, 10);
		action.JSClick(getDriver(), btnProceedToCheckOut);
		return new OrderPage();
	}

}
