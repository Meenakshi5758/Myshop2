package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_HomePage {
	
	WebDriver ldriver;

	public Login_HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//BUTTON[@type='button'])[1]")
	WebElement dropdwn;

	@FindBy(xpath = "(//a[contains(text(),\"Sign Out\")])[1]")
	WebElement signOutOption;

	@FindBy(id = "search")
	WebElement searchItemBox;

	@FindBy(xpath = ("//*[@id=\"search_mini_form\"]/div[2]/button"))
	WebElement searchBtn;

	@FindBy(xpath="//button[normalize-space()=\"OK\"]")
	WebElement clearOkbtn;


	public void clickOnDropDown() {
		Actions action = new Actions(ldriver);
		action.moveToElement(dropdwn).click().perform();

	}

	public void clickOnSignOut() {
		Actions action = new Actions(ldriver);
		action.moveToElement(signOutOption).click().perform();
	}

	public void enterinSearchBox(String item) {
		searchItemBox.sendKeys(item);
	}

	public void enterSearchBtn() {
		searchBtn.click();
	}
	public void dltFromCart()
	{
		clearOkbtn.click();
	}
}


