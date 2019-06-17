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

        signUpPopUp.clickSignIn();
        signIn.signInWithCreds("x36607@nwytg.net","Eamw5768");
        weather.clickLogout();
        signUpPopUp.clickX();
        weather.clickCookieOK();

        myFields.clickMyFields();
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
        diseaseManagementDetails.clickOperations();
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
