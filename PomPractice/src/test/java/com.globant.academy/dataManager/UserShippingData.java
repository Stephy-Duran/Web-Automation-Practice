package com.globant.academy.dataManager;

import org.testng.annotations.DataProvider;

public class UserShippingData {

    @DataProvider(name = "userShippingData")
    public Object[][] getUserShippingData() {
        return new Object[][]{
                {"Mariana", "Lopez", "12234"},
                {"Carlos", "Perez", "56723"},
                {"Laura", "Gomez", "11011"}
        };
    }
    
}
