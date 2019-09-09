import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NDVIDetails {
    WebDriver driver;

    public NDVIDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By nDVIOVerview = By.xpath("//span[text()='NDVI Overview']");  //locator for 'NDVI Overview' tab

    public void clickNDVIOverview() {
        driver.findElement(nDVIOVerview).click();
    }

}
