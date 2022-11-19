package com.MyShop.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver ldriver;
	public ProductPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[normalize-space()=\"M\"]")
	WebElement size;

	@FindBy(xpath = "//div[@attribute-code=\"color\"]/div/div[3]")
	WebElement purpleColor;

	@FindBy(id = "qty")
	WebElement quantity;

	@FindBy(id="product-addtocart-button")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[@class=\"action delete\"]")
	WebElement dltFromCart;

	@FindBy(xpath = "//a[@class=\"action showcart\"]")
	WebElement myCartLink;

	@FindBy(id="top-cart-btn-checkout")
	WebElement checkOutBtn;

	public void clickOnSize()
	{
		size.click();
	}

	public void selectColor()
	{
		purpleColor.click();
	}
	public void setQuantity(String quant) 
	{
		quantity.clear();
		quantity.sendKeys(quant);
	}

	public void addCartBtn()
	{
		addToCartBtn.click();
	}

	public void clickOnMyCart()
	{
		myCartLink.click();
	}

	public void clickOnProceedCheckOut()
	{
		checkOutBtn.click();
	}
	public void clearAllFromCart()
	{
		dltFromCart.click();

	}



}
