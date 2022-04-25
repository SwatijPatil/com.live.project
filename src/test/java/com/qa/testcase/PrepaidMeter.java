package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ERPmodule;
import com.qa.pages.PrepaidMeterPage;
import com.qa.pages.Signin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrepaidMeter extends Testbase {
   public Signin sn;
   public ERPmodule erp;
   public PrepaidMeterPage pm;

    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","123456");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test
    public void addNewmeterChangesFormeter(){
        PrepaidMeterPage pm=new PrepaidMeterPage(driver);
        pm.doNavigate();
        pm.addNewCharges();
    }

}
