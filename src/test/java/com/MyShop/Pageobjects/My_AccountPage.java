package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_AccountPage {
	
	WebDriver ldriver;

	public My_AccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
	WebElement username;

	public String getUserName()
	{
		String userName=username.getText();
		return userName;
	}

}
