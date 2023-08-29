package TestUtilities;

import Utilities.AppiumUtilities;
import com.sun.tools.javac.comp.Todo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtilities {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    //TODO add the first visible screen POM as a varaible

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("Resources/AndroidData.properties");

        properties.load(fileInputStream);

        service = startAppiumService(
                properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port"))
        );

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setAutomationName("UIAutomator2")
                .setApp("/Users/ivansvalina/IdeaProjects/ZavrsniRad/src/test/java/Resources/Phoenix_Android.apk");

        AndroidDriver driver = new AndroidDriver(options);
        //TODO add the first visible screen POM for the driver to open it
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
