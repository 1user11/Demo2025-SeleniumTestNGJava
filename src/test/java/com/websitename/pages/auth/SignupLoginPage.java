package com.websitename.pages.auth;

import com.websitename.base.BasePage;
import com.websitename.utils.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignupLoginPage extends BasePage {

    @FindBy(xpath = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(xpath = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(xpath = "button[data-qa='signup-button']")
    private WebElement signupBtn;

    @FindBy(xpath = "input[data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "input[data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "button[data-qa='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement loginErrorMsg;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sign Up with email: {email}")
    public SignupLoginPage signUp(String name, String email) {
        Utils.clearAndType(signupName, name);
        Utils.clearAndType(signupEmail, email);
        signupBtn.click();
        return this;
    }

    @Step("Login with email: {email}")
    public SignupLoginPage login(String email, String password) {
        Utils.clearAndType(loginEmail, email);
        Utils.clearAndType(loginPassword, password);
        loginBtn.click();
        return this;
    }

    @Step("Check that login error message is displayed")
    public boolean isLoginErrorDisplayed() {
        try {
            return loginErrorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
