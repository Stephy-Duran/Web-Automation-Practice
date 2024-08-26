package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;

public class LoginPage extends BasePage {
    
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
