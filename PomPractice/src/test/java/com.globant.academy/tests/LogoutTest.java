package com.globant.academy.tests;

import com.globant.academy.dataManager.JsonDataReader;
import com.globant.academy.pages.HomePage;
import com.globant.academy.pages.LoginPage;
import com.globant.academy.tests.utils.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends BaseTest {
    
    private static final Logger log = LoggerFactory.getLogger(PurchaseProductTest.class);
    
    @Test
    public void validateSuccessfulLogout() {
        try {
            LoginPage loginPage = openLoginPage();
            loginPage.login(JsonDataReader.getUserName(), JsonDataReader.getPassword());
            HomePage homePage = loginPage.submitDataLogin();
            loginPage = homePage.logout();
            Assert.assertTrue(loginPage.verifyLogout());
        }
        catch(IOException e) {
            log.error("Error in the Log out process, check if you put a correct key from JSON file, ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
