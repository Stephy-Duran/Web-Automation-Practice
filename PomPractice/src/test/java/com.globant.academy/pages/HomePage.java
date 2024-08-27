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
    
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutOption;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    /**
     Selects a random set of products to add to the cart based on the specified quantity. Uses a HashSet to ensure
     that no duplicate indices are added to the cart. If the specified quantity exceeds the number of available
     products, an error is logged.
     
     @param quantityOfProductToAdd The number of products to randomly select and add to the cart.
     @author Stephany Duran
     */
    public void selectRandomProducts(int quantityOfProductToAdd) {
        if(addToCartBtns.size() >= quantityOfProductToAdd) {
            Random random = new Random();
            Set<Integer> selectedProducts = new HashSet<>();
            while(quantityOfProductToAdd > 0) {
                int productIndex = random.nextInt(addToCartBtns.size());
                if(!selectedProducts.contains(productIndex)) {
                    addToCartBtns.get(productIndex).click();
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
        return Integer.parseInt(shoppingCartBtn.getAttribute("textContent")) == quantity;
    }
    
    public ShoppingCartPage clickShoppingCartIcon() {
        shoppingCartBtn.click();
        return new ShoppingCartPage(driver);
    }
    
    public LoginPage logout() {
        customClickElement(burgerMenu);
        customClickElement(logoutOption);
        return new LoginPage(driver);
    }
}
