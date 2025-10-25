package com.websitename.tests.ui.contact;

import com.websitename.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStoreName extends BaseTest {

    @Test
    public void testStoreName() {
        String websiteName = driver.findElement(By.xpath("//h1/a[@href='https://askomdch.com/']")).getText();
        Assert.assertEquals(websiteName,"AskOmDch", "Store Name doesn't match!");
    }
}
