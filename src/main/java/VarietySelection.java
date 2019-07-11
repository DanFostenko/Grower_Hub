import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VarietySelection {
    WebDriver driver;

    public VarietySelection(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By varietySelection = By.xpath("//*[@title='Variety Selection']");  //locator for 'Variety Selection' button
    private By wizard = By.xpath("//span[text()='VARIETY SELECTION']");  //locator for 'VARIETY SELECTION' button
    private By varietyAZ = By.xpath("//span[text()='Varieties A to Z']");  //locator for 'Varieties A to Z' tab

    public void clickVarietySelection() {
        driver.findElement(varietySelection).click();
    }
    public void clickWizard() {
        driver.findElement(wizard).click();
    }
    public void clickVarietyAZ() {
        driver.findElement(varietyAZ).click();
    }
}