package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SurveyPage extends Testbase {
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public WebElement communications;
    @FindBy(xpath = "//p[contains(.,'Survey')]")
    public WebElement survey;
    @FindBy(xpath="//button[contains(.,'Create New')]")
    public WebElement createNewButton;
    @FindBy(id="subject")
    public WebElement subject;
    @FindBy(id="description-data")
    public WebElement description;
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
    @FindBy(xpath = "//label[@for='one_vote']")
    public WebElement checkBox;
    @FindBy(xpath="//input[@class='form-control question-input qus-val']")
    public WebElement question;
    @FindBy(xpath="//select[@class='msg_q_select optionSelect']")
    public WebElement questionType;
    @FindBy(xpath="//label[@for='mandatory_checkbox_input_1']")
    public WebElement mandatoryResponse;
    @FindBy(xpath = "//button[contains(.,'Save & Publish')]")
    public WebElement saveAndPublish;
    //_______________________SEARCH TITLE _______________________________
    @FindBy(xpath=" //input[@id='search-status']")
    public WebElement searchFilter;
    @FindBy(xpath="//button[@class='search_image bg-transparent']")
    public WebElement searchIcon;
    @FindBy(xpath="//button[@id='edit-poll']")
    public WebElement editButton;


    public void search(){
        searchFilter.sendKeys("ERP Dashboard");
        searchIcon.click();
    }
    public void editSurvey(){
        editButton.click();
    }

@FindBy(xpath="//input[@id='later-radio']")
public WebElement laterRadioButton;
    @FindBy(xpath="//input[@id='startDate']")
    public WebElement startDate;
    @FindBy(xpath = "(//table[@class=' table-condensed'])[6]")
    public WebElement startDateCalendar;
    @FindBy(xpath="(//th[contains(.,'April 2022')])[3]")
    public WebElement startDateMonthYear;
    @FindBy(xpath="//select[@id='starts_time']")
    public WebElement startTime;
    @FindBy(xpath="(//table[@class=' table-condensed'])[6]")
    public WebElement expiryDate;
    @FindBy(xpath="(//th[contains(.,'April 2022')])[6]")
    public WebElement expiryCalMonthYear;
    @FindBy(xpath="//button[contains(.,'Save as Draft')]")
    public WebElement saveAndDraft;


    public void doSelectStarDate(){
        while(!(startDateMonthYear.getText().split(" ")[0].equalsIgnoreCase("May")
        && startDateMonthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            driver.findElement(By.xpath("(//th[@class='next'])[3]")).click();
        }
        driver.findElement(By.xpath("//div[@class='datetimepicker-days']//tbody/tr[3]/td[contains(.,'11')][@class='day']")).click();
    }
    public void doSelectExpiryDate() throws InterruptedException {
        expireDateCal.click();
        expiryDate.click();
        while(!(expiryCalMonthYear.getText().split(" ")[0].equalsIgnoreCase("May")
        && expiryCalMonthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            driver.findElement(By.xpath("(//th[@class='next'])[8]")).click();
        }
        Thread.sleep(4000);
driver.findElement(By.xpath("(//div[@class='datetimepicker-days']//tbody/tr[5]/td[@class='day'][contains(.,'26')])[2]"))
        .click();    }


    public SurveyPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void  doSelectDRopDown(WebElement ele, int index){
        Select s=new Select(ele);
        s.selectByIndex(index);
    }
    public void doSelectDate() throws InterruptedException {
        dateMonthYear.click();
        System.out.println(monthYear.getText());
        while(!(monthYear.getText().split(" ")[0].equalsIgnoreCase("April")
                && monthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            Thread.sleep(8000);

        }
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[6]/td[3]")).click();
    }
    public void doNvaigateToSurvey(){
        communications.click();
        survey.click();
    }
    public void createNewSurvey() throws InterruptedException {
        createNewButton.click();
        subject.sendKeys("FROM ERP 22-04-2022 ");
        description.sendKeys("test Description 2022");
        scheduleNowradioButton.click();
        expireDateCal.click();
        dateMonthYear.click();
        doSelectDate();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        doSelectDRopDown(timedropdown, 22);
        participants.click();
        for (WebElement group : groups) {
            System.out.println(group.getText());
            if(group.getText().equalsIgnoreCase("All owners")){
                group.click();
                break;
            } }
        checkBox.click();
        question.sendKeys("one");
        Thread.sleep(10000);
        doSelectDRopDown(questionType,1);
        mandatoryResponse.click();
        saveAndPublish.click();
    }
    public void createSurveyPoll() throws InterruptedException {
        createNewButton.click();
        subject.sendKeys("selecting the later radiobutton");
        description.sendKeys("later radio button");
        laterRadioButton.click();
        startDate.click();
        Thread.sleep(10000);
        startDateCalendar.click();
        doSelectStarDate();

    doSelectDRopDown(startTime,3);
        Thread.sleep(5000);
      doSelectExpiryDate();
      doSelectDRopDown(timedropdown, 21);
      participants.click();
        for (WebElement group : groups) {
            System.out.println(group.getText());
            if (group.getText().equalsIgnoreCase("All owners")) {
                group.click();
                break;
            }
        }
        checkBox.click();
        question.sendKeys("one");
        Thread.sleep(10000);
        doSelectDRopDown(questionType, 2);
        mandatoryResponse.click();
        saveAndDraft.click();
    }

}


