package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Signin extends Testbase {

    @FindBy(id="edit-name")
    public WebElement username;
    @FindBy(id="edit-pass")
    public WebElement password;
    @FindBy(id="edit-submit")
    public WebElement submit;
    @FindBy(xpath="//ul/li/a[1]")
    public WebElement logo;
    public Signin(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String UN, String PW){
        System.out.println(driver);
        username.sendKeys(UN);
        password.sendKeys(PW);
        submit.click();

    }
    public boolean validatePagelogo(){
       return logo.isSelected();
    }
    public String validateTitle(){
        return driver.getTitle();
    }
}




