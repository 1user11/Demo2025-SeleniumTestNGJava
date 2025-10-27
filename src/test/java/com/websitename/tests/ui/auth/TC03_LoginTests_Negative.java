package com.websitename.tests.ui.auth;

import com.websitename.base.BaseTest;
import com.websitename.pages.auth.SignupLoginPage;
import com.websitename.pages.home.HomePage;
import com.websitename.utils.UserData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("AutomationExercise")
@Feature("Authentication")
@Owner("Oksana")
@Link(name = "Test Cases", url = "https://automationexercise.com/test_cases")
public class TC03_LoginTests_Negative extends BaseTest {

    @Story("TC03: Login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"ui","auth","smoke"})
    public void loginWithInvalidCredentials(){
        UserData user = new UserData();
        new HomePage(driver)
                .open()
                .goToSignupLogin();
        SignupLoginPage login = new SignupLoginPage(driver)
                .login(user.getInvalidEmail(), user.getInvalidPassword());

        Assert.assertTrue(login.isLoginErrorDisplayed(), "Login error message is not displayed!");
    }

    @Story("TC03_1: Login with invalid email")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"ui","auth","smoke"})
    public void loginWithInvalidEmail() throws InterruptedException {
        UserData user = new UserData();
        new HomePage(driver)
                .open()
                .goToSignupLogin();
        SignupLoginPage login = new SignupLoginPage(driver)
                .login(user.getInvalidEmail(), user.getValidPassword());

        Assert.assertTrue(login.isLoginErrorDisplayed(), "Login error message is not displayed!");
    }

    @Story("TC03_2: Login with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"ui","auth","smoke"})
    public void loginWithInvalidPassword(){
        UserData user = new UserData();
        new HomePage(driver)
                .open()
                .goToSignupLogin();
        SignupLoginPage login = new SignupLoginPage(driver)
                .login(user.getValidEmail(), user.getInvalidPassword());

        Assert.assertTrue(login.isLoginErrorDisplayed(), "Login error message is not displayed!");
    }
}
