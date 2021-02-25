package com.testcases;

import com.applicationmodules.HomePage;
import com.applicationmodules.LoginPage;
import com.genericmethods.WebUtils;
import com.testngannotation.Annotations;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_01_SigninValidation extends Annotations {
    @Test
    @Epic("Home Page Module")
    @Story("US10987")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate the signin link behaviour")
    public void signInValidation(){
        WebUtils webUtils=new WebUtils();
        WebDriver driver=webUtils.launchBrowser();

        HomePage homePage=new HomePage();
        homePage.navigateToSignInPage(driver);

        LoginPage loginPage=new LoginPage();
        loginPage.verifyAuthenticationHeader(driver);


    }
}
