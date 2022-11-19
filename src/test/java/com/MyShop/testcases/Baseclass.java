package com.MyShop.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.MyShop.utilites.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	ReadConfig readconfig=new ReadConfig();
	String url=readconfig.getUrl();
	String browser=readconfig.getBrowser();
	String firstName=readconfig.getFirstName();
	String lastname=readconfig.getLatName();
	String email=readconfig.getEmail();
	String pwd=readconfig.getPassword();
	String confpwd=readconfig.getConfirmPassword();
	String address1=readconfig.getAddress1();
	String address2=readconfig.getAddress2();
	String address3=readconfig.getAddress3();
	String city=readconfig.getCity();
	String zipCode=readconfig.getZip();
	String phoneNum=readconfig.getPhNo();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeMethod
	public void launchBrowser()
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		logger=LogManager.getLogger("Shopping");

		driver.get(url);
		logger.info("url opened");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver, String testname) throws IOException
	{
		TakesScreenshot scr=((TakesScreenshot)driver);
		File screenshot=scr.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screen Shots//"+testname+".png");
	    FileUtils.copyFile(screenshot, dest);
		

	}

	
	}


