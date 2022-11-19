package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
	WebDriver ldriver;

	public CreateAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="firstname")
	WebElement firstnameBox;

	@FindBy(id="lastname")
	WebElement lastnameBox;

	@FindBy(id="is_subscribed")
	WebElement checkBox;

	@FindBy(id="email_address")
	WebElement emailBox;

	@FindBy(id="password")
	WebElement pwdBox;

	@FindBy(id="password-confirmation")
	WebElement confpwdBox;

	@FindBy(xpath="//button[normalize-space()=\"Create an Account\"]")
	WebElement createBtn;

	public void enterFistname(String firstname)
	{
		firstnameBox.sendKeys(firstname);
	}
	public void enterLatname(String lastname)
	{
		lastnameBox.sendKeys(lastname);
	}
	public void clickOncheckBox()
	{
		checkBox.click();
	}
	public void enterEmail(String email)
	{
		emailBox.sendKeys(email);
	}
	public void enterpwd(String pwd)
	{
		pwdBox.sendKeys(pwd);
	}
	public void enterconfpwd(String confpwd)
	{
		confpwdBox.sendKeys(confpwd);
	}
	public void clickOnCreatBtn()
	{
		createBtn.click();
	}

}
