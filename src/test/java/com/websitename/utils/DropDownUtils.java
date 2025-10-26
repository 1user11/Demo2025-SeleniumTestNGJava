package com.websitename.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {

    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static String getSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public static boolean isMultiple(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    public static boolean isOptionSelected(WebElement element, String text) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText().equals(text);
    }
}

