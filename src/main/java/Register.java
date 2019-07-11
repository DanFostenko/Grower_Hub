import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on Sign Up -> 1. My Profile step
    private By nameField = By.xpath(".//*[@placeholder='Name']");
    private By telephoneField = By.xpath(".//*[@placeholder='Telephone']");
    private By emailField = By.xpath(".//*[@placeholder='Email Address']");
    private By passwordField = By.xpath(".//*[@placeholder='Password']");
    private By continueButton = By.xpath("//button/span[text()='Continue']");

    //Elements on Sign Up -> 2. My Farm step
    private By farmNameField = By.xpath(".//*[@placeholder='Farm Name']");
    private By addressField = By.xpath(".//*[@placeholder='First line of address']");
    private By cityField = By.xpath(".//*[@placeholder='Town / City']");
    private By countryDropDown = By.xpath("//label[text()='Country']/../div/div/div"); //    ("//div[@class='jss875 jss878 jss770 jss755']")
    private By countryElement = By.xpath("//li[text()='United Kingdom']"); // private By countryElement = By.xpath("//li[text()='%s'], country");   ("//li[text()='%s'], United Kingdom")
    private By postcodeField = By.xpath(".//*[@placeholder='Postcode']");

    //Elements on Sign Up -> 3. Terms Of Service
    private By acceptCheckbox = By.xpath("//input[@name='registerTerms']");
    private By signUpButton = By.xpath("//button/span[text()='Sign up']");

    //Methods
    public Register fillInMyProfile(String name, String telephone, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(continueButton).click();
        return new Register(driver);
    }
    public Register fillInMyFarm(String farmName, String address, String city, String country, String postcode) {
        driver.findElement(farmNameField).sendKeys(farmName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(countryDropDown).click();
        driver.findElement(countryDropDown).click();    //dropdown opens from the 2nd click
        driver.findElement(countryElement).click();
        driver.findElement(postcodeField).sendKeys(postcode);
        driver.findElement(continueButton).click();
        driver.findElement(acceptCheckbox).click();
        //driver.findElement(signUpButton).click();
        return new Register(driver);
    }
    public Register fillInTermsOfService() {
        driver.findElement(acceptCheckbox).click();
        driver.findElement(signUpButton).click();
        return new Register(driver);
    }
}
