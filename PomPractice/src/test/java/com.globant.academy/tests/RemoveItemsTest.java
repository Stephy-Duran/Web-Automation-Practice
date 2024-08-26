package com.globant.academy.tests;

import com.globant.academy.pages.*;
import com.globant.academy.dataManager.JsonDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;

import java.io.IOException;

public class RemoveItemsTest extends BaseTest {
    
    private static final Logger log = LoggerFactory.getLogger(PurchaseProductTest.class);
    
    @Test
    public void removeShoppingCartProducts() {
        try {
            String userName = JsonDataReader.getUserName();
            String password = JsonDataReader.getPassword();
            int quantityOfProductsToPurchase = JsonDataReader.getQuantityOfProductToPurchase();
            
            LoginPage loginPage = openLoginPage();
            loginPage.login(userName, password);
            HomePage homePage = loginPage.submitDataLogin();
            homePage.selectRandomProducts(quantityOfProductsToPurchase);
            Assert.assertTrue(homePage.validateQuantityShoppingCart(quantityOfProductsToPurchase),
                              "The quantity does not match ");
            ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();
            shoppingCartPage.removeAllProductsFromShoppingCart();
            Assert.assertTrue(shoppingCartPage.wereAllProductsRemoved());
        }
        catch(IOException e) {
            log.error("Error in RemoveItemsTest, check if you put a correct key from JSON file, ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
