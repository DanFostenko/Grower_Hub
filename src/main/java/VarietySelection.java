import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VarietySelection {
    WebDriver driver;

    public VarietySelection(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By varietySelection = By.xpath("//*[@title='Variety Selection']/..");  //locator for 'Variety Selection' button
    private By wizard = By.xpath("//span[text()='VARIETY SELECTION']");  //locator for 'VARIETY SELECTION' button
    private By springWheatButton = By.xpath("//button/span[text()='Spring Wheat']");  //locator for 'Spring Wheat' button
    private By winterWheatButton = By.xpath("//button/span[text()='Winter Wheat']");  //locator for 'Winter Wheat' button
    private By springBarleyButton = By.xpath("//button/span[text()='Spring Barley']");  //locator for 'Spring Barley' button
    private By winterBarleyButton = By.xpath("//button/span[text()='Winter Barley']");  //locator for 'Winter Barley' button
    private By continueButton = By.xpath("//button/span[text()='Continue']");  //locator for 'Continue' button
    private By compareSelectedVarietiesButton = By.xpath("//div[text()='COMPARE SELECTED VARIETIES']");  //locator for 'COMPARE SELECTED VARIETIES' button

    private By varietyAZ = By.xpath("//button/span[text()='VARIETIES A TO Z']");  //locator for 'Varieties A to Z' button
    private By cropDropDown = By.xpath("//span[text()='Select a crop']/../div[1]/div");  //locator for 'Select a crop' drop down
    private By cropOption = By.xpath("//div[text()='Winter Wheat']");  //locator for 'Winter Wheat' option in 'Select a crop' drop down
    private By yearDropDown = By.xpath("//span[text()='Select a crop']/../div[2]/div");  //locator for 'Year' drop down
    private By yearOption = By.xpath("//div[text()='2019']");  //locator for 'Winter Wheat' option in 'Select a crop' drop down
    private By searchField = By.xpath("//input[@placeholder='Search on variety name']");  //locator for search input field
    private By searchButton = By.xpath("//span[text()='search']/..");  //locator for 'Search' button
    private By letterB = By.id("letter_B");  //locator for 'B' line
    private By boostVariety = By.xpath("//div[text()='Bounty']");  //locator for 'Boost' variety checkbox

    private By writeReviewButton = By.xpath("//span[text()='WRITE A REVIEW']/..");  //locator for 'WRITE A REVIEW' button
    private By ratingStars = By.xpath("//div[text()='Overall Rating']/../div[3]/div/*[name()='svg'][3]");  //locator for '3' rating stars
    private By textAreaMemo = By.xpath("//textarea");  //locator for text area in review modal window
    private By addReviewButton = By.xpath("//span[text()='ADD REVIEW']/..");  //locator for 'WRITE A REVIEW' button

    public void clickVarietySelection() {
        driver.findElement(varietySelection).click();
    }

    public void clickWizard() {
        driver.findElement(wizard).click();
        driver.findElement(springWheatButton).click();
        driver.findElement(winterWheatButton).click();
        driver.findElement(springBarleyButton).click();
        driver.findElement(winterBarleyButton).click();
        for (int i = 1; i < 4; i++) {  //click 3 'End-use Group' and 'Scope of Recommendation' buttons
            driver.findElement(By.xpath("//label[text()='End-use Group']/../../div[2]/div[" + i + "]")).click();
            driver.findElement(By.xpath("//label[text()='Scope of Recommendation']/../../div[2]/div[" + i + "]")).click();
        }
        driver.findElement(continueButton).click();
        driver.findElement(continueButton).click();
        for (int i = 1; i < 5; i++) {  //click 4 variety checkboxes
            By varietyCheckboxBy = By.xpath("//tr[" + i + "]/td[1]");
            driver.findElement(varietyCheckboxBy).click();
        }
        driver.findElement(compareSelectedVarietiesButton).click();
    }

    public void clickVarietyAZ() {
        driver.findElement(varietySelection).click();
        driver.findElement(varietyAZ).click();
        driver.findElement(cropDropDown).click();
        driver.findElement(cropOption).click();
        driver.findElement(yearDropDown).click();
        driver.findElement(yearOption).click();
        driver.findElement(searchField).sendKeys("Bounty");
        driver.findElement(searchButton).click();
        driver.findElement(letterB).click();
        driver.findElement(boostVariety).click();
    }

    public void clickWriteReview() {
        driver.findElement(writeReviewButton).click();
        driver.findElement(ratingStars).click();
        driver.findElement(textAreaMemo).sendKeys("Review about \"Bounty\" variety of Winter Wheat crop, season 2019.");
        driver.findElement(addReviewButton).click();
        Maps.waitObjectLoad(500);  //forced timeout to save review
    }
}