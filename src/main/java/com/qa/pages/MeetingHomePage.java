package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MeetingHomePage {
  public WebDriver driver;
    @FindBy(xpath = "//span[contains(.,'Communications')]")
    public WebElement communicationmodule;
    @FindBy(xpath = "//p[contains(.,'Meetings')]")
    public WebElement meeting;
    @FindBy(xpath = "//a[contains(.,'Create')]")
    public WebElement CreateMeet;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-th']")
    public WebElement meetingdate;
    @FindBy(xpath = "(//td[@class='day'][contains(.,'19')])[1]")
    public WebElement meetingstartdate;
    @FindBy(xpath = "(//span[@class='hour'][contains(.,'23:00')])[1]")
    public WebElement meetTimeinhour;
    @FindBy(xpath = "(//span[@class='minute'][contains(.,'23:55')])[1]")
    public WebElement meettimeinmin;
    @FindBy(id = "id_title")
    public WebElement meetingtitle;
    @FindBy(id = "id_venue")
    public WebElement venu;
    //li[@class='select2-results__option']
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement group;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public List<WebElement> usergroups;
    @FindBy(xpath="//div[@class='cke_inner cke_reset']/div[@id='cke_1_contents']/iframe")
    public WebElement frameagend;
    @FindBy(xpath="//div[@class='cke_inner cke_reset']/div[@id='cke_2_contents']/iframe")
    public WebElement frameDescription;
    @FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    public WebElement addagenda;
    @FindBy(xpath = "/html[1]/body[1]")
    public WebElement description;
    @FindBy(xpath="//input[@class='btn btn-default center-block submitBtn']")
    public WebElement submitbutton;
    @FindBy(xpath = "//a[contains(.,'Edit')]")
    public WebElement editlink;
    @FindBy(xpath = "(//table[@class=' table-condensed'])[3]")
    public WebElement entiretable;
    //________________________view________________________________________________
    @FindBy(xpath="(//a[contains(.,'View')])[2]")
    public WebElement viewlink;
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    public WebElement deletebutton;
    @FindBy(xpath = "//a[contains(.,'Cancel')]")
    public WebElement cancellink;
    @FindBy(xpath="//button[@class='swal-button swal-button--yes']")
    public WebElement yesbutton;

    public MeetingHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToFrame(){
    }

   public void donavigationTomeetingModule(){
        communicationmodule.click();
        meeting.click();}   

    public void addMeeting(){
        CreateMeet.click();
        meetingdate.click();
        meetingstartdate.click();
        meetTimeinhour.click();
        meettimeinmin.click();
        meetingtitle.sendKeys("new meeting 15-03-2021");
        venu.sendKeys("HALL");
        group.click();
            for (WebElement user :usergroups) {
                if (user.getText().equalsIgnoreCase("All owners")){
                    user.click();
                    break; } }
            WebElement frameIndex = driver.findElement(By.tagName("iframe"));
            //System.out.println(frameIndex.getSize());
            driver.switchTo().frame(frameagend);
            addagenda.sendKeys("meeting description ");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(frameDescription);
            description.sendKeys("add the new description from dashboard ");
            driver.switchTo().defaultContent();
            submitbutton.click();
    }
    public void editMeeting(){
        editlink.click();
        meetingtitle.clear();
       meetingtitle.sendKeys("add the new title for test one ");
       submitbutton.click();
    }
    public void viewMeeting(){
        viewlink.click();
        deletebutton.click();
    }
    public void cancelMeet(){
        cancellink.click();
        yesbutton.click();
    }

}

