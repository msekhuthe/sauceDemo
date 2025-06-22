package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(id = "login-button")
    WebElement loginButton_id;

    //Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Method to enter username
    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(username_id));
        username_id.sendKeys(username);
    }
    // Method to enter password
    public void enterPassword(String password) {

        password_id.sendKeys(password);
    }
    // Method to click the login button
    public void clickLoginButton() {
        loginButton_id.click();
    }
}
