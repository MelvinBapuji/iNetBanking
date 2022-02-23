package com.iNetBanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class TC_LoginDDT_02 extends BaseClass

{	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws Exception
	{
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(user);
	logger.info("Username entered");
	lp.setPassword(pwd);
	logger.info("Password entered");
	lp.clickSubmit();
	Thread.sleep(3000);
	if(isAlertPresent() == true)
	{
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login Test passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
	}
	}


	public boolean isAlertPresent()// user defined function to check if alert is present
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/iNetBanking/testdata/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata [][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j =0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
