package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreatePostPage extends iOSBasePage {
    IOSDriver driver;

    public CreatePostPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(className = "XCUIElementTypeTextView")
    private WebElement postTextInputField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Post\"`]")
    private WebElement createPostButton;

    public void InputPostText(String text){
        postTextInputField.sendKeys(text);
    }
    public GroupDetailsPage PublishPost(){
        Tap(createPostButton);
        return new GroupDetailsPage(driver);
    }
}
