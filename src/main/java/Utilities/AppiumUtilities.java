package Utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumUtilities {
    public AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumService(String ipAddres, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddres)
                .usingPort(port)
                .build();

        service.start();
        return service;
    }
}
