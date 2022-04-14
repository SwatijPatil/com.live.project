package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Testbase {
    @FindBy(xpath = "(//span[@class='xn-text'][contains(.,'Manage Society')])[1]")
    public WebElement managesociety;

    public Homepage(WebDriver driver) {
    }
}
