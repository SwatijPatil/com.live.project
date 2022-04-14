package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ERPmodule extends Testbase {
    @FindBy(xpath = "(//span[contains(.,'Manage Society')])[1]")
    public WebElement managesociety;
    @FindBy(xpath="//a[contains(.,' MyGateLiving Dashboard')]")
    public WebElement erpnavigation;
    @FindBy(id="edit-society")
    public WebElement dp;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement proccedebutton;
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public  WebElement navigatetocommunicationmodule;
    public ERPmodule(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doNavigationToErpDashboard(){
        managesociety.click();
        erpnavigation.click();
        Select s =new Select(dp);
        s.selectByValue("680");
        proccedebutton.click();
        //navigatetocommunicationmodule.click();
    }
}
