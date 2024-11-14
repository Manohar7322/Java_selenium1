package com.Supertails;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SupertailsTestNG {
  WebDriver driver;
  ExtentTest test;
  SuperTails_POM POM;
  @Test(dataProvider = "dp")
  public void f(String cart) throws InterruptedException, IOException {
	  try {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,500);");
		  POM=new SuperTails_POM(driver);
		  POM.ClickMethod("grid-itemcategory", "className");
		  js.executeScript("window.scrollBy(0,400);");
//	  Thread.sleep(5000);
		  POM.ClickMethod("//*[@id=\"searchResultsWrapper\"]/ul/li[1]/a/div[2]/b/div[2]", "xpath");
		  js.executeScript("window.scrollBy(0,400);");
		  if(cart.equals("AddtoCart")) {
			  POM.ClickMethod("AddToCart-template--16703736905966__main", "id");
			  test.pass("Item Added To the Cart");
		  }else {
			  throw new Exception();

		  }
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	  Thread.sleep(2000);
		  POM.ClickMethod("//*[@id=\"modal_atc_id\"]/a[2]", "xpath");
		  POM.ClickMethod("revamp_cartremove", "id");
//	  Alt.accept();
		  POM.ClickMethod("removeItem_yes", "className");
		  js.executeScript("alert('Cart Item is Empty')");
		  Thread.sleep(2000);
		  Alert Alt=driver.switchTo().alert();
		  Alt.accept();	  
	  }catch(Exception e) {
		  POM.ClickMethod("/html/body/div[4]/div[5]/header/div/div[2]/div[2]/div[1]/a[4]", "xpath");
		  test.fail("Did't Add Cart Item");
		  File ssfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(ssfile, new File("AddToCart.jpg"));
	  test.fail("Didn't Add Any Item in the Cart"+test.addScreenCaptureFromPath("C:\\JAVA_WS\\SuperTails\\AddToCart.jpg"));
		  ReadFile.Flush();
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
//      new Object[] {"AddtoCart"},
      new Object[] {"ItemAdd"}
    };
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  Properties prob=ReadFile.Properties();
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  String url=prob.getProperty("url");
	  test=ReadFile.Test("Verify AddToCart");
	  System.out.println("url"+url);
	  driver.get(url);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  ReadFile.Flush();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
