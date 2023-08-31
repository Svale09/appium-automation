package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtilities{
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }

    public void scrollToElement(String attribute, String value){
        driver.findElement(
                AppiumBy.androidUIAutomator((
                        String.format("new UiScrollable(new UiSelector()).scrollIntoView(%s('%s'));",attribute, value)
                ))); //Ui automator method of scrolling
    }
}
