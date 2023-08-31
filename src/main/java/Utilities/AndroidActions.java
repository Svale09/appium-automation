package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtilities{
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }

    public void scrollToElement(String value){
        driver.findElement(
                AppiumBy.androidUIAutomator((
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + value + "\"));")
                )); //Ui automator method of scrolling
    }

    public void Swipe(int amount, WebElement element, String direction) {
        //for (int i = 0; i < amount; i++) {
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", direction,
                    "percent", 0.75
            ));
        }
    //}

    public String GetText(WebElement element){
        return element.getText();
    }
}
