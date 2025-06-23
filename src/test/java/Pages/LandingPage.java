package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LandingPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement productText;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;





    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLandingPage(String actualText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(productText));
        actualText = productText.getText();
        Assert.assertEquals(actualText, "Products");

    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public void clickShoppingCartLink(){
        shoppingCartLink.click();
    }

}
