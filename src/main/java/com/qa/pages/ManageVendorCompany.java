package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ManageVendorCompany {
    public  final WebDriver driver;
    @FindBy(xpath="//span[contains(.,'Manage Society')]")
    public WebElement managesociety;
    @FindBy(xpath = "//a[contains(.,' Manage Vendor Company')]")
    public WebElement vendorCompanyLink;
    @FindBy(tagName = "font")
    public WebElement addButton;
    @FindBy(xpath = "//select[@id='edit-society-name']")
    public WebElement societyDropDown;
    @FindBy(xpath="//input[@id='edit-company-name']")
    public WebElement companyName;
    @FindBy(xpath = "//select[@id='edit-company-type']")
    public WebElement Type;
    @FindBy(xpath="//input[@id='edit-contact-number']")
    public WebElement contactNumber;
    @FindBy(xpath = "//input[@id='edit-contact-email']")
    public WebElement email;
    @FindBy(xpath="//input[@id='edit-address']")
    public WebElement address;
    @FindBy(id="edit-city")
    public WebElement cityName;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement saveButton;
    @FindBy(xpath="//div[@class='alert alert-block alert-dismissible alert-success messages status']")
    public WebElement successMSg;
    //______________________HomePage_______________________
    @FindBy(xpath = "//select[@id='edit-society']")
    public WebElement selectSociety;
    @FindBy(id="edit-name")
    public WebElement name;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement searchButton;
    @FindBy(xpath = "//tbody/tr[2]/td[5]/a[contains(.,'Edit')]")
    public WebElement editLink;
    @FindBy(xpath = "//tbody/tr[1]/td[5]/a[contains(.,'Edit')]" +
            "")
    public WebElement automationEditLink;
    @FindBy(xpath = "//button[@id='edit-delete']")
    public WebElement delete;
    @FindBy(xpath="//button[contains(.,'Reset Search')]")
    public  WebElement resetSearch;
    @FindBy(xpath = "//select[@id='edit-type']")
public WebElement selectTpe;

    public void edit(){
        navigateToVendorCompany();
        doSelect(selectSociety, "28");
        name.sendKeys("Mygate");
        searchButton.click();
        editLink.click();
        doSelect(societyDropDown,"28");
        companyName.clear();
        companyName.sendKeys("test Automation");
        doSelect(Type,"F");
        contactNumber.clear();
        contactNumber.sendKeys("5151232323");
        email.clear();
        email.sendKeys("testmygate@gmail.com");
        address.clear();
        address.sendKeys("test mygate");
        doSelect(cityName,"731");
        saveButton.click();


    }
    public ManageVendorCompany(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToVendorCompany(){
        managesociety.click();
        vendorCompanyLink.click();
    }
    public void doSelect(WebElement ele, String value){
        Select s=new Select(ele);
        s.selectByValue(value);
    }
    public void addVendorCompany(){
        addButton.click();
        doSelect(societyDropDown,"28");
        companyName.sendKeys("Mygate");
        doSelect(Type,"F");
        contactNumber.sendKeys("5454565656");
        email.sendKeys("test45@gmail.com");
        address.sendKeys("test address");
        doSelect(cityName, "613");
        saveButton.click();
        Assert.assertEquals("×\n" +
                "Status message\n" +
                "Company already exists!",successMSg.getText());
    }
    public void deleteVendorCompanyComapny(){
        doSelect(selectSociety,"28");
        name.sendKeys("test");
        searchButton.click();
        automationEditLink.click();
        doSelect(societyDropDown,"28");
        delete.click();
    }
    public void searchFilter(){
        doSelect(selectSociety,"28");
        searchButton.click();
        resetSearch.click();
        doSelect(selectSociety,"28");
        name.sendKeys("mygate");
        searchButton.click();
        resetSearch.click();
        doSelect(selectSociety,"28");
        selectTpe.sendKeys("F");
        searchButton.click();
    }



}
