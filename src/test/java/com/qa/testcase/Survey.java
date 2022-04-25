package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ERPmodule;
import com.qa.pages.Signin;
import com.qa.pages.SurveyPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Survey extends Testbase {
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn =new Signin(driver);
        sn.login("siddup7878@gmail.com","123456");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test(priority = 1)
    public void createSurveyPoll() throws InterruptedException {
        SurveyPage sp=new SurveyPage(driver);
        sp.doNvaigateToSurvey();
        //sp.createNewSurvey();
        sp.createSurveyPoll();
    }
    @Test(priority = 2)
    public void searchSurvey(){
        SurveyPage sp=new SurveyPage(driver);
        //sp.search();

    }
}
