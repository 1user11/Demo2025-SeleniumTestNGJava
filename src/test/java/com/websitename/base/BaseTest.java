package com.websitename.base;

import io.qameta.allure.Allure;
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
    //    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--window-size=1920,1080");
//
//
////        ChromeOptions options = new ChromeOptions();
////        String chromeOpts = System.getenv("CHROME_OPTIONS");
////        if (chromeOpts != null) {
////            options.addArguments(chromeOpts.split(";"));
////        }
//
//        driver = new ChromeDriver(options);
////        driver.get("https://askomdch.com/");
//        driver.get("https://automationexercise.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    protected WebDriver driver; // <- protected so subclasses can access

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (!result.isSuccess() && driver != null) {
                com.websitename.utils.Helpers.attachScreenshot(driver, "Failure: " + result.getName());
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
