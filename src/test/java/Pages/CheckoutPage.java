package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement checkoutText;
    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy(id = "postal-code")
    WebElement postalCodeInput;
    @FindBy(id = "continue")
    WebElement continueButton;



    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyCheckoutPage(String actualText){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(checkoutText));
        actualText = checkoutText.getText();
        Assert.assertEquals(actualText,"Checkout: Your Information");
    }

    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
