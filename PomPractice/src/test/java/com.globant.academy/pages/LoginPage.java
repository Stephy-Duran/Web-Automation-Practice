package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        super.sendKeys(this.userNameField, userName);
        super.sendKeys(this.passwordField, password);
    }

    public HomePage submitDataLogin() {
        super.clickElement(submitBtn);
        return new HomePage(driver);
    }
}
