package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YourCartPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement yourCartText;
    @FindBy(id = "checkout")
    WebElement checkOutButton;

    // Constructor to initialize the WebDriver
    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }
    public void verifyYourCartPage(String actualText){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(yourCartText));
        actualText = yourCartText.getText();
        Assert.assertEquals(actualText,"Your Cart");

    }
    public void clickCheckOutButton(){
        checkOutButton.click();
    }




}
