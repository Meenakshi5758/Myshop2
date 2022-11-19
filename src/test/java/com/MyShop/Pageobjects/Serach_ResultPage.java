package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Serach_ResultPage {
	WebDriver ldriver;
	public Serach_ResultPage(WebDriver rdriver ) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()=\"Search results for: 'Top'\"]")
	WebElement textofsearchResult;

	@FindBy(linkText = "Electra Bra Top")
	WebElement productName;


	public String getTextOfSearchResult()
	{
		String textserch=textofsearchResult.getText();
		return textserch;
	}

	public String getTextOfProduct()
	{
		String textProduct=productName.getText();
		return textProduct;
	}
	public void clickOnProduct() {
		productName.click();
	}

}
