import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on temporary email service page
    private By emailReadField = By.xpath("//span[@id='email']");
    private By prolongButton = By.xpath("//a[text()='+10 min']");
    private By messageList = By.xpath("//td[text()='Welcome to Growerhub Web App']/..");
    private By oneTimePassword = By.xpath("//h2[@class='sub-title']");
    //private By verificationLink = By.xpath("//a[contains(text(), 'Confirm my account')]");
    //private By verificationLink = By.xpath("//td[@role='presentation']");
    //private By verificationLink = By.xpath("//td/a[starts-with(@href, 'https://growerhub')]");
    //private By verificationLink = By.partialLinkText("VERIFY YOUR ACCOUNT");

    //Elements on Sign Up -> 1. My Profile step
    private By fullNameField = By.xpath(".//*[@placeholder='Full Name']");
    private By telephoneField = By.xpath(".//*[@placeholder='Telephone']");
    private By emailField = By.xpath(".//*[@placeholder='Email Address']");
    private By passwordField = By.xpath(".//*[@placeholder='Password']");
    private By acceptCheckbox = By.xpath("//input[@name='registerTerms']");
    private By letGetStartedButton = By.xpath("//button/span[text()='LETS GET STARTED']/..");

    //Elements on Sign Up -> 2. Verification step
    private By enterCodeInput = By.xpath("//input[@type='number'][1]");
    private By resendCodeLink = By.xpath("//span[text()='Resend Code']");
    private By continueButton = By.xpath("//button/span[text()='Continue']/..");

    //Elements on Sign Up -> 3. My Farm step
    private By farmNameField = By.xpath(".//*[@placeholder='Farm Name']");
    private By addressField = By.xpath(".//*[@placeholder='First line of address']");
    private By cityField = By.xpath(".//*[@placeholder='Town / City']");
    private By countryDropDown = By.xpath("//label[text()='Country']/../div/div/div");  // ("//div[@class='jss875 jss878 jss770 jss755']")
    private By countryElement = By.xpath("//li[text()='United Kingdom']");  //("//li[text()='%s'], United Kingdom")
    private By postcodeField = By.xpath(".//*[@placeholder='Postcode']");

    //Elements on Sign Up -> 4. My Fields
    private By signUpButton = By.xpath("//button/span[text()='Sign up']");
    private By finishButton = By.xpath("//span[text()='Finish']/..");
    private By growingSeasonDropDown = By.xpath("//label[text()='Select Growing Season']/following-sibling::*/div");
    private By growingSeasonOption = By.xpath("//li[text()='2018-2019 Season']");
    private By xButton = By.xpath("//div[@data-cy='onboarding-close']");

    //Methods
    private void switchToActiveTab() {
        for (String tab : driver.getWindowHandles()) { //switch to the active tab
            driver.switchTo().window(tab);
        }
    }

    public String fillInMyProfile(String name, String telephone, String password) {
        String mainTab = driver.getWindowHandle();  //remember the name of main browser tab
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.minuteinbox.com','_blank');");    //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t")
        switchToActiveTab();
        String email = driver.findElement(emailReadField).getText();
        System.out.println("Registration email: " + email);
        driver.findElement(prolongButton).click();
        driver.switchTo().window(mainTab);
        driver.findElement(fullNameField).sendKeys(name);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(acceptCheckbox).click();
        driver.findElement(letGetStartedButton).click();
        //fillInVerification
        switchToActiveTab();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); //waiting for element to appear
        driver.findElement(messageList).click();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS); //waiting for element to appear
        String otp = driver.switchTo().frame("iframeMail").findElement(oneTimePassword).getText();  //get 6-digits OTP verification code
        //driver.switchTo().frame("iframeMail").findElement(verificationLink).click();    //email verification
        driver.close();
        switchToActiveTab();
        driver.findElement(enterCodeInput).sendKeys(otp);
        driver.findElement(continueButton).click();
        return email;
    }

    public Register fillInVerification() {

        return new Register(driver);
    }

    public Register fillInMyFarm(String farmName, String address, String city, String country, String postcode) {
        countryElement = By.xpath("//li[text()='"+country+"']");
        Maps.waitObjectLoad(3000);  //forced timeout to load the modal window
        driver.findElement(farmNameField).sendKeys(farmName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(countryDropDown).click();
        Maps.waitObjectLoad(500);  //forced timeout to render dropdown
        driver.findElement(countryElement).click();
        driver.findElement(postcodeField).sendKeys(postcode);
        Maps.waitObjectLoad(500);   //forced timeout to focus off the field
        driver.findElement(continueButton).click();
        return new Register(driver);
    }

    public Register finishRegistration() {
        Maps.waitObjectLoad(2000);  //forced timeout to process request to Auth0
        //driver.findElement(growingSeasonDropDown).click();
        //driver.findElement(growingSeasonOption).click();
        driver.findElement(xButton).click();
        //driver.findElement(finishButton).click(); //need to scroll down to find the button
        return new Register(driver);
    }

}
