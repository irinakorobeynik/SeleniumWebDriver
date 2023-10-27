package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;
import com.coherent.aqa.java.training.web.korobeynik.utilities.Employee;
import com.coherent.aqa.java.training.web.korobeynik.utilities.WebUtils;
import lombok.extern.log4j.Log4j2;
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

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;
import static java.lang.Integer.parseInt;

@Log4j2
public class TableSortTest extends BaseTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void init() {
        openBrowser(driver, TABLE_URL);
    }

    @Test
    public void tableTest() {
        List<Employee> allEmployeeList = new ArrayList<>();
        Select select = new Select(driver.findElement(TABLE_DROPDOWN));
        select.selectByValue(SELECTED_DROPDOWN_VALUE);
        Assert.assertTrue(driver.findElement(PAGINATION_TEXT).getText().contains(SELECTED_DROPDOWN_VALUE),
                "Message doesn't correspond selected value");
        List<WebElement> paginationPages = driver.findElements(PAGINATION_PAGES);
        paginationPages.stream()
                .map(paginationButton -> driver.findElements(TABLE_CELLS))
                .forEach(cellList -> {
                    cellList.stream()
                            .map(cell -> cell.findElements(TABLE_CELL_COLUMNS))
                            .forEach(cellColumns -> {
                                Employee employee = new Employee(cellColumns.get(0).getText(), cellColumns.get(1).getText(),
                                        cellColumns.get(2).getText(), parseInt(cellColumns.get(3).getText()),
                                        parseInt(cellColumns.get(5).getText().replaceAll("[^0-9]", "")));
                                allEmployeeList.add(employee);
                            });
                    WebUtils.waitForElementAndClick(PAGINATION_NEXT_PAGE, driver, 3);
                });
        CommonUtils.getFilteredEmployeeList(AGE, SALARY, allEmployeeList).forEach(log::info);
    }

    @AfterClass
    public void tearDown() {
        quit(driver);
    }

}
