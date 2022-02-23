package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id = "cgv")
	WebElement termsCheckBox;
	
	@FindBy(xpath = "//button[@name = 'processCarrier']/span")
	WebElement btnProceedToCheckOut;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnTermsCheckBox()
	{
		action.click(getDriver(), termsCheckBox);
	}
	
	public PaymentPage clickOnProceedToCheckOut()
	{
		action.click(getDriver(), btnProceedToCheckOut);
		return new PaymentPage();
	}

}
