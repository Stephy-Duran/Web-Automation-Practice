package com.globant.academy.pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Iniciar los elementos de la pagina tan pronto la construyo
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElement(WebElement element) {
        waitElementVisibility(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitElementVisibility(element);
        element.sendKeys(text);
    }

    public void waitToBeclickeable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitSomeSeconds(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
