package com.qa.pages;

import com.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PrepaidMeterPage extends Testbase {
    @FindBy(xpath = "//span[contains(.,'Accounts')]")
    public WebElement account;
    @FindBy(xpath="//p[contains(.,'Utility Meter')]")
    public WebElement utilityMeter;
    @FindBy(xpath = "//button[contains(.,'Add New Meter Charges')]")
    public WebElement addNewMeterCharges;
    @FindBy(id="meternamelistcharge")
    public WebElement meterName;//24
    @FindBy(id="input_ecb_unit_charge")
    public WebElement ECCharges;
    @FindBy(id="input_dg_unit_charge")
    public WebElement DcCharges;
    @FindBy(id="input_applicable_from")
    public WebElement calendar;
    @FindBy(xpath = "(//table[@class='table-condensed'])[1]")
    public WebElement calendarTable;
    @FindBy(xpath = "//table[@class='table-condensed']/thead/tr[2]/th[contains(.,'April')]")
    public WebElement monthYear;
    @FindBy(xpath = "//button[@id='update_settings']")
    public WebElement createButton;

    public PrepaidMeterPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void doSelectDropDown(WebElement ele, String value){
        Select s =new Select(ele);
        s.selectByValue(value);

    }
 public void doSelectDate(){
     calendar.click();
     calendarTable.click();
     while(!(monthYear.getText().split(" ")[0].equalsIgnoreCase("May")&&
             monthYear.getText().split(" ")[1].equalsIgnoreCase("2022"))){
         driver.findElement(By.xpath("(//table[@class='table-condensed']/thead/tr[2]/th[@class='next'])[1]")).click();
     }
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//table[@class='table-condensed']/tbody/tr[4]/td[1]")).click();
 }
 public void doNavigate(){
     account.click();
     utilityMeter.click();
 }
 public void addNewCharges() {
     addNewMeterCharges.click();
     doSelectDropDown(meterName, "24");
     ECCharges.sendKeys("1.56");
     DcCharges.sendKeys("2.5");
     doSelectDate();
 }


}
