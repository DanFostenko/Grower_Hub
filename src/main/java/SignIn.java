import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
    WebDriver driver;

    public SignIn(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    private By emailField = By.xpath(".//*[@placeholder='Email Address']");
    private By passwordField = By.xpath(".//*[@placeholder='Password *']");
    private By signInButton = By.xpath("//button/span[text()='Sign in']");

    //Methods
    public SignIn typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public SignIn typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignIn signInWithCreds(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new SignIn(driver);
    }
}
