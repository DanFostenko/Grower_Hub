import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
    private By cropEdit = By.xpath("//tbody/tr/th/div/div/div/div");  //locator for 'Crop' edit
    //private By cropInput = By.xpath("//p[text()='Select...']/..");  //locator for 'Crop' input
    private By option = By.xpath("//div[@role='option']");  //locator for context menu automatic option
    private By variety = By.xpath("//tbody/tr/td[2]/div");  //locator for 'Variety' record
    private By varietyEdit = By.xpath("//tbody/tr/td[2]/div/div/div/div");  //locator for 'Variety' edit
    private By fieldName = By.xpath("//tbody/tr/td[3]/div");  //locator for 'Field (N°)' record
    private By fieldNameEdit = By.xpath("//tbody/tr/td[3]/div/div/div/div");  //locator for 'Field (N°)' edit
    private By fieldNameInput = By.id("fieldLabel");  //locator for 'Field (N°)' input
    private By soilType = By.xpath("//tbody/tr/td[4]/div");  //locator for 'Soil Type' record
    private By soilTypeEdit = By.xpath("//tbody/tr/td[4]/div/div/div/div");  //locator for 'Soil Type' edit
    private By drillDate = By.xpath("//tbody/tr/td[6]/div");  //locator for 'Drill Date' record
    private By drillDateEdit = By.xpath("//tbody/tr/td[6]/div/div/div/div");  //locator for 'Drill Date' edit
    private By drillDateOKButton = By.xpath("//span[text()='OK']");  //locator for 'Drill Date' calendar 'OK' button

    //Methods
    public void clickFieldDetails() {
        driver.findElement(fieldDetails).click();
    }
    public void clickMyFieldsFarmView() {
        driver.findElement(farmView).click();
    }
    public void clickCropOverview() {
        driver.findElement(cropOverview).click();
    }
    public void clickFarmDetails() {
        driver.findElement(farmDetails).click();
    }
    public void clickOperations() {
        driver.findElement(operations).click();
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
        driver.findElement(fieldNameEdit).click();
        driver.findElement(fieldNameInput).sendKeys("Field Name X");
        try {
            Thread.sleep(1000); //forced timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void typeSoilType() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(soilType)).build().perform();
        driver.findElement(soilTypeEdit).click();
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_H);  r.keyPress(KeyEvent.VK_U);  r.keyPress(KeyEvent.VK_M);
        driver.findElement(option).click();
    }
    public void typeDrillDate() {
        try {
            Thread.sleep(1000); //forced timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(drillDate)).build().perform();
        driver.findElement(drillDateEdit).click();
        try {
            Thread.sleep(1000); //forced timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(drillDateOKButton).click();
    }
}