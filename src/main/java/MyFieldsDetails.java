import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}