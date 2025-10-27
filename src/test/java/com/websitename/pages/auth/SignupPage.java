package com.websitename.pages.auth;

import com.websitename.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

    private static final String SIGNUP_PAGE_URL = "https://example.com/signup";

    @FindBy(xpath = "//div[@id='uniform-id_gender1']")
    private WebElement titleMr;

    @FindBy(xpath = "//div[@id='uniform-id_gender2']")
    private WebElement titleMrs;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement years;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement company;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountBtn;

    String expectedResult = "Congratulations!";

    protected SignupPage(WebDriver driver) {
        super(driver);
    }




}
