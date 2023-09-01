package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupsPage extends AndroidBasePage {
    AndroidDriver driver;

    public GroupsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/featured_groups_recycler_view']//*[@class='androidx.cardview.widget.CardView']")
    private List<WebElement> featuredGroupCards;

    public GroupDetailsPage OpenGroupDetails(){
        featuredGroupCards.get(0).click();
        return new GroupDetailsPage(driver);
    }
}
