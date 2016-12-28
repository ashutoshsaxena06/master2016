package com.util.Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class FetchDataExcel_OnlineWeekend {
	WebDriver driver;
	
	@Test(dataProvider = "Authentication")

	public void Registration_data(String sUserName, String sPassword) throws Exception {

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("log")).sendKeys(sUserName);

		System.out.println(sUserName);

		driver.findElement(By.id("pwd")).sendKeys(sPassword);

		System.out.println(sPassword);

		driver.findElement(By.id("login")).click();

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
 
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

	}
  @BeforeMethod
  public void beforeMethod() throws Exception {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");

	}

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ImportDataFromExcel.getTableArray(
				"C:\\Ashutosh\\Workspace\\Work\\CodeBase\\master2016\\DataResources\\OnLineMacro-Manual-20161009.xlsx",
				"Sheet1");

		return (testObjArray);

	}
}
