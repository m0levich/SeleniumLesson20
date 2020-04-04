package com.github.m0levich.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwoFactorAuthPage {
    private final WebDriver webDriver;

    @FindBy(id = "otp-code")
    private WebElement twoFactorsCodeFill;

    @FindBy(id = "login-otp-button")
    private WebElement enterButton;

    public TwoFactorAuthPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public MainPage twoFactorsAuth(String code){
        twoFactorsCodeFill.clear();
        twoFactorsCodeFill.sendKeys(code);
        enterButton.click();
        return new MainPage(webDriver);
    }
}
