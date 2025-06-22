package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {

    private static final String screenshotDir = System.getProperty("user.dir") + "/Screenshots";

    @Test
    public void takeSnapShot(WebDriver driver, String ScreenshotName) {

        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotDir, ScreenshotName + ".png");

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
