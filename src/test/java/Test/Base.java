package Test;

import Pages.*;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Base {

    // Initialize the browser and pages
    BrowserFactory browserFactory = new BrowserFactory();

    // Start the browser with the specified URL
    final WebDriver driver = browserFactory.startBrowser("Edge", "https://www.saucedemo.com/");

    // Initialize the page objects
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    YourCartPage yourCartPage = PageFactory.initElements(driver, YourCartPage.class );
    CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
    CompletePage completePage = PageFactory.initElements(driver, CompletePage.class);

    ReadFromExcel readFromExcel;

    {
        try {
            readFromExcel = new ReadFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Initialize the TakeScreenshots utility
    TakeScreenshots takeScreenshots = new TakeScreenshots();


}
