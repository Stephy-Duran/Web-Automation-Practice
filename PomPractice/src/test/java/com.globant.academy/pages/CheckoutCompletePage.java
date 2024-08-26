package com.globant.academy.pages;

import com.globant.academy.pages.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    
    @FindBy(css = "[data-test='complete-header']")
    private WebElement successMessage;
    
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    
    public String getMessage() {
        return successMessage.getAttribute("innerText");
    }
}
