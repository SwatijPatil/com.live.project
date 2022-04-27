package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UnregisteredUserRequest {

    private final WebDriver driver;
    @FindBy(xpath = "( //a[contains(.,'Manage Unregistered Users')])[1]")
    public WebElement unregisterUserLink;
    @FindBy(xpath="//span[contains(.,'Manage Residents')]")
    public WebElement residentList;
    @FindBy(xpath=" ( //a[contains(.,'User Registration Requests')])[1]")
    public WebElement userRegistrationRequest;
    @FindBy(xpath="//select[@id='edit-society']")
    public WebElement societyDropDown;
    @FindBy(xpath="//button[@id='edit-submit']")
    public WebElement searchButton;

    public UnregisteredUserRequest(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void doNavigateTomodule() throws InterruptedException {
        residentList.click();
        Thread.sleep(5000);
        userRegistrationRequest.click();
    }
    public void doSelectDropDown(WebElement ele, String value){
        Select s=new Select(ele);
        s.selectByValue("value");
    }
    public void approveTheRequest(){
        doSelectDropDown(societyDropDown, "28");
        searchButton.click();


    }

}
