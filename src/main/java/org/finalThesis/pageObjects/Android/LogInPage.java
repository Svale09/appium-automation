package org.finalThesis.pageObjects.Android;

import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AppiumUtilities {
    AndroidDriver driver;
    public LogInPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy()
    private WebElement emailInputField;
    @AndroidFindBy()
    private WebElement passwordInputField;
    @AndroidFindBy()
    private WebElement continueButton;

    public void enterCredentials(String email, String password){
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
    }

    public EventsPage tapContinueButton(){
        continueButton.click();
        return new EventsPage(driver);
    }
}
