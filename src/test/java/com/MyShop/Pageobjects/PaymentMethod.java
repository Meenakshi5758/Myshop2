package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	
	WebDriver ldriver;
	public PaymentMethod(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="(//div[@class=\"actions-toolbar\"])[4]/div/button")
	WebElement placeOrderBtn;

	
	public void clickOnPlaceOrder()
	{
		Actions act=new Actions(ldriver);
		act.moveToElement(placeOrderBtn).click().build().perform();
	}


}
