package com.globant.academy.tests;

import com.globant.academy.pages.*;
import com.globant.academy.dataManager.JsonDataReader;
import com.globant.academy.dataManager.UserShippingData;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;


public class PurchaseProductTest extends BaseTest {
    
    @Test(dataProvider = "userShippingData", dataProviderClass = UserShippingData.class)
    public void validatePurchaseProductsFlow(String name, String lastName, String postalCode) {
        int oneProduct = JsonDataReader.getOneProduct();
        String userName = JsonDataReader.getUserName();
        String password = JsonDataReader.getPassword();
        
        LoginPage loginPage = openLoginPage();
        loginPage.login(userName, password);
        HomePage homePage = loginPage.submitDataLogin();
        
        homePage.selectRandomProducts(oneProduct);
        Assert.assertTrue(homePage.validateQuantityShoppingCart(oneProduct), "The quantity does not match ");
        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();
        Assert.assertTrue(shoppingCartPage.areAllProductsSelectedPresent(oneProduct));
        
        CheckoutUserInformationPage checkoutUserInformationPage = shoppingCartPage.clickOnCheckoutBtn();
        checkoutUserInformationPage.fillOutUserInformation(name, lastName, postalCode);
        CheckoutOverview checkoutOverview = checkoutUserInformationPage.clickOnContinueBtn();
        Assert.assertTrue(checkoutOverview.isTotalAmountOfTheBillCorrect(oneProduct));
        
        CheckoutCompletePage checkoutCompletePage = checkoutOverview.clickOnFinishBtn();
        String actualMessage = checkoutCompletePage.getMessage();
        String expectedMessage = JsonDataReader.getThankYouMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Message does not match");
    }
}
