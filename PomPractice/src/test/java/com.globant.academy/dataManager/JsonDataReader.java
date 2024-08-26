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
    
    static ObjectMapper mapper = new ObjectMapper();
    
    
    /**
     * Retrieves the value associated with the key USER_NAME from the JSON file.
     *
     * @return The value of USER_NAME as a String.
     * @throws IOException If an input or output exception occurs during file reading.
     * @author Stephany Duran
     */
    public static String getUserName() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get(USER_NAME).asText();
    }
    
    public static String getPassword() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get(PASSWORD).asText();
    }
    
    public static String getThankYouMessage() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get(THANK_YOU_MESSAGE).asText();
    }
    
    public static int getQuantityOfProductToPurchase() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get(QUANTITY_OF_PRODUCTS_TO_PURCHASE).asInt();
    }
    
    public static int getOneProduct() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get(ONE_PRODUCT).asInt();
    }
}
