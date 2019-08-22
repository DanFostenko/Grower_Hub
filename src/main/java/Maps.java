import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Maps {
    WebDriver driver;

    public Maps(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By maps = By.xpath("//*[@title='Maps']");  //locator for 'Maps' button
    private By plusButton = By.xpath("//div[contains(text(),'get started')]/../button");  //locator for '+' button
    private By soilMapButton = By.xpath("//span[text()='Soil Map']/..");  //locator for 'Soil Map' button
    private By drillMapButton = By.xpath("//span[text()='Drill Map']/..");  //locator for 'Drill Map' button
    private By cancelButton = By.xpath("//button[@label='Cancel']");  //locator for 'Cancel' button

    public void clickMaps() {
        driver.findElement(maps).click();
    }
    public void clickAdd() {
        driver.findElement(plusButton).click();
    }
    public void clickSoilMap() {
        driver.findElement(soilMapButton).click();
    }
    public void clickDrillMap() {
        driver.findElement(drillMapButton).click();
    }
    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

}