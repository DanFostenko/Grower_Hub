import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DanFo\\IdeaProjects\\growerhubtest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for element to appear
        driver.manage().window().maximize(); //maximize browser window

        String site = "test.growerhub.io";  //dev.growerhub.io //growerhub.io
        String httpcreds = "syngenta:c0j4ZvP8KvIn";
        String email = "x36607@nwytg.net";
        String password = "Eamw5768";
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
        signUpPopUp.clickSignIn();
        signIn.signInWithCreds(email,password);
        weather.clickLogout();

        //registration
        signUpPopUp.clickRegister();
        email = register.fillInMyProfile("Bogdan Fostenko","441234567898",password);
        signIn.signInWithCreds(email,password);
        register.fillInMyFarm("Bogdan's Farm","CPC4, Capital Park, Fulbourn, Cambridge CB21 5XE","Cambridge","United Kingdom","CB21 5XE");
        register.fillInTermsOfService();
        register.finishRegistration();

        //upload new field
        myFields.clickMyFields();
        myFields.uploadNewShapeFiles();

        //go through the views
        weather.clickCookieOK();
        myFields.clickMyFields();
        myFields.clickAddNewField();
        myFields.clickFarm();
        myFields.clickSeason();
        myFields.clickMoreDetails();
        myFieldsDetails.clickFieldDetails();
        myFieldsDetails.clickOperations();
        myFieldsDetails.clickMyFieldsFarmView();
        myFields.clickFarm();
        myFields.clickSeason();
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
        nDVI.clickGotIt();
        nDVI.clickMoreDetails();
        varietySelection.clickVarietySelection();
        varietySelection.clickWizard();
        varietySelection.clickVarietyAZ();
        myServices.clickMyServices();
        myServices.clickCategories();

        driver.quit();  //end work of driver
    }
}
