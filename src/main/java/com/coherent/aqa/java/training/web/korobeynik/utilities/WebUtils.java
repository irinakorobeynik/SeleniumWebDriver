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
}
