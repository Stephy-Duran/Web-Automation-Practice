package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;

import java.util.List;

public class CheckoutOverview extends BasePage {

    @FindBy(css = "[data-test='finish']")
    private WebElement finishBtn;

    @FindBy(className = "item_pricebar")
    private List<WebElement> cartItemsPrice;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public boolean isTotalAmountOfTheBillCorrect(int amountProducts) {
        double totalSum = 0;

        for (WebElement productPrice : this.cartItemsPrice) {
            String priceText = productPrice.getAttribute("innerText").replace("$", "");
            double price = Double.parseDouble(priceText);
            totalSum += price;
        }

        String totalText = this.itemTotal.getText().replace("Item total: $", "");
        double expectedTotal = Double.parseDouble(totalText);

        return this.cartItemsPrice.size() == amountProducts && totalSum == expectedTotal;
    }

    public CheckoutCompletePage clickOnFinishBtn() {
        super.clickElement(finishBtn);
        return new CheckoutCompletePage(driver);
    }
}
