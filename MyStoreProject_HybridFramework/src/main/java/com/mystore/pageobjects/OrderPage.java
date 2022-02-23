package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//td[@class = 'cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text() = 'Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		String unitP = unitPrice.getText();
		String unitPri = unitP.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unitPri);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice()
	{
		String totalP = totalPrice.getText();
		String totalPri = totalP.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(totalPri);
		return finalTotalPrice/100;
		
	}
	
	public LoginPage clickOnCheckOut()
	{
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}

}
