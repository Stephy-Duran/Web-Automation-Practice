package com.globant.academy.tests;

import com.globant.academy.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.globant.academy.tests.utils.BaseTest;

public class BuyProductsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BuyProductsTest.class);

    @Test
    @Parameters({"userName", "password"})
    public void validatePurchaseProductsFlow(String userName, String password) {
    

    }


}
