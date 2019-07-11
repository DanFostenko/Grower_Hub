import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DanFo\\IdeaProjects\\growerhubtest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for element appearance
        driver.manage().window().maximize(); //maximize browser window

        String site = "test.growerhub.io";  //dev.growerhub.io //growerhub.io
        String httpcreds = "syngenta:c0j4ZvP8KvIn";
        driver.get("https://"+httpcreds+"@"+site);

        SignUpPopUp signUpPopUp = new SignUpPopUp(driver);
        SignIn signIn = new SignIn(driver);
        Register register = new Register(driver);
        Weather weather = new Weather(driver);
        MyFields myFields = new MyFields(driver);
        MyFieldsDetails myFieldsDetails = new MyFieldsDetails(driver);
        WeatherDetails weatherDetails = new WeatherDetails(driver);
        DiseaseManagement diseaseManagement = new DiseaseManagement(driver);
        DiseaseManagementDetails diseaseManagementDetails = new DiseaseManagementDetails(driver);
        NDVI nDVI = new NDVI(driver);
        NDVIDetails nDVIDetails = new NDVIDetails(driver);
        VarietySelection varietySelection = new VarietySelection(driver);
        MyServices myServices = new MyServices(driver);

        //log in - log out
        /*signUpPopUp.clickSignIn();
        signIn.signInWithCreds("x36607@nwytg.net","Eamw5768");
        weather.clickLogout();*/

        //registration
        signUpPopUp.clickRegister();
        register.fillInMyProfile("Bogdan Fostenko","441234567898","","Eamw5768");

        signUpPopUp.clickSignIn(); //to be delete after email obtained correctly w/o spike
        signIn.signInWithCreds("b3843956@urhen.com","Eamw5768");
        register.fillInMyFarm("Bogdan's Farm","CPC4, Capital Park, Fulbourn, Cambridge CB21 5XE","Cambridge","United Kingdom","CB21 5XE");
        signUpPopUp.clickX();

        //go through the views
        weather.clickCookieOK();
        myFields.clickMyFields();
        myFields.clickFarm();
        myFields.clickSeason();
        myFields.clickMoreDetails();
        myFieldsDetails.clickCropOverview();
        myFieldsDetails.clickFarmDetails();
        myFieldsDetails.clickOperations();
        myFieldsDetails.clickImportHistory();
        weather.clickWeather();
        weather.clickMoreDetails();
        weatherDetails.clickSprayGuide();
        weatherDetails.clickWeatherAnalysis();
        diseaseManagement.clickDiseaseManagement();
        diseaseManagement.clickMoreDetails();
        diseaseManagementDetails.clickDiseaseOverview();
        nDVI.clickNDVI();
        nDVI.clickMoreDetails();
        varietySelection.clickVarietySelection();
        varietySelection.clickWizard();
        varietySelection.clickVarietyAZ();
        myServices.clickMyServices();
        myServices.clickCategories();

        driver.quit(); //end work of driver
    }
}
