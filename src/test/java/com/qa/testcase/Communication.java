package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.DocumentPage;
import com.qa.pages.ERPmodule;
import com.qa.pages.Signin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Communication extends Testbase {
    public  Signin sn;
    public    ERPmodule erp;
    @BeforeTest
    public void setup(){
        intialisation();
         sn=new Signin(driver);
         sn.login("siddup7878@gmail.com","mygate1234");
    }
    @Test(priority = 1)
    public void erpDashboard(){
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test(priority= 2)
    public void createDocument(){
        DocumentPage dp=new DocumentPage(driver);
        //dp.addMangementTypeOfDocument();
       // dp.addPersonalTypeDocument();
       // dp.addSocietyTypeDocument();
        //dp.addflatTypeDocument();
    }
    @Test(priority= 3)
    public void editAndDeleteDocument() {
        DocumentPage dp = new DocumentPage(driver);
        // dp.editPersonalTypeDocument();
        // dp.deletePersonalTypedocument();
        dp.searchDocumentUsingName();
        dp.addNewDoc();
    }
}
