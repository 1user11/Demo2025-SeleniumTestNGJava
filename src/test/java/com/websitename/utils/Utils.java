package com.websitename.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;

public class Utils {

    public static void clearAndType(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public static String text(WebElement el) {
        return el.getText();
    }

    public static void hover(WebDriver d, WebElement el) {
        new Actions(d).moveToElement(el).perform();
    }

    public static void attachScreenshot(WebDriver d, String name) {
        if (d == null) return;
        byte[] bytes = ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(bytes));
    }
}
