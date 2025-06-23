package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class PurchaseItemTests extends Base{


    public void enterUsernameTest(){
        loginPage.enterUsername("standard_user");
    }

    @Test(dependsOnMethods = "enterUsernameTest")
    public void enterPasswordTest(){
        loginPage.enterPassword("secret_sauce");
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

    @AfterTest
    public void closeBrowserTest(){
        driver.quit();
    }

}
