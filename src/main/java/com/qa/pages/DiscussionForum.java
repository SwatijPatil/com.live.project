package com.qa.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DiscussionForum {
     public WebDriver driver;
    @FindBy(xpath="//p[contains(.,'Discussion Forum')]")
    public WebElement discussion;
    @FindBy(xpath="//a[contains(.,'Create Discussion')]")
    public WebElement creatediscussion;
    @FindBy(xpath="//input[@id='id_title']")
    public WebElement title;
    @FindBy(xpath="//body[contains(@class , 'cke_editable cke_editable_themed')]")
    public WebElement description;
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public  WebElement navigatetocommunicationmodule;
    @FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/span[1]/span[1]/span[1]/ul[1]")
    //@FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    //@FindBy(xpath="//input[@class='select2-search__field']")
    //@FindBy(xpath="//li[@class='select2-search select2-search--inline']")
    //@FindBy(xpath="//span[@class='select2-selection select2-selection--multiple']")
    public WebElement select_group;
    @FindBy(xpath="//li[@class='select2-results__option']")
    public List<WebElement> usergroups;
    @FindBy(xpath="//input[@id='id_unityapp-fileattachment-content_type-object_id-0-attachment']")
    public WebElement choosefile;
    @FindBy(xpath="//input[@value='Create']")
    public WebElement createbutton;
    @FindBy(xpath="//div[@class='row']/a[@value='Edit']")
    public WebElement editlink;
    @FindBy(xpath="//input[@id='id_unityapp-fileattachment-content_type-object_id-1-attachment']")
    public WebElement choosefile1;
    @FindBy(xpath="//input[@value='Update']")
    public WebElement update;
    @FindBy(xpath="//input[@value='Send']")
    public WebElement sendbutton;
    //______________close the topic_________________
    @FindBy(xpath = "(//span[@data-original-title='Topic Open'])[4]")
    public WebElement topic;
    @FindBy(xpath="//textarea[@id='id_comment']")
    public WebElement addcomment;
    @FindBy(xpath="//button[@id='modal-submit']")
    public WebElement closebutton;
    //____________Edit___________________
    @FindBy(xpath = "//a[contains(.,'nava')]")
    public WebElement titlelink;
    @FindBy(xpath="//textarea[@id='id_body']")
    public WebElement postcmt;
    @FindBy(xpath="//input[@value='Post']")
    public WebElement postbutton;
    //________________DELETE_________________________
    @FindBy(xpath="(//span[@data-original-title='Delete Discussion'])[2]")
    public  WebElement delectIcon;
    @FindBy(xpath = "//button[@class='swal-button swal-button--yes']")
    public WebElement yesbutton;
    //________-------Search________________________
    @FindBy(xpath="//input[@id='id_title']")
    public WebElement titlesearch;
    @FindBy(xpath="//button[contains(.,'Search')]")
    public WebElement searchbtn;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[contains(.,'nava')]")
    public WebElement validatetitle;
    @FindBy(xpath = "//a[contains(.,'remove')]")
    public WebElement removelink;
    @FindBy(xpath="//select[@id='id_status']")
    public WebElement status;
    public DiscussionForum(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void dropdown(WebElement ele, String value){
        Select s=new Select(ele);
        s.selectByValue(value);

    }
    public void navigateToDocumentSection(){
        navigatetocommunicationmodule.click();
        discussion.click();

    }
    public void createNewDiscussion(){
        creatediscussion.click();
        title.sendKeys("Test discussion for dashboard on 05-04-2021");
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        description.sendKeys("add");
        //select_group.click();
        driver.switchTo().defaultContent();
        select_group.click();
        for (WebElement usergroup : usergroups) {
        if (usergroup.getText().equalsIgnoreCase("All Tenants")){
           usergroup.click();
         break;
        }
        }
        choosefile.sendKeys("C:\\Users\\Swati\\Downloads\\download (6).jpg");
        createbutton.click();
        editlink.click();
        title.clear();
        title.sendKeys("New Test title on 05-04-2021");
        //choosefile.sendKeys("C:\\Users\\Swati\\Downloads\\download (7).jpg");
        update.click();
         sendbutton.click();
    }
    public void closeTheTopic(){
        topic.click();
        addcomment.sendKeys("add the comment ");
        closebutton.click();
    }
    public void addCommentInTheDiscussion(){
        titlelink.click();
        postcmt.sendKeys("add the test post comment");
        choosefile.sendKeys("C:\\Users\\Swati\\Downloads\\image.jpg");
        postbutton.click(); }
    public void deleteDisussion(){
        delectIcon.click();
        yesbutton.click();
    }
    public void searchByTitle(){
        titlesearch.sendKeys("nava");
        searchbtn.click();
        Assert.assertEquals("nava",validatetitle.getText());
        System.out.println("pass");
        removelink.click(); }
    public void searchByStatus(){
        dropdown(status,"approved");
        searchbtn.click();
    }

}
