package com.coherent.aqa.java.training.web.korobeynik.utilities;

import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;
import org.openqa.selenium.By;

public class ByVariables {
    public static final String MAIL_RU_URL = CommonUtils.getPropertyValue("url");
    public static final String LOGIN_INPUT2 = CommonUtils.getPropertyValue("user");
    public static final String PASSWORD_INPUT2 = CommonUtils.getPropertyValue("password");
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
}
