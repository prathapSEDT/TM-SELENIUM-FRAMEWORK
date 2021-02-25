package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOR {
    @FindBy(xpath="//h1[text()='Authentication']")
    public WebElement authenticationHeader;
}
