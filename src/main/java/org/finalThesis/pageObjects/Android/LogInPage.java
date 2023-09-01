package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AndroidBasePage {
    AndroidDriver driver;
    public LogInPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter email']")
    private WebElement emailInputField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter password']")
    private WebElement passwordInputField;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/button_background")
    private WebElement continueButton;

    public void enterCredentials(String email, String password){
        InputText(emailInputField, email);
        InputText(passwordInputField, password);
    }

    public EventsPage tapContinueButton(){
        Tap(continueButton);
        return new EventsPage(driver);
    }
}
