import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyServices {
    WebDriver driver;

    public MyServices(WebDriver driver) {  //class constructor
        this.driver = driver;
    }
    private By myServices = By.xpath("//*[@title='My Services']");  //locator for 'My Services' button
    private By categories = By.xpath("//span[text()='Categories']");  //locator for 'Categories' button

    public void clickMyServices() {
        driver.findElement(myServices).click();
    }
    public void clickCategories() {
        driver.findElement(categories).click();
    }

}