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

    @AfterTest
    public void closeBrowserTest(){
        driver.quit();
    }

}
