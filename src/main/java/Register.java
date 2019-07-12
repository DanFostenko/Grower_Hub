import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    //Elements on 10Minutes
    private By emailReadField = By.id("mailAddress");
    private By prolongButton = By.id("resetSessionLifeButton");
    private By messageList = By.id("messagesList");
    private By verificationLink = By.xpath("//td[@role='presentation']");
    //private By verificationLink = By.xpath("//a[starts-with(@href, 'https://growerhub')]");

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
    private By countryElement = By.xpath("//li[text()='United Kingdom']");  //("//li[text()='%s'], United Kingdom")
    private By postcodeField = By.xpath(".//*[@placeholder='Postcode']");

    //Elements on Sign Up -> 3. Terms Of Service
    private By acceptCheckbox = By.xpath("//input[@name='registerTerms']");
    private By signUpButton = By.xpath("//button/span[text()='Sign up']");

    //Methods
    public String fillInMyProfile(String name, String telephone, String password) {
        String mainTab = driver.getWindowHandle();  //remember the name of main browser tab
        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/10MinuteMail/index.html','_blank');");    //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t")
        for (String tab : driver.getWindowHandles()) { //switch to the active tab
            driver.switchTo().window(tab);
        }
        String secondaryTab = driver.getWindowHandle();  //remember the name of secondary browser tab
        String email = driver.findElement(emailReadField).getAttribute("value");
        System.out.println("Registration email is: " + email);
        driver.findElement(prolongButton).click();
        driver.switchTo().window(mainTab);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(continueButton).click();
        for (String tab : driver.getWindowHandles()) { //switch to the active tab
            driver.switchTo().window(tab);
        }
        //WebDriverWait wait = (new WebDriverWait(driver, 15));    //явное - ожидание элементов до их появления, которое используется 1 раз
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        driver.findElement(messageList).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        String link = driver.findElement(verificationLink).getAttribute("href");
        driver.get(link);

        ((JavascriptExecutor)driver).executeScript("window.close");
        return email;
        //return new Register(email);
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
