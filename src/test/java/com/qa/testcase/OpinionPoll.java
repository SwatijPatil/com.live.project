package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ERPmodule;
import com.qa.pages.OpinionPollPage;
import com.qa.pages.Signin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpinionPoll extends Testbase {
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","mygate1234");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test(priority = 1)
    public void createOpinionPoll() throws InterruptedException {
        OpinionPollPage page=new OpinionPollPage(driver);
        page.doNavigateToOpinionPoll();
        //page.createNewOpinionPoll();
    }
    @Test(priority = 2)
    public void createSecretPoll() throws InterruptedException {
        OpinionPollPage page=new OpinionPollPage(driver);
       // page.createScretePoll();
    }
    @Test(priority = 3)
    public void deleteThePoll(){
        OpinionPollPage page=new OpinionPollPage(driver);
        //page.deletePoll();
    }
    @Test(priority = 4)
    public void pollSearchFilter(){
        OpinionPollPage page=new OpinionPollPage(driver);
        page.search();

    }
}
