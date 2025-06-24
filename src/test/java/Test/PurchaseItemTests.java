package Test;

import Utils.ReadFromExcel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static Utils.ReadFromExcel.password;
import static Utils.ReadFromExcel.username;

@Test
public class PurchaseItemTests extends Base{


    public void enterUsernameTest(){
        loginPage.enterUsername(ReadFromExcel.username);
    }

    @Test(dependsOnMethods = "enterUsernameTest")
    public void enterPasswordTest(){
        loginPage.enterPassword(ReadFromExcel.password);
    }

    @Test(dependsOnMethods = "enterPasswordTest")
    public void clickLoginButtonTest(){
        takeScreenshots.takeSnapShot(driver, "LoginPageScreenshot");
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButtonTest")
    public void verifyLandingPageTest(){
        takeScreenshots.takeSnapShot(driver, "LandingPageScreenshot");
        landingPage.verifyLandingPage("Products");
    }

    @Test(dependsOnMethods = "verifyLandingPageTest")
    public void clickAddToCartButtonTest(){
        landingPage.clickAddToCartButton();
        takeScreenshots.takeSnapShot(driver, "AddToCartButtonScreenshot");

    }

    @Test(dependsOnMethods = "clickAddToCartButtonTest")
    public void clickShoppingCartLinkTest(){
        landingPage.clickShoppingCartLink();
        takeScreenshots.takeSnapShot(driver, "ShoppingCartLinkScreenshot");
    }
    @Test(dependsOnMethods = "clickShoppingCartLinkTest")
    public void verifyYourCartPageTest(){
        yourCartPage.verifyYourCartPage("Your Cart");
        takeScreenshots.takeSnapShot(driver, "YourCartPageScreenshot");
    }
    @Test(dependsOnMethods = "verifyYourCartPageTest")
    public void clickCheckOutButtonTest(){
        yourCartPage.clickCheckOutButton();
    }

    @Test(dependsOnMethods = "clickCheckOutButtonTest")
    public void verifyCheckoutTest(){
        checkoutPage.verifyCheckoutPage("Checkout: Your Information");
        takeScreenshots.takeSnapShot(driver, "CheckoutPageScreenshot");
    }
    @Test(dependsOnMethods = "verifyCheckoutTest")
    public void enterFirstNameTest(){
        checkoutPage.enterFirstName(ReadFromExcel.firstName);
    }
    @Test(dependsOnMethods = "enterFirstNameTest")
    public void enterLastNameTest(){
        checkoutPage.enterLastName(ReadFromExcel.lastName);

    }
    @Test(dependsOnMethods = "enterLastNameTest")
    public void enterPostalCodeTest(){
        checkoutPage.enterPostalCode(ReadFromExcel.postalCode);
        takeScreenshots.takeSnapShot(driver, "CheckoutInfoPageScreenshot");
    }
    @Test(dependsOnMethods = "enterPostalCodeTest")
    public void clickContinueButtonTest(){
        checkoutPage.clickContinueButton();
    }
    @Test(dependsOnMethods = "clickContinueButtonTest")
    public void verifyOverviewPageTest(){
        overviewPage.verifyOverviewPage("Checkout: Overview");
        takeScreenshots.takeSnapShot(driver, "OverviewPageScreenshot");
    }
    @Test(dependsOnMethods = "verifyOverviewPageTest")
    public void clickFinishButtonTest(){
        overviewPage.clickFinishButton();
    }
    @Test(dependsOnMethods = "clickFinishButtonTest")
    public void verifyCompletePageTest(){
        completePage.verifyCompletePage("Checkout: Complete!");
        takeScreenshots.takeSnapShot(driver, "CompletePageScreenshot");
    }
    @Test(dependsOnMethods = "verifyCompletePageTest")
    public void clickBackHomeButtonTest(){
        completePage.clickBackHomeButton();
    }

    @AfterTest
    public void closeBrowserTest(){
        driver.quit();
    }

}
