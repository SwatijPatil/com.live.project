package com.qa.testcase;


import com.qa.base.Testbase;
import com.qa.pages.AddServiceProvider;
import com.qa.pages.MeetingHomePage;
import com.qa.pages.ERPmodule;
import com.qa.pages.Signin;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignInPageTest extends Testbase {
    Signin sn;
    ERPmodule ep;
    MeetingHomePage com;
    AddServiceProvider asp;
    String deletesuccessmsg = "Status message\n" +
            "ADD NEW SP FROM DB has been detached from the flat B 000 successfully.";

    public SignInPageTest() {

        super();
    }

    @BeforeTest
    public void setup() {
        intialisation();
        sn = new Signin(driver);
        ep = new ERPmodule(driver);
        com = new MeetingHomePage(driver);
    }

    /* @AfterMethod
   public void teardown(){
  driver.quit();
}*/
    @Test(priority = 1)
    public void signinToRSA() {
        sn.login("siddup7878@gmail.com", "mygate1234");
    }

    @Test(priority = 8)
    public void validateLOgo() throws InterruptedException {
        Thread.sleep(4000);
        sn.validatePagelogo();
    }

    @Test(priority = 9)
    public void validateHomePageTitle() {
        String title = sn.validateTitle();
        Assert.assertEquals(title, "Service Provider List | mygate.in");
    }

    /*@Test(priority = 4)
    public void VnavigateToERPModule(){
        ep.erpDashboard();
    }
    @Test(priority  =5)

        public void createmeeting(){
        com.mettingone();

        }*/
    @Test(priority = 2)
    public void addNewServiceProvider() throws InterruptedException {
        asp = new AddServiceProvider(driver);
        asp.addServiceProvider();
        driver.navigate().back();
        System.out.println("Successfully created");

    }

    @Test(priority = 3)
    public void AddtheServiceproviderToFlat() throws InterruptedException {
        asp = new AddServiceProvider(driver);
        // asp.AddtheSpToFlat();
        // asp.suspendServiceProvider();
       /* asp.addUnhiredServiceProviderToflat();
        WebElement expected = driver.findElement(By.xpath("//div[@class='alert alert-block alert-dismissible alert-success messages status']"));

        //Assert.assertEquals(deletesuccessmsg,expected.getText());
        if (expected.getText().contains("ADD NEW SP FROM DB has been detached from the flat B 000 successfully.")) {
            System.out.println("spdeleted successfully");


        } else {
            System.out.println("fail");
        }
        driver.navigate().back();*/asp.doDeleteSP();

    }
}



