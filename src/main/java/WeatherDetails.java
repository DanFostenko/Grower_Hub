import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherDetails {
    WebDriver driver;

    public WeatherDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By sprayGuide = By.xpath("//span[text()='Spray Guide']");  //locator for 'Spray Guide' tab
    private By weatherAnalysis = By.xpath("//span[text()='Weather Analysis']");  //locator for 'Weather Analysis' tab

    public void clickSprayGuide() {
        driver.findElement(sprayGuide).click();
    }
    public void clickWeatherAnalysis() {
        driver.findElement(weatherAnalysis).click();
    }
}
