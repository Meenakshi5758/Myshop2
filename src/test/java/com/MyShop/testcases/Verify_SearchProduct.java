package com.MyShop.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyShop.Pageobjects.ConformationPage;
import com.MyShop.Pageobjects.Coustmer_LoginPage;
import com.MyShop.Pageobjects.HomePage;
import com.MyShop.Pageobjects.Login_HomePage;
import com.MyShop.Pageobjects.PaymentMethod;
import com.MyShop.Pageobjects.ProductPage;
import com.MyShop.Pageobjects.Serach_ResultPage;
import com.MyShop.Pageobjects.Shipping_Address;

public class Verify_SearchProduct extends Baseclass {
	
	@Test(priority = 4, enabled = true)
	public void verifySearchProduct() throws IOException, InterruptedException {
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();
		Thread.sleep(5000);

		Coustmer_LoginPage pg2 = new Coustmer_LoginPage(driver);
		pg2.enterEmail(email);
		pg2.enterPwd(pwd);
		pg2.clickOnSignIn();
		logger.info("***Sign In Successfully***");
		Thread.sleep(5000);

		Login_HomePage pg3 = new Login_HomePage(driver);
		pg3.enterinSearchBox("Top");
		logger.info("Entered Text in search Box");
		pg3.enterSearchBtn();
		logger.info("Clicked on Search Button");
		Thread.sleep(5000);

		Serach_ResultPage pg4 = new Serach_ResultPage(driver);
		String searchProductName = pg4.getTextOfSearchResult();
		if (searchProductName.equals("Search results for: 'Top'")) {
			logger.info("***Search text match with expected text*** ");
			Assert.assertTrue(true);
		} else {
			logger.info("***Search text not match with expected text*** ");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}

		String productName = pg4.getTextOfProduct();
		if (productName.contains("Top")) {
			logger.info("Search Product Name Matched");
			Assert.assertTrue(true);

		} else {
			logger.info("Search Product Name Not Matched");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 5)
	public void verifyPayment() throws IOException, InterruptedException {
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();
		logger.info("Enter in to user login page");
		Thread.sleep(5000);

		Coustmer_LoginPage login = new Coustmer_LoginPage(driver);
		login.enterEmail(email);
		login.enterPwd(pwd);
		login.clickOnSignIn();
		Thread.sleep(3000);
		
		Login_HomePage pg1 = new Login_HomePage(driver);
		pg1.enterinSearchBox("Top");
		pg1.enterSearchBtn();
		Thread.sleep(3000);

		Serach_ResultPage pg3 = new Serach_ResultPage(driver);
		pg3.clickOnProduct();
		Thread.sleep(3000);

		ProductPage pg4 = new ProductPage(driver);
		pg4.clickOnSize();
		pg4.selectColor();
		pg4.setQuantity("2");
		pg4.addCartBtn();
		Thread.sleep(5000);
		pg4.clickOnMyCart();
		pg4.clickOnProceedCheckOut();
		Thread.sleep(20000);

		Shipping_Address pg5 = new Shipping_Address(driver);

		pg5.enterAddress1(address1);
		pg5.enterAddress2(address2);
		pg5.enterAddress3(address3);
		pg5.enterCity(city);
		pg5.enterZipCode(zipCode);;
		pg5.enterPhnO(phoneNum);
		pg5.selectCountry();
		pg5.selectState();
		pg5.clickOnShippingMthod();
		pg5.clickOnNextBtn();
		Thread.sleep(3000);

		PaymentMethod pg6 = new PaymentMethod(driver);
		pg6.clickOnPlaceOrder();
		Thread.sleep(5000);

		ConformationPage pg7 = new ConformationPage(driver);
		String msg = pg7.getSuccessTitle();
		if (msg.equals("Thank you for your purchase!")) {
			logger.info("Success msg fetch successfully");
			Assert.assertTrue(true);
		} else {
			logger.info("Unable to fetch success msg");
			captureScreenShot(driver, "verifyPayment");
		}
		pg7.clickOnContinueShipping();

	
}
}
