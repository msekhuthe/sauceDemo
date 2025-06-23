package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement overviewText;
    @FindBy(id = "finish")
    WebElement finishButton;


    public OverviewPage(WebDriver driver) {
        this.driver = driver;

    }

    public void verifyOverviewPage(String actualText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(overviewText));
        actualText = overviewText.getText();
        Assert.assertEquals(actualText, "Checkout: Overview");

    }

    public void clickFinishButton(){
        finishButton.click();
    }


}
