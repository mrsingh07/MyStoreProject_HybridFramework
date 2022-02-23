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
public class AccountCreationPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//h1[contains(text(), 'Create an account')]")
	WebElement formTitle;
	
	@FindBy(id = "id_gender1")
	WebElement rbtnMale;
	
	@FindBy(id = "id_gender2")
	WebElement rbtnFemale;
	
	@FindBy(id = "customer_firstname")
	WebElement txtCustFirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement txtCustLastName;
	
	@FindBy(id = "passwd")
	WebElement txtNewPassword;
	
	@FindBy(id = "days")
	WebElement drpDays;
	
	@FindBy(id = "months")
	WebElement drpMonths;
	
	@FindBy(id = "years")
	WebElement drpYears;
	
	@FindBy(id = "firstname")
	WebElement txtAddFirstName;
	
	@FindBy(id = "lastname")
	WebElement txtAddLastName;
	
	@FindBy(name = "company")
	WebElement companyName;
	
	@FindBy(id = "address1")
	WebElement txtaddress;
	
	@FindBy(id = "city")
	WebElement txtcity;
	
	@FindBy(id = "id_state")
	WebElement drpState;
	
	@FindBy(id = "postcode")
	WebElement txtPostalCode;
	
	@FindBy(id = "id_country")
	WebElement drpCountry;
	
	@FindBy(id = "phone_mobile")
	WebElement txtPhoneNum;
	
	@FindBy(id = "submitAccount")
	WebElement btnRegister;
	
	
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone)
	{
		if(gender.equalsIgnoreCase("Mr")) {
			action.click(getDriver(), rbtnMale);
		} else {
			action.click(getDriver(), rbtnFemale);
		}
		
		action.type(txtCustFirstName, fName);
		action.type(txtCustLastName, lName);
		action.type(txtNewPassword, pswd);
		action.selectByValue(drpDays, day);
		action.selectByValue(drpMonths, month);
		action.selectByValue(drpYears, year);
		action.type(companyName, comPany);
		action.type(txtaddress, addr);
		action.type(txtcity, cityString);
		action.selectByVisibleText(stateName, drpState);
		action.type(txtPostalCode, zip);
		action.selectByVisibleText(countryName, drpCountry);
		action.type(txtPhoneNum, mobilePhone);
	}
	
	public HomePage validateRegistration() throws Throwable {
		btnRegister.click();
		return new HomePage();
	}
	
	public boolean validateAccountCreatePage() throws Throwable
	{
		return action.isDisplayed(getDriver(), formTitle);
	}

}
