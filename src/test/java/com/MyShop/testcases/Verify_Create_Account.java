package com.MyShop.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyShop.Pageobjects.Coustmer_LoginPage;
import com.MyShop.Pageobjects.CreateAccountPage;
import com.MyShop.Pageobjects.HomePage;
import com.MyShop.Pageobjects.LogOut;
import com.MyShop.Pageobjects.Login_HomePage;
import com.MyShop.Pageobjects.My_AccountPage;

public class Verify_Create_Account extends Baseclass {

	@Test(priority = 1, enabled = true)
	public void verifyCreatAccount() throws InterruptedException, IOException {

	  HomePage pg = new HomePage(driver);
	pg.clickOnCreatAccn();

		logger.info("***Create Account Page Open***");

		CreateAccountPage pg2 = new CreateAccountPage(driver);
		pg2.enterFistname(firstName);
		pg2.enterLatname(lastname);
		pg2.clickOncheckBox();
		pg2.enterEmail(email);
		pg2.enterpwd(pwd);
		pg2.enterconfpwd(confpwd);
		pg2.clickOnCreatBtn();

		Thread.sleep(5000);

		logger.info("Account is Created");

		My_AccountPage pg3 = new My_AccountPage(driver);
		String username = pg3.getUserName();
		if (username.equals("Welcome, Meenakshi Kadole!")) {
			logger.info("***user name verify successfully***");
			Assert.assertTrue(true);
		} else {
			logger.info("***user name not matched***");
			captureScreenShot(driver, "verifyCreatAccount");
			Assert.assertTrue(false);
		}



	}

	@Test(priority = 2, enabled = true)
	public void verifyLoginPage() throws IOException, InterruptedException {
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();

		logger.info("Sign In page Opened");

		Coustmer_LoginPage pg1 = new Coustmer_LoginPage(driver);
		pg1.enterEmail(email);
		pg1.enterPwd(pwd);
		pg1.clickOnSignIn();
		Thread.sleep(10000);

		String name = pg.getSignInName();
		System.out.println("sign in name is: " + name);
		if (name.equals("Welcome, Meenakshi kadole!")) {
			logger.info("***Name Match With Expected Result***");
			Assert.assertTrue(true);
		} else {
			logger.info("***Name On Sign In Page Not Match With Expected Result***");
			captureScreenShot(driver, "verifyLoginPage");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 3, enabled = true)
	public void verifysignOut() throws IOException, InterruptedException {
		HomePage pg1 = new HomePage(driver);
		pg1.clickOnSignIn();
		Coustmer_LoginPage pg2 = new Coustmer_LoginPage(driver);
		pg2.enterEmail(email);
		pg2.enterPwd(pwd);
		pg2.clickOnSignIn();
		Thread.sleep(5000);

		Login_HomePage pg3 = new Login_HomePage(driver);
		pg3.clickOnDropDown();
		pg3.clickOnSignOut();

		LogOut pg4 = new LogOut(driver);
		String signOutName = pg4.getSignoutText();

		if (signOutName.equals("You are signed out")) {
			logger.info("Sign Out Completed");
			Assert.assertTrue(true);
		} else {
			logger.info("Sign Out-Failed");
			captureScreenShot(driver, "verifysignOut");
			logger.info("ScreenShot Captured");
			Assert.assertTrue(false);
		}
	}
	
	

}
