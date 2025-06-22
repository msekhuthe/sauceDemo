package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class StartChrome {

    WebDriver driver;

    @Test
    public void verifyLoginSuccess() throws InterruptedException {

        driver = new EdgeDriver();
//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        String productText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        //String productText = driver.findElement(By.xpath(contains(.,'Products'))).getText();
        Assert.assertEquals(productText, "Products");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String cartText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartText, "Your Cart");
        driver.findElement(By.id("checkout")).click();
        String yourInfo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(yourInfo, "Checkout: Your Information");
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("Mo");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        driver.findElement(By.id("postal-code")).sendKeys("2191");
        driver.findElement(By.id("continue")).click();
        String overview = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
        driver.findElement(By.id("finish")).click();
        String complete = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(complete, "Checkout: Complete!");
        driver.findElement(By.id("back-to-products")).click();


    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
