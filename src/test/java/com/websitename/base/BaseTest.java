package com.websitename.base;

import com.websitename.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver() {
        return driver;
    }

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (!result.isSuccess() && driver != null) {
                Utils.attachScreenshot(driver, "Failure: " + result.getName());
                try {
                    io.qameta.allure.Allure.addAttachment(
                            "Page Source", "text/html", driver.getPageSource(), ".html"
                    );
                } catch (Exception ignored) {}
            }
        } finally {
            if (driver != null) driver.quit();
        }
    }
}
