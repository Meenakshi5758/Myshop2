package com.MyShop.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyShop.Pageobjects.Coustmer_LoginPage;
import com.MyShop.Pageobjects.HomePage;
import com.MyShop.Pageobjects.Login_HomePage;
import com.MyShop.utilites.ReadExcleFile;

public class Login_DDT_003 extends Baseclass {
	@Test(dataProvider = "LoginData")
	public void verifylogin(String Email,String pasword) throws IOException, InterruptedException
	{
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();

		logger.info("Sign In page Opened");

		Coustmer_LoginPage pg1 = new Coustmer_LoginPage(driver);
		pg1.enterEmail(Email);
		pg1.enterPwd(pasword);
		pg1.clickOnSignIn();
		Thread.sleep(5000);
	
		String name = pg.getSignInName();
		System.out.println("sign in name is: "+name);
		if (name.equals("Welcome, Meenakshi!")) {
			logger.info("***Name Match With Expected Result***");
			Assert.assertTrue(true);
		} else {
			logger.info("***Name On Sign In Page Not Match With Expected Result***");
			captureScreenShot(driver, "verifyLoginPage");
			Assert.assertTrue(false);
		}

		Login_HomePage logInpge=new Login_HomePage(driver);
		logInpge.clickOnDropDown();
		logInpge.clickOnSignOut();


	}

	@DataProvider(name="LoginData")
	public String[][] LoginDataProvider()
	{
		String path=System.getProperty("user.dir")+"\\TestData\\Book1.xlsx";
		int ttlrow=ReadExcleFile.getRowCount(path, "Sheet1");
		int ttlcol=ReadExcleFile.getColCount(path, "Sheet1");

		String data[][]=new String [ttlrow-1][ttlcol];
		for(int i=1;i<ttlrow;i++)
		{
			for(int j=0;j<ttlcol;j++)
			{
				data[i-1][j]=ReadExcleFile.getCellValue(path, "Sheet1", i, j);
			}
		}
		return data;
	}

}
