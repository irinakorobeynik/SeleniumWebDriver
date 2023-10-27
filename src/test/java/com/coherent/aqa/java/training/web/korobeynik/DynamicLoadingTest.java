package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class DynamicLoadingTest extends BaseTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void init() {
        openBrowser(driver, DL_URL);
    }

    @Test
    public void testLoading() {
        driver.findElement(By.id("save")).click();
        WebUtils.waitForElementToHaveTextAndChild(LOADING_ELEMENT, LOADING_ELEMENT_CHILD, driver, 5, DL_FIRST_NAME_LABEL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(LOADING_ELEMENT).getText().contains(DL_FIRST_NAME_LABEL), "First name is not displayed");
        softAssert.assertTrue(driver.findElement(LOADING_ELEMENT).getText().contains(DL_LAST_NAME_LABEL), "Last name is not displayed");
        softAssert.assertTrue(driver.findElement(LOADING_ELEMENT).findElement(By.tagName("img")).isDisplayed(), "Image is not displayed");
        softAssert.assertAll("User is not loaded properly");
    }

    @AfterClass
    public void tearDown() {
        quit(driver);
    }

}
