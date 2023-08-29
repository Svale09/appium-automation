package TestUtilities;

import Utilities.AppiumUtilities;
import com.sun.tools.javac.comp.Todo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeClass;

public class AndroidBaseTest extends AppiumUtilities {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    //TODO add the first visible screen POM as a varaible

    @BeforeClass
    public void ConfigureAppium(){

    }
}
