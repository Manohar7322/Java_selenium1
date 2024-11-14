package pages;

import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class Actions_POM {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[5]/section/header/div/div/div[2]/div[2]/div/a[1]")
    WebElement createAccountButton;

    @FindBy(xpath = "//button[normalize-space()='Create your account']") // Added this to find the "Create your account" button
    WebElement createAccountPageButton;

    @FindBy(id = "register-customer[first_name]")
    WebElement firstNameInput;

    @FindBy(id = "register-customer[last_name]")
    WebElement lastNameInput;

    @FindBy(id = "register-customer[email]")
    WebElement emailInput;

    @FindBy(id = "register-customer[password]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='create_customer']/button")
    WebElement submitButton;

    public Actions_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);

        createAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(createAccountPageButton));
        createAccountPageButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(ConfigReader.getProperty("firstName"));
        lastNameInput.sendKeys(ConfigReader.getProperty("lastName"));
        emailInput.sendKeys(ConfigReader.getProperty("email"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));
        submitButton.click();
    }
}
