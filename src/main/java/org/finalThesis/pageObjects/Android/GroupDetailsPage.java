package org.finalThesis.pageObjects.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupDetailsPage extends AndroidBasePage {
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
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView")
    private WebElement mainContainer;

    public int GetMemberCount() {
        waitForElementToAppearByElement(memberCounter, driver);
        String members = GetText(memberCounter);
        String[] memberCounter = members.split(" ");
        return Integer.parseInt(memberCounter[0]);
    }

    public void JoinGroup() {
        Tap(joinGroupButton);
    }

    public CreatePostPage TapPostInputField() {
        Tap(postInputField);
        return new CreatePostPage(driver);
    }

    public String GetLatestPostTimestamp() {
        waitForElementToAppearByElement(postTimeStamps.get(0), driver);
        return postTimeStamps.get(0).getText();
    }

    //TODO Need to improve and fix the scrolling method used to scroll to the first post
    public void ScrollToPosts() {
        waitForElementToAppearByElement(mainContainer, driver);
        int startY = driver.manage().window().getSize().height;
        ScrollDown((int) (startY * 0.55));
        ScrollDown((int) (startY * 0.80));
        ScrollDown((int) (startY * 0.90));
    }
}
