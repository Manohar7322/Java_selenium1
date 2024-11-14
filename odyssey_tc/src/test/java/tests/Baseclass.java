package tests;

import utils.Extent_report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    protected WebDriver driver;
    protected Extent_report extentReport;

    @BeforeSuite
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        Extent_report.setupExtentReport();
        extentReport = new Extent_report(driver);
    }
    @AfterSuite
    public void tearDown() {
        Extent_report.tearDown();
        driver.quit();
    }
}
