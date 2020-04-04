package com.github.m0levich.pages;

import com.github.m0levich.blocks.NavigationMenu;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver webDriver;
    private final NavigationMenu navigationMenu;

    public BasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
        this.navigationMenu = new NavigationMenu(webDriver);
    }

    public NavigationMenu getNavigationMenu() {
        return navigationMenu;
    }
}
