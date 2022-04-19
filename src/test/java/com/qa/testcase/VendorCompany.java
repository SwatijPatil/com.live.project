package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ManageVendorCompany;
import com.qa.pages.Signin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VendorCompany extends Testbase {
    public Signin sn;
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","mygate1234");
    }
    @Test(priority = 1)
    public void navigateToVendorComapnyPage(){
        ManageVendorCompany mnc=new ManageVendorCompany(driver);
        mnc.navigateToVendorCompany();
        mnc.addVendorCompany();
    }
    @Test(priority = 2)
    public void editCompanyDetails(){
        ManageVendorCompany mnc=new ManageVendorCompany(driver);
        mnc.edit();
    }
    @Test(priority = 3)
    public void deleteTheVendorCompany(){
        ManageVendorCompany mnc =new ManageVendorCompany(driver);
        mnc.navigateToVendorCompany();
        mnc.deleteVendorCompanyComapny();
    }
    @Test(priority = 4)
            public void searchVendorCompany() {
        ManageVendorCompany mnc = new ManageVendorCompany(driver);
        mnc.searchFilter();

    }

}
