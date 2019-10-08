import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Maps {
    WebDriver driver;

    public Maps(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By maps = By.xpath("//*[@title='Maps']");  //locator for 'Maps' button
    //private By addMapButton = By.xpath("//div[contains(text(),'get started')]/../button");  //locator for '+' button
    private By addMapButton = By.xpath("//main/div//./button[@type='button' and @tabindex='0'][last()]");  //locator for '+' button
    private By soilMapButton = By.xpath("//span[text()='Soil Map']/..");  //locator for 'Soil Map' button
    private By drillMapButton = By.xpath("//span[text()='Drill Map']/..");  //locator for 'Drill Map' button
    private By createMapButton = By.xpath("//button[@label='Create Map']");  //locator for 'Create Map' button
    private By cancelButton = By.xpath("//button[@label='Cancel']");  //locator for 'Cancel' button
    private By fieldSelectionCheckbox = By.xpath("//input[@type='checkbox']");  //locator for 'Field Selection' checkbox
    private By fieldSelectionNextButton = By.xpath("//button[@label='Next']");  //locator for Field Selection 'Next' button
    private By mapRefinementDateFromPicker = By.xpath("//label[text()='Date from']/..");  //locator for Map Refinement 'Date from' button
    private By calendarYearPicker = By.xpath("//h6[text()='2019']");  //locator for 2019 year which calls year picker
    private By calendarYear2018Picker = By.xpath("//div[text()='2018']");  //locator for current year which calls year picker
    private By calendarOkButton = By.xpath("//span[text()='OK']");  //locator for Map Refinement calendar 'OK' button
    private By soilMapPreview = By.xpath("//section/div/div/button");  //locator for the first Soil Map preview
    private By mapRefinementDateToPicker = By.xpath("//label[text()='Date to']/..");  //locator for Map Refinement 'Date to' button
    private By mapRefinementCreateSoilMapButton = By.xpath("//span[text()='Create Soil Map']/..");  //locator for Map Refinement 'Create Soil Map' button
    private By mapRefinementCreateNewButton = By.xpath("//span[text()='Create new']/..");  //locator for Map Refinement 'Create new' button
    private By mapRefinementNextButton = By.xpath("//span[text()='Next']/..");  //locator for Map Refinement 'Next' button
    private By mapSoilTexturesList = By.xpath("//div[@class='comp-soil-texture']/../../div");  //locator for Soil Textures drop downs
    private By mapSoilTexturesOption = By.xpath("//div/ul/li[2]");  //locator for the 1st Soil Textures option in drop down
    private By mapSaveButton = By.xpath("//span[text()='Save']/..");  //locator for 'Save' button
    private By mapCreationNextButton = By.xpath("//span[text()='Next, Create Drill Map']/..");  //locator for 'Next, Create Drill Map' button
    private By mapNameField = By.xpath("//label[text()='Map Name']/..");  //locator for 'Map name' field
    private By mapNameTypeField = By.xpath("//label[text()='Map Name']/../div/input");  //locator for 'Map name' field

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
        driver.findElement(calendarYearPicker).click();
        driver.findElement(calendarYear2018Picker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(3000);   //pause for generating satellite images
        driver.findElement(soilMapPreview).click();
        driver.findElement(mapRefinementCreateSoilMapButton).click();
        waitObjectLoad(7000);   //pause for generating contour map
        selectSoilTextures();
        driver.findElement(mapSaveButton).click();
        waitObjectLoad(7000);   //pause for saving settings
        driver.findElement(mapSaveButton).click();
        driver.findElement(mapNameField).click();
        driver.findElement(mapNameTypeField).sendKeys("Soil Map");
        driver.findElement(mapSaveButton).click();
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
        driver.findElement(calendarYear2018Picker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(1000);
        driver.findElement(mapRefinementDateToPicker).click();
        driver.findElement(calendarOkButton).click();
        waitObjectLoad(3000);   //pause for generating satellite images
        driver.findElement(soilMapPreview).click();
        driver.findElement(mapRefinementCreateSoilMapButton).click();
        waitObjectLoad(7000);   //pause for generating contour map
        selectSoilTextures();
        waitObjectLoad(7000);   //pause for saving settings
        driver.findElement(mapCreationNextButton).click();
        driver.findElement(mapNameField).click();
        driver.findElement(mapNameTypeField).sendKeys("Drill Map");
        driver.findElement(mapSaveButton).click();
        //To be continued "Map Creation" step
        driver.findElement(maps).click();
    }

    private void selectSoilTextures() {
        int elementSize = driver.findElements(mapSoilTexturesList).size() + 1;
        for (int i = 1; i < elementSize; i++) {  //go through up to 3 drop downs
            By mapSoilTexturesListBy = By.xpath("\"" + mapSoilTexturesList + "[" + i + "]\"");
            System.out.println(mapSoilTexturesListBy);
            System.out.println(mapSoilTexturesList);
            driver.findElement(mapSoilTexturesListBy).click();
            driver.findElement(mapSoilTexturesOption).click();
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
}