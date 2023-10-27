package com.coherent.aqa.java.training.web.korobeynik.utilities;

import org.openqa.selenium.By;

public class Constants {
    public static final String MAIL_RU_URL = CommonUtils.getPropertyValue("yandex.url");
    public static final String MULTISELECT_URL = CommonUtils.getPropertyValue("multiselect.url");
    public static final String ALERT_URL = CommonUtils.getPropertyValue("alert.url");
    public static final String DL_URL = CommonUtils.getPropertyValue("dynamic.loading.url");
    public static final String BAR_URL = CommonUtils.getPropertyValue("progress.bar.url");
    public static final String TABLE_URL = CommonUtils.getPropertyValue("table.url");
    public static final String USERNAME = CommonUtils.getPropertyValue("user.primary.username");
    public static final String SELECTED_DROPDOWN_VALUE = "10";
    public static final int AGE = 20;
    public static final double SALARY = 120000.0;
    public static final String START_PERCENT = "0%";
    public static final String RELOAD_PERCENT = "50%";

    public static final String ALERT_TEXT_BOX = "I am an alert box!";
    public static final String CONFIRM_TEXT_BOX = "Press a button!";
    public static final String CONFIRM_POSITIVE_TEXT = "You pressed OK!";
    public static final String CONFIRM_NEGATIVE_TEXT = "You pressed Cancel!";
    public static final String PROMPT_TEXT_BOX = "Please enter your name";
    public static final String DL_FIRST_NAME_LABEL = "First Name :";
    public static final String DL_LAST_NAME_LABEL = "Last Name :";
    public static final By AUTH_POP_UP_LOCATOR = By.className("passp-auth-content");
    public static final By LOGIN_BUTTON = By.id("header-login-button");
    public static final By LOGIN_BUTTON_IN_POP_UP = By.cssSelector("button[type=submit]");
    public static final By CURRENT_ACCOUNT = By.cssSelector("a.CurrentAccount ");
    public static final By USERNAME_FIELD = By.name("login");
    public static final By PASSWORD_FIELD = By.xpath("//input[@class ='Textinput-Control']");
    public static final By INPUT = By.tagName("input");
    public static final By FOLDER_LINK = By.linkText("Папки");
    public static final By INBOX = By.partialLinkText("Входящие");
    public static final By CAPTCHA = By.xpath("//span[contains(text(),'Please confirm that you and not a robot are sending requests')]");
    public static final By MAIL_APP_CONTENT = By.cssSelector(".mail-App-Content");
    public static final By USER_SETTINGS = By.cssSelector(".user-account_left-name");
    public static final By EXIT = By.cssSelector(".legouser__menu-item_action_exit");
    public static final By LOGO = By.cssSelector(".LogoLink_1YTSO7lznsTdEa67eVBgF5");
    public static final By ADD_ACCOUNT = By.cssSelector(".AddAccountButton");
    public static final By MULTISELECT = By.id("multi-select");
    public static final By FIRST_SELECTED = By.id("printMe");
    public static final By FIRST_SELECTED_TEXT = By.className("getall-selected");
    public static final By MULTISELECT_OPTIONS = By.xpath(".//option");
    public static final By ALERT_BUTTON = By.cssSelector("button[onclick='myAlertFunction()']");
    public static final By CONFIRM_BUTTON = By.cssSelector("button[onclick='myConfirmFunction()']");
    public static final By PROMPT_BUTTON = By.cssSelector("button[onclick='myPromptFunction()']");
    public static final By CONFIRM_TEXT = By.id("confirm-demo");
    public static final By PROMPT_TEXT = By.id("prompt-demo");
    public static final By LOADING_ELEMENT = By.cssSelector("#loading");
    public static final By LOADING_ELEMENT_CHILD = By.cssSelector("#loading>*");
    public static final By DOWNLOAD_BUTTON = By.cssSelector("#cricle-btn");
    public static final By BAR_TEXT = By.cssSelector(".percenttext");
    public static final By TABLE_DROPDOWN = By.cssSelector("select[name='example_length']");
    public static final By TABLE_CELLS = By.cssSelector("tbody>*");
    public static final By TABLE_CELL_COLUMNS = By.xpath(".//td");
    public static final By PAGINATION_NEXT_PAGE = By.xpath("//a[@class='paginate_button current']/following::*[@class ='paginate_button ']");
    public static final By PAGINATION_PAGES = By.xpath("//*[@class='paginate_button ']");
    public static final By PAGINATION_TEXT = By.id("example_info");


}
