package TestUtilities;

import Utilities.AppiumUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.finalThesis.pageObjects.iOS.OnboardingPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class iOSBaseTest extends AppiumUtilities {
    private AppiumDriverLocalService service;
    public IOSDriver driver;
    public OnboardingPage onboardingPage;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/ivansvalina/IdeaProjects/ZavrsniRad/src/main/java/Resources/iOSData.properties");
        properties.load(fileInputStream);

        service = startAppiumService(
                properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port"))
        );

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setAutomationName("XCUITest")
                .setApp("/Users/ivansvalina/Library/Developer/Xcode/DerivedData/iosApp-beddrelcoxzocufownczwlyqkwbd/Build/Products/Debug-iphonesimulator/ThePhoenixQA.app")
                .setWdaLaunchTimeout(Duration.ofSeconds(5));

        driver = new IOSDriver(service.getUrl(), options);
        onboardingPage = new OnboardingPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
