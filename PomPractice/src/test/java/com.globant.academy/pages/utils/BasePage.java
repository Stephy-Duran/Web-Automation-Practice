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
    
    /**
     Constructor for the BasePage class. This method initializes the WebElements and creates a wait object.
     
     @param driver WebDriver instance used to interact with the browser.
     @author Stephany Duran
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Iniciar los elementos de la pagina tan pronto la construyo
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void customClickElement(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }
    
    public void customSendKeys(WebElement element, String text) {
        waitElementVisibility(element);
        element.sendKeys(text);
    }
    
    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
