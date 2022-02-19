package com.ecommerce.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String psw) throws InterruptedException
	{
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		logger.info("URL is opened...");
		
		LoginPage lp=new LoginPage(driver);//to access login page class in TC_LoginTest_001 class we hv to create an object of login page
	    
		//lp.setSearchBox(searchstore);
		//Logger.info("Searched");//logger msg
		
		/*lp.setUserName(user);
	    Logger.info("User provided");//logger msg
	    
	    lp.setPassword(psw);
	    Logger.info("Password provided");//logger msg */
	    
	    lp.clickLogin();
	    logger.info("Login is Clicked");//logger msg
	    
	    Thread.sleep(3000);
	    
	    if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
	    {
	      Assert.assertTrue(true);	
	      lp.clickLogout();
	      logger.info("Login Passed");//logger msg
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    	logger.info("Login Failed");//logger msg
	    }
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException //it is data provider so its in 2dimentional
	{
		String path=System.getProperty("user.dir")+"src/test/java/com/ecommerce/testData/LoginData.xlsx";
	
		int rownum=XLUtils.getRowCount(path, "Sheet1");
	    int colcount=XLUtils.getCellCount(path,"Sheet1",1);
	    
	String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
}
