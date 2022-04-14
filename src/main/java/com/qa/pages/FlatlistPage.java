package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FlatlistPage {
    public WebDriver driver;
    @FindBy(xpath="//span[contains(.,'Manage Society')]")
    public WebElement managesociety;
    @FindBy(xpath = "(//a[contains(.,' Manage Flats')])[1]")
    public WebElement manageflatlink;
    @FindBy(xpath = "//ul[@class='animated zoomIn menu_level_3rd']/li/a[contains(.,' Manage Flats View')]")
    public WebElement manageflatviewlink;
    @FindBy(xpath="//font[contains(.,'Add Flat')]")
    public WebElement addflat;
    @FindBy(id="edit-society-name")
    public WebElement societynamedropdown;
    @FindBy(xpath="//select[@id='edit-building--2']")
    public WebElement buildingdropdown;
    @FindBy(xpath="//input[@id='edit-floor-number']")
    public WebElement floornum;
    @FindBy(xpath="//input[@id='edit-flatnumber']")
    public WebElement flatnumber;
    @FindBy(xpath="//input[@id='edit-phoneextension']")
    public WebElement phone_extension;
    @FindBy(xpath="//input[@id='edit-occupanttype']")
    public WebElement occupant_type;
    @FindBy(xpath="//input[@id='edit-primary-contact-number']")
    public WebElement e_intercomnum;
    @FindBy(xpath="//input[@id='edit-secondary-contact-number']")
    public WebElement secondarycontactnum;
    @FindBy(xpath = "//button[@id='edit-submit']")
    public WebElement savebutton;
    @FindBy(xpath = "//a[@id='flat_reset']")
    public WebElement cancelbutton;
    
public void selectDropDown(WebElement ele, String value){
    Select s=new Select(ele);
    s.selectByValue(value);
}
public FlatlistPage(WebDriver driver){
    PageFactory.initElements(driver, this);
    }
    public void navigateToFlatList() {
        managesociety.click();
        manageflatlink.click();
        manageflatviewlink.click();
    }
    public void addFlat(){
        addflat.click();
        selectDropDown(societynamedropdown, "680");
        selectDropDown(buildingdropdown,"5157");
        floornum.sendKeys("100");
        flatnumber.sendKeys("Automation 001");
        phone_extension.sendKeys("7760854870");
        //selectDropDown(occupant_type,"O");
        e_intercomnum.sendKeys("8197900165");
        secondarycontactnum.sendKeys("5454545454");
        savebutton.click();
        System.out.println("successfully created");
}
           @FindBy(xpath = "//a[contains(.,'A Automation 001')]")
           public WebElement flatlink;
           @FindBy(xpath = "//tbody/tr[1]/td[7]/a[contains(.,'Edit')]")
           public WebElement editlink;
           @FindBy(xpath="//textarea[@name='reason_text']")
           public WebElement addreason;
           @FindBy(xpath="//button[@class='otp_login_confirm_button']")
           public WebElement popupsubmitbutton;
           @FindBy(xpath="//input[@id='edit-floor']")
           public WebElement editfloor;
           @FindBy(xpath="//input[@id='edit-flat']")
           public WebElement editflatnum;
           @FindBy(xpath = "(//input[@class='form-checkbox'])[3]")
           public WebElement deletecheckbox;
           @FindBy(xpath="//button[@id='edit-delete']")
           public WebElement deletebutton;
           public void editFlatDetails(){
               flatlink.click();
               editlink.click();
               addreason.sendKeys("add reason");
               popupsubmitbutton.click();
               editfloor.clear();
               editfloor.sendKeys("12");
               editflatnum.clear();editflatnum.sendKeys("edit flat number 10");
               savebutton.click();
               deletecheckbox.click();
               deletebutton.click();
               driver.navigate().back();
           }
           @FindBy(xpath="//select[@name='status']")
           public WebElement activeflatstatus;
           @FindBy(xpath="//button[@class='btn btn-primary form-submit'][@id='edit-submit']")
           public WebElement searchbutton;
           @FindBy(xpath="//select[@id='edit-society']")
           public WebElement societyname;
           @FindBy(xpath="//a[contains(.,'A 5')]")
           public WebElement a5flatlink;
           @FindBy(xpath="(//tbody/tr[1]/td[5])[2]/a[contains(.,'Edit')]")
           public WebElement editactiveuser;
           @FindBy(xpath="//input[@id='edit-upload-photograph']")
           public WebElement uploadphoto;
           @FindBy(xpath = "//select[@name='id_type']")
           public WebElement idtype;
           @FindBy(xpath="//input@id='edit-id-number']")
           public WebElement idnumber;
           @FindBy(id="edit-address")
           public WebElement address;
           @FindBy(xpath="//select[@id='edit-country']")
           public WebElement countrydropdown;
           @FindBy(xpath="//select[@id='edit-state--2']")
           public WebElement statedropdown;
           @FindBy(xpath="//select[@id='edit-city--3']")
           public WebElement citydropdown;
           @FindBy(xpath = "//input[@id='edit-pincode']")
           public WebElement pincode;
           public void activeFlatNavigation() throws InterruptedException {
               Thread.sleep(3000);
               selectDropDown(societyname,"680");
               selectDropDown(activeflatstatus,"A");
               searchbutton.click();
               a5flatlink.click();
               editactiveuser.click();
               addreason.sendKeys("test add");
               popupsubmitbutton.click();
               Thread.sleep(3000);
              // editactiveuser.click();
               uploadphoto.sendKeys("C:\\Users\\Swati\\OneDrive\\Pictures\\Screenshots\\Screenshot (1155).png");
               selectDropDown(idtype,"Aadhar");
               //idnumber.sendKeys("idnumber1234");
               address.sendKeys("new address");
               selectDropDown(countrydropdown,"26");
               selectDropDown(statedropdown,"256");
               selectDropDown(citydropdown,"613");
               pincode.sendKeys("887777");
               savebutton.click();




           }



}
