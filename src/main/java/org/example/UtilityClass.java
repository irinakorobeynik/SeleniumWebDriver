package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class UtilityClass {
    public static void waitForElementDisplayed(By element, WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitIfElementDisplayed(WebDriver driver, By element) {
        if (driver.findElement(element).isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

    }

    public static String getPropertyValue(String property){
        String value = null;
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))){
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(property);
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Something wrong with getting values for testing: "+ e);
        }
        return value;

    }
}
