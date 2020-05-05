package com.github.m0levich.pages;

import com.github.m0levich.blocks.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final int TIME_OUT_IN_SECONDS = 30;
    protected final WebDriver webDriver;
    public final NavigationMenu navigationMenu;
    protected final WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.navigationMenu = new NavigationMenu(webDriver);
        this.webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        PageFactory.initElements(webDriver,this);
    }
}
