package com.github.m0levich.pages;

import com.github.m0levich.blocks.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        new WebDriverWait(webDriver,15).until(ExpectedConditions.titleContains("Старт"));
    }
}
