package com.coherent.aqa.java.training.web.korobeynik.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;


public class WebUtils {
    public static void waitForElementDisplayed(By element, WebDriver driver, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementAndClick(By element, WebDriver driver, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    @DataProvider(name = "credentialsDataProvider")
    public static Object[][] credentialsDataProvider() {
        return new Object[][]{
                {CommonUtils.getPropertyValue("user2"), CommonUtils.getPropertyValue("password2")},
                {CommonUtils.getPropertyValue("user"), CommonUtils.getPropertyValue("password")}

        };
    }
    @DataProvider(name = "alertDataProvider")
    public static Object[][] alertDataProvider() {
        return new Object[][]{
                {"accept"},
                {"dismiss"}
        };
    }



    public static void waitForAlertDisplayed(WebDriver driver, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.alertIsPresent());
    }

}
