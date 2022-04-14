package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Amenity {
    @FindBy(xpath="//span[contains(.,'Amenity Booking')]")
    public WebElement navigatetoamenity;
    @FindBy(xpath="//button[@class='btn create']")
    public WebElement newbookingbutton;
    @FindBy(xpath="(//span[contains(.,'Choose House')])[1]")
    public WebElement selecthouse;
    @FindBy(xpath="//li[@class='select2-results__option']")
    public List<WebElement> housenum;
    @FindBy(xpath="//div[@id='amenity99']")
    public WebElement newclubhouse;
    @FindBy(xpath="//td[@class='day'][contains(.,'23')]")
    public WebElement date;
    @FindBy(xpath = "//button[contains(.,'BOOK NOW')]")
    public WebElement booknowbutton;
    @FindBy(xpath = "//a[contains(.,'Go to Bookings')]")
    public WebElement gotobookings;
    @FindBy(xpath="(//i[@class='fa fa-times-circle-o'])[1]")
    public WebElement cancelbooking;
    @FindBy(xpath = "//span[contains(.,'Edit')]")
    public WebElement edit;
    @FindBy(xpath = "//button[contains(.,'SELECT TIMESLOT')]")
    public WebElement timeslotbutton;
    @FindBy(xpath="//textarea[@id='id_reason_for_rejection']")
    public WebElement rejectreason;
    @FindBy(xpath="//button[@id='modal-submit']")
    public WebElement submitbutton;
    @FindBy(xpath="//button[contains(.,'Close')]")
    public WebElement closebutton;
    //__________________PAID AMENITY_____________
    @FindBy(xpath="//div[@id='amenity76']")
    public WebElement paidamenity;
    @FindBy(xpath="//td[@class='day'][contains(.,'7')]")
    public WebElement paidamenitydate;
    @FindBy(xpath="(//span[@class='checkmark_square'])[3]")
    public WebElement timeslot;
    @FindBy(xpath="//button[contains(.,'PROCEED TO PAYMENT')]")
    public WebElement proceedtopaymentbutton;
    @FindBy(xpath="(//span[@class='checkmark'])[7]")
    public WebElement paymentmode;
    @FindBy(xpath="//span[contains(.,'SBI')]")
    public WebElement SBI;

    public Amenity(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void navigateToAmenityBooking(){
        navigatetoamenity.click();
    }
    public void addAmenity(){
        newbookingbutton.click();
        selecthouse.click();
        for (WebElement house:housenum) {
            if(house.getText().equalsIgnoreCase("A-4")){
         house.click();
            break;
            }
        }
        newclubhouse.click();
        date.click();
        booknowbutton.click();
        gotobookings.click();
        cancelbooking.click();
        rejectreason.sendKeys("add reject reason ");
        submitbutton.click();
        closebutton.click();

    }
    /*public void editAmenity(){
        edit.click();
        date.click();
        timeslotbutton.click();
    }*/
    public void paidAmenity() throws InterruptedException {
        newbookingbutton.click();
        selecthouse.click();
        for (WebElement house:housenum) {
            if(house.getText().equalsIgnoreCase("A-6")){
                house.click();
                break;
            }
        }
        paidamenity.click();
        paidamenitydate.click();
        timeslotbutton.click();
        timeslot.click();
        Thread.sleep(4000);
        proceedtopaymentbutton.click();
        paymentmode.click();
       // SBI.click();
        booknowbutton.click();

    }

}

