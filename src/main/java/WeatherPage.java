import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherPage {
    WebDriver driver;

    public WeatherPage(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By cookieOKButton = By.xpath("//button/span[text()='OK, Continue']");  //locator for 'OK, continue' button
    private By userPicButton = By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/header/div/div[6]/button");
    private By logoutButton = By.xpath("//span[text()='Logout']");
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button

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
    /*public WeatherDetails clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }*/
}
