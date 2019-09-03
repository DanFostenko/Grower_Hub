import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.TabableView;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyFieldsDetails {
    WebDriver driver;

    public MyFieldsDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By fieldDetails = By.xpath("//span[text()='Field Details']");  //locator for 'Field Details' tab in single-field view
    private By farmView = By.xpath("//a[text()='My Fields']");  //locator for 'My Fields' link in Farm view
    private By cropOverview = By.xpath("//span[text()='Crop Overview']");  //locator for 'Crop Overview' tab
    private By farmDetails = By.xpath("//span[text()='Farm Details']");  //locator for 'Farm Details' tab
    private By operations = By.xpath("//span[text()='Operations']");  //locator for 'Operations' tab
    private By importHistory = By.xpath("//span[text()='Import History']");  //locator for 'Import History' tab
    private By crop = By.xpath("//tbody/tr/th/div");  //locator for 'Crop' record
    private By cropEdit = By.xpath("//tbody/tr/th/div/div/div/div/div");  //locator for 'Crop' edit
    //private By cropInput = By.xpath("//p[text()='Select...']/..");  //locator for 'Crop' input
    private By option = By.xpath("//div[@role='option']");  //locator for context menu automatic option
    private By variety = By.xpath("//tbody/tr/td[2]/div");  //locator for 'Variety' record
    private By varietyEdit = By.xpath("//tbody/tr/td[2]/div/div/div/div/div");  //locator for 'Variety' edit
    private By fieldName = By.xpath("//tbody/tr/td[3]/div");  //locator for 'Field (N°)' record
    private By fieldNameEdit = By.xpath("//tbody/tr/td[3]/div/div/div/div");  //locator for 'Field (N°)' edit
    private By fieldNameInput = By.id("fieldLabel");  //locator for 'Field (N°)' input
    private By soilType = By.xpath("//tbody/tr/td[4]/div");  //locator for 'Soil Type' record
    private By soilTypeEdit = By.xpath("//tbody/tr/td[4]/div/div/div/div/div");  //locator for 'Soil Type' edit
    private By drillDate = By.xpath("//tbody/tr/td[6]/div");  //locator for 'Drill Date' record
    private By drillDateEdit = By.xpath("//tbody/tr/td[6]/div/div/div/div");  //locator for 'Drill Date' edit
    private By drillDateOKButton = By.xpath("//span[text()='OK']");  //locator for 'Drill Date' calendar 'OK' button
    private By listViewToggle = By.xpath("//span[text()='List View']/..");  //locator for 'List View' toggle
    private By boardViewToggle = By.xpath("//span[text()='Board View']/..");  //locator for 'Board View' toggle
    private By tableViewToggle = By.xpath("//span[text()='Table View']/..");  //locator for 'Table View' toggle
    private By gridViewToggle = By.xpath("//span[text()='Table View']/..");  //locator for 'Grid View' toggle

    //Methods
    public void clickFieldDetails() {
        driver.findElement(fieldDetails).click();
    }
    public void clickMyFieldsFarmView() {
        driver.findElement(farmView).click();
    }
    public void clickCropOverview() {
        driver.findElement(cropOverview).click();
        driver.findElement(gridViewToggle).click();
        driver.findElement(tableViewToggle).click();
    }
    public void clickFarmDetails() {
        driver.findElement(farmDetails).click();
    }
    public void clickOperations() {
        driver.findElement(operations).click();
        driver.findElement(boardViewToggle).click();
        driver.findElement(listViewToggle).click();
    }
    public void clickImportHistory() {
        driver.findElement(importHistory).click();
    }
    public void typeCrop() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(crop)).build().perform();
        driver.findElement(cropEdit).click();
        //driver.findElement(cropInput).sendKeys("Carrot");
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_C);  r.keyPress(KeyEvent.VK_A);  r.keyPress(KeyEvent.VK_R);
        driver.findElement(option).click();
    }
    public void typeVariety() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(variety)).build().perform();
        driver.findElement(varietyEdit).click();
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_A);  r.keyPress(KeyEvent.VK_B);
        driver.findElement(option).click();
    }
    public void typeFieldName() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(fieldName)).build().perform();
        try {
            driver.findElement(fieldNameEdit).click();
            driver.findElement(fieldNameInput).sendKeys("Field Name X");
            Thread.sleep(1000); //forced timeout to complete renaming
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void typeSoilType() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(soilType)).build().perform();
        try {
            Thread.sleep(1000); //forced timeout to complete the action
            driver.findElement(soilTypeEdit).click();
            Robot r = null;
            try {
                r = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            r.keyPress(KeyEvent.VK_P);  r.keyPress(KeyEvent.VK_E);
            r.keyPress(KeyEvent.VK_A);  r.keyPress(KeyEvent.VK_T);
            Thread.sleep(1000); //forced timeout to give some time to return the options
            driver.findElement(option).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void typeDrillDate() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(drillDate)).build().perform();
        try {
            Thread.sleep(1000); //forced timeout
            driver.findElement(drillDateEdit).click();
            Thread.sleep(2000); //forced timeout
            driver.findElement(drillDateOKButton).click();
            Thread.sleep(1000); //forced timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}