import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on temporary email service page
    private By emailReadField = By.xpath("//span[@id='email']");
    private By prolongButton = By.xpath("//a[text()='+10 min']");
    private By messageList = By.xpath("//td[text()='Verify your email']/..");
    private By verificationLink = By.xpath("//a[contains(text(), 'Confirm my account')]");
    //private By verificationLink = By.xpath("//td[@role='presentation']");
    //private By verificationLink = By.xpath("//td/a[starts-with(@href, 'https://growerhub')]");
    //private By verificationLink = By.partialLinkText("VERIFY YOUR ACCOUNT");

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
    private By countryDropDown = By.xpath("//label[text()='Country']/../div/div/div");  // ("//div[@class='jss875 jss878 jss770 jss755']")
    private By countryElement = By.xpath("//li[text()='United Kingdom']");  //("//li[text()='%s'], United Kingdom")
    private By postcodeField = By.xpath(".//*[@placeholder='Postcode']");

    //Elements on Sign Up -> 3. Terms Of Service
    private By acceptCheckbox = By.xpath("//input[@name='registerTerms']");
    private By signUpButton = By.xpath("//button/span[text()='Sign up']");

    //Elements on Sign Up -> 4. My Fields
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
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(continueButton).click();
        switchToActiveTab();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); //waiting for element to appear
        driver.findElement(messageList).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //waiting for element to appear
        driver.switchTo().frame("iframeMail").findElement(verificationLink).click();
        driver.close();
        switchToActiveTab();
        driver.close();
        switchToActiveTab();

        return email;
    }
    public Register fillInMyFarm(String farmName, String address, String city, String country, String postcode) {
        countryElement = By.xpath("//li[text()='"+country+"']");
        driver.findElement(farmNameField).sendKeys(farmName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(countryDropDown).click();
        driver.findElement(countryDropDown).click();    //dropdown opens from the 2nd try
        driver.findElement(countryElement).click();
        driver.findElement(postcodeField).sendKeys(postcode);
        driver.findElement(continueButton).click();
        return new Register(driver);
    }
    public Register fillInTermsOfService() {
        driver.findElement(acceptCheckbox).click();
        driver.findElement(signUpButton).click();
        return new Register(driver);
    }
    public Register finishRegistration() {
        try {
            Thread.sleep(1000); //forced timeout to process request on Auth0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElement(growingSeasonDropDown).click();
        //driver.findElement(growingSeasonOption).click();
        driver.findElement(xButton).click();
        //driver.findElement(finishButton).click();
        return new Register(driver);
    }
}
