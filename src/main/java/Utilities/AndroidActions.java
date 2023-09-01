package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtilities {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(String value) {
        driver.findElement(
                AppiumBy.androidUIAutomator((
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + value + "\"));")
                )); //Ui automator method of scrolling
    }

    public void Swipe(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void ScrollDown(int startY) {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;;
        int endX = size.width / 2;
        int endY = (int) (size.height * 0.30);

        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(
                new PointOption().withCoordinates(startX, startY)).
                moveTo(new PointOption().withCoordinates(endX, endY))
                .release()
                .perform();
    }
}
