package com.github.m0levich.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FinancialFreedom {
    private final WebDriver webDriver;

    @FindBy(xpath = "//span[@class='amount-holder']/child::span")
    private WebElement financialFreedomBlock;

    @FindBy(xpath = "//small[@class='my-assets'][1]")
    private WebElement myAssets;

    private String matcher = "[0-9]{0,3} [0-9]{0,3} [0-9]{1,3}[.]{1}[0-9]{1,2} [₽]{1}$";

    public FinancialFreedom(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public String getMatcher() {
        return matcher;
    }

    public String getFinancialFreedomValue() {
        return financialFreedomBlock.getText();
    }

    public WebElement getFinancialFreedomBlock() {
        return financialFreedomBlock;
    }

    public String getMyAssetsValue() {
        return myAssets.getText();
    }

    public WebElement getMyAssets() {
        return myAssets;
    }
}
