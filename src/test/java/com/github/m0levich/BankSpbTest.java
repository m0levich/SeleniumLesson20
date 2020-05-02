package com.github.m0levich;

import com.github.m0levich.pages.LoginPage;
import com.github.m0levich.pages.OverviewPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class BankSpbTest {
    private WebDriver webDriver;

    @BeforeClass
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void testSetup() {
        webDriver = new ChromeDriver();
        webDriver.get("https://idemo.bspb.ru");
    }

    @Test
    public void myAssetsTest() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(webDriver);
        ReadingFromFile readingFromFile = new ReadingFromFile();
        loginPage.checkLanguage();
        try {
            loginPage
                    .login(readingFromFile.getLogin(), readingFromFile.getPassword())
                    .twoFactorsAuth(readingFromFile.getSmsPin())
                    .getNavigationMenu()
                    .selectMenu("Обзор");
        } catch (FileNotFoundException e) {
            Assert.fail("Файл не найден в корне проекта", e);
        }
        OverviewPage overviewPage = new OverviewPage(webDriver);
        String financialFreedomValue = overviewPage.getFinancialFreedom().getFinancialFreedomValue();
        Assert.assertTrue(financialFreedomValue.matches(overviewPage.getFinancialFreedom().getMatcher()),"Financial Freedom check on the matcher failed");
        Actions act = new Actions(webDriver);
        act.moveToElement(overviewPage.getFinancialFreedom().getFinancialFreedomBlock()).perform();
        Assert.assertTrue(overviewPage.getFinancialFreedom().getMyAssets().isDisplayed(),"MyAssets block check for display failed");
        String myAssets = overviewPage.getFinancialFreedom().getMyAssetsValue();
        Assert.assertTrue(myAssets.matches("Моих средств " + overviewPage.getFinancialFreedom().getMatcher()),"MyAssets block check on the matcher failed");
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
