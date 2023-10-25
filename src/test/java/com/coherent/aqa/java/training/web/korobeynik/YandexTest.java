package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.ByVariables.*;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils.*;


public class YandexTest {

    private static final WebDriver driver = new ChromeDriver();;

    @BeforeClass
    public void openBrowser() {

        driver.get(MAIL_RU_URL);

    }

    @Test(dataProvider = "credentialsDataProvider", dataProviderClass = WebUtils.class)
    public void loginTest(String username, String password) throws InterruptedException {
        waitForElementDisplayed(LOGIN_BUTTON, driver, 30);
        driver.findElement(LOGIN_BUTTON).click();
        waitForElementDisplayed(AUTH_POP_UP_LOCATOR, driver, 5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(AUTH_POP_UP_LOCATOR).isDisplayed(), "Login Form is not displayed");
        try {
            WebElement currentAccount = driver.findElement(CURRENT_ACCOUNT);
            if (currentAccount.isDisplayed()) {
               currentAccount.click();
               waitForElementAndClick(ADD_ACCOUNT, driver, 5);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(LOGIN_BUTTON_IN_POP_UP).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // waitForElementDisplayed(CURRENT_ACCOUNT, driver, 5);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_IN_POP_UP).click();
        waitForElementDisplayed(MAIL_APP_CONTENT, driver, 15);
        softAssert.assertTrue(driver.findElement(MAIL_APP_CONTENT).isDisplayed(), "Inbox is not displayed");
        softAssert.assertAll("Something goes wrong with login Test");
        driver.findElement(USER_SETTINGS).click();
        Thread.sleep(1000); //implicit
        waitForElementDisplayed(EXIT, driver, 5);
        driver.findElement(EXIT).click();
    }


    @AfterClass
    public void quit() {
        driver.quit();
    }


}


