package com.globant.academy.pages;

import com.globant.academy.pages.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutUserInformationPage extends BasePage {
    
    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameTestTxt;
    @FindBy(id = "last-name")
    private WebElement lastNameTxt;
    @FindBy(name = "postalCode")
    private WebElement zipOrPostalCodeTxt;
    @FindBy(name = "continue")
    private WebElement continueBtn;
    
    public CheckoutUserInformationPage(WebDriver driver) {
        super(driver);
    }
    
    public void fillOutUserInformation(String name, String lastName, String postalCode) {
        super.sendKeys(this.firstNameTestTxt, name);
        super.sendKeys(this.lastNameTxt, lastName);
        super.sendKeys(this.zipOrPostalCodeTxt, postalCode);
        waitSomeSeconds(5);
    }
    
    public CheckoutOverview clickOnContinueBtn() {
        super.clickElement(this.continueBtn);
        return new CheckoutOverview(super.driver);
    }
}
