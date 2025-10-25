package com.websitename.pages.home;

import com.websitename.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

     private static final String BASE_URL =
            System.getProperty("baseUrl", "https://automationexercise.com/");

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    private WebElement productsLink;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[normalize-space()='Test Cases']")
    private WebElement testCasesLink;

    @FindBy(xpath = "//a[normalize-space()='API Testing']")
    private WebElement apiTestingLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open home page: {BASE_URL}")
    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Verify that 'Logout' link is visible")
    public boolean isLogoutVisible() {
        try {
            return waitVisible(logoutLink).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Navigation helpers
    @Step("Go to 'Signup/Login")
    public void goToSignupLogin() { signupLoginLink.click(); }

    @Step("Go to 'Products' page")
    public void goToProducts()    { productsLink.click(); }

    @Step("Go to 'Contact Us' page")
    public void goToContactUs()   { contactUsLink.click(); }

    @Step("Go to 'Test Cases' page")
    public void goToTestCases()   { testCasesLink.click(); }

    @Step("Go to 'API Testing' page")
    public void goToAPITesting()   { apiTestingLink.click(); }


    // Optional getter if needed elsewhere
    @Step("Get Base URL")
    public static String getBaseUrl() {
        return BASE_URL;
    }
}
