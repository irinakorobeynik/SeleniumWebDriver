package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class BaseTest {

    public void openBrowser(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void quit(WebDriver driver) {
        driver.quit();
    }

    @DataProvider(name = "credentialsDataProvider")
    public static Object[][] credentialsDataProvider() {
        return new Object[][]{
                {CommonUtils.getPropertyValue("user.secondary.username"), CommonUtils.getPropertyValue("user.secondary.password")},
                {CommonUtils.getPropertyValue("user.primary.username"), CommonUtils.getPropertyValue("user.primary.password")}
        };
    }

    @DataProvider(name = "alertDataProvider")
    public static Object[][] alertDataProvider() {
        return new Object[][]{
                {"accept"},
                {"dismiss"}
        };
    }
}
