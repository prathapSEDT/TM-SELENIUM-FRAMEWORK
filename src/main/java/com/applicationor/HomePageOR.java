package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOR {
    @FindBy(xpath="//a[normalize-space(text())='Sign in']")
    public WebElement signIn;
    @FindBy(xpath="//a[normalize-space(text())='Contact us']")
    public WebElement contactUs;
    @FindBy(css="#search_query_top")
    public WebElement searchBox;
    @FindBy(css="button[name='submit_search']")
    public WebElement searchButton;

}
