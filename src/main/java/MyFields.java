import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFields {
    WebDriver driver;

    public MyFields(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myFieldsButton = By.xpath("//*[@title='My Fields']");  //locator for 'My Fields' button
    private By addNewFieldButton = By.xpath("//button[@aria-label='Add new field']");  //locator for 'Add New Field' button
    private By importFromGatekeeperButton = By.xpath("//span[text()='Import from Gatekeeper']");  //locator for 'Import from Gatekeeper' button
    private By xButton = By.xpath("//*[@id='app']/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]");  //locator for 'Import from Gatekeeper' button
    private By farmDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Farm' drop-down
    private By seasonDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Season' drop-down
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

    public void clickMyFields() {
        driver.findElement(myFieldsButton).click();
    }

    public void clickAddNewField() {
        driver.findElement(addNewFieldButton).click();
        driver.findElement(importFromGatekeeperButton).click();
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