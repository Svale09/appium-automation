package TestUtilities;

import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.finalThesis.pageObjects.Android.OnboardingPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtilities {
    private AppiumDriverLocalService service;
    public AndroidDriver driver;
    public OnboardingPage onboardingPage;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/ivansvalina/IdeaProjects/ZavrsniRad/src/main/java/Resources/AndroidData.properties");

        properties.load(fileInputStream);

        service = startAppiumService(
                properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port"))
        );

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setAutomationName("UIAutomator2")
                .setApp("/Users/ivansvalina/Documents/Faks/Završni/App Versions/Phoenix_Android.apk")
                .autoGrantPermissions();

        driver = new AndroidDriver(service.getUrl(), options);
        onboardingPage = new OnboardingPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
