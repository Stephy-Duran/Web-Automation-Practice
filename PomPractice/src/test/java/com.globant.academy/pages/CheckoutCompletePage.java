package com.globant.academy.pages;

import com.globant.academy.pages.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutCompletePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CheckoutCompletePage.class);
    
    @FindBy(css = "[data-test='complete-header']")
    private WebElement successMessage;
    
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    
    public String getMessage() {
        log.info("Getting successfully message");
        return successMessage.getAttribute("innerText");
    }
}
