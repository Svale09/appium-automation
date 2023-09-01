package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidBasePage extends AndroidActions {
    AndroidDriver driver;

    public AndroidBasePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void Tap(WebElement element) {
        waitForElementToAppearByElement(element, driver);
        element.click();
    }

    public void InputText(WebElement element, String text){
        waitForElementToAppearByElement(element, driver);
        element.sendKeys(text);
    }

    public String GetText(WebElement element){
        waitForElementToAppearByElement(element, driver);
        return element.getText();
    }
}
