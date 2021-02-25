package com.genericmethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebUtils {
    public static String browser;
    public static String url;
    private WebDriver driver = null;
    private  static File propertiesFile;
    private  Properties properties;
    private FileInputStream fis;

    /*
    @method name:launchBrowser
    @description:this method will launch browser types as chrome,firefox,and edge
    @input:browser type and url
    @return:web driver refference
     */
    @Step("Launch Browser")
    public WebDriver launchBrowser() {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;

    }

    /*
@method name:closeBrowser
@description:this method will close browser types as chrome,firefox,and edge
@input:NA
@return:NA
 */
    @Step("Closing browser")
    public void closeBrowser(WebDriver driver) {
        driver.close();
    }

      /*
@method name:KillSession
@description:this method will kill browser types as chrome,firefox,and edge
@input:NA
@return:NA
 */
@Step("Killing browser session")
    public void KillSession(WebDriver driver) {
        driver.quit();
    }
    /*
@method name:clickLinkUsingLinkText
@description:this method will click on the hyperlink using link text
@input:Link name
@return:NA
*/
    @Step("Click the link {1}")
    public void clickLinkUsingLinkText(WebDriver driver,String linktext){
        driver.findElement(By.linkText(linktext)).click();
    }
    @Step("Click the element {0} on the page {1}")
    public void clickElement(String elementname,String pagename,WebElement element){
        element.click();
    }

@Step("Select the dropdown {0} with the value {3} on the page {1}")
    public void selectDropDownByText(String elementname,String pagename,WebElement element,String optionText){
        Select selectDay=new Select(element);
        selectDay.selectByVisibleText(optionText);

    }
    @Step("Select the dropdown {0} with the value {3} on the page {1}")
    public void selectDropDownByIndex(String elementname,String pagename,WebElement element,int indexPosition){
        Select selectDay=new Select(element);
        selectDay.selectByIndex(9);
    }
    @Step("Select the dropdown {0} with the value {3} on the page {1}")
    public void selectDropDownByValue(String elementname,String pagename,WebElement element,String value){
        Select selectDay=new Select(element);
        selectDay.selectByValue(value);

    }



    public String getConfigDetails(String key) throws IOException {
        if(propertiesFile==null){
            propertiesFile=new File("src/main/resources/application-config/configuration.properties");
            fis=new FileInputStream(propertiesFile);
            properties=new Properties();
        }
        properties.load(fis);
        return properties.getProperty(key);
    }


    public boolean elementExist(WebElement element){
        boolean status=false;
        try{
            if(element.isDisplayed()){
                status=true;
            }
        }catch (Exception e){

            status=false;
            System.out.println(e.getStackTrace());
        }
        return status;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
