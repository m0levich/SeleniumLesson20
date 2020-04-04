package com.github.m0levich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        new WebDriverWait(webDriver,15).until(ExpectedConditions.titleContains("Интернет банк - Банк Санкт-Петербург"));
        PageFactory.initElements(webDriver,this);
    }

    public TwoFactorAuthPage login(String userName, String userPassword) {
        userNameField.clear();
        userNameField.sendKeys(userName);
        userPasswordField.clear();
        userPasswordField.sendKeys(userPassword);
        enterButton.click();
        return new TwoFactorAuthPage(webDriver);
    }
}
