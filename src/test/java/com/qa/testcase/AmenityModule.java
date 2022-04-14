package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.Amenity;
import com.qa.pages.ERPmodule;
import com.qa.pages.Signin;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmenityModule extends Testbase {
    public Signin sn;
    public ERPmodule erp;
    public Amenity amenity;
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","mygate1234");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();

    }
    @Test
    public void createNewAmenity(){
        Amenity amenity=new Amenity(driver);
        amenity.navigateToAmenityBooking();
       // amenity.addAmenity();
    }
    /*@Test(priority = 2)
    public void editBookedAmenity(){
        Amenity amenity=new Amenity(driver);
       // amenity.editAmenity();
    }*/
    @Test(priority =4)
    public void bookPaidAmenity() throws InterruptedException {
        Amenity amenity=new Amenity(driver);
        amenity.paidAmenity();

    }

}
