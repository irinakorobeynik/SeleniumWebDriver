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

import static com.coherent.aqa.java.training.web.korobeynik.utilities.ByVariables.*;

public class AlertTests {
    private static final WebDriver driver = new ChromeDriver();
    private static Alert alert;

    @BeforeClass
    public void openBrowser() {
        driver.get(ALERT_URL);
    }

    @Test
    public void testAlertBox() {
        driver.findElement(ALERT_BUTTON).click();
        WebUtils.waitForAlertDisplayed(driver, 2);
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), ALERT_TEXT_BOX, "Alert message doesn't match");
        alert.accept();

    }

    @Test(dataProvider = "alertDataProvider", dataProviderClass = WebUtils.class)
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

    }

    @Test
    public void testPromptBox() {
        driver.findElement(PROMPT_BUTTON).click();
        WebUtils.waitForAlertDisplayed(driver, 2);
        alert = driver.switchTo().alert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alert.getText(), "Please enter your name", "Alert message doesn't match");
        alert.sendKeys(USERNAME);
        alert.accept();
        softAssert.assertTrue(driver.findElement(PROMPT_TEXT).getText().contains(USERNAME), "Confirm Text doesn't match");

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
