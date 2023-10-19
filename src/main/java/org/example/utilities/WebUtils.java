package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
    public static void waitForElementDisplayed(By element, WebDriver driver, int sec) {
        new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
