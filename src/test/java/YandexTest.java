import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.example.ByVariables.*;
import static org.example.UtilityClass.*;


public class YandexTest {

    private WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void openBrowser() {
        driver.get(MAIL_RU_URL);

    }

    @Test
    public void loginTest() {
        waitForElementDisplayed(LOGIN_BUTTON, driver,30);
        driver.findElement(LOGIN_BUTTON).click();
        waitForElementDisplayed(AUTH_POP_UP_LOCATOR, driver,5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(AUTH_POP_UP_LOCATOR).isDisplayed());
        driver.findElement(USERNAME_FIELD).sendKeys(LOGIN_INPUT2);
        driver.findElement(LOGIN_BUTTON_IN_POP_UP).click();
        waitForElementDisplayed(CURRENT_ACCOUNT, driver,5);
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD_INPUT2);
        driver.findElement(LOGIN_BUTTON_IN_POP_UP).click();
        waitForElementDisplayed(MAIL_APP_CONTENT, driver,5);
        softAssert.assertTrue(driver.findElement(MAIL_APP_CONTENT).isDisplayed(), "Folder is not displayed");
        softAssert.assertAll("Something goes wrong with login Test");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    }


