package com.websitename.pages.auth;

import com.websitename.base.BasePage;
import com.websitename.utils.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignupLoginPage extends BasePage {

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupBtn;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement loginErrorMsg;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

//    @Step("Sign Up with email: {email}")
//    public SignupLoginPage signUp(String name, String email) {
//        signupName.clear();
//        signupName.sendKeys(name);
//        signupEmail.clear();
//        signupEmail.sendKeys(email);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
//        signupBtn.click();
//        return this;
//    }

    @Step("Sign Up with email: {email}")
    public SignupLoginPage signUp(String name, String email) {
        Helpers.clearAndType(signupName, name);
        Helpers.clearAndType(signupEmail, email);
        signupBtn.click();
        return this;
    }

    @Step("Login with email: {email}")
    public SignupLoginPage login(String email, String password) {
        Helpers.clearAndType(loginEmail, email);
        Helpers.clearAndType(loginPassword, password);
//        waitClickable(loginBtn);
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
