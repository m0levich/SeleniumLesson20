package com.github.m0levich.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class FinancialFreedom {
    private final WebDriver webDriver;
    private By financialFreedomBlock = By.xpath("//span[@class='amount-holder']/child::span");
    private By myAssets = By.xpath("//small[@class='my-assets'][1]");
    private String matcher = "[0-9]{0,3} [0-9]{0,3} [0-9]{1,3}[.]{1}[0-9]{1,2} [₽]{1}$";

    public FinancialFreedom(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getMatcher() {
        return matcher;
    }

    public String getFinancialFreedomValue() {
        return webDriver.findElement(financialFreedomBlock).getText();
    }

    public By getFinancialFreedomBlock() {
        return financialFreedomBlock;
    }

    public String getMyAssetsValue() {
        return webDriver.findElement(myAssets).getText();
    }

    public By getMyAssets() {
        return myAssets;
    }
}
