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
    private By policyPrivacyAcceptCheckbox = By.xpath("//input[@name='registerPrivacyPolicy']");   //locator for 'I accept the Privacy Policy' checkbox
    private By policyAcceptButton = By.xpath("//span[text()='ACCEPT & CLOSE']/..");    //locator for 'ACCEPT & CLOSE' button
    private By policyTermsConditionsAcceptCheckbox = By.xpath("//input[@name='registerTerms']");   //locator for 'I accept the Terms & Conditions' checkbox
    private By policyDeclineButton = By.xpath("//span[text()='DECLINE']");    //locator for 'DECLINE' button

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
        Maps.waitObjectLoad(1000);  //forced timeout to process request on Auth0
        return new SignIn(driver);
    }
    public void acceptPolicy() {    //required when policy is updated for existing account
        driver.findElement(policyPrivacyAcceptCheckbox).click();
        driver.findElement(policyAcceptButton).click();
        driver.findElement(policyTermsConditionsAcceptCheckbox).click();
        driver.findElement(policyAcceptButton).click();
    }
    public void declinePolicy() {
        driver.findElement(policyDeclineButton).click();
    }
}
