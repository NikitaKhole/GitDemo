package com.ecommerce.testCases;

/*import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/

/*public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	//public String searchstore=readconfig.getPassword();;
	//public String username=readconfig.getUseremail();
	//public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger Logger;
	
	@BeforeClass
	@Parameters("browser")
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		//C:\Users\Ketan Chaudhari\eclipse-workspace\e-Commerce\Drivers\chromedriver.exe in above we passed parameter user.dir insteade of passing this complete path with the help of setProperty method
		
		driver=new ChromeDriver();
		
		Logger=Logger.getLogger("eCommerce");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	
	/*@AfterClass
	public void tearDown()
	{
		driver.quit();
	}*/
	
	/*public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}*/

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	//public String username=readconfig.getUseremail();
	//public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("eCommerce"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		
		
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.close();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	
	
}

