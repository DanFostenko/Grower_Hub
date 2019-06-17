import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NDVI {
    WebDriver driver;

    public NDVI(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By nDVI = By.xpath("//*[@title='NDVI']");  //locator for 'NDVI' button
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

    public void clickNDVI() {
        driver.findElement(nDVI).click();
    }
    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

}