package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ERPmodule;
import com.qa.pages.MeetingHomePage;
import com.qa.pages.Signin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Meeting extends Testbase {
    public Signin sn;
    public ERPmodule erp;
   // public WebDriver driver;
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","mygate1234");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();}
    @Test
    public void createMeeting(){
        MeetingHomePage mp=new MeetingHomePage(driver);
        mp.donavigationTomeetingModule();
        //mp.addMeeting();
    }
    @Test
    public void editThemeeting(){
        MeetingHomePage mp=new MeetingHomePage(driver);
        mp.editMeeting();
    }
}
