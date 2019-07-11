import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiseaseManagementDetails {
    WebDriver driver;

    public DiseaseManagementDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By diseaseOverview = By.xpath("//span[text()='Disease Overview']");  //locator for 'Disease Overview' tab
    private By operations = By.xpath("//span[text()='Operations']");  //locator for 'Operations' tab

    public void clickDiseaseOverview() {
        driver.findElement(diseaseOverview).click();
    }

}
