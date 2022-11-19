package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Shipping_Address {
	WebDriver ldriver;

	public Shipping_Address(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath =  "//div[@name=\"shippingAddress.street.0\"]/div/input")
	WebElement addressBox1;

	@FindBy(xpath = "(//div[@class=\"field additional\"])[1]/div/input")
	WebElement addressBox2;

	@FindBy(xpath = "(//div[@class=\"field additional\"])[2]/div/input")
	WebElement addressBox3;

	@FindBy(xpath = "//div[@name=\"shippingAddress.city\"]/div/input")
	WebElement city;

	@FindBy(xpath = "//div[@name=\"shippingAddress.region_id\"]/div/select")
	WebElement stateDropDown;

	@FindBy(xpath = "//div[@name=\"shippingAddress.postcode\"]/div/input")
	WebElement zipCode;

	@FindBy(xpath = "//div[@name=\"shippingAddress.country_id\"]/div/select")
	WebElement countryDropDown;

	@FindBy(xpath = "//div[@name=\"shippingAddress.telephone\"]/div/input")
	WebElement mobNo;

	@FindBy(xpath = "(//div[@class=\"actions-toolbar\"])[2]/div/button")
	WebElement nextBtn;

	@FindBy(xpath = "//div[@id=\"checkout-step-shipping_method\"]/form/div[1]/table/tbody/tr[2]/td[1]")
	WebElement radiobtn;


	public void enterAddress1(String address)
	{
		addressBox1.sendKeys(address);

	}
	public void enterAddress2(String address)
	{
		addressBox1.sendKeys(address);

	}
	public void enterAddress3(String address)
	{
		addressBox1.sendKeys(address);

	}
	public void enterCity(String City)
	{
		city.sendKeys(City);

	}

	public void enterPhnO(String phoneNum)
	{
		mobNo.sendKeys(phoneNum);

	}

	public void clickOnNextBtn() {
		Actions act=new Actions(ldriver);
		act.moveToElement(nextBtn).click().perform();
	}
	public void selectState()
	{
		Select select=new Select(stateDropDown);
		select.selectByVisibleText("Karnataka");
	}
	public void enterZipCode(String Zipcode)
	{
		zipCode.sendKeys(Zipcode);
	}
	public void selectCountry()
	{
		Select select=new Select(countryDropDown);
		select.selectByVisibleText("India");
	}
	public void clickOnShippingMthod()
	{
		radiobtn.click();

	}

}
