package com.iNetBanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass
{
	@Test
	public void Logintest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		else
		{
			captureScreen(driver, "Logintest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
	}
}
