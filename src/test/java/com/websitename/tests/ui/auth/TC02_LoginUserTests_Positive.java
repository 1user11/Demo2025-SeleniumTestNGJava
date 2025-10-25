package com.websitename.tests.ui.auth;

import com.websitename.base.BaseTest;
import com.websitename.pages.auth.SignupLoginPage;
import com.websitename.pages.home.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("AutomationExercise")
@Feature("Authentication")
@Owner("Oksana")
@Link(name = "Test Cases", url = "https://automationexercise.com/test_cases")

public class TC02_LoginUserTests_Positive extends BaseTest {

    @Story("TC02: Login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"ui","login","smoke"})
        public void login_withValidPassword() {
//            String email = System.getProperty("loginEmail");
//            String password = System.getProperty("loginPassword");
            HomePage home = new HomePage(driver).open();

            home.goToSignupLogin();
            new SignupLoginPage(driver()).login("ememdems@hotmail555.com", "8XbTY@zG@wYg2hg");

            home = new HomePage(driver());

            Assert.assertTrue(home.isLogoutVisible(), "Expected Logout link visible after login");
        }
}
