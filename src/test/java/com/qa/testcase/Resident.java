package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ResidentListPage;
import com.qa.pages.Signin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Resident extends Testbase {
    public Signin sn;
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","123456");
    }
    @Test
    public void residentListNavigation() throws InterruptedException {
        ResidentListPage rsp=new ResidentListPage(driver);
        rsp.doNavigateToResidentList();
        //rsp.addResident();
        rsp.search();
    }
}
