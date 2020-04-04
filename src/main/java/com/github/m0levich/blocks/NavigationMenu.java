package com.github.m0levich.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenu {
    private final WebDriver webDriver;

    public NavigationMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectMenu(String menuName) {
        String selector = String.format("//a[.='%s']", menuName);
        webDriver.findElement(By.xpath(selector)).click();
    }
}
