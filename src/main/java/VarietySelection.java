import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VarietySelection {
    WebDriver driver;

    public VarietySelection(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By varietySelection = By.xpath("//*[@title='Variety Selection']/..");  //locator for 'Variety Selection' button
    private By wizard = By.xpath("//span[text()='VARIETY SELECTION']");  //locator for 'VARIETY SELECTION' button
    private By springWheatButton = By.xpath("//button/span[text()='Spring Wheat']");  //locator for 'Spring Wheat' button
    private By winterWheatButton = By.xpath("//button/span[text()='Winter Wheat']");  //locator for 'Winter Wheat' button
    private By springBarleyButton = By.xpath("//button/span[text()='Spring Barley']");  //locator for 'Spring Barley' button
    private By winterBarleyButton = By.xpath("//button/span[text()='Winter Barley']");  //locator for 'Winter Barley' button
    private By varietyAZ = By.xpath("//button/span[text()='VARIETIES A TO Z']");  //locator for 'Varieties A to Z' button

    public void clickVarietySelection() {
        driver.findElement(varietySelection).click();
    }
    public void clickWizard() {
        driver.findElement(wizard).click();
        driver.findElement(springWheatButton).click();
        driver.findElement(winterWheatButton).click();
        driver.findElement(springBarleyButton).click();
        driver.findElement(winterBarleyButton).click();
    }
    public void clickVarietyAZ() {
        driver.findElement(varietySelection).click();
        driver.findElement(varietyAZ).click();
    }
}