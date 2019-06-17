import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFields {
    WebDriver driver;

    public MyFields(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By myFieldsButton = By.xpath("//*[@title='My Fields']");  //locator for 'My Fields' button
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

    public void clickMyFields() {
        driver.findElement(myFieldsButton).click();
    }
    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

}