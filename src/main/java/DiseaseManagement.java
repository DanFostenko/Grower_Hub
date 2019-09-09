import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiseaseManagement {
    WebDriver driver;

    public DiseaseManagement(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By diseaseManagement = By.xpath("//*[@title='Disease Management']");  //locator for 'Disease Management' button
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

    public void clickDiseaseManagement() {
        driver.findElement(diseaseManagement).click();
    }

    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

}