package com.globant.academy.dataManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    
    private static final String JSON_FILE_PATH = "src/test/resources/data/testData.json";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String THANK_YOU_MESSAGE = "thankYouMessage";
    private static final String QUANTITY_OF_PRODUCTS_TO_PURCHASE = "quantityOfProductToPurchase";
    private static final String ONE_PRODUCT = "oneProduct";
    private static final String ERROR_MESSAGE =
            "Error in the Log out process, check if you put a correct key " + "from JSON file, ";
    static ObjectMapper mapper = new ObjectMapper();
    
    /**
     Retrieves the value associated with the key USER_NAME from the JSON file.
     
     @return The value of USER_NAME as a String.
     @author Stephany Duran
     */
    public static String getUserName() {
        return getJsonValue(USER_NAME);
    }
    
    public static String getPassword() {
        return getJsonValue(PASSWORD);
    }
    
    public static String getThankYouMessage() {
        return getJsonValue(THANK_YOU_MESSAGE);
    }
    
    public static int getQuantityOfProductToPurchase() {
        return Integer.parseInt(getJsonValue(QUANTITY_OF_PRODUCTS_TO_PURCHASE));
    }
    
    public static int getOneProduct() {
        return Integer.parseInt(getJsonValue(ONE_PRODUCT));
    }
    
    public static String getJsonValue(String value) {
        try {
            return mapper.readTree(new File(JSON_FILE_PATH)).get(value).asText();
        }
        catch(IOException e) {
            return ERROR_MESSAGE;
        }
    }
}
