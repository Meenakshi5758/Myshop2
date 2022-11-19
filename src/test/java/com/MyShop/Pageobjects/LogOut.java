package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {

	WebDriver ldriver;

	public LogOut(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//h1[normalize-space()=\"You are signed out\"]")
	WebElement signOutText;

	public String getSignoutText()
	{
		String signouttext=signOutText.getText();
		return signouttext;

	}

}
