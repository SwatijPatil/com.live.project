package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PollElectionPage extends Testbase {
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public WebElement communications;
    @FindBy(xpath="//p[contains(.,'Election Poll')]")
    public WebElement electionPollModule;
    @FindBy(xpath = "//button[contains(.,'Create New')]")
    public WebElement createNewButton;
    @FindBy(xpath="//input[@id='q']")
    public WebElement subjectTextField;
    @FindBy(xpath="//textarea[@id='description-data']")
    public WebElement descriptionField;
    @FindBy(xpath="//input[@id='endDate']")
    public WebElement expireDateCal;
    @FindBy(xpath="//input[@name='is_scheduled']")
    public WebElement scheduleNowradioButton;
    @FindBy(xpath="(//div[@class='datetimepicker-days']/table[@class=' table-condensed'])[2]")
    public WebElement dateMonthYear;
    @FindBy(xpath = "(//div[@class='datetimepicker-days']/table/thead/tr[1]/th[2])[2]")
    public WebElement monthYear;
    @FindBy(xpath="//select[@name='end_time']")
    public WebElement timedropdown;
    @FindBy(xpath="//ul[@class='select2-selection__rendered']")
    public WebElement participants;
    @FindBy(xpath="//li[@class='select2-results__option']")
    public List<WebElement> groups;
    //________________POLL DETAILS _____________
    @FindBy(xpath="//input[@id='s_0-p']")
    public WebElement postName;
    @FindBy(id="s_0-n_1")
    public WebElement nominee1;
    @FindBy(xpath = "//input[@name='s_0-n_2']")
    public WebElement nominee2;
    @FindBy(xpath = "//button[contains(.,'Save as Draft')]")
    public WebElement saveASDraft;

    public void  doSelectDRopDown(WebElement ele, String value){
         Select s=new Select(ele);
         s.selectByValue(value);
     }

    public void doSelectDate() throws InterruptedException {
        dateMonthYear.click();
        System.out.println(monthYear.getText());
        while(!(monthYear.getText().split(" ")[0].equalsIgnoreCase("April")
                && monthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            Thread.sleep(8000);
            driver.findElement(By.xpath("//th[@class='next']/span[@class='glyphicon glyphicon-arrow-right']")).click();
            break;
        }
        driver.findElement(By.xpath("(//td[@class='day today active'])[2]")).click();
    }
    public PollElectionPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doNavigateToelectionPollModule(){
        communications.click();
        electionPollModule.click();
    }
    public void createElectionPoll() throws InterruptedException {
        createNewButton.click();
        subjectTextField.sendKeys("Test Poll form the ERP Dashboard");
        descriptionField.sendKeys("add the new Description for the election poll");
        scheduleNowradioButton.click();
        expireDateCal.click();
        dateMonthYear.click();
        doSelectDate();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        doSelectDRopDown(timedropdown, "21:00");
        participants.click();
        for (WebElement group : groups) {
            System.out.println(group.getText());
            if(group.getText().equalsIgnoreCase("All owners")){
                group.click();
                break;
            } }
        postName.sendKeys("Admin");
        nominee1.sendKeys("one");
        nominee2.sendKeys("two");
        saveASDraft.click();
    }

}
