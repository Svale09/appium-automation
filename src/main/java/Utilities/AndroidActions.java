package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

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

    public String GetText(WebElement element){
        return element.getText();
    }
}
