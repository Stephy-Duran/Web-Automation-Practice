package com.globant.academy.tests;

import com.globant.academy.pages.*;
import com.globant.academy.dataManager.JsonDataReader;
import com.globant.academy.dataManager.UserShippingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;

import java.io.IOException;

public class PurchaseProductTest extends BaseTest {
    
    private static final Logger log = LoggerFactory.getLogger(PurchaseProductTest.class);
    
    @Test(dataProvider = "userShippingData", dataProviderClass = UserShippingData.class)
    public void validatePurchaseProductsFlow(String name, String lastName, String postalCode) {
        try {
            
            int oneProduct = JsonDataReader.getOneProduct();
            String userName = JsonDataReader.getUserName();
            String password = JsonDataReader.getPassword();
            
            LoginPage loginPage = openLoginPage();
            loginPage.login(userName, password);
            HomePage homePage = loginPage.submitDataLogin();
            homePage.selectRandomProducts(oneProduct);
            Assert.assertTrue(homePage.validateQuantityShoppingCart(oneProduct),
                              "The quantity does not match ");
            
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
        catch(IOException e) {
            log.error("Error in purchaseProductTest, check if you put a correct key from JSON file, ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
