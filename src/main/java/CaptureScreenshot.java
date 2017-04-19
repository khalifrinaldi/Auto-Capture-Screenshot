import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaptureScreenshot {
    WebDriver driver;

    @Test
    public void testfailed() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.id("email")).sendKeys("testing failed");
    }
    @AfterMethod
    public void captureScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("/Users/YourUser/CaptureScreenshot/ErrorScreenshots/scr.png"));
            }
        }

    }