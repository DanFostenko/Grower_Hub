import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyFields {
    WebDriver driver;

    public MyFields(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myFieldsButton = By.xpath("//*[@title='My Fields']");  //locator for 'My Fields' button
    private By addNewFieldButton = By.xpath("//button[@aria-label='Add new field']");  //locator for 'Add New Field' button
    private By importFromGatekeeperButton = By.xpath("//span[text()='Import from Gatekeeper']");  //locator for 'Import from Gatekeeper' button
    private By xButton = By.xpath("//div[text()='Add New Field']/following-sibling::*");  //locator for 'X' (Close) button
    private By farmDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Farm' drop-down
    private By seasonDropDown = By.xpath("//div[@class='growing-season-selection-comp']");  //locator for 'Season' drop-down
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button
    private By uploadNewShapeFilesButton = By.xpath("//button/span[text()='Upload Shape Files']/..");  //locator for 'Upload Shape Files' button
    private By dropZone = By.xpath("//div[starts-with(@class,'dropzone-box')]");    //locator for 'Drag&Drop' zone
    private By fileSelector = By.xpath("//button/span[text()='Choose Files']/..");    //locator for 'Choose Files' zone
    //private By shapeFile =

    public void clickMyFields() {
        driver.findElement(myFieldsButton).click();
    }

    public void clickAddNewField() {
        driver.findElement(addNewFieldButton).click();
        driver.findElement(importFromGatekeeperButton).click();
        driver.findElement(xButton).click();
    }

    public void uploadNewShapeFiles() {
        driver.findElement(addNewFieldButton).click();
        driver.findElement(uploadNewShapeFilesButton).click();
        WebElement uploadElement = driver.findElement(fileSelector);
        uploadElement.sendKeys("C:\\Users\\DanFo\\IdeaProjects\\growerhubtest\\UKFieldShape.zip");
        driver.findElement(fileSelector).click();
        driver.findElement(xButton).click();
    }

    public void clickFarm() {
        driver.findElement(farmDropDown).click();
    }

    public void clickSeason() {
        driver.findElement(seasonDropDown).click();
    }

    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

}