package com.globant.academy.tests.utils;

import com.globant.academy.utils.DriverSetup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.globant.academy.pages.LoginPage;

public class BaseTest {

    DriverSetup driver;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new DriverSetup(browser);
        driver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    public void navigateTo(String url) {
        driver.getDriver().get(url);
    }

    public LoginPage openLoginPage() {
        return new LoginPage(driver.getDriver());
    }

    //@AfterTest
    public void closeBrowser() {
        driver.getDriver().close();
    }
}
