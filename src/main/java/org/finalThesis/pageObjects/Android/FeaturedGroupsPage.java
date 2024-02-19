package org.finalThesis.pageObjects.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FeaturedGroupsPage extends AndroidBasePage{
    AndroidDriver driver;

    public FeaturedGroupsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "androidx.cardview.widget.CardView")
    private List<WebElement> featuredCards;

    public GroupDetailsPage OpenFeaturedGroupDetails(){
        Tap(featuredCards.get(0));
        return new GroupDetailsPage(driver);
    }
}
