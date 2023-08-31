package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Driver;
import java.time.Duration;

public class AppiumUtilities {
    public AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumService(String ipAddres, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddres)
                .usingPort(port)
                .build();

        service.start();
        return service;
    }

    public void waitForElementToAppear(String id, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }
    public String GetText(WebElement element){
        return element.getText();
    }
}
