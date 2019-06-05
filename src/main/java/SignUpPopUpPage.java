import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPopUpPage {
    private WebDriver driver;

    public SignUpPopUpPage(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    public By signInButton = By.xpath("//span[text()='Sign in']"); //locator for 'Sign in' button
    private By registerButton = By.xpath("//span[text()='RegisterPage For Free']"); //locator for 'RegisterPage For Free' button
    private By tryDemoButton = By.xpath("//span[text()='Try Our Demo Farm']");  //locator for 'Try Our Demo Farm' button
    private By XButton = By.xpath(".//*[@data-cy='onboarding-close']");  //locator for 'X' button

    //Methods
    public SignInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public RegisterPage clickRegister() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public WeatherPage clickTryDemo() {
        driver.findElement(tryDemoButton).click();
        return new WeatherPage(driver);
    }
}
