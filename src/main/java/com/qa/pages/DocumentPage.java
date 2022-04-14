package com.qa.pages;

import javafx.beans.value.WeakChangeListener;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DocumentPage {
    public WebDriver driver;
    @FindBy(xpath="//p[contains(.,'Documents')]")
    public WebElement documentmodule;
    @FindBy(xpath="//a[contains(.,'New Document')]")
    public WebElement newdoclink;
    @FindBy(xpath = "//input[@id='id_upload_file']")
    public WebElement chooseFile;
    @FindBy(xpath="//input[@name='description[]']")
    public WebElement description;
    @FindBy(xpath="//button[contains(.,'Add More Docs')]")
    public WebElement addmorebutton;
    @FindBy(xpath="//input[@id='id_document_type_1']")
    public WebElement managementtype_doc;
    @FindBy(xpath="//button[contains(.,'Save')]")
    public WebElement savebutton;
    @FindBy(xpath = "//input[@id='id_document_type_2']")
    public WebElement personaltypedoc;
    @FindBy(xpath="//input[@id='id_document_type_0']")
    public WebElement societytypedocument;
    @FindBy(xpath="//input[@id='id_document_type_3']")
    public WebElement flat_type_doc;
    @FindBy(xpath="//ul[@class='select2-selection__rendered']")
    public WebElement list;
    @FindBy(xpath="(//input[@id='id_upload_file'])[2]")
    public WebElement secdoc;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public List<WebElement> groups;
    //@FindBy(xpath="//ul[@class='select2-results__options']")
    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    public WebElement selecthouse;
    @FindBy(xpath="//li[@class='select2-results__option']")
    public List<WebElement> housenumbers;
//__________________________________EDIT______________________________________________________________
    @FindBy(xpath="(//a[contains(.,'Edit')])[1]")
    public WebElement editlink;
    @FindBy(xpath="//input[@id='id_name']")
    public WebElement namefield;
    @FindBy(xpath="//textarea[@id='id_description']")
    public WebElement editdesc;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement updatebutton;
    //_______________________Delete ___________________
    @FindBy(xpath="(//a[contains(.,'Delete')])[3]")
    public WebElement deleteLink;
    @FindBy(xpath="//button[@class='swal-button swal-button--yes']")
    public WebElement yesbutton;
    @FindBy(xpath="//input[@id='id_name']")
    public WebElement searchfield;
    @FindBy(xpath="//button[contains(.,'Search')]")
    public WebElement searchbutton;
    @FindBy(xpath="//a[contains(.,'Cancel')]")
     public WebElement cancellink;
    @FindBy(xpath="//a[contains(.,'New Folder')]")
    public WebElement newdoc;
    @FindBy(xpath = "//input[@id='folder_name_input']")
    public WebElement foldername;
   @FindBy(xpath="(//button[contains(.,'Submit')])[1]")
   public WebElement docsubmitbutton;
   @FindBy(xpath="//select[@id='folder_type_select']")
   public WebElement doctype;
    public void typeDrpDown(WebElement ele, String value){
       Select s=new Select(ele);
       s.selectByValue(value);
   }
   public DocumentPage(WebDriver driver){
        PageFactory.initElements(driver, this); }
    public void addMangementTypeOfDocument(){
        documentmodule.click();
        newdoclink.click();
        chooseFile.sendKeys("C:\\Users\\Swati\\Downloads\\image.jpg");
        description.sendKeys("add description @@@");
        addmorebutton.click();
        secdoc.sendKeys("C:\\Users\\Swati\\Downloads\\images (3).jpg");
        description.sendKeys("new ");
        managementtype_doc.click();
        savebutton.click();
    }
    public void addPersonalTypeDocument(){
        documentmodule.click();
        newdoclink.click();
        chooseFile.sendKeys("C:\\Users\\Swati\\Downloads\\images (3).jpg");
        personaltypedoc.click();
        savebutton.click();
    }
    public void addSocietyTypeDocument(){
        documentmodule.click();
        newdoclink.click();
        chooseFile.sendKeys("C:\\Users\\Swati\\Downloads\\images (4).jpg");
        societytypedocument.click();
        list.click();
        for (WebElement group:groups) {
            System.out.println(group.getText());
            if (group.getText().equalsIgnoreCase("All tenants")){
                group.click();
                break;
            }
        }
        savebutton.click(); }
    public void addflatTypeDocument(){
        documentmodule.click();
        newdoclink.click();
        chooseFile.sendKeys("C:\\Users\\Swati\\Downloads\\download (1).jpg");
        description.sendKeys("add flat type document ");
        flat_type_doc.click();
        selecthouse.click();
        for (WebElement housenum:housenumbers) {
            if(housenum.getText().equalsIgnoreCase("A-4")){
                housenum.click();
                break;
            }
        }
        savebutton.click();

    }
    public void editPersonalTypeDocument(){
        documentmodule.click();
       editlink.click();
       namefield.clear();
       namefield.sendKeys("test one ");
       editdesc.sendKeys("edit the des and add new des");
       chooseFile.sendKeys("C:\\Users\\Swati\\Downloads\\download (6).jpg");
       updatebutton.click();

    }
    public void deletePersonalTypedocument(){
        documentmodule.click();
        deleteLink.click();
        yesbutton.click();
    }
    public void searchDocumentUsingName(){
        documentmodule.click();
       searchfield.sendKeys("test");
       searchbutton.click();
       cancellink.click();
    }
    public void addNewDoc(){
       // documentmodule.click();
        newdoc.click();
        //foldername.sendKeys("personal type document ");
        //typeDrpDown(doctype," Personal");
       // docsubmitbutton.click();
        //newdoc.click();
        foldername.sendKeys("society type document");
        typeDrpDown(doctype, "Society");
        docsubmitbutton.click();



    }


}
