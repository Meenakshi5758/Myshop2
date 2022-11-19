package com.MyShop.utilites;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path = "C:\\Users\\Meenakshi\\eclipse-workspace\\MyShop\\Configuration\\ConfigProperties";

	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getUrl()
	{
		String url=properties.getProperty("baseurl");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("no url in config property file");
	}
	public String getBrowser()
	{
		String browser=properties.getProperty("browser");
		if(browser!=null)
			return browser;
		else
			throw new RuntimeException("no browser found in config properties");
	}
	public String getFirstName()
	{
		String firstname=properties.getProperty("FirstName");
		if(firstname!=null)
			return firstname;
		else 
			throw new RuntimeException("no FirstName found in config properties");
	}
	public String getLatName()
	{
		String lastname=properties.getProperty("LastName");
		if(lastname!=null)
			return lastname;
		else 
			throw new RuntimeException("no LastName found in config properties");
	}
	public String getEmail()
	{
		String email=properties.getProperty("Email");
		if(email!=null)
			return email;
		else 
			throw new RuntimeException("no Email found in config properties");
	}
	public String getPassword()
	{
		String pwd=properties.getProperty("Password");
		if(pwd!=null)
			return pwd;
		else 
			throw new RuntimeException("no Password found in config properties");
	}
	public String getConfirmPassword()
	{
		String confirmpwd=properties.getProperty("ConfirmPassword");
		if(confirmpwd!=null)
			return confirmpwd;
		else 
			throw new RuntimeException("no ConfirmPassword found in config properties");
	}

	public String getAddress1()
	{
		String address1=properties.getProperty("Address1");
		if(address1!=null)
			return address1;
		else 
			throw new RuntimeException("no Address1 found in config properties");
	}
	public String getAddress2()
	{
		String address2=properties.getProperty("Address2");
		if(address2!=null)
			return address2;
		else 
			throw new RuntimeException("no Address2 found in config properties");
	}
	public String getAddress3()
	{
		String address3=properties.getProperty("Address3");
		if(address3!=null)
			return address3;
		else 
			throw new RuntimeException("no Address3 found in config properties");
	}
	public String getCity()
	{
		String city=properties.getProperty("City");
		if(city!=null)
			return city;
		else 
			throw new RuntimeException("no city found in config properties");
	}
	public String getZip()
	{
		String zip=properties.getProperty("Zip");
		if(zip!=null)
			return zip;
		else 
			throw new RuntimeException("no zip found in config properties");
	}
	public String getPhNo()
	{
		String phno=properties.getProperty("phno");
		if(phno!=null)
			return phno;
		else 
			throw new RuntimeException("no Phone NUmber found in config properties");
	}
}
