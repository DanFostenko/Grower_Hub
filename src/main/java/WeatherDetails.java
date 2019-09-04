import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WeatherDetails {
    WebDriver driver;

    public WeatherDetails(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By sprayGuide = By.xpath("//span[text()='Spray Guide']");  //locator for 'Spray Guide' tab
    private By weatherAnalysis = By.xpath("//span[text()='Weather Analysis']");  //locator for 'Weather Analysis' tab
    //Spray Guide tab
    private By sprayingTable = By.xpath("//div[@class='comp-weather-spray-guide']");  //Locator for Spraying and Forecast table
    private By moreDetailsButton = By.xpath("//span[text()='More Details']/..");  //Locator for 'More Details' button
    //Weather Analysis tab
    private By data1D = By.xpath("//span[text()='1D']/..");  //Locator for 1D chart input parameter
    private By data1W = By.xpath("//span[text()='1W']/..");  //Locator for 1W chart input parameter
    private By data1M = By.xpath("//span[text()='1M']/..");  //Locator for 1M chart input parameter
    private By data3M = By.xpath("//span[text()='3M']/..");  //Locator for 3M chart input parameter
    private By data6M = By.xpath("//span[text()='6M']/..");  //Locator for 6M chart input parameter
    private By data1Y = By.xpath("//span[text()='1Y']/..");  //Locator for 1Y chart input parameter
    private By dataTemperature = By.xpath("//div[text()='Temperature']");  //Locator for 'Temperature' chart input parameter
    private By dataPrecipitation = By.xpath("//div[text()='Precipitation (mm)']");  //Locator for 'Precipitation (mm)' chart input parameter
    private By dataHumidity = By.xpath("//div[text()='Humidity']");  //Locator for 'Humidity' chart input parameter
    private By dataWind = By.xpath("//div[text()='Wind']");  //Locator for 'Wind' chart input parameter
    private By data2018 = By.xpath("//div[text()='2018']");  //Locator for 2018 chart input parameter
    private By data2017 = By.xpath("//div[text()='2018']");  //Locator for 2017 chart input parameter
    private By data2016 = By.xpath("//div[text()='2018']");  //Locator for 2016 chart input parameter
    private By data2015 = By.xpath("//div[text()='2018']");  //Locator for 2015 chart input parameter
    private By data2014 = By.xpath("//div[text()='2018']");  //Locator for 2014 chart input parameter

    public void clickSprayGuide() {
        driver.findElement(sprayGuide).click();
        elementExists(sprayingTable);
        elementExists(moreDetailsButton);
    }
    public void clickWeatherAnalysis() {
        driver.findElement(weatherAnalysis).click();
        driver.findElement(data1D).click();
        driver.findElement(data1W).click();
        driver.findElement(data1M).click();
        driver.findElement(data3M).click();
        driver.findElement(data6M).click();
        driver.findElement(data1Y).click();
        driver.findElement(dataTemperature).click();
        driver.findElement(dataPrecipitation).click();
        driver.findElement(dataHumidity).click();
        driver.findElement(dataWind).click();
        driver.findElement(data2018).click();
        driver.findElement(data2017).click();
        driver.findElement(data2016).click();
        driver.findElement(data2017).click();
        driver.findElement(data2015).click();
        driver.findElement(data2015).click();
        driver.findElement(data2014).click();
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
