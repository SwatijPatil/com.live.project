package com.qa.pages;

import com.qa.base.Testbase;
import com.sun.javafx.image.ByteToIntPixelConverter;
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
    @FindBy(xpath = "//span[contains(.,'Communications')]")
    public WebElement communications;
    @FindBy(xpath = "//p[contains(.,'Election Poll')]")
    public WebElement electionPollModule;
    @FindBy(xpath = "//button[contains(.,'Create New')]")
    public WebElement createNewButton;
    @FindBy(xpath = "//input[@id='q']")
    public WebElement subjectTextField;
    @FindBy(xpath = "//textarea[@id='description-data']")
    public WebElement descriptionField;
    @FindBy(xpath = "//input[@id='endDate']")
    public WebElement expireDateCal;
    @FindBy(xpath = "//input[@name='is_scheduled']")
    public WebElement scheduleNowradioButton;
    @FindBy(xpath = "(//div[@class='datetimepicker-days']/table[@class=' table-condensed'])[2]")
    public WebElement dateMonthYear;
    @FindBy(xpath = "(//div[@class='datetimepicker-days']/table/thead/tr[1]/th[2])[2]")
    public WebElement monthYear;
    @FindBy(xpath = "//select[@name='end_time']")
    public WebElement timedropdown;
    @FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    public WebElement participants;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public List<WebElement> groups;
    //________________POLL DETAILS _____________
    @FindBy(xpath = "//input[@id='s_0-p']")
    public WebElement postName;
    @FindBy(id = "s_0-n_1")
    public WebElement nominee1;
    @FindBy(xpath = "//input[@name='s_0-n_2']")
    public WebElement nominee2;
    @FindBy(xpath = "//button[contains(.,'Save as Draft')]")
    public WebElement saveASDraft;
    //___________________EDIT ______________________________
    @FindBy(xpath = "(//button[@id='edit-poll'])[1]")
    public WebElement editPollButton;
    @FindBy(id = "later-radio")
    public WebElement laterRadioButton;
    @FindBy(id = "startDate")
    public WebElement sratDate;
    @FindBy(xpath = "(//table[@class=' table-condensed'])[3]")
    public WebElement startDateCalender;
    @FindBy(xpath = "(//th[contains(.,'April 2022')])[3]")
    public WebElement monthyr;
    @FindBy(xpath = "//button[contains(.,'Save & Publish')]")
    public WebElement saveAndPublish;
    @FindBy(xpath = "//select[@name='start_time']")
    public WebElement startTime;

    //__________________Status filter____________________________
    public void doSelectEDitDate() throws InterruptedException {
        dateMonthYear.click();
        System.out.println(monthYear.getText());
        while (!(monthYear.getText().split(" ")[0].equalsIgnoreCase("April")
                && monthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))) {
            Thread.sleep(8000);

        }
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[6]/td[3]")).click();
    }


    public void doSelectStartDate() throws InterruptedException {
        while (!(monthyr.getText().split(" ")[0].equalsIgnoreCase("May")
                && monthyr.getText().split(" ")[1].equalsIgnoreCase("2022"))) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//th[@class='next'])[3]")).click();
            break;
        }
        driver.findElement(By.xpath("//td[@class='day old today active']")).click();
    }

    public void doSelectDRopDown(WebElement ele, int index) {
        Select s = new Select(ele);
        s.selectByIndex(index);
    }

    public void doSelectDate() throws InterruptedException {
        dateMonthYear.click();
        System.out.println(monthYear.getText());
        while (!(monthYear.getText().split(" ")[0].equalsIgnoreCase("April")
                && monthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))) {
            Thread.sleep(8000);

        }
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[6]/td[3]")).click();
    }

    public PollElectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doNavigateToelectionPollModule() {
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
        doSelectDRopDown(timedropdown, 22);
        participants.click();
        for (WebElement group : groups) {
            System.out.println(group.getText());
            if (group.getText().equalsIgnoreCase("All owners")) {
                Thread.sleep(3000);
                group.click();
                break;
            }
        }
        postName.sendKeys("Admin");
        nominee1.sendKeys("one");
        nominee2.sendKeys("two");
        saveASDraft.click();
    }

    @FindBy(xpath = "(//button[contains(.,'Delete')])[2]")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[@id='confirm-modal-delete']")
    public WebElement confirmDelete;

    public void editPoll() throws InterruptedException {
        Thread.sleep(15000);
        editPollButton.click();
        subjectTextField.click();
        subjectTextField.sendKeys("add new subject");
        descriptionField.clear();
        descriptionField.sendKeys("ELECTION POLL");
        laterRadioButton.click();
        sratDate.click();
        //startDateCalender.click();
        doSelectStartDate();
        doSelectDRopDown(startTime, 22);
        expireDateCal.click();
        saveAndPublish.click();
    }

    public void deletePoll() throws InterruptedException {
        Thread.sleep(15000);
        deleteButton.click();
        confirmDelete.click();
    }

    @FindBy(xpath = "//span[@id='select2-st_select-container']")
    public WebElement statusFilter;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement filter;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public List<WebElement> options;
    @FindBy(xpath = "//button[@id='filter-btn']")
    public WebElement filterButton;
    @FindBy(xpath = "//button[@id='clear-filter-btn']")
    public WebElement clearFilter;
    @FindBy(xpath = "(//button[@id='view-poll'])[1]")
    public WebElement viewButton;
    @FindBy(xpath = "//label[@for='attachments']")
    public WebElement attachment;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement radioButton;
    @FindBy(xpath = "//button[contains(.,'Update & Publish')]")
    public WebElement updateButton;
    @FindBy(id = "end_time")
    public WebElement expiryTime;
    @FindBy(xpath = "//input[@id='search-status']")
    public WebElement searchBar;

    public void searchFilter() throws InterruptedException {
        statusFilter.click();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("scheduled")) {
                option.click();
                break;
            }
        }
        Thread.sleep(4000);
        filterButton.click();
        Thread.sleep(5000);
        editPollButton.click();
        radioButton.click();
        expireDateCal.click();
        //dateMonthYear.click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//td[@class='day'][contains(.,'18')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        doSelectDRopDown(timedropdown, 23);
        updateButton.click();
    }
}