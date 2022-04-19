package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpinionPollPage extends Testbase {
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public WebElement communications;
    @FindBy(xpath="//p[contains(.,'Opinion Poll')]")
    public WebElement opinionPoll;
    @FindBy(xpath="//a[contains(.,'Create New Poll')]")
    public WebElement createNewLink;
    @FindBy(id="id_question")
    public WebElement subject;
    @FindBy(id="id_closing_date")
    public WebElement expiryOn;
    @FindBy(xpath="(//table[@class=' table-condensed'])[3]")
    public WebElement calendar;
    @FindBy(xpath="(//table[@class=' table-condensed'])[3]/thead/tr[1]/th[2]")
    public WebElement monthYearDate;
    @FindBy(id="id_description")
    public WebElement description;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement selectGroup;
    @FindBy(xpath="//li[@class='select2-results__option']")
    public List<WebElement> userGroups;
    @FindBy(id = "id_publish_date")
    public WebElement publishDate;
    @FindBy(xpath = "//input[@id='id_choices_set-0-choice']")
    public WebElement option1;
    @FindBy(xpath="//input[@id='id_choices_set-1-choice']")
    public WebElement option2;
    @FindBy(id="submit_button")
    public  WebElement creatButton;
    @FindBy(id="id_secret_poll")
    public WebElement secretPoll;
    @FindBy(xpath = "//input[@id='send_poll_mail']")
    public WebElement sendButton;
    @FindBy(xpath = "(//img[@src='/static/img/delete_poll.png'])[1]")
    public WebElement deleteIcon;
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    public WebElement deleteButton;
    @FindBy(id="id_question")
    public WebElement question;
    @FindBy(xpath = "//button[contains(.,'Search')]")
    public WebElement searchButton;
    @FindBy(xpath = "//a[contains(.,'Cancel')]")
    public WebElement cancelLInk;
    public void createNewOpinionPoll() throws InterruptedException {
        createNewLink.click();
        selectGroup.click();
        for (WebElement group:userGroups) {
            System.out.println(group.getText());
            if (group.getText().equalsIgnoreCase("ALL owners")){
                group.click();
                break;
            }
        }
        selectGroup.click();
        subject.sendKeys("New POLL ON 19-04-2021");
        expiryOn.click();
        selectDate();
        description.sendKeys("add new description");
        publishDate.click();
        driver.findElement(By.xpath("(//td[@class='day active'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='hour active'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='minute'][contains(.,'20:55')])[2]")).click();
        option1.sendKeys("one");
        option2.sendKeys("two");
        creatButton.click();
        sendButton.click();


    }
    public void selectDate() throws InterruptedException {
        calendar.click();
        System.out.println(monthYearDate.getText());
        while(!(monthYearDate.getText().split(" ")[0].equalsIgnoreCase("May")
                && monthYearDate.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            driver.findElement(By.xpath("(//table[@class=' table-condensed'])[3]/thead/tr[1]/th[3]")).click();
        }
        driver.findElement(By.xpath("(//td[contains(.,'11')])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[contains(.,'22:00')])[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[contains(.,'22:45')][@class='minute']")).click();
    }
    public OpinionPollPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void doNavigateToOpinionPoll(){
        communications.click();
        opinionPoll.click();
    }
    public void createScretePoll() throws InterruptedException {
        createNewLink.click();
        selectGroup.click();
        for (WebElement group:userGroups) {
            System.out.println(group.getText());
            if (group.getText().equalsIgnoreCase("ALL owners")){
                group.click();
                break;
            }
        }
        selectGroup.click();
        subject.sendKeys("Opinion POLL FROM DASHBOARD");
        expiryOn.click();
        selectDate();
        description.sendKeys("FROM DASHBOARD");
        secretPoll.click();
        publishDate.click();
        selectPublishDate();
        option1.sendKeys("one");
        option2.sendKeys("two");
        creatButton.click();
        sendButton.click();
    }
    public void deletePoll(){
        deleteIcon.click();
        deleteButton.click();
    }
    public void selectPublishDate(){
        driver.findElement(By.xpath("(//*[@class=' table-condensed'])[9]")).click();
        System.out.println(monthYearDate.getText());
        while(!(monthYearDate.getText().split(" ")[0].equalsIgnoreCase("May")
                && monthYearDate.getText().split(" ")[1].equalsIgnoreCase("2022"))){
            driver.findElement(By.xpath("(//table[@class=' table-condensed'])[9]/thead/tr[1]/th[3]")).click();

        }
        driver.findElement(By.xpath("(//td[@class='day'][contains(.,'28')])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='hour active'][contains(.,'19:00')])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='minute active'][contains(.,'19:45')])[3]")).click();
    }
    public void search(){
        question.sendKeys("New poll");
        searchButton.click();
        cancelLInk.click();
    }

}
