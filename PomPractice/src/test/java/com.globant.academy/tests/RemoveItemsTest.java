package com.globant.academy.tests;

import com.globant.academy.pages.*;
import com.globant.academy.dataManager.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;


public class RemoveItemsTest extends BaseTest {
    
    @Test
    public void removeShoppingCartProducts() {
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
}

