package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurveyPage extends Testbase {
    @FindBy(xpath="//span[contains(.,'Communications')]")
    public WebElement communications;
    @FindBy(xpath = "//p[contains(.,'Survey')]")
    public WebElement survey;
    @FindBy(xpath="//button[contains(.,'Create New')]")
    public WebElement createNewButton;
    @FindBy(id="subject")
    public WebElement subject;

    public void doNvaigateToSurvey(){
        communications.click();
        survey.click();
    }
    public void createNewSurvey(){
        createNewButton.click();
        subject.sendKeys("add test subject ");




    }

}
