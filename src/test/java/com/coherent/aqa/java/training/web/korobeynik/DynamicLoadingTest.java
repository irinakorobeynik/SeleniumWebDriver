package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.ByVariables.*;

public class DynamicLoadingTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void openBrowser() {
        driver.get(DL_URL);
    }

    @Test
    public void testLoading() {
        driver.findElement(By.id("save")).click();
        WebUtils.waitForElementToHaveTextAndChild(LOADING_ELEMENT, LOADING_ELEMENT_CHILD, driver, 5, DL_FIRST_NAME_LABEL);
        Assert.assertTrue(driver.findElement(LOADING_ELEMENT).getText().contains(DL_FIRST_NAME_LABEL));
        Assert.assertTrue(driver.findElement(LOADING_ELEMENT).getText().contains(DL_LAST_NAME_LABEL));
        Assert.assertTrue(driver.findElement(LOADING_ELEMENT).findElement(By.tagName("img")).isDisplayed());

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
