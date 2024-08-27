package com.globant.academy.tests;

import com.globant.academy.dataManager.JsonDataReader;
import com.globant.academy.pages.HomePage;
import com.globant.academy.pages.LoginPage;
import com.globant.academy.tests.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    
    @Test
    public void validateSuccessfulLogout() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(JsonDataReader.getUserName(), JsonDataReader.getPassword());
        HomePage homePage = loginPage.submitDataLogin();
        loginPage = homePage.logout();
        Assert.assertTrue(loginPage.verifyLogout());
    }
}
