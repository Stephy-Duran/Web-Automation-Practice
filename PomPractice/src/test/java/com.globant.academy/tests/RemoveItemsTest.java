package com.globant.academy.tests;

import com.globant.academy.pages.*;
import com.globant.academy.dataManager.JsonDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;

public class RemoveItemsTest extends BaseTest {
    
    private static final Logger log = LoggerFactory.getLogger(BuyProductsTest.class);
    
    @Test
    public void removeShoppingCartProducts() {
        try {
            String userName = JsonDataReader.getUserName();
            String password = JsonDataReader.getPassword();
            int quantityOfProductsToPurchase = JsonDataReader.getQuantityOfProductToPurchase();
            LoginPage loginPage = super.openLoginPage();
            loginPage.login(userName, password);
            HomePage homePage = loginPage.submitDataLogin();
            homePage.selectRandomProduct(quantityOfProductsToPurchase);
            Assert.assertTrue(homePage.validateQuantityShoppingCart(quantityOfProductsToPurchase),
                              "The quantity does not match ");
            ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();
            shoppingCartPage.removeAllProductsFromShoppingCart();
            Assert.assertTrue(shoppingCartPage.wereAllProductsRemoved());
        }
        catch(Exception e) {
            log.error("Error in RemoveItemsTest, check if you put a correct key from JSON file, ", e);
        }
    }
    
    }
