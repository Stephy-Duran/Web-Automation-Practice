package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    
    
    @FindBy(id = "user-name")
    private WebElement userNameField;
    
    @FindBy(css = "#password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBtn;
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void login(String userName, String password) {
        log.info("Filling login fields");
        customSendKeys(userNameField, userName);
        customSendKeys(passwordField, password);
    }
    
    public HomePage submitDataLogin() {
        customClickElement(loginBtn);
        return new HomePage(driver);
    }
    
    public boolean verifyLogout() {
        return driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/") &&
               loginBtn.isDisplayed();
    }
}
