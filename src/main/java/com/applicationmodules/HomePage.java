package com.applicationmodules;

import com.applicationor.HomePageOR;
import com.genericmethods.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebUtils {

    @Step("Navigate to Signin page")
    public void navigateToSignInPage(WebDriver driver){
        HomePageOR homePageOR= PageFactory.initElements(driver,HomePageOR.class);
        clickElement("Sign In","Home page",homePageOR.signIn);
        takeScreenshot(driver);
    }




}
