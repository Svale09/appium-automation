package Utilities;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class iOSActions extends AppiumUtilities {
    IOSDriver driver;

    public iOSActions(IOSDriver driver){
        this.driver = driver;
    }

    public void ScrollToElement(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("direction", "down");

        driver.executeScript("mobile: scroll", params);
    }
}
