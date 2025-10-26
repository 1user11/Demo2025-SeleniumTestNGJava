package com.websitename.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


    public class JSUtils {

        // Click using JS
        public static void jsClick(WebDriver driver, WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        // Scroll element into view (true = align to top)
        public static void scrollIntoView(WebDriver driver, WebElement element, boolean alignToTop) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(arguments[1]);", element, alignToTop);
        }

        // Scroll down by pixels
        public static void scrollDown(WebDriver driver, int pixels) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ");");
        }

        // Scroll up by pixels
        public static void scrollUp(WebDriver driver, int pixels) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-" + pixels + ");");
        }

        // Scroll to bottom
        public static void scrollToBottom(WebDriver driver) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }

        // Scroll to top
        public static void scrollToTop(WebDriver driver) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        }

        // Highlight element
        public static void highlightElement(WebDriver driver, WebElement element) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='yellow';", element);
        }

        // Remove highlight
        public static void removeHighlight(WebDriver driver, WebElement element) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.border=''; arguments[0].style.backgroundColor='';", element);
        }

        // Set value directly (when sendKey doesn't work)
        public static void setValue(WebDriver driver, WebElement element, String value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
        }

        // Get element text (even if hidden)
        public static String getText(WebDriver driver, WebElement element) {
            return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
        }

        // Move slider to percentage
        public static void moveSlider(WebDriver driver, WebElement slider, double percentage) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
                    slider, percentage);
        }

        // Smooth scroll animation
        public static void smoothScroll(WebDriver driver, int pixels) {
            ((JavascriptExecutor) driver).executeScript(
                    "window.scrollBy({ top: " + pixels + ", behavior: 'smooth' });");
        }
}
