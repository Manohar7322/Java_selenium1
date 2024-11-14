package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ConfigReader;
import utils.Extent_report;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Actions_POM;
import pages.LoginPage;
import pages.LogoutPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OdysseyTests {
    WebDriver driver;
    ExtentReports extent;

    @BeforeSuite
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        Extent_report.setupExtentReport();
        extent = Extent_report.getExtent();
    }

    @Test
    public void testCreateAccount() {
        ExtentTest test = extent.createTest("Create Account Test");  // Create test for reporting
        driver.get(ConfigReader.getProperty("url"));

        Actions_POM createAccountPage = new Actions_POM(driver);
        createAccountPage.createAccount();

        test.pass("Account creation successful.");
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public void testLogout() {
        ExtentTest test = extent.createTest("Logout Test");

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        test.pass("Logout successful.");
    }

    @Test(dependsOnMethods = "testLogout")
    public void testLogin() {
        ExtentTest test = extent.createTest("Login Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        test.pass("Login successful.");
    }

    @AfterSuite
    public void tearDown() {
        Extent_report.tearDown();


    }
}
