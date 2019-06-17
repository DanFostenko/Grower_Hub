import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    private By EmailField = By.xpath(".//*[@placeholder='Email Address']");
    private By PasswordField = By.xpath(".//*[@placeholder='Password *']");
    private By signInButton = By.xpath("//button/span[text()='Sign in']");

    //Methods
    public SignInPage typeEmail(String email) {
        driver.findElement(EmailField).sendKeys(email);
        return this;
    }
    public SignInPage typePassword(String password) {
        driver.findElement(PasswordField).sendKeys(password);
        return this;
    }
    public SignInPage signInWithCreds(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
    public Weather clickSignIn() {
        driver.findElement(signInButton).click();
        return new Weather(driver);
    }
}
