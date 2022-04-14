package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.FlatlistPage;
import com.qa.pages.Signin;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flat extends Testbase {

    public Signin sn;
    public FlatlistPage flp;
    public Flat flatpage;
    public Flat() {
        super();
    }


    @BeforeTest
    public void setup(){
        intialisation();
       sn=new Signin(driver);
    }
    @Test(priority = 1)
    public void newLogin(){
        FlatlistPage flp=new FlatlistPage(driver);
       sn.login("siddup7878@gmail.com","mygate1234");
       flp.navigateToFlatList();

    }
  /* @Test(priority = 2)
    public void editNewFlat(){
        flp=new FlatlistPage(driver);
        flp.addFlat();
        flp.editFlatDetails();

    }*/
    @Test(priority =4)
    public void activeFlat() throws InterruptedException {
        flp=new FlatlistPage(driver);
        flp.activeFlatNavigation();

    }


}
