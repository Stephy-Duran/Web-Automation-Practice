package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CheckoutOverview extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CheckoutOverview.class);
    
    @FindBy(css = "[data-test='finish']")
    private WebElement finishBtn;
    
    @FindBy(className = "item_pricebar")
    private List<WebElement> cartItemsPrice;
    
    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;
    
    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }
    
    /**
     Verifies that the number of products and their total sum match the expected values.
     
     @param amountProducts The expected number of products in the cart.
     @return True if the number of products and the total amount on the bill are correct, false otherwise.
     @author Stephany Duran
     */
    public boolean isTotalAmountOfTheBillCorrect(int amountProducts) {
        double totalSum = 0;
        for(WebElement productPrice : cartItemsPrice) {
            String priceText = productPrice.getAttribute("innerText").replace("$", "");
            double price = Double.parseDouble(priceText);
            totalSum += price;
        }
        String totalText = itemTotal.getText().replace("Item total: $", "");
        double expectedTotal = Double.parseDouble(totalText);
        return cartItemsPrice.size() == amountProducts && totalSum == expectedTotal;
    }
    
    /**
     Clicks the finish button and generates an instance of CheckoutCompletePage.
     
     @return An instance of CheckoutCompletePage.
     @author Stephany Duran
     */
    public CheckoutCompletePage clickOnFinishBtn() {
        log.info("Click on finish button");
        customClickElement(finishBtn);
        return new CheckoutCompletePage(driver);
    }
}
