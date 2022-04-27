package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.Signin;
import com.qa.pages.UnregisteredUserRequest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationRequest extends Testbase {
    @BeforeTest
    public void setup(){
        intialisation();
        Signin sn=new Signin(driver);
        sn.login("swatip7878@gmail.com","123456");
    }
    @Test
    public void doNavigateTouserRequest() throws InterruptedException {
        UnregisteredUserRequest ur=new UnregisteredUserRequest(driver);
        ur.doNavigateTomodule();
        ur.approveTheRequest();

    }
}
