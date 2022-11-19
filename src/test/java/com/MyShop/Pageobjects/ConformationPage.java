package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConformationPage {
	
	WebDriver ldriver;
	public ConformationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//h1[@class=\"page-title\"]")
	WebElement successTitle;

	@FindBy(linkText = "Continue Shopping")
	WebElement continueShippinglink;

	//Thank you for your purchase!

	public String getSuccessTitle()
	{
		String successmsg=successTitle.getText();
		return successmsg;

	}

	public void clickOnContinueShipping()
	{
		continueShippinglink.click();

	}

}
