package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ResidentListPage extends Testbase {
    @FindBy(xpath = "//span[contains(.,'Manage Residents')]")
    public WebElement manageResident;
    @FindBy(xpath = " //a[contains(.,'Resident List')] ")
    public WebElement residentListLink;
    @FindBy(xpath="//font[contains(.,'Add Resident')]")
    public WebElement addResidentButton;
    @FindBy(xpath = "//select[@id='edit-society-name']")
    public WebElement societyDropDown;
    @FindBy(xpath="//select[@id='edit-building--2']")
    public WebElement buildingName;
    @FindBy(xpath="//select[@id='edit-flat-number--2']")
    public WebElement flatName;
    @FindBy(xpath = "//select[@id='edit-user-type']")
    public WebElement userType;
    @FindBy(xpath="//input[@id='edit-name']")
    public WebElement name;
    @FindBy(xpath="//input[@id='edit-mobile']")
    public WebElement mobile;
    @FindBy(xpath="//input[@id='edit-email']")
    public WebElement email;
    @FindBy(xpath = "//input[@id='edit-landline']")
    public WebElement landLine;
    @FindBy(xpath="//select[@id='edit-status--2']")
    public WebElement status;
    @FindBy(id="edit-address")
    public WebElement address;
    @FindBy(xpath="//select[@id='edit-country']")
    public WebElement country;
    @FindBy(xpath="//select[@id='edit-state--2']")
    public WebElement state;
    @FindBy(xpath="//select[@id='edit-city--2']")
    public WebElement city;
    @FindBy(xpath="//input[@id='edit-pincode']")
    public WebElement pincode;
    @FindBy(xpath = "//input[@id='edit-upload-photograph']")
    public WebElement photography;
    @FindBy(id = "edit-id-type")
    public WebElement idType;
    @FindBy(xpath = "//input[@id='edit-id-number']")
    public WebElement IdNumber;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement saveButton;
    //____________________Society ____________________________
    @FindBy(xpath = "//select[@id='edit-society']")
    public WebElement societyList;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement searchButton;
    @FindBy(xpath = "//select[@id='edit-status']")
    public WebElement selectStatus;


    public ResidentListPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doSelect(WebElement ele, String value){
        Select s=new Select(ele);
        s.selectByValue(value);
    }
    public void doNavigateToResidentList(){
        manageResident.click();
        residentListLink.click();
    }
    public void addResident(){
        addResidentButton.click();
        doSelect(societyDropDown, "28");
        doSelect(buildingName,"41");
        doSelect(flatName,"160110");
        doSelect(userType, "T");
        name.sendKeys("SWATI");
        mobile.sendKeys("5154565650");
        email.sendKeys("mygate100@gmail.com");
        landLine.sendKeys("22356");
        doSelect(status, "O");
        address.sendKeys("hsr layout");
        doSelect(country, "26");
        doSelect(state,"256");
        doSelect(city,"613");
        pincode.sendKeys("560040");
        photography.sendKeys("C:\\Users\\Swati\\Downloads\\images (1).jpg");
        doSelect(idType,"Aadhar");
        IdNumber.sendKeys("1234567890");
        saveButton.click();
    }
    public void search() throws InterruptedException {
        Thread.sleep(10000);
       doSelect(societyList,"28");
       searchButton.click();
    }
}


