package com.ecommerce.testCases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened...");
		
		LoginPage lp=new LoginPage(driver);//to access login page class in TC_LoginTest_001 class we hv to create an object of login page
	    
		//lp.setSearchBox(searchstore);
		//Logger.info("Searched");//logger msg
		
		/*lp.setUserName(username);
	    Logger.info("User provided");//logger msg
	    
	    lp.setPassword(password);
	    Logger.info("Password provided");//logger msg */
	    
	    lp.clickLogin();
	    logger.info("Login is Clicked");//logger msg
	    
	    Thread.sleep(5000);
	    
	    if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
	    {
	      Assert.assertTrue(true);	
	      lp.clickLogout();
	      logger.info("Login Passed");//logger msg
	    }
	    else
	    {
	    	captureScreen(driver,"loginTest");
	    	Assert.assertTrue(false);
	    	logger.info("Login Failed");//logger msg
	    }
	}
	
	

}
