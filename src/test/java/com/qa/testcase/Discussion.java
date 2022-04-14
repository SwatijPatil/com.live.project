package com.qa.testcase;

import com.qa.base.Testbase;
import com.qa.pages.DiscussionForum;
import com.qa.pages.ERPmodule;
import com.qa.pages.Signin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Discussion extends Testbase {
    public  Signin sn;
    @BeforeTest
    public void setup(){
           intialisation();
           Signin sn=new Signin(driver);
           sn.login("siddup7878@gmail.com","mygate1234");
        ERPmodule er=new ERPmodule(driver);
        er.doNavigationToErpDashboard();


    }
    @Test(priority =1)
    public void addNewDiscussion(){
        DiscussionForum disf=new DiscussionForum(driver);
        disf.navigateToDocumentSection();
        disf.createNewDiscussion();
    }
    @Test(priority = 2)
    public void closeDiscussionTopic(){
        DiscussionForum disf=new DiscussionForum(driver);
        disf.navigateToDocumentSection();
        disf.closeTheTopic();
    }
    @Test(priority =4)
    public void addCommentInTheDiscussion(){
        DiscussionForum disf=new DiscussionForum(driver);
        disf.addCommentInTheDiscussion();
        driver.navigate().refresh();
    }
    @Test(priority=3)
    public void deleteTheDiscussion(){
        DiscussionForum disf=new DiscussionForum(driver);
        disf.deleteDisussion();
    }
    @Test(priority=5)
    public void searchDiscussion(){
        DiscussionForum disf=new DiscussionForum(driver);
        //disf.navigateToDocumentSection();
        disf.searchByTitle();
        disf.searchByStatus();
        driver.navigate().refresh();
    }

}

