package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class AlertTests extends BaseTest {
    private static final WebDriver driver = new ChromeDriver();
    private static Alert alert;

    @BeforeClass
    public void init() {
        openBrowser(driver, ALERT_URL);
    }

    @Test
    public void testAlertBox() {
        driver.findElement(ALERT_BUTTON).click();
        WebUtils.waitForAlertDisplayed(driver, 2);
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), ALERT_TEXT_BOX, "Alert message doesn't match");
        alert.accept();

    }

    @Test(dataProvider = "alertDataProvider", dataProviderClass = BaseTest.class)
    public void testConfirmBox(String alertAction) {
        driver.findElement(CONFIRM_BUTTON).click();
        WebUtils.waitForAlertDisplayed(driver, 2);
        alert = driver.switchTo().alert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alert.getText(), CONFIRM_TEXT_BOX, "Alert message doesn't match");
        switch (alertAction) {
            case "accept":
                alert.accept();
                softAssert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), CONFIRM_POSITIVE_TEXT, "Confirm Text doesn't match");
                break;
            case "dismiss":
                alert.dismiss();
                softAssert.assertEquals(driver.findElement(CONFIRM_TEXT).getText(), CONFIRM_NEGATIVE_TEXT, "Confirm Text doesn't match");
                break;
        }
        softAssert.assertAll("Something went wrong with Confirm test");

    }

    @Test
    public void testPromptBox() {
        driver.findElement(PROMPT_BUTTON).click();
        WebUtils.waitForAlertDisplayed(driver, 2);
        alert = driver.switchTo().alert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alert.getText(), PROMPT_TEXT_BOX, "Prompt message doesn't match");
        alert.sendKeys(USERNAME);
        alert.accept();
        softAssert.assertTrue(driver.findElement(PROMPT_TEXT).getText().contains(USERNAME), "Confirm Text doesn't match");
        softAssert.assertAll("Something went wrong with prompt text");

    }

    @AfterClass
    public void tearDown() {
        quit(driver);
    }

}
