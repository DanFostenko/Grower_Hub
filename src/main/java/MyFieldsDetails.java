import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyFieldsDetails {
    WebDriver driver;

    public MyFieldsDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Tabs
    private By fieldDetails = By.xpath("//span[text()='Field Details']");  //locator for 'Field Details' tab in single-field view
    private By farmView = By.xpath("//a[text()='My Fields']");  //locator for 'My Fields' link in Farm view
    private By fieldOverview = By.xpath("//span[text()='Field Overview']");  //locator for 'Crop Overview' tab
    private By farmDetails = By.xpath("//span[text()='Farm Details']");  //locator for 'Farm Details' tab
    private By operations = By.xpath("//span[text()='Operations']");  //locator for 'Operations' tab
    private By cropRotation = By.xpath("//span[text()='Crop Rotation']");  //locator for 'Crop Rotation' tab
    private By importHistory = By.xpath("//span[text()='Import History']");  //locator for 'Import History' tab
    //Crop Overview tab elements
    private By crop = By.xpath("//tbody/tr/th/div");  //locator for 'Crop' record
    private By cropEdit = By.xpath("//tbody/tr/th/div/div/div/div/div");  //locator for 'Crop' edit
    //private By cropInput = By.xpath("//p[text()='Select...']/..");  //locator for 'Crop' input
    private By option = By.xpath("//div[@role='option']");  //locator for context menu automatic option
    private By variety = By.xpath("//tbody/tr/td[2]/div");  //locator for 'Variety' record
    private By varietyEdit = By.xpath("//tbody/tr/td[2]/div/div/div/div/div");  //locator for 'Variety' edit
    private By fieldName = By.xpath("//tbody/tr/td[3]/div");  //locator for 'Field (N°)' record
    private By fieldNameEdit = By.xpath("//tbody/tr/td[3]/div/div/div/div");  //locator for 'Field (N°)' edit
    private By fieldNameInput = By.id("fieldLabel");  //locator for 'Field (N°)' input
    private By soilType = By.xpath("//tbody/tr/td[4]/div");  //locator for 'Soil Type' record
    private By soilTypeEdit = By.xpath("//tbody/tr/td[4]/div/div/div/div/div");  //locator for 'Soil Type' edit
    private By drillDate = By.xpath("//tbody/tr/td[6]/div");  //locator for 'Drill Date' record
    private By drillDateEdit = By.xpath("//tbody/tr/td[6]/div/div/div/div");  //locator for 'Drill Date' edit
    private By drillDateOKButton = By.xpath("//span[text()='OK']");  //locator for 'Drill Date' calendar 'OK' button
    private By tableViewToggle = By.xpath("//span[text()='Table View']/..");  //locator for 'Table View' toggle
    private By gridViewToggle = By.xpath("//span[text()='Grid View']/..");  //locator for 'Grid View' toggle
    private By selectorRadioButton = By.xpath("//span[text()='Table View']/../../../div[1]");  //locator for selector radio button
    private By paginationList = By.xpath("//span[text()='Rows per page:']/../div[2]");  //locator for pagination list
    private By paginationButtons = By.xpath("//span[text()='Rows per page:']/../div[3]");  //locator for pagination buttons
    private By addFieldButton = By.xpath("//span[text()='Table View']/../../../../div[2]/div/button");  //locator for "+" add field button
    //Farm Details tab elements
    private By farmLocationGroup = By.xpath("//div[@class='comp-farm-location']");  //locator for "Farm Location" group
    private By farmDetailsGroup = By.xpath("//h6[text()='Farm Details']");  //locator for "Farm Location" group
    private By farmOverviewGroup = By.xpath("//div[@class='comp-farm-area']");  //locator for "Farm Overview" group
    private By cropOverviewGroup = By.xpath("//div[@class='comp-crop-overview']");  //locator for "Crop Overview" group
    //Operations tab elements
    private By listViewToggle = By.xpath("//span[text()='List View']/..");  //locator for 'List View' toggle
    private By boardViewToggle = By.xpath("//span[text()='Board View']/..");  //locator for 'Board View' toggle
    private By groupByDropDown = By.xpath("//span[text()='Group by']");  //locator for "Group by" dropdown menu
    private By addOperationButton = By.xpath("//span[text()='List View']/../../../../../div[4]");  //locator for "+" add operation button
    private By plantingFilter = By.xpath("//span[text()='Planting']");  //locator for "Planting" filter button
    private By cropProtectionFilter = By.xpath("//span[text()='Crop protection']");  //locator for "Crop Protection" filter button
    private By nutritionFilter = By.xpath("//span[text()='Nutrition']");  //locator for "Nutrition" filter button
    private By harvestFilter = By.xpath("//span[text()='Harvest']");  //locator for "Harvest" filter button
    //Crop Rotation tab elements
    private By cropAreaChart = By.xpath("//div[@class='column-area-by-crop-chart']");  //locator for "Area by Crop (ha)" chart

    //Methods
    public void clickFieldDetails() {
        driver.findElement(fieldDetails).click();
    }

    public void clickMyFieldsFarmView() {
        driver.findElement(farmView).click();
    }

    public void clickFieldOverview() {
        driver.findElement(fieldOverview).click();
        driver.findElement(selectorRadioButton).click();    //check radio
        driver.findElement(selectorRadioButton).click();    //uncheck radio
        driver.findElement(gridViewToggle).click();
        driver.findElement(tableViewToggle).click();
        elementExists(paginationList);
        elementExists(paginationButtons);
        elementExists(addFieldButton);
    }

    public void clickFarmDetails() {
        driver.findElement(farmDetails).click();
        elementExists(farmLocationGroup);
        elementExists(farmDetailsGroup);
        elementExists(farmOverviewGroup);
        elementExists(cropOverviewGroup);
    }

    public void clickOperations() {
        driver.findElement(operations).click();
        driver.findElement(boardViewToggle).click();
        driver.findElement(listViewToggle).click();
        elementExists(plantingFilter);
        elementExists(cropProtectionFilter);
        elementExists(nutritionFilter);
        elementExists(harvestFilter);
        elementExists(groupByDropDown);
        elementExists(addOperationButton);
    }

    public void clickCropRotation() {
        driver.findElement(cropRotation).click();
        elementExists(paginationList);
        elementExists(paginationButtons);
        elementExists(cropAreaChart);
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
        Maps.waitObjectLoad(1000);  //forced timeout to complete renaming
        driver.findElement(fieldNameEdit).click();
        driver.findElement(fieldNameInput).sendKeys("Field Name X");
    }

    public void typeSoilType() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(soilType)).build().perform();
        driver.findElement(soilTypeEdit).click();
        Maps.waitObjectLoad(1000); //forced timeout to complete the action
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_P);  r.keyPress(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_A);  r.keyPress(KeyEvent.VK_T);
        Maps.waitObjectLoad(1000); //forced timeout to give some time to return the options
        driver.findElement(option).click();
    }

    public void typeDrillDate() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(drillDate)).build().perform();
        driver.findElement(drillDateEdit).click();
        Maps.waitObjectLoad(1000);  //forced timeout to close the calendar
        driver.findElement(drillDateOKButton).click();
        Maps.waitObjectLoad(1000);  //forced timeout to close the calendar
    }

    public boolean elementExists(By xpath) {
        try {
            driver.findElement(xpath);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}