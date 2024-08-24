package com.globant.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.academy.pages.utils.BasePage;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = ".cart_item")
    List<WebElement> productsLis;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/button[2]")
    WebElement checkoutBtn;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean areAllProductsSelectedPresent(int amountProductsSelected) {
        return productsLis.size() == amountProductsSelected;
    }

    public CheckoutUserInformationPage clickOnCheckoutBtn() {
        super.clickElement(checkoutBtn);
        return new CheckoutUserInformationPage(driver);
    }
}
