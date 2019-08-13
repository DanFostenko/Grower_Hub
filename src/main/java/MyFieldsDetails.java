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
    private By crop = By.xpath("//th/div/div/div");  //locator for 'Crop' record
    private By cropEdit = By.xpath("//th/div/div/div/div");  //locator for 'Crop' edit
    private By cropInput = By.xpath("//input[value()='Select...']");  //locator for 'Crop' input
    private By variety = By.xpath("//tr/td/div/div/div");  //locator for 'Variety' record
    private By varietyEdit = By.xpath("//tr/td/div/div/div/div");  //locator for 'Variety' edit
    private By varietyInput = By.xpath("//input[value()='Select...']");  //locator for 'Variety' input

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
        driver.findElement(cropInput).sendKeys("Carrot");
        /*Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_C);*/
    }
    public void typeVariety() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(variety)).build().perform();
        driver.findElement(varietyEdit).click();
        driver.findElement(varietyInput).sendKeys("Abaco");
    }

}