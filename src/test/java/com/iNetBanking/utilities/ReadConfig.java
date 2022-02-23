package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	//Constructor to load the file
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}
		catch (Exception e)
		{
			System.out.println("Excpetion is "+ e.getMessage());
		}
	}
	//function for reading the variable
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getusername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
