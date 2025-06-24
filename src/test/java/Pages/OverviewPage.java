package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement overviewText;
    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    WebElement itemTotalAmount;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    WebElement taxAmount;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    WebElement amountTotal;


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

    public double getTheAmount(WebElement element){
        String itemCostText = element.getText();
        String[] splitTax = itemCostText.split("\\$");

        return Double.parseDouble(splitTax[1]);
    }

    public void validateAmountTotal(){
        double sum = getTheAmount(itemTotalAmount) + getTheAmount(taxAmount);
        double totalAmount = Math.floor(sum * 100)/100;
        double actualTotalAmount = getTheAmount(amountTotal);
        Assert.assertEquals(totalAmount, actualTotalAmount);
       System.out.println("Expected Total Amount: " + totalAmount + " = " + "actual Total Amount: " + actualTotalAmount);
    }


}
