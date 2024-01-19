package Utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class AppiumUtilities {
    public AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumService(String ipAddress, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress)
                .usingPort(port)
                .build();

        service.start();
        return service;
    }

    public void waitForElementToAppearByElement(WebElement element, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = "/Users/ivansvalina/IdeaProjects/ZavrsniRad/Reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public Map<String, String> RetrieveCredentials(){
        Map<String, String> credentials = new HashMap<String, String>();
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("/Users/ivansvalina/Documents/Faks/Završni/credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String email = (String)jsonObject.get("email");
            String password = (String)jsonObject.get("password");
            credentials.put("email", email);
            credentials.put("password", password);
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        return credentials;
    }
}
