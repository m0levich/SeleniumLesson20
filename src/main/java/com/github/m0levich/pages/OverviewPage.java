package com.github.m0levich.pages;

import com.github.m0levich.blocks.FinancialFreedom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage extends BasePage {
    private final FinancialFreedom financialFreedom;

    public OverviewPage(WebDriver webDriver) {
        super(webDriver);
        new WebDriverWait(webDriver,15).until(ExpectedConditions.titleContains("Обзор"));
        this.financialFreedom = new FinancialFreedom(webDriver);
    }

    public FinancialFreedom getFinancialFreedom() {
        return financialFreedom;
    }
}
