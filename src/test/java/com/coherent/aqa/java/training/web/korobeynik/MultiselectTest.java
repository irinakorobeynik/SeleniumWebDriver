package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static com.coherent.aqa.java.training.web.korobeynik.utilities.ByVariables.*;


public class MultiselectTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void openBrowser() {
        driver.get(MULTISELECT_URL);
    }

    @Test
    public void getMultipleSelects() {
        WebElement selectElement = driver.findElement(MULTISELECT);
        List<String> allOptions = selectElement.findElements(MULTISELECT_OPTIONS)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        List<String> selectedRandomOptions = CommonUtils.getRandomOptionsFrom(allOptions);
        Select select = new Select(selectElement);
        selectedRandomOptions.forEach(select::selectByVisibleText);
        driver.findElement(FIRST_SELECTED).click();
        Assert.assertTrue(driver.findElement(FIRST_SELECTED_TEXT).getText()
                .contains(selectedRandomOptions.get(selectedRandomOptions.size()-1)));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }


}
