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
        sn.login("siddup7878@gmail.com","123456");
        ERPmodule erp=new ERPmodule(driver);
        erp.doNavigationToErpDashboard();
    }
    @Test(priority = 1)
    public void navigateToERPDashboard() throws InterruptedException {
        PollElectionPage election=new PollElectionPage(driver);
        election.doNavigateToelectionPollModule();
        //election.createElectionPoll();
        Thread.sleep(2000);
        //election.editPoll();
        //election.deletePoll();
    }
    @Test(priority = 2)
    public void statusSearch() throws InterruptedException {
        PollElectionPage election=new PollElectionPage(driver);
        election.searchFilter();

    }

}
