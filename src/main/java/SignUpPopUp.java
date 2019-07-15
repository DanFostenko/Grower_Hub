import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPopUp {
    private WebDriver driver;

    public SignUpPopUp(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on page
    public By signInButton = By.xpath("//span[text()='Sign in']"); //locator for 'Sign in' button
    private By registerButton = By.xpath("//span[text()='Register For Free']"); //locator for 'Register For Free' button
    private By tryDemoButton = By.xpath("//span[text()='Try Our Demo Farm']");  //locator for 'Try Our Demo Farm' button
    private By xButton = By.xpath(".//*[@data-cy='onboarding-close']");  //locator for 'X' button

    //Methods
    public SignIn clickSignIn() {
        driver.findElement(signInButton).click();
        return new SignIn(driver);
    }

    public Register clickRegister() {
        driver.findElement(registerButton).click();
        return new Register(driver);
    }

    public Weather clickTryDemo() {
        driver.findElement(tryDemoButton).click();
        return new Weather(driver);
    }

    public Weather clickX() {
        driver.findElement(xButton).click();
        return new Weather(driver);
    }
}
