package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class iOSBasePage extends iOSActions {
    IOSDriver driver;

    public iOSBasePage(IOSDriver driver){
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
