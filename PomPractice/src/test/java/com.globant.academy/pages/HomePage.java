package com.globant.academy.pages;

import com.globant.academy.pages.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HomePage extends BasePage {
    
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    @FindBy(css = ".inventory_item .btn_inventory")
    private List<WebElement> addToCartBtns;
    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement shoppingCartBtn;
    @FindBy(className = "bm-burger-button")
    private WebElement burgerMenu;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void selectRandomProduct(int quantityOfProductToAdd) {
        if(this.addToCartBtns.size() >= quantityOfProductToAdd) {
            Random random = new Random();
            Set<Integer> selectedProducts = new HashSet<>();
            while(quantityOfProductToAdd > 0) {
                int productIndex = random.nextInt(this.addToCartBtns.size());
                if(!selectedProducts.contains(productIndex)) {
                    this.addToCartBtns.get(productIndex).click();
                    selectedProducts.add(productIndex);
                    quantityOfProductToAdd--;
                }
            }
        }
        else {
            log.error("[Error]Index out of Bounds, the amounts of products is: {}", addToCartBtns.size());
        }
    }
    
    public boolean validateQuantityShoppingCart(int quantity) {
        return Integer.parseInt(this.shoppingCartBtn.getAttribute("textContent")) == quantity;
    }
    
    public ShoppingCartPage clickShoppingCartIcon() {
        this.shoppingCartBtn.click();
        return new ShoppingCartPage(super.driver);
    }
    
}
