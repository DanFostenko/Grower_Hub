import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyFields {
    WebDriver driver;

    public MyFields(WebDriver driver) {  //class constructor
        this.driver = driver;
    }

    private By myFieldsButton = By.xpath("//*[@title='My Fields']");  //locator for 'My Fields' button
    private By addNewFieldButton = By.xpath("//button[@aria-label='Add new field']");  //locator for 'Add New Field' button
    private By importFromGatekeeperButton = By.xpath("//span[text()='Import from Gatekeeper']");  //locator for 'Import from Gatekeeper' button
    private By xButton = By.xpath("//div[text()='Add New Field']/following-sibling::*");  //locator for 'X' (Close) button
    private By farmDropDown = By.xpath("//div[@class='farm-selection-comp']");  //locator for 'Farm' drop-down
    private By seasonDropDown = By.xpath("//div[@class='growing-season-selection-comp']");  //locator for 'Season' drop-down
    private By feedbackButton = By.xpath("//span[text()='Feedback']/parent::button");  //locator for 'Feedback' button
    private By cancelFeedbackButton = By.xpath("//span[text()='Cancel']/parent::button");  //locator for 'Cancel' button
    private By bellButton = By.xpath("//span[text()='Feedback']/parent::button/following-sibling::div[1]");  //locator for 'Bell' button
    private By moreDetails = By.xpath("//span[text()='More Details']");  //locator for 'More Details' button
    private By uploadNewShapeFilesButton = By.xpath("//button/span[text()='Upload Shape Files']/..");  //locator for 'Upload Shape Files' button
    private By dropZone = By.xpath("//div[starts-with(@class,'dropzone-box')]");    //locator for 'Drag&Drop' zone
    private By fileSelector = By.xpath("//*[@id='app']/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div/div[3]/div/button");    //locator for 'Choose Files' button

    public void clickMyFields() {
        driver.findElement(myFieldsButton).click();
    }

    public void clickAddNewField() {
        driver.findElement(addNewFieldButton).click();
        driver.findElement(importFromGatekeeperButton).click();
        driver.findElement(xButton).click();
    }

    public void uploadNewShapeFiles() {
        driver.findElement(addNewFieldButton).click();
        driver.findElement(uploadNewShapeFilesButton).click();
        uploadFile();
    }

    public void uploadFile() {  //I'm very ashamed of the peace of code below, but there's no another solution
        driver.findElement(fileSelector).click();   //fileSelector type is button, it's not input
        try {
            Thread.sleep(2000); //forced timeout to process zip uploading
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*WebElement uploadElement = driver.findElement(fileSelector);
        driver.switchTo().activeElement().sendKeys("C:\\Users\\DanFo\\IdeaProjects\\growerhubtest\\UKFieldShape.zip");*/
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        driver.switchTo().activeElement();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_U);  r.keyRelease(KeyEvent.VK_U);
        r.keyPress(KeyEvent.VK_K);  r.keyRelease(KeyEvent.VK_K);
        r.keyPress(KeyEvent.VK_F);  r.keyRelease(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_I);  r.keyRelease(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_E);  r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_L);  r.keyRelease(KeyEvent.VK_L);
        r.keyPress(KeyEvent.VK_D);  r.keyRelease(KeyEvent.VK_D);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_S);  r.keyRelease(KeyEvent.VK_S);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_H);  r.keyRelease(KeyEvent.VK_H);
        r.keyPress(KeyEvent.VK_A);  r.keyRelease(KeyEvent.VK_A);
        r.keyPress(KeyEvent.VK_P);  r.keyRelease(KeyEvent.VK_P);
        r.keyPress(KeyEvent.VK_E);  r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_PERIOD);  r.keyRelease(KeyEvent.VK_PERIOD);
        r.keyPress(KeyEvent.VK_Z);  r.keyRelease(KeyEvent.VK_Z);
        r.keyPress(KeyEvent.VK_I);  r.keyRelease(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_P);  r.keyRelease(KeyEvent.VK_P);
        r.keyPress(KeyEvent.VK_ENTER);  r.keyRelease(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        try {
            Thread.sleep(2000); //forced timeout to process zip uploading
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(xButton).click();
    }

    public void clickFarm() {
        driver.findElement(farmDropDown).click();
    }

    public void clickSeason() {
        driver.findElement(seasonDropDown).click();
    }

    public void clickFeedback() {
        driver.findElement(feedbackButton).click();
    }

    public void clickCancelFeedback() {
        driver.findElement(cancelFeedbackButton).click();
    }

    public void clickBell() {
        driver.findElement(bellButton).click();
    }

    public void clickMoreDetails() {
        driver.findElement(moreDetails).click();
    }

}