import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFieldsDetails {
    WebDriver driver;

    public MyFieldsDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By cropOverview = By.xpath("//span[text()='Crop Overview']");  //locator for 'Crop Overview' tab
    private By farmDetails = By.xpath("//span[text()='Farm Details']");  //locator for 'Farm Details' tab
    private By operations = By.xpath("//span[text()='Operations']");  //locator for 'Operations' tab
    private By importHistory = By.xpath("//span[text()='Import History']");  //locator for 'Import History' tab

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