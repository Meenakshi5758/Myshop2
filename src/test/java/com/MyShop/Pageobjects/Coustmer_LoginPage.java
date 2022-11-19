package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Coustmer_LoginPage {

	WebDriver ldriver;

	public Coustmer_LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id="email")
	WebElement emailTextBox;

	@FindBy(id="pass")
	WebElement pwdTextBox;

	@FindBy(xpath = "//*[@id=\"send2\"]/span")
	WebElement signInBtn;

	public void enterEmail(String email)
	{
		emailTextBox.sendKeys(email);
	}

	public void enterPwd(String pass)
	{
		pwdTextBox.sendKeys(pass);
	}
	public void clickOnSignIn()
	{
		signInBtn.click();
	}
}
