package com.coherent.aqa.java.training.web.korobeynik;


import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class ProgressBarTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void openBrowser() {
        driver.get(BAR_URL);
    }

    @Test
    public void testProgressBar() {
        driver.findElement(DOWNLOAD_BUTTON).click();
        WebUtils.waitForElementToHaveText(BAR_TEXT, driver, 15, RELOAD_PERCENT);
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(BAR_TEXT).getText(), START_PERCENT, "Page wasn't refreshed");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}

