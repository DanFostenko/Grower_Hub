import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DanFo\\IdeaProjects\\growerhubtest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //waiting for element to appear
        driver.manage().window().maximize(); //maximize browser window

        String site = "test.growerhub.io";  //dev.growerhub.io //growerhub.io
        String httpcreds = "syngenta:c0j4ZvP8KvIn";
        String email = "Bogdan.Fostenko@syngenta.com";
        String password = "Eamw5768*";
        String myPassword = "Eamw5768";
        driver.get("https://"+httpcreds+"@"+site);

        DiseaseManagement diseaseManagement = new DiseaseManagement(driver);
        DiseaseManagementDetails diseaseManagementDetails = new DiseaseManagementDetails(driver);
        Maps maps = new Maps(driver);
        MyFields myFields = new MyFields(driver);
        MyFieldsDetails myFieldsDetails = new MyFieldsDetails(driver);
        MyServices myServices = new MyServices(driver);
        NDVI nDVI = new NDVI(driver);
        NDVIDetails nDVIDetails = new NDVIDetails(driver);
        Register register = new Register(driver);
        SignIn signIn = new SignIn(driver);
        SignUpPopUp signUpPopUp = new SignUpPopUp(driver);
        VarietySelection varietySelection = new VarietySelection(driver);
        Weather weather = new Weather(driver);
        WeatherDetails weatherDetails = new WeatherDetails(driver);

        //log in-out
        for (int i = 1; i < 1; i++) {
            signUpPopUp.clickSignIn();
            signIn.signInWithCreds(email,myPassword);
            weather.clickLogout();
            System.out.println("Log in #: " + i);
        }

        //registration
        signUpPopUp.clickRegister();
        email = register.fillInMyProfile("Bogdan Fostenko","441234567898",password);
        //signIn.signInWithCreds(email,password);
        register.fillInVerification();
        register.fillInMyFarm("Bogdan's Farm","CPC4, Capital Park, Fulbourn, Cambridge CB21 5XE","Cambridge","United Kingdom","CB21 5XE");
        register.finishRegistration();
        weather.clickCookieOK();

        //upload new field
        myFields.clickMyFields();
        myFields.clickUploadShapeFiles();
        myFields.clickEditLayers();
        myFields.clickEditSaveLayers();
        myFields.clickEditLayers();
        myFields.clickEditCancelLayers();

        //go through the views
        myFields.clickMyFields();
        myFields.clickSeason();
        myFields.clickFeedback();
        myFields.clickCancelFeedback();
        myFields.clickBell();
        myFields.findElements();
        myFields.clickMoreDetails();
        myFieldsDetails.clickFieldDetails();
        myFieldsDetails.clickOperations();
        myFieldsDetails.clickMyFieldsFarmView();
        myFields.clickFarm();
        myFields.clickSeason();
        myFieldsDetails.clickFieldOverview();
        myFieldsDetails.typeCrop();
        myFieldsDetails.typeVariety();
        myFieldsDetails.typeFieldName();
        //myFieldsDetails.typeSoilType();
        //myFieldsDetails.typeDrillDate();
        myFieldsDetails.clickFarmDetails();
        myFieldsDetails.clickOperations();
        myFieldsDetails.addOperation("Planting","To Do");
        myFieldsDetails.addOperation("Crop Protection", "In Progress");
        myFieldsDetails.addOperation("Nutrition", "Blocked");
        myFieldsDetails.addOperation("Harvest", "Completed");
        myFieldsDetails.clickCropRotation();
        myFieldsDetails.clickImportHistory();
        maps.clickMaps();
        maps.addSoilMap();
        maps.addDrillMap();
        /*weather.clickWeather();
        weather.clickMoreDetails();
        weatherDetails.clickSprayGuide();
        weatherDetails.clickWeatherAnalysis();*/
        diseaseManagement.clickDiseaseManagement();
        diseaseManagement.clickMoreDetails();
        diseaseManagementDetails.clickDiseaseOverview();
        nDVI.clickNDVI();
        nDVI.clickGotIt();
        nDVI.clickMoreDetails();
        varietySelection.clickVarietySelection();
        varietySelection.clickWizard();
        varietySelection.clickVarietyAZ();
        varietySelection.clickWriteReview();
        myServices.clickMyServices();
        myServices.clickCategories();
        myFields.clickMyFields();
        myFields.clickAddNewField();
        myFields.clickFarm();
        myFields.clickAddNewFarm();
        register.fillInMyFarm("La ferme de Bogdan","5 Rue Aristide Maillol, 18000 Bourges, France","Bourges","France","18000");
        myFields.clickClose();
        myFields.clickFarm();
        myFields.clickDefaultFarm();
        driver.quit();  //end work of driver
    }

}
