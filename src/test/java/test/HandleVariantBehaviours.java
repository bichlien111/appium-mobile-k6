package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import org.openqa.selenium.Capabilities;

public class HandleVariantBehaviours {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
        try {
            Capabilities caps = appiumDriver.getCapabilities();

            // Get platform name
            String platformName = CapabilityHelpers.getCapability(caps, "platformName", String.class);
            String udid = CapabilityHelpers.getCapability(caps, "udid", String.class);
            String packageName = CapabilityHelpers.getCapability(caps, "appPackage", String.class);

            System.out.println(platformName);
            System.out.println(udid);
            System.out.println(packageName);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            appiumDriver.quit();
        }
    }
}
