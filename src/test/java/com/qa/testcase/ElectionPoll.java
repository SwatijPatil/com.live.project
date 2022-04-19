package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.ERPmodule;
import com.qa.pages.PollElectionPage;
import com.qa.pages.Signin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElectionPoll extends Testbase {
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("siddup7878@gmail.com","mygate1234");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test
    public void navigateToERPDashboard() throws InterruptedException {
        PollElectionPage election=new PollElectionPage(driver);
        election.doNavigateToelectionPollModule();
        election.createElectionPoll();


    }
}
