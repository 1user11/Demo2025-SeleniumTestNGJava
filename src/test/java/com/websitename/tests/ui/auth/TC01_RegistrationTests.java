package com.websitename.tests.ui.auth;

import com.websitename.base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Epic("AutomationExercise")
@Feature("Authentication")
@Owner("Oksana")
@Link(name = "Test Cases", url = "https://automationexercise.com/test_cases")
public class TC01_RegistrationTests extends BaseTest {

@Story("TC02: Registration with valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Test(groups = {"ui","signup","smoke"})
    public void userRegistrationWithValidCredentionals() {

    }

}
