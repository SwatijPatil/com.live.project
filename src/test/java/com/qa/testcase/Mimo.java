package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.MimoPage;
import com.qa.pages.Signin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mimo extends Testbase {
    public Signin sn;
    public MimoPage mimo;

    @BeforeTest
    public void setup(){
      intialisation();
      Signin sn=new Signin(driver);
      sn.login("siddup7878@gmail.com","mygate1234");
    }
   /* @Test(priority = 1)
    public void createMIRequest() throws InterruptedException {
        MimoPage mimo=new MimoPage(driver);
        mimo.navigateToMImoPage();
        mimo.createNewMIMORequest();
    }
    @Test(priority = 2)
    public void editTheMIRequest() throws InterruptedException {
        MimoPage mimo=new MimoPage(driver);
        mimo.editMIRequest();
    }
    @Test(priority = 3)
    public void rejectTheMIRequest()
    {
        MimoPage mimo=new MimoPage(driver);
        mimo.reject();
    }*/
    @Test(priority = 4)
    public void filter(){
        MimoPage mimo=new MimoPage(driver);
        mimo.navigateToMImoPage();
        mimo.searchFilter();

    }
}
