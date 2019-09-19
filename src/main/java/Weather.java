import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Weather {
    WebDriver driver;

    public Weather(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By weatherButton = By.xpath("//*[@title='Weather']");  //locator for 'Weather' button
    private By cookieOKButton = By.xpath("//button/span[text()='OK, Continue']/.."); //xpath locator for 'OK, continue' button in Cookie Policy window
    private By userPicButton = By.xpath("//span[text()='Feedback']/parent::button/following-sibling::div[2]");  //locator for user button linked to Feedback button
    private By logoutButton = By.xpath("//span[text()='Logout']/../..");    //locator for 'Logout' menu from user dropdown
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button
    private By keyList = By.xpath("//p[text()='Key']");  //Locator for Key leaflet
    private By mapLayers = By.xpath("//a[@title='Layers']");  //Locator for map layers
    private By weatherLayersButton = By.xpath("//div[@class='leaflet-control']/button");  //Locator for Weather Layers button
    private By weatherLayer = By.xpath("//div[@id='map-menu-list-grow']/ul/li");  //Locator for Weather Layer in the Weather Layers list

    private By weatherTileString = By.xpath("//img[@class='leaflet-image-layer leaflet-zoom-animated']");  //Locator for weather layers
    private By infoSprayGuide = By.xpath("//div[text()='Spray Guide']/../../div[3]");  //Locator for Spray Guide on info panel
    private By infoForecast = By.xpath("//div[text()='5 Day Forecast']/../../div[5]");  //Locator for 5 Day Forecast on info panel
    private By weatherPlayerButton = By.xpath("//li[text()='Now']/../../../../div[1]");  //Locator for weather player "+" button
    private By weatherPlayerMenu = By.xpath("//li[text()='Now']/..");  //Locator for weather player menu

    public void clickWeather() {
        driver.findElement(weatherButton).click();
        elementExists(keyList);
        elementExists(mapLayers);
        findWeatherLayers();
        //findAllWeatherLayers();
        elementExists(infoSprayGuide);
        elementExists(infoForecast);
        driver.findElement(weatherPlayerButton).click();
        elementExists(weatherPlayerMenu);
        driver.findElement(weatherPlayerButton).click();
    }

    public void clickCookieOK() {
        driver.findElement(cookieOKButton).click();
    }

    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

    private void findWeatherLayers() {
        elementExists(weatherLayersButton);
        for (int j = 1; j < 31; j++) {  //go through 30 weather tiles of default weather layer
            By weatherTileBy = By.xpath("\"" + weatherTileString + "[" + j + "]\"");
            elementExists(weatherTileBy);
        }
    }

    private void findAllWeatherLayers() {
        for (int i = 2; i < 12; i++) {  //go through 11 weather layers
            driver.findElement(weatherLayersButton).click();
            By weatherLayerBy = By.xpath("\"" + weatherLayer + "[" + i + "]\"");
            driver.findElement(weatherLayerBy).click();
            for (int j = 1; j < 31; j++) {  //go through 30 weather tiles of each weather layer
                By weatherTileBy = By.xpath("\"" + weatherTileString + "[" + j + "]\"");
                elementExists(weatherTileBy);
            }
        }
    }

    public void clickLogout() {
        driver.findElement(userPicButton).click();
        driver.findElement(logoutButton).click();
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
