package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreatePostPage extends AndroidActions {
    AndroidDriver driver;

    public CreatePostPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/text_input")
    private WebElement postTextInputField;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/post_comment")
    private WebElement createPostButton;

    public void InputPostText(String text){
        postTextInputField.sendKeys(text);
    }
    public GroupDetailsPage PublishPost(){
        waitForElementToAppearByElement(createPostButton,driver);
        createPostButton.click();
        return new GroupDetailsPage(driver);
    }
}
