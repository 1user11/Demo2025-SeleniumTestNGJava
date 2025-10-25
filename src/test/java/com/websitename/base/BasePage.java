package com.websitename.base;

import com.websitename.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, com.websitename.listeners.TestListener.class})
public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        if (driver == null) throw new IllegalStateException("Driver is null");
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Config.pageFactoryTimeoutSec()), this);
    }

    // ---- page-scoped waits ----
    protected WebElement waitVisible(WebElement el) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.waitVisibleSec()))
                .until(ExpectedConditions.visibilityOf(el));
    }
    protected WebElement waitClickable(WebElement el) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.waitClickableSec()))
                .until(ExpectedConditions.elementToBeClickable(el));
    }
    protected boolean waitInvisible(WebElement el) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.waitInvisibleSec()))
                .until(ExpectedConditions.invisibilityOf(el));
    }
    protected boolean waitUrlContains(String part) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.waitDefaultSec()))
                .until(ExpectedConditions.urlContains(part));
    }

    public String getTitle()      { return driver.getTitle(); }
    public String getCurrentUrl() { return driver.getCurrentUrl(); }
}
