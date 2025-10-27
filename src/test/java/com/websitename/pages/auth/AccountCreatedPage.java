package com.websitename.pages.auth;

import com.websitename.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    private static final String ACCOUNT_CREATED_PAGE_URL = "https://automationexercise.com/account_created";

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedHeader;

    @FindBy(xpath = "//p[contains(text(),'Congratulations!')]")
    private WebElement textSuccessfulRegistration;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueBtn;

    protected AccountCreatedPage(WebDriver driver) {
        super(driver);
    }
}
