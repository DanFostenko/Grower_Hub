import org.openqa.selenium.By;
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

    public void clickWeather() {
        driver.findElement(weatherButton).click();
    }
    public void clickCookieOK() {
        driver.findElement(cookieOKButton).click();
    }
    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }
    public void clickLogout() {
        driver.findElement(userPicButton).click();
        driver.findElement(logoutButton).click();
    }
}
