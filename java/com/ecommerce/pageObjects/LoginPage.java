package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//localdriver
	public WebDriver ldriver;
	
	//parametrized constructor.remotedriver
	public LoginPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);//this  stands for current page
	}
	
	
	//finding webElement
	
	//@FindBy(xpath="//input[@placeholder='Search store']")
	//@CacheLookup
	//WebElement txtSearch;
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;

//Performing action on webElement

	 //public void setSearchBox(String searchstore)
	 //{
	//	 txtSearch.sendKeys(searchstore);
	 //}
	 
 public void setUserName(String uname)

  {
	txtEmail.sendKeys(uname);
  }

 public void setPassword(String psw)

  {
	txtPassword.sendKeys(psw);
  }
  
 public void clickLogin()
 
  {
	btnLogin.click();
  }

public void clickLogout()

  {
	lnkLogout.click();
  }
}