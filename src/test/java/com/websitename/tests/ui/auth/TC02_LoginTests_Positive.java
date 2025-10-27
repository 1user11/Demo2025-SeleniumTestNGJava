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

public class TC02_LoginTests_Positive extends BaseTest {

    @Story("TC02: Login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"ui","auth","smoke"})
    public void loginWithValidCredentials() {
        UserData user = new UserData();
        new HomePage(driver)
                .open()
                .goToSignupLogin();
        new SignupLoginPage(driver)
                .login(user.getValidEmail(), user.getValidPassword());

        Assert.assertTrue(new HomePage(driver).isLogoutVisible(), "Logout button should be visible after successful login.");
    }
}
