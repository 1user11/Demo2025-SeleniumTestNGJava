package com.websitename.pages.auth;

import com.websitename.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    private static final String ACCOUNT_CREATED_PAGE_URL = "https://automationexercise.com/delete_account";

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement accountDeletedHeader;

    @FindBy(xpath = "//p[contains(text(),'Your account has been permanently deleted!')]")
    private WebElement textSuccessfulAccountDeletion;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueBtn;

    protected DeleteAccountPage(WebDriver driver) {
        super(driver);
    }
}
