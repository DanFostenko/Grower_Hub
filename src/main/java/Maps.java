import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;

public class Maps {
    WebDriver driver;

    public Maps(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By maps = By.xpath("//*[@title='Maps']");  //locator for 'Maps' button
    private By addMapButton = By.xpath("//div[contains(text(),'get started')]/../button");  //locator for '+' button
    private By soilMapButton = By.xpath("//span[text()='Soil Map']/..");  //locator for 'Soil Map' button
    private By drillMapButton = By.xpath("//span[text()='Drill Map']/..");  //locator for 'Drill Map' button
    private By createMapButton = By.xpath("//button[@label='Create Map']");  //locator for 'Create Map' button
    private By cancelButton = By.xpath("//button[@label='Cancel']");  //locator for 'Cancel' button
    private By fieldSelectionCheckbox = By.xpath("//input[@type='checkbox']");  //locator for 'Field Selection' checkbox
    private By fieldSelectionNextButton = By.xpath("//button[@label='Next']");  //locator for Field Selection 'Next' button
    private By mapRefinementDateFromPicker = By.xpath("//label[text()='Date from']/..");  //locator for Map Refinement 'Date from' button
    private By mapRefinementDateToPicker = By.xpath("//label[text()='Date to']/..");  //locator for Map Refinement 'Date to' button
    private By calendarOkButton = By.xpath("//span[text()='OK']");  //locator for Map Refinement calendar 'OK' button
    private By mapRefinementCreateNewButton = By.xpath("//span[text()='Create new']/..");  //locator for Map Refinement 'Create new' button
    private By mapRefinementNextButton = By.xpath("//span[text()='Next']/..");  //locator for Map Refinement 'Next' button

    public void clickMaps() {
        driver.findElement(maps).click();
        waitObjectLoad(1000);
    }

    public void clickAdd() {
        driver.findElement(addMapButton).click();
        waitObjectLoad(1000);
    }

    public void addSoilMap() {
        clickAdd();
        driver.findElement(soilMapButton).click();
        driver.findElement(createMapButton).click();
        driver.findElement(fieldSelectionCheckbox).click();
        driver.findElement(fieldSelectionNextButton).click();
        driver.findElement(mapRefinementDateFromPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(maps).click();
    }

    public void addDrillMap() {
        clickAdd();
        driver.findElement(drillMapButton).click();
        driver.findElement(createMapButton).click();
        driver.findElement(fieldSelectionCheckbox).click();
        driver.findElement(fieldSelectionNextButton).click();
        driver.findElement(mapRefinementCreateNewButton).click();
        driver.findElement(mapRefinementNextButton).click();
        driver.findElement(mapRefinementDateFromPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(maps).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    public static void waitObjectLoad(int timeout) {
        try {
            Thread.sleep(timeout); //forced timeout to wait for the next object element to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void keyboardRobot(Robot r) {
        r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}