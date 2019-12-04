import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Calendar;

public class Maps {
    WebDriver driver;

    public Maps(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By maps = By.xpath("//*[@title='Maps']");  //locator for 'Maps' button
    //private By addMapButton = By.xpath("//div[contains(text(),'get started')]/../button");  //locator for '+' button
    private By addMapButton = By.xpath("//*[name()='svg']/../../button");  //universal locator for '+' button
    //private By soilMapButton = By.xpath("//span[text()='Soil Map']/..");  //locator for 'Soil Map' button
    private By soilMapButton = By.xpath("//div[text()='Select Map Type']/../div[2]/div/div/button/span[text()='Soil Map']/..");  //locator for 'Soil Map' button
    //private By drillMapButton = By.xpath("//span[text()='Drill Map']/..");  //locator for 'Drill Map' button
    private By drillMapButton = By.xpath("//div[text()='Select Map Type']/../div[2]/div/div/button/span[text()='Drill Map']/..");  //locator for 'Drill Map' button
    private By createMapButton = By.xpath("//button[@label='Create Map']");  //locator for 'Create Map' button
    private By cancelButton = By.xpath("//button[@label='Cancel']");  //locator for 'Cancel' button
    private By fieldSelectionCheckbox = By.xpath("//input[@type='checkbox']");  //locator for 'Field Selection' checkbox
    private By fieldSelectionNextButton = By.xpath("//button[@label='Next']");  //locator for Field Selection 'Next' button
    private By mapRefinementDateFromPicker = By.xpath("//label[text()='Date from']/..");  //locator for Map Refinement 'Date from' button
    private By calendarYearPicker = By.xpath("//h6[text()='2019']");  //locator for 2019 year which calls year picker
    private By calendarYear2019Picker = By.xpath("//div[text()='2019']");  //locator for current year which calls year picker
    private By calendarOkButton = By.xpath("//span[text()='OK']");  //locator for Map Refinement calendar 'OK' button
    private By soilMapPreview = By.xpath("//section/div/div/button");  //locator for the first Soil Map preview
    private By mapRefinementDateToPicker = By.xpath("//label[text()='Date to']/..");  //locator for Map Refinement 'Date to' button
    private By mapRefinementCreateSoilMapButton = By.xpath("//span[text()='Create Soil Map']/..");  //locator for Map Refinement 'Create Soil Map' button
    private By mapRefinementCreateNewButton = By.xpath("//span[text()='Create new']/..");  //locator for Map Refinement 'Create new' button
    private By mapRefinementNextButton = By.xpath("//span[text()='Next']/..");  //locator for Map Refinement 'Next' button
    private By mapSoilTexturesList = By.xpath("//div[@class='comp-soil-texture']/../../div");  //locator for Soil Textures drop downs
    private By mapSoilTexturesOption = By.xpath("//div/ul/li[2]");  //locator for the 1st Soil Textures option in drop down
    private By mapSaveButton = By.xpath("//span[text()='Save']/..");  //locator for 'Save' button, universal "//span[starts-with(text(),'Save')]/.."
    private By mapSaveYourMapButton = By.xpath("//button[@label='Save']");  //locator for 'Save' button in 'Save Your Map' window
    private By mapCreationNextButton = By.xpath("//span[text()='Next, Create Drill Map']/..");  //locator for 'Next, Create Drill Map' button
    private By mapCreationDrillTypeDropdown = By.xpath("//label[text()='Drill Type']/../div/div");  //locator for 'Drill Type' dropdown
    private By mapCreationDrillTypeOption = By.xpath("//li[text()='Direct-Drill']");  //locator for 'Direct-Drill' option in 'Drill Type' dropdown
    private By mapCreationCultivationTypeDropdown = By.xpath("//label[text()='Cultivation Type']/../div/div");  //locator for 'Cultivation Type' dropdown
    private By mapCreationCultivationTypeOption = By.xpath("//li[text()='Inversion']");  //locator for 'Inversion' option in 'Cultivation Type' dropdown
    private By mapCreationApplicationRate = By.xpath("//h4[text()='Application Rate (seeds/sq.m)']");  //locator for 'Application Rate (seeds/sq.m)' area
    private By mapCreationApplicationRateValue = By.xpath("//input[@value='0']");  //locator for '0' value of Application Rate (seeds/sq.m)
    //private By mapCreationApplicationRateValue = By.xpath("//input[@value='0']");  //locator for '0' value of Application Rate (seeds/sq.m)
    private By mapSaveDrillButton = By.xpath("//span[text()='Save Drill Map']");  //locator for 'Save Drill Map' button
    private By mapNameField = By.xpath("//label[text()='Map Name']/..");  //locator for 'Map name' field
    private By mapNameTypeField = By.xpath("//label[text()='Map Name']/../div/input");  //locator for 'Map name' field


    public void clickMaps() {
        driver.findElement(maps).click();
        waitObjectLoad(500);
    }

    public void clickAdd() {
        driver.findElement(addMapButton).click();
        waitObjectLoad(500);
    }

    public void addSoilMap() {
        clickAdd();
        driver.findElement(soilMapButton).click();
        driver.findElement(createMapButton).click();
        driver.findElement(fieldSelectionCheckbox).click();
        driver.findElement(fieldSelectionNextButton).click();
        driver.findElement(mapRefinementDateFromPicker).click();
        driver.findElement(calendarYearPicker).click();
        driver.findElement(calendarYear2019Picker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);   //pause for closing modal window
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(4000);   //pause for generating satellite images
        driver.findElement(soilMapPreview).click();
        driver.findElement(mapRefinementCreateSoilMapButton).click();
        selectSoilTextures();
        driver.findElement(mapSaveButton).click();
        driver.findElement(mapNameField).click();   //click on to activate editing
        driver.findElement(mapNameTypeField).sendKeys("Soil Map " + Calendar.getInstance().getTime());
        driver.findElement(mapSaveYourMapButton).click(); //focus ON
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
        driver.findElement(calendarYearPicker).click();
        driver.findElement(calendarYear2019Picker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(4000);   //pause for generating satellite images
        driver.findElement(soilMapPreview).click();
        driver.findElement(mapRefinementCreateSoilMapButton).click();
        //waitObjectLoad(7000);   //pause for generating contour map
        selectSoilTextures();
        //waitObjectLoad(7000);   //pause for saving settings
        driver.findElement(mapCreationNextButton).click();
        driver.findElement(mapNameField).click();   //click on to activate editing
        driver.findElement(mapNameTypeField).sendKeys("Drill Map" + Calendar.getInstance().getTime());
        driver.findElement(mapSaveYourMapButton).click();
        driver.findElement(mapCreationDrillTypeDropdown).click();
        driver.findElement(mapCreationDrillTypeOption).click();
        waitObjectLoad(1000);   //pause for appending values
        driver.findElement(mapCreationCultivationTypeDropdown).click();
        waitObjectLoad(1000);   //pause for appending values
        driver.findElement(mapCreationCultivationTypeOption).click();
        waitObjectLoad(1000);   //pause for appending values
        driver.findElement(mapCreationApplicationRateValue).click();
        driver.findElement(mapCreationApplicationRateValue).sendKeys("1");
        driver.findElement(mapCreationApplicationRate).click(); //click on the area to shift the focus from dropdown
        driver.findElement(mapSaveDrillButton).click();
        driver.findElement(mapNameField).click();   //click on to activate editing
        driver.findElement(mapNameTypeField).sendKeys("Soil Map " + Calendar.getInstance().getTime());
        driver.findElement(mapSaveYourMapButton).click();
        waitObjectLoad(1000);
        driver.findElement(maps).click();
    }

    private void selectSoilTextures() {
        int elementSize = driver.findElements(mapSoilTexturesList).size() + 1;
        for (int i = 1; i < elementSize; i++) {  //go through up to 3 drop downs
            //By mapSoilTexturesListBy = By.xpath("\"" + mapSoilTexturesList + "[" + i + "]\"");
            By mapSoilTexturesListBy = By.xpath("//div[@class='comp-soil-texture']/../../div[" + i + "]");
            //System.out.println(mapSoilTexturesListBy);
            driver.findElement(mapSoilTexturesListBy).click();
            waitObjectLoad(500);   //pause for appending values
            driver.findElement(mapSoilTexturesOption).click();
            waitObjectLoad(500);   //pause for appending values
        }
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

    public static void refreshPage() {
        try {
            Robot r = null;
            try {
                r = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_F5);  r.keyRelease(KeyEvent.VK_F5);
            r.keyRelease(KeyEvent.VK_CONTROL);
        } finally{};
    }

}