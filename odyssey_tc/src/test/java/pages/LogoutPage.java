package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[5]/section/header/div/div/div[2]/div[2]/div/a[1]")
    WebElement accountButton;

    @FindBy(xpath = "//*[@id='account-popover']/div/div/a[4]")
    WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        accountButton.click();
        logoutButton.click();
    }
}
