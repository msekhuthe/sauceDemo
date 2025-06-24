package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CompletePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement completeText;
    @FindBy(id = "back-to-products")
    WebElement backToProductsButton;

    // Constructor to initialize the WebDriver
    public CompletePage(WebDriver driver){
        this.driver = driver;

    }
    public void verifyCompletePage(String actualText){
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(visibilityOf(completeText));
       actualText = completeText.getText();
        Assert.assertEquals(actualText, "Checkout: Complete!");

    }

    public void clickBackHomeButton(){
        backToProductsButton.click();
    }

}
