package com.globant.academy.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    private final WebDriver driver;

    public DriverSetup(String browser) {
        driver = browser.equalsIgnoreCase("firefox") ? new FirefoxDriver() : setUpChrome();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ChromeDriver setUpChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
