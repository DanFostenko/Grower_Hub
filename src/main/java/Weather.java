import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Weather {
    WebDriver driver;

    public Weather(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By weatherButton = By.xpath("//*[@title='Weather']");  //locator for 'Weather' button
    private By cookieOKButton = By.xpath("//button/span[text()='OK, Continue']"); //xpath locator for 'OK, continue' button in Cookie Policy window
    private By userPicButton = By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/header/div/div[6]/button");
    private By logoutButton = By.xpath("//span[text()='Logout']");
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
