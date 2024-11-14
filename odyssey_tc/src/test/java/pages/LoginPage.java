package pages;


import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[5]/section/header/div/div/div[2]/div[2]/div/a[1]")
    WebElement accountButton;

    @FindBy(id = "login-customer[email]")
    WebElement emailInput;

    @FindBy(id = "login-customer[password]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='header_customer_login']/button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        accountButton.click();
        emailInput.sendKeys(ConfigReader.getProperty("email"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();
    }
}
