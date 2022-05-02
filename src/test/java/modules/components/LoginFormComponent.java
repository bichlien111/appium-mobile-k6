package modules.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> driver;
    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTxtSel =
            MobileBy.xpath("//*[contains(@text, 'Please enter a valid email address')]");

    private final static By passSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordTxtSel =
            MobileBy.xpath("//*[contains(@text, 'Please enter at least 8 characters')]");

    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By correctLoginSel = MobileBy.id("android:id/alertTitle");

    public LoginFormComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement emailEle() {
        return driver.findElement(emailSel);
    }

    public MobileElement passEle() {
        return driver.findElement(passSel);
    }

    public MobileElement loginEle() {
        return driver.findElement(loginBtnSel);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailEle().sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passEle().sendKeys(password);
        }
    }

    public String getInvalidEmail() {
        return driver.findElement(incorrectEmailTxtSel).getText().trim();
    }

    public String getInvalidPassword() {
        return driver.findElement(incorrectPasswordTxtSel).getText().trim();
    }

    public String getCorrectLogin() {
        return driver.findElement(correctLoginSel).getText().trim();
    }

    public void clickLoginBtn() {
        loginEle().click();
    }
}

