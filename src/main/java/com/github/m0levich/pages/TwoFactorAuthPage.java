package com.github.m0levich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwoFactorAuthPage {
    private final WebDriver webDriver;
    private By twoFactorsCodeFill = By.id("otp-code");
    private By enterButton = By.id("login-otp-button");

    public TwoFactorAuthPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void twoFactorsAuth(String code){
        webDriver.findElement(twoFactorsCodeFill).clear();
        webDriver.findElement(twoFactorsCodeFill).sendKeys(code);
        webDriver.findElement(enterButton).click();
    }
}
