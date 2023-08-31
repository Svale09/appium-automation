package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class GroupDetailsPage extends AndroidActions {
    AndroidDriver driver;

    public GroupDetailsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/members_count")
    private WebElement memberCounter;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/group_status_button")
    private WebElement joinGroupButton;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/write_post")
    private WebElement postInputField;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/post_view']//*[@resource-id='the.phoenix.android.qa:id/date_role_badge']")
    private List<WebElement> postTimeStamps;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/post_view']")
    private List<WebElement> posts;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/main_scroll_view']")
    private List<WebElement> mainContainers;

    public int GetMemberCount(){
        String members = GetText(memberCounter);
        String[] memberCounter = members.split(" ");
        return Integer.parseInt(memberCounter[0]);
    }

    public void JoinGroup(){
        joinGroupButton.click();
    }

    public CreatePostPage TapPostInputField(){
        postInputField.click();
        return new CreatePostPage(driver);
    }

    public String GetLatestPostTimestamp(){
        return postTimeStamps.get(0).getText();
    }

    public void ScrollToPosts(int amount){
        Swipe(amount, mainContainers.get(0), "up");
    }
}
