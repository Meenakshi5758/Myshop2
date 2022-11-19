package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Create an Account")
	WebElement creatLink;

	@FindBy(linkText = "Sign In")
	WebElement signinLink;

	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
	WebElement signInName;



	public void clickOnCreatAccn()
	{
		creatLink.click();
	}
	public void clickOnSignIn()
	{
		signinLink.click();
	}
	public String getSignInName()
	{
		String fullName=signInName.getText();
		return fullName;
	}

}
