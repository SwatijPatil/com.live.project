package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddServiceProvider extends Testbase {
    String  expected= "Record exists for the society";
    public  WebDriver driver;
    @FindBy(xpath = "(//span[contains(.,'Manage Service Providers')])[1]")
    public WebElement navigatetosp;
    @FindBy(xpath = "//a[@class='btn btn-success form-submit']")
    public WebElement addspbutton;
    @FindBy(id = "edit-society-name")
    public WebElement societynamedropdown;
    @FindBy(xpath = "//input[@id='edit-provider-name']")
    public WebElement SPName;
    @FindBy(id="edit-provider-mobile")
    public WebElement SpmobileNumber;
    @FindBy(id="edit-provider-type")
    public WebElement spType;
    @FindBy(id="edit-provider-sub-type--2")
    public WebElement subType;
    @FindBy(id="edit-upload-profile-photograph")
    public WebElement uploadphoto;
    @FindBy(id="edit-socity-provider-code")
    public WebElement society_id;
    @FindBy(xpath = "//select[@id='edit-company--2']")
    public WebElement companyname;
    @FindBy(id="edit-upload-photograph")
    public WebElement docphoto;
    @FindBy(id="edit-id-type")
    public WebElement IDtype;
    @FindBy(id="edit-id-number")
    public WebElement idnum;
    @FindBy(id="edit-address1")
    public WebElement permanentaddress;
    @FindBy(id="edit-address2")
    public WebElement presentadd;
    @FindBy(id="edit-police-verfication-status-1")
    public WebElement policeverification;
    @FindBy(xpath = "//button[@class='btn btn-success form-submit icon-before']")
    public WebElement savebutton;
    @FindBy(xpath = "//div[@class='alert alert-block alert-dismissible alert-success messages status']")
    public WebElement msg;

    public AddServiceProvider(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doSelectDropDown(WebElement  ele, String value) throws InterruptedException {
        Select s = new Select(ele);
        Thread.sleep(3000);
        s.selectByValue(value);

    }
   public void addServiceProvider( ) throws InterruptedException {
        navigatetosp.click();
        addspbutton.click();
        doSelectDropDown(societynamedropdown,"680");
        Thread.sleep(3000);
        SPName.sendKeys("add new sp from db");
        SpmobileNumber.sendKeys("5555666666");
        doSelectDropDown(spType,"936" );
        doSelectDropDown(subType, "945");
        uploadphoto.sendKeys("C:\\Users\\Swati\\Downloads\\images (2).jpg");
        society_id.sendKeys("id1234");
        doSelectDropDown(companyname,"89");
        docphoto.sendKeys("C:\\Users\\Swati\\Downloads\\images (4).jpg");
        idnum.sendKeys("testIDNUm12334");
        IDtype.sendKeys("AADHARA CARD");
        permanentaddress.sendKeys("HSR LAYOUT");
        presentadd.sendKeys("TEST ADDRESS");
        policeverification.click();
        savebutton.click();
        driver.navigate().back();




         //Assert.assertEquals(msg,"Record exists for the society");
       //_______________________________________________Search by usinghire status_________________________________

    }
    @FindBy(id="edit-society")
    public WebElement societyname;
    @FindBy(id="edit-job-status-1")
    public WebElement Hirestatus;
    @FindBy(xpath = "//button[@class='btn btn-primary form-submit ajax-processed']")
    public WebElement SubmitButton;
    @FindBy(xpath="(//a[contains(.,'B 109 edit')])[2]")
    public WebElement FlatLink;
    @FindBy(xpath="//button[@value='Add More Flats']")
    public WebElement Addmoreflatbutton;
    @FindBy(id="edit-building")
    public WebElement BuildingDropDown;
    @FindBy(id="edit-flat-number--2")
    public WebElement flatlist;
    @FindBy(xpath="//input[@id='edit-sdate-datepicker-popup-0']")
    public WebElement date;
    @FindBy(xpath="//td[@data-month='2'][@data-year='2022']/a[contains(.,'10')]")
    public WebElement startdate;
        public void AddtheSpToFlat() throws InterruptedException {
        doSelectDropDown(societyname,"748");
        Hirestatus.click();
        SubmitButton.click();
        FlatLink.click();
        Addmoreflatbutton.click();
        doSelectDropDown(BuildingDropDown,"5608");
        doSelectDropDown(flatlist,"163842");
       date.click();
       startdate.click();
       SubmitButton.click();
        }
       // ___________________edit______________
    @FindBy(xpath = "//a[contains(.,'XSS')]")
    public WebElement Spnamelink;
    @FindBy(id="edit-society")
    public WebElement newsocietyname;
    @FindBy(xpath="//button[@class='otp_login_confirm_button']")
    public WebElement popupsubmitbutton;
        @FindBy(xpath="//textarea[@class='reason_text_field']")
        public WebElement AddReason;
        @FindBy(xpath="//span[contains(.,'Suspend')]")
        public WebElement suspnedsp;
        public void suspendServiceProvider() throws InterruptedException {
           Select s9=new Select(driver.findElement(By.id  ("edit-society")));
           s9.selectByValue("748");
           SubmitButton.click();
        Spnamelink.click();
        AddReason.sendKeys("test^&*");
        popupsubmitbutton.click();
        suspnedsp.click();
        }
        @FindBy(xpath="//tbody/tr/td[3]/a[contains(.,'ADD NEW SP FROM DB')]")
        public WebElement Unhiredspname;
        @FindBy(xpath="(//tbody/tr/td[10]/a[contains(.,'HIRE')])[1]")
        public WebElement Unhireflat;
        @FindBy(xpath="//button[@class='btn btn-success form-submit icon-before']")
        public WebElement addflatbutton;
        @FindBy(xpath="//tbody/tr[1]/td[10]/a[contains(.,'B 000')]")
        public WebElement flatb000;
        @FindBy(xpath="//a[contains(.,'Edit')]")
        public WebElement editflatdetails;
        @FindBy(xpath="//input[@id='edit-edate-datepicker-popup-0']")
        public WebElement enddate;
        @FindBy(xpath = "//a[@class='ui-state-default'][contains(.,'21')]")
        public WebElement selectenddate;
        @FindBy(xpath="//a[contains(.,'Delete')]")
        public WebElement deleteLink;
        @FindBy(xpath = "//a[@class='btn mg_common_modal_btn btn-danger']")
        public WebElement popupokbutton;
        @FindBy(xpath = "//a[@class='btn btn-default'][contains(.,'Cancel')]")
        public WebElement cancel_button;
        public void addUnhiredServiceProviderToflat() throws InterruptedException {
            doSelectDropDown(societyname,"680");
           SubmitButton.click();
           Unhireflat.click();
          addflatbutton.click();
         doSelectDropDown(BuildingDropDown,"5158");
         doSelectDropDown(flatlist,"160623");
         date.click();
         startdate.click();
         savebutton.click();
         doSelectDropDown(societyname,"680");
         SubmitButton.click();
         flatb000.click();
         editflatdetails.click();
         enddate.click();
         selectenddate.click();
         savebutton.click();
         doSelectDropDown(societyname,"680");
         SubmitButton.click();
         flatb000.click();
         deleteLink.click();
         popupokbutton.click();
            WebElement expected = driver.findElement(By.xpath("//div[@class='alert alert-block alert-dismissible alert-success messages status']"));
            if (expected.getText().contains("ADD NEW SP FROM DB has been detached from the flat B 000 successfully.")) {
                System.out.println("spdeleted successfully");
            } else {
                System.out.println("fail");
            }
            driver.navigate().back();
            cancel_button.click();
            //_______________________________Delete the sp from the list
        }
        @FindBy(xpath="//a[contains(.,'ADD NEW SP FROM DB')]")
        public WebElement spnamelink;
        @FindBy(xpath = "//span[@class='btn btn-danger']")
        public WebElement deletespbutton;
        @FindBy(id="reason_type")
        public WebElement deletereason;
        @FindBy(xpath = "//span[@class='btn btn-primary']")
        public WebElement proceedbutton;
        public void doDeleteSP() throws InterruptedException {
            doSelectDropDown(societyname,"680");
            SubmitButton.click();
            spnamelink.click();
            AddReason.sendKeys("add reason");
            popupsubmitbutton.click();
      deletespbutton.click();
      doSelectDropDown(deletereason,"reason_2");
      proceedbutton.click();
      System.out.println("sp successfully deleted");



        }


    }

