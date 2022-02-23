package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id = "email")
	WebElement userName;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement btnSignIn;
	
	@FindBy(id = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id = "SubmitCreate")
	WebElement btnCreateNewAccount;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname,String pwd) throws Throwable
	{
		action.type(userName, uname);
		action.type(password, pwd);
		action.click(getDriver(), btnSignIn);
		return new HomePage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable
	{
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), btnCreateNewAccount);
		return new AccountCreationPage();
	}
	
	public AddressPage login1(String uname,String pwd) throws Throwable
	{
		action.type(userName, uname);
		action.type(password, pwd);
		action.click(getDriver(), btnSignIn);
		return new AddressPage();
	}
	

}
