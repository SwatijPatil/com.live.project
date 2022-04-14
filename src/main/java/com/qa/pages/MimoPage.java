package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MimoPage {
    public WebDriver driver;
    @FindBy(xpath="(//span[contains(.,'Manage Residents')])[1]")
    public WebElement manageResident;
    @FindBy(xpath="//a[contains(.,' Manage Move in Move out requests')]")
    public WebElement mimolink;
    @FindBy(xpath="//select[@id='society_id']")
    public WebElement selectSociety;
    @FindBy(xpath = "(//button[contains(.,'Search')])[1]")
    public WebElement searchButton;
    @FindBy(xpath="//button[contains(.,'New Move In')]")
    public WebElement newMoveINButton;
    @FindBy(xpath = "//select[@id='status']")
    public WebElement statusFilter;
    @FindBy(xpath="//select[@id='block']")
    public WebElement building;
    @FindBy(xpath = "//select[@id='flat']")
    public WebElement flatnum;
    @FindBy(xpath = "//select[@id='user_type']")
    public WebElement type;
    @FindBy(xpath="//input[@name='move_in_date']")
    public WebElement miDate;
    @FindBy(xpath="//a[@class='ui-state-default'][contains(.,'15')]")
    public WebElement selectMIDate;
    //_____________________Resident Info__________________
    @FindBy(xpath="//input[@class='required form-control PERSONAL_Name']")
    public WebElement userName;
    @FindBy(xpath="//input[@class='required form-control PERSONAL_Email']")
    public WebElement email;
    @FindBy(xpath="//input[@class='required form-control PERSONAL_Mobile']")
    public WebElement mobileNumber;
    @FindBy(xpath="//input[@id='move_in_date']")
    public WebElement datefield;
    @FindBy(xpath="//select[@class='form-control photo_id_type']")
    public WebElement photoIdType;
    @FindBy(xpath="(//input[@class='form-control'])[1]")
    public WebElement photoIdDocument;
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement policeVerification;
    //______________________Payment________________________
    @FindBy(xpath="//input[@class='form-control payment_amount custom_input_width only_number']")
    public WebElement amount;
    @FindBy(xpath = "//input[@class='form-control date_of_payment custom_input_width hasDatepicker']")
    public WebElement paymentDate;
    @FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active']")
    //@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default ui-state-highlight ui-state-active']")
    public WebElement selectPaymentDate;
    @FindBy(xpath = "//input[@class='payment_mode']")
    public WebElement paymentModeCash;
    @FindBy(xpath="//select[@id='bank_name']")
    public WebElement bankName;
    @FindBy(xpath = "//textarea[@class='payment_description form-control']")
    public WebElement paymentDescription;
    @FindBy(xpath = "//select[@id='status']")
    public WebElement paymentStatus;
    @FindBy(xpath="//button[contains(.,'Save')]")
    public WebElement saveButton;
    @FindBy(xpath="//button[contains(.,'Close')]")
    public WebElement closeButton;
    //____________________EDIT _________________________
    @FindBy(xpath = "//button[contains(.,'Edit')]")
    public WebElement editButton;
    @FindBy(xpath="//input[@class='form-control VEHICLES_VEHICLENAME']")
    public WebElement vehicleName;
    @FindBy(xpath="//input[@class='form-control VEHICLES_VEHICLENUMBER']")
    public WebElement vehicleNumber;
    @FindBy(xpath="//input[@class=' form-control VEHICLES_VEHICLEATTACHMENT']")
    public WebElement vehicleAttachment;
    @FindBy(xpath="//input[@class='form-control payment_amount custom_input_width only_number']")
    public WebElement editAmount;
    @FindBy(xpath="//button[contains(.,'Approve and Generate Pass')]")
    public WebElement approveAndGenerateButton;
    @FindBy(xpath="//button[contains(.,'Reject')]")
    public WebElement rejectButton;
    @FindBy(xpath = "//input[@id='payment']")
    public WebElement rejectReasonPayment;
    @FindBy(xpath="//textarea[@id='reject_comment']")
    public WebElement rejectComment;
    @FindBy(xpath="//button[contains(.,'Submit')]")
    public WebElement submitButton;
    //Status Filter ___________________
    @FindBy(xpath = "(//a[contains(@href,'flat_id=160492')][contains(.,'View')])[1]")
    public WebElement viewLinkForApprovedUser;
    //_____________configuration__________________
    @FindBy(xpath="//button[contains(.,'Configure')]")
    public WebElement configureButton;
    @FindBy(xpath="//input[@class='personal-detail-toggle-btn']")
    public WebElement residentialInfo;
    @FindBy(xpath="//input[@class='family-detail-toggle-btn']")
    public WebElement familyDetails;
    @FindBy(xpath="//input[@class='vehicles-toggle-btn']")
    public WebElement vehicleDetails;
    @FindBy(xpath="(//button[contains(.,'Save & Next')])[1]")
    public WebElement saveAndNextButton;
    @FindBy(xpath="(//button[contains(.,'Okay')])[1]")
    public WebElement okayButton;


    public void configurationSetup(){
   configureButton.click();
   residentialInfo.click();
   familyDetails.click();
   vehicleDetails.click();
}

    public MimoPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doSelect(WebElement ele, String value){
        Select s=new Select(ele);
        s.selectByValue(value);
    }
    public void navigateToMImoPage(){
        manageResident.click();
        mimolink.click();
        doSelect(selectSociety, "28");
        searchButton.click();

    }
    public void createNewMIMORequest() throws InterruptedException {
        newMoveINButton.click();
        doSelect(building,"2018");
        doSelect(flatnum,"160498");
        doSelect(type, "M");
        datefield.click();
       miDate.click();
        userName.sendKeys("test one");
        email.sendKeys("testemail@gmail.com");
        mobileNumber.sendKeys("5454565656");
        doSelect(photoIdType, "Aadhaar");
        photoIdDocument.sendKeys("C:\\Users\\Swati\\Downloads\\images (1).jpg");
        policeVerification.sendKeys("C:\\Users\\Swati\\Downloads\\images (1).jpg");
        amount.sendKeys("0");
        //paymentDate.click();
        Thread.sleep(4000);
        //selectPaymentDate.click();
        //doSelect(bankName,"BANK_OF_INDIA");
        paymentDescription.sendKeys("add des from the admin dashboard");
        doSelect(paymentStatus,"SUCCESSFULL");
        saveButton.click();
    }
    public void editMIRequest() throws InterruptedException {
        editButton.click();
        doSelect(flatnum, "160492");
        userName.clear();
        userName.sendKeys("edit the user name ");
        email.clear();
        email.sendKeys("edutemail@gmail.com");
        mobileNumber.sendKeys("5121343432");
        photoIdDocument.sendKeys("C:\\Users\\Swati\\Downloads\\images(4).png");
        paymentDescription.sendKeys("Move in payment done successfully");
        doSelect(paymentStatus,"SUCCESSFULL");
        saveButton.click();
        //approveAndGenerateButton.click();
        Thread.sleep(2000);
        editButton.click();
        saveButton.click();
    }
    public void searchFilter(){
        doSelect(statusFilter,"APPROVED");
        viewLinkForApprovedUser.click();
        editButton.click();
        doSelect(statusFilter,"PENDING");
        saveButton.click();
        approveAndGenerateButton.click();
    }
    public void reject(){
        rejectButton.click();
        rejectReasonPayment.click();
        rejectComment.sendKeys("payment issue ");
        submitButton.click();

    }
}
