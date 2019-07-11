import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFields {
    WebDriver driver;

    public MyFields(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By myFieldsButton = By.xpath("//*[@title='My Fields']");  //locator for 'My Fields' button
    private By farmDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Farm' drop-down
    private By seasonDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Season' drop-down
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

    public void clickMyFields() {
        driver.findElement(myFieldsButton).click();
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