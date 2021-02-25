package com.applicationmodules;

import com.applicationor.HomePageOR;
import com.applicationor.LoginOR;
import com.genericmethods.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends WebUtils {
    @Step("Verify that user is navigated to Authentication page")
    public void verifyAuthenticationHeader(WebDriver driver){
        LoginOR loginOR= PageFactory.initElements(driver,LoginOR.class);
        boolean status=elementExist(loginOR.authenticationHeader);
        takeScreenshot(driver);
        Assert.assertEquals(true,status,"Authentication header is not available on login page");
        takeScreenshot(driver);
    }
}
