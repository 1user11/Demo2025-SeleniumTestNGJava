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

    @FindBy(xpath = "")
    private WebElement name;

    @FindBy(xpath = "")
    private WebElement password;

    @FindBy(xpath = "")
    private WebElement days;

    @FindBy(xpath = "")
    private WebElement months;

    @FindBy(xpath = "")
    private WebElement years;

    @FindBy(xpath = "")
    private WebElement firstName;

    @FindBy(xpath = "")
    private WebElement lastName;

    @FindBy(xpath = "")
    private WebElement address;

    @FindBy(xpath = "")
    private WebElement country;

    @FindBy(xpath = "")
    private WebElement city;

    @FindBy(xpath = "")
    private WebElement zipcode;

    @FindBy(xpath = "")
    private WebElement mobileNumber;

    @FindBy(xpath = "")
    private WebElement createAccountBtn;




//
//        driver.findElement(By.xpath("//a[@href='/login']")).click();
//        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testerabcdef");
//        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testerabcdef!!@test.com");
//        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
//
//            driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
//            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty1230");
//            new Select(driver.findElement(By.xpath("//select[@id='days']"))).selectByValue("5");
//            new Select(driver.findElement(By.xpath("//select[@id='months']"))).selectByValue("5");
//            new Select(driver.findElement(By.xpath("//select[@id='years']"))).selectByValue("1990");
//            driver.findElement(By.id("first_name")).sendKeys("Tester");
//            driver.findElement(By.id("last_name")).sendKeys("Qa");
//            driver.findElement(By.id("address1")).sendKeys("Main st");
//            driver.findElement(By.id("country")).sendKeys("United States");
//            driver.findElement(By.id("state")).sendKeys("NJ");
//            driver.findElement(By.id("city")).sendKeys("Paramus");
//            driver.findElement(By.id("zipcode")).sendKeys("07005");
//            driver.findElement(By.id("mobile_number")).sendKeys("8763458734");
//            driver.findElement(By.xpath("//button[text()='Create Account']")).click();
//            String actualResult = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
//            String expectedResult = "Congratulations!";
//
//            Assert.assertTrue(actualResult.contains(expectedResult));




    protected SignupPage(WebDriver driver) {
        super(driver);
    }

}
