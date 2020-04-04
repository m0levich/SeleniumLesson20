package com.github.m0levich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;
    private By userNameField = By.xpath("//input[@name='username']");
    private By userPasswordField = By.xpath("//input[@name='password']");
    private By enterButton = By.id("login-button");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        new WebDriverWait(webDriver,15).until(ExpectedConditions.titleContains("Интернет банк - Банк Санкт-Петербург"));
    }

    public void login(String userName, String userPassword) {
        webDriver.findElement(userNameField).clear();
        webDriver.findElement(userNameField).sendKeys(userName);
        webDriver.findElement(userPasswordField).clear();
        webDriver.findElement(userPasswordField).sendKeys(userPassword);
        webDriver.findElement(enterButton).click();
    }
}
