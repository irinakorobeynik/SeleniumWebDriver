package com.coherent.aqa.java.training.web.korobeynik.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void waitForElementToHaveTextAndChild(By element, By childElement, WebDriver driver, int sec, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.and(
                ExpectedConditions.textToBePresentInElement(driver.findElement(element), text),
                ExpectedConditions.visibilityOfElementLocated(childElement)
        ));
    }

    public static void waitForElementToHaveText(By element, WebDriver driver, int sec, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).pollingEvery(Duration.ofMillis(50))
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(element), text));
    }


    public static void waitForAlertDisplayed(WebDriver driver, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.alertIsPresent());
    }


}
